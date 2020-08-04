<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Quản lí bất động sản"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 wrap-accounts">
            <jsp:include page="Header.jsp"/>
            <div class="bg-image">
                <h3 class="title">QUẢN LÍ ĐẤT</h3>
            </div>
            <hr>
            <a href="/admin/land/add">
                <input style="width: 315px !important;" class="button" value="ĐĂNG KÍ MỚI BẤT ĐỘNG SẢN">
            </a>
            <hr>
            <h3 style="text-align: center">DANH SÁCH BẤT ĐỘNG SẢN</h3>
            <c:forEach items="${requestScope.landResponses}" var="landCur">
                <div class="card" >
                    <div class="card-header">
                       #${landCur.landId} - Ngày tạo: ${landCur.createdDate}
                    </div>
                    <div class="card-body" style="display: flex; justify-content: space-between; align-items: center;">
                        <h5 class="card-title">Chủ bất động sản: ${landCur.ownerName}</h5>
                        <p class="card-text">${landCur.street} | ${landCur.ward} | ${landCur.district}
                            <span style="font-weight: 600">[${landCur.status}]</span></p>
                        <a  href="/land/history/${landCur.landId}" class="btn btn-primary">Xem lịch sử giao dịch</a>
                        <img style="width: 16rem;" src="${landCur.image}" alt="img-land">
                    </div>

                </div>
                <br>
            </c:forEach>
            <c:if test="${empty requestScope.landResponses}">
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
