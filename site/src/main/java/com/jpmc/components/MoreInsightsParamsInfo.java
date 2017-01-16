package com.jpmc.components;

import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;

/**
 * Created by jaikarve on 1/16/17.
 */
@FieldGroupList({
        @FieldGroup(
                titleKey = "collection",
                value = { "moreDocument", "title"}
        )
})
public interface MoreInsightsParamsInfo {
    String MORE_DOCUMENT = "moreDocument";
    String TITLE = "title";

    @Parameter(name = MORE_DOCUMENT, required = true)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MoreLikeThisMaster"}, pickerConfiguration = "cms-pickers/documents-only")
    String getMoreDocument();

    @Parameter(name = TITLE)
    String getTitle();
}
