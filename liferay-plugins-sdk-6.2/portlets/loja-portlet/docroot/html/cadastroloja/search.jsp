<%@ include file="init.jsp" %>

<%
CadastroLojaSearch searchContainer = (CadastroLojaSearch)request.getAttribute("liferay-ui:search:searchContainer");

CadastroLojaDisplayTerms displayTerms = (CadastroLojaDisplayTerms)searchContainer.getDisplayTerms();
%>

<div class="form-search">
	<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" 
		name="<%= displayTerms.getNomeFantasia() %>" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
</div>
