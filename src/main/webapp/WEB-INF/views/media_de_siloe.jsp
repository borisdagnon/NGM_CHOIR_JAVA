<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 12/01/2019
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<fmt:parseDate pattern="dd-MM-yyyy" value="${videoLaPlusRecente.formatdate}" var="date" />
<fmt:formatDate value="${date}" pattern="EEEE" var="jour"/>
<fmt:formatDate value="${date}" pattern="dd" var="numJour"/>
<fmt:formatDate value="${date}" pattern="MMMM" var="mois"/>
<fmt:formatDate value="${date}" pattern="y" var="annee"/>



<div class="contener_media_siloe" >





<div class="contener_media_siloe_carousel" >

        <div class="contener_2">
            <div class="carousel">
                <div><img class="accueil_carousel_images" src="${pageContext.request.contextPath}/resources/image/culte_restitution.png"> </div>
                <div><img  class="accueil_carousel_images" src="${pageContext.request.contextPath}/resources/image/citation.png"></div>
                <div><img  class="accueil_carousel_images" src="${pageContext.request.contextPath}/resources/image/priere.png"></div>
                <div><img  class="accueil_carousel_images" src="${pageContext.request.contextPath}/resources/image/enseignement_priere.png"></div>
            </div>
        </div>

</div>


<div class="contener_media_videoaudio_et_overflow">
        <div class="contener_media_video_audio" style="">


            <div id="contener_video_youtube" class="contener_video_youtube">
                <div class="embedresize">
                    <div>
                        <iframe allowfullscreen="" frameborder="0"  src="https://www.youtube.com/embed/<c:out value="${videoLaPlusRecente.lien}"/>" ></iframe>
                    </div>
                </div>
            </div>



            <div id="contener_audio_soundcloud" class="contener_audio_soundcloud" style="display: none">
                <!--<iframe id="soundcloudplayer" width="100px" height="166" scrolling="no" frameborder="no" allow="autoplay" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/647988643&color=%23ffa51c&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true"></iframe>
-->
            </div>






            <div class="contener_media_video_audio_titre" style="text-align: left">

                <p id="ajax_titre_video"><b>Titre : </b><span id="ajax_titre_video_put"><c:out value="${videoLaPlusRecente.titre}"/></span></p>
                <p id="ajax_titre_orateur"><b>Orateur</b> : <span id="ajax_titre_orateur_put"><c:out value="${videoLaPlusRecente.orateur.appele}"/> <c:out value="${videoLaPlusRecente.orateur.aka}"/></span></p>
                <p id="ajax_titre_date"><b>Date</b> : <span id="ajax_titre_date_put">
    <span style="text-transform: capitalize"><c:out value="${jour}"/> <c:out value="${numJour}"/> <c:out value="${mois}"/> <c:out value="${annee}"/></span>
    </span>
                </p>



            </div>

        </div>


        <div class="contener_media_siloe_overflow" >


            <ul id="tabs">
                <li><a href="#" name="tab1">CGF</a></li>
                <li><a href="#" name="tab2">2019</a></li>
            </ul>

            <div id="content">
                <div id="tab1">


                        <div class="contener_media_media" >

                            <c:forEach items="${listeVideos}" var="l">

                                <button class="accordion" ><span><c:out value="${l.titre}"/></span><div class="icon_chevron"><i class="fas fa-chevron-circle-right"></i></div></button>
                                <div class="panel">
                                    <div class="cadre_photos">
                                        <img style="width: inherit;height: auto" src="${pageContext.request.contextPath}/resources/image/orateurs/orateur_elom.PNG">
                                    </div>

                                    <div class="contener_infos_et_icones">


                                    <div class="cadre_infos" >
                                        <p class="titre_video"><c:out value="${l.titre}"/></p>
                                        <p class="orateur">Pasteur <c:out value="${l.orateur.aka}"/></p>
                                        <p class="date_video">
                                            <c:set var = "jourLettre1" value = "" />
                                            <c:set var = "jourAutresLettres" value = "" />
                                            <c:set var = "jourLettre1" value = "" />
                                            <c:set var = "moisLettre1" value = "" />
                                            <c:set var = "moisAutresLettres" value = "" />
                                            <c:set var = "moisLettre1" value = "" />
                                            <fmt:parseDate pattern="dd-MM-yyyy" value="${l.formatdate}" var="date" />
                                            <fmt:formatDate value="${date}" pattern="EEEE" var="jour"/>
                                            <fmt:formatDate value="${date}" pattern="dd" var="numJour"/>
                                            <fmt:formatDate value="${date}" pattern="MMMM" var="mois"/>
                                            <fmt:formatDate value="${date}" pattern="y" var="annee"/>



                                            <span style="text-transform: capitalize"><c:out value="${jour}"/>
    <c:out value="${numJour}"/>
    <c:out value="${mois}"/>
    <c:out value="${annee}"/>
</span>


                                        </p>
                                    </div>


                                    <c:choose>
                                        <c:when test="${l.lien!=null}">
                                            <div class="cadre_icone_film" >
                                                <a><i id="<c:out value="${l.id}"/>" class="fas fa-film"></i></a>
                                            </div>

                                            <div class="cadre_icone_audio" >
                                                <a><i id="<c:out value="${l.id}"/>" class="fas fa-volume-up"></i></a>
                                            </div>

                                        </c:when>








                                        <c:when test="${l.lien==null}">
                                            <div class="cadre_icone_film" >
                                                <i class="fas fa-film"></i>
                                            </div>

                                            <div class="cadre_icone_audio" >
                                                <i class="fas fa-volume-up"></i>
                                            </div>
                                        </c:when>


                                    </c:choose>



                                </div>
                                </div>
                            </c:forEach>




                        </div>

                </div>
                <div id="tab2"></div>
            </div>




        </div>
    </div>

</div>








<%@include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/mobile_player.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/slick-1.8.1/slick/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/media_siloe.js"></script>

<script>
    $( window ).resize(function() {

        if($(window).width()<$(".contener_media_siloe ").width()){
            $("html").css("width",$(".contener_media_siloe ").width())
        }else {
            $("html").css("width",$(window).width())
        }

    });
    $("html").css("height",$(".container ").height()+300)
</script>
<script>


    $('.carousel').slick({
        dots:false,
        arrows:false,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay:true,
        autoplaySpeed: 5000

    });



    $(".accordion").on("click",function () {
       $class= $(this).find("i").attr("class");
       if($class==="fas fa-chevron-circle-right"){

           $(this).find("i").removeClass("fas fa-chevron-circle-right");
           $(this).find("i").addClass("fas fa-chevron-circle-down");
       }else {
           $(this).find("i").removeClass("fas fa-chevron-circle-down");
           $(this).find("i").addClass("fas fa-chevron-circle-right");
       }
    });

    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }

</script>
