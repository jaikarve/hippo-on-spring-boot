package com.jpmc.components;

import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;

/**
 * Created by jaikarve on 1/15/17.
 */
@FieldGroupList({
        @FieldGroup(
                titleKey = "collection",
                value = { "document1", "document2", "document3", "document4", "document5", "document6" }
        )
})
public interface FeaturedInsightParamsInfo extends BaseCollectionParamsInfo {
    String INSIGHT_1 = "document1";
    String INSIGHT_2 = "document2";
    String INSIGHT_3 = "document3";
    String INSIGHT_4 = "document4";
    String INSIGHT_5 = "document5";
    String INSIGHT_6 = "document6";

    @Parameter(name = INSIGHT_1, required = true)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MarketInsight"}, pickerConfiguration = "cms-pickers/documents-only")
    String getInsight1();

    @Parameter(name = INSIGHT_2, required = true)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MarketInsight"}, pickerConfiguration = "cms-pickers/documents-only")
    String getInsight2();

    @Parameter(name = INSIGHT_3, required = true)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MarketInsight"}, pickerConfiguration = "cms-pickers/documents-only")
    String getInsight3();

    @Parameter(name = INSIGHT_4)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MarketInsight"}, pickerConfiguration = "cms-pickers/documents-only")
    String getInsight4();

    @Parameter(name = INSIGHT_5)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MarketInsight"}, pickerConfiguration = "cms-pickers/documents-only")
    String getInsight5();

    @Parameter(name = INSIGHT_6)
    @JcrPath(isRelative = true, pickerSelectableNodeTypes = {"hippoonspringboot:MarketInsight"}, pickerConfiguration = "cms-pickers/documents-only")
    String getInsight6();

}
