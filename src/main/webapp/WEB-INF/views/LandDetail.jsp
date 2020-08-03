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
                        <img style="width: 50%;" src="${requestScope.landResponse.image}"
                             alt="img-detail-land-${requestScope.landResponse.landId}">
                        <h5 style="padding-top: 2%; font-size: xx-large;" class="card-title">
                            Đường ${requestScope.landResponse.street},
                            Phường: ${requestScope.landResponse.ward},
                            Quận: ${requestScope.landResponse.district}</h5>
                        <p style="text-align: justify;" class="card-text">
                            <span style="text-decoration: underline">Chủ sở hữu:
                            </span><span><strong id="i-holder">${requestScope.landResponse.ownerName}</strong> VND</span>
                            <br/>
                            <span style="text-decoration: underline">Giá bán theo VND:
                            </span><span><strong id="i-price">${requestScope.landResponse.price}</strong> VND</span>
                            <br/>
                            <span style="text-decoration: underline">Giá bán theo ETH:
                            </span><span><strong id="i-price-eth">${requestScope.valueEth}</strong> ETH</span> <br/>
                            <br/>
                            <span style="text-decoration: underline">Mô tả chi tiết: <br/> <br>
                            </span><span>${requestScope.landResponse.description}</span> <br/>
                        </p>
                        <a href="/" class="button">Trang chủ</a>
                        <input id="i-btn-buy" type="button" class="button" value="Mua">
                        <div id="i-alert" style="display: none; font-weight: 600;" class="alert alert-danger"
                             role="alert">
                            <strong></strong>
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                        Ngày đăng: ${requestScope.landResponse.createdDate}
                    </div>
                </c:if>

            </div>
            <jsp:include page="Footer.jsp"/>
            <div class="w3-container">
                <div id="i-modal-transfer" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
                        <div id="i-status-success-password" style="display: none">
                            <div class="w3-center"><br>
                                <img id="i-success-icon" style="width: 30%; padding: 14px; display: none;" id="i-img-uploaded-password"
                                     src="/imgs/item-real/status-success.png">
                                <img id="i-fail-icon" style="width: 30%; padding: 14px; display: none;" id="i-img-uploaded-password"
                                     src="/imgs/item-real/alert.png">
                                <h3 id="i-alert-title"></h3>
                                <strong id="i-alert-content"></strong>
                            </div>
                        </div>
                        <div class="w3-section">
                            <div style="display: flex; justify-content: flex-end; padding-right: 10px;">
                                <hr>
                                <button id="i-close-modal-password"
                                        onclick="document.getElementById('i-modal-password').style.display='none'"
                                        type="button"
                                        class="button">Đóng
                                </button>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    // window.addEventListener('load', function() {
    //
    //     // Check if Web3 has been injected by the browser (Mist/MetaMask).
    //     if (typeof web3 !== 'undefined') {
    //         // Use Mist/MetaMask's provider.
    //         web3js = new Web3(web3.currentProvider);
    //         console.log("co metamask");
    //     } else {
    //        console.log("ko co metamask");
    //     }
    //
    // });
    window.addEventListener('load', function () {
        document.getElementById('i-modal-transfer').style.display = "none";
        document.getElementById('i-success-icon').style.display = "none";
        document.getElementById('i-fail-icon').style.display = "none";
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

                                if (objResponse.success === true) {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thành công";
                                    document.getElementById('i-success-icon').style.display = "block";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                } else if (objResponse.success === false && objResponse.strResult == "not-enough-money") {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Tài khoản không đủ tiền để thực hiện giao dịch";
                                    document.getElementById('i-fail-icon').style.display = "block";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                } else if (objResponse.success === false && objResponse.strResult == "not-enough-gas") {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Tài khoản không đủ gas để thực hiện giao dịch";
                                    document.getElementById('i-fail-icon').style.display = "block";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                }else if (objResponse.success === false && objResponse.strResult == "error-system") {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Lỗi hệ thống. Xin quay lại sau.";
                                    document.getElementById('i-fail-icon').style.display = "block";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                }else if (objResponse.success === false) {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Hệ thống giao dịch đang bảo trì. Xin quay lại sau";
                                    document.getElementById('i-fail-icon').style.display = "block";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                }

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
            let objPriceEth = document.getElementById('i-price');
            if (objPriceEth.textContent != "" && !(isNaN(objPriceEth.textContent))) {
                objPriceEth.innerText = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPriceEth.textContent);
            }
        });
    });
</script>
</body>
</html>
