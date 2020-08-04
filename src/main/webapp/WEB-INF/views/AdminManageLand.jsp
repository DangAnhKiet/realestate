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
                <%--                <div class="col-sm-6">--%>
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
                <%--                                <p class="card-text">Đăng kí thông tin và đăng lên hệ thống blockchain và sàn giao--%>
                <%--                                    dịch.</p>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </a>--%>
                <%--                </div>--%>
                <%--                <br>--%>
                <div class="col-sm-12">

                    <nav class="navbar navbar-light bg-light wrap-nav-account">
                        <div style="display: flex; width: 267px;">
                            <div>
                                <input class="form-control" id="i-land-id" type="search"
                                       placeholder="Nhập thông tin lô đất" aria-label="Search">
                            </div>
                            <div>
                                <button id="i-get-account" style="margin-left: 3px;font-weight: 600"
                                        class="btn btn-outline-success my-2 my-sm-0"
                                        type="button"><span style="margin-left: 3px">Tìm</span></button>
                                <div class="w3-section w3-center">
                                    <p><span id="i-error-content" style="font-weight: 600;"></span></p>
                                </div>
                            </div>
                        </div>
                        <div><a href="/admin/land/add">
                            <button type="button" class="button">Đăng kí bất động sản mới</button>
                        </a></div>
                    </nav>
                    <br>
                    <div class="row">
                        <%--                        <c:if test="${not empty requestScope.listLands}">--%>
                        <%--                            <c:forEach items="${requestScope.listLands}" var="i">--%>
                        <div class="col-sm-12">
                            <div class="card my-card-home">
                                <img id="i-image" class="card-img-bottom-new"
                                     src="https://ipfs.io/ipfs/QmZ984JBrf5w4S7k5jb9LHTCNtzZ9oxUxb63N9uF9KDAjc"
                                     alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Người bán: <span id="i-seller"></span>
                                    </h5>
                                    <h5 class="card-title">Người mua: <span id="i-buyer"></span>
                                    </h5>
                                    <h5 class="card-title">Giá bán: <span id="i-price"></span> VNĐ
                                    </h5>
                                    <h5 class="card-title">Thời gian bán: <span id="i-time"></span>
                                    </h5>
                                </div>
                            </div>
                        </div>
                        <%--                            </c:forEach>--%>
                        <%--                        </c:if>--%>
                        <%--                        <c:if test="${empty requestScope.listLands}">--%>
                        <%--                            <div class="col sm 12">--%>
                        <%--                                <h4 style="text-align: center; padding-bottom: 20%; padding-top: 10%;">Không tìm thấy--%>
                        <%--                                    lịch sử--%>
                        <%--                                    giao dịch</h4>--%>
                        <%--                            </div>--%>
                        <%--                        </c:if>--%>
                    </div>


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
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>

</div>
<script type="text/javascript">
    window.addEventListener(('load'), function () {
        //get history by landId
        let objButtonUpdatePrivateKey = document.getElementById('i-land-id');
        objButtonUpdatePrivateKey.addEventListener('click', function () {
            // document.getElementById('i-p-alert-private-key').style.display = "none";
            // if (document.getElementById('i-land-id').value.length != 64) {
            //     document.getElementById('i-p-alert-private-key').innerText = "Khóa riêng tư không đúng. Vui lòng nhập lại";
            //     document.getElementById('i-p-alert-private-key').style.display = "block";
            //
            // } else {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: 'http://localhost:8084/api/land/history',
                data: JSON.stringify({
                    "privateKey": document.getElementById('i-land-id').value
                }),
                success: function (objResponse) {
                    if (objResponse !== null) {
                        document.getElementById('i-time').innerText = objResponse.timestamp;
                        document.getElementById("i-buyer").innerText = objResponse.buyer;
                        document.getElementById('i-seller').innerText = objResponse.seller;
                        document.getElementById('i-price').innerText = objResponse.price;
                        document.getElementById('i-image').innerText = objResponse.image;
                        // document.getElementById('i-update-private-key').style.display = "none";
                        // document.getElementById('i-status-success').style.display = "block";
                    } else {
                        document.getElementById('i-error-content').innerText =
                            "không thể tìm thấy lịch sử";
                        // document.getElementById('i-content-update').style.display = "none";
                        // document.getElementById('i-status-fail').style.display = "block";
                        // document.getElementById('i-get-account').style.display = "none";

                    }
                }
            });
            // }
        });
    });
</script>

<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
