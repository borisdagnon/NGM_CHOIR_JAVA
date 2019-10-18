<%@include file="head.jsp"%>



<div  class="contener_programmes_1">


<c:forEach items="${listeProgrammes}" var="lp">

    <div style="" class="contener_programmes_2">
<!-- Trigger/Open The Modal -->
<button class="programmes_button" id="modal_${lp.id}" name="myBtn">  <img class="programmes_images"  src="${pageContext.request.contextPath}/resources/image/programmes/<c:out value="${lp.nomphoto}"/>"></button>

<!-- The Modal -->
<div  id="myModal_${lp.id}" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span id="span_${lp.id}" class="close">&times;</span>
            <h2><c:choose>
                <c:when test="${lp.titre=='Reunion de Priere'}">
                    R&eacute;union de Pri&egrave;re
                </c:when>
                <c:when test="${lp.titre=='Aux Captifs La Delivrance'}">
                    Aux Captifs La D&eacute;livrance
                </c:when>
                <c:otherwise>
                    <c:out value="${lp.titre}"/>
                </c:otherwise>
            </c:choose></h2>
        </div>
        <div class="modal-body">
            <p>${fn:replace(fn:replace(lp.contenu, '&lt;','<'), '&gt;','>')}</p>
        </div>
        <div class="modal-footer">
            <c:choose>
                <c:when test="${lp.titre=='Femmes Influentes'}">
                    <img  class="image_footer_modal" src="${pageContext.request.contextPath}/resources/image/programmes/programme_femmes_times.png" >
                </c:when>
                <c:when test="${lp.titre == 'Reunion de Priere'}">
                    <img  class="image_footer_modal" src="${pageContext.request.contextPath}/resources/image/programmes/programme_priere_times.png" >
                </c:when>
                <c:when test="${lp.titre=='Enseignements'}">
                    <img  class="image_footer_modal" src="${pageContext.request.contextPath}/resources/image/programmes/programme_enseignement_times.png" >
                </c:when>
                <c:when test="${lp.titre=='Culte de Restitution'}">
                    <img  class="image_footer_modal" src="${pageContext.request.contextPath}/resources/image/programmes/programme_culte_times.png" >
                </c:when>
                <c:when test="${lp.titre=='Aux Captifs La Delivrance'}">
                    <img  class="image_footer_modal" src="${pageContext.request.contextPath}/resources/image/programmes/programme_veillee_times.png" >
                </c:when>

            </c:choose>
        </div>
    </div>

</div>


    </div>
</c:forEach>
</div>
<%@ include file="footer.jsp"%>

<script>
    $( window ).resize(function() {

        if($(window).width()<$(".contener_programmes_1 ").width()){
            $("html").css("width",$(".contener_programmes_1 ").width())
        }else {
            $("html").css("width",$(window).width())
        }

    });
    $("html").css("height",$(".container ").height()+300)
</script>
<script src="${pageContext.request.contextPath}/resources/js/programmes.js"></script>
