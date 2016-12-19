<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(LojaIndicadaConstants.SEARCH_CONTAINER_RESULT_ROW);

	LojaIndicada lojaIndicada = (LojaIndicada) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
				lojaIndicada.getGroupId(),
				LojaIndicada.class.getName(),
				lojaIndicada.getLojaIndicadaId(), ActionKeys.UPDATE) || permissaoUpdateLojaIndicada)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="<%=LojaIndicadaConstants.PATH_JSP_EDIT %>" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="<%=LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID %>"
				value="<%=String.valueOf(lojaIndicada.getLojaIndicadaId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
				lojaIndicada.getGroupId(),
				LojaIndicada.class.getName(),
				lojaIndicada.getLojaIndicadaId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=LojaIndicada.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(lojaIndicada.getIdLoja())%>"
			resourcePrimKey="<%=String.valueOf(lojaIndicada.getLojaIndicadaId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
				lojaIndicada.getGroupId(),
				LojaIndicada.class.getName(),
				lojaIndicada.getLojaIndicadaId(), ActionKeys.DELETE) || permissaoDeleteLojaIndicada)%>">


		<portlet:actionURL name="deletar" var="deleteURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="<%=LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID %>"
				value="<%= String.valueOf(lojaIndicada.getLojaIndicadaId()) %>" />
			<portlet:param name="deleteTagIds" value=""/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>