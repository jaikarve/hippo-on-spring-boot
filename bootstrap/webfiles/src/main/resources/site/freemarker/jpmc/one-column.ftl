<#include "../include/imports.ftl">

    <@hst.defineObjects/>

    <div class="page-title text-center container-fluid">
        <h1 class="title center-block">
            ${hstRequestContext.resolvedSiteMapItem.pageTitle}
        </h1>
        <div class="share-button-container center-block">
            <a href="#share-by-email" class="secondary-link ng-scope" data-href="/wcs/ContentServer?pagename=JPMGIMWeb/Common/EmailHandler"
               data-document-url="" ng-click="open('emailThis.html',$event)" ng-controller="OverlayCtrl">
                <span class="icon-email"></span>
                <span class="text darkTextClass">Email This</span>
            </a>
            <span class="secondary-link pointer" gim-print-page="" tabindex="0" role="tooltip" aria-haspopup="true" keypress-to-click="">
                <span class="icon-print"></span>
                <span class="text darkTextClass">Print</span>
            </span>
        </div>
    </div>

    <div class="container-fluid band leftTitle">
        <@hst.include ref="top"/>
    </div>

    <div class="container-fluid band bg-white">
        <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow"/>
        <div class="row">
            <div class="thirty-three">
                <@hst.include ref="middle-left"/>
            </div>
            <div class="thirty-three">
                <@hst.include ref="middle-center"/>
            </div>
            <div class="thirty-three">
                <@hst.include ref="middle-right"/>
            </div>
        </div>
    </div>

    <div class="container-fluid band light">
        <@hst.include ref="middle-2"/>
    </div>

    <div class="container-fluid band">
        <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow"/>
        <div class="row">
            <div class="thirty-three">
                <@hst.include ref="bottom-left"/>
            </div>
            <div class="thirty-three">
                <@hst.include ref="bottom-center"/>
            </div>
            <div class="thirty-three">
                <@hst.include ref="bottom-right"/>
            </div>
        </div>
    </div>

    <div class="container-fluid band">
        <@hst.include ref="bottom-2"/>
    </div>