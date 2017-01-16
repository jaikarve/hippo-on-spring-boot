<#include "../../include/imports.ftl">

    <#if document??>
        <#if document.title??>
            <div class="basic-text module ">
                <h2>${document.title?html}</h2>
            </div>
        </#if>
        <div class="featured-text module header-image long-title no-top-border" style="min-height: 290px; height: auto;">
            <@hst.link var="img" hippobean=document.image/>
            <@hst.cmseditlink hippobean=document />
            <img src="${img}" class="centered-image" title="Maze" alt="">
            <h2 class="headline">
            </h2>
            <#if document.content??>
                <div>
                    <div class="supporting-copy">
                        <@hst.html hippohtml=document.content/>
                    </div>
                </div>
            </#if>
        </div>
    </#if>