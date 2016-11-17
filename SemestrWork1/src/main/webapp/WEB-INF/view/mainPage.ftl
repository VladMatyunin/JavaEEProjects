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
<title>Главная страница</title>

</#macro>
<#macro page_body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="img/profile.png" alt="">
                <div class="intro-text">
                    <span class="name">ХараХабра | Speakers</span>
                    <hr class="star-light">
                    <span class="skills">Сайт для дискуссий и обсуждений</span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Portfolio Grid Section -->
<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Популярные категории</h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="img/portfolio/cabin.png" class="img-responsive" alt="">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="img/portfolio/cake.png" class="img-responsive" alt="">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="img/portfolio/circus.png" class="img-responsive" alt="">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="img/portfolio/game.png" class="img-responsive" alt="">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="img/portfolio/safe.png" class="img-responsive" alt="">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="img/portfolio/submarine.png" class="img-responsive" alt="">
                </a>

            </div>


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
                            <form action="<@spring.url value="/search"/>" method="post">
                                <input type="hidden" name="tagname" value="${tags.name}">
                                <button class="btn-warning">${tags.name}</button>
                            </form>
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