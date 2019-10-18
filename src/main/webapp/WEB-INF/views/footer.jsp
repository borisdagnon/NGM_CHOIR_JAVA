
<div class="container">
    <div class="global_footer" style=" ">


        <p style="color: #6a0300">Centre Gr&acirc;ce &amp; Foi, est une &eacute;glise et assembl&eacute;e, situ&eacute;e &agrave; angers, dans le Maine-Et-Loire, pour annoncer l'evangile</p>
    </div>
</div>




<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/slick-1.8.1/slick/slick.min.js"></script>
<script>
    $('.carousel').slick({
        dots:false,
        arrows:false,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay:true,
        autoplaySpeed: 5000,

    });

    $(document).ready(function() {
        $("#content").find("[id^='tab']").hide(); // Hide all content
        $("#tabs li:first").attr("id","current"); // Activate the first tab
        $("#content #tab1").fadeIn(); // Show first tab's content

        $('#tabs a').click(function(e) {
            e.preventDefault();
            if ($(this).closest("li").attr("id") == "current"){ //detection for current tab
                return;
            }
            else{
                $("#content").find("[id^='tab']").hide(); // Hide all content
                $("#tabs li").attr("id",""); //Reset id's
                $(this).parent().attr("id","current"); // Activate this
                $('#' + $(this).attr('name')).fadeIn(); // Show content for the current tab
            }
        });




    });


    $('.tabgroup > div').hide();
    $('.tabgroup > div:first-of-type').show();
    $('.tabs a').click(function(e){
        e.preventDefault();
        var $this = $(this),
            tabgroup = '#'+$this.parents('.tabs').data('tabgroup'),
            others = $this.closest('li').siblings().children('a'),
            target = $this.attr('href');
        others.removeClass('active');
        $this.addClass('active');
        $(tabgroup).children('div').hide();
        $(target).show();

    });

    $("#tabone").on("click",function () {
        $(".tab").css("background-color","");
        $(".tab").css("background-color","background-image: linear-gradient(to right top, #c41b00, #ca3000, #cf3f00, #d44d00, #d95a00, #df6700, #e47300, #e97f00, #ef8f00, #f59f00, #f9af00, #fdbf00)")
    });

    $("#tabtwo").on("click",function () {
        $(".tab").css("background-color","#c34a36")
    });

    $("#tabthree").on("click",function () {
        $(".tab").css("background-color","");
        $(".tab").css("background-color","background-image: linear-gradient(to right top, #8a2243, #a02348, #b7234d, #cd2350, #e42452);")
    })



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



</body>
</html>
