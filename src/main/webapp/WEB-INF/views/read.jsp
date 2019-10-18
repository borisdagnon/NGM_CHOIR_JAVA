<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 30/12/2018
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<div class="container" style="font-family: Raleway">
    <div class="row justify-content-center"><p style="font-size: 3em"><c:out value="${unEnseignement.titre}"/></p></div>
    <div class="row justify-content-left">
        <div class="col-md-4"><img style="width: 640px;height: 480px" src="${pageContext.request.contextPath}/resources/image/photo_enseignement/<c:out value="${unEnseignement.nomphoto}"/>"></div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-8">
<c:out value="${unEnseignement.contenu}"/>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
