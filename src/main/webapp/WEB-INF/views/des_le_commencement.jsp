<%@include file="head.jsp"%>


<div class="contener_global_des_le_commencement">

    <div class="contener_des_le_commencement_top">

        <div class="contener_bloc_gauche_top" >
            <img class="contener_bloc_gauche_top_image" src="${pageContext.request.contextPath}/resources/image/top_gauche_des_le_commencement.png"/>
            <h3 class="contener_bloc_gauche_top_titre"><b>D&egrave;s Le Commencement</b></h3>


        </div>

        <div style="display: none" class="contener_bloc_droite_top">
            <h3><b>Description</b></h3>
            <p>...</p>
        </div>


    </div>

    <div class="contener_des_le_commencement_bottom">

        <div class="contener_bloc_gauche_bottom">

        </div>

        <div class="contener_bloc_droite_bottom">
            <c:forEach items="${lesEnseignements}" var="l">



            <a class="contener_bloc_a" href="des_le_commencement/article/<c:out value="${l.id}"/>" style="color: #000000">
                <div class="article" >

                    <div class="contener_bloc_droite_bottom_image" >
                        <img class="thumbnail" src="${pageContext.request.contextPath}/resources/image/des_le_commencement/<c:out value="${l.nomphoto}"/>" style="height: inherit;width: inherit">
                    </div>

                    <div class="contener_bloc_droite_bottom_text">
                        <div class="contener_bloc_droite_bottom_text_titre">
                            <b>
                                <c:out value="${l.titre}"/>
                            </b>
                        </div>
                        <div class="contener_bloc_droite_bottom_text_categorie">

                            <img src="${pageContext.request.contextPath}/resources/image/top_gauche_des_le_commencement.png" class="contener_bloc_droite_bottom_text_categorie_img"><p>Par D&egrave;s le Commencement <c:out value="${l.annee}"/> <c:out value="${mois}"/> <c:out value="${annee}"/></p>
                        </div>

                        <div class="contener_bloc_droite_bottom_text_resume">
                            <p><c:out value="${l.resume}"/></p>

                        </div>
                    </div>

                </div>

            </a>
                </c:forEach>

        </div>


    </div>

</div>

<script src="${pageContext.request.contextPath}/resources/js/dropdown.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pagination_ajax.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/speedvault.js"></script>
<%@include file="footer.jsp"%>



