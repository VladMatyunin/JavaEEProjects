<#macro page_head >
<title>Easy</title>
</#macro>
<#macro page_body>
<h1>Basic Page</h1>
<p>This is the body of the page!</p>
</#macro>
<#macro display_page>
<!doctype html>
<html>
<head>
    <#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
    <#assign spring=JspTaglibs["http://www.springframework.org/tags"] >
    <link rel="stylesheet" href="/q/css/bootstrap.min.css" >
    <script src="/q/js/jquery-1.11.1.min.js"></script>
    <script src="/q/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/q/css/mycss/freelancer.css" >
    <link rel="stylesheet" href="/q/css/mycss/freelancer.min.css" >

    <@page_head/>
</head>
<body>
    <#include "header.ftl"/>

    <@page_body/>

<#include "footer.ftl"/>
</body>
</html>
</#macro>
