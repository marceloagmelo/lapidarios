<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "openLocalSelector");
	String target = ParamUtil.getString(request, "target");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("target", target);
	portletURL.setParameter("jspPage", "/html/local/selecione.jsp");
	portletURL.setParameter("redirect", currentURL);

	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	
	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("locais_order", "locais-order-by-col", orderByCol);
		portalPrefs.setValue("locais_order", "locais-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("locais_order", "locais-order-by-col", "nome");
		orderByType = portalPrefs.getValue("locais_order", "locais-order-by-type", "asc");
	}

	List<Local> locais = new ArrayList<Local>();
	OrderByComparator orderByComparator = LocaisComparator.getLocaisOrderByComparator(orderByCol,orderByType);
	locais = LocalUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), keywords, orderByComparator, 
			themeDisplay.getPermissionChecker());
%>


<aui:form action="<%=portletURLString%>"  method="post" name="openLocalSelectorFm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />

	<liferay-ui:search-container emptyResultsMessage="mensagem.naoExistem.locais" iteratorURL="<%=portletURL %>">

		<aui:nav-bar>
			<aui:nav>
				<portlet:renderURL var="addURL">
					<portlet:param name="jspPage" value="/html/local/cadastro.jsp" />
					<portlet:param name="redirect" value="<%= Constantes.REDIRECT_SELECIONE_LOCAL %>" />
				</portlet:renderURL>

				<aui:nav-item href="<%=addURL%>"
					iconCssClass="icon-plus" label="add" />

			</aui:nav>
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search
						autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
						placeholder='<%=LanguageUtil.get(locale, "keywords")%>' />
				</div>

			</aui:nav-bar-search>
		</aui:nav-bar>


		<liferay-ui:search-container-results>

			<%
				results = ListUtil.subList(locais, searchContainer.getStart(), searchContainer.getEnd());
				total = locais.size();
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
				
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="br.com.prodevelopment.lapidarios.evento.model.Local"
			keyProperty="localId" modelVar="local">

			<liferay-ui:search-container-column-text name="label.nome" buffer="buffer">
			<%
			buffer.append(local.getNome());
			%>	
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text>
				<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("localid", local.getLocalId());
				data.put("nome", HtmlUtil.escapeAttribute(local.getNome()));
				%>

				<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />openLocalSelectorFm').delegate(
		'click',
		function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');

			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);
			
			Util.getWindow().hide();
		},
		'.selector-button'
	);
</aui:script>