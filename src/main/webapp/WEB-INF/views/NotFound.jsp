<%--
  Created by IntelliJ IDEA.
  User: hauphvn
  Date: 7/28/2020
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head_tag.jsp">
        <jsp:param name="title" value="Not found"/>
        <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
    </jsp:include>
</head>
<body id="i-wrap-not-found">
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="Header.jsp"/>
            <div class="error-template">
                <h1>
                    Lỗi!</h1>
                <h2>
                    404 Không tìm thấy trang</h2>
                <div class="error-details">
                    Xin lỗi, đã có lỗi xảy ra trong quá trình xử lí.
                </div>
                <div class="error-actions">
                    <a href=" http://localhost:8084/" class="button"><i class="fa fa-home" aria-hidden="true"></i>
                        Về trang chủ </a>
                    <a href="#" class="button"><i class="fa fa-envelope" aria-hidden="true"></i>  Liên hệ</a>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>
