<div class="row">
    <div ng-repeat="stand in $resolve.stands.standList" class="col m3 s12">
        <div class="card small stand-card">
            <div class="card-image">
                <#--<img src="/upload/{{stand.images.filePath}}"-->
                    <img src="/images/algo.jpg"
                     alt="{{stand.title}}">
            </div>
            <div class="card-content row">
                <span class="card-title col m12"><a href="/#/stand/{{stand.id}}">{{stand.title}}</a></span>
                <div class="col m6 center-align card-text">Автор: Rustam</div>
                <div class="col m6 center-align card-text">дата: 6.06.18</div>
            </div>
        </div>
    </div>
</div>
<md-content layout="row" layout-align="center end">
    <md-button ng-repeat="n in range(1,$resolve.stands.size)" class="md-fab md-mini md-primary"
               ng-click="thisPage(n)">{{n}}
    </md-button>
</md-content>

<div class="fixed-action-btn">
    <a class="btn-floating btn-large waves-effect waves-light green" href="/#/create"><i
            class="material-icons">add</i></a>
</div>

<#--<md-button class="md-fab md-fab-bottom-right relative" aria-label="Add" href="/#/create">-->
<#--<img src="/images/plus.svg">-->
<#--</md-button>-->