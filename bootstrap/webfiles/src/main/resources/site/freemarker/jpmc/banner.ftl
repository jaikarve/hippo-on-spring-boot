<#include "../include/imports.ftl">

    <#if document??>
        <@hst.cmseditlink hippobean=document />
        <div class="featured-text module ">
            <a href="" target="_self"></a>
            <a href="" target="_self">
                <#if document.title??>
                    <h2 class="headline">
                        ${document.title?html}
                    </h2>
                </#if>
            </a>
            <div>
                <div class="supporting-copy">
                    <picture class="">
                        <@hst.link var="img" hippobean=document.image/>
                        <img src="${img}" alt="" class=""><br>
                        <#if document.content??>
                            <@hst.html hippohtml=document.content/>
                        </#if>
                    </picture>
                </div>
            </div>
        </div>
        <#elseif preview>
            <img src="<@hst.link path="/images/essentials/catalog-component-icons/banner.png" />"> Click to edit Banner
    </#if>