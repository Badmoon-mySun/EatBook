<#assign style = "">

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
<script src="${script}"></script>
</html>
</#macro>


