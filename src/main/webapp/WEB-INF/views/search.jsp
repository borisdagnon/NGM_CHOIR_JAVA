<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 05/03/2018
  Time: 01:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<div class="ui vertical stripe segment">
    <div class="ui middle aligned stackable grid container">

       <h1 class="ui header" style="margin-top: 5px"> <i class="search icon"></i> R&eacute;sultat des recherches</h1>


        <!-- Row pour l'audio ou témoignages -->
        <div class="ui center aligned text container" style="line-height: 3px; border-bottom: solid; margin-top: 160px">
            <h2 class="ui header"><i class="comment icon"></i>T&eacute;moignages</h2>
        </div>
        <div class="row">
            <div class="eight wide column">

                <c:choose>

                    <c:when test="${!empty SearchAudios}">


                        <c:forEach items="${SearchAudios}" var="audio" varStatus="status">
                            <h3 class="ui header"><c:out value="${audio.nom}"/></h3>
                            <audio preload="auto" controls>
                                <source src="${pageContext.request.contextPath}/resources/audios/<c:out value="${audio.nomFichier}.mp3"/>" />
                                <source src="audio.ogg" />
                                <source src="audio.wav" />
                            </audio>
                        </c:forEach>

                    </c:when>

                    <c:otherwise>
                        <h2 class="ui header">pas de r&eacute;sultats...</h2>
                    </c:otherwise>

                </c:choose>




            </div>
        </div>
        <!-- Row pour l'audio ou témoignages -->






<!--Row pour les messages video -->
        <div class="ui center aligned text container" style="line-height: 3px; border-bottom: solid; margin-top: 160px">
            <h2 class="ui header"><i class="fire icon"></i>Pr&eacute;dications</h2>
        </div>
        <div class="row">

            <div class="eight wide column">


                <c:choose>

                    <c:when test="${!empty SearchVideos}">


                        <h2 class="ui header">${fn:length(SearchVideos)} r&eacute;sultats...</h2>

                    <ul id="svList">
                        <div class="ui center aligned container">
                        <c:forEach items="${SearchVideos}" var="v" varStatus="index">


                            <li class="svThumb ytVideo" style="width: 450px; height: 280px" data-videoID="<c:out value="${v.lien}"/>"><c:out value="${v.titre}"/></li>

                        </c:forEach>
                        </div>
                    </ul>
                    </c:when>

                    <c:otherwise>
                        <h2 class="ui header">pas de r&eacute;sultats...</h2>
                    </c:otherwise>
                </c:choose>



            </div>

        </div>

<!--Row pour les messages video -->



        <div class="ui center aligned text container" style="line-height: 3px; border-bottom: solid; margin-top: 160px">
            <h2 class="ui header"><i class="file alternate outline icon"></i>Louanges</h2>
        </div>
        <div class="row">
            <div class="eight wide column">

                <c:choose>

                    <c:when test="${!empty SearchLouanges}">

                        <h2 class="ui header">${fn:length(SearchLouanges)} r&eacute;sultats...</h2>

                        <c:forEach items="${SearchLouanges}" var="l">

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

                    </c:when>

                    <c:otherwise>
                        <h2 class="ui header">pas de r&eacute;sultats...</h2>
                    </c:otherwise>

                </c:choose>




            </div>
        </div>






    </div>
</div>

<%@include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/speedvault.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/audioplayer.js"></script>
<script>
    $( function()
    {
        $( 'audio' ).audioPlayer();
    });
</script>