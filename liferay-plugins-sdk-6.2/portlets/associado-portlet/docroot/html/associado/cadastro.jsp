<%@ include file="init.jsp"%>

<%
Associado associado = (Associado)request.getAttribute(Constantes.ASSOCIADO);
long associadoId = BeanParamUtil.getLong(associado, request, Constantes.ASSOCIADO_ID);

String[] formInformacoes = {"dadosBasicos", "outrosDados"};
String[] formContantos = {"enderecos", "telefones", "enderecosEmail"};

String[][] categorySections = {formInformacoes, formContantos};

String labelTitulo = "label.adicionar.associado";
if (Validator.isNotNull(associado)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(associado.getNome());
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.associado.x", HtmlUtil.escape(associado.getNome()));
	}
}
%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (associado == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (associadoId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="associadoId" type="hidden" value="<%= associadoId %>" />
<%
request.setAttribute(Constantes.ASSOCIADO_ID, associadoId);
%>
	<liferay-util:buffer var="htmlTop">
		<c:if test="<%= associado != null %>">
			<div class="user-info">
				<div class="float-container">
					<img alt="<%= HtmlUtil.escape(associado.getNome()) %>" class="user-logo" src="<%= associado.getFotoURL(themeDisplay, associado.getUserId(), associado.getSexo()) %>" />

					<span class="user-name"><%= HtmlUtil.escape(associado.getNome()) %></span>
				</div>
			</div>
		</c:if>
	</liferay-util:buffer>

	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		htmlTop="<%= htmlTop %>"
		jspPath="/html/associado/"
		showButtons="<%= !Constantes.VIEW.equals(acao)%>"
	/>
</aui:form>

<%!
private static final String[] _CATEGORY_NAMES = {"informacoes", "contatos"};
%>