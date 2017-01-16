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

package com.jpmc.videopicker.youtube;

import com.google.api.client.repackaged.com.google.common.base.Strings;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import org.onehippo.forge.exdocpicker.api.ExternalDocumentCollection;
import org.onehippo.forge.exdocpicker.impl.SimpleExternalDocumentCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public final class YoutubeClient {
    private static Logger log = LoggerFactory.getLogger(YoutubeClient.class);

    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;

    private YoutubeClient() {
    }

    // String apiKey = "AIzaSyBdcp9hagF_3yZrE23SyzU1M_1SQU3cBQo";
    public static ExternalDocumentCollection<YouTubeResult> searchYoutube(final String query, final String app, final String channel, final String key) {
        final SimpleExternalDocumentCollection<YouTubeResult> retVal = new SimpleExternalDocumentCollection<>();
        try {
            if (Strings.isNullOrEmpty(query)) {
                return retVal;
            }
            final YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, request -> {
            }).setApplicationName(app).build();
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
            // {{ https://cloud.google.com/console }}

            search.setKey(key);
            search.setQ(query);
            search.setChannelId(channel);
            search.setType("video");
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            SearchListResponse searchResponse = search.execute();
            final List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {

                for (SearchResult searchResult : searchResultList) {
                    final YouTubeResult result = new YouTubeResult();
                    final SearchResultSnippet snippet = searchResult.getSnippet();
                    if (snippet != null) {
                        final ThumbnailDetails thumbnails = snippet.getThumbnails();
                        if (thumbnails != null) {
                            final Thumbnail aDefault = thumbnails.getDefault();
                            if (aDefault != null) {
                                final String url = aDefault.getUrl();
                                result.setThumbnail(url);
                            }
                        }
                        result.setTitle(snippet.getTitle());
                        result.setDescription(snippet.getDescription());
                    }

                    result.setLink(searchResult.getId().getVideoId());
                    retVal.add(result);
                }
                return retVal;

            }

        } catch (IOException e) {
            log.error("Error searching", e);
        }
        return retVal;

    }
}
