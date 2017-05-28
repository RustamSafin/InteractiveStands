<div ng-app="MyApp" ng-controller="AppCtrl" layout="row" layout-align="center center" layout-fill="layout-fill">


    <form action="/" method="post" ng-show="showLogin" class="box-one loginBox md-whiteframe-z1" layout="column">

        <md-toolbar>
            <h2 class="md-toolbar-tools"><span>Login</span></h2>
            <md-button ng-click="hideLogin()" class="md-fab md-fab-bottom-right " aria-label="Add">
                <img src="/images/plus.svg">
            </md-button>
        </md-toolbar>
        <md-content class="md-padding" layout="column">
            <md-input-container>
                <label>EmailAddress</label>
                <input type="email" name="login" ng-model="username"/>
            </md-input-container>
            <md-input-container>
                <label>Password</label>
                <input type="password" name="password"/>
            </md-input-container>
            <div layout="row" layout-align="center center" style="padding-top:20px">
                <md-button type="submit" class="md-raised md-primary">Login</md-button>
                <div flex="flex"></div>
                <md-button href="" md-no-ink="md-no-ink">Forgot Password</md-button>
            </div>
        </md-content>
    </form>
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