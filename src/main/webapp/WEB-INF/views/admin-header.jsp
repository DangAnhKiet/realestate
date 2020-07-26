<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sticky-top">
    <ul class="nav-home-admin">
        <li><i class="fa fa-home" id="i-home" aria-hidden="true" href="/admin/home"></i></li>
        <li><a class="nav-hover" id="i-admin-home" href="/admin/manage/land">Quản lí đất</a></li>
        <li><a class="nav-hover" id="i-admin-account" href="/admin/manage/account">Quản lí tài khoản</a></li>
        <li><a class="nav-hover" id="i-admin-help" href="/help">Trợ giúp</a></li>
        <li class="avatar">
            <img src="https://i.pravatar.cc/300" alt="Avatar">
            <ul class="avatar-detail">
                <li><a href="/accounts/detail">Thông tin cá nhân</a></li>
                <li><a href="#">Đăng xuất</a></li>
            </ul>
        </li>
    </ul>
</div>
<script type="text/javascript">
    var objHome = document.getElementById("i-home");

    objHome.addEventListener("click", function () {
        window.location.href = "/admin/home";
    })

    function removeHover() {
        var listLi = document.getElementsByClassName("nav-hover");
        let i = 0;
        for (i = 0; i < listLi.length; i++) {
            listLi[i].classList.remove("tab-current");
        }
    }

    var url = window.location.href;
    if (typeof url == 'string') {
        removeHover();
        if (url.includes("admin/manage/land") || url.includes("/admin/land/add")) {
            document.getElementById("i-admin-home").classList.add("tab-current");
        } else if (url.includes("/admin/manage/account")) {
            document.getElementById("i-admin-account").classList.add("tab-current");
        } else if (url.includes("/help")) {
            document.getElementById("i-admin-help").classList.add("tab-current");
        } else if (url.includes("/admin/home")) {
            objHome.style.color = "#EEA738";
        }
    }
</script>