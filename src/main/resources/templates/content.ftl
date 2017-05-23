<md-content layout="row" layout-wrap flex>
    <md-content flex="33" ng-repeat="stand in $resolve.stands">
        <md-card>
            <img src="/upload/{{stand.images.filePath}}" style="height: 350px" class="md-card-image" alt="Washed Out">
            <md-card-title>
                <md-card-title-text>
                    <span class="md-headline">{{stand.title}}</span>
                </md-card-title-text>
            </md-card-title>
            <md-card-content>
            </md-card-content>
            <md-chips ng-repeat="pattern in stand.patterns">
                <md-chip>
                    {{pattern.name}}
                </md-chip>
            </md-chips>
            <md-card-actions layout="row" layout-align="end center">
                <md-button class="md-icon-button" aria-label="Favorite">
                    <md-icon md-svg-icon="img/icons/favorite.svg"></md-icon>
                </md-button>
                <md-button class="md-icon-button" aria-label="Settings">
                    <md-icon md-svg-icon="img/icons/menu.svg"></md-icon>
                </md-button>
                <md-button class="md-icon-button" aria-label="Share">
                    <md-icon md-svg-icon="img/icons/share-arrow.svg"></md-icon>
                </md-button>
            </md-card-actions>
        </md-card>
    </md-content>
    <md-content layout="row" layout-align="center end">
        <md-button class="md-fab md-mini md-primary" arial="page" ng-repeat="i in $resolve.stands.size" ng-click="thisPage(i)">
            {{i+1}}
        </md-button>
    </md-content>
    <md-button class="md-fab md-primary md-fab-bottom-right relative" aria-label="Add" ng-click="">
        <img src="/images/plus.svg">
    </md-button>