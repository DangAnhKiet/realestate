<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sticky-top">
    <c:if test="${not empty sessionScope.MY_SESSION}">
        <ul class="nav-home-admin">
            <a href="/">
                <li><img src="/imgs/item-real/LOGO.png" id="i-logo-dapp" alt="logo-dapp"></li>
            </a>
            <c:if test="${requestScope.role == 'admin'}">
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover"
                                                             id="i-admin-exchanges"
                                                             href="/admin/exchanges">Sàn giao
                    dịch</a></li>
                <li style="border-left: 1px dashed #fff;"><a
                        class="nav-hover" id="i-admin-land" href="/admin/manage/land">Quản lí
                    đất</a>
                </li>
                <li style="border-left: 1px dashed #fff;"><a
                        class="nav-hover" id="i-admin-account"
                        href="/admin/manage/account">Quản lí tài khoản</a></li>
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-admin-help"
                                                             href="/help">Trợ giúp</a></li>
            </c:if>
            <c:if test="${requestScope.role == 'member'}">
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover"
                                                             id="i-member-exchanges" href="#">Sàn
                    giao dịch</a></li>
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-member-land"
                                                             href="/member/manage/land">Quản lí
                    đất</a>
                </li>
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-member-help"
                                                             href="/help">Trợ giúp</a></li>
            </c:if>
            <li class="avatar">
                <img id="i-img-ipfs" src="https://i.pravatar.cc/300" alt="Avatar">
                <ul class="avatar-detail">
                    <li><a href="/accounts/detail">Thông tin cá nhân</a></li>
                    <li style="border-top: 1px dashed #fff;"><a href="/logout" methods="GET">Đăng
                        xuất</a></li>
                </ul>
            </li>
        </ul>

    </c:if>
    <c:if test="${empty sessionScope.MY_SESSION}">
        <ul class="nav-home-admin"
            style="height: 74px;display: flex; justify-content: space-between; align-items: center;">
            <a href="/">
                <div style="margin-left: 44%;"><img style="width: 107px;"
                                                    src="/imgs/item-real/logo2.png" alt="logo-dapp">
                </div>
            </a>
            <a style="margin-right: 1%;" href="/login">
                <div><input type="button" class="button" value="ĐĂNG NHẬP"></div>
            </a>
        </ul>

    </c:if>
</div>
<script type="text/javascript">
    console.log("vao script header");
    <%--const regex1 = /\[/;--%>
    <%--const regex2 = /\]/;--%>

    let objImgIpfs = document.getElementById('i-img-ipfs');
    let objHome = document.getElementById("i-home");
    let url = window.location.href;
    if (typeof url == 'string') {
        document.getElementById('i-logo-dapp').style.cssText = "border-bottom: none;";
        let listLi = document.getElementsByClassName("nav-hover");
        for (let j = 0; j < listLi.length; j++) {
            console.log("+++++++++++remove++++++:"+j);
            listLi[j].classList.remove("tab-current");
        }
        for (let i = 0; i < listLi.length; i++) {
            if(url.includes(listLi[i].href)){
                listLi[i].classList.add("tab-current");
                break;
            }
        }
        if (url.includes("admin/home")) {
            document.getElementById('i-logo-dapp').style.cssText =
                "border-bottom: 2px orange solid;";
        }
    }

    function removeHover() {
        let listLi = document.getElementsByClassName("nav-hover");
        let i = 0;
        for (i = 0; i < listLi.length; i++) {
            listLi[i].classList.remove("tab-current");
        }
    }


</script>