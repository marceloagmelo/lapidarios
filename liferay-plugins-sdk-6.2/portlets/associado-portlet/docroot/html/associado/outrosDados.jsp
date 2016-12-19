<%@ include file="init.jsp"%>

<%
Associado associado = (Associado)request.getAttribute(Constantes.ASSOCIADO);
long associadoId = BeanParamUtil.getLong(associado, request, Constantes.ASSOCIADO_ID);

// Loja indicada
String sIdLojaIndicada = ParamUtil.getString(request, Constantes.CAMPO_ID_LOJA_INDICADA);
if ( (Validator.isNull(sIdLojaIndicada)) && (associado != null) ) {
	if (Validator.isNotNull(associado.getIdLojaIndicada())) {
		sIdLojaIndicada = associado.getIdLojaIndicada();
	}
}

%>
<liferay-ui:error-marker key="errorSection" value="outrosDados" />

<aui:model-context bean="<%= associado %>" model="<%= Associado.class %>" />

<aui:input name="versao" type="hidden"/>

<h3><liferay-ui:message key="outrosDados" /></h3>
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= AssociadoIDPolishopDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_ID_POLISHOP %>" message="mensagem.idpolishop.duplicado" />
		<aui:input name="<%=Constantes.CAMPO_ID_POLISHOP %>" label="label.idPolishop"/>

		<aui:field-wrapper label="label.idLojaIndicada">
			<input name="lojaIndicadaHidden" disabled="disabled" value="<%=sIdLojaIndicada %>"/>
		</aui:field-wrapper>
		<aui:input name="<%=Constantes.CAMPO_ID_LOJA_INDICADA %>" type="hidden" />

		<aui:input name="<%=Constantes.CAMPO_ID_PATROCINADOR %>" label="label.idPatrocinador"/>

	</aui:fieldset>
</div>

<aui:script use="aui-base">
	var verSeDesabilitaCamposDadosPessoais = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_ID_POLISHOP %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_ID_PATROCINADOR %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposDadosPessoais(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>
