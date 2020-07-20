<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Quản lí"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
           <jsp:include page="admin-header.jsp"/>

            <div class="bottom-header">
                <div class="text-center">
<%--                    <h1 class="title">Browser Our Properties</h1>--%>
<%--                    <h4 class="sub-title">An cư lập nghiệp - Xây đắp tương lai</h4>--%>
                </div>
            </div>
            <!--wrap-filter -->
            <br/>
            <form class="wrap-filter">
                <div class="row">
                    <div class="col">
                        <label for="exampleFormControlSelect1">Tên chủ bất động sản</label>
                        <input placeholder="Nhập họ tên chủ đất" type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Thành phố</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>Hồ chí minh</option>
                            <option>Hà Nội</option>
                            <option>Đà nẵng</option>
                            <option>Huế</option>
<%--                            <option>5</option>--%>
                        </select>
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Quận</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>Quận 1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Diện tích</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option> 10m2 đến 50m2 </option>
                            <option> 50m2 đến 200m2 </option>
                            <option> 200m2 đến 500m2 </option>
                            <option> >1000m2 </option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="exampleFormControlSelect1">Giá</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option> <1 tỷ VNĐ </option>
                            <option> 1 tỷ - 3 tỷ VNĐ </option>
                            <option> 3 tỷ - 10  tỷ VNĐ </option>
                            <option> 10 tỷ - 20 tỷ VNĐ </option>
                            <option> >20 tỷ VNĐ </option>
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
