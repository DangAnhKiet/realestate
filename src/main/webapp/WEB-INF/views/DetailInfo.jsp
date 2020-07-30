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
            <jsp:include page="Header.jsp"/>
            <div class="card mb-3">
                <div class="wrap-img-detail">
                    <img class="card-img-top" src="/imgs/item-real/metro-background.png" alt="Card image cap">
                        <img id="i-main-avatar" class="avatar" src="/imgs/item-real/avatar-default.png"
                             alt="Avatar">
                    <div id="openUpload" class="wrap-icon-photograph">
                        <div class="img"><img src="/imgs/icons/photograph.png" alt=""></div>
                    </div>
                </div>
                <div class="card-body">
                    <h5 class="card-title">Thông tin cá nhân</h5>
                    <p class="card-text">Họ tên:</p>
                    <p class="card-text">Tài khoản đăng nhập:</p>
                    <p class="card-text">Mật khẩu:</p>
                    <p class="card-text">Điện thoại:</p>
                    <p class="card-text">Địa chỉ ví tiền:</p>
                    <p class="card-text">Địa chỉ email:</p>
<%--                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
                </div>
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
            <%--            end popup update img--%>
            <jsp:include page="Footer.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.addEventListener(('load'), function () {
        let objOpenUpload = document.getElementById('openUpload');
        let objInputUpload = document.getElementById('imgUpload');
        let objSubmitUpload = document.getElementById('submit-upload-img');
        let objHiddenFile = document.getElementById('i-file');
        let objPopupUpdateImg = document.getElementById('i-view-detail');
        let objChooseImge = document.getElementById('i-choose-image');
        let objAgreeUpload = document.getElementById('btn-agree-update-img');
        let objNameChooseFileToUpload = document.getElementById('span-choose-image');
        let objMainAvatar = document.getElementById('i-main-avatar');
        let objInputAccountForm = document.getElementById('i-account-form');
        let objAlertUploadImg = document.getElementById('i-alert-upload-img');
        let objUpdatingLand = document.getElementById('i-updating-land');

        resetAllAlert();

        function resetAllAlert() {
            // reset alert
            objAlertUploadImg.innerText = "";
            objAlertUploadImg.style.display = "none";

        }
// Access our form...
        const formUploadImage = document.getElementById( "fileUploadForm" );
        // ...to take over the submit event
        formUploadImage.addEventListener( 'submit', function ( event ) {
            event.preventDefault();
            console.log("chayj sendData");
            sendData();
        } );

        function getAvatar(){
            if(objImgIpfs != null){
                objMainAvatar.src = objImgIpfs.src;
            }
        }
        objHiddenFile.addEventListener('change', function (e) {
            let fileName = e.target.files[0].name;
            document.getElementById('span-choose-image').innerText = fileName;
            objChooseImge.style.display = "block";
        });
        objOpenUpload.addEventListener('click', function () {
            objPopupUpdateImg.style.display = "block";
        });
        objAgreeUpload.addEventListener('click', function () {
            console.log("chay ham dong y");
            if(arrSesson != null) {
                let pos = 0;
                arrSesson.forEach(element => {
                    if(pos == 1){
                        objInputAccountForm.value = element;
                    }
                    pos++;
                });
            }
            document.getElementById('btnSubmit').click();
        });

        getAvatar();
        const file = {
            dom    : objHiddenFile,
            binary : null
        };
        const reader = new FileReader();
        reader.addEventListener( "load", function () {
            file.binary = reader.result;
        } );
        // At page load, if a file is already selected, read it.
        if( file.dom.files[0] ) {
            reader.readAsBinaryString( file.dom.files[0] );
        }

        // If not, read the file once the user selects it.
        file.dom.addEventListener( "change", function () {
            if( reader.readyState === FileReader.LOADING ) {
                reader.abort();
            }

            reader.readAsBinaryString( file.dom.files[0] );
        } );
        function sendData() {
            // reset alert
            objUpdatingLand.style.display = "block";
            objAgreeUpload.classList.add("lock-button");
            // objAgreeUpload.classList.remove("lock-button");
            resetAllAlert();
            // If there is a selected file, wait it is read
            // If there is not, delay the execution of the function
            if( !file.binary && file.dom.files.length > 0 ) {
                setTimeout( sendData, 10 );
                return;
            }

            // To construct our multipart form data request,
            // We need an XMLHttpRequest instance
            const XHR = new XMLHttpRequest();

            // We need a separator to define each part of the request
            const boundary = "blob";

            // Store our body request in a string.
            let data = "";

            // So, if the user has selected a file
            if ( file.dom.files[0] ) {
                // Start a new part in our body's request
                data += "--" + boundary + "\r\n";

                // Describe it as form data
                data += 'content-disposition: form-data; '
                    // Define the name of the form data
                    + 'name="'         + file.dom.name          + '"; '
                    // Provide the real name of the file
                    + 'filename="'     + file.dom.files[0].name + '"\r\n';
                // And the MIME type of the file
                data += 'Content-Type: ' + file.dom.files[0].type + '\r\n';

                // There's a blank line between the metadata and the data
                data += '\r\n';

                // Append the binary data to our body's request
                data += file.binary + '\r\n';
            }

            // Text data is simpler
            // Start a new part in our body's request
            data += "--" + boundary + "\r\n";

            // Say it's form data, and name it
            data += 'content-disposition: form-data; name="' + objInputAccountForm.name + '"\r\n';
            // There's a blank line between the metadata and the data
            data += '\r\n';

            // Append the text data to our body's request
            data += objInputAccountForm.value + "\r\n";

            // Once we are done, "close" the body's request
            data += "--" + boundary + "--";

            // Define what happens on successful data submission
            XHR.addEventListener( 'load', function( event ) {
                let json = JSON.parse(XHR.responseText);
               if(json.success === false && json.strResult != ""){
                   objUpdatingLand.style.display = "none";
                   objAgreeUpload.classList.remove("lock-button");
                   objAlertUploadImg.innerText = json.strResult;
                   objAlertUploadImg.style.display = "initial";
               }else if(json.success === true){
                   if(json.strResult != ""){
                       objUpdatingLand.style.display = "none";
                       objAgreeUpload.classList.remove("lock-button");
                       objMainAvatar.src = json.strResult;
                       document.getElementById('i-img-ipfs').src = json.strResult;
                       document.getElementById('i-view-detail').style.display='none';
                   }else{
                       objUpdatingLand.style.display = "none";
                       objAgreeUpload.classList.remove("lock-button");
                       objMainAvatar.src = "imgs/item-real/avatar-default.png";
                       document.getElementById('i-img-ipfs').src = "imgs/item-real/avatar-default.png";
                       document.getElementById('i-view-detail').style.display='none';
                   }
               }
            } );

            // Define what happens in case of error
            XHR.addEventListener( 'error', function( event ) {
                console.log( 'Oops! Something went wrong.' +  JSON.stringify(event) );
            } );

            // Set up our request
            XHR.open( 'POST', 'http://localhost:8084/api/account/update/image' );

            // Add the required HTTP header to handle a multipart form data POST request
            XHR.setRequestHeader( 'Content-Type','multipart/form-data; boundary=' + boundary );

            // And finally, send our data.
            XHR.send( data );
        }
    });

</script>
</body>
</html>
