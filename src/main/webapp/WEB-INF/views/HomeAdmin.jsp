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
    <jsp:param name="title" value="Home Admin"/>
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
                <button type="button" class="btn btn-find">Tìm kiếm</button>
            </form>
            <br/>
            <!--           end wrap filter -->
            <!--           wrap card -->
            <div class="wrap-cards">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="https://loremflickr.com/640/360" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text">
                                    <span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span>
                                </p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="https://loremflickr.com/640/360" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text"><span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span></p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="https://loremflickr.com/640/360" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text"><span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span></p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="https://loremflickr.com/640/360" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text"><span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span></p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="https://loremflickr.com/640/360" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text"><span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span></p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="https://loremflickr.com/640/360" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Tên nhà đất</h5>
                                <p class="card-text"><span class="key-card-text">Giá niêm yết: </span> <span class="value-card-text">8 tỷ</span> <br />
                                    <span class="key-card-text">Diện tích: </span> <span class="value-card-text">600m2</span><br />
                                    <span class="key-card-text">Tình trạng: </span> <span class="value-card-text">Đang bán</span></p>
                                <a href="#" class="btn btn-primary">MUA</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--           end wrap card -->
        </div>
    </div>
</div>
</body>
</html>
