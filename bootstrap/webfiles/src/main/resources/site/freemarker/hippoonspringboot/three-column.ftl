<#include "../include/imports.ftl">

<@hst.defineObjects/>

<div class="content-wrapper no-container">
    <div class="hero-wrapper">
        <@hst.include ref="hero"/>
    </div>

    <div class="body-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-3">
                    <@hst.include ref="left"/>
                </div>

                <div class="col-md-6 col-sm-6">
                    <@hst.include ref="content"/>
                </div>

                <div class="col-md-3 col-sm-3">
                    <@hst.include ref="right"/>
                </div>
            </div>
        </div>
    </div>
</div>