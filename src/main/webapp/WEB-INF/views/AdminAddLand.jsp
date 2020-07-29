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
                <h3 class="title">ĐĂNG KÍ BẤT ĐỘNG SẢN</h3>
            </div>
            <br>
            <div class="wrap-address">
                <span><strong>Tài khoản đăng nhập của chủ đất:</strong>
                </span>
                <input style="margin: 0px 0px 5px 14px; border-radius: 6px; padding: 5px;" id="i-username" type="text" placeholder="phamvana...">
                <input type="button" id="i-btn-update-address" class="button" value="Lấy địa chỉ ví">
                <div id="i-alert-username" style="display: none" class="alert alert-danger" role="alert">
                    <span id="i-alert-username-content"></span>
                </div>
            </div>
            <div class="wrap-adding">
                <div style="width: 35%;" class="row">
                    <div class="col-md-12">
                        <div class="wrap-buyer-address">
                            <label>Đại chỉ chủ đất</label>
                            <br/>
                            <input id="i-seller-address" type="text" placeholder="0x000000000000000">
                        </div>
                        <div class="wrap-select-city">
                            <select id="city" class="ui dropdown select-city" required>
                                <option value="">Thành phố</option>
                                <option value="1-city">Hà nội</option>
                                <option value="2-city">Hồ chí minh</option>
                            </select>
                        </div>
                        <div class="wrap-select-district">
                            <select id="i-select-district" class="ui dropdown select-district" required>
                                <option value="">Tên quận</option>
                                <option value="1-district">Quận 1</option>
                                <option value="2-district">Quận 2</option>
                                <option value="3-district">Quận 3</option>
                                <option value="4-district">Quận 4</option>
                                <option value="5-district">Quận 5</option>
                                <option value="6-district">Quận 6</option>
                                <option value="7-district">Quận 7</option>
                                <option value="8-district">Quận 8</option>
                                <option value="9-district">Quận 9</option>
                                <option value="10-district">Quận 10</option>
                                <option value="11-district">Quận 11</option>
                                <option value="12-district">Quận 12</option>
                                <option value="thuduc-district">Quận thủ đức</option>
                                <option value="govap-district">Quận gò vấp</option>
                                <option value="binhthanh-district">Quận bình thạnh</option>
                                <option value="tanbinh-district">Quận tân bình</option>
                                <option value="tanphu-district">Quận tân phú</option>
                                <option value="phunhuan-district">Quận phú nhuận</option>
                                <option value="binhtan-district">Quận bình tân</option>
                                <option value="cuchi-district">Huyện củ chi</option>
                                <option value="hocmon-district">Huyện hóc môn</option>
                                <option value="binhchanh-district">Huyện bình chánh</option>
                                <option value="nhabe-district">Huyện nhà bè</option>
                                <option value="1-district">Ba Đình</option>
                                <option value="2-district">Bắc Từ Liêm</option>
                                <option value="3-district">Cầu Giấy</option>
                                <option value="4-district">Đống Đa</option>
                                <option value="5-district">Hà Đông</option>
                                <option value="6-district">Hai Bà Trưng</option>
                                <option value="7-district">Hoàn Kiếm</option>
                                <option value="8-district">Hoàng Mai</option>
                                <option value="9-district">Long Biên</option>
                                <option value="10-district">Nam Từ Liêm</option>
                                <option value="11-district">Tây Hồ</option>
                                <option value="12-district">Thanh Xuân</option>
                            </select>
                        </div>
                        <div class="wrap-select-ward">
                            <select id="i-select-ward" class="ui dropdown select-district" required>
                                <option value="">Tên phường</option>
                                <option value="1-street">Tân định</option>
                                <option value="2-street">Đa cao</option>
                                <option value="3-street">Phường 3</option>
                                <option value="4-street">Phường 2</option>
                                <option value="5-street">Phường 4</option>
                                <option value="6-street">Phú hữu</option>
                            </select>
                        </div>
                        <div class="wrap-select-street">
                            <select id="i-select-street" class="ui dropdown select-district" required>
                                <option value="">Tên đường</option>
                                <option value="1-ward">Cao thắng</option>
                                <option value="2-ward">Trần hưng đạo</option>
                                <option value="3-ward">Lê lai</option>
                                <option value="4-ward">Hoàng văn thụ</option>
                                <option value="5-ward">3 tháng 2</option>
                                <option value="6-ward">An dương vương</option>
                            </select>
                        </div>
                        <div class="wrap-buyer-address">
                            <label>Giá bán (VNĐ):</label>
                            <br/>
                            <input id="i-price" type="text" placeholder="1000000000">
                        </div>
                        <!--Material textarea-->
                        <div class="form-group">
                            <label for="i-desc">Mô tả thêm thông tin</label>
                            <textarea class="form-control" id="i-desc" rows="6"></textarea>
                        </div>
                        <div id="image-id" class="wrap-upload-img">
                            <form id="fileUploadForm" method="post" enctype="multipart/form-data">
                                <input style="margin-bottom: 12px;margin-top: 10px;" type="button" id="imgUpload" value="Chọn ảnh"
                                       onclick="document.getElementById('i-img-file').click();"/>
                                <input type="file" style="display:none;" id="i-img-file" name="file" accept="image/*" required/>
                                <input type="text" id="i-hash-img" style="display: none" value="">
                            </form>
                            <p id="i-choose-image" style="font-weight: 600; display: none;margin-bottom: 36px;">Ảnh đã chọn: <span
                                    id="span-choose-image"></span></p>
                            <div id="i-alert-upload-img" style="margin-bottom: 42px; display: none;" class="alert alert-danger" role="alert">
                                Lỗi kích thước ảnh quá lớn hoặc sai định dạng ảnh(png, jpg).
                            </div>
                        </div>
                        <div id="i-alert-fullfill" style="display: none;" class="alert alert-danger" role="alert">
                            Vui lòng nhập đầy đủ thông tin.
                        </div>
                        <div class="nav-btn">
                            <div class="back">
                                <a href="/admin/manage/land">
                                    <div style="text-align: end;">
                                        <input type="button" value="Quay lại" class="button">
                                    </div>
                                </a>
                            </div>
                            <div style="text-align: end;">
                                <input type="button" id="i-btn-adding" value="Thêm đất" class="button">
                            </div>
                        </div>
                        <div style="display: none;left: 45%;" id="i-updating-land" class="lds-hourglass"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
