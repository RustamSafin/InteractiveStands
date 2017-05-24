<md-content flex layout-padding>
    <h2>{{$resolve.stand.title}}</h2>
    <md-chips ng-model="$resolve.stand.patterns" readonly="true">
        <md-chip-template>
            {{$chip.name}}
        </md-chip-template>
    </md-chips>
    <ng-bind-html ng-bind-html="$resolve.stand.body"></ng-bind-html>
    <div class="control-group">
        <div class="controls">
            <md-button ng-click="back()">Back</md-button>
            <ng-if ng-if="$resolve.canManage">
                <md-button href="/#/stand/{{$resolve.stand.id}}/update">Update</md-button>
                <md-button ng-click="delete($resolve.stand.id)">Delete</md-button>
            </ng-if>
        </div>
    </div>
</md-content>