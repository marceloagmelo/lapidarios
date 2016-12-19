<%@ include file="init.jsp"%>

<%
	//PessoaSearch searchContainer = (PessoaSearch)request.getAttribute("liferay-ui:search:searchContainer");

	//String redirect = ParamUtil.getString(request, "redirect");

	ResultRow row = (ResultRow) request
			.getAttribute(CadastroLojaConstants.SEARCH_CONTAINER_RESULT_ROW);

	Loja loja = (Loja) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							loja.getGroupId(),
							Loja.class.getName(),
							loja.getLojaId(), ActionKeys.UPDATE) || permissaoUpdateLoja)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="<%=CadastroLojaConstants.PATH_JSP_EDIT %>" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="lojaId"
				value="<%=String.valueOf(loja.getLojaId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							loja.getGroupId(),
							Loja.class.getName(),
							loja.getLojaId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=Loja.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(loja.getNomeFantasia())%>"
			resourcePrimKey="<%=String.valueOf(loja.getLojaId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							loja.getGroupId(),
							Loja.class.getName(),
							loja.getLojaId(), ActionKeys.DELETE) || permissaoDeleteLoja)%>">


		<portlet:actionURL name="deletar" var="deleteURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="lojaId"
				value="<%= String.valueOf(loja.getLojaId()) %>" />
			<portlet:param name="deleteTagIds" value=""/>
			<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete
			trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
			url="<%= deleteURL %>"
		/>

	</c:if>
</liferay-ui:icon-menu>
