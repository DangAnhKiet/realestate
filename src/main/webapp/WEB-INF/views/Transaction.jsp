<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Giao dịch mua bán"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="Header.jsp"/>

            <%--            Popup update img--%>
            <div class="w3-container">
                <div id="i-view-detail" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">

                        <div class="w3-center"><br>
                            <span onclick="document.getElementById('i-view-detail').style.display='none'"
                                  class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                            <img style="width: 100px;" src="/imgs/item-real/alert.png">
                        </div>
                        <div class="w3-section w3-center">
                            <h3>Cập nhật ảnh đại diện <span id="img-title" style="font-weight: 600;"></span></h3>
                            <form id="fileUploadForm" method="post" enctype="multipart/form-data">
                                <input style="margin-bottom: 12px;" type="button" id="imgUpload" value="Chọn ảnh"
                                       onclick="document.getElementById('i-file').click();"/>
                                <input type="file" style="display:none;" id="i-file" name="myImage"
                                       accept="image/*"/>
                                <input type="text" name="myAccount" id="i-account-form"
                                       style="display:
                                none">
                                <input type="submit" style="display: none" id="btnSubmit">
                            </form>
                            <p id="i-choose-image" style="font-weight: 600; display: none;">Ảnh đã chọn: <span id="span-choose-image"></span></p>
                            <div style="display: none;left: 45%;" id="i-updating-land" class="lds-hourglass"></div>
                            <span class="alert alert-danger" id="i-alert-upload-img" style="display: none"></span>
                        </div>

                        <div style="text-align: right; padding-right: 10px;">
                            <hr>
                            <button onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="button">Đóng
                            </button>
                            <button id="btn-agree-update-img" style="margin-right: 3px;"
                                    type="button"
                                    class="button">Đồng ý
                            </button>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.addEventListener(('load'), function () {

        });
</script>
</body>
</html>
