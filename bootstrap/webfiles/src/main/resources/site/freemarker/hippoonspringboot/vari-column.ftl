<#include "../include/imports.ftl">

<@hst.defineObjects/>

<div class="content-wrapper no-container vari-column">

    <div class="body-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <@hst.include ref="top"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <@hst.include ref="left1"/>
                </div>
                <div class="col-md-3 col-sm-3">
                    <@hst.include ref="right1"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3 col-sm-3">
                    <@hst.include ref="left2"/>
                </div>
                <div class="col-md-9 col-sm-9">
                    <@hst.include ref="right2"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <@hst.include ref="bottom"/>
                </div>
            </div>
        </div>
    </div>
</div>