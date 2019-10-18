$("#lire").on("click",function (e) {
    e.preventDefault();
    speekNow($("#titre").text());
    speekNow($(".contener_bloc_global_resume_et_image_resume").text());
speekNow($(".contener_bloc_global_text").text());
});

function speekNow($text) {

    var speech = new SpeechSynthesisUtterance();
    speech.lang="fr-FR";
speech.rate=.9;
    speech.pitch=1.5;
    speech.volume=2;
    speech.voice=speechSynthesis.getVoices()[0];

    //On lit d'abbord le titre
    speech.text=$text;
    speechSynthesis.speak(speech);



    console.log(`Voices #: ${speechSynthesis.getVoices().length}`)

    speechSynthesis.getVoices().forEach(voice => {
        console.log(voice.name, voice.lang)
    })
}

