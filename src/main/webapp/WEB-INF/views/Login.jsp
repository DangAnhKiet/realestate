<%--
  Created by IntelliJ IDEA.
  User: hauphvn
  Date: 5/8/2020
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Đăng nhập"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<body>

<div style="padding-top: 4em;" class="container">
    <%--    <div class="row">--%>
    <%--        <div class="co -sm-12">--%>
    <%--            --%>
    <%--        </div>--%>
    <%--    </div>--%>
    <div class="row wrap-row-login">
        <div class="col-sm-12 wrap-col-login">
            <div class="wrap-content-login">
                <div>
                    <a href="/"><img style="width: 16%;" src="/imgs/item-real/LOGO.png" id="i-logo-dapp" alt="logo-dapp">
                    </a>
                </div>
                <h2 class="login-title">KH-REAL ESTATE</h2>
                <div class="input-group mb-3 my-input-login">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fa fa-user" aria-hidden="true"></i></span>
                    </div>
                    <input type="text" name="username" id="i-username" class="form-control" placeholder="Tên đăng nhập *" aria-label="Username"
                           aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3 my-input-login">
                    <div class="input-group-prepend">
                        <span class="input-group-text" i><i class="fa fa-key" aria-hidden="true"></i></span>
                    </div>
                    <input type="password" name="password" id="i-password" class="form-control" placeholder="Mật khẩu *" aria-label="Password"
                           aria-describedby="basic-addon1">
                </div>

                <p style="display: none; color: darkred;font-weight: 600" id="alert-login"></p>
                <div style="display: flex; justify-content: center; text-align: center">
                    <div>
                        <button id="i-btn-homepage" class="button">TRANG CHỦ</button>
                    </div>
                    <div>
                        <button id="i-btn-login" class="button">ĐĂNG NHẬP</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var objPassword = document.getElementById("i-password");
    var objUsername = document.getElementById("i-username");
    var objErrorLogin = document.getElementById('alert-login');
    var objHomePage = document.getElementById('i-btn-homepage');

    objHomePage.addEventListener('click', function () {
        window.location.href = "http://localhost:8084";
    })
    document.getElementById("i-btn-login").addEventListener("click", function () {
        objErrorLogin.style.display = "none";
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: 'http://localhost:8084/api/account/login/',
            data: JSON.stringify({
                "nameLogin": objUsername.value,
                "password": objPassword.value
            }),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (objResult) {
            },
            error: function (objResult) {
                console.log(objResult.responseText);
                if(objResult.responseText.includes("admin")){
                    window.location.href = "http://localhost:8084/admin/home";
                }else if(objResult.responseText.includes("member")){
                    window.location.href = "http://localhost:8084/member/home";
                }else{
                    objErrorLogin.innerText = objResult.responseText;
                    objErrorLogin.style.display = "block";
                }
            }
        });
    });
</script>
</body>
</html>
