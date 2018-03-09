<%@include file="head.jsp"%>
<div class="ui vertical stripe segment">
    <div class="ui middle aligned stackable grid container">

        <c:forEach items="${listeLouanges}" var="l">

            <div class="row">
                <div class="six wide column">

                    <div class="ui message">
                        <h2 class="ui centered aligned header"><c:out value="${l.nom}"/></h2>

                            ${fn:replace(fn:replace(l.lyrics, '&lt;','<'), '&gt;','>')}
                    </div>

                </div>
                <div class="four wide column">

                </div>
            </div>

        </c:forEach>


    </div>
</div>
<%@include file="footer.jsp"%>