<#macro common title style script>
<html>
<head>
    <meta content="text/html; charset=utf-8">
    <title>${title}</title>
    <link href="${style}" rel="stylesheet">
</head>
    <body>
        <#nested>
    </body>
<#if script != "">
    <script src="${script}" charset="utf-8"></script>
</#if>
</html>
</#macro>