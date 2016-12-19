<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");

	PortletURL portletURL = renderResponse.createRenderURL();

	pageContext.setAttribute("portletURL", portletURL);

	String portletURLString = portletURL.toString();
%>

<%@ include file="mensagens.jspf"%>

<aui:form action="<%=portletURLString%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="deleteTagIds" type="hidden" />

<%
AssociadoSearch searchContainer = new AssociadoSearch(
		renderRequest, portletURL);

List headerNames = searchContainer.getHeaderNames();

headerNames.add(StringPool.BLANK);
%>
	<aui:nav-bar>
		<aui:nav>
			<c:if test='<%= permissaoAddAssociado %>'>
				<portlet:renderURL var="addURL">
					<portlet:param name="jspPage" value="/html/associado/cadastro.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:renderURL>

				<aui:nav-item href="<%=addURL%>"
					iconCssClass="icon-plus" label="add" />
			</c:if>
			<c:if test='<%= permissaoConfigAssociado %>'>
				<liferay-security:permissionsURL
					modelResource="br.com.prodevelopment.associado"
					modelResourceDescription="<%=HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
					resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
					var="permissionsURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>
				
				<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
			</c:if>
			
			<c:if test='<%= permissaoDeleteAssociado %>'>
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
						<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="deletarSelecionados" />
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
		<aui:nav-bar-search cssClass="pull-right"
			searchContainer="<%= searchContainer %>">
			<div class="form-search">
				<liferay-ui:input-search
					autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
					name="<%=Constantes.CAMPO_NOME %>"
					placeholder='<%=LanguageUtil.get(locale, "keywords")%>' />
			</div>

		</aui:nav-bar-search>
	</aui:nav-bar>

	<%
		AssociadoDisplayTerms searchTerms = (AssociadoDisplayTerms) searchContainer
					.getSearchTerms();

		List<Associado> results = AssociadoUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
				searchTerms.getNome(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker(), prefAssociadoSomenteEsseSite);

		int total = results.size();

		searchContainer.setTotal(total);

		searchContainer.setResults(results);
		
		searchContainer.setRowChecker(new RowChecker(renderResponse));

		List resultRows = searchContainer.getResultRows();

		for (int i = 0; i < results.size(); i++) {
			Associado associado = (Associado) results.get(i);

			ResultRow row = new ResultRow(associado,
					associado.getAssociadoId(), i);
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("jspPage", "/html/associado/cadastro.jsp");
			rowURL.setParameter(Constantes.ASSOCIADO_ID, String.valueOf(associado.getAssociadoId()));
			rowURL.setParameter(Constantes.ACAO, Constantes.VIEW);
			rowURL.setParameter("backURL", currentURL);
			
			// Nome
			row.addText(HtmlUtil.escape(associado.getNome()),
					rowURL);

			row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
					"/html/associado/action.jsp",
					this.getServletContext(), request, response);
			

			// Add result row

			resultRows.add(row);
		}
	%>

	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</aui:form>