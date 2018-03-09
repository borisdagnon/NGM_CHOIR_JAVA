<%@include file="head.jsp"%>

<div class="ui center aligned container text">

    <div class="ui text container" style="margin-top: 12px; margin-bottom: 12px">
        <h2 class="ui header">Filtrer par Ann&eacute;es:</h2>
    </div>
    <div class="ui fluid selection dropdown">
        <input name="user" type="hidden">
        <i class="dropdown icon"></i>
        <div class="default text">Ann&eacute;e</div>
        <div class="menu">
            <div class="item"  data-value="Toutes">
                <i class="file video icon"></i>
                Toutes
            </div>
<c:forEach items="${listeAnnees}" var="a" >

            <div class="item something"  data-value="<c:out value="${a}"/>">
                <i class="file video icon"></i>
                <c:out value="${a}"/>
            </div>

</c:forEach>
        </div>
    </div>

</div>


<div class="ui vertical stripe segment aligned centered">

    <div class="ui three column horizontally padded grid">


        <div class="equal height row">


            <c:forEach items="${listeVideos}" var="l" varStatus="index">


        <div class="column" id="videos_<c:out value="${index.index}"/>" name="<c:out value="${l.annee}"/>">
            <div class="wrapper">
            <div class="youtube"  data-embed="<c:out value="${l.lien}"/>">

                <!-- (2) the "play" button -->
                <div class="play-button"></div>

            </div>

                <div class="ui message">
                    <div ></div>
                    <div class="header">
                        <c:out value="${l.titre}"/>
                    </div>

                    <p><i class="calendar alternate outline icon"></i><c:out value="${l.format}"/></p>
                </div>

            </div>


        </div>


</c:forEach>


</div>
    </div>
</div>
<%@include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/dropdown.js"></script>

