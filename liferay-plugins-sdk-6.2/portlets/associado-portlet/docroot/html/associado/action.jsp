<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Associado associado = (Associado) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							associado.getGroupId(),
							Associado.class.getName(),
							associado.getAssociadoId(), ActionKeys.UPDATE) || permissaoUpdateAssociado)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/associado/cadastro.jsp" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="associadoId"
				value="<%=String.valueOf(associado.getAssociadoId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							associado.getGroupId(),
							Associado.class.getName(),
							associado.getAssociadoId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=Associado.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(associado.getNome())%>"
			resourcePrimKey="<%=String.valueOf(associado.getAssociadoId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							associado.getGroupId(),
							Associado.class.getName(),
							associado.getAssociadoId(), ActionKeys.DELETE) || permissaoDeleteAssociado)%>">

		<portlet:actionURL var="deleteURL" name="deletar">
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="associadoId"
				value="<%=String.valueOf(associado.getAssociadoId())%>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>
	
		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>
