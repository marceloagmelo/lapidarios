<%@ include file="init.jsp" %>

<div id="sb-site">

<header id="top-internas">
	<div class="container">
		<div class="center-form">
			<h1 class="title-header">Quero que entrem em contato comigo</h1>
		</div>
	</div>
</header>

<portlet:actionURL var="enviarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.ENVIAR %>" />
</portlet:actionURL>


<div id="content">
	<div class="container">
		<div class="center-form">

			<div class="model-form">
			
			<h2 class="subtitulo-form">Confira suas informações</h2>
			<aui:form action="<%= enviarURL %>" method="post" name="fm">

				<fieldset class="fieldset ">

					<div class="row-fluid">

						<div class="span6">

							<div class="control-group input-String-wrapper">
								<label class="control-label" for="_58_firstName"> Nome <span class="label-required">*</span> </label>
								<input class="field lfr-input-text" id="_58_firstName" name="_58_firstName" type="text" value="<%=nome %>" maxlength="75" disabled>
								<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Nome do usuário.">
								<i class="icon icon-question-form"></i>
							</a>
							</div>

						</div>

						<div class="span6">

							<div class="control-group input-Date-wrapper">

								<label class="control-label" for="_58_emailAddress">Email <span class="label-required">*</span></label>

								<span class="lfr-input-date field" id="ixfm_null_null_displayDate">
									<div class="control-group input-text-wrapper">
										<input class="field" id="_58_emailAddress" name="_58_emailAddress" type="text" wrappedfield="true" value="<%=email %>" disabled>
										<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Email do usuário.">
											<i class="icon icon-question-form"></i>
										</a>
									</div>
								</span>
							</div>

						</div>
					</div>

						<div class="clearfix">
							<div class="clearfix row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label" for="<portlet:namespace /><%=Constantes.CAMPO_UF %>"> UF <span class="label-required">*</span></label>
										<select class="aui-field-select" id="<portlet:namespace /><%=Constantes.CAMPO_UF %>" name="<portlet:namespace /><%=Constantes.CAMPO_UF %>">
										    <option class="" value="" selected="selected">Selecione</option>
											<option class="" value="AC">Acre</option>
										    <option class="" value="AL">Alagoas</option>
										    <option class="" value="AP">Amapá</option>
										    <option class="" value="AM">Amazonas</option>
										    <option class="" value="BA">Bahia</option>
										    <option class="" value="CE">Ceará</option>
										    <option class="" value="DF">Distrito Federal</option>
										    <option class="" value="ES">Espirito Santo</option>
										    <option class="" value="GO">Goiás</option>
										    <option class="" value="MA">Maranhão</option>
										    <option class="" value="MS">Mato Grosso do Sul</option>
										    <option class="" value="MT">Mato Grosso</option>
										    <option class="" value="MG">Minas Gerais</option>
										    <option class="" value="PA">Pará</option>
										    <option class="" value="PB">Paraíba</option>
										    <option class="" value="PR">Paraná</option>
										    <option class="" value="PE">Pernambuco</option>
										    <option class="" value="PI">Piauí</option>
										    <option class="" value="RJ">Rio de Janeiro</option>
										    <option class="" value="RN">Rio Grande do Norte</option>
										    <option class="" value="RS">Rio Grande do Sul</option>
										    <option class="" value="RO">Rondônia</option>
										    <option class="" value="RR">Roraima</option>
										    <option class="" value="SC">Santa Catarina</option>
										    <option class="" value="SP">São Paulo</option>
										    <option class="" value="SE">Sergipe</option>
										    <option class="" value="TO">Tocantins</option>										
										</select>
										<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Digite o estado.">
											<i class="icon icon-question-form"></i>
										</a>
									</div>
								</div>

								<div class="span6">
									<div class="control-group input-String-wrapper">
									<label class="control-label" for="<portlet:namespace /><%=Constantes.CAMPO_CIDADE %>"> Cidade <span class="label-required">*</span></label>
									<input class="field lfr-input-text" id="<portlet:namespace /><%=Constantes.CAMPO_CIDADE %>" name="<portlet:namespace /><%=Constantes.CAMPO_CIDADE %>" type="text" value="" maxlength="75">
									<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Digite a cidade.">
										<i class="icon icon-question-form"></i>
									</a>
									</div>
								</div>
							</div>
						</div>

						<div class="row-fluid">

							<div class="span6">

								<div class="control-group input-telefone">
									<label class="control-label" for="<portlet:namespace /><%=Constantes.CAMPO_CELULAR %>"> Celular <span class="label-required">*</span></label>
									<input class="field sp_celphones" id="<portlet:namespace /><%=Constantes.CAMPO_CELULAR %>" name="<portlet:namespace /><%=Constantes.CAMPO_CELULAR %>" type="text" value="" maxlength="75">
									<a class="ajuda" href="javascript:void(0);" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="Digite o telefone.">
										<i class="icon icon-question-form"></i>
									</a>
								</div>
							</div>
						</div>

				</fieldset>

				<div class="button-holder">
					<button class="btn btn-danger btn-lg" type="submit"> Enviar </button>
				</div>
			</aui:form>

			<div class="obrigatorios">Todos os dados com (*) são obrigatórios</div>

			<div class="footer-form">
				
			</div>
		</div>
		</div>
	</div>		
</div>
</div>