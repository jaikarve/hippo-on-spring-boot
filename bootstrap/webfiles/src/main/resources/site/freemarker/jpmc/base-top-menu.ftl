<#include "../include/imports.ftl">

    <style>
        .menuButton {
            position: relative;
        }
        .menuButton a.hst-cmseditlink {
            right: 10px;
        }
    </style>

    <#if menu??>
        <#if menu.siteMenuItems??>
            <nav class="nav">
                <div class="menu globalNav enable-hover">
                    <ul aria-hidden="false" role="menu" class="dropdown-menu primary visible-md-table visible-lg-table" force-tablet-nav="">
                        <#list menu.siteMenuItems as item>
                            <li class=" primary-item long-list " role="menuitem" tabindex="0" aria-hidden="false"
                                aria-expanded="false" id="1383277141549" gim-nav-menu-height="">
                                <span class="icon-plus hide" role="button" aria-expanded="false"></span>
                                <span class="icon-minus hide" role="button" aria-expanded="true"></span>
                                <div class="primary-link">
                                    <a href="<@hst.link link=item.hstLink/>" role="link">
                                        <div class="primary-name">
                                            ${item.name?html}
                                        </div>
                                    </a>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </nav>
        </#if>
        <div class="menuButton">
            <@hst.cmseditmenu menu=menu/>
        </div>
        <#else>
            <#if editMode>
                <h5>[Menu Component]</h5>
                <sub>Click to edit Menu</sub>
            </#if>
    </#if>