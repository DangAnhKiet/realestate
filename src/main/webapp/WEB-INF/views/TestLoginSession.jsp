<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="head_tag.jsp">
        <jsp:param name="title" value="Management Real Estate"/>
        <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
    </jsp:include>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="Header.jsp"/>n
        </div>
    </div>
</div>
<h2>Login list:</h2>
<c:forEach items = "$(listUsers)" var = "i">
<h4>${i}</h4><br>
</c:forEach>
<form action="/persistMessage", method="post">
    Username:
    <input type="text" name="username" placeholder="username"><br>
    Password:
    <input type="password" name="password" placeholder="Password"><br>
    <input type="submit" value="Login"><br>

</form>

<hr>
<form action="/destroy", method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
