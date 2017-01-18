package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import com.github.woonsanko.examples.hippoboot.beans.Imageset;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:bannerdocument")
@Node(jcrType = "hippoonspringboot:bannerdocument")
public class Banner extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:title")
    public String getTitle() {
        return getProperty("hippoonspringboot:title");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:content")
    public HippoHtml getContent() {
        return getHippoHtml("hippoonspringboot:content");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:link")
    public HippoBean getLink() {
        return getLinkedBean("hippoonspringboot:link", HippoBean.class);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:image")
    public Imageset getImage() {
        return getLinkedBean("hippoonspringboot:image", Imageset.class);
    }

    @HippoEssentialsGenerated(internalName = "hippostd:tags")
    public String[] getTags() {
        return getProperty("hippostd:tags");
    }
}
