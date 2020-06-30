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
<jsp:param name="title" value="Admin Login"/>
<jsp:param name="link-css-this-page" value="../css/admin-login.css"/>
</jsp:include>

<body>

<div style="padding-top: 4em;" class="container">
    <div class="row">
        <div class="col-sm-12 wrap-login">
            <div>
                <h2 class="login-title">KH-REAL ESTATE</h2>
                    <div class="form-group">
                        <lable for="username">Username:</lable>
                        <input type="text" id="username" name="username" class="form-control">
                    </div>
                    <div class="form-group">
                        <lable for="password">Password:</lable>
                        <input type="password" name="password" id="password" class="form-control">
                    </div>
                    <p style="display: none; color: darkred" id="alert-login">Tên đăng nhập hoặc mật khẩu không đúng</p>
                    <div style="display: flex; justify-content: center; text-align: center">
                        <div>
                            <button id="i-btn-login" class="btn btn-success">ĐĂNG NHẬP</button>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    document.getElementById("i-btn-login").addEventListener("click",function(){
       var password = document.getElementById("password").value;
       var username = document.getElementById("username").value;
       var role = "admin";
       $.ajax({
           type:'POST',
           contentType: "application/json",
           url: 'http://localhost:8080/account/login/',
           data: JSON.stringify({
               "nameLogin":username,
              "password":password,
               "role":role
           }),
           success: function (objResult) {
               var jsonResult =JSON.parse(JSON.stringify(objResult));
                if(jsonResult.success == true && jsonResult.strResult == "admin"){
                    alert("la admin");
                }else if(jsonResult == "member"){
                   alert("la member");
                }else{
                    document.getElementById("alert-login").style.display = "block";
                }
           }
       });
    });
</script>
</body>
</html>
