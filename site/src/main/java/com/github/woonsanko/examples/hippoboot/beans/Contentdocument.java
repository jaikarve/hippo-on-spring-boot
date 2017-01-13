package com.github.woonsanko.examples.hippoboot.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import java.util.Calendar;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:contentdocument")
@Node(jcrType = "hippoonspringboot:contentdocument")
public class Contentdocument extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:title")
    public String getTitle() {
        return getProperty("hippoonspringboot:title");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:introduction")
    public String getIntroduction() {
        return getProperty("hippoonspringboot:introduction");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:publicationdate")
    public Calendar getPublicationdate() {
        return getProperty("hippoonspringboot:publicationdate");
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:content")
    public HippoHtml getContent() {
        return getHippoHtml("hippoonspringboot:content");
    }
}
