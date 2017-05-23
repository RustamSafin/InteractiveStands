<md-content flex="100" layout-padding>
    <form method="post">
        <div ng-if="$resolve.canManageStand">
            <h2>Update Lesson</h2>
            <div layout-gt-sm="row">
                <md-input-container class="md-block" flex="40">
                    <label>Title</label>
                    <input value="{{$resolve.stand.title}}">
                </md-input-container>
            </div>
            <textarea name="editor1" id="editor1" layout="row">{{$resolve.stand.body}}</textarea>
        </div>
        <div ng-if="!($resolve.canManageStand)">
            <h2>Create Lesson</h2>
            <div layout-gt-sm="row">
                <md-input-container class="md-block" flex="40">
                    <label>Title</label>
                    <input>
                </md-input-container>
            </div>
            <textarea name="editor1" id="editor1" layout="row">Text</textarea>
        </div>
        <div class="control-group">
            <div class="controls">
                <md-button type="submit">Submit</md-button>
            </div>
        </div>
        <md-button ng-click="back()">Back</md-button>
    </form>
</md-content>
