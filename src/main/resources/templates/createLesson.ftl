<md-content flex="100" layout-padding>
    <form action="/create" method="post">
        <div ng-if="$resolve.canManageStand">
            <div layout-gt-sm="row">
                <md-input-container class="md-block" flex="40">
                    <label>Title</label>
                    <input name="title" id="title" value="{{$resolve.stand.title}}">
                </md-input-container>
            </div>
            <div layout="row">
                <md-input-container>
                    <label>Patterns</label>
                    <md-select ng-repeat="pattern in $resolve.patterns" name="patterns[]" multiple="">
                        <md-optgroup  label="Patterns">
                            <md-option  ng-value="pattern.id">{{pattern.name}}</md-option>
                        </md-optgroup>
                    </md-select>
                </md-input-container>
            </div>
            <textarea name="text" id="text" layout="row">{{$resolve.stand.body}}</textarea>
        </div>
        <div ng-if="!($resolve.canManageStand)">
            <h2>Create Lesson </h2>
            <div layout-gt-sm="row">
                <md-input-container class="md-block" flex="40">
                    <label>Title</label>
                    <input name="title" id="title">
                </md-input-container>
            </div>
            <div layout="row">
                <md-input-container>
                    <label>Patterns</label>
                    <md-select ng-model="nam" name="patterns[]" multiple="">
                        <md-optgroup  ng-repeat="pattern in $resolve.patterns" label="Patterns">
                            <md-option ng-value="pattern.id">{{pattern.name}}</md-option>
                        </md-optgroup>
                    </md-select>
                </md-input-container>
            </div>
            <textarea name="text" id="text" layout="row">Text</textarea>
        </div>
        <div class="control-group">
            <div class="controls">
                <md-button ng-click="back()">Back</md-button>
                <md-button type="submit">Submit</md-button>
            </div>
        </div>

    </form>
</md-content>
