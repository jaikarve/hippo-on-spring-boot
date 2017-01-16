/**
 * Copyright 2010-2013 Hippo B.V. (http://www.onehippo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpmc.components;

import com.github.woonsanko.examples.hippoboot.beans.Video;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = VideoParamsInfo.class)
public class VideoComponent extends BaseComponent {

    public static final Logger log = LoggerFactory.getLogger(VideoComponent.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        final HstRequestContext ctx = request.getRequestContext();
        VideoParamsInfo paramsInfo = getComponentParametersInfo(request);
        String videoDocPath = paramsInfo.getVideoDoc();
        log.debug("Video URL specified in hst is " + videoDocPath);

        final Video videoDoc = ctx.getSiteContentBaseBean().getBean(videoDocPath);
        if (videoDoc != null) {
            request.setAttribute("videoDoc", videoDoc);
        }
    }
}
