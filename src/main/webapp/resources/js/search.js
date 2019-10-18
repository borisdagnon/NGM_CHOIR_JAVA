$(document).ready(function () {

    var elements=[];
    $url="ajax";

    $("#search").on("keyup",function () {


      $Achercher=$(this).val();

var filterDataRequest = $.ajax({

    type:"POST",
    url:$url,
    dataType:"json",
    encode:true,
    data:$Achercher
});


//Si l'envoie a bien été effectué, on a une réponse -data-
filterDataRequest.done(function (data) {
    elements=[];
var tmp=null;


    $(data.listeRechercheVideo).each(function (index, value) {

       tmp=check(value['table']);
        elements.push(
            {
                category: tmp,
                title:value['titre']
            })


    });

    $(data.listeRechercheAudio).each(function (index, value) {

        tmp=check(value['table']);
        elements.push(
            {
                category: tmp,
                title:value['nom']
            })


    });

    $(data.listeRechercheLouange).each(function (index, value) {

        tmp=check(value['table']);
        elements.push(
            {
                category: tmp,
                title:value['nom']
            })


    });


    $('.ui.search')
        .search({

            type:'category',
            source:elements,
            minCharacters : 2
        });



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

})

    });


function check($table){
    var tmp=null;
    if($table===1){
        tmp='Témoignages'
    }else {
        if($table===2){
            tmp='Louanges'
        }else {
            tmp='Vidéos'
        }
    }

    return tmp;
    }


});