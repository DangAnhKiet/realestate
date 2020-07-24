<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sticky-top">
    <ul class="nav-home-admin">
        <li><i class="fa fa-home" aria-hidden="true"></i></li>
        <li><a class="nav-hover" id="i-admin-home" href="/member">Sàn giao dịch</a></li>
        <li><a class="nav-hover" id="i-admin-account" href="/member/lands">Quản lí đất</a></li>
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
    function removeHover(){
        var listLi = document.getElementsByClassName("nav-hover");
        let i = 0;
        for(i = 0; i < listLi.length; i++){
            listLi[i].classList.remove("tab-current");
        }
    }
    var url = window.location.href;
    if(typeof url == 'string'){
        removeHover();
        if(url.includes("/member")){
            document.getElementById("i-admin-home").classList.add("tab-current");
        }else if(url.includes("admin/accounts")){
            document.getElementById("i-admin-account").classList.add("tab-current");
        }
        else if(url.includes("/help")){
            document.getElementById("i-admin-help").classList.add("tab-current");
        }
    }
</script>