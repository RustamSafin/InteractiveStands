<#include "template.ftl">
<@mainTemplate title="Login Registration form" />
<#macro m_body>
<div class="materialContainer">
    <div class="box">
        <form method="post" action="/login">
            <div class="title">LOGIN</div>

            <div class="input">
                <label for="name">s</label>
                <input type="text" name="login" id="name">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="pass">Password</label>
                <input type="password" name="password" id="pass">
                <span class="spin"></span>
            </div>
            <div class="control-group">
                <div class="controls">
                    <div class="button login ">
                        <button><span>GO</span> <i class="fa fa-check"></i></button>
                    </div>
                </div>
            </div>
        </form>
        <a href="" class="pass-forgot">Forgot your password?</a>

    </div>

    <div class="overbox">
        <div class="material-button alt-2"><span class="shape"></span></div>
        <form method="post" name="user" action="/registration">
            <div class="title">REGISTER</div>

            <div class="input">
                <label for="regname">Username</label>
                <input type="text" name="username" id="regname">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="regpass">Password</label>
                <input type="password" name="password" id="regpass">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="reregpass">Repeat Password</label>
                <input type="password" name="reregpass" id="reregpass">
                <span class="spin"></span>
            </div>
            <div class="control-group">
                <div class="controls">
                    <div class="button">
                        <button><span>NEXT</span></button>
                    </div>
                </div>
            </div>
        </form>

    </div>

</div>
</#macro>