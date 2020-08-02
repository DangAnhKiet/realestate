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
                <div class="col-sm-12">
                    <a href="/admin/land/add">
                        <div class="item-manage-land card">
                            <div class="card-body">
                                <h5 class="card-title">Thêm bất động sản</h5>
                                <p class="card-text">Đăng kí thông tin và đăng lên hệ thống blockchain và sàn giao
                                    dịch.</p>
                            </div>
                        </div>
                    </a>
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
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>

</div>


<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
