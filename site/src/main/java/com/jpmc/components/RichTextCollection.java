package com.jpmc.components;

import com.github.woonsanko.examples.hippoboot.beans.RichTextSnippet;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryManager;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaikarve on 7/26/16.
 */
@ParametersInfo(type = RichTextCollectionParamsInfo.class)
public class RichTextCollection extends BaseCollection {

    private static final Logger log = LoggerFactory.getLogger(RichTextCollection.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        final HstRequestContext ctx = request.getRequestContext();

        RichTextCollectionParamsInfo paramsInfo = getComponentParametersInfo(request);

        String itemsScope = paramsInfo.getScope();

        HippoBean folderBean = ctx.getSiteContentBaseBean();
        if (itemsScope != null) {
            folderBean = folderBean.getBean(itemsScope);
            if (folderBean == null) {
                log.warn("Scope not found: '{}'.", itemsScope);
                return;
            }
        }

        final HstQueryManager hstQueryManager = ctx.getQueryManager();
        final HstQuery hstQuery;

        final List<HippoBean> results = new ArrayList<HippoBean>();
        try {
            hstQuery = hstQueryManager.createQuery(folderBean, RichTextSnippet.class, true);
            final HstQueryResult queryResult = hstQuery.execute();
            request.setAttribute("count", queryResult.getSize());

            final HippoBeanIterator beanIterator = queryResult.getHippoBeans();
            while (beanIterator.hasNext()) {
                HippoBean bean = beanIterator.nextHippoBean();
                results.add(bean);
            }
        }
        catch (QueryException e) {
            log.error("Unable to execute the query for latest items", e);
        }
        finally {
            request.setAttribute("items", results);
        }
    }
}
