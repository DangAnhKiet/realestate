<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Quản lí tài khoản"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
       <div class="col-sm-12 wrap-accounts">
           <jsp:include page="Header.jsp"/>
           <div class="bg-image">
               <h2 class="title">Quản lí tài khoản</h2>
           </div>
           <br>
           <nav class="navbar navbar-light bg-light wrap-nav-account">
               <div style="display: flex; width: 267px;" >
                      <div>
                          <input class="form-control" type="search" placeholder="Nhập tên hoặc địa chỉ tài khoản của chủ đất" aria-label="Search">
                      </div>
                       <div>
                           <button style="margin-left: 3px;font-weight: 600" class="btn btn-outline-success my-2 my-sm-0"
                                   type="button"><span style="margin-left: 3px">Tìm</span></button>
                       </div>
               </div>
              <div> <a href="/admin/registry"><button type="button" class="btn btn-primary btn-lg">Đăng kí mới</button></a></div>
           </nav>
           <div class="list-group list-account">
               <a href="#" class="list-group-item list-group-item-action flex-column align-items-start item-active">
                   <div class="account-image">
                       <img src="https://i.pravatar.cc/300" alt="Avatar">
                   </div>
                   <div class="account-info">
                       <div class="d-flex w-100 justify-content-between">
                           <h5 class="mb-1">List group item heading</h5>
                       </div>
                       <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                       <small>Donec id elit non mi porta.</small>
                   </div>
               </a>
               <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                   <div class="account-image">
                       <img src="https://i.pravatar.cc/300" alt="Avatar">
                   </div>
                   <div class="account-info">
                       <div class="d-flex w-100 justify-content-between">
                           <h5 class="mb-1">List group item heading</h5>
                       </div>
                       <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                       <small>Donec id elit non mi porta.</small>
                   </div>
               </a>
               <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                   <div class="account-image">
                       <img src="https://i.pravatar.cc/300" alt="Avatar">
                   </div>
                   <div class="account-info">
                       <div class="d-flex w-100 justify-content-between">
                           <h5 class="mb-1">List group item heading</h5>
                       </div>
                       <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                       <small>Donec id elit non mi porta.</small>
                   </div>
               </a>
           </div>
           <jsp:include page="Footer.jsp"/>
       </div>
    </div>
</div>

</body>
</html>
