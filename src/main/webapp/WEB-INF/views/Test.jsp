<%--
  Created by IntelliJ IDEA.
  User: hauphvn
  Date: 7/19/2020
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://www.gstatic.com/firebasejs/7.16.1/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/7.16.1/firebase-auth.js"></script>
<%--    <script src="https://www.gstatic.com/firebasejs/7.16.1/firebase-firestore.js"></script>--%>
<%--    <script src="https://www.gstatic.com/firebasejs/7.16.1/firebase-analytics.js"></script>--%>
</head>
<body onload="loadFirebase()">
<%--<h1>vi du </h1>--%>
<%--<input type="submit" class="btn btn-success" value="Run captcha" id="sign-in-button">--%>
<div id="recaptcha-container"></div>
<div id="hauphvn"></div>
<%--<div class="form-group">--%>
<%--    <input  type="text" maxlength="11" minlength="10"  required id="input-phone-guest" type="text" id="login" class="second" name="numberPhone" placeholder="Nhập số điện thoại" required>--%>
<%--    <input style="display: none" id="input-code" type="number" required class="second" name="varifyCodeFirebase" placeholder="Nhập mã số xác nhận">--%>
<%--</div>--%>
<div class="form-group">
    <input  type="text" maxlength="11" minlength="10"  required id="input-phone-guest" type="text" id="login" class="second" name="numberPhone" placeholder="Nhập số điện thoại" required>
    <input style="display: none" id="input-code" type="number" required class="second" name="varifyCodeFirebase" placeholder="Nhập mã số xác nhận">
</div>
<button id="btn-verify-phone" onclick="checkNumberPhone()" type="button" style="cursor: pointer" class="btn-vip">Gửi mã xác nhận</button>
<p style="display: none;" id="wrong-phone" class="text-danger">Số điện thoại chưa đăng ký.</p>
<p style="display: none" id="wrong-code" class="text-danger">Mã xác nhận không hợp lệ.</p>
<input type="text" placeholder="nhap code" id="my-code">
<button onclick="submitPhoneNumberAuthCode()" type="button"  class="btn-vip"  >Đăng nhập</button>

<!-- The core Firebase JS SDK is always required and must be listed first -->

<%--<script  src="./init-firebase.js"></script>--%>

<script type="application/javascript">
    // var firebaseConfig = {
    //     apiKey: "AIzaSyCFYD5UslCuc_lKDrBGqxWDp4UO_rNnwOE",
    //     authDomain: "real-d8692.firebaseapp.com",
    //     databaseURL: "https://real-d8692.firebaseio.com",
    //     projectId: "real-d8692",
    //     storageBucket: "real-d8692.appspot.com",
    //     messagingSenderId: "76860271192",
    //     appId: "1:76860271192:web:24ed8527ea696ad092b82d",
    //     measurementId: "G-QYBWB0RNYR"
    // };
    // Initialize Firebase

    // firebase.initializeApp(firebaseConfig);
    function submitPhoneNumberAuth() {
        var phoneNumber = "+84967900801";
        var appVerifier = window.recaptchaVerifier;
        firebase
            .auth()
            .signInWithPhoneNumber(phoneNumber, appVerifier)
            .then(function (confirmationResult) {
                window.confirmationResult = confirmationResult;
                                   alert("Đa gửi code to phone: "+ phoneNumber)
            })
            .catch(function (error) {
                console.log("Khong the gui code den so dien thoai tren");
                console.log(error);
            });
    }

    // firebase.analytics();
    function loadFirebase() {
        var firebaseConfig = {
            apiKey: "AIzaSyCFYD5UslCuc_ lKDrBGqxWDp4UO_rNnwOE",
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
        alert("chay capcha");
        firebase.auth().useDeviceLanguage();
        //@ts-ignore
        window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier("recaptcha-container");

        //@ts-ignore
        window.recaptchaVerifier.render().then(function (widgetId) {
            //@ts-ignore
            window.recaptchaWidgetId = widgetId;
        });
        submitPhoneNumberAuth();
        // window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier(
        //     "recaptcha-container",
        //     {
        //                        // size: "normal",
        //         size: "invisible",
        //         callback: function (response) {
        //                            alert("fdsfds");
        //             submitPhoneNumberAuth();
        //         }
        //     }
        // );
    }

    function submitPhoneNumberAuthCode() {

        var codeFirebase = document.getElementById("my-code").value;
        confirmationResult
            .confirm(codeFirebase)
            .then(function (result) {
                var user = result.user;
                if (user) {
                    alert("dung code");
                } else {
                    alert("sai code");
                }
            })
            .catch(function (error) {
                alert("error");
            });
    }

</script>
</body>
</html>
