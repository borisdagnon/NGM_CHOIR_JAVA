var header='';
var token='';

$("i").click(function () {
     header = $("meta[name='_csrf_header']").attr("content");
     token = $("meta[name='_csrf']").attr("content");


    $var="";
    $url="";
    $id="";
    $affiche="";
    $media=$(this).attr("class");
    $id=$(this).attr("id");


if($media==="fas fa-film"){
    $url="callVideo";
    if($id!=="" && $id!==undefined){
        callVideo($id,$url);
    }


}else {
    if($media==="fas fa-volume-up"){
        $url="callAudio";

        if($id!=="" && $id!==undefined){
            callAudio($id,$url);
        }

    }
}

});

function callVideo($var,$url){
    $("#contener_video_youtube").css("display","block");
    $("#contener_audio_soundcloud").empty();
    $("#contener_audio_soundcloud").css("display","none");

    $var ={
       identifiant: $var
    };
    var filterDataRequest = $.ajax({

        type:"POST",
        url:$url,
        dataType:"json",
        encode:true,
        data:$var,
        beforeSend: function(xhr){
            xhr.setRequestHeader(header, token);
        }
    });



    filterDataRequest.done(function (data) {
        var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };

        var today  = data.uneVideo.formatdate;
        $jour=today.split("-")[0];
        $mois=today.split("-")[1];
        $annee=today.split("-")[2];

        today=new Date($annee+"-"+$mois+"-"+$jour);
        today=today.toLocaleDateString("fr-FR", options);

        $jourLettre=capitalize(today.split(" ")[0]);
        $jourNumero=capitalize(today.split(" ")[1]);
        $mois=capitalize(today.split(" ")[2]);
        $annee=capitalize(today.split(" ")[3]);


        $("iframe").attr("src","https://www.youtube.com/embed/"+data.uneVideo.lien);
        $("#ajax_titre_video_put").html(data.uneVideo.titre);
        $("#ajax_titre_orateur_put").html(data.uneVideo.orateur.appele+" "+data.uneVideo.orateur.aka);
        $("#ajax_titre_date_put").html($jourLettre+" "+$jourNumero+" "+$mois+" "+$annee);
        $affiche+='<script src="/resources/js/speedvault.js"></script>';
        $("#lesEnseignements").html($affiche);
        $("#lavideo").html($affiche);

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
}


function callAudio($var,$url){

    $("#contener_video_youtube").css("display","none");

    $("#contener_audio_soundcloud").css("display","block");

    $var ={
        identifiant: $var
    };
    var filterDataRequest = $.ajax({

        type:"POST",
        url:$url,
        dataType:"json",
        encode:true,
        data:$var,
        beforeSend: function(xhr){
            xhr.setRequestHeader(header, token);
        }
    });

    filterDataRequest.done(function (data) {

$afficheAudio="";
        if($.isEmptyObject(data)){
            $afficheAudio="non";
           // alert("Is empty object")
        }else {
            $afficheAudio="oui";
           // alert("Is not empty object")
        }



        try {
            var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
            var today  = data.unAudio.annee;

            $jour=today.split("-")[2];
            $mois=today.split("-")[1];
            $annee=today.split("-")[0];

            today=new Date($annee+"-"+$mois+"-"+$jour);
            today=today.toLocaleDateString("fr-FR", options);

            $jourLettre=capitalize(today.split(" ")[0]);
            $jourNumero=capitalize(today.split(" ")[1]);
            $mois=capitalize(today.split(" ")[2]);
            $annee=capitalize(today.split(" ")[3]);
        }
        catch(error) {
            console.error(error);
            // expected output: ReferenceError: nonExistentFunction is not defined
            // Note - error messages will vary depending on browser
        }




        if($afficheAudio==="oui"){


            $("#contener_audio_soundcloud").css("display","flex");
            $("#contener_audio_soundcloud").css("align-items","flex");
            $(".contener_media_video_audio_titre").css("margin-top","-120px");


                if($(window).width()<=500){
                    $("#contener_audio_soundcloud").html(' <div style="width: 200px; height: 300px" class="mhn-player">\n' +
                        '                <div style="width: 200px; height: 150px;" class="album-art"></div>\n' +
                        '                <div class="play-list" style="display: block; height: 90px">\n' +
                        '                    <a href="#" class="play"\n' +
                        '                       data-id="1"\n' +
                        '                       data-album="Centre Grâce & Foi"\n' +
                        '                       data-artist="Pasteur ELOM"\n' +
                        '                       data-title="'+data.unAudio.titre+'"\n' +
                        '                       data-albumart="/resources/image/nouveau_logo.jpg"\n' +
                        '                       data-url="https://docs.google.com/uc?export=open&id='+data.unAudio.lien+'"></a>\n' +
                        '\n' +
                        '\n' +
                        '                </div>\n' +
                        '                <div class="audio"></div>\n' +
                        '                <div class="current-info">\n' +
                        '                    <div class="song-artist"></div>\n' +
                        '                    <div class="song-album"></div>\n' +
                        '                    <div class="song-title"></div>\n' +
                        '                </div>\n' +
                        '                <div style="margin-top: -5px" class="controls">\n' +
                        '                    <a href="#" class="toggle-play-list"><i class="fa fa-list-ul"></i></a>\n' +
                        '                    <div class="duration clearfix">\n' +
                        '                        <span class="pull-left play-position"></span>\n' +
                        '                        <span class="pull-right"><span class="play-current-time">00:00</span> / <span class="play-total-time">00:00</span></span>\n' +
                        '                    </div>\n' +
                        '                    <div class="progress"><div class="bar"></div></div>\n' +
                        '                    <div class="action-button">\n' +
                        '                        <a href="#" class="prev"><i class="fa fa-step-backward"></i></a>\n' +
                        '                        <a href="#" class="play-pause"><i class="fa fa-pp"></i></a>\n' +
                        '                        <a href="#" class="stop"><i class="fa fa-stop"></i></a>\n' +
                        '                        <a href="#" class="next"><i class="fa fa-step-forward"></i></a>\n' +
                        '                        <input type="range" class="volume" min="0" max="1" step="0.1" value="0.5" data-css="0.5">\n' +
                        '                    </div>\n' +
                        '\n' +
                        '                </div>\n' +
                        '            </div>' +
                        '<script src="/resources/js/mobile_player.js"></script>\n');

                }else {
                    $("#contener_audio_soundcloud").html(' <div class="mhn-player">\n' +
                        '                <div class="album-art"></div>\n' +
                        '                <div class="play-list" style="display: block">\n' +
                        '                    <a href="#" class="play"\n' +
                        '                       data-id="1"\n' +
                        '                       data-album="Centre Grâce & Foi"\n' +
                        '                       data-artist="Pasteur ELOM"\n' +
                        '                       data-title="'+data.unAudio.titre+'"\n' +
                        '                       data-albumart="/resources/image/nouveau_logo.jpg"\n' +
                        '                       data-url="https://docs.google.com/uc?export=open&id='+data.unAudio.lien+'"></a>\n' +
                        '\n' +
                        '\n' +
                        '                </div>\n' +
                        '                <div class="audio"></div>\n' +
                        '                <div class="current-info">\n' +
                        '                    <div class="song-artist"></div>\n' +
                        '                    <div class="song-album"></div>\n' +
                        '                    <div class="song-title"></div>\n' +
                        '                </div>\n' +
                        '                <div class="controls">\n' +
                        '                    <a href="#" class="toggle-play-list"><i class="fa fa-list-ul"></i></a>\n' +
                        '                    <div class="duration clearfix">\n' +
                        '                        <span class="pull-left play-position"></span>\n' +
                        '                        <span class="pull-right"><span class="play-current-time">00:00</span> / <span class="play-total-time">00:00</span></span>\n' +
                        '                    </div>\n' +
                        '                    <div class="progress"><div class="bar"></div></div>\n' +
                        '                    <div class="action-button">\n' +
                        '                        <a href="#" class="prev"><i class="fa fa-step-backward"></i></a>\n' +
                        '                        <a href="#" class="play-pause"><i class="fa fa-pp"></i></a>\n' +
                        '                        <a href="#" class="stop"><i class="fa fa-stop"></i></a>\n' +
                        '                        <a href="#" class="next"><i class="fa fa-step-forward"></i></a>\n' +
                        '                        <input type="range" class="volume" min="0" max="1" step="0.1" value="0.5" data-css="0.5">\n' +
                        '                    </div>\n' +
                        '\n' +
                        '                </div>\n' +
                        '            </div>' +
                        '<script src="/resources/js/mobile_player.js"></script>\n');

                }





            $("#ajax_titre_video_put").html(data.unAudio.titre);
            $("#ajax_titre_orateur_put").html("Pasteur ELOM");
            $("#ajax_titre_date_put").html($jourLettre+" "+$jourNumero+" "+$mois+" "+$annee);

        }else {
            $("#contener_audio_soundcloud").html("<img style='width: inherit;height: inherit' src=\"resources/image/Pas d'audio.png\" >")
            $("#ajax_titre_video_put").html("");
            $("#ajax_titre_orateur_put").html("");
            $("#ajax_titre_date_put").html("");

              }


        /* $affiche+='<script src="/resources/js/speedvault.js"></script>';
        *$("#lesEnseignements").html($affiche);
         $("#lavideo").html($affiche);*/

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
}

const capitalize = (s) => {
    if (typeof s !== 'string') { // noinspection JSAnnotator
        return ''
    }
    // noinspection JSAnnotator
    return s.charAt(0).toUpperCase() + s.slice(1)
};


