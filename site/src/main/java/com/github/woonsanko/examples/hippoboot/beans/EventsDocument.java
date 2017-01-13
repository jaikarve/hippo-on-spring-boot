package com.github.woonsanko.examples.hippoboot.beans;

import java.util.Calendar;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import com.github.woonsanko.examples.hippoboot.beans.Imageset;

@HippoEssentialsGenerated(internalName = "hippoonspringboot:eventsdocument")
@Node(jcrType = "hippoonspringboot:eventsdocument")
public class EventsDocument extends HippoDocument {
    /** 
     * The document type of the events document.
     */
    public final static String DOCUMENT_TYPE = "hippoonspringboot:eventsdocument";
    private final static String TITLE = "hippoonspringboot:title";
    private final static String DATE = "hippoonspringboot:date";
    private final static String INTRODUCTION = "hippoonspringboot:introduction";
    private final static String IMAGE = "hippoonspringboot:image";
    private final static String CONTENT = "hippoonspringboot:content";
    private final static String LOCATION = "hippoonspringboot:location";
    private final static String END_DATE = "hippoonspringboot:enddate";

    /** 
     * Get the title of the document.
     * @return the title
     */
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:title")
    public String getTitle() {
        return getProperty(TITLE);
    }

    /** 
     * Get the date of the document, i.e. the start date of the event.
     * @return the (start) date
     */
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:date")
    public Calendar getDate() {
        return getProperty(DATE);
    }

    /** 
     * Get the introduction of the document.
     * @return the introduction
     */
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:introduction")
    public String getIntroduction() {
        return getProperty(INTRODUCTION);
    }

    /** 
     * Get the main content of the document.
     * @return the content
     */
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:content")
    public HippoHtml getContent() {
        return getHippoHtml(CONTENT);
    }

    /** 
     * Get the location of the document.
     * @return the location
     */
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:location")
    public String getLocation() {
        return getProperty(LOCATION);
    }

    /** 
     * Get the end date of the document, i.e. the end date of the event.
     * @return the end date
     */
    @HippoEssentialsGenerated(internalName = "hippoonspringboot:enddate")
    public Calendar getEndDate() {
        return getProperty(END_DATE);
    }

    @HippoEssentialsGenerated(internalName = "hippoonspringboot:image")
    public Imageset getImage() {
        return getLinkedBean("hippoonspringboot:image", Imageset.class);
    }
}
