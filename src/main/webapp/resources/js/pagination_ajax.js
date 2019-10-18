
$('.ui.inverted.blue').on('click',function (e) {
    e.preventDefault();
    $page=$(this).text();
    $combo="";
    $anneeSelect=$("#dropDwn_Annee").dropdown('get value');
    $themeSelect=$("#dropDwn_Theme").dropdown("get value");


    if($anneeSelect==="" && $themeSelect!==""){
        //alert("Pas d'année, mais theme oui");
        $combo="anneeNonThemeOui"
    }else {
        if($anneeSelect!=="" && $themeSelect===""){
            // alert("Pas de theme, mais année oui");
            $combo="anneeOuiThemeNon"
        }else {

            if($anneeSelect!=="" && $themeSelect!==""){
                //  alert("année et theme oui");
                $combo="anneeOuiThemeOui"
            }else {
                if($anneeSelect==="" && $themeSelect===""){
                    //  alert("année et theme oui");
                    $combo="anneeNonThemeNon"
                }
            }

        }
    }

    $url="pagination_ajax";

    $var ={
        combo:$combo,
        page:$page,
        annee:$anneeSelect,
        theme: $themeSelect

    };
    var filterDataRequest = $.ajax({

        type:"POST",
        url:$url,
        dataType:"json",
        encode:true,
        data:$var
    });

    filterDataRequest.done(function (data) {

        $html="";
        $affiche="";

        $affiche+='<div class="row">';
        $(data.listeVideos).each(function (index,value) {
            $affiche+='<div class="col-md-4">';
            $affiche+='<div class="card mb-4 box-shadow">';
            $affiche+='<div class="youtube" data-embed="'+value.lien+'">';
            $affiche+='<!-- (2) the "play" button -->';
            $affiche+='<div class="play-button"></div>';
            $affiche+='</div>';
            $affiche+='<div class="card-body">';
            $affiche+='<h3 style="font-family: Magneto" class="card-text">'+value.titre+'</h3>';
            $affiche+='<div class="d-flex justify-content-between align-items-center">';

            $affiche+='<h4 class="text-muted">'+value.formatdate+'</h4>';
            $affiche+='</div>';
            $affiche+='</div>';
            $affiche+='</div>';
            $affiche+='</div>';

        });

        $(data.listeEnseignements).each(function (index,value) {
            $affiche+='<div class="col-md-4">';
            $affiche+='<div class="card mb-4 box-shadow">';
            $affiche+='<a href="?read='+value.id+'"><img class="img-fluid d-block w-100" style="width: 640px;height: 480px" src="./resources/image/photo_enseignement/'+value.nomphoto+'"></a>';
            $affiche+='<div class="card-body">';
            $affiche+='<h3 style="font-family: Magneto" class="card-text">'+value.titre+'</h3>';
            $affiche+='<div class="d-flex justify-content-between align-items-center">';
            $affiche+='<h4 class="text-muted">'+value.resume+'</h4>';
            $affiche+='</div>';
            $affiche+='</div>';
            $affiche+='</div>';
            $affiche+='</div>';

        });

        $affiche+='</div>';
        $affiche+='</ul><script src="/resources/js/speedvault.js"></script>';
        $("#lesEnseignements").html($affiche);


    });

    //Si il y a un problème on gère les erreurs
    filterDataRequest.fail(function (jqXHR,textStatus) {

        if (jqXHR.status === 0){alert("Not connect.n Verify Network.");}
        else if (jqXHR.status === 404){alert("Requested page not found. [404]");}
        else if (jqXHR.status === 500){alert("Internal Server Error [500].");}
        else if (textStatus === "parsererror"){alert("Requested JSON parse failed.");}
        else if (textStatus === "timeout"){alert("Time out error.");}
        else if (textStatus === "abort"){alert("Ajax request aborted.");}
        else{alert("Uncaught Error.n" + jqXHR.responseText);}

    });



});