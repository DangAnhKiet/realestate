<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Trợ giúp"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 wrap-help">
            <jsp:include page="Header.jsp"/>
            <div class="home">
            </div>
            <br>

            <div class="row">
                <c:if test="${not empty requestScope.listLands}">
                    <c:forEach items="${requestScope.listLands}" var="i">
                        <div class="col-sm-12">
                            <div class="card my-card-home">
                                <img class="card-img-bottom-new" src="${i.image}" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Người bán: <span class="i-price">${i.seller}</span></h5>
                                    <h5 class="card-title">Người mua: <span class="i-price">${i.buyer}</span></h5>
                                    <h5 class="card-title">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>
                                    <h5 class="card-title">Thời gian bán: <span class="i-price">${i.timestamp}</span>
                                        VNĐ</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty requestScope.listLands}">
                    <div class="col sm 12">
                        <h4 style="text-align: center; padding-bottom: 20%; padding-top: 10%;">Không tìm thấy lịch sử
                            giao dịch</h4>
                    </div>
                </c:if>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>

</div>
</body>
</html>