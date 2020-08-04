<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Lịch sử giao dịch"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 wrap-accounts">
            <jsp:include page="Header.jsp"/>
            <div class="bg-image">
                <h3 class="title">LỊCH SỬ GIAO DỊCH CHI TIẾT</h3>
            </div>
            <hr>
            <a href="/admin/manage/land">
                <input class="button" value="Quay lại">
            </a>
            <hr>
            <h3 style="text-align: center">DANH SÁCH GIAO DỊCH</h3>
            <c:forEach items="${requestScope.historyLandResponses}" var="historyCurr">
                <div class="card" >
                    <div class="card-header">
                       - Ngày giao dịch: ${historyCurr.timestamp}
                    </div>
                    <div class="card-body" style="display: flex; justify-content: space-between; align-items: center;">

                        <p class="card-text">Người mua: <strong>${historyCurr.buyer}</strong></p>
                        <p class="card-text">Người bán: <strong>${historyCurr.seller}</strong></p>
                        <p class="card-text">Giá giao dịch: <strong>${historyCurr.price}</strong></p>
                        <img style="width: 16rem;" src="${historyCurr.image}" alt="img-land">
                    </div>
                </div>
                <br>
            </c:forEach>
            <c:if test="${empty requestScope.historyLandResponses}">
                <div class="col sm 12">
                    <h4 style="text-align: center; padding-bottom: 20%; padding-top: 10%;">Không tìm thấy thông tin</h4>
                </div>
            </c:if>
            <hr>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
</script>

<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
