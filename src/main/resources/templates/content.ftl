<md-content layout="row" layout-wrap flex>
    <md-content flex="33" ng-repeat="stand in $resolve.stands.standList">
        <md-card>
            <img src="/upload/{{stand.images.filePath}}" style="height: 350px" class="md-card-image" alt="Washed Out">
            <md-card-title>
                <md-card-title-text>
                    <span class="md-headline">{{stand.title}}</span>
                </md-card-title-text>
            </md-card-title>
            <md-card-content>
            </md-card-content>
            <md-chips ng-model="stand.patterns" readonly="true">
                <md-chip-template>
                    {{$chip.name}}
                </md-chip-template>
            </md-chips>
            <md-card-actions layout="row" layout-align="end center">
                <md-button class="md-icon-button" aria-label="Favorite">
                    <md-icon md-svg-icon="/images/thumb_up.svg"></md-icon>
                </md-button>
                <md-button class="md-icon-button" aria-label="Settings" href="/#/stand/{{stand.id}}">
                    <md-icon md-svg-icon="/images/launch.svg"></md-icon>
                </md-button>
                <md-button class="md-icon-button" aria-label="Share">
                    <md-icon md-svg-icon="img/icons/share-arrow.svg"></md-icon>
                </md-button>
            </md-card-actions>
        </md-card>
    </md-content>
    <md-content flex="100" layout="row" layout-align="center end">
        <md-button ng-repeat="n in range(1,$resolve.stands.size)" class="md-fab md-mini md-primary"
                   ng-click="thisPage(n)">{{n}}
        </md-button>
    </md-content>
</md-content>


<md-button class="md-fab md-fab-bottom-right relative" aria-label="Add" href="/#/create">
    <img src="/images/plus.svg">
</md-button>