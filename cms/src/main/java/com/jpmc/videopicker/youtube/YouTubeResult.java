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

import java.io.Serializable;

public class YouTubeResult implements Serializable {

    private String title;
    private String description;
    private String link;
    private String thumbnail;

    public String getTitle() {
        if (title == null) {
            return link;
        }
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        if (description == null) {
            return title;
        }
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        if (link != null) {
            this.link = "//www.youtube.com/embed/" + link;
        }

    }

    public void setThumbnail(final String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final YouTubeResult that = (YouTubeResult) o;

        return link != null ? link.equals(that.link) : that.link == null;

    }

    @Override
    public int hashCode() {
        return link != null ? link.hashCode() : 0;
    }
}
