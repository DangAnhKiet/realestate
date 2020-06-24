<%--
  Created by IntelliJ IDEA.
  User: hauphvn
  Date: 5/8/2020
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/head_tag.jsp">
    <jsp:param name="title" value="Management Real Estate"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h3 style="text-align: center;margin-top: 14px;">QUẢN LÍ ĐẤT</h3>
            <div class="wrap-address">
                <span><strong>Tài khoản hiện tại:</strong>
                <span>0x6787654567545675456754</span>
                </span>
                <input type="button" id="i-update-address" class="btn btn-success" value="Cập nhập">
                <div class="info-user">
                    <span><strong>Phạm văn hậu</strong></span>
                    <img id="i-logout" src="../../imgs/icons/sign-out-alt-solid.svg" alt="">
                </div>
            </div>
            <div class="wrap-item">
                <img src="../../imgs/item-real/200.png" alt="hinh-mau">
                <img src="../../imgs/item-real/200.png" alt="hinh-mau">
                <img src="../../imgs/item-real/200.png" alt="hinh-mau">
                <img src="../../imgs/item-real/200.png" alt="hinh-mau">
                <img src="../../imgs/item-real/200.png" alt="hinh-mau">
            </div>

            <div class="wrap-adding">
                <div class="wrap-select-district">
                    <select class="ui dropdown select-district">
                        <option value="">Tên quận</option>
                        <option value="1-district">Quận 1</option>
                        <option value="2-district">Quận 2</option>
                        <option value="3-district">Quận 3</option>
                        <option value="4-district">Quận 4</option>
                        <option value="5-district">Quận 5</option>
                    </select>
                </div>
                <div class="wrap-select-street">
                    <select class="ui dropdown select-district">
                        <option value="">Tên đường</option>
                        <option value="">Cao thắng</option>
                        <option value="">Trần hưng đạo</option>
                        <option value="">Lê lai</option>
                        <option value="">Hoàng văn thụ</option>
                        <option value="">3 tháng 2</option>
                        <option value="">An dương vương</option>
                    </select>
                </div>
                <div class="wrap-price">
                    <lable for="price">Giá bán(VNĐ)</lable>
                    <input type="text" id="price">
                </div>
                <div class="wrap-upload-img">
                        <label for="img">Hình ảnh:</label>
                        <input type="file" id="img" name="img" accept="image/*">
                </div>
                <div style="margin-bottom: 5px;"><input type="button" id="i-btn-adding"value="Đăng bán"class="btn btn-primary"></div>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
</script>
<jsp:include page="/WEB-INF/foot_tag.jsp"/>
<%--<script src="./ProjectTruffle/src/js/truffle-contract.js"></script>--%>
<%--<script src="./ProjectTruffle/src/js/web3.min.js"></script>--%>
</body>
</html>
