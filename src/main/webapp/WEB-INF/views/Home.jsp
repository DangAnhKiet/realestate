<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="KH REAL ESTATE DAPP"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 wrap-accounts">
            <jsp:include page="Header.jsp"/>
            <div class="home">
            </div>
            <br>

            <div class="row">
                <c:if test="${not empty requestScope.landResponseList}">
                    <c:forEach items="${requestScope.landResponseList}" var="i">
                        <div class="col-sm-12">
                            <div class="card co">
                                <div><img class="card-img-bottom-new" src="${i.image}" alt="Card image cap"></div>
                                <div class="card-body">
                                    <c:if test="${requestScope.role == 'admin'}">
                                        <h5 class="card-title">LandId: <span class="i-land">${i.landId}</span></h5>
                                    </c:if>
                                    <h5 class="card-title">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>
                                    <p class="card-text">${i.street} | ${i.district}</p>
                                    <a style="background-color: #EEA738; border-color: #EEA738;"
                                       href="/land/${i.landId}"
                                       class="btn land-view-detail">Xem chi
                                        tiết</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty requestScope.landResponseList}">
                    <div class="col sm 12">
                        <h4 style="text-align: center; padding-bottom: 20%; padding-top: 10%;">Không tìm thấy bất động
                            sản mới</h4>
                    </div>
                </c:if>
            </div>

            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    let objPrice = document.getElementsByClassName('i-price');
    for (let i = 0; i < objPrice.length; i++) {
        if (objPrice[i].textContent != "" && !(isNaN(objPrice[i].textContent))) {
            objPrice[i].innerText = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice[i].textContent);
        }
    }
    // window.addEventListener('load',function () {
    //
    // });
</script>
</body>
</html>
`