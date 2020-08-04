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
                            </span><span><strong id="i-holder">${requestScope.landResponse.ownerName}</strong></span>
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
                <div id="i-modal-transfer" style="display: none" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
                        <div id="i-status-success-password" style="display: none">
                            <div class="w3-center"><br>
                                <img id="i-success-icon" style="width: 12%; padding: 14px; display: none;"
                                     src="/imgs/item-real/status-success.png">
                                <img id="i-fail-icon" style="width: 12%; padding: 14px; display: none;"
                                     src="/imgs/item-real/alert.png">
                                <h3 id="i-alert-title"></h3>
                                <strong id="i-alert-content"></strong>
                            </div>
                        </div>
                        <div class="w3-section">
                            <div style="display: flex; justify-content: flex-end; padding-right: 10px;">
                                <hr>
                                <button id="i-close-modal-password"
                                        onclick="document.getElementById('i-modal-transfer').style.display='none'"
                                        type="button"
                                        class="button">Đóng
                                </button>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--            Modal detail transfer--%>
            <div class="w3-container">
                <div id="i-modal-detail-transfer" style="display: none" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
                        <div style="display: block">
                            <div class="w3-center"><br>
                                <p>Số dư trong ví của bạn: <strong><span id="i-money-owner-wallet">0</span></strong> (ETH)</p>
                                <p>Gía bất động sản sẽ mua: <strong><span id="i-price-land">${requestScope.valueEth}</span></strong> (ETH)</p>
                            </div>
                        </div>
                        <div class="w3-section">
                            <div style="display: flex; justify-content: flex-end; padding-right: 10px;">
                                <hr>
                                <button
                                        onclick="document.getElementById('i-modal-detail-transfer').style.display='none'"
                                        type="button"
                                        class="button">Đóng
                                </button>
                                <button id="i-click-buy-inside"
                                        type="button"
                                        class="button">Mua
                                </button>
                                <hr>
                            </div>
                            <div style="display: none;left: 45%;" id="i-updating-land" class="lds-hourglass"></div>
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
    //         web3 = new Web3();
    //         web3.setProvider(new Web3.providers.HttpProvider('http://localhost:7545'));
    //
    //         web3.eth.sendTransaction({from: web3.eth.accounts[9], to:web3.eth.accounts[1], value: web3.toWei(100, "ether")})
    //     } else {
    //        console.log("ko co metamask");
    //     }
    //
    // });
    // window.addEventListener('load', function () {
    document.getElementById('i-modal-transfer').style.display = "none";
    document.getElementById('i-success-icon').style.display = "none";
    document.getElementById('i-fail-icon').style.display = "none";
    document.getElementById('i-status-success-password').style.display = "none";
    // reset alert
    document.getElementById('i-alert').style.display = "none";
    let mySessionLandDetail = '${sessionScope.MY_SESSION}';
    let landCurrent = '${requestScope.addressHolder}';

    let objPrice = document.getElementById('i-price');
    if (objPrice.textContent != "" && !(isNaN(objPrice.textContent))) {
        objPrice.innerText = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice.textContent);
    }

    document.getElementById('i-btn-buy').addEventListener('click', function () {
        if (mySessionLandDetail != "") {
            let jsonSessionLandDetail = JSON.parse(mySessionLandDetail);
            console.log(landCurrent);
            console.log(JSON.stringify(jsonSessionLandDetail));
            console.log(landCurrent == jsonSessionLandDetail.walletAddress);
            if (jsonSessionLandDetail.role == "admin") {
                document.getElementById('i-alert').innerText = "Chỉ thành viên mới được quyền thực hiện giao dịch mua bán";
                document.getElementById('i-alert').style.display = "block";
            } else if (jsonSessionLandDetail.role == "member") {
                if (landCurrent == jsonSessionLandDetail.walletAddress) {
                    document.getElementById('i-alert').innerText = "Bạn đang sở hữu bất động sản này. Không thể thực hiện giao dịch mua.";
                    document.getElementById('i-alert').style.display = "block";
                } else {
                    getBalance(document.getElementById('i-money-owner-wallet'));
                    document.getElementById('i-modal-detail-transfer').style.display = "block";
                    document.getElementById('i-status-success-password').style.display = "none";
                    document.getElementById('i-click-buy-inside').addEventListener('click', function () {
                        document.getElementById('i-updating-land').style.display = 'block';
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: 'http://localhost:8084/api/land/transaction',
                            data: JSON.stringify({
                                "address": jsonSessionLandDetail.userLogin,
                                "landId": '${requestScope.landId}'
                            }),
                            success: function (objResponse) {
                                document.getElementById('i-updating-land').style.display = 'none';
                                document.getElementById('i-modal-detail-transfer').style.display = "none";
                                if (objResponse.success === true) {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thành công";
                                    document.getElementById('i-success-icon').style.display = "inline";
                                    document.getElementById('i-status-success-password').style.display = "block";
                                    document.getElementById('i-modal-transfer').style.display = "block";

                                } else if (objResponse.success === false && objResponse.strResult == "not-enough-money") {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Tài khoản không đủ tiền để thực hiện giao dịch";
                                    document.getElementById('i-fail-icon').style.display = "inline";
                                    document.getElementById('i-status-success-password').style.display = "inline";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                } else if (objResponse.success === false && objResponse.strResult == "not-enough-gas") {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Tài khoản không đủ gas để thực hiện giao dịch";
                                    document.getElementById('i-fail-icon').style.display = "inline";
                                    document.getElementById('i-status-success-password').style.display = "inline";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                } else if (objResponse.success === false && objResponse.strResult == "error-transfer-eth") {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Lỗi hệ thống thanh toán tiền tệ. Xin quay lại sau.";
                                    document.getElementById('i-fail-icon').style.display = "inline";
                                    document.getElementById('i-status-success-password').style.display = "inline";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                } else if (objResponse.success === false) {
                                    document.getElementById('i-alert-title').innerText = "Giao dịch mua thất bại";
                                    document.getElementById('i-alert-content').innerText = "Hệ thống giao dịch đang bảo trì. Xin quay lại sau";
                                    document.getElementById('i-fail-icon').style.display = "inline";
                                    document.getElementById('i-status-success-password').style.display = "inline";
                                    document.getElementById('i-modal-transfer').style.display = "block";
                                }
                            }
                        });
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
    // });
</script>
</body>
</html>
