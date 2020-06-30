<%--
- Đây là trong home của ứng dụng khi chưa đăng nhập
- Show những thông tin để khách hàng tham khảo,
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="KH REAL ESTATE DAPP"/>
    <jsp:param name="link-css-this-page" value="../css/home.css"/>
</jsp:include>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div style="text-align: center;margin-top: 14px;" class="card-title">
                <h3>SÀN GIAO DỊCH BẤT ĐỘNG SẢN</h3> <br/> <h4>KH
                REALESTATE BLOCKCHAIN</h4>
            </div>

            <div class="wrap-login">
                <div class="btn-sign-in">
                    <input type="button" class="btn btn-success" value="Đăng nhập"/>
                </div>
                <div class="btn-sign-up">
                    <input type="button" class="btn btn-primary" value="Đăng kí"/>
                </div>
            </div>
            <div class="wrap-item">
                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail" onclick="document.getElementById('i-view-detail').style.display='block'">Xem chi
                        tiết</p>
                    <p class="buy">Mua</p>
                </div>

                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail">Xem chi tiết</p>
                    <p class="buy">Mua</p>
                </div>

                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail">Xem chi tiết</p>
                    <p class="buy">Mua</p>
                </div>
                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail">Xem chi tiết</p>
                    <p class="buy">Mua</p>
                </div>

                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail">Xem chi tiết</p>
                    <p class="buy">Mua</p>
                </div>
                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail">Xem chi tiết</p>
                    <p class="buy">Mua</p>
                </div>

                <div class="textWithBlurredBg">
                    <img src="imgs/item-real/200.png" alt="hinh-mau">
                    <p class="detail">Xem chi tiết</p>
                    <p class="buy">Mua</p>
                </div>
            </div>

            <%--            Modal view detail--%>
            <div class="w3-container">
                <div id="i-view-detail" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">

                        <div class="w3-center"><br>
                            <span onclick="document.getElementById('i-view-detail').style.display='none'"
                                  class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                            <img src="https://loremflickr.com/640/360">
                        </div>

                        <form class="w3-container" action="/action_page.php">
                            <div class="w3-section">
                                <h3>Thông tin chi tiết</h3>
                                <hr>
                                <h5>Diện tích</h5>
                                <p>Dài: 4.12m</p>
                                <p>Ngang: 4.12m</p>
                                <p>Nở hậu: 4.12m</p>
                                <p>Tổng diện tích sử dụng: 4.12m</p>
                                <hr>
                                <h5>Vị trí</h5>
                                <p>Đường: 227 Nguyễn văn cừ</p>
                                <p>Phường: 5</p>
                                <p>Quận: 5</p>
                                <p>Thành phố: Hồ Chí Minh</p>
                                <hr>
                                <>h5Mô tả thêm</h5>
                                <p>Nhà cách mặt tiền đường lớn 2 căn, nằm trong con hẻm an ninh đường Trần Khắc Chân,
                                    phường Tân Định, quận 1. Con hẻm thông ra Trần Khánh Dư, khu phố rất yên tĩnh,
                                    nhà sát nhà, hàng xóm thuận hòa, đoàn kết.
                                </p>
                            </div>
                        </form>

                        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
                            <button onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="w3-right w3-button w3-red">Đóng
                            </button>
                            <button style="margin-right: 3px;"
                                    onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="w3-right w3-button w3-blue">Mua ngay
                            </button>
                            <%--                            <span class="w3-right w3-padding w3-hide-small"> <a href="#">Mua ngay</a></span>--%>
                        </div>

                    </div>
                </div>
            </div>
            <%--            <div class="wrap-adding">--%>
            <%--                <div class="wrap-select-district">--%>
            <%--                    <select class="ui dropdown select-district">--%>
            <%--                        <option value="">Tên quận</option>--%>
            <%--                        <option value="1-district">Quận 1</option>--%>
            <%--                        <option value="2-district">Quận 2</option>--%>
            <%--                        <option value="3-district">Quận 3</option>--%>
            <%--                        <option value="4-district">Quận 4</option>--%>
            <%--                        <option value="5-district">Quận 5</option>--%>
            <%--                    </select>--%>
            <%--                </div>--%>
            <%--                <div class="wrap-select-street">--%>
            <%--                    <select class="ui dropdown select-district">--%>
            <%--                        <option value="">Tên đường</option>--%>
            <%--                        <option value="">Cao thắng</option>--%>
            <%--                        <option value="">Trần hưng đạo</option>--%>
            <%--                        <option value="">Lê lai</option>--%>
            <%--                        <option value="">Hoàng văn thụ</option>--%>
            <%--                        <option value="">3 tháng 2</option>--%>
            <%--                        <option value="">An dương vương</option>--%>
            <%--                    </select>--%>
            <%--                </div>--%>
            <%--                <div class="wrap-price">--%>
            <%--                    <lable for="price">Giá bán(VNĐ)</lable>--%>
            <%--                    <input type="text" id="price">--%>
            <%--                </div>--%>
            <%--                <div class="wrap-upload-img">--%>
            <%--                    <label for="img">Hình ảnh:</label>--%>
            <%--                    <input type="file" id="img" name="img" accept="image/*">--%>
            <%--                </div>--%>
            <%--                <div style="margin-bottom: 5px;"><input type="button" id="i-btn-adding"value="Đăng bán"class="btn btn-primary"></div>--%>

            <%--            </div>--%>
        </div>
    </div>
</div>
<script src="../../../resources/static/js/home.js"></script>
<jsp:include page="foot_tag.jsp"/>
<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>