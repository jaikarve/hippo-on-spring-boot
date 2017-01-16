<#include "../../include/imports.ftl">

    <#if document??>
        <div class="featured-text module ">
            <style>
                .title {
                    position: relative;
                }
                .title a.hst-cmseditlink {
                    left: 300px;
                    bottom: 150px;
                }
            </style>
            <span class="title">
                <@hst.cmseditlink hippobean=document />
            </span>
            <a href="#" target="_self"></a>
            <a href="#" target="_self">
                <#if document.title??>
                    <h2 class="headline">${document.title?html}</h2>
                </#if>
            </a>
            <div>
                <div class="supporting-copy">
                    <table border="0" cellpadding="1" cellspacing="1">
                        <tbody>
                        <tr>
                            <td style="vertical-align: top;">
                                <p>

                                    <picture class="">
                                        <@hst.link var="img" hippobean=document.image/>
                                        <img src="${img}"
                                             alt="" class=""><!-- <![endif]-->
                                    </picture>
                                </p>
                            </td>
                            <td style="vertical-align: top;  padding-left: 15px;">
                                <@hst.html hippohtml=document.content/>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
        <#elseif preview>
            <img src="<@hst.link path="/images/essentials/catalog-component-icons/banner.png" />"> Click to edit Banner
    </#if>