package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import com.github.woonsanko.examples.hippoboot.beans.Imageset;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:MoreLikeThisCompound")
@Node(jcrType = "hippoonspringboot:MoreLikeThisCompound")
public class MoreLikeThisCompound extends HippoDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:caption")
    public String getCaption() {
        return getProperty("hippoonspringboot:caption");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:image")
    public Imageset getImage() {
        return getLinkedBean("hippoonspringboot:image", Imageset.class);
    }
}
