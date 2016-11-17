<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#assign spring=JspTaglibs["http://www.springframework.org/tags"] >
<nav  class="navbar navbar-default navbar-fixed-top navbar-custom">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Speakers </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li class="dropdown" style="color: black">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Связаться с нами<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#" style="color: black"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>   Почта</a></li>
                        <li><a href="#" style="color: black"><i class="glyphicon glyphicon-heart-empty" aria-hidden="true"></i>   Группа ВК</a></li>
                        <li><a href="#" style="color: black"><i class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></i>   Facebook</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" action="/search" method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Введите тему..." name="tagname">
                </div>
                <button type="submit" class="btn btn-default">Поиск</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">О нас</a></li>
            <@sec.authorize access="hasRole('ROLE_ANONYMOUS')">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Вы Анонимус!<span class="caret"></span></a>
                    <ul class="dropdown-menu" >
                        <li><a href="/auth" style="color: black">Авторизоваться</a></li>
                        <li><a href="/reg" style="color: black">Зарегистрироваться</a></li>
                        <li role="separator" class="divider" style="color: black"></li>
                        <li><a href="#" style="color: black">Забыл пароль</a></li>
                    </ul>
                </li>
            </@sec.authorize>
            <@sec.authorize access="hasRole('ROLE_USER')">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><@sec.authentication property="principal.username"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/profile" style="color: black">Мой Кабинет</a></li>
                        <li><a href="/logout" style="color: black">Выйти</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#" style="color: black">Удалить Профиль</a></li>
                    </ul>
                </li>
            </@sec.authorize>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>