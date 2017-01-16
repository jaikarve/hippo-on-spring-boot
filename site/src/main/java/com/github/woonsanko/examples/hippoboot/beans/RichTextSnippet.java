package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:RichTextSnippet")
@Node(jcrType = "hippoonspringboot:RichTextSnippet")
public class RichTextSnippet extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:richText")
    public HippoHtml getRichText() {
        return getHippoHtml("hippoonspringboot:richText");
    }
}
