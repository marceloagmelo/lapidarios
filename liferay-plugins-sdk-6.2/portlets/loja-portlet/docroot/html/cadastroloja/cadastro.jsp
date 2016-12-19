<%@ include file="init.jsp"%>

<%@include file="message.jspf"%>

<%
Loja loja = (Loja)request.getAttribute(CadastroLojaConstants.LOJA);
long lojaId = BeanParamUtil.getLong(loja, request, CadastroLojaConstants.LOJA_ID);

String[] formInformacoes = {"dadosPessoais"};
String[] formContantos = {"enderecos", "telefones", "enderecosEmail"};

String[][] categorySections = {formInformacoes, formContantos};

String labelTitulo = "label.adicionar.loja";
if (Validator.isNotNull(loja)) {
	if (CadastroLojaConstants.VIEW.equals(action)) {
		labelTitulo = HtmlUtil.escape(loja.getNomeFantasia());
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.loja.x", HtmlUtil.escape(loja.getNomeFantasia()));
	}
}
%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (loja == null) %>"
	title='<%= labelTitulo %>' />

<%@ include file="mensagens.jspf"%>

<portlet:actionURL var="saveURL"/>
	
<aui:form action="<%= saveURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (lojaId == 0) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="lojaId" type="hidden" value="<%= lojaId %>" />
	<aui:input name="ordemIndicadaAtual" type="hidden" value="<%= (lojaId == 0) ? false : loja.getOrdemIndicadaAtual() %>" />
<%
request.setAttribute(CadastroLojaConstants.LOJA_ID, lojaId);
%>
	<liferay-util:buffer var="htmlTop">
		<c:if test="<%= loja != null %>">
			<div class="user-info">
				<div class="float-container">
					<span class="user-name"><%= HtmlUtil.escape(loja.getNomeFantasia()) %></span>
				</div>
			</div>
		</c:if>
	</liferay-util:buffer>

	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		htmlTop="<%= htmlTop %>"
		jspPath="/html/cadastroloja/"
		showButtons="<%= !CadastroLojaConstants.VIEW.equals(action)%>"
	/>
</aui:form>

<%!
private static final String[] _CATEGORY_NAMES = {"informacoes", "contatos"};
%>