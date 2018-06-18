<div class="stand row">
    <form action="/create" method="post">
        <div ng-if="$resolve.canManageStand">
            <div class=" col m6">
                <div class="row">
                    <div class="input-field">
                        <input id="title" name="title" type="text" value="{{$resolve.stand.title}}">
                        <label for="title" class="grey-text">Название стенда</label>
                    </div>

                    <#--<textarea name="code" id="code" layout="row"></textarea>-->
                    <div id="editor">{{$resolve.stand.body}}
                    </div>
                    <button class="btn waves-effect com-sub waves-light green white-text col m12 " type="submit" name="action">Сохранить</button>
                </div>
            </div>
            <div class=" card col m6">
                <div class="row comment">
                    <h4>Пояснение</h4>
                    <textarea name="text" id="text" layout="row">{{$resolve.comment.body}}</textarea>
                    <div class="btn green com-sub waves-light right white-text">Добавить</div>
                </div>
            </div>

        </div>
        <div ng-if="!($resolve.canManageStand)">
            <div class=" col m6">
                <div class="row">
                    <div class="input-field col m10">
                        <input id="title" name="title" type="text">
                        <label for="title" class="grey-text">Название стенда</label>
                    </div>
                    <div id="editor">public class Main {
                            public static void main(String[] args) {
                                System.out.println("Hello World");
                            }
                        }
                    </div>
                    <textarea name="body" id="body" style="display: none;" />
                    <button class="btn waves-effect waves-light com-sub green white-text " type="submit" name="action">Сохранить</button>
                </div>
            </div>
            <div class="card col m6">
                <div class="row comment">
                    <h4>Пояснение</h4>
                    <textarea name="text" id="text" layout="row">Добавьте необходимые пояснения</textarea>
                    <div class="btn green com-sub waves-light right white-text">Добавить</div>
                </div>
            </div>
    </form>
    <script src="/ace/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    <script>
        var editor = ace.edit("editor");
        editor.setTheme("ace/theme/textmate");
        editor.session.setMode("ace/mode/java");
        var textarea = $('textarea[name="body"]');
        editor.getSession().on("change", function () {
            textarea.val(editor.getSession().getValue());
        });
    </script>
</div>