<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Quản lí tài khoản"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>

<body>

<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-lg-12 wrap-accounts">
            <jsp:include page="Header.jsp"/>
            <div class="bg-image">
                <h2 class="title">Quản lí tài khoản</h2>
            </div>
            <hr>
            <a href="/admin/account/registry">
                <input style="width: 230px!important;" class="button" value="ĐĂNG KÍ THÀNH VIÊN ">
            </a>
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                            <tr>
                                <th><span>Người dùng</span></th>
                                <th><span>Điện thoại</span></th>
                                <th class="text-center"><span>Trạng thái</span></th>
                                <th><span>Tài khoản đăng nhập</span></th>
                                <th><span>Email</span></th>
                                <%--                                           <th>&nbsp;</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.accountResponses}" var="account">
                                <tr>
                                    <td>
                                        <img src="${account.img}" alt="avatar-user">
                                        <span href="#" class="user-link">${account.fullName}</span>
                                        <span class="user-subhead">${account.role}</span>
                                    </td>
                                    <td>${account.phoneNumber}</td>
                                    <td class="text-center">
                                        <span class="label label-default">${account.status}</span>
                                    </td>
                                    <td>
                                        <a href="#">${account.nameLogin}</a>
                                    </td>
                                    <td>
                                        <a href="#">${account.email}</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <c:if test="${empty requestScope.accountResponses}">
            <div class="col sm 12">
                <h4 style="text-align: center; padding-bottom: 20%; padding-top: 10%;">Không tìm thấy thông tin</h4>
            </div>
            </c:if>
            <hr>
            <jsp:include page="Footer.jsp"/>
            <%--           <nav class="navbar na
                    </div>
                </div>
            </div>

         vbar-light bg-light wrap-nav-account">--%>
            <%--               <div style="display: flex; width: 267px;">--%>
            <%--                   <div>--%>
            <%--                       <input class="form-control" type="search"--%>
            <%--                              placeholder="Nhập tên hoặc địa chỉ tài khoản của chủ đất" aria-label="Search">--%>
            <%--                   </div>--%>
            <%--                   <div>--%>
            <%--                       <button id="i-get-account" style="margin-left: 3px;font-weight: 600"--%>
            <%--                               class="btn btn-outline-success my-2 my-sm-0"--%>
            <%--                               type="button"><span style="margin-left: 3px">Tìm</span></button>--%>
            <%--                   </div>--%>
            <%--               </div>--%>
            <%--               <div><a href="/admin/account/registry">--%>
            <%--                   <button type="button" class="button">Đăng kí tài khoản mới</button>--%>
            <%--               </a></div>--%>
            <%--           </nav>--%>
            <%--           <br>--%>
            <%--           <div class="row">--%>
            <%--               <c:if test="${not empty requestScope.listLands}">--%>
            <%--                   <c:forEach items="${requestScope.listLands}" var="i">--%>
            <%--                       <div class="col-sm-12">--%>
            <%--                           <div class="card my-card-home">--%>
            <%--                               <img class="card-img-bottom-new" src="${i.image}" alt="Card image cap">--%>
            <%--                               <div class="card-body">--%>
            <%--                                   <h5 class="card-title">Người bán: <span class="i-price">${i.seller}</span> VNĐ</h5>--%>
            <%--                                   <h5 class="card-title">Người mua: <span class="i-price">${i.buyer}</span> VNĐ</h5>--%>
            <%--                                   <h5 class="card-title">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>--%>
            <%--                                   <h5 class="card-title">Thời gian bán: <span class="i-price">${i.timestamp}</span>--%>
            <%--                                       VNĐ</h5>--%>
            <%--                               </div>--%>
            <%--                           </div>--%>
            <%--                       </div>--%>
            <%--                   </c:forEach>--%>
            <%--               </c:if>--%>
            <%--               <c:if test="${empty requestScope.listLands}">--%>
            <%--                   <div class="col sm 12">--%>
            <%--                       <h4 style="text-align: center; padding-bottom: 20%; padding-top: 10%;">Không tìm thấy lịch sử--%>
            <%--                           giao dịch</h4>--%>
            <%--                   </div>--%>
            <%--               </c:if>--%>
            <%--           </div>--%>
            <%--           <div class="list-group list-account">--%>

            <%--               <div class="list-group-item list-group-item-action flex-column align-items-start item-active">--%>
            <%--                   <div class="account-image">--%>
            <%--                       <img src="https://i.pravatar.cc/300" alt="Avatar">--%>
            <%--                   </div>--%>
            <%--                   <div class="account-info">--%>
            <%--                       <div class="d-flex w-100 justify-content-between">--%>
            <%--                           <h5 class="mb-1">List group item heading</h5>--%>
            <%--                       </div>--%>
            <%--                       <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>--%>
            <%--                       <small>Donec id elit non mi porta.</small>--%>
            <%--                   </div>--%>
            <%--                   <div>--%>
            <%--                       <input style="background-color: firebrick; color: white;" type="text" class="button-inside-list" value="Khóa tài khoản">--%>
            <%--                       <input type="text" class="button-inside-list" value="Xem chi tiết">--%>
            <%--                   </div>--%>
            <%--               </div>--%>
            <%--           </div>--%>


</body>
</html>
