$(".card").on("click",function (e) {
    e.preventDefault();
    $id=$(this).attr('id');

    $url="louanges_pdf";

    $var ={
        id:$id

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

        $(data.pdf).each(function (index, value) {


        });

$("#louanges").html($html);



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