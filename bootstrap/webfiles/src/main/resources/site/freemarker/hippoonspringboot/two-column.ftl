<#include "../include/imports.ftl">

<@hst.defineObjects/>

<div class="content-wrapper no-container">
    <div class="hero-wrapper">
        <@hst.include ref="hero"/>
    </div>

    <div class="body-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <@hst.include ref="content"/>
                </div>

                <div class="col-md-3 col-sm-3">
                    <@hst.include ref="right"/>
                </div>
            </div>
        </div>
    </div>
</div>