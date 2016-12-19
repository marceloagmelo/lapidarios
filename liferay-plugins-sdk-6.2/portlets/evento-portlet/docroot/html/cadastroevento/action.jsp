<%@ include file="init.jsp"%>

<%
	//PessoaSearch searchContainer = (PessoaSearch)request.getAttribute("liferay-ui:search:searchContainer");

	//String redirect = ParamUtil.getString(request, "redirect");

	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Evento evento = (Evento) row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/cadastroevento/cadastro.jsp" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="eventoId"
				value="<%=String.valueOf(evento.getEventoId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />


		<liferay-security:permissionsURL
			modelResource="<%=Evento.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(evento.getNome())%>"
			resourcePrimKey="<%=String.valueOf(evento.getEventoId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />



		<portlet:actionURL var="deleteURL" name="deletar">
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="eventoId"
				value="<%=String.valueOf(evento.getEventoId())%>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>
	
		<liferay-ui:icon-delete url="<%=deleteURL%>" />

</liferay-ui:icon-menu>
