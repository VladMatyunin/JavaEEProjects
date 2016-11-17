<!doctype html>
<html>
<head>
    <#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
    <#assign spring=JspTaglibs["http://www.springframework.org/tags"] >
    <link rel="stylesheet" href="/css/bootstrap.min.css" >
    <script src="/js/jquery-1.11.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <title>Авторизация</title>
</head>
<body class="body">
<style>
    .btn-label {position: relative;left: -12px;display: inline-block;padding: 6px 12px;background: rgba(0,0,0,0.15);border-radius: 3px 0 0 3px;}
    .btn-labeled {padding-top: 0;padding-bottom: 0;}
    .input-group { margin-bottom:10px; }
    .separator { border-right: 1px solid #dfdfe0; }
    .facebook,.twitter { min-width:170px; }
    .facebook { background-color:#354E84;color:#fff; }
    .twitter { background-color:#00A5E3;color:#fff; }
    .facebook:hover,.twitter:hover { color:#fff;
     }
    .body{background-color: rgba(87, 103, 255, 0.28)}

</style>
<br><br>
<form action="/login" method="post" role="form">
<div class="container">
    <div class="row" style="float:none; margin: 0 auto">
        <div class="col-xs-12 col-sm-12 col-lg-5 col-xs-offset-3 col-sm-offset-3 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Авторизация на сайте</h3>
                </div>

                <div class="panel-body">
                    <div class="row">

                        <div class="col-xs-11 col-sm-11 col-md-11 login-box">

                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" name="email" class="form-control" placeholder="Email пользователя" required autofocus />
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                    <input type="password" class="form-control" name="password" placeholder="Ваш пароль" required />
                                </div>
                                <p>
                                    <#if error??>
                                    <span style="color: red">${error}</span>
                                    </#if>
                                    <a href="#">Забыли свой пароль?</a></p>
                                У вас нет аккаунта? <a href="#">Регистрация</a>

                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="Remember">
                                    Запомнить меня
                                </label>
                            </div>
                        </div>
                        <div class="col-xs-8 col-sm-8 col-md-8">
                            <button type="submit" class="btn btn-labeled btn-success">
                                <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Войти</button>

                            <button type="button" class="btn btn-labeled btn-info" onclick="location.href='/main'">
                                <span class="btn-label"><i class="glyphicon glyphicon-chevron-left"></i></span>На главную</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>


