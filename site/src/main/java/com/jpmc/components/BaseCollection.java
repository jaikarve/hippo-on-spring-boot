package com.jpmc.components;

import com.google.common.base.Strings;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jaikarve on 1/15/17.
 */
@ParametersInfo(
        type = BaseCollectionParamsInfo.class
)
public class BaseCollection extends BaseComponent {

    private static final Logger log = LoggerFactory.getLogger(BaseCollection.class);
    @Override
    public void doBeforeRender(HstRequest hstRequest, HstResponse hstResponse) {
        super.doBeforeRender(hstRequest, hstResponse);
        final HstRequestContext ctx = hstRequest.getRequestContext();

        BaseCollectionParamsInfo paramsInfo = getComponentParametersInfo(hstRequest);
        hstRequest.setAttribute("title", paramsInfo.getTitle());
        hstRequest.setAttribute("margin", paramsInfo.getSeparatorMargin());
        hstRequest.setAttribute("titleColor", paramsInfo.getTitleTextColor());

        String documentPath = paramsInfo.getBackgroundImage();
        if(!Strings.isNullOrEmpty(documentPath)) {
            try {
                Object e = RequestContextProvider.get().getObjectBeanManager().getObject(documentPath);
                hstRequest.setAttribute("backgroundImage", e);
            } catch (ObjectBeanManagerException var6) {
                if(log.isDebugEnabled()) {
                    log.error("Error getting image", var6);
                }
            }
        }
    }
}
