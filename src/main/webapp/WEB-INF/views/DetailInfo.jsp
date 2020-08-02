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

            <div class="card mb-3">
                <div class="wrap-img-detail">
                    <img class="card-img-top" src="/imgs/item-real/metro-background.png" alt="Card image cap">
                    <img id="i-main-avatar" class="avatar" src="/imgs/item-real/avatar-default.png"
                         alt="Avatar">
                    <div id="openUpload" class="wrap-icon-photograph">
                        <div class="img"><img src="/imgs/icons/photograph.png" alt=""></div>
                    </div>
                </div>
                <div class="card-body">
                    <h5 class="card-title">Thông tin cá nhân: <span></span></h5>
                    <p class="card-text"><span class="my-card-text">Họ tên:</span> <span id="name"></span></p>
                    <p class="card-text"><span class="my-card-text">Tài khoản đăng nhập:</span><span id="login"></span>
                    </p>
                    <p class="card-text"><span class="my-card-text">Mật khẩu: </span><span class="alert alert-warning"
                                                                                           id="pass"></span>
                        <button id="i-btn-update-password" class="button-spec">CẬP NHẬT MẬT KHẨU</button>

                    </p>
                    <p class="card-text"><span class="my-card-text">Điện thoại:</span> <span id="phone"></span></p>
                    <p class="card-text"><span class="my-card-text">Địa chỉ ví tiền:</span><span
                            class="alert alert-warning" id="address"></span>
                        <button id="i-btn-update" class="button-spec">CẬP NHẬT KHÓA</button>
                    </p>
                    <p class="card-text">Địa chỉ email: <span id="email"></span></p>
                    <%--                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
                </div>
            </div>
            <%--            Popup update img--%>
            <div class="w3-container">
                <div id="i-view-detail" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">

                        <div class="w3-center"><br>
                            <span onclick="document.getElementById('i-view-detail').style.display='none'"
                                  class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                            <img style="width: 100px;" src="/imgs/item-real/alert.png">
                        </div>
                        <div class="w3-section w3-center">
                            <h3>Cập nhật ảnh đại diện <span id="img-title" style="font-weight: 600;"></span></h3>
                            <form id="fileUploadForm" method="post" enctype="multipart/form-data">
                                <input style="margin-bottom: 12px;" type="button" id="imgUpload" value="Chọn ảnh"
                                       onclick="document.getElementById('i-file').click();"/>
                                <input type="file" style="display:none;" id="i-file" name="myImage"
                                       accept="image/*"/>
                                <input type="text" name="myAccount" id="i-account-form"
                                       style="display:
                                none">
                                <input type="submit" style="display: none" id="btnSubmit">
                            </form>
                            <p id="i-choose-image" style="font-weight: 600; display: none;">Ảnh đã chọn: <span id="span-choose-image"></span></p>
                            <div style="display: none;left: 45%;" id="i-updating-land" class="lds-hourglass"></div>
                            <span class="alert alert-danger" id="i-alert-upload-img" style="display: none"></span>
                        </div>

                        <div style="text-align: right; padding-right: 10px;">
                            <hr>
                            <button onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="button">Đóng
                            </button>
                            <button id="btn-agree-update-img" style="margin-right: 3px;"
                                    type="button"
                                    class="button">Đồng ý
                            </button>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
            <%--            end popup update img--%>
            <%--            Modal update private key--%>
            <div class="w3-container">
                <div id="i-modal" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
                        <div id="i-content-update">
                            <div class="w3-center"><br>
                                <h3>Cập nhật địa chỉ ví</h3> <br>
                                <strong>Nhập khóa riêng tư của ví</strong>
                                <input style="width: 66%; margin-bottom: 2px;" id="i-private-key-input" type="text"
                                       placeholder="a443868280953e8......">
                                <p style="display: none" id="i-p-alert-private-key" class="alert alert-danger"></p>
                            </div>
                        </div>
                        <div id="i-status-success" style="display: none">
                            <div class="w3-center"><br>
                                <h3>Cập nhật địa chỉ ví thành công</h3>
                                <img style="width: 30%; padding: 14px;" id="i-img-uploaded"
                                     src="/imgs/item-real/status-success.png">
                            </div>
                        </div>
                        <div id="i-status-fail" style="display: none">
                            <div class="w3-center"><br>
                                <img style="width: 100px;" src="/imgs/item-real/alert.png">
                            </div>
                            <div class="w3-section w3-center">
                                <p><span id="i-error-content" style="font-weight: 600;"></span></p>
                            </div>
                        </div>
                        <div class="w3-section">
                            <div style="display: flex; justify-content: flex-end; padding-right: 10px;">
                                <hr>
                                <button id="i-close-modal"
                                        onclick="document.getElementById('i-modal').style.display='none'"
                                        type="button"
                                        class="button">Đóng
                                </button>
                                <button id="i-update-private-key" style="margin-right: 3px;"
                                        type="button"
                                        class="button">Cập nhật
                                </button>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--        End popup--%>
            <%--            Modal update password--%>
            <div class="w3-container">
                <div id="i-modal-password" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
                        <div id="i-content-update-password">
                            <div class="w3-center"><br>
                                <h3>Cập nhật mật khẩu</h3> <br>
                                <strong>Nhập mật khẩu cũ</strong>
                                <input style="width: 66%; margin-bottom: 2px;" id="i-password-key-input" type="text"
                                       placeholder="mat khau cu...">
                                <br/>
                                <strong>Nhập mật Khẩu mới</strong>
                                <input style="width: 66%; margin-bottom: 2px;" id="i-password-key-input-new" type="text"
                                       placeholder="mat khau moi...">
                                <br/>
                                <strong>Nhập lại mật Khẩu mới</strong>
                                <input style="width: 66%; margin-bottom: 2px;" id="i-password-key-input-new-again"
                                       type="text"
                                       placeholder="mat lai khau moi...">
                                <p style="display: none" id="i-p-alert-password-key" class="alert alert-danger"></p>
                            </div>
                        </div>
                        <div id="i-status-success-password" style="display: none">
                            <div class="w3-center"><br>
                                <h3>Cập nhật mật khẩu thành công</h3>
                                <img style="width: 30%; padding: 14px;" id="i-img-uploaded-password"
                                     src="/imgs/item-real/status-success.png">
                            </div>
                        </div>
                        <div id="i-status-fail-password" style="display: none">
                            <div class="w3-center"><br>
                                <img style="width: 100px;" src="/imgs/item-real/alert.png">
                            </div>
                            <div class="w3-section w3-center">
                                <p><span id="i-error-content-password" style="font-weight: 600;"></span></p>
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
                                <button id="i-update-password" style="margin-right: 3px;"
                                        type="button"
                                        class="button">Cập nhật
                                </button>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--        End popup--%>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">

    let stringSession = ${sessionScope.MY_SESSION};

    window.addEventListener(('load'), function () {

        document.getElementById('name').innerText = stringSession.fullName.toUpperCase();
        document.getElementById('login').innerText = stringSession.userLogin;
        document.getElementById('i-account-form').value = stringSession.userLogin;
        document.getElementById('pass').innerText = "******";
        if (stringSession.walletAddress == 'update') {
            document.getElementById('address').innerText = "Bạn cần cập nhật địa chỉ ví để có thể giao dịch mua bán.";
        }else{
            document.getElementById('address').innerText = stringSession.walletAddress;
        }
        document.getElementById('phone').innerText = stringSession.numberPhone;
        document.getElementById('email').innerText = stringSession.email;

        //Update private key
        let objButtonUpdatePrivateKey = document.getElementById('i-update-private-key');
        objButtonUpdatePrivateKey.addEventListener('click', function () {
            document.getElementById('i-p-alert-private-key').style.display = "none";
            if (document.getElementById('i-private-key-input').value.length != 64) {
                document.getElementById('i-p-alert-private-key').innerText = "Khóa riêng tư không đúng. Vui lòng nhập lại";
                document.getElementById('i-p-alert-private-key').style.display = "block";

            } else {
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: 'http://localhost:8084/api/account/privateKey/update',
                    data: JSON.stringify({
                        "nameLogin": ""+stringSession.userLogin,
                        "privateKey": document.getElementById('i-private-key-input').value
                    }),
                    success: function (objResponse) {
                        if (objResponse.success === true && objResponse.strResult.includes("0x")) {
                            document.getElementById('address').innerText = objResponse.strResult;
                            document.getElementById('i-update-private-key').style.display = "none";
                            document.getElementById('i-status-success').style.display ="block";
                        } else {
                            document.getElementById('i-error-content').innerText =
                                "Lỗi không thể cập nhật địa chỉ. Xin thử lại một khóa riêng tư khác.";
                            document.getElementById('i-content-update').style.display = "none";
                            document.getElementById('i-status-fail').style.display = "block";
                            document.getElementById('i-update-private-key').style.display = "none";

                        }
                    }
                });
            }
        });
        //End update private key
        //Update password
        let objButtonUpdatePassword = document.getElementById('i-update-password');
        objButtonUpdatePassword.addEventListener('click', function () {
            document.getElementById('i-p-alert-password-key').style.display = "none";
            if (document.getElementById('i-password-key-input-new').value.length > 20 && document.getElementById('i-password-key-input-new-again').value.length > 20) {
                document.getElementById('i-p-alert-password-key').innerText = "Mật khẩu quá dài. Vui lòng nhập lại";
                document.getElementById('i-p-alert-password-key').style.display = "block";

            } else {
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: 'http://localhost:8084/api/account/password/change',
                    data: JSON.stringify({
                        "nameLogin": "" + stringSession.userLogin,
                        "oldPass": document.getElementById('i-password-key-input').value,
                        "newPass": document.getElementById('i-password-key-input-new').value
                    }),
                    success: function (objResponse) {
                        if (objResponse.success === true) {
                            document.getElementById('pass').innerText = objResponse.strResult;
                            document.getElementById('i-update-password').style.display = "none";
                            document.getElementById('i-status-success-password').style.display = "block";
                        } else {
                            document.getElementById('i-error-content-password').innerText =
                                "Mật khẩu cũ không khớp. Vui lòng xin thử lại.";
                            document.getElementById('i-content-update-password').style.display = "none";
                            document.getElementById('i-status-fail-password').style.display = "block";
                            document.getElementById('i-update-password').style.display = "none";

                        }
                    }
                });
            }
        });
    });
    // end update password
    window.addEventListener(('load'), function () {
        let objOpenUpload = document.getElementById('openUpload');
        let objInputUpload = document.getElementById('imgUpload');
        let objSubmitUpload = document.getElementById('submit-upload-img');
        let objHiddenFile = document.getElementById('i-file');
        let objPopupUpdateImg = document.getElementById('i-view-detail');
        let objChooseImge = document.getElementById('i-choose-image');
        let objAgreeUpload = document.getElementById('btn-agree-update-img');
        let objNameChooseFileToUpload = document.getElementById('span-choose-image');
        let objMainAvatar = document.getElementById('i-main-avatar');
        let objInputAccountForm = document.getElementById('i-account-form');
        let objAlertUploadImg = document.getElementById('i-alert-upload-img');
        let objUpdatingLand = document.getElementById('i-updating-land');

        resetAllAlert();

        function resetAllAlert() {
            // reset alert
            objAlertUploadImg.innerText = "";
            objAlertUploadImg.style.display = "none";

        }

        function updateSession() {
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8084/api/session/update",
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });
        }

