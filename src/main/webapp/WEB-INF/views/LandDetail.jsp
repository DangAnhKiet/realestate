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
                        <p style="text-align: justify;" class="card-text">
                            <span style="text-decoration: underline">Giá bán:
                            </span><span><strong id="i-price">${requestScope.landResponse.price}</strong> VNĐ</span> <br/>
                            <span style="text-decoration: underline">Mô tả chi tiết: <br/> <br>
                            </span><span>${requestScope.landResponse.description}</span> <br/>
                        </p>
                        <a href="/" class="button">Trang chủ</a>
                        <input id="i-btn-buy" type="button" class="button" value="Mua">
                        <div id="i-alert" style="display: none; font-weight: 600;" class="alert alert-danger" role="alert">
                            <strong></strong>
                        </div>
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
    window.addEventListener('load', function () {
        // reset alert
        document.getElementById('i-alert').style.display = "none";
        let mySession = '${sessionScope.MY_SESSION}';
        let landCurrent = '${requestScope.addressHolder}';

        let objPrice = document.getElementById('i-price');
        if (objPrice.textContent != "" && !(isNaN(objPrice.textContent))) {
            objPrice.innerText = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice.textContent);
        }

        document.getElementById('i-btn-buy').addEventListener('click', function () {
            if (mySession != "") {
                let jsonSession = JSON.parse(mySession);
                console.log(landCurrent);
                console.log(JSON.stringify(jsonSession));
                console.log(landCurrent == jsonSession.walletAddress);
                if (jsonSession.role == "admin") {
                    document.getElementById('i-alert').innerText = "Chỉ thành viên mới được quyền thực hiện giao dịch mua bán";
                    document.getElementById('i-alert').style.display = "block";
                } else if (jsonSession.role == "member") {
                    if (landCurrent == jsonSession.walletAddress) {
                        document.getElementById('i-alert').innerText = "Bạn đang sở hữu bất động sản này. Không thể thực hiện giao dịc MUA.";
                        document.getElementById('i-alert').style.display = "block";
                    } else {
                        console.log("chayj ajax");
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: 'http://localhost:8084/api/land/transaction',
                            data: JSON.stringify({
                                "address": jsonSession.userLogin,
                                "landId": '${requestScope.landId}'
                            }),
                            success: function (objResponse) {
                                // if (objResponse.success === true && objResponse.strResult.includes("0x")) {
                                //     document.getElementById('address').innerText = objResponse.strResult;
                                //     document.getElementById('i-update-private-key').style.display = "none";
                                //     document.getElementById('i-status-success').style.display = "block";
                                // } else {
                                //     document.getElementById('i-error-content').innerText =
                                //         "Lỗi không thể cập nhật địa chỉ. Xin thử lại một khóa riêng tư khác.";
                                //     document.getElementById('i-content-update').style.display = "none";
                                //     document.getElementById('i-status-fail').style.display = "block";
                                //     document.getElementById('i-update-private-key').style.display = "none";
                                //
                                // }
                            }
                        });
                    }
                }
            } else {
                document.getElementById('i-alert').innerText = "Đăng nhập để thực hiện giao dịch mua bán!";
                document.getElementById('i-alert').style.display = "block";
            }
        });
    });
</script>
</body>
</html>
