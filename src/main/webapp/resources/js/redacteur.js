$("#enregistrer").on("click",function (e) {
    e.preventDefault();

if(!$("#titre_article").val()){

    $("#titre_article").css("border","3px solid red");
}else {
    $("#titre_article").css("border","1px solid");
    if($("#resume").val()===""){

        $("#resume").css("border","3px solid red");
    }else {

        $("#resume").css("border","1px solid");
if(quill.container.firstChild.innerHTML.length<30){
$("#editor-container").css("border","3px solid red")
}else {

    valider();
    uploadFile();
}
    }
}

});

function valider(){
    $url="enregistrer_article";
    $var ={
        action:"insert",
        titre_article: $("#titre_article").val(),
        resume: $("#resume").val(),
        contenu: quill.container.firstChild.innerHTML,
        nomphoto:  $("input[name='uploadfile']").val().split("\\")[$("input[name='uploadfile']").val().split("\\").length-1]
    };


     var filterDataRequest = $.ajax({

         type:"POST",
         url:$url,
         dataType:"json",
         encode:true,
         data:$var
     });

     filterDataRequest.done(function (data) {


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

function uploadFile() {
    $.ajax({
        url: "/uploadFileAjax",
        type: "POST",
        data: new FormData($("#upload-file-form")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            // Handle upload success
            // ...
        },
        error: function () {
            // Handle upload error
            // ...
        }
    })};

