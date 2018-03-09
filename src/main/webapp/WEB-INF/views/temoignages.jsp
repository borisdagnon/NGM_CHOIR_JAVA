<%@include file="head.jsp"%>
<div class="ui vertical stripe segment">
    <div class="ui middle aligned stackable grid container">
        <div class="row">
            <div class="eight wide column">

                <c:forEach items="${listeAudios}" var="audio" varStatus="status">
                    <h2 class="ui header"><c:out value="${audio.nom}"/></h2>
                    <audio preload="auto" controls>
                        <source src="${pageContext.request.contextPath}/resources/audios/<c:out value="${audio.nomFichier}.mp3"/>" />
                        <source src="audio.ogg" />
                        <source src="audio.wav" />
                    </audio>
                </c:forEach>

            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/audioplayer.js"></script>
<script>
    $( function()
    {
        $( 'audio' ).audioPlayer();
    });
</script>
