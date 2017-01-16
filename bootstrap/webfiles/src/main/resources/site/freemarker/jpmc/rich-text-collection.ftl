<#include "../include/imports.ftl">

    <#if items??>
        <#list items as item>
            <div class="thirty-three">
                <@hst.cmseditlink hippobean=item />
                <div class="basic-text module ">
                    <#if item.richText??>
                        <@hst.html hippohtml=item.richText/>
                    </#if>
                </div>
            </div>
        </#list>
    </#if>