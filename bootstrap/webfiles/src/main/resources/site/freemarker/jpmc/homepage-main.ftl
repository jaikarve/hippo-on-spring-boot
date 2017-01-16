<#include "../include/imports.ftl">

    <@hst.defineObjects/>

    <div class="page-title text-center container-fluid">
        <h1 class="title center-block">
            ${hstRequestContext.resolvedSiteMapItem.pageTitle}
        </h1>
        <div class="share-button-container center-block">
            <a href="#" class="secondary-link ng-scope" data-href="/wcs/ContentServer?pagename=JPMGIMWeb/Common/EmailHandler"
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

    <div id="None" class="container-fluid band   bg-light-gray   ">
        <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow" title="" alt="">
        <div class="row">
            <div class="sixty-six">
                <@hst.include ref="top-left"/>
            </div>
            <div class="thirty-three">
                <@hst.include ref="top-right"/>
            </div>
        </div>
    </div>
    <div id="Bandtitle1" class="container-fluid band      "
         gim-resize-module=".featured-text">
        <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow" title="" alt="">
        <div class="row">
            <@hst.include ref="middle"/>
        </div>
    </div>

    <div id="FeaturedMarketInsights" class="container-fluid band    light  " gim-resize-module=".featured-text">

        <@hst.include ref="middle-2"/>

    </div>

    <div id="None" class="container-fluid band      " gim-resize-module=".featured-text">
        <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow" title="" alt="">
        <div class="row">
            <div class="fifty">
                <@hst.include ref="bottom-left"/>
            </div>
            <div class="fifty">
                <@hst.include ref="bottom-right"/>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

    <div id="MorefromInsights" class="container-fluid band      " gim-resize-module=".featured-text">
        <img src="<@hst.webfile  path='/images/jpmc/bandshadow.png'/>" class="bandshadow" title="" alt="">
        <@hst.include ref="bottom-2"/>
    </div>

    <div id="TheJ.P.MorganInsightsapp" class="container-fluid band leftTitle   dark  " gim-resize-module=".featured-text">
        <@hst.include ref="bottom-3"/>
    </div>