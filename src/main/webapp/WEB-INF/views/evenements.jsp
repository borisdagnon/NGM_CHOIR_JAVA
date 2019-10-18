<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 06/04/2018
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>

<%@include file="head.jsp"%>
<h3>Example heading <span class="label label-default">New</span></h3>
<div class="container">

    <c:forEach items="${listeEvenements}" var="l">
        <h2 >
            <img src="${pageContext.request.contextPath}/resources/image/plugin.png">
            <div class="content">
                <c:out value="${l.titre}"/>
                <div class="panel panel-default">
                    <div class="panel-body">
                       <c:out value="${l.description}"/>
                    </div>
                </div>

            </div>
        </h2>
        ${fn:replace(fn:replace(l.contenu, '&lt;','<'), '&gt;','>')}

    </c:forEach>

</div>

<%@include file="footer.jsp"%>
