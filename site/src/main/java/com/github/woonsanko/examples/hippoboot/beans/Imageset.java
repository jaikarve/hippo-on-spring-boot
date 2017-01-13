package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageBean;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:imageset")
@Node(jcrType = "hippoonspringboot:imageset")
public class Imageset extends HippoGalleryImageSet {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:small")
    public HippoGalleryImageBean getSmall() {
        return getBean("hippoonspringboot:small", HippoGalleryImageBean.class);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:large")
    public HippoGalleryImageBean getLarge() {
        return getBean("hippoonspringboot:large", HippoGalleryImageBean.class);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:smallsquare")
    public HippoGalleryImageBean getSmallsquare() {
        return getBean("hippoonspringboot:smallsquare",
                HippoGalleryImageBean.class);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:mediumsquare")
    public HippoGalleryImageBean getMediumsquare() {
        return getBean("hippoonspringboot:mediumsquare",
                HippoGalleryImageBean.class);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:largesquare")
    public HippoGalleryImageBean getLargesquare() {
        return getBean("hippoonspringboot:largesquare",
                HippoGalleryImageBean.class);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:banner")
    public HippoGalleryImageBean getBanner() {
        return getBean("hippoonspringboot:banner", HippoGalleryImageBean.class);
    }
}
