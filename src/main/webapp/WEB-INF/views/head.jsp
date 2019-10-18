<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 20/08/2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html class="no-js" lang="fr">
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglibs.jsp"%>
<head>
    <sec:csrfMetaTags/>
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-135042385-1"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());
        gtag('config', 'UA-135042385-1');
    </script>

    <meta meta name="viewport" content=
            "width=device-width, user-scalable=yes" />
    <meta charset="utf-8" />
    <meta http-equiv="Content-Security-Policy">
    <meta name="description" content="Centre Grâce & Foi, est une église et assemblée, située à angers, dans le Maine-Et-Loire, pour annoncer l'evangile" />
    <meta name="msvalidate.01" content="CA060253A05BFA7FFD8CD937E3F1F149" />
    <meta name="google-site-verification" content="Ao_Cg_k6GzkNo8Jysfya9LK826Jj_rSrrWqe1Ga8_HU" />
    <meta property="og:title" content="Église Centre Grâce et Foi" />
    <meta property="og:type" content="article" />
    <meta property="og:url" content="http://www.centregracefoi.com/" />
    <meta property="og:image" content="http://www.centregracefoi.com/resources/image/invite_bande.png" />




    <!-- Site Properties -->
    <title>${titre}</title>
    <script type="application/ld+json"> { "@context" : "http://schema.org", "@type" : "Article","name" : "Ils rebâtiront sur d'anciennes", "author" : { "@type" : "Person", "name" : "Église Évangélique Angers Centre Grâce & Foi" }, "image" : "http://www.centregracefoi.com/resources/image/Flyer.png", "articleBody" : "Centre Grâce et Foi - Ils rebâtiront sur d'anciennes ruines...", "url" : "http://www.centregracefoi.com/messages" } </script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/G&F.png">

    <%@include file="link.jsp"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/responsive.css"/>

    <c:choose>
        <c:when test="${titre=='Centre de Grâce et Foi | Programmes'}">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/programmes.css"/>
        </c:when>
        <c:when test="${titre=='Centre de Grâce et Foi | Mandat'}">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mandat.css"/>
        </c:when>
        <c:when test="${titre=='Centre de Grâce et Foi | Média de Siloé'}">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/media_de_siloe.css"/>
            <link href="${pageContext.request.contextPath}/resources/AudioPlayer/jPlayer-2.9.2/dist/skin/blue.monday/css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/mobile_player.css" />

        </c:when>
        <c:when test="${titre=='Centre de Grâce et Foi | Dès le Commancement'}">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/des_le_commencement.css"/>
        </c:when>
        <c:when test="${titre=='Centre de Grâce et Foi | Dès le Commancement - Article'}">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/des_le_commencement_article.css"/>
        </c:when>
        <c:otherwise>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css"/>

        </c:otherwise>
    </c:choose>


</head>
<body style="">


<c:choose>
    <c:when test="${titre=='Centre de Grâce et Foi | Accueil'}"><c:set var="actA" value="active"/> </c:when>
    <c:when test="${titre=='Centre de Grâce et Foi | Enseignements'}"><c:set var="actEN" value="active"/> </c:when>
    <c:when test="${titre=='Centre de Grâce et Foi | Témoignages'}"><c:set var="actT" value="active"/> </c:when>
    <c:when test="${titre=='Centre de Grâce et Foi | Reccueil de Chants'}"><c:set var="actL" value="active"/> </c:when>
    <c:when test="${titre=='Centre de Grâce et Foi | Évènements'}"><c:set var="actEV" value="active"/> </c:when>
    <c:when test="${titre=='Centre de Grâce et Foi | Programmes'}"><c:set var="actP" value="active"/> </c:when>
</c:choose>


    <style>
        /*icon styles*/
        .fi-social-facebook {
            color: dodgerblue;
            font-size: 2rem;
        }
        .fi-social-youtube {
            color: red;
            font-size: 2rem;
        }
        .fi-social-pinterest {
            color: darkred;
            font-size: 2rem;
        }
        i.fi-social-instagram {
            color: brown;
            font-size: 2rem;
        }
        i.fi-social-tumblr {
            color: navy;
            font-size: 2rem;
        }
        .fi-social-twitter {
            color: skyblue;
            font-size: 2rem;
        }

    </style>
    <header>



    </header>

<div class="image_arriere_plan">
    <video autoplay muted loop id="myVideo" >
        <source src="${pageContext.request.contextPath}/resources/video/New%20G&F.mp4" type="video/mp4">
        Your browser does not support HTML5 video.
    </video>


    <div class="bloc_1" >


        <div class="container" >

            <div class="contener_1">

                <div class="division_2">
                    <a href="/"><img class="accueil_image_logo" src="${pageContext.request.contextPath}/resources/image/New_G&F.png"></a>
                </div>

                <div class="division_1">
                    <nav>
                        <ul>
                            <li>
                                <a href="/programmes">Programmes</a>
                            </li>
                            <li>
                                <a href="/mandat">Mandat</a>
                            </li>
                            <li>
                                <a href="/contact">Contact</a>
                            </li>
                            <li>
                                <a href="/des_le_commencement">D&egrave;s Le Commencement</a>
                            </li>
                            <li>
                                <a href="/media_de_siloe">M&eacute;dia Silo&eacute;</a>
                            </li>
                        </ul>
                    </nav>
                </div>



            </div>



        </div>





    </div>



