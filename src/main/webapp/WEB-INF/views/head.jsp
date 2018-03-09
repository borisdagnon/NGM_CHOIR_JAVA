<!DOCTYPE html>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglibs.jsp"%>
<head>
    <meta charset="UTF-8">
    <title>${titre}</title>
    <%@include file="link.jsp"%>


    <%@include file="script.jsp"%>


</head>
<body class="pushable">
<c:set value="" var="actA"/>
<c:set value="" var="actM"/>
<c:choose>
<c:when test="${titre=='Accueil'}"><c:set var="actA" value="active"/> </c:when>
<c:when test="${titre=='Messages'}"><c:set var="actM" value="active"/> </c:when>
<c:when test="${titre=='Témoignages'}"><c:set var="actT" value="active"/> </c:when>
</c:choose>


<div class="ui large top fixed menu transition hidden">



        <a class="toc item">
            <i class="sidebar icon"></i>
        </a>

        <a class="<c:out value="${actA}"/> item" href="/">
            Accueil
        </a>
        <a class="<c:out value="${actM}"/> item" href="messages">
            Prédications
        </a>
        <a class="<c:out value="${actT}"/> item" href="temoignages">
            Témoignages
        </a>
        <a class="<c:out value="${actT}"/> item" href="louanges">
            Louanges
        </a>



</div>


<!-- Sidebar Menu -->
<div class="ui vertical inverted sidebar menu left">
    <a class="<c:out value="${actA}"/> item" href="/">
        Accueil
    </a>
    <a class="<c:out value="${actM}"/> item" href="messages">
        Prédications
    </a>
    <a class="<c:out value="${actT}"/> item" href="temoignages">
        Témoignages
    </a>
    <a class="<c:out value="${actT}"/> item" href="louanges">
        Louanges
    </a>
</div>



<div class="pusher">
<div class="ui inverted vertical masthead center aligned segment">
<div class="ui container">

    <div class="ui large secondary inverted pointing menu" >



        <a class="toc item">
            <i class="sidebar icon"></i>
        </a>

        <a class="<c:out value="${actA}"/> item" href="/">
            Accueil
        </a>
        <a class="<c:out value="${actM}"/> item" href="messages">
            Prédications
        </a>

        <a class="<c:out value="${actT}"/> item" href="temoignages">
            Témoignages
        </a>

        <a class="<c:out value="${actT}"/> item" href="louanges">
            Louanges
        </a>

        <div class="right menu" >
            <div class="item" >
                <div class="ui transparent icon input" >

                    <form action="search">

                        <div class="ui search">
                            <div class="ui icon input">
                                <input class="prompt" placeholder="Search countries..." type="search"  name="q" id="search">
                               <i class="search icon" ></i>
                            </div>
                            <div class="results"></div>
                        </div>

                    </form>


                </div>
            </div>
        </div>

    </div>


</div>

</div>

