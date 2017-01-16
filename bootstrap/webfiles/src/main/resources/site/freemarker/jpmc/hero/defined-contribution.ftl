<#include "../../include/imports.ftl">

    <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>"/>

    <#if document??>
        <#if document.image??>
            <@hst.link var="img" hippobean=document.image/>
            <picture class="band-bg">
                <img src="${img}" class="band-image"/>
            </picture>
        </#if>
        <#if document.content??>
            <@hst.cmseditlink hippobean=document />
            <div class="fifty">
                <div class="basic-text module">
                    <h2>${document.title?html}</h2>
                </div>
                <div class="supporting-copy">
                    <@hst.html hippohtml=document.content/>
                </div>
            </div>
        </#if>
    </#if>