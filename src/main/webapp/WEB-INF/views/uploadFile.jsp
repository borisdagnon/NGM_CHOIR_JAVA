<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 12/08/2018
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<div class="ui vertical stripe segment">
    <div class="ui middle aligned stackable grid container">

        <form id="upload-file-form">
            <label for="upload-file-input">Upload your file:</label>
            <input id="upload-file-input" type="file" name="uploadfile" accept="*" />
        </form>

    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/uploadFile.js"></script>
<%@include file="footer.jsp"%>
