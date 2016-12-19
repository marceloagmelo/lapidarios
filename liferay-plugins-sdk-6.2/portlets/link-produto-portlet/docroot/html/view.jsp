<%@ include file="init.jsp"%>
<script>
	function funGerarLink() {

		var textId = document.getElementById("textIdLoja");
		var textLinkProduto = document.getElementById("textLinkProduto");
		var textLinkFinal = document.getElementById("textLinkProdutoFinal");
		var divLinkFinal = document.getElementById("divLinkFinal");
		var divMensagem = document.getElementById("divMensagem");
		var divSucesso = document.getElementById("divSucesso");
		var divErro = document.getElementById("divErro");
		var spanMensagemErro = document.getElementById("spanMensagemErro");
		var msgErro = "";
		var ok = true;

		//Sempre oculta todas as divs de mensagens e link
		divLinkFinal.style.display = "none";
		divMensagem.style.display = "none";
		divSucesso.style.display = "none";
		divErro.style.display = "none";

		//Seta os backgrounds sempre branco
		textId.style.backgroundColor = "#fff";
		textLinkProduto.style.backgroundColor = "#fff";

		if (textId.value == "") {
			ok = false;
			msgErro = "Informe o ID da sua Polishop (www.polishp.com.vc/<i>idsualoja</i>)"
			textId.style.backgroundColor = "#f2dede";
			textId.focus();
		} //if

		if (ok) {
			if (textLinkProduto.value == "") {
				ok = false;
				msgErro = "Informe o link do produto. Copie a URL e cole no campo correspondente.";
				textLinkProduto.style.backgroundColor = "#f2dede";
				textLinkProduto.focus();
			} else {
				if (textLinkProduto.value.indexOf("http://www.polishop.vc") < 0) {
					ok = false;
					msgErro = "Linkd de produto inválido. Dever ser algo como: <i>http://www.polishop.vc/nome-do-produto</i>";
					textLinkProduto.style.backgroundColor = "#f2dede";
					textLinkProduto.focus();
				}//if
			}//if
		} //if

		if (ok) {
			textLinkFinal.value = textLinkProduto.value
					+ "?utm_source=PolishopComVC&utm_medium=" + textId.value;
			divSucesso.style.display = "block";
			divLinkFinal.style.display = "block";

			//Grava o cookie
			funGravarCookie(textId.value);

		} else {
			textLinkFinal.value = "";
			spanMensagemErro.innerHTML = msgErro;
			divErro.style.display = "block";
		} //if

		divMensagem.style.display = "block";

	} //function

	function copySelectionText() {
		var copysuccess // var to check whether execCommand successfully executed
		try {
			copysuccess = document.execCommand("copy") // run command to copy selected text to clipboard
		} catch (e) {
			copysuccess = false
		}
		return copysuccess
	}//function

	function funCopiarLink(e, id) {
		var field = document.getElementById(id)
		field.focus()
		field.setSelectionRange(0, field.value.length)
		var copysuccess = copySelectionText()
		if (copysuccess) {
			showtooltip(e)
		}
	}//function

	function funGravarCookie(valor) {
		var expires;
		var date;
		var name = "cookieIdPolishop";
		var exdays = 90; //90 dias

		date = new Date(); //  criando o COOKIE com a data atual
		date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
		expires = date.toUTCString();
		value = "TESTE123";

		document.cookie = name + "=" + valor + "; expires=" + expires
				+ "; path=/";
	}//function
</script>

<%
String labelTitulo = LanguageUtil.get(locale, "label.titulo");
%>
<portlet:actionURL var="gerarURL"/>

<div class="content-section-a">
	<div class="container">
		<div class="row">
	       <div class="col-sm-12">
	           
	           <h2 class="section-heading">Gerador de link de produtos da Polishop</h2>
	           <p class="lead">
	           Gere links dos produtos da <strong>sua loja Polishop</strong> para enviar para seus amigos.
	           </p>
	       </div>
	       <div class="col-sm-4">
	           <label>Informe o ID da sua loja Polishop:</label>
	           <input name="textIdLoja" type="text" id="textIdLoja" class="form-control" />
	       </div>
	       <div class="col-sm-12" style="margin-top:20px;">
	           <div class="xxinput-group">
	               <label>Cole abaixo o link (URL) do produto:</label>
	               <input name="textLinkProduto" type="text" id="textLinkProduto" class="form-control" />
	           </div>
	       </div>
	       <div class="col-sm-12" style="margin-top:20px;">
	           <p><a class="btn btn-primary btn-lg" href="javascript:funGerarLink();" role="button">Gerar Link</a></p>
	       </div>
	       <div id="divMensagem" style="display:none;" class="col-sm-12" style="margin-top:20px;">
	           <div id="divSucesso" class="alert alert-success" role="alert">Link gerado com sucesso. Clique em "<strong>Copiar Link</strong>" abaixo para copiar o link.</div>
	           <div id="divErro" class="alert alert-danger" role="alert"><span id="spanMensagemErro">...</span></div>
	       </div>
	       <div id="divLinkFinal" style="display:none;" class="col-sm-12" style="margin-top:20px;">
	           <div class="input-group">
	             <input type="text" class="form-control" id="textLinkProdutoFinal" placeholder="Aqui aparecerá o link do produto na sua loja...">
	             <span class="input-group-btn">
	               <button class="btn btn-default" type="button" onclick="funCopiarLink(event, 'textLinkProdutoFinal');return false">Copiar Link</button>
	             </span>
	           </div><!-- /input-group -->
	       </div>

		</div>
	</div>
</div>