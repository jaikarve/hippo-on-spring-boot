<#include "../include/imports.ftl">

    <#if videoDoc??>
        <@hst.cmseditlink hippobean=videoDoc />
        <div>
            <#if title??>
                <header>
                    <h1>
                        ${title?html}
                    </h1>
                </header>
            </#if>
            <#if videoDoc.title??>
                <div>
                    <h3>${videoDoc.title?html}</h3>
                </div>
            </#if>
            <#if videoDoc.description??>
                <div>
                    <p>${videoDoc.description?html}</p>
                </div>
            </#if>
            <div>
                <p>
                <div style="text-align: center;">
                    <iframe width="560" height="315" src="https:${videoDoc.videoLink}" frameborder="0" allowfullscreen></iframe>
                </div>
                </p>
            </div>
        </div>
        <#elseif preview>
            <img src="<@hst.link path="images/essentials/catalog-component-icons/component-video-30x30.png" />"> Click to edit Video
    </#if>