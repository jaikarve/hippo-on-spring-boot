package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import java.util.List;
import com.github.woonsanko.examples.hippoboot.beans.MoreLikeThisCompound;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:MoreLikeThisMaster")
@Node(jcrType = "hippoonspringboot:MoreLikeThisMaster")
public class MoreLikeThisMaster extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:moreLikeThis")
    public List<MoreLikeThisCompound> getMoreLikeThis() {
        return getChildBeansByName("hippoonspringboot:moreLikeThis",
                MoreLikeThisCompound.class);
    }
}
