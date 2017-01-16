package com.jpmc.components;


import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jaikarve on 1/16/17.
 */
@ParametersInfo(
        type = MoreInsightsParamsInfo.class
)
public class MoreInsights extends BaseComponent {

    private static final Logger log = LoggerFactory.getLogger(MoreInsights.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        final HstRequestContext ctx = request.getRequestContext();

        MoreInsightsParamsInfo paramsInfo = getComponentParametersInfo(request);

        String documentLocation = paramsInfo.getMoreDocument();
        final HippoBean document = ctx.getSiteContentBaseBean().getBean(documentLocation);

        request.setAttribute("document", document);
        request.setAttribute("title", paramsInfo.getTitle());
    }
}
