<#include "../include/imports.ftl">

    <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow" title="" alt="">

    <#if title??>
        <h1 class="h1 bandTitle">${title?html}</h1>
    </#if>

    <#if document??>
        <div class="row">
            <@hst.cmseditlink hippobean=document />
            <div class="promotional-asset module">
                <div class="promo-asset-header showBorder">
                    <div class="clearfix"></div>
                </div>
                <#list document.moreLikeThis as likeThis>
                    <div class="promo-asset col-sm-4 col-xsl-6">
                        <a class="promo-component">
                            <div class="promo">
                                <#if likeThis.image??>
                                    <@hst.link var="img" hippobean=likeThis.image/>
                                    <picture class="promo-picture" style="min-height: 104px; height: auto;">
                                        <img src="${img}" />
                                    </picture>
                                </#if>
                                <#if likeThis.caption??>
                                    <div class="title">${likeThis.caption?html}</div>
                                </#if>
                            </div>
                        </a>
                    </div>
                </#list>
            </div>
        </div>
    </#if>