<#include "mainTempl.ftl">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] >
<#macro page_body>
<br><br><br><br><br>
    <@form.form commandName = "regform"  action = "/reg" method = "post" >
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-lg-4">
        <h1 class="form-signin-heading">Регистрация</h1>
                <#if emailExists??> ${emailExists}</#if>
                <label class="checkbox">Имя</label>
        <@form.input path="name" cssClass="form-control"  />
        <@form.errors path="name" cssStyle="color: red;" />
        <label class="checkbox">Фамилия</label>
        <@form.input path="surname" cssClass="form-control"  />
        <@form.errors path="surname" cssStyle="color: red;" />
        <label class="checkbox">Почта</label>
        <@form.input path="email" cssClass="form-control"  />
        <@form.errors path="email" cssStyle="color: red;" />
        <h3>Придумайте пароль</h3>
        <label class="checkbox">Пароль</label>
        <@form.password path="password" cssClass="form-control" />
        <@form.errors path="password" cssStyle="color: red;" />
        <label class="checkbox">Подтвердите Пароль</label>
        <@form.password path="confirmPassword" cssClass="form-control"/>
        <@form.errors path="confirmPassword" cssStyle="color: red;" />
                <#if passwordError??> ${passwordError}</#if>



            </div>
            <div class="col-xs-12 col-sm-12 col-lg-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-1-">
                <br><br>
                <h3 class="dark-grey">Terms and Conditions</h3><br>
                <p>

                    By clicking on "Register" you agree to The Company's' Terms and Conditions
                </p>
                <p>
                    While rare, prices are subject to change based on exchange rate fluctuations -
                    should such a fluctuation happen, we may request an additional payment. You have the option to request a full refund or to pay the new price. (Paragraph 13.5.8)
                </p>
                <p>
                    Should there be an error in the description or pricing of a product, we will provide you with a full refund (Paragraph 13.5.6)
                </p>
                <p>
                    Acceptance of an order by us is dependent on our suppliers ability to provide the product. (Paragraph 13.5.6)
                </p>

                <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
            </div>
    </div>
    </div>
    </@form.form>
<br><br><br><br>
</#macro>
<@display_page>

</@display_page>