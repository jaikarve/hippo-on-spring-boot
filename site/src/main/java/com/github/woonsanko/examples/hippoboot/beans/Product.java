package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import java.util.List;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import com.github.woonsanko.examples.hippoboot.beans.Imageset;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:product")
@Node(jcrType = "hippoonspringboot:product")
public class Product extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:title")
    public String getTitle() {
        return getProperty("hippoonspringboot:title");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:price")
    public Double getPrice() {
        return getProperty("hippoonspringboot:price");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:introduction")
    public String getIntroduction() {
        return getProperty("hippoonspringboot:introduction");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:description")
    public HippoHtml getDescription() {
        return getHippoHtml("hippoonspringboot:description");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:images")
    public List<Imageset> getImages() {
        return getLinkedBeans("hippoonspringboot:images", Imageset.class);
    }
}
