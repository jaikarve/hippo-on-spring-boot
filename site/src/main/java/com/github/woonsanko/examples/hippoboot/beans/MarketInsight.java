package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:MarketInsight")
@Node(jcrType = "hippoonspringboot:MarketInsight")
public class MarketInsight extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:title")
    public String getTitle() {
        return getProperty("hippoonspringboot:title");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:overview")
    public String getOverview() {
        return getProperty("hippoonspringboot:overview");
    }
}
