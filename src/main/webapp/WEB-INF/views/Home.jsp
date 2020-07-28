    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <jsp:include page="head_tag.jsp">
        <jsp:param name="title" value="KH REAL ESTATE DAPP"/>
        <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
    </jsp:include>
    <body>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <jsp:include page="Header.jsp"/>
                <div style="text-align: center;margin-top: 14px;" class="card-title">
                    <h3>SÀN GIAO DỊCH BẤT ĐỘNG SẢN</h3> <br/> <h4>KH
                    REALESTATE BLOCKCHAIN</h4>
                </div>
                <div style="text-align: center;">
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
                <jsp:include page="Footer.jsp"/>
            </div>
        </div>
    </div>
    </body>
    </html>`