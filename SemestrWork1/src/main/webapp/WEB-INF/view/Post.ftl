<#include "mainTempl.ftl">
<#assign spring=JspTaglibs["http://www.springframework.org/tags"] >
<#macro page_head>
<script>
    function like(id) {
//        var el = document.getElementById('like'+id);
//        el.disable();
        $.ajax({
            url: "<@spring.url value = "/like"></@spring.url>",
            type: "POST",
            data: {
                id: id
            }
        })
    }
    function dislike(id) {
//        var el = document.getElementById('dislike'+id);
//        el.disable();
        $.ajax({
            url: "<@spring.url value = "/dislike"></@spring.url>",
            type: "POST",
            data: {
                id: id
            },
        })
    }
</script>
<title>Пост № ${post.id}</title>
</#macro>
<#macro page_body>
<br><br><br>
<div style="color: black" class="col-lg-10">
    <br><br><br><br>
    <div class="col-lg-12 text-center">
        <h2>Пост № ${post.id}</h2>
        <hr class="star-primary">
    </div>

    <#if post??>
            <div class="panel panel-info">
                <!-- Default panel contents -->
                <div class="panel-heading"><h6>Название: ${post.name}    |    Автор:${post.getOwnerName()}  <span style="color: gray"> - email:${post.getOwnerEmail()} - </span>
                    Рейтинг: ${post.rating}   |
                    Дата: ${post.date}</h6>
                    <#list post.getTags() as tags>
                    <form action="<@spring.url value="/search"/>" method="post">
                        <input type="hidden" name="tagname" value="${tags.name}">
                        <button class="btn-warning">${tags.name}</button>
                    </form>
                    </#list>
                </div>
                <div class="panel-body" style="word-wrap: break-word">
                ${post.text} <br>
                    ____________________<br>

                    <button type="submit" class="btn-info" onclick="like(${post.id})" id="like${post.id}" ><i class="glyphicon glyphicon-thumbs-up" ></i></button> <button type="submit" class="btn-danger" onclick="dislike(${post.id})" id="dislike${post.id}"><i class="glyphicon glyphicon-thumbs-down"></i></button>
                </div>

            </div>
    </#if>
    <br>
    <h4>Комментарии:</h4>
    <#if comments??>
        <#list comments as comments>
            Автор: ${comments.getUserName()}<br>
            ____________________________________________<br>
        ${comments.text}<br>
        ${comments.date}<br>
        </#list>
    </#if><br>
    <h3>Добавить комментарий:</h3>
    <div class="row">
    <div class="col-lg-2" style="padding-bottom: 100px">

    <form action="<@spring.url value = "/post/${post.id}/newcomment"/>" method="post">
        <input type="text" class="form-control" name="text" placeholder="Комментарий" style="height: 200%; width: 300%">
        <button class="btn-info" type="submit">Опубликовать</button>
    </form>
    </div></div>
</div>
<br><br><br><br><br>
</#macro>
<@display_page></@display_page>