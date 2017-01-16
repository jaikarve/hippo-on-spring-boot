package com.jpmc.components;

import org.hippoecm.hst.core.parameters.*;

/**
 * Created by jaikarve on 1/15/17.
 */

@FieldGroupList({
        @FieldGroup(
                titleKey = "header",
                value = { "title", "titleTextColor", "separatorMargin", "backgroundImage"}
        )
})
public interface BaseCollectionParamsInfo {
    final static String PARAM_TITLE = "title";
    final static String PARAM_SEPARATORMARGIN = "separatorMargin";
    final static String BACKGROUND_IMAGE = "backgroundImage";
    final static String TITLE_TEXT_COLOR = "titleTextColor";

    @Parameter(name = TITLE_TEXT_COLOR)
    @Color
    String getTitleTextColor();

    @Parameter(name = PARAM_TITLE)
    String getTitle();

    @Parameter(name = PARAM_SEPARATORMARGIN, required = true, defaultValue = "20")
    @DropDownList(value= {"0", "20", "30", "40", "50", "60", "70", "80", "90", "100"})
    String getSeparatorMargin();

    @Parameter(name = BACKGROUND_IMAGE)
    @JcrPath(isRelative = true, pickerConfiguration = "cms-pickers/images")
    String getBackgroundImage();
}
