<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");

	PortletURL portletURL = renderResponse.createRenderURL();
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
%>
<%@include file="mensagens.jspf"%>

<div class="loja-indicada-portlet" id="<portlet:namespace/>">
	<aui:form action="<%=portletURLString%>" method="get" name="fm">
		<liferay-portlet:renderURLParams varImpl="portletURL" />
		<aui:input name="deleteTagIds" type="hidden" />
		<%
			LojaIndicadaSearch searchContainer = new LojaIndicadaSearch(
					renderRequest, portletURL);
			List headerNames = searchContainer.getHeaderNames();
			headerNames.add(StringPool.BLANK);
		%>
		<aui:nav-bar>
			<aui:nav>
				<c:if test="<%=permissaoAddLojaIndicada%>">
					<portlet:renderURL var="addURL">
						<portlet:param name="jspPage"
							value="<%=LojaIndicadaConstants.PATH_JSP_EDIT%>" />
						<portlet:param name="redirect" value="<%=currentURL%>" />
					</portlet:renderURL>
					<aui:nav-item href="<%=addURL%>" iconCssClass="icon-plus"
						label="add" />
				</c:if>
				<c:if test="<%=permissaoConfigLojaIndicada%>">
					<liferay-security:permissionsURL
						modelResource="<%=LojaIndicadaConstants.RESOURCE_LOJA_INDICADA%>"
						modelResourceDescription="<%=HtmlUtil.escape(themeDisplay
									.getScopeGroupName())%>"
						resourcePrimKey="<%=String.valueOf(scopeGroupId)%>"
						var="permissionsURL"
						windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

					<aui:nav-item href="<%=permissionsURL%>" label="permissions"
						title="edit-permissions" useDialog="<%=true%>" />
				</c:if>
			<c:if test='<%= permissaoDeleteLojaIndicada %>'>
				<aui:nav-item cssClass="hide" dropdown="<%=true%>"
					id="tagsActionsButton" label="actions">
					<aui:nav-item cssClass="item-remove" iconCssClass="icon-remove"
						id="deleteSelectedTags" label="delete" />
				</aui:nav-item>
				
				<aui:script use="aui-base,liferay-util-list-fields">
					A.one('#<portlet:namespace /><%=searchContainerReference.getId()%>SearchContainer').delegate(
						'click',
						function() {
							var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace /><%=RowChecker.ALL_ROW_IDS%>').length == 0);
				
							A.one('#<portlet:namespace />tagsActionsButton').toggle(!hide);
						},
						'input[type=checkbox]'
					);
				
					A.one('#<portlet:namespace />deleteSelectedTags').on(
						'click',
						function() {
							if (confirm('<liferay-ui:message
						key="are-you-sure-you-want-to-delete-this" />')) {
								<portlet:actionURL var="deleteURL">
						<portlet:param name="<%=LojaIndicadaConstants.PORTLET_ACTION %>" value="deletarSelecionados" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
					</portlet:actionURL>
				
								document.<portlet:namespace />fm.method = "post";
								document.<portlet:namespace />fm.<portlet:namespace />deleteTagIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
								
								submitForm(document.<portlet:namespace />fm, '<%=deleteURL%>');
							}
						}
					);
				</aui:script>
				
			</c:if>
			</aui:nav>
		</aui:nav-bar>
		<%
			LojaIndicadaDisplayTerms searchTerms = (LojaIndicadaDisplayTerms) searchContainer
						.getSearchTerms();
			List<LojaIndicada> results = LojaIndicadaUtil.search(
					themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(),
					searchTerms.getKeywords(), searchContainer.getStart(),
					searchContainer.getEnd(),
					searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());
			int total = LojaIndicadaUtil.searchCount(
					themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(),
					searchTerms.getKeywords(), themeDisplay.getPermissionChecker());
			
			searchContainer.setTotal(total);

			searchContainer.setResults(results);

			searchContainer.setRowChecker(new RowChecker(renderResponse));

			List resultRows = searchContainer.getResultRows();
			
			for (int i = 0; i < results.size(); i++) {
				LojaIndicada lojaIndicada = (LojaIndicada) results.get(i);
				
				ResultRow row = new ResultRow(lojaIndicada,
						lojaIndicada.getLojaIndicadaId(), i);

				PortletURL rowURL = renderResponse.createRenderURL();
				rowURL.setParameter("jspPage",
						LojaIndicadaConstants.PATH_JSP_EDIT);
				rowURL.setParameter(LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID,
						String.valueOf(lojaIndicada.getLojaIndicadaId()));
				rowURL.setParameter(LojaIndicadaConstants.ACTION,
						ActionKeys.VIEW);
				rowURL.setParameter("backURL", currentURL);

				// ID Loja
				row.addText(lojaIndicada.getIdLoja(), rowURL);
				
				row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
						"/html/action.jsp",
						this.getServletContext(), request, response);
				
				// Add result row
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</aui:form>
</div>