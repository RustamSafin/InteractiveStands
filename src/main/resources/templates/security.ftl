

<div ng-app="MyApp" ng-controller="AppCtrl" layout="row" layout-align="center center" layout-fill="layout-fill">
    <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
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

    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


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
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular-sanitize.js"></script>
    <script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.4-master-e1345ae/angular-material.js"></script>
    <script src="/js/sidebar.js"></script>
    <script src="/ckeditor/ckeditor.js"></script>
    <script src="/ckeditor/plugins/codesnippet/lib/highlight/highlight.pack.js"></script>

    <link rel="stylesheet" href="/css/security.css" type="text/css">

    <#--<form action="/" method="post" ng-show="showLogin" class="box-one loginBox md-whiteframe-z1" layout="column">-->

        <#--<md-toolbar>-->
            <#--<h2 class="md-toolbar-tools"><span>Login</span></h2>-->
            <#--<md-button ng-click="hideLogin()" class="md-fab md-fab-bottom-right " aria-label="Add">-->
                <#--<img src="/images/plus.svg">-->
            <#--</md-button>-->
        <#--</md-toolbar>-->
        <#--<md-content class="md-padding" layout="column">-->
            <#--<md-input-container>-->
                <#--<label>EmailAddress</label>-->
                <#--<input type="email" name="login" ng-model="username"/>-->
            <#--</md-input-container>-->
            <#--<md-input-container>-->
                <#--<label>Password</label>-->
                <#--<input type="password" name="password"/>-->
            <#--</md-input-container>-->
            <#--<div layout="row" layout-align="center center" style="padding-top:20px">-->
                <#--<md-button type="submit" class="md-raised md-primary">Login</md-button>-->
                <#--<div flex="flex"></div>-->
                <#--<md-button href="" md-no-ink="md-no-ink">Forgot Password</md-button>-->
            <#--</div>-->
        <#--</md-content>-->
    <#--</form>-->
    <form action="/registration" method="post" ng-show="showReg" class="box-one loginBox md-whiteframe-z1"
          layout="column">

        <md-toolbar>
            <h2 class="md-toolbar-tools"><span>Registration</span></h2>
            <md-button ng-click="hideReg()" class="md-fab md-fab-bottom-right" aria-label="Add">
                <img src="/images/cross.svg">
            </md-button>
        </md-toolbar>
        <md-content class="md-padding" layout="column">
            <md-input-container>
                <label>EmailAddress</label>
                <input type="email" name="username" ng-model="username"/>
            </md-input-container>
            <md-input-container>
                <label>Password</label>
                <input type="password" name="password"/>
            </md-input-container>
            <md-input-container>
                <label>Confirm password</label>
                <input type="password"/>
            </md-input-container>
            <div layout="row" layout-align="center center" style="padding-top:20px">
                <md-button type="submit" class="md-raised md-primary">Registration</md-button>
                <div flex="flex"></div>
                <md-button href="" md-no-ink="md-no-ink">Forgot Password</md-button>
            </div>
        </md-content>
    </form>
</div>