<#include "mainTempl.ftl">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] >
<#macro page_head>
<title>Мой профиль</title>
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
            success: function () {
                return true;
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
            success: function () {
                return true;
            }
        })
    }
</script>
</#macro>
<#macro page_body>
<br><br><br><br><br>
    <#if user??>
    <div class="row">
        <div class="pull-right" style="padding-right: 90px;padding-left: 30px; padding-bottom: 30px; background-color: #2C3E50; color: whitesmoke">
        <i class="glyphicon glyphicon-ok"></i>  <strong>${user.name}</strong><br>
            <i class="glyphicon glyphicon-ok"></i>  <strong>${user.surname}</strong><br>
            <i class="glyphicon glyphicon-ok"></i>  <strong>${user.email}</strong><br>
            <i class="glyphicon glyphicon-star"></i> - ${user.rating}<br>
            <div class="progress">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="${user.rating+50}" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                    <span class="sr-only">Complete</span>
                </div>
            </div>
            <button type="button" class="btn btn-labeled btn-info" onclick="location.href='/main'"">
            <span class="btn-label"><i class="glyphicon glyphicon-chevron-left"></i></span>На главную</button> <br>
        </div>
    <div style="color: black">

        <div class="container">

                <div class="col-xs-7 col-sm-7 col-md-7">

        <div class="col-lg-8 text-center">
                <h2>Ваши посты</h2>
                <hr class="star-primary">
            </div><br><br><br><br><br>
        <#if user.posts??>
            <#list user.posts as allposts>
                <div class="panel panel-info">
                    <!-- Default panel contents -->
                    <div class="panel-heading"><h6>Название: ${allposts.name}    |    Автор:${allposts.getOwnerName()}  <span style="color: gray"> - email:${allposts.getOwnerEmail()} - </span>
                        Рейтинг: ${allposts.rating}   |
                        Дата: ${allposts.date}</h6>
                        <#list allposts.getTags() as tags>
                            <form action="<@spring.url value="/search"/>" method="post">
                                <input type="hidden" name="tagname" value="${tags.name}">
                                <button class="btn-warning">${tags.name}</button>
                            </form>
                        </#list>
                    </div>
                    <div class="panel-body" style="word-wrap: break-word">
                    ${allposts.text} <br>
                        ___________<br>
                        <form action="<@spring.url value = "/post/${allposts.id}"/>" method="get"><button type="submit" class="btn-warning"><i class="glyphicon glyphicon-comment"></i></button></form>
                    </div>
                </div>
            </#list>
        </#if>
        <br>
        </div>
            </div> </div>
    </div>
    </#if>
<br>

<div class="container">
    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6">
            <form action="profile/newpost" method="post">
            <input type="text" class="form-control" name="name" size="20" placeholder="Название поста.."><br>
            <textarea type="text" class="form-control" name="text" size="6000" placeholder="Текст.."></textarea><br>
            <select multiple class="select-picker form-control" name="tags" required style="width: 30%">
                <#if tags??>
                    <#list tags as tags>
                        <option>${tags.name}</option>
                    </#list>
                </#if>
            </select><br>
            <button class="btn-info" type="submit">Отправить</button>
            </form>
        </div>
</div>
</div>
<br><br><br><br><br>
</#macro>
<@display_page/>