<#import "common.ftl" as base>

<#macro auth title script>
    <#assign style="/components/css/auth.css">
    <@base.common "${title}" "${style}" "${script}">
        <div class="log">

            <h1>
                <a class="a2" href="menu.html"> EatBook</a>
            </h1>
        </div>

        <div class="title">
            <h1>
                <a class="a1"> Вход </a>
            </h1>
        </div>

        <div class="title2">
            <big>
                <a class="big1">У вас ещё нет аккаунта?</a>
                <a class="big2" href="register.html">Создать</a>
            </big>
        </div>

        <div class="wrapper">
            <div class="form">
                <#nested>
            </div>
            <div class="picture">
                <img src="/components/image/schema.png" width="800" height="500">
            </div>
        </div>
    </@base.common>
</#macro>
