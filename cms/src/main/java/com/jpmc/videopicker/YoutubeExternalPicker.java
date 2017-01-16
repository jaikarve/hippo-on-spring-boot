/*
 * Copyright 2016 Hippo B.V. (http://www.onehippo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpmc.videopicker;

import com.google.api.client.repackaged.com.google.common.base.Strings;
import com.jpmc.videopicker.youtube.YouTubeResult;
import com.jpmc.videopicker.youtube.YoutubeClient;
import org.onehippo.forge.exdocpicker.api.ExternalDocumentCollection;
import org.onehippo.forge.exdocpicker.api.ExternalDocumentServiceContext;
import org.onehippo.forge.exdocpicker.api.ExternalDocumentServiceFacade;
import org.onehippo.forge.exdocpicker.impl.SimpleExternalDocumentCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import java.util.Iterator;
import java.util.Locale;

public class YoutubeExternalPicker implements ExternalDocumentServiceFacade<YouTubeResult> {


    private static final Logger log = LoggerFactory.getLogger(YoutubeExternalPicker.class);
    public static final String FIELD_NAME = "youtube.field.name";
    public static final String API_KEY = "youtube.api.key";
    public static final String APP_NAME = "youtube.app.name";
    public static final String CHANNEL = "youtube.channel.name";

    @Override
    public String getDocumentTitle(final ExternalDocumentServiceContext ctx, final YouTubeResult serializable, final Locale locale) {
        final String title = serializable.getTitle();
        if (Strings.isNullOrEmpty(title)) {
            return serializable.getLink();
        }
        return title;
    }

    @Override
    public String getDocumentDescription(final ExternalDocumentServiceContext ctx, final YouTubeResult serializable, final Locale locale) {
        return serializable.getDescription();
    }

    @Override
    public String getDocumentIconLink(final ExternalDocumentServiceContext ctx, final YouTubeResult serializable, final Locale locale) {
        return serializable.getThumbnail();
    }

    @Override
    public ExternalDocumentCollection<YouTubeResult> getFieldExternalDocuments(final ExternalDocumentServiceContext ctx) {
        final SimpleExternalDocumentCollection<YouTubeResult> coll = new SimpleExternalDocumentCollection<>();
        final Node contextNode = ctx.getContextModel().getNode();
        final String property = ctx.getPluginConfig().getString(FIELD_NAME);
        try {
            if (contextNode.hasProperty(property)) {
                final String link = contextNode.getProperty(property).getString();
                final YouTubeResult doc = new YouTubeResult();
                doc.setTitle(link);
                doc.setLink(link);
                coll.add(doc);
            }
        } catch (RepositoryException e) {
            log.error("", e);
        }
        return coll;
    }

    @Override
    public void setFieldExternalDocuments(final ExternalDocumentServiceContext ctx, final ExternalDocumentCollection<YouTubeResult> externalDocumentCollection) {
        final Node contextNode = ctx.getContextModel().getNode();
        final String property = ctx.getPluginConfig().getString(FIELD_NAME);
        final Iterator<? extends YouTubeResult> iterator = externalDocumentCollection.iterator();
        if (iterator.hasNext()) {
            try {
                final YouTubeResult next = iterator.next();
                contextNode.setProperty(property, next.getLink());
            } catch (RepositoryException e) {
                log.error("", e);
            }
        }

    }

    @Override
    public ExternalDocumentCollection<YouTubeResult> searchExternalDocuments(final ExternalDocumentServiceContext ctx, final String query) {
        //YoutubeClient.searchYoutube(query, query);
        String key = ctx.getPluginConfig().getString(API_KEY);
        String appName = ctx.getPluginConfig().getString(APP_NAME);
        String channel = ctx.getPluginConfig().getString(CHANNEL);
        log.info("key = {}", key);
        return YoutubeClient.searchYoutube(query, appName, channel, key);
    }
}
