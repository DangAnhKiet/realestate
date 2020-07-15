<%--
  Created by IntelliJ IDEA.
  User: hauphvn
  Date: 7/9/2020
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Trang chủ"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="sticky-top">
                <ul class="nav-home-admin">
                    <li><i class="fa fa-home" aria-hidden="true"></i></li>
                    <li><a href="#">Sàn giao dịch</a></li>
                    <li><a href="#">Quản lí đất</a></li>
                    <li><a href="#">Trợ giúp</a></li>
                    <li class="avatar">
                        <img src="https://i.pravatar.cc/300" alt="Avatar">
                        <ul class="avatar-detail">
                            <li><a href="#">Thông tin cá nhân</a></li>
                            <li><a href="#">Đăng xuất</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="bottom-header">
                <div class="text-center">
                    <h1 class="title">Browser Our Properties</h1>
                    <h4 class="sub-title">An cư lập nghiệp - Xây đắp tương lai</h4>
                </div>
            </div>
            <!--wrap-filter -->
            <br/>
            <form class="wrap-filter">
                <div class="row">
                    <div class="col">
                        <label for="exampleFormControlSelect1">Thành phố</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Quận</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Diện tích</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Giá</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div style="margin-bottom: 5px;"><input type="button"
                                                        id="i-btn-adding" value="Tìm kiếm" class="btn btn-find">
                </div>
            </form>
            <br/>
            <!--           end wrap filter -->
            <!--           wrap card -->
            <div class="wrap-cards">
                <div class="row">
                    <c:forEach items="${listLands}" var="land">
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
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
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text"><span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span></p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
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
            <!--           end wrap card -->
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
</body>
</html>
