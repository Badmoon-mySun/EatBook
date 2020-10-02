<#import "common.ftl" as base>
<#assign header = "">

<#macro auth title script>
    <#assign style="/components/css/auth.css">
    <@base.common "${title}" "${style}" "${script}">
        <div class="log">
            <h1>
                <a class="a2" href="/home"> EatBook</a>
            </h1>
        </div>

        ${header}

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
