<%--
  Created by IntelliJ IDEA.
  User: feros
  Date: 09/02/2019
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>


<div class="contener_global_textEditor">


    <form class="" style="margin-left: 15px" id="upload-file-form">
            <div class="grid-container">
                <div class="grid-x grid-padding-x">

                    <div style="margin: auto; width: 547px;height: 103px" class="">
                        <label><h2>Titre de l'article</h2>
                            <input type="text" id="titre_article" placeholder="...">
                        </label>
                    </div>
                    <div style="margin: auto; width: 547px;height: 103px" class="">
                        <label><h2>Image de l'article</h2>

                            <input id="upload-file-input" type="file" name="uploadfile" accept="*" />
                        </label>
                    </div>
                    <div style="margin: auto; width: 547px;height: 103px" class="">
                        <label><h2>Resum&eacute; de l'article</h2>

                            <textarea rows="3" id="resume"></textarea>
                        </label>
                    </div>
                </div>
            </div>
        </form>

    <div class="" style="margin-top: 150px">
        <h2>Contenu de l'article</h2>
        <div id="standalone-container">
            <div id="toolbar-container">
    <span class="ql-formats">
      <select class="ql-font"></select>
      <select class="ql-size"></select>
    </span>
                <span class="ql-formats">
      <button class="ql-bold"></button>
      <button class="ql-italic"></button>
      <button class="ql-underline"></button>
      <button class="ql-strike"></button>
    </span>
                <span class="ql-formats">
      <select class="ql-color"></select>
      <select class="ql-background"></select>
    </span>
                <span class="ql-formats">
      <button class="ql-script" value="sub"></button>
      <button class="ql-script" value="super"></button>
    </span>
                <span class="ql-formats">
      <button class="ql-header" value="1"></button>
      <button class="ql-header" value="2"></button>
      <button class="ql-blockquote"></button>
      <button class="ql-code-block"></button>
    </span>
                <span class="ql-formats">
      <button class="ql-list" value="ordered"></button>
      <button class="ql-list" value="bullet"></button>
      <button class="ql-indent" value="-1"></button>
      <button class="ql-indent" value="+1"></button>
    </span>
                <span class="ql-formats">
      <button class="ql-direction" value="rtl"></button>
      <select class="ql-align"></select>
    </span>
                <span class="ql-formats">
      <button class="ql-link"></button>
      <button class="ql-image"></button>
      <button class="ql-video"></button>
      <button class="ql-formula"></button>
    </span>
                <span class="ql-formats">
      <button class="ql-clean"></button>
    </span>
            </div>
            <div id="editor-container">


            </div>
        </div>
    </div>




</div>
<div class="contener_global_buttons">
    <!-- Buttons (actions) -->
    <button type="button" class="success button" id="enregistrer">Enregistrer</button>
    <button type="button" class="alert button" id="annuler">Annuler</button>
</div>

<script src="//cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
<script src="//cdn.quilljs.com/1.3.6/quill.min.js"></script>
<script>
    var quill = new Quill('#editor-container', {
        modules: {
            syntax: true,
            toolbar: '#toolbar-container'
        },
        placeholder: 'Compose an epic...',
        theme: 'snow'
    });


</script>

<script src="${pageContext.request.contextPath}/resources/js/redacteur.js"></script>
<%@include file="footer.jsp"%>