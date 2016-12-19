<%@ include file="init.jsp"%>

<%
LojaIndicada lojaIndicada = (LojaIndicada)request.getAttribute(LojaIndicadaConstants.LOJA_INDICADA);
long lojaIndicadaId = BeanParamUtil.getLong(lojaIndicada, request, LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID);

String labelTitulo = "label.adicionar.loja";
if (Validator.isNotNull(lojaIndicada)) {
	if (LojaIndicadaConstants.VIEW.equals(action)) {
		labelTitulo = HtmlUtil.escape(lojaIndicada.getIdLoja());
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.loja.x", HtmlUtil.escape(lojaIndicada.getIdLoja()));
	}
}

%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (lojaIndicada == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=LojaIndicadaConstants.PORTLET_ACTION %>" value="<%=LojaIndicadaConstants.SALVAR %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= LojaIndicadaConstants.ACTION %>" type="hidden" value="<%= (lojaIndicadaId == 0) ? LojaIndicadaConstants.ADD : LojaIndicadaConstants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="lojaIndicadaId" type="hidden" value="<%= lojaIndicadaId %>" />
<%
request.setAttribute(LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID, lojaIndicadaId);
%>
<aui:model-context bean="<%= lojaIndicada %>" model="<%= LojaIndicada.class %>" />

<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= LojaIndicadaIdLojaObrigatorioException.class %>" focusField="<%=LojaIndicadaConstants.CAMPO_ID_LOJA %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=LojaIndicadaConstants.CAMPO_ID_LOJA %>" label="label.idLoja" disabled="<%=LojaIndicadaConstants.VIEW.equals(action) %>">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>
	<c:if test="<%=(!LojaIndicadaConstants.VIEW.equals(action)) %>">
		<aui:button-row>
			<aui:button type="submit" />
			<portlet:renderURL var="cancelarURL"/>
	
			<aui:button href="<%= cancelarURL %>" value="botao.cancelar"/>
		</aui:button-row>
	</c:if>
</div>
</aui:form>