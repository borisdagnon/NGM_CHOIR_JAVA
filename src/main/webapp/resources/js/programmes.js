 number=0;

$("button[name=myBtn]").on("click",function (e) {
    e.preventDefault();
    number=$(this).attr("id").split("_")[1];
    // Get the modal
     modal = "#myModal_"+$(this).attr("id").split("_")[1]//document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = $(this).attr("id")//document.getElementById("myBtn");

// Get the <span> element that closes the modal
    span = "#span_"+$(this).attr("id").split("_")[1]//document.getElementsByClassName("close")[0];


    // When the user clicks the button, open the modal
        $(modal).css("display","block");



    $("#span_"+number).on("click",function () {
        // When the user clicks on <span> (x), close the modal

        $(modal).css("display","none");
    });


    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {

        if ($(event.target).is("div")) {
            $(modal).css("display","none");
        }
    }
});













