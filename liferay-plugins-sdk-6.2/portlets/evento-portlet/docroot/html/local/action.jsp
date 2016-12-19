<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Local local = (Local) row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/local/cadastro.jsp" />
			<portlet:param name="<%=Constantes.REDIRECT %>" value="<%=Constantes.REDIRECT_VIEW_LOCAL%>" />
			<portlet:param name="localId"
				value="<%=String.valueOf(local.getLocalId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

		<liferay-security:permissionsURL
			modelResource="<%=Local.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(local.getNome())%>"
			resourcePrimKey="<%=String.valueOf(local.getLocalId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

		<portlet:actionURL var="deleteURL" name="deletarLocal">
			<portlet:param name="jspPage" value="/html/local/view.jsp" />
			<portlet:param name="direciona" value="<%=Constantes.REDIRECT_VIEW_LOCAL%>" />
			<portlet:param name="localId"
				value="<%=String.valueOf(local.getLocalId())%>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL%>" />
</liferay-ui:icon-menu>
