<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Sàn giao dịch"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="Header.jsp"/>
            <h1>San giao dich cho admin</h1>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.addEventListener(('load'), function () {
    });

</script>
</body>
</html>
