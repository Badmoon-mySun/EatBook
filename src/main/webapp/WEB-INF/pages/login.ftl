<#import "bases/authorization_base.ftl" as auth>

<@auth.auth "Login" "">
    <form action="" method="post" id="register">
        <fieldset class="fields">
            <label for="email">Эл.почта</label><input type="email" id="email">
            <span></span><br>
            <label for="password">Пароль</label><input type="password" id="password">
            <span></span><br>
            <label class="aut">Запомнить меня</label><input type="checkbox" class="option1" value="a1"></span><br>
        </fieldset>
        <div class="buttons">
            <fieldset class="second">
                <button type="submit" class="button7">Авторизироваться</button>
            </fieldset>
            <fieldset class="second right">
                <a href="#" class="forgetPassword">Забыли пароль?</a>
            </fieldset>
        </div>
    </form>
</@auth.auth>