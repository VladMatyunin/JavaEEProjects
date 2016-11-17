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
            },

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
<title>Поиск</title>

</#macro>
<#macro page_body>
<!-- Portfolio Grid Section -->
<section id="portfolio">
    <div class="container">

        <div class="row">

        </div>
        <div style="color: black" class="col-lg-10">
            <div class="col-lg-12 text-center">
                <h2>Все посты</h2>
                <hr class="star-primary">
            </div>
            <br><br><br><br>
            <#if Posts??>
                <#list Posts as allposts>
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading"><h6>Название: ${allposts.name}    |    Автор:${allposts.getOwnerName()}  <span style="color: gray"> - email:${allposts.getOwnerEmail()} - </span>
                            Рейтинг: ${allposts.rating}   |
                            Дата: ${allposts.date}</h6>
                            <#list allposts.getTags() as tags>
                                <button class="btn-warning">${tags.name}</button>
                            </#list>
                        </div>
                        <div class="panel-body" style="word-wrap: break-word">
                        ${allposts.text} <br>
                            ____________________<br>
                            <@sec.authorize access="hasRole('ROLE_USER')">
                                <button type="submit" class="btn-info" onclick="like(${allposts.id})" id="like${allposts.id}" ><i class="glyphicon glyphicon-thumbs-up" ></i></button> <button type="submit" class="btn-danger" onclick="dislike(${allposts.id})" id="dislike${allposts.id}"><i class="glyphicon glyphicon-thumbs-down"></i></button>
                            </@sec.authorize>
                            <form action="<@spring.url value = "/post/${allposts.id}"/>" method="get"><button type="submit" class="btn-warning"><i class="glyphicon glyphicon-comment"></i></button></form>
                        </div>
                    </div>
                </#list>
            </#if>
            <br>
        </div>
    </div>

</section>

</#macro>
<@display_page/>