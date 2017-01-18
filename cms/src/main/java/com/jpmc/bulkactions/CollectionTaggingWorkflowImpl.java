package com.jpmc.bulkactions;

import com.onehippo.cms7.search.state.Collection;
import com.onehippo.cms7.search.state.CollectionState;
import com.onehippo.cms7.search.state.Failure;
import com.onehippo.cms7.search.state.Report;
import com.onehippo.cms7.search.workflow.ReportWorkflow;
import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.Workflow;
import org.hippoecm.repository.api.WorkflowContext;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.InternalWorkflow;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.onehippo.repository.documentworkflow.DocumentWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Map;

import static com.onehippo.cms7.search.workflow.CollectionWorkflowReasons.DOCUMENT_NOT_FOUND;
import static com.onehippo.cms7.search.workflow.CollectionWorkflowReasons.INVALID_WORKFLOW;
import static com.onehippo.cms7.search.workflow.CollectionWorkflowReasons.WORKFLOW_FAILED;

/**
 * Created by jaikarve on 1/17/17.
 */
public class CollectionTaggingWorkflowImpl extends WorkflowImpl implements CollectionTaggingWorkflow, InternalWorkflow{

    static final Logger log = LoggerFactory.getLogger(CollectionTaggingWorkflowImpl.class);

    private final Session session;
    private final Node subject;
    private final CollectionState state;

    public CollectionTaggingWorkflowImpl(
            Session userSession, Session rootSession, Node subject)
            throws RemoteException, RepositoryException {

        this.session = rootSession;
        this.subject =
                rootSession.getNodeByIdentifier(subject.getIdentifier());
        this.state = new CollectionState(this.subject);
    }

    @Override
    public void addTag(final String tag)
            throws WorkflowException, RepositoryException, RemoteException {

        final WorkflowContext context = getWorkflowContext();

        ReportWorkflow reportWorkflow =
                (ReportWorkflow) context.getWorkflow("collection-reports");
        if (state.isReady()) {
            if (state.getReport().hasFailures()) {
                throw new WorkflowException(
                        "Cannot start workflow when existing failures have not been acknowledged");
            }
            reportWorkflow.cleanupReport();
        }

        reportWorkflow.createReport("addTag");
        Report report = state.getReport();
        Collection collection = state.getCollection();

        int succeeded = 0;
        int executed = 0;
        try {
            for (String handleId : collection.getDocumentIdentifiers()) {
                executed++;
                try {
                    Node handle = session.getNodeByIdentifier(handleId);
                    Workflow workflow =
                            context.getWorkflow("default", new Document(handle));
                    if (workflow instanceof DocumentWorkflow) {
                        DocumentWorkflow documentWorkflow = (DocumentWorkflow) workflow;
                        if (addtagToDocument(documentWorkflow, tag, handle.getPath())) {
                            succeeded++;
                        } else {
                            report.addFailure(new Failure(handle, WORKFLOW_FAILED));
                        }
                    } else {
                        report.addFailure(new Failure(handle, INVALID_WORKFLOW));
                    }
                } catch (ItemNotFoundException e) {
                    report.addFailure(new Failure(null, DOCUMENT_NOT_FOUND));
                } finally {
                    report.setNumberOfProcessedDocuments(executed);
                    session.save();
                    session.refresh(false);
                }
            }
        } finally {
            reportWorkflow.finishReport(succeeded);
            session.save();
            session.refresh(false);
        }
    }

    private boolean addtagToDocument(
            DocumentWorkflow workflow, String tag, String handlePath)
            throws RepositoryException, WorkflowException, RemoteException {
        try {
            final Document document = workflow.obtainEditableInstance();
            final Node editableNode = document.getNode(session);

            Value[] values;
            if (editableNode.hasProperty("hippoonspringboot:tags")) {
                values = editableNode.getProperty("hippoonspringboot:tags").getValues();
            } else {
                values = new Value[0];
            }

            Value[] newValues = new Value[values.length + 1];
            System.arraycopy(values, 0, newValues, 0, values.length);
            newValues[values.length] = session.getValueFactory().createValue(tag);

            editableNode.setProperty("hippoonspringboot:tags", newValues);
            session.save();

            workflow.commitEditableInstance();
            return true;
        } catch (Exception e) {
            log.error("Failed to execute workflow on document at {}",
                    handlePath, e);
            return false;
        }
    }

    @Override
    public Map<String, Serializable> hints() throws WorkflowException {
        Map<String, Serializable> hints = super.hints();
        hints.put("addTags", canStart());
        return hints;
    }

    private boolean canStart() {
        if (state.getWorkflowPhase() == CollectionState.Phase.INITIALIZED) {
            return true;
        }
        if (state.getWorkflowPhase() == CollectionState.Phase.COMPLETE) {
            Report report = state.getReport();
            return !report.hasFailures();
        }
        return false;
    }
}
