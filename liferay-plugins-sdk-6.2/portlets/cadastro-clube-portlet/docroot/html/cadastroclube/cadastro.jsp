<%@ include file="init.jsp"%>

<%@ include file="mensagens.jspf"%>

<%
String reqLojaId = (String)request.getAttribute(CadastroClubeConstants.LOJA_INDICADA_ID);
if (Validator.isNull(reqLojaId)) {
	reqLojaId = lojaId;
}
%>
	
<div id="sb-site">

<header id="top-internas">
	<div class="container">
		<div class="center-form">
			<h1 class="title-header">Cadastre-se na plataforma LAPIDÁRIOS</h1>
		</div>
	</div>
</header>

<div id="content">
	<div class="container">
		<div class="center-form">
			<div class="model-form">
				
<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=CadastroClubeConstants.PORTLET_ACTION %>" value="<%=CadastroClubeConstants.SALVAR %>" />
</portlet:actionURL>

			<aui:form action="<%= salvarURL %>" method="post" name="fm">

				<fieldset class="fieldset ">

					<h2 class="subtitulo-form">1 - Dados</h2>

					<div class="row-fluid">

						<div class="span6">

							<div class="control-group input-String-wrapper">
								<label class="control-label" for="_58_firstName">Nome</label>
								<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Seu nome cadastrado na plataforma LAPIDÁRIOS.">
									<i class="icon icon-question-form"></i>
								</a>
								<input class="field lfr-input-text" id="_58_firstName" name="_58_firstName" type="text" maxlength="75" value="<%=user.getFullName() %>" disabled>
							</div>

						</div>

						<div class="clearfix row-fluid">
							<div class="span6">
								<div class="control-group input-String-wrapper">
								<label class="control-label" for="_58_middleName"> ID da Polishop <span class="label-required">*</span></label>
								<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content='Informe qual foi o "nome" que você deu a sua loja no ato de seu cadastro.'>
										<i class="icon icon-question-form"></i>
									</a>
								<aui:input name="<%=CadastroClubeConstants.CAMPO_ID_POLISHOP %>" label="label.idPolishop">
									<aui:validator name="required" />
								</aui:input>
									
								</div>
							</div>
						</div>
						


				<h2 class="subtitulo-form">2 - Identificando seu patrocinador</h2>

				<div class="row-fluid">
					<div class="span6">
						<div class="patrocinador">SEU PATROCINADOR É: <strong><%=lojaId %></strong></div>
						
						<div class="outro-id">
							<label class="checkbox">
		        				<input type="checkbox" class="inputOutroID"> Meu patrocinador na POLISHOP.VC não é este.
		      				</label>
		      				<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Este campo deve estar previamente preenchido com o ID do seu patrocinador POLISHOP.VC. Caso o seu patrocinador na POLISHOP.VC não seja este ou, se o campo estiver em Branco, marque o combo abaixo e informe o ID de seu Patrocinador.">
								<i class="icon icon-question-form"></i>
							</a>
	      				</div>

	      				<div id="controle-form" class="campo-oculto">
							<div class="control-group input-String-wrapper">
								<label class="control-label" for="_58_middleName"> ID cadastrado na polishop <span class="label-required">*</span></label>
								<!-- <a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
									<i class="icon icon-question-form"></i>
								</a> -->
								<aui:input name="<%=CadastroClubeConstants.CAMPO_ID_PATROCINADOR %>" label="label.idPatrocionador" value="<%=lojaId %>"/>
							</div>
						</div>
					</div>
					
				</div>

				</fieldset>

				<div class="button-holder">
					<button class="btn btn-danger btn-lg" type="submit"> Cadastrar </button>
				</div>
			</aui:form>

			<div class="obrigatorios">Todos os dados com (*) são obrigatórios</div>

			
		</div>
		</div>
	</div>		
</div>

</div> <!-- .fim div sb-site -->