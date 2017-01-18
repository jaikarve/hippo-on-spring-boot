package com.jpmc.bulkactions;

import com.onehippo.cms7.search.frontend.ISearchContext;
import org.apache.wicket.model.Model;
import org.hippoecm.addon.workflow.WorkflowDescriptorModel;
import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.hippoecm.frontend.service.render.RenderPlugin;
import org.hippoecm.addon.workflow.*;

/**
 * Created by jaikarve on 1/17/17.
 */
public class CollectionTaggingWorkflowPlugin extends RenderPlugin {

    public CollectionTaggingWorkflowPlugin(final IPluginContext context,
                                           final IPluginConfig config) {
        super(context, config);

        WorkflowDescriptorModel model = (WorkflowDescriptorModel) getModel();
        final ISearchContext searcher = context.getService(
                ISearchContext.class.getName(), ISearchContext.class);

        add(new StdWorkflow<CollectionTaggingWorkflow>
                ("addTag", Model.of("Add Tag"), context, model) {

            @Override
            protected String execute(CollectionTaggingWorkflow workflow)
                    throws Exception {

                if (searcher != null) {
                    searcher.saveCollection();
                }
                workflow.addTag("tag");

                return null;
            }
        });
    }
}
