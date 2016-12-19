<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	EventoAgenda agendaEvento = (EventoAgenda) row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="<%=Constantes.PATH_JSP_EDIT %>" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="<%=Constantes.CAMPO_EVENTO_AGENDA_ID %>"
				value="<%=String.valueOf(agendaEvento.getEventoAgendaId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

</liferay-ui:icon-menu>
