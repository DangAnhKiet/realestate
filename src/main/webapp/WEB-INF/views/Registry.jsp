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
    <jsp:param name="title" value="Đăng kí tài khoản"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>
<body>
<jsp:include page="admin-header.jsp"/>
<div class="container register">
    <div class="row">

        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Chào mừng</h3>
            <p>Bạn sắp trở thành thành viên trên hệ thống mua bán bất động sản đáng tin cậy nhất Việt Nam</p>
<%--            <input type="submit" name="" value="Đăng nhập"/><br/>--%>
        </div>
        <div class="col-md-9 register-right">
<%--            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">--%>
<%--                <li class="nav-item">--%>
<%--&lt;%&ndash;                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Employee</a>&ndash;%&gt;--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Hirer</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Đăng kí thông tin</h3>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Họ tên *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Tên đăng nhập *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Mật khẩu *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control"  placeholder="Nhập lại mật khẩu *" value="" />
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
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control"
                                       placeholder="Số điện thoại *"
                                       value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" minlength="10" maxlength="10" name="txtCodeConfirm" class="form-control"
                                       placeholder="Mã xác nhận *"
                                       value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" minlength="10" maxlength="10" name="txtPrivateKey" class="form-control"
                                       placeholder="Khóa bảo mật *"
                                       value="" />
                            </div>
<%--                            <div class="form-group">--%>
<%--                                <select class="form-control">--%>
<%--                                    <option class="hidden"  selected disabled>Please select your Sequrity Question</option>--%>
<%--                                    <option>What is your Birthdate?</option>--%>
<%--                                    <option>What is Your old Phone Number</option>--%>
<%--                                    <option>What is your Pet Name?</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="Enter Your Answer *" value="" />--%>
<%--                            </div>--%>
                            <input type="submit" class="btnRegister"  value="Đăng kí"/>
                        </div>
                    </div>
                </div>
<%--                <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">--%>
<%--                    <h3  class="register-heading">Apply as a Hirer</h3>--%>
<%--                    <div class="row register-form">--%>
<%--                        <div class="col-md-6">--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="Họ tên *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="Tên đăng nhập *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="email" class="form-control" placeholder="Email *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" maxlength="10" minlength="10" class="form-control" placeholder="Phone *" value="" />--%>
<%--                            </div>--%>


<%--                        </div>--%>
<%--                        <div class="col-md-6">--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="password" class="form-control" placeholder="Password *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="password" class="form-control" placeholder="Confirm Password *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <select class="form-control">--%>
<%--                                    <option class="hidden"  selected disabled>Please select your Sequrity Question</option>--%>
<%--                                    <option>What is your Birthdate?</option>--%>
<%--                                    <option>What is Your old Phone Number</option>--%>
<%--                                    <option>What is your Pet Name?</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="`Answer *" value="" />--%>
<%--                            </div>--%>
<%--                            <input type="submit" class="btnRegister"  value="Register"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>

</div>
</body>
</html>
