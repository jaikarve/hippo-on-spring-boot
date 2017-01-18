package com.jpmc.bulkactions;

import org.hippoecm.repository.api.Workflow;
import org.hippoecm.repository.api.WorkflowException;

import javax.jcr.RepositoryException;
import java.rmi.RemoteException;

/**
 * Created by jaikarve on 1/17/17.
 */
public interface CollectionTaggingWorkflow extends Workflow {

    void addTag(String tag) throws WorkflowException, RepositoryException, RemoteException;
}
