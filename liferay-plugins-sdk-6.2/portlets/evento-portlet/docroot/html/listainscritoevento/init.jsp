<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.lapidarios.portlet.listainscritoevento.Constantes"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.cadastroevento.util.EventoUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.LocalUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.AgendaEventoUtil"%>
<%@page import="br.com.prodevelopment.lapidarios.evento.util.DateUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.util.UsuarioUtil"%>
<%@page import="br.com.prodevelopment.lapidarios.evento.model.Evento"%>
<%@page import="br.com.prodevelopment.lapidarios.evento.model.Local"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.EventoAgenda"%>
<%@page import="br.com.prodevelopment.lapidarios.evento.model.EventoInscricao"%>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasPreenchidaException"%>
<%
	List<Evento> listaEventos = EventoUtil.search(
			themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId(), null, null, null);
	int pageDelta = 50;
	PortletURL portletURL = renderResponse.createRenderURL();

	SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null,
			SearchContainer.DEFAULT_CUR_PARAM, pageDelta, portletURL,
			null, null);

	searchContainer.setDelta(pageDelta);
	searchContainer.setDeltaConfigurable(false);
	
	List<EventoInscricao> results = null;

	int[] status = { WorkflowConstants.STATUS_APPROVED,
			WorkflowConstants.STATUS_PENDING };

	String filtroEventoSelecionado = ParamUtil.getString(renderRequest,
			Constantes.FILTRO_EVENTO_SELECIONADO);
	String filtroLocalSelecionado = ParamUtil.getString(renderRequest,
			Constantes.FILTRO_LOCAL_SELECIONADO);
	String filtroDataSelecionada = ParamUtil.getString(renderRequest,
			Constantes.FILTRO_DATA_SELECIONADA);
	String filtroHoraSelecionada = ParamUtil.getString(renderRequest,
			Constantes.FILTRO_HORA_SELECIONADA);
	String metodo = (String) request.getAttribute(Constantes.METODO);
	boolean filtrou = ((Validator.isNotNull(filtroEventoSelecionado))
			&& (Validator.isNotNull(filtroLocalSelecionado)) && (Validator
			.isNotNull(filtroDataSelecionada)));
%>
