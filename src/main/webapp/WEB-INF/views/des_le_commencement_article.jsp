<%@include file="head.jsp"%>

  <div class="contener_global_article">

      <div class="contener_bouton_lire">
          <div id="playerCover">
              <div id="player">
                  <div id="playPause"><i class="fa fa-play" aria-hidden="true"></i></div>
                  <div id="sArea">
                      <div id="insTime">00:00</div>
                      <div id="sHover"></div>
                      <div id="seekBar">
                          <div id="seName"><c:out value="${unEnseignement.titre}"/></div>
                      </div>
                      <div id="trackName"><c:out value="${unEnseignement.titre}"/></div>
                      <p id="idlienaudio" style="display: none"><c:out value="${unEnseignement.lienaudio}"/></p>
                  </div>

                  <div id="aTime">
                      <div id="aTm">
                          <div id="aPlayed">00:00</div>
                          <div id="aTotal">00:00</div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="contener_bloc_global_titre">
          <h2 id="titre">
              <b><c:out value="${unEnseignement.titre}"/></b>
          </h2>
          <sec:authorize access="isAuthenticated()">
              <a href="/modifier/<c:out value="${unEnseignement.id}"/>" class="button">Modifer</a>

          </sec:authorize>

      </div>

      <div class="contener_bloc_global_logo">
          <div class="bloc_logo">
              <img class="bloc_logo_img" src="${pageContext.request.contextPath}/resources/image/G&F.png" >

          </div>

          <div class="bloc_section">
              D&egrave;s le Commencement
          </div>
      </div>

      <div class="contener_bloc_global_resume_et_image">

          <div class="contener_bloc_global_resume_et_image_image">
              <img style="width: inherit;height: auto" src="${pageContext.request.contextPath}/resources/image/des_le_commencement/<c:out value="${unEnseignement.nomphoto}"/>">
          </div>

          <div style="" class="contener_bloc_global_resume_et_image_resume">
              <c:out value="${unEnseignement.resume}"/>
          </div>

      </div>

      <div class="contener_bloc_global_text">
          ${fn:replace(fn:replace(unEnseignement.contenu, '&lt;','<'), '&gt;','>')}

      </div>
  </div>

<script src="${pageContext.request.contextPath}/resources/js/dropdown.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pagination_ajax.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/speedvault.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/speecher.js"></script>
<script>
    $("html").css("height",$(".contener_global_article").height()+300)



    $(function()
    {
        var audio, playPause = $('#playPause'), sArea = $('#sArea'), seekBar = $('#seekBar'), tProgress = $('#aPlayed'), tTime = $('#aTotal'), sHover = $('#sHover'), seekT, seekLoc, insTime = $('#insTime');

        // 1. Function to handle play and pause actions
        function play_pause()
        {
            if(audio.paused)
            {
                audio.play();
                $('#playPause i').attr('class','fa fa-pause');
            }
            else
            {
                audio.pause();
                $('#playPause i').attr('class','fa fa-play');
            }
        }

        // 2. Function to show hover layer ( Hover layer shows play time at the place of hover )
        function showHover(event)
        {
            var seekBarPos = seekBar.offset();
            seekT = event.clientX - seekBarPos.left;
            seekLoc = audio.duration * (seekT / sArea.outerWidth());

            sHover.width(seekT);

            var cM = seekLoc / 60;

            var ctMinutes = Math.floor(cM);
            var ctSeconds = Math.floor(seekLoc - ctMinutes * 60);

            if( (ctMinutes < 0) || (ctSeconds < 0) )
                return;

            if(ctMinutes < 10)
                ctMinutes = '0'+ctMinutes;

            if(ctSeconds < 10)
                ctSeconds = '0'+ctSeconds;

            insTime.text(ctMinutes+':'+ctSeconds).css({'left':seekT,'margin-left':'-25px'}).fadeIn(0);
        }

        // 3. Function to hide hover layer
        function hideHover()
        {
            sHover.width(0);
            insTime.text('00:00').css({'left':'0px','margin-left':'0px'}).fadeOut(0);
        }

        // Add eventListener for playing audio from a particular time interval when there is click on div#sArea element ( Area between play/pause button and timer )

        sArea.on('click',function()
        {
            audio.currentTime = seekLoc;
            seekBar.width(seekT);
            hideHover();
        })

        // 4. Function to update the time upto which audio has been played currently
        function updateCurrTime()
        {
            var curMinutes = Math.floor(audio.currentTime / 60);
            var curSeconds = Math.floor(audio.currentTime - curMinutes * 60);

            var durMinutes = Math.floor(audio.duration / 60);
            var durSeconds = Math.floor(audio.duration - durMinutes * 60);

            var playProgress = (audio.currentTime / audio.duration) * 100;

            if(curMinutes < 10)
                curMinutes = '0'+curMinutes;

            if(curSeconds < 10)
                curSeconds = '0'+curSeconds;

            if(durMinutes < 10)
                durMinutes = '0'+durMinutes;

            if(durSeconds < 10)
                durSeconds = '0'+durSeconds;

            // Show the play progress in the player ui
            tProgress.text(curMinutes+':'+curSeconds);

            // Update the total time duration of audio file in the player ui
            tTime.text(durMinutes+':'+durSeconds);

            // Set the seekbar width
            seekBar.width(playProgress+'%');

            // If audio has been played to its full length, then
            // 1. Show the play icon
            // 2. Set the seekbar width to 0
            // 3. Update the play progress to 00:00
            if( playProgress == 100 )
            {
                $('#playPause i').attr('class','fa fa-play');
                seekBar.width(0);
                tProgress.text('00:00');
            }
        }

        // 5. Main function for making the audio player functional
        function initPlayer()
        {
            // Create an audio object
            audio = new Audio();


            // Add the URL of audio source file to be played
            audio.src = 'https://docs.google.com/uc?export=open&id='+$("#idlienaudio").text();

            // Set looping to false to avoid audio from playing again
            audio.loop = false;

            // Play or pause the audio when there is click on div#playPause element ( play/pause button )
            playPause.on('click',play_pause);

            // When there is hover on div#sArea element, then show the hover layer.
            // div#sArea element => Area between play/pause button and player timer
            sArea.mousemove(function(event){ showHover(event); });

            // When mouse is removed from div#sArea element hide the hover layer
            sArea.mouseout(hideHover);

            // When current played time is updated ( it is updated when audio is playing ), then update the current time text in player UI
            $(audio).on('timeupdate',updateCurrTime);
        }

        // Make the audio player functional
        initPlayer();

    })
</script>
<%@include file="footer.jsp"%>



