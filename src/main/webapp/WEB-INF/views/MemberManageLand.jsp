<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Management Real Estate"/>
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
            <br>
            <div class="row">
                <c:forEach items="${requestScope.listLands}" var="i">
                    <div class="col-sm-6">
                        <div class="card my-card-home">
                            <img style="width: 100% !important;" class="card-img-bottom-new" src="${i.pathImage}" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>
                                <p class="card-text">${i.street} | ${i.district}</p>
                                <a style="background-color: #EEA738; border-color: #EEA738;" href="/landn/${i.landId}"
                                   class="btn land-view-detail">Xem
                                    chi tiết</a>
                                <c:if test="${i.status == 'active'}">
                                    <a style="background-color: #EEA738; border-color: #EEA738;"
                                       href="/update/${i.landId}"
                                       class="btn land-view-detail">không công khai</a>
                                </c:if>
                                <c:if test="${i.status == 'pending'}">
                                    <a style="background-color: #EEA738; border-color: #EEA738;"
                                       href="/update/${i.landId}"
                                       class="btn land-view-detail">công khai</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
</div>
<script type="text/javascript">
    window.addEventListener('load', function () {
        let objPrice = document.getElementsByClassName('i-price');
        for (let i = 0; i < objPrice.length; i++) {
            if (objPrice[i].textContent != "" && !(isNaN(objPrice[i].textContent))) {
                objPrice[i].innerText = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice[i].textContent);
            }
        }
    });
</script>


<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
