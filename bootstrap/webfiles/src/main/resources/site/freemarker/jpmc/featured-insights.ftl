<#include "../include/imports.ftl">

    <#if documents??>
        <#if backgroundImage??>
            <picture class="band-bg">
                <@hst.link var="backgroundImg" hippobean=backgroundImage/>
                <img src="${backgroundImg}" alt="" class="band-image"><!-- <![endif]-->
            </picture>
        </#if>
        <#if title??>
            <h1 class="h1 bandTitle" style="color: ${titleColor}">${title}</h1>
        </#if>
        <div class="row">
        </div>
        <div class="row">

            <#list documents as document>
                <div class="thirty-three">
                    <@hst.cmseditlink hippobean=document />
                    <div class="card-container ">
                        <div class="card" gim-card="true" id="1383336611764-null" gim-is-card-flipped="false" card-adjust="">
                            <div class="face side-one front">
                                <div class="body ">
                                    <div class="content smartscroller" smart-scroller="true" style="height: 219px;">
                                        <div class="scrollholder" style="height: 219px;">
                                            <div class="scrollbar">
                                                <div class="scroller" style=""></div>
                                            </div>
                                            <div class="scrollwrap" style="">
                                                <div class="subtitle"></div>
                                                <div class="title">  ${document.title?html}
                                                </div>
                                                <div class="supplemental-text">
                                                    <p>
                                                        ${document.overview?html}
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- smart scroll-->
                                </div><!--body-->
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </#if>