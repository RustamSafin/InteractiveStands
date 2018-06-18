<div class="row stand-main">
    <div class="col m6">
        <div class="control-group center-align">
            <a id="play" class="btn waves-light green white-text"><i class="material-icons left">play_arrow</i>Запустить</a>
            <a id="debug" class="btn waves-light red white-text disabled "><i class="material-icons left">bug_report</i>Пошагово</a>
            <a id="stop" class="btn waves-light blue white-text "><i class="material-icons left">stop</i>Стоп</a>
            <a id="nextStep" class="btn waves-light blue white-text "><i class="material-icons left">skip_next</i>След.шаг</a>
        </div>
        <div id="codelist" style="display: none">{{$resolve.stand.body}}</div>
        <div id="edit">
        </div>
        <div class="card result" style="display: none">
            <div class="card-title result-card">Результаты выполнения</div>
            <div id='result' class="card-content result-card"></div>
        </div>
    </div>
    <div class="card col m6">
        <div class="row comment">
            <h4>Стек вызовов</h4>
            <table>
                <thead>
                    <tr>
                        <th>Переменная</th>
                        <th>Значение</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>mas</td>
                        <td>int[5]</td>
                    </tr>
                    <tr>
                        <td>isSorted</td>
                        <td>false</td>
                    </tr>
                    <tr>
                        <td>i</td>
                        <td>1</td>
                    </tr>
                </tbody>
            </table>
            <h4>Пояснение</h4>
            <p><iframe allowfullscreen="" frameborder="0" height="360" src="https://www.youtube.com/embed/F13_wsHDIG4?start=0" width="580"></iframe></p>

            <p>При этом проходе мы сделали то же самое, что и в первый раз &ndash; сравнили попарно все элементы, сделали все необходимые обмены. В результате получили следующий массив: [1, 4, 2, 6, 9]. Уже сейчас можно проследить, что число 2 с каждым проходом сдвигается на 1 позицию влево. В этом и есть вся суть метода пузырьком &ndash; смещать элементы с меньшими значениями влево, а элементы с бОльшими значениями смещать вправо.</p>
        </div>
    </div>
    <script src="/ace/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(document).ready(function () {
            var editor = ace.edit("edit");
            // $(".comment").appendChild($("#codelist").getValue());
            editor.setValue($("#codelist").text(),-1);

            var Range = ace.require("ace/range").Range;
            // editor.session.addMarker(new Range(3,0,3,1000),"ace_active-line","fullLine");
            editor.setTheme("ace/theme/textmate");
            editor.session.setMode("ace/mode/java");
            editor.renderer.setShowGutter(true);
            editor.on("guttermousedown", function (e) {
                var target = e.domEvent.target;

                if (target.className.indexOf("ace_gutter-cell") == -1) {
                    return;
                }
                if (!editor.isFocused()) {
                    return;
                }
                if (e.clientX > 25 + target.getBoundingClientRect().left) {
                    return;
                }
                var row = e.getDocumentPosition().row;
                var breakpointsArray = e.editor.session.getBreakpoints();
                if (!(row in breakpointsArray)) {
                    e.editor.session.setBreakpoint(row);
                } else {
                    e.editor.session.clearBreakpoint(row);
                }
                e.stop();
            });
            editor.session.on("changeBreakpoint", function (e) {
            });
            var socket = io.connect('http://localhost:8080');
            socket.on('output', function (data) {
                $('.callstack').append(data);
            });
            $('.debug').on("click",function(e){
                // var editor = ace.edit("edit");
                socket.emit("start_debug",{code: editor.getValue(), bp: getBreakPoints()})
            });
            $('.nextStep').on("click",function(e){
                socket.emit("input","step into");
            });
            $('.stop').on("click",function(e){
                socket.emit("stop_debug","break");
            });

            function getBreakPoints() {
                var x = document.getElementsByClassName("ace_breakpoint");
                var arr = [];
                x.forEach(function (element) {
                    arr.push(element);
                })
            }
            
            $('#play').on("click",function () {
                $.ajax({
                    url: '/run',
                    method: POST,
                    data: editor.getValue(),
                    success: function (data) {
                        $(".result").css("display: block");
                        $("#result").append(data);
                    }
                });
            })
        });
    </script>
</div>

