<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sticky-top">
    <c:if test="${not empty sessionScope.MY_SESSION}">
        <ul class="nav-home-admin">
            <a id="i-a-logo-home" href="/">
                <li><img src="/imgs/item-real/LOGO.png" id="i-logo-dapp" alt="logo-dapp"></li>
            </a>
            <c:if test="${requestScope.role == 'admin'}">
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover"
                                                             id="i-admin-exchanges"
                                                             href="/">Sàn giao
                    dịch</a></li>
                <li style="border-left: 1px dashed #fff;"><a
                        class="nav-hover" id="i-admin-land" href="/admin/manage/land">Quản lí
                    đất</a>
                </li>
                <li style="border-left: 1px dashed #fff;"><a
                        class="nav-hover" id="i-admin-account"
                        href="/admin/manage/account">Quản lí tài khoản</a></li>
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-admin-help"
                                                             href="/admin/help">Trợ giúp</a></li>
            </c:if>
            <c:if test="${requestScope.role == 'member'}">
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover"
                                                             id="i-member-exchanges" href="/">Sàn
                    giao dịch</a></li>
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-member-land"
                                                             href="/member/manage/land">Quản lí
                    đất</a>
                </li>
                <%--                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-member-land-history"--%>
                <%--                                                             href="/member/manage/history">Lịch sử giao--%>
                <%--                    dịch</a>--%>
                </li>
                <li style="border-left: 1px dashed #fff;"><a class="nav-hover" id="i-member-help"
                                                             href="/member/help">Trợ giúp</a></li>
                <li style="padding-top: 1rem; padding-left: 8%; color: white; width: 34%;">
                    <img style="width: 12%;" src="/imgs/item-real/payment.png" alt="icon-wallet">   Số tiền trong ví:
                    <span>  <strong id="i-my-wallet-header"> </strong> ETH</span>
                    <img  id="i-open-eye" style="cursor: pointer; width: 8%;" src="/imgs/item-real/eye.svg" alt="icon-eye">
                    <img id="i-close-eye" style="cursor: pointer;width: 8%;display: none;" src="/imgs/item-real/close-eye.svg" alt="icon-close-eye">
                </li>
            </c:if>
            <li class="avatar">
                <c:if test="${requestScope.role == 'admin'}">
                    <div class="badge badge-danger text-wrap" style="width: 6rem;">
                        Quản trị viên
                    </div>
                </c:if>

                <img id="i-img-ipfs" src="/imgs/item-real/avatar-default.png" alt="Avatar">
                <c:if test="${requestScope.role == 'member'}">
                    <span id="i-fullName"></span>
                </c:if>
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
            <h2 style="color: #ffffff">KH REALESTATE BLOCKCHAIN</h2>
            <a style="margin-right: 1%;" href="/login">
                <div><input type="button" class="button" value="ĐĂNG NHẬP"></div>
            </a>
        </ul>

    </c:if>
</div>
<script type="text/javascript">
    let objImgIpfs = document.getElementById('i-img-ipfs');
    let objHome = document.getElementById("i-home");
    let objUrlToAdminHome = document.getElementById('i-a-logo-home');
    let url = window.location.href;
    document.getElementById('i-close-eye').addEventListener('click', function () {
        getBalance(document.getElementById('i-my-wallet-header'));
        document.getElementById('i-close-eye').style.display = "none";
        document.getElementById('i-open-eye').style.display = "inline";
    });
    document.getElementById('i-open-eye').addEventListener('click', function () {
        document.getElementById('i-my-wallet-header').innerText = "*****";
        document.getElementById('i-open-eye').style.display = "none";
        document.getElementById('i-close-eye').style.display = "inline";

    });
    if(null != document.getElementById('i-my-wallet-header')){
        getBalance(document.getElementById('i-my-wallet-header'));
    }
    function getBalance(elemCurr){
        let mySession = '${sessionScope.MY_SESSION}';
        let jsonSession = JSON.parse(mySession);
        $.ajax({
            type: "POST",
            contentType: "text/plain",
            url: 'http://localhost:8084/api/land/checkBalance',
            data: jsonSession.userLogin,
            success: function (objResponse) {
                if (objResponse.success === true) {
                    if(elemCurr != null){
                        // document.getElementById('i-money-owner-wallet').innerText = objResponse.strResult;
                        elemCurr.innerText = objResponse.strResult;
                    }

                } else if (objResponse.success === false ) {
                    if(elemCurr != null){
                        // document.getElementById('i-money-owner-wallet').innerText = objResponse.strResult;
                        elemCurr.innerText = "###";
                    }
                }
            }
        });
    }
    // window.addEventListener('load', function () {

        let mySession = '${sessionScope.MY_SESSION}';

        if (${requestScope.role == 'member'}) {
            if (mySession !== '') {
                let objSession = JSON.parse(mySession);
                objImgIpfs.src = objSession.imgPath;
                document.getElementById('i-fullName').innerText = objSession.fullName;
            }
        }
        if (objUrlToAdminHome != null) {
            objUrlToAdminHome.addEventListener('click', function () {
                if (${requestScope.role == 'admin'}) {
                    objUrlToAdminHome.href = "/";
                } else if (${requestScope.role == 'member'}) {
                    objUrlToAdminHome.href = "/";
                }
            });
        }
        if (typeof url == 'string') {
            if (null != document.getElementById('i-logo-dapp')) {
                document.getElementById('i-logo-dapp').style.cssText = "border-bottom: none;";
            }

            let listLi = document.getElementsByClassName("nav-hover");
            for (let j = 0; j < listLi.length; j++) {
                console.log("+++++++++++remove++++++:" + j);
                listLi[j].classList.remove("tab-current");
            }
            for (let i = 0; i < listLi.length; i++) {
                if (url === (listLi[i].href)) {
                    listLi[i].classList.add("tab-current");
                    break;
                }
            }
            // if (url.includes("/")) {
            //     document.getElementById('i-logo-dapp').style.cssText =
            //         "border-bottom: 2px orange solid;";
            // }
        }

        function removeHover() {
            let listLi = document.getElementsByClassName("nav-hover");
            let i = 0;
            for (i = 0; i < listLi.length; i++) {
                listLi[i].classList.remove("tab-current");
            }
        }


    // });


</script>