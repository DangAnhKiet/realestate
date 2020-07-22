<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script src="https://www.gstatic.com/firebasejs/7.16.1/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.16.1/firebase-auth.js"></script>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Đăng kí tài khoản"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>
<body>
<div class="container register">
    <div class="row">
        <div style="padding: 0px !important;" class="col-sm-12">
            <jsp:include page="admin-header.jsp"/>
        </div>
    </div>
    <div class="row">
            <div class="col-md-3 register-left">
                <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                <h3>Chào mừng</h3>
                <p>Bạn sắp trở thành thành viên trên hệ thống mua bán bất động sản đáng tin cậy nhất Việt Nam</p>
                <%--            <input type="submit" name="" value="Đăng nhập"/><br/>--%>
            </div>
            <div class="col-md-9 register-right">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <h3 class="register-heading">Đăng kí thông tin</h3>
                        <div class="row register-form">
                            <div class="col-md-6">
                                <div class="form-group has-check">
                                    <input id="i-input-fullname" type="text" class="form-control" placeholder="Họ tên *" value="" />
                                    <i id="i-check-fullname" data-check-status="false" style="color: orange;display: none;" class="fa fa-check"
                                       aria-hidden="true"></i>
<%--                                    <i style="color: orange;display: none;" class="fa fa-times" aria-hidden="true"></i>--%>
                                </div>
                                <div class="form-group has-check">
                                    <input id="i-input-userlogin" type="text" class="form-control" placeholder="Tên đăng nhập *" value="" />
                                    <i id="i-check-username-login" data-check-status="false" style="color: orange;display: none;" class="fa fa-check"
                                       aria-hidden="true"></i>
                                </div>
                                <div class="form-group">
                                    <input id="i-input-password" type="password" class="form-control" placeholder="Mật khẩu *" value="" />
                                </div>
                                <div class="form-group has-check">
                                    <input id="i-input-repassword" type="password" class="form-control"  placeholder="Nhập lại mật khẩu *" value="" />
                                    <i id="i-check-password" data-check-status="false" style="color: orange;display: none;" class="fa fa-check"
                                       aria-hidden="true"></i>
                                </div>
                                <div class="form-group">
                                    <div class="maxl">
                                        <label class="radio inline">
                                            <input type="radio" name="gender" value="male" checked>
                                            <span> Nam </span>
                                        </label>
                                        <label class="radio inline">
                                            <input type="radio" name="gender" value="female">
                                            <span>Nữ </span>
                                        </label>
                                    </div>
                                </div>
                                <p style="color:gray;">(*) Thông tin bắt buộc</p>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group has-check">
                                    <input id="i-input-email" required type="email" class="form-control" placeholder="Địa chỉ email *" value="" />
                                    <i id="i-check-email" data-check-status="false" style="color: orange;display: none;" class="fa fa-check"
                                       aria-hidden="true"></i>
                                </div>
                                <div class="form-group">
                                    <input id="i-phone-number" type="text" minlength="10" maxlength="11" name="txtEmpPhone"
                                    class="form-control"
                                           placeholder="Số điện thoại *"
                                           value="" />
                                    <div style="display: none"  id="i-input-alert" class="alert alert-danger input-alert" role="alert"></div>
                                    <div id="recaptcha-container"></div>
                                </div>
                                <div class="form-group">
                                    <input id="i-code" type="text" minlength="10" maxlength="10" name="txtCodeConfirm" class="form-control"
                                           placeholder="Nhập mã xác nhận *"
                                           value="" />
                                    <div style="display: none;" id="is-sent-code">
                                        <span class="text-danger">Mã xác nhận không đúng! </span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="i-input-private-key" type="text" name="txtPrivateKey"
                                           class="form-control"
                                           placeholder="Khóa bảo mật của ví tiền ảo *"
                                           value="" />
                                </div>
                                <input style="pointer-events:none; background-color:#ddd;" id="i-btn-register" type="button" class="btnRegister"
                                       value="Đăng kí"/>
                                <a href="/admin/accounts"><input type="submit" class="btnRegister"  value="Quay lại"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%--            Modal view detail--%>
        <div class="w3-container">
            <div id="i-view-detail" class="w3-modal">
                <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">

                    <div class="w3-center"><br>
                        <span onclick="document.getElementById('i-view-detail').style.display='none'"
                              class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                        <img style="width: 100px;" src="/imgs/item-real/alert.png">
                    </div>
                        <div class="w3-section w3-center">
                            <h3>Không thể gửi mã xác nhận đến số <span id="my-phone" style="font-weight: 600;"></span></h3>
                        </div>
                        <div style="text-align: right; padding-right: 10px;">
                            <hr>
                            <button onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="btn btn-danger">Đóng
                            </button>
                            <a href="/admin/registry">
                                <button style="margin-right: 3px;"
                                        onclick="document.getElementById('i-view-detail').style.display='none'"
                                        type="button"
                                        class="btn btn-primary">Nhập lại
                                </button>
                            </a>
                            <hr>
                        </div>
                </div>
            </div>
        </div>
