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
AgendaEventoSearch searchContainer = new AgendaEventoSearch(
		renderRequest, portletURL);

List headerNames = searchContainer.getHeaderNames();

headerNames.add(StringPool.BLANK);

String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");

if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
	portalPrefs.setValue("cargos_order", "cargos-order-by-col", orderByCol);
	portalPrefs.setValue("cargos_order", "cargos-order-by-type", orderByType);
} else {
	orderByCol = portalPrefs.getValue("cargos_order", "cargos-order-by-col", "nome");
	orderByType = portalPrefs.getValue("cargos_order", "cargos-order-by-type", "asc");
}

OrderByComparator orderByComparator = AgendasEventoComparator.getAgendasEventoComparator(orderByCol,orderByType);
searchContainer.setOrderByComparator(orderByComparator);

%>
	<aui:nav-bar>
		<aui:nav>
			<c:if test='<%= permissaoAddEvento %>'>
				<portlet:renderURL var="addURL">
					<portlet:param name="jspPage" value="<%=Constantes.PATH_JSP_EDIT %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:renderURL>

				<aui:nav-item href="<%=addURL%>"
					iconCssClass="icon-plus" label="add" />
			</c:if>
			<c:if test='<%= permissaoConfigEvento %>'>
				<liferay-security:permissionsURL
					modelResource="br.com.prodevelopment.lapidarios.evento.eventoAgenda"
					modelResourceDescription="<%=HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
					resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
					var="permissionsURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>
				
				<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
			</c:if>
			
			<c:if test='<%= permissaoDeleteEvento %>'>
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

			<c:if test="<%= (permissaoAddEvento) %>">
				<aui:nav-item dropdown="<%= true %>" label="manage">
	
					<%
					
					String taglibURL = "javascript:" + renderResponse.getNamespace() + "openLocaisView()";
					%>
	
					<aui:nav-item href="<%= taglibURL %>" iconCssClass="icon-list-alt" label="label.locais" />
	
				</aui:nav-item>
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
		AgendaEventoDisplayTerms searchTerms = (AgendaEventoDisplayTerms) searchContainer
					.getSearchTerms();
	
	    List<EventoAgenda> results = null;
	    int total = 0;
		if (searchTerms.isAdvancedSearch()) {
			results = AgendaEventoUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
					searchTerms.getEventoNome(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());
			total = results.size();
		}
		else {
			results = AgendaEventoUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
					searchTerms.getEventoNome(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());
			total = results.size();
		}

		searchContainer.setTotal(total);
		searchContainer.setResults(results);
		searchContainer.setRowChecker(new RowChecker(renderResponse));

		List resultRows = searchContainer.getResultRows();

		for (int i = 0; i < results.size(); i++) {
			EventoAgenda agendaEvento = (EventoAgenda) results.get(i);

			ResultRow row = new ResultRow(agendaEvento,
					agendaEvento.getEventoAgendaId(), i);
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("jspPage", Constantes.PATH_JSP_EDIT);
			rowURL.setParameter(Constantes.CAMPO_EVENTO_AGENDA_ID, String.valueOf(agendaEvento.getEventoAgendaId()));
			rowURL.setParameter(Constantes.ACAO, Constantes.VIEW);
			rowURL.setParameter("backURL", currentURL);
			
			// Data
			String dataEvento = DateUtil.dateToString(agendaEvento.getDataEvento());
			row.addText(dataEvento, rowURL);
			//row.addDate(agendaEvento.getDataEvento(), rowURL);

			// Hora
			row.addText(agendaEvento.getHoraEvento(), rowURL);

			// Nome
			row.addText(HtmlUtil.escape(agendaEvento.getEventoNome()),
					rowURL);
			
			row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
					Constantes.PATH_JSP_ACTION,
					this.getServletContext(), request, response);
			

			// Add result row

			resultRows.add(row);
		}
	%>

	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</aui:form>

<aui:script>
	function <portlet:namespace />openLocaisView() {
		Liferay.Util.openWindow(
			{
				id: '<portlet:namespace />openCargosView',
				title: '<%= UnicodeLanguageUtil.get(pageContext, "label.locais") %>',
				uri: '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/html/local/view.jsp" /></liferay-portlet:renderURL>'
			}
		);
	}
</aui:script>