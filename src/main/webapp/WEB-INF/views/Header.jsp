<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sticky-top">
    <c:if test="${not empty sessionScope.MY_SESSION}">
        <ul class="nav-home-admin">
            <a href="/"><li><img src="/imgs/item-real/LOGO.png" id="i-logo-dapp" alt="logo-dapp"></li></a>
            <li><a class="nav-hover" id="i-admin-land" href="/admin/manage/land">Quản lí đất</a></li>
            <li style="border-left: 1px dashed #fff; border-right: 1px dashed #fff;"><a class="nav-hover" id="i-admin-account"
                                                                                        href="/admin/manage/account">Quản lí tài khoản</a></li>
            <li><a class="nav-hover" id="i-admin-help" href="/help">Trợ giúp</a></li>

            <li class="avatar">
                <img src="https://i.pravatar.cc/300" alt="Avatar">
                <ul class="avatar-detail">
                    <li><a href="/accounts/detail">Thông tin cá nhân</a></li>
                    <li style="border-top: 1px dashed #fff;"><a href="/logout" methods="GET">Đăng xuất</a></li>
                </ul>
            </li>
        </ul>
    </c:if>
    <c:if test="${empty sessionScope.MY_SESSION}">
            <ul class="nav-home-admin" style="height: 74px;display: flex; justify-content: space-between; align-items: center;">
                <a href="/"><div style="margin-left: 44%;"><img style="width: 107px;" src="/imgs/item-real/logo2.png" alt="logo-dapp"></div></a>
                <a style="margin-right: 1%;" href="/login"><div><input type="button" class="button" value="ĐĂNG NHẬP"></div></a>
            </ul>

    </c:if>
</div>
<script type="text/javascript">
    var objHome = document.getElementById("i-home");
    var strSession ="${sessionScope.MY_SESSION.toString()}";
    console.log(strSession);
    if (objHome != null) {
        objHome.addEventListener("click", function () {
            window.location.href = "http://localhost:8084/";
        })
    }

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
        if (url.includes("admin/manage/land") || url.includes("/admin/land/add.")) {
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