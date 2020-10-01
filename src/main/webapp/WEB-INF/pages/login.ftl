<#import "bases/authorization_base.ftl" as auth>

<@auth.auth "Login" "">
    <form action="${uri}" method="post" id="register">
        <fieldset class="fields">
            <#if error??>
                <div style="font-size: 16px; color: red;">${error}</div>
            </#if>
            <label for="email">Эл.почта</label>
            <input type="email" id="email" name="email">
            <span></span><br>
            <label for="password">Пароль</label>
            <input type="password" id="password" name="password">
            <span></span><br>
            <label class="aut">Запомнить меня</label>
            <input type="checkbox" class="option1" name="remember">
            </span><br>
        </fieldset>
        <div class="buttons">
            <fieldset class="second">
                <button type="submit" class="button7">Авторизироваться</button>
            </fieldset>
        </div>
    </form>
</@auth.auth>