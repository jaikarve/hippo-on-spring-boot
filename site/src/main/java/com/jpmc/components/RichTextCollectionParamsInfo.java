package com.jpmc.components;

import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;

/**
 * Created by jaikarve on 7/26/16.
 */

@FieldGroupList({
        @FieldGroup(
                titleKey = "collection",
                value = { "scope" }
        )
})
public interface RichTextCollectionParamsInfo extends BaseCollectionParamsInfo {

    String PARAM_SCOPE = "scope";

    @Parameter(name = PARAM_SCOPE, required = true, defaultValue = "")
    @JcrPath(isRelative = true, pickerInitialPath = "", pickerSelectableNodeTypes = {"hippostd:folder"}, pickerConfiguration = "cms-pickers/folders")
    String getScope();

}