<%--        End popup--%>
    </div>

</div>
<script type="text/javascript">
    window.onload = function() { // same as window.addEventListener('load', (event) => {
        document.getElementById("is-sent-code").style.display = "none";
        document.getElementById("is-sent-code").style.display = "none";
        document.getElementById("i-view-detail").style.display = "none";

        var apiKeyFirebase = "${apiKeyFirebase}";
        var firebaseConfig = {
            apiKey: apiKeyFirebase,
            authDomain: "real-d8692.firebaseapp.com",
            databaseURL: "https://real-d8692.firebaseio.com",
            projectId: "real-d8692",
            storageBucket: "real-d8692.appspot.com",
            messagingSenderId: "76860271192",
            appId: "1:76860271192:web:24ed8527ea696ad092b82d",
            measurementId: "G-QYBWB0RNYR"
        };
        firebase.initializeApp(firebaseConfig);
        // firebase.analytics();
    };
    var objRegister = document.getElementById("i-btn-register");
    var objPhonenumber = document.getElementById("i-phone-number");
    var objInputAlert = document.getElementById("i-input-alert");
    var objFullName = document.getElementById("i-input-fullname");
    var objPassword = document.getElementById("i-input-password");
    var objRePassword = document.getElementById("i-input-repassword");
    var objUserLogin = document.getElementById("i-input-userlogin");
    var objEmail = document.getElementById("i-input-email");
    var objPrivateKey = document.getElementById("i-input-private-key");
    var objRadioGender = document.getElementsByName("gender");

    objFullName.addEventListener('focusout', function () {
        document.getElementById('i-check-fullname').dataset.CheckStatus = "true";
        document.getElementById('i-check-fullname').style.display = "block";

    });
    objUserLogin.addEventListener('focusout', function () {
        document.getElementById('i-check-username-login').dataset.CheckStatus = "true";
        document.getElementById('i-check-username-login').style.display = "block";

    });
    objPassword.addEventListener('focusout', function () {

    });
    objRePassword.addEventListener('focusout', function () {
        if(objRePassword.value.includes(objPassword.value)){
            document.getElementById('i-check-password').dataset.CheckStatus = "true";
            document.getElementById('i-check-password').style.display = "block";
        }else{
            document.getElementById('i-check-password').dataset.CheckStatus = "false";
            document.getElementById('i-check-password').classList.remove("fa-check");
            document.getElementById('i-check-password').classList.add("fa-times");
            document.getElementById('i-check-password').style.display = "block";
        }


    });
    objPhonenumber.addEventListener('focusout',function () {
        checkNumberPhone();
    });
    objRegister.addEventListener('click',function () {
        submitPhoneNumberAuthCode();
    });

    objUserLogin.addEventListener('click',function () {
        let strUserLogin= objUserLogin.value;
    })

    function checkNumberPhone(){
        let validated = true;
        if(objPhonenumber.value.includes(" ")){
            objInputAlert.style.display = "";
            objInputAlert.innerHTML = "Số điện thoại không được có khoảng trắng!";
            objRegister.style.cssText = "pointer-events:none; background-color:#ddd";
            validated = false;
        }
        if(objPhonenumber.value.length < 10 || objPhonenumber.value.length > 11){
            objInputAlert.style.display = "";
            objInputAlert.innerHTML = "Số điện thoại chỉ từ 10 đến 11 kí tự!";
            objRegister.style.cssText = "pointer-events:none; background-color:#ddd";
            validated = false;
        }
        let letters = /[A-Za-z]/;
        if(objPhonenumber.value.match(letters)){
            objInputAlert.style.display = "";
            objInputAlert.innerHTML = "Số điện thoại chỉ chấp nhận kiểu số";
            objRegister.style.cssText = "pointer-events:none; background-color:#ddd";
            validated = false;
        }
        if(validated){
            objInputAlert.innerText = "";
            objInputAlert.style.display = "none";
            loadCaptcha();
            submitPhoneNumberAuth();
        }
    }

    function submitPhoneNumberAuth() {
        // var phoneNumber = document.getElementById('i-phone-number').value;
        let strPhoneFormat = "+84"+objPhonenumber.value.substring(1, objPhonenumber.value.length)+"";
        // alert(strPhoneFormat);
        let appVerifier = window.recaptchaVerifier;
        firebase
            .auth()
            .signInWithPhoneNumber(strPhoneFormat, appVerifier)
            .then(function (confirmationResult) {
                window.confirmationResult = confirmationResult;
                // alert("Đa gửi code to phone: "+ strPhoneFormat);
                objRegister.style.cssText = "pointer-events:auto; background-color:#FF5733";

            })
            .catch(function (error) {
                document.getElementById("my-phone").innerText = strPhoneFormat;
                document.getElementById("i-view-detail").style.display = "block";
                // alert("Không thể gửi mã xác nhận vào số điện thoại:"+strPhoneFormat);
                console.log("Khong the gui code den so dien thoai tren");
                console.log(error);
            });
    }
    function submitPhoneNumberAuthCode() {
        document.getElementById("is-sent-code").style.display = "none";
        let codeFirebase = document.getElementById("i-code").value;
        let checkedGender = "male";
        for(let i = 0, length = objRadioGender.length; i < length; i++){
            if(objRadioGender[i].checked){
                checkedGender = objRadioGender[i].value;
                break;
            }
        }
        confirmationResult
            .confirm(codeFirebase)
            .then(function (result) {
                var user = result.user;
                if (user) {
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: 'http://localhost:8080/account/add',
                        data: JSON.stringify({
                            "nameLogin": objUserLogin.value,
                            "fullName": objFullName.value,
                            "password": objPassword.value,
                            "email": objEmail.value,
                            "phoneNumber": objPhonenumber.value,
                            "privateKey": objPrivateKey.value,
                            "gender": checkedGender,
                            "status":"active",
                            "role":"member"
                        }),
                        success: function (ojbResponse) {
                            // alert(ojbResponse);
                        }
                    });
                } else {
                    document.getElementById("is-sent-code").style.display = "block";
                }
            })
            .catch(function (error) {
                document.getElementById("is-sent-code").style.display = "block";
            });
    }
    function getPhoneNumberFromUserInput(){
        let phoneNumber = document.getElementById("i-phone-number").value;
        return phoneNumber;
    }
    function getCodeFromUserInput(){
        let code = document.getElementById("i-code").value;
        return code;
    }

    function loadCaptcha(){
        // document.getElementById("recaptcha-container").style.display = "block";
        firebase.auth().useDeviceLanguage();
        // window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier("recaptcha-container");
        window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container', {
            'size': 'invisible',
            'callback': function(response) {
                // reCAPTCHA solved, allow signInWithPhoneNumber.
                // ...
            },
            'expired-callback': function() {
                // Response expired. Ask user to solve reCAPTCHA again.
                // ...
            }
        });
        // window.recaptchaVerifier.render().then(function (widgetId) {
        //     window.recaptchaWidgetId = widgetId;
        // });
    }
</script>
</body>
</html>
