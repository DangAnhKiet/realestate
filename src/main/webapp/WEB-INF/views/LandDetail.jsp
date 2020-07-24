<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head_tag.jsp">
    <jsp:param name="title" value="Thông tin chi tiết"/>
    <jsp:param name="link-css-this-page" value="../css/manage-real.css"/>
</jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="admin-header.jsp"/>
            <div class="card mb-3">
                <div class="wrap-img-detail">
                    <img class="card-img-top" src="/imgs/item-real/metro-background.png" alt="Card image cap">
                    <img class="avatar" src="https://i.pravatar.cc/300" alt="Avatar">
                    <%--                    <form id="form2Submit" action="/account/update/image" method="post" enctype="multipart/form-data">--%>
                    <div id="openUpload" class="wrap-icon-photograph">
                        <div class="img"><img src="/imgs/icons/photograph.png" alt=""></div>
                        <%--                        <div class="alt"><p>Cập nhật hình đại diện</p></div>--%>
                    </div>
                    <%--                    </form>--%>
                </div>
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a
                        little bit longer.</p>
                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a
                        little bit longer.</p>
                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                </div>
                <img class="card-img-bottom" src="/imgs/item-real/background-building6.png" alt="Card image cap">
            </div>
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
                                <input type="file" style="display:none;" id="i-file" name="file" accept="image/*"/>
                                <input type="submit" style="display: none" id="btnSubmit">
                            </form>
                            <p id="i-choose-image" style="font-weight: 600; display: none;">Ảnh đã chọn: <span id="span-choose-image"></span></p>
                        </div>
                        <div style="text-align: right; padding-right: 10px;">
                            <hr>
                            <button onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="btn btn-danger">Đóng
                            </button>
                            <button id="btn-agree-update-img" style="margin-right: 3px;"
                                    onclick="document.getElementById('i-view-detail').style.display='none'"
                                    type="button"
                                    class="btn btn-primary">Đồng ý
                            </button>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
            <%--            end popup update img--%>
        </div>
    </div>
</div>
<script type="text/javascript">
    var objOpenUpload = document.getElementById('openUpload');
    var objInputUpload = document.getElementById('imgUpload');
    var objSubmitUpload = document.getElementById('submit-upload-img');
    var objHiddenFile = document.getElementById('i-file');
    var objPopupUpdateImg = document.getElementById('i-view-detail');
    var objChooseImge = document.getElementById('i-choose-image');
    var objAgreeUpload = document.getElementById('btn-agree-update-img');
    var objNameChooseFileToUpload = document.getElementById('span-choose-image');

    objHiddenFile.addEventListener('change', function (e) {
        let fileName = e.target.files[0].name;
        document.getElementById('span-choose-image').innerText = fileName;
        objChooseImge.style.display = "block";
    });
    objOpenUpload.addEventListener('click', function () {
        objPopupUpdateImg.style.display = "block";
    });
    objAgreeUpload.addEventListener('click', function () {
        if (objNameChooseFileToUpload.innerText != "") {
            let thisText = objHiddenFile.value;
            let thisImage = objHiddenFile.files[0];
            let formdata = new FormData();
            formdata.append("thisText", thisText);
            formdata.append("thisImage", thisImage);
            // document.getElementById('btnSubmit').click();
            //stop submit the form, we will post it manually.
            // event.preventDefault();

            // Get form
            var form = $('#fileUploadForm')[0];

            // Create an FormData object
            var data = new FormData(form);

            // If you want to add an extra field for the FormData
            data.append("CustomField", "This is some extra data, testing");

            // disabled the submit button
            // $("#btnSubmit").prop("disabled", true);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8084/account/update/image",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {

                    // $("#result").text(data);
                    console.log("SUCCESS : ", data);
                    // $("#btnSubmit").prop("disabled", false);

                },
                error: function (e) {

                    // $("#result").text(e.responseText);
                    console.log("ERROR : ", e);
                    // $("#btnSubmit").prop("disabled", false);

                }
            });
        }
    });
</script>
</body>
</html>
