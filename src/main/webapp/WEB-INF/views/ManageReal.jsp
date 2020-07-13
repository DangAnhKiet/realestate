<%--
 Created by IntelliJ IDEA.
 User: hauphvn
 Date: 5/8/2020
 Time: 9:35 AM
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Management Real Estate"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h3 style="text-align: center;margin-top: 14px;">QUẢN LÍ ĐẤT</h3>
            <div class="wrap-address">
                <span><strong>Địa chỉ của admin:</strong>
                <span>0x6787654567545675456754</span>
                </span>
                <input type="button" id="i-update-address" class="btn btn-success" value="Cập nhập">
                <div class="info-user">
                    <span><strong>Phạm văn hậu</strong></span>
                    <img id="i-logout" src="../../imgs/icons/sign-out-alt-solid.svg" alt="">
                </div>
            </div>
            <div class="wrap-adding">
                <div class="wrap-buyer-address">
                    <label>Đại chỉ chủ đất</label>
                    <br/>
                    <input id="i-seller-address" type="text" placeholder="0x000000000000000">
                </div>
                <div class="wrap-select-district">
                    <select id="district" class="ui dropdown select-district">
                        <option value="">Tên quận</option>
                        <option value="1-district">Quận 1</option>
                        <option value="2-district">Quận 2</option>
                        <option value="3-district">Quận 3</option>
                        <option value="4-district">Quận 4</option>
                        <option value="5-district">Quận 5</option>
                    </select>
                </div>
                <div class="wrap-select-street">
                    <select id="street" class="ui dropdown select-district">
                        <option value="">Tên đường</option>
                        <option value="1-street">Cao thắng</option>
                        <option value="2-street">Trần hưng đạo</option>
                        <option value="3-street">Lê lai</option>
                        <option value="4-street">Hoàng văn thụ</option>
                        <option value="5-street">3 tháng 2</option>
                        <option value="6-street">An dương vương</option>
                    </select>
                </div>
                <div class="wrap-price">
                    <lable for="price">Giá bán(VNĐ)</lable>
                    <input id="price-id" type="text" id="price">
                </div>
                <div id="image-id" class="wrap-upload-img">
                    <label for="img">Hình ảnh:</label>
                    <input type="file" id="img" name="img" accept="image/*">
                </div>
                <div style="margin-bottom: 5px;"><input type="button"
                                                        id="i-btn-adding" value="Thêm đất" class="btn btn-primary">
                </div>

            </div>
            <div class="wrap-item">
                <c:forEach items="${listLands}" var="land">
                    <div class="textWithBlurredBg">
                        <img src="${land.image}" alt="hinh-mau">
                        <p id="land-id-${land.landId}"
                           data-address-seller = '${land.addressSeller}'
                           data-district = '${land.district}'
                           data-street = '${land.street}'
                           data-image = '${land.image}'
                           data-price = '${land.price}'
                           data-status = '${land.status}'
                           class="detail" onclick="showDetailInfo(${land.landId})">Xem
                            chi
                            tiết</p>
                        <p class="buy">Mua</p>
                    </div>
                </c:forEach>
            </div>
            <%--            Modal view detail--%>
            <div class="w3-container">
                <div id="i-view-detail" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">

                        <div class="w3-center"><br>
                            <span onclick="document.getElementById('i-view-detail').style.display='none'"
                                  class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                            <img id="spec-image" src="https://loremflickr.com/640/360">
                        </div>

                        <form class="w3-container" action="/action_page.php">
                            <div class="w3-section">
                                <h3>Thông tin chi tiết</h3>
                                <hr>
                                <h5>Giá: <span id="spec-price"></span></h5>
                                <h5>Diện tích</h5>
                                <p>Dài: 4.12m</p>
                                <p>Ngang: 4.12m</p>
                                <p>Nở hậu: 4.12m</p>
                                <p>Tổng diện tích sử dụng: 4.12m</p>
                                <hr>
                                <h5>Vị trí</h5>
                                <p>Đường: <span id="spec-street"></span></p>
                                <p>Phường: <span id="spec-ward"></span></p>
                                <p>Quận: <span id="spec-district"></span></p>
                                <p>Thành phố: Hồ Chí Minh</p>
                                <hr>
                                <h5>Mô tả thêm</h5>
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
        </div>
    </div>
</div>

<script type="text/javascript">
    function showDetailInfo(land){
        <%--data-addressSeller = '${land.addressSeller}'--%>
        <%--data-district = '${land.district}'--%>
        <%--data-street = '${land.street}'--%>
        <%--data-image = '${land.image}'--%>
        <%--data-price = '${land.price}'--%>
        <%--data-status = '${land.status}'--%>
    // <img id="spec-image" src="https://loremflickr.com/640/360">
    //         <p>Đường: <span id="spec-street"></span></p>
    //     <p>Phường: <span id="spec-ward"></span></p>
    //     <p>Quận: <span id="spec-district"></span></p>
        const elemId= "land-id-"+land;
        const elemLand = document.getElementById(elemId);

        let elemStreet = document.getElementById("spec-street").innerText = elemLand.dataset.street;
        let elemDistrict = document.getElementById("spec-district").innerText = elemLand.dataset.district;
        let elemImage = document.getElementById("spec-image").src = elemLand.dataset.image;
        let elemPrice = document.getElementById("spec-price").innerText = elemLand.dataset.price;

        document.getElementById('i-view-detail').style.display = "block";

    }
    document.getElementById("i-btn-adding").addEventListener("click", function () {
        let buyAddress = document.getElementById("i-seller-address").value;
        // alert(buyAddress);
        let d = document.getElementById("district");
        let district = d.options[d.selectedIndex].text;
        let s = document.getElementById("street");
        let street = s.options[s.selectedIndex].text;
        let price = document.getElementById("price-id").value;
        let pathImage = "https://picsum.photos/200/300";
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: 'http://localhost:8080/land/add',
            data: JSON.stringify({
                "addressSeller": buyAddress,
                "district": district,
                "street": street,
                "price": price,
                "image": pathImage
            }),
            success: function (ojbResponse) {
                alert(ojbResponse);
            }
        });
    });
</script>
<jsp:include page="foot_tag.jsp"/>
<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
