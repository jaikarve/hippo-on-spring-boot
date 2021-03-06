/*
 * Copyright 2011-2013 Hippo B.V. (http://www.onehippo.com)
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
package com.jpmc.components;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;

/**
 * Header/title component for Home Page
 */
@ParametersInfo(type = BaseLayoutParamsInfo.class)
public class BaseLayout extends BaseComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        BaseLayoutParamsInfo paramsInfo = getComponentParametersInfo(request);

        request.setAttribute("title", paramsInfo.getTitle());
        request.setAttribute("icon", paramsInfo.getIcon());

        request.setAttribute("separatorMargin", paramsInfo.getSeparatorMargin());
        request.setAttribute("separatorBorderTop", paramsInfo.getSeparatorBorderTop());
        request.setAttribute("separatorBorderBottom", paramsInfo.getSeparatorBorderBottom());
        request.setAttribute("offerBackgroundColor", paramsInfo.getOfferBackgroundColor());
        request.setAttribute("borderColor", paramsInfo.getBorderColor());
    }
}
