<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Management Real Estate"/>
    <jsp:param name="link-css-this-page" value="/css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 wrap-accounts">
            <jsp:include page="Header.jsp"/>
            <div class="bg-image">
                <h3 class="title">QUẢN LÍ ĐẤT</h3>
            </div>
            <br>
            <div class="row">
                <c:forEach items="${requestScope.listLands}" var="i">
                    <div class="col-sm-12">
                        <div class="card my-card-home">
                            <img class="card-img-bottom-new" src="${i.pathImage}" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>
                                <p class="card-text">${i.street} | ${i.district}</p>
                                <a style="background-color: #EEA738; border-color: #EEA738;" href="/landn/${i.landId}"
                                   class="btn land-view-detail">Xem
                                    chi tiết</a>
                            </div>
                        </div>
                    </div>

                    <%--                    <div class="list-group list-account">--%>

                    <%--                        <div class="list-group-item list-group-item-action flex-column align-items-start item-active">--%>
                    <%--                            <div class="account-image">--%>
                    <%--                                <img src="${i.pathImage}" alt="Avatar">--%>
                    <%--                            </div>--%>
                    <%--                            <div class="account-info">--%>
                    <%--                                <div class="d-flex w-100 justify-content-between">--%>
                    <%--                                    <h5 class="mb-1">Giá bán: <span class="i-price">${i.price}</span> VNĐ</h5>--%>
                    <%--                                    <p class="card-text">${i.street} | ${i.district}</p>--%>

                    <%--                                </div>--%>
                    <%--&lt;%&ndash;                                <a style="background-color: #EEA738; border-color: #EEA738;"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;                                   href="/land/${i.landId}" class="btn land-view-detail">Xem chi tiết</a>&ndash;%&gt;--%>
                    <%--                                <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget--%>
                    <%--                                    risus varius blandit.</p>--%>
                    <%--                                <small>Donec id elit non mi porta.</small>--%>
                    <%--                            </div>--%>
                    <%--                            <div>--%>
                    <%--                                <input style="background-color: firebrick; color: white;" type="text"--%>
                    <%--                                       class="button-inside-list" value="Khóa tài khoản">--%>
                    <%--                                <input type="text" class="button-inside-list" href="/land/${i.landId}" class="btn land-view-detail" value="Xem chi tiết">--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </c:forEach>
            </div>
            <%--            <div class="row">--%>
            <%--                <div class="col-sm-12">--%>
            <%--                    <a href="/admin/land/list">--%>
            <%--                        <div class="item-manage-land card">--%>
            <%--                            <div class="card-body">--%>
            <%--                                <h5 class="card-title">Danh sách bất động sản trên sàn</h5>--%>
            <%--                                <p class="card-text">Thông tin tất cả bất động sản của người bán.</p>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </a>--%>
            <%--                </div>--%>
            <%--                <div class="col-sm-12">--%>
            <%--                    <a href="/admin/land/add">--%>
            <%--                        <div class="item-manage-land card">--%>
            <%--                            <div class="card-body">--%>
            <%--                                <h5 class="card-title">Thêm bất động sản</h5>--%>
            <%--                                <p class="card-text">Đăng kí thông tin và đăng lên hệ thống blockchain và sàn giao dịch.</p>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </a>--%>
            <%--                </div>--%>
            <%--                <div class="col-sm-6">--%>
            <%--                    <a href="">--%>
            <%--                        <div class="item-manage-land card">--%>
            <%--                            <div class="card-body">--%>
            <%--                                <h5 class="card-title">Lịch sử giao dịch</h5>--%>
            <%--                                <p class="card-text">Thông tin lịch sủ giao dịch buôn bán bất động sản.</p>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </a>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
</div>
<script type="text/javascript">
    window.addEventListener('load', function () {
        let objPrice = document.getElementsByClassName('i-price');
        for (let i = 0; i < objPrice.length; i++) {
            if (objPrice[i].textContent != "" && !(isNaN(objPrice[i].textContent))) {
                objPrice[i].innerText = new Intl.NumberFormat('vi-VN', {maximumSignificantDigits: 3}).format(objPrice[i].textContent);
            }
        }
    });
</script>


<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
