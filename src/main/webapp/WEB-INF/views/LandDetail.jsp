<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Thông tin chi tiết"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="Header.jsp"/>
            <div style="margin-top: 2%;" class="card text-center">
                <div class="card-header">
                   Thông tin chi tiết
                </div>
                <c:if test="${requestScope.isNull == true}">
                    <div class="card-body">
                        <h5 class="card-title">Không tìm thấy sản phẩm</h5>
                        <a href="/" class="button">Trang chủ</a>
                    </div>
                </c:if>
                <c:if test="${requestScope.isNull == false}">
                    <div class="card-body">
                        <img src="${requestScope.landResponse.image}" alt="img-detail-land-${requestScope.landResponse.landId}">
                        <h5 style="padding-top: 2%; font-size: xx-large;" class="card-title">Đường ${requestScope.landResponse.street},
                            Phường: ${requestScope.landResponse.ward},
                                 Quận: ${requestScope.landResponse.district}</h5>
                        <p  style="text-align: justify;" class="card-text">
                            <span style="text-decoration: underline">Giá bán:
                            </span><span><strong id="i-price">${requestScope.landResponse.price}</strong> VNĐ</span> <br/>
                            <span style="text-decoration: underline">Mô tả chi tiết: <br/> <br>
                            </span><span>${requestScope.landResponse.description}</span> <br/>
                        </p>
                        <a href="/" class="button">Trang chủ</a>
                        <a href="#" class="button">Mua</a>
                    </div>
                    <div class="card-footer text-muted">
                        Ngày đăng: ${requestScope.landResponse.createdDate}
                    </div>
                </c:if>

            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.addEventListener('load',function () {
        let objPrice = document.getElementById('i-price');
            if (objPrice.textContent != "" && !(isNaN(objPrice.textContent))) {
                objPrice.innerText  = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice.textContent);
            }
    });
</script>
</body>
</html>
