<#include "../include/imports.ftl">

    <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow" title="" alt="">

    <#if document??>
        <#if document.title??>
            <h1 class="h1 bandTitle">
                ${document.title?html}
            </h1>
        </#if>
        <div class="row">
            <@hst.cmseditlink hippobean=document />
            <div class="fifty">
                <div class="featured-text module no-top-border" style="min-height: 284px; height: auto;">
                    <a href="#" target="_self"></a>
                    <a href="#" target="_self">
                        <@hst.html hippohtml=document.content/>
                    </a>
                    <#if document.title == "The J.P. Morgan Insights App">
                        <div>
                            <div class="supporting-copy">Get the Insights app:</div>
                        </div>
                        <div class="basic-text module ">
                            <div class="supporting-copy">
                                <a ng-href="https://itunes.apple.com/us/app/insights-by-j.p.-morgan-asset/id602722972?ls=1&amp;mt=8"
                                   href="#"
                                   target="_blank" title="Download on the App Store">
                                    <img src="<@hst.webfile  path='/images/jpmc/Apple-App-Store_badge.jpg'/>" class="ng-scope"
                                         title="Apple App Store badge" alt="Apple App Store badge">
                                </a>
                            </div>
                        </div>
                        <div>
                            <a href="#" class="btn btn-cta"
                               target="_self">Learn more about the Insights App
                                <span class="icon-rightchevron"></span>
                            </a>
                        </div>
                    </#if>
                </div>
            </div>
            <#if document.image??>
                <div class="fifty">
                    <div class="basic-text module ">
                        <div class="supporting-copy">
                            <@hst.link var="img" hippobean=document.image/>
                            <picture class="">
                                <img src="${img}" alt=""
                                     class="">
                            </picture>
                        </div>
                    </div>
                </div>
            </#if>
            <div class="clearfix"></div>
        </div>
    </#if>