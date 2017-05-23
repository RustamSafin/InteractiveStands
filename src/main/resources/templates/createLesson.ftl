<md-content flex="100" layout-padding>
    <form method="post">
        <h2>Create Lesson</h2>
        <div layout-gt-sm="row">
            <md-input-container class="md-block" flex="40">
                <label>Title</label>
                <input ng-model="user.firstName">
            </md-input-container>
        </div>


        <textarea name="editor1" id="editor1" layout="row"></textarea>
        <div class="control-group">
            <div class="controls">
                <md-button type="submit">Submit</md-button>
            </div>
        </div>

    </form>
</md-content>
