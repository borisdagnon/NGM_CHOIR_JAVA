$('.ui.dropdown')
    .dropdown()
;

$('.item.something').on('click',function () {
    $anneeSelect=$(this).attr('data-value');

    if($anneeSelect==="Toutes"){

        $("[id^=videos_]").each(function () {
            $id=$(this).attr('id');

            $("#"+$id)
                .show(1000)
            ;
        })

    }else{

        $("[id^=videos_]").each(function () {
            $id=$(this).attr('id');

            $anneeCompare=$(this).attr('name');

            if($anneeCompare===$anneeSelect){
                $("#"+$id)
                    .show(1000)
                ;
            }else{
                $("#"+$id)
                    .hide(1000)
                ;
            }


        })
    }


});