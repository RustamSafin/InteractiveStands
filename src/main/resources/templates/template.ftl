<#--<#macro mainTemplate title="" styles=[] scripts=[] headerBannerClass="banner" >-->
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link href="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.4-master-e1345ae/angular-material.css"
          rel="stylesheet">
    <link href="https://material.angularjs.org/1.1.4-master-e1345ae/docs.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/ckeditor/plugins/codesnippet/lib/highlight/styles/default.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>
    <script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular-sanitize.js"></script>

    <script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.4-master-e1345ae/angular-material.js"></script>
    <script src="/js/sidebar.js"></script>
    <script src="/ckeditor/ckeditor.js"></script>
    <script src="/ckeditor/plugins/codesnippet/lib/highlight/highlight.pack.js"></script>

    <script src="/js/security.js"></script>
    <link rel="stylesheet" href="/css/security.css" type="text/css">


</head>
<body ng-app="MyApp" ng-controller="AppCtrl" ng-cloak="">

<#--<#include "components/header.ftl" />-->

<#--<a href="/stand/#/stand/test">Туда</a>-->
<div ng layout="column" class="sidenavdemoBasicUsage">
    <md-toolbar class="md-theme-indigo" layout="row">
        <div class="md-toolbar-tools">
            <div>
                <md-button ng-click="toggleLeft()" class="md-icon-button md-primary"
                           aria-label="Settings" hide-gt-md="">
                    <md-icon md-svg-icon="img/icons/menu.svg"></md-icon>
                </md-button>
            </div>
            <h2 flex="" md-truncate="">Prover</h2>
        </div>
    </md-toolbar>
    <div layout="row" flex="100">
        <md-sidenav class="md-sidenav-left" md-component-id="left" md-is-locked-open="$mdMedia('gt-md')"
                    md-whiteframe="4">

            <md-toolbar class="md-theme-indigo" ng-controller="LeftCtrl">
                <h1 class="md-toolbar-tools">Login@example</h1>
            </md-toolbar>
            <md-button class="inset" layout="row" layout-align="start center">
                Logout
            </md-button>
        </md-sidenav>
        <ng-view flex="100" layout="row"></ng-view>
    </div>
</div>
</body>
</html>
<#--</#macro>-->