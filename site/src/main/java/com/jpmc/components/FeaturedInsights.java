package com.jpmc.components;

import com.github.woonsanko.examples.hippoboot.beans.MarketInsight;
import com.github.woonsanko.examples.hippoboot.beans.RichTextSnippet;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaikarve on 1/15/17.
 */
@ParametersInfo(
        type = FeaturedInsightParamsInfo.class
)
public class FeaturedInsights extends BaseCollection {

    public void doBeforeRender(HstRequest hstRequest, HstResponse hstResponse) {
        super.doBeforeRender(hstRequest, hstResponse);
        final HstRequestContext ctx = hstRequest.getRequestContext();

        FeaturedInsightParamsInfo paramsInfo = getComponentParametersInfo(hstRequest);
        List<MarketInsight> snippets = new ArrayList<MarketInsight>();

        HippoBean siteContentBaseBean = ctx.getSiteContentBaseBean();

        MarketInsight snippet = null;
        if(!StringUtils.isEmpty(paramsInfo.getInsight1())) {
            snippet = siteContentBaseBean.getBean(paramsInfo.getInsight1());
            if(snippet != null) {
                snippets.add(snippet);
            }
        }
        if(!StringUtils.isEmpty(paramsInfo.getInsight2())) {
            snippet = siteContentBaseBean.getBean(paramsInfo.getInsight2());
            if(snippet != null) {
                snippets.add(snippet);
            }
        }
        if(!StringUtils.isEmpty(paramsInfo.getInsight3())) {
            snippet = siteContentBaseBean.getBean(paramsInfo.getInsight3());
            if(snippet != null) {
                snippets.add(snippet);
            }
        }

        if(!StringUtils.isEmpty(paramsInfo.getInsight4())) {
            snippet = siteContentBaseBean.getBean(paramsInfo.getInsight4());
            if(snippet != null) {
                snippets.add(snippet);
            }
        }

        if(!StringUtils.isEmpty(paramsInfo.getInsight5())) {
            snippet = siteContentBaseBean.getBean(paramsInfo.getInsight5());
            if(snippet != null) {
                snippets.add(snippet);
            }
        }

        if(!StringUtils.isEmpty(paramsInfo.getInsight6())) {
            snippet = siteContentBaseBean.getBean(paramsInfo.getInsight6());
            if(snippet != null) {
                snippets.add(snippet);
            }
        }

        hstRequest.setAttribute("documents", snippets);
    }
}
