<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 08/12/17
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part searcher</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            <strong>error:</strong> ${error}
        </div>
    </c:if>
    <div class="row card">
        <form action="/main" method="post" id="part-form" class="form-inline">
            <div class="form-group col-12" style="padding-top: 7px">
                <label for="part-number">PN: </label><input class="form-control" name="number" id="part-number"
                                                            value="${filter.number}"><br/>
                <label for="part-name">Part Name: </label><input name="name" class="form-control" id="part-name"
                                                                 value="${filter.name}"><br/>
                <label for="part-vendor">Vendor: </label><input name="vendor" class="form-control" id="part-vendor"
                                                                value="${filter.vendor}"><br/>
                <label for="part-qty">Qty: </label><input name="qty" id="part-qty" class="form-control"
                                                          value="${filter.getQtyString()}"><br/>
            </div>
            <br/>
            <div class="form-group col-10" style="padding-top: 15px;">
                <strong>Shipped: </strong>
                <label for="part-shipped-after">after -</label>
                <input name="shippedAfter" id="part-shipped-after" class="form-control"
                       value="${filter.getShippedAfterString()}">
                <label for="part-shipped-before">before -</label>
                <input name="shippedBefore" id="part-shipped-before" class="form-control"
                       value="${filter.getShippedBeforeString()}"><br/>
            </div>
            <br/>
            <div class="form-group col-10" style="padding-top: 15px;">
                <strong>Received: </strong>
                <label for="part-received-after">after-</label>
                <input name="receivedAfter" id="part-received-after" class="form-control"
                       value="${filter.getReceivedAfterString()}">
                <label for="part-received-before">before-</label>
                <input name="receivedBefore" id="part-received-before" class="form-control"
                       value="${filter.getReceivedBeforeString()}"><br/>
            </div>
            <div class="form-group col-1">
                <input hidden name="orderByParameter" id="orderByParameter" value="${filter.orderByParameter}">
                <input hidden name="asc" id="asc" value="${filter.asc}">
                <input class="btn btn-info" type="submit" value="filter">
            </div>

        </form>
    </div>
    <table class="table">
        <tr>
            <th><a href="#" onclick="setOrderBy('number')">PN</a></th>
            <th><a href="#" onclick="setOrderBy('name')">Part Name</a></th>
            <th><a href="#" onclick="setOrderBy('vendor')">Vendor</a></th>
            <th><a href="#" onclick="setOrderBy('qty')">Qty</a></th>
            <th><a href="#" onclick="setOrderBy('shipped')">Shipped</a></th>
            <th><a href="#" onclick="setOrderBy('received')">Received</a></th>
        </tr>
        <c:forEach items="${requestScope.partList}" var="part">
            <tr>
                <th>${part.number}</th>
                <th>${part.name}</th>
                <th>${part.vendor}</th>
                <th>${part.qty}</th>
                <th>${part.shipped}</th>
                <th>${part.received}</th>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    var asc = document.getElementById("asc");
    var orderByParameter = document.getElementById("orderByParameter");
    var form = document.getElementById("part-form");
    function setOrderBy(orderBy) {
        orderByParameter.setAttribute("value", orderBy);
        asc.setAttribute("value", !(asc.getAttribute("value") === "true"));
        form.submit();
    }

</script>
</body>
</html>
