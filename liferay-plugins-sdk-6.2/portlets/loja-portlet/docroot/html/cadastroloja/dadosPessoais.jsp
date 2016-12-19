<%@ include file="init.jsp"%>

<%
Loja loja = (Loja)request.getAttribute(CadastroLojaConstants.LOJA);
long lojaId = BeanParamUtil.getLong(loja, request, CadastroLojaConstants.LOJA_ID);
String observacao = "";
if (lojaId > 0) {
	observacao = loja.getObservacao(locale);
}
%>
<liferay-ui:error-marker key="errorSection" value="dadosPessoais" />

<aui:model-context bean="<%= loja %>" model="<%= Loja.class %>" />

<aui:input name="versao" type="hidden"/>

<h3><liferay-ui:message key="dadosPessoais" /></h3>
<liferay-ui:error exception="<%= LojalteradaOutroUsuarioException.class %>" focusField="<%=CadastroLojaConstants.CAMPO_NOME_FANTASIA %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= LojaRazaoSocialObrigatorioException.class %>" focusField="<%=CadastroLojaConstants.CAMPO_RAZAO_SOCIAL %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=CadastroLojaConstants.CAMPO_RAZAO_SOCIAL %>" label="label.razaoSocial">
			<aui:validator name="required" />
		</aui:input>

		<liferay-ui:error exception="<%= LojaNomeFantasiaObrigatorioException.class %>" focusField="<%=CadastroLojaConstants.CAMPO_NOME_FANTASIA %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=CadastroLojaConstants.CAMPO_NOME_FANTASIA %>" label="label.nomeFantasia">
			<aui:validator name="required" />
		</aui:input>

		<liferay-ui:error exception="<%= LojaCNPJInvalidoException.class %>" focusField="<%=CadastroLojaConstants.CAMPO_CNPJ %>" message="mensagem.cnpj.invalido" />
		<liferay-ui:error exception="<%= LojaCNPJDuplicadoException.class %>" focusField="<%=CadastroLojaConstants.CAMPO_CNPJ %>" message="mensagem.cnpj.duplicado" />
		<aui:input name="<%=CadastroLojaConstants.CAMPO_CNPJ %>" label="label.cnpj" max="14">
			<aui:validator name="minLength">14</aui:validator>
			<aui:validator name="maxLength">14</aui:validator>
			<aui:validator name="number"></aui:validator>
		</aui:input>
	</aui:fieldset>
	<aui:fieldset cssClass="span5">
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.observacao">
			<liferay-ui:input-localized
				name="<%=CadastroLojaConstants.CAMPO_OBSERVACAO%>" type="textarea" xml="<%=observacao %>" />
		</aui:field-wrapper>
		
	</aui:fieldset>
</div>
<aui:script use="aui-base">
	var verSeDesabilitaCamposDadosPessoais = function(desabilita) {
		A.one('#<portlet:namespace /><%=CadastroLojaConstants.CAMPO_RAZAO_SOCIAL %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=CadastroLojaConstants.CAMPO_NOME_FANTASIA %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=CadastroLojaConstants.CAMPO_CNPJ %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=CadastroLojaConstants.CAMPO_OBSERVACAO %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposDadosPessoais(<%= (CadastroLojaConstants.VIEW.equals(action)) %>);
</aui:script>
