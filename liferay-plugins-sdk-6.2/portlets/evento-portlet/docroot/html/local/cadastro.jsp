<%@ include file="init.jsp"%>

<%
Local local = null;//(Local)request.getAttribute(Constantes.LOCAL);
long localId = BeanParamUtil.getLong(local, request, Constantes.LOCAL_ID);
if (localId > 0) {
	local = LocalUtil.getLocal(localId);
}

String[] formInformacoes = {"dadosIniciais"};
String[] formContantos = {"enderecos", "telefones", "enderecosEmail"};

String[][] categorySections = {formInformacoes, formContantos};

String labelTitulo = "label.adicionar.local";
if (Validator.isNotNull(local)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(local.getNome());
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.local.x", HtmlUtil.escape(local.getNome()));
	}
}
%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (local == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR_LOCAL %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (localId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="localId" type="hidden" value="<%= localId %>" />
<%
request.setAttribute(Constantes.LOCAL_ID, localId);
%>
	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		jspPath="/html/local/"
		showButtons="<%= !Constantes.VIEW.equals(acao)%>"
	/>
</aui:form>

<%!
private static final String[] _CATEGORY_NAMES = {"informacoes", "contatos"};
%>