// Access our form...
        const formUploadImage = document.getElementById("fileUploadForm");
        // ...to take over the submit event
        formUploadImage.addEventListener('submit', function (event) {
            event.preventDefault();
            sendData();
        });

        function getAvatar() {
            if (objImgIpfs != null) {
                objMainAvatar.src = objImgIpfs.src;
            }
        }

        objHiddenFile.addEventListener('change', function (e) {
            let fileName = e.target.files[0].name;
            document.getElementById('span-choose-image').innerText = fileName;
            objChooseImge.style.display = "block";
        });
        objOpenUpload.addEventListener('click', function () {
            objPopupUpdateImg.style.display = "block";
        });
        objAgreeUpload.addEventListener('click', function () {
            document.getElementById('btnSubmit').click();
        });

        getAvatar();


        function sendData() {
            var form = $('#fileUploadForm')[0];
            var data = new FormData(form);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8084/api/account/update/image",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    document.getElementById('i-main-avatar').src = data.strResult;
                    document.getElementById('i-img-ipfs').src = data.strResult;
                    document.getElementById('i-view-detail').style.display = "none";
                    //Updating current session
                    updateSession();
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });
        }
    });

    document.getElementById("i-btn-update").addEventListener("click", function () {
        document.getElementById('i-p-alert-private-key').style.display = "none";
        document.getElementById('i-content-update').style.display = "block";
        document.getElementById('i-status-fail').style.display = "none";
        document.getElementById('i-status-success').style.display = "none";
        document.getElementById("i-modal").style.display = "block";
        document.getElementById('i-update-private-key').style.display = "block";

    });

    document.getElementById("i-btn-update-password").addEventListener("click", function () {
        document.getElementById('i-p-alert-password-key').style.display = "none";
        document.getElementById('i-content-update-password').style.display = "block";
        document.getElementById('i-status-fail-password').style.display = "none";
        document.getElementById('i-status-success-password').style.display = "none";
        document.getElementById("i-modal-password").style.display = "block";
        document.getElementById('i-update-password').style.display = "block";
    });

</script>
</body>
</html>
