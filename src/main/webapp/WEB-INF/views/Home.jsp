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
                <c:forEach items="${requestScope.landResponseList}" var="i">
                    <div class="col-sm-6">
                        <div class="card my-card-home">
                            <img class="card-img-top" src="${i.image}" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>
                                <p class="card-text">${i.street} | ${i.district}</p>
                                <a style="background-color: #EEA738; border-color: #EEA738;" href="/land" class="btn">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.addEventListener('load',function () {
        let objPrice = document.getElementsByClassName('i-price');
        for(let i = 0; i < objPrice.length; i++){
            if (objPrice[i].textContent != "" && !(isNaN(objPrice[i].textContent))) {
                objPrice[i].innerText  = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice[i].textContent);
            }
        }
    });
</script>
</body>
</html>
`