</div>
<%--            Modal view detail--%>
<div class="w3-container">
    <div id="i-view-detail" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
            <div class="w3-center"><br>
                <h3>Đăng bất động sản thành công</h3>
                <span onclick="document.getElementById('i-view-detail').style.display='none'"
                      class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                <img style="width: 100%; padding: 14px;" id="i-img-uploaded" src="/imgs/item-real/200.png">
            </div>
            <form class="w3-container">
                <div class="w3-section">
                    <hr>
                    <h5>Gía bán: <span id="i-price-uploaded"></span></h5>
                    <h5>Vị trí</h5>
                    <p>Đường: <span id="i-street-uploaded"></span></p>
                    <p>Phường: <span id="i-ward-uploaded"></span></p>
                    <p>Quận: <span id="i-district-uploaded"></span></p>
                    <p>Thành phố: <span id="i-city-uploaded"></span></p>
                    <hr>
                    <h5>Mô tả chi tiết</h5>
                    <p id="i-desc-uploaded">
                    </p>
                </div>
            </form>
            <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
                <button onclick="document.getElementById('i-view-detail').style.display='none'"
                        type="button"
                        class="w3-right w3-button button">Đóng
                </button>
            </div>
        </div>
    </div>
</div>
<%--End modal land detail--%>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", () => {
        turnOffAllAlert();
    });
    let objNameChooseFileToUpload = document.getElementById('span-choose-image');
    let objUsernameLogin = document.getElementById('i-username');
    let objUpdateAddress = document.getElementById('i-btn-update-address');
    let objAlertUsername = document.getElementById('i-alert-username');
    let objAlertUsernameContent = document.getElementById('i-alert-username-content');
    let objHolderAddress = document.getElementById('i-seller-address');
    let objBtnAddingLand = document.getElementById('i-btn-adding');
    let objInputPrice = document.getElementById('i-price');
    let objSelectStreet = document.getElementById('i-select-street');
    let objSelectWard = document.getElementById('i-select-ward');
    let objSelectDistrict = document.getElementById('i-select-district');
    let objAlertFullfill = document.getElementById('i-alert-fullfill');
    let objInputUploadImage = document.getElementById('i-img-file');
    let objAlertUploadImg = document.getElementById('i-alert-upload-img');
    let objTextAreaDescription = document.getElementById('i-desc');
    let objHashImg = document.getElementById('i-hash-img');
    let objChooseImge = document.getElementById('i-choose-image');
    let objStreetUploaded = document.getElementById('i-street-uploaded');
    let objDescUploaded = document.getElementById('i-desc-uploaded');
    let objWardUploaded = document.getElementById('i-ward-uploaded');
    let objDistrictUploaded = document.getElementById('i-district-uploaded');
    let objImgUploaded = document.getElementById('i-img-uploaded');
    let objPriceUploaded = document.getElementById('i-price-uploaded');
    let objShowPopStatusUploadLand = document.getElementById('i-view-detail');
    let objUpdatingLand = document.getElementById('i-updating-land');

    function turnOffAllAlert() {
        objAlertUsername.style.display = "none";
        objAlertFullfill.style.display = "none";
        objAlertUploadImg.style.display = "none";
        objChooseImge.style.display = "none";
        objShowPopStatusUploadLand.style.display = "none";

        objUpdatingLand.style.display = "none";
        // objBtnAddingLand.style.backgroundColor = "#ddd";
        objBtnAddingLand.style.backgroundColor = "#007bff";
        objBtnAddingLand.disabled = false;
    }


    objInputUploadImage.addEventListener('change', function (e) {
        let fileName = e.target.files[0].name;
        document.getElementById('span-choose-image').innerText = fileName;
        objChooseImge.style.display = "block";
        if (objInputUploadImage.value != "") {
            console.log(objInputUploadImage.value);
            // Get form
            let form = $('#fileUploadForm')[0];
            let data = new FormData(form);
            data.append("CustomField", "This is some extra data, testing");
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8084/api/ipfs/img/update",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (response) {
                    if (response != null || response != "") {
                        console.log("Upload img land thanh cong. hash img: " + response);
                        objHashImg.value = response;
                    } else {
                        objAlertUploadImg.style.display = "block";
                    }
                },
                error: function (e) {
                    console.log("Loi upload anh");
                    objAlertUploadImg.style.display = "block";
                }
            });
        }
    });
    objInputPrice.addEventListener('change', function () {
        if (objInputPrice.value != "" && !(isNaN(objInputPrice.value))) {
            objInputPrice.value = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objInputPrice.value);
        }
    });
    objBtnAddingLand.addEventListener('click', function () {
        // if (objTextAreaDescription.value == "") {
        //     objTextAreaDescription.value = "";
        // }
        if (objHolderAddress.value != "" &&
            objInputPrice.value != "" &&
            objSelectStreet.value != "" &&
            objSelectWard.value != "" &&
            objSelectDistrict.value != "" &&
            objInputUploadImage.value != "") {
            objUpdatingLand.style.display = "block";
            objBtnAddingLand.style.backgroundColor = "#ddd";
            // objBtnAddingLand.style.backgroundColor = "#007bff";
            objBtnAddingLand.disabled = true;
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: 'http://localhost:8084/api/land/add',
                data: JSON.stringify({
                    "addressSeller": objHolderAddress.value,
                    "district": objSelectDistrict.options[objSelectDistrict.selectedIndex].text,
                    "street": objSelectStreet.options[objSelectStreet.selectedIndex].text,
                    "price": objInputPrice.value.split(".").join(""),
                    "description": objTextAreaDescription.value,
                    "ward": objSelectWard.options[objSelectWard.selectedIndex].text,
                    "pathImage": objHashImg.value
                }),
                success: function (objResponse) {
                    objUpdatingLand.style.display = "none";
                    if (objResponse.success === true) {
                        console.log(objSelectDistrict.options[objSelectDistrict.selectedIndex].text);
                        objDistrictUploaded.innerText = objSelectDistrict.options[objSelectDistrict.selectedIndex].text;
                        objStreetUploaded.innerText = objSelectStreet.options[objSelectStreet.selectedIndex].text;
                        objPriceUploaded.innerText = objInputPrice.value;
                        objDescUploaded.innerText = objTextAreaDescription.value;
                        objWardUploaded.innerText = objSelectWard.options[objSelectWard.selectedIndex].text;
                        objImgUploaded.src = objHashImg.value;
                        objShowPopStatusUploadLand.style.display = "block";

                        objUpdatingLand.style.display = "none";
                        // objBtnAddingLand.style.backgroundColor = "#ddd";
                        objBtnAddingLand.style.backgroundColor = "#007bff";
                        objBtnAddingLand.disabled = false;
                    }
                },
                error: function () {
                    console.log("Loi add land");
                }
            });
        } else {
            objAlertFullfill.style.display = "block";
        }
    });

    objUpdateAddress.addEventListener('click', function () {
        let username = objUsernameLogin.value;
        if (username != "") {
            objAlertUsername.style.display = "none";
            $.ajax({
                type: "POST",
                // contentType: "application/json",
                url: 'http://localhost:8084/api/account/get/name',
                data: {name: username},
                success: function (objResponse) {
                    if (objResponse !== "") {
                        objHolderAddress.value = objResponse;
                    } else {
                        objAlertUsernameContent.innerText = "Tài khoản đăng nhập không tồn tại";
                        objAlertUsername.style.display = "block";
                    }
                }
            });
        } else {
            objAlertUsernameContent.innerText = "Nhập tài khoản đăng nhập của chủ bất động sản";
            objAlertUsername.style.display = "block";
        }
    });


</script>
<jsp:include page="foot_tag.jsp"/>
<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
