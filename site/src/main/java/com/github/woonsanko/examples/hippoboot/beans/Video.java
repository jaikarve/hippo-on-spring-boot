package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:Video")
@Node(jcrType = "hippoonspringboot:Video")
public class Video extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:title")
    public String getTitle() {
        return getProperty("hippoonspringboot:title");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:description")
    public String getDescription() {
        return getProperty("hippoonspringboot:description");
    }

    public String getVideoLink() {
        return getProperty("hippoonspringboot:videoLink");
    }
}
