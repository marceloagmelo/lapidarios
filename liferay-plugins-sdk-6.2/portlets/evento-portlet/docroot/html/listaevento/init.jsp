<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.lapidarios.portlet.listaevento.Constantes"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.cadastroevento.util.EventoUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.LocalUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.AgendaEventoUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.util.DateUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.util.UsuarioUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.Evento"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.Local"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.EventoAgenda"%>

<%@page
	import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>

<%@page
	import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasPreenchidaException"%>
<%
List<String> listaUfs = LocalUtil.getUFs(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
String eventoNomeAnterior=StringPool.BLANK; 
String eventoDataAnterior=StringPool.BLANK;
boolean mudouEventoData=true;
int pageDelta = 50	;
PortletURL portletURL = renderResponse.createRenderURL();

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, pageDelta, portletURL, null, null);

searchContainer.setDelta(pageDelta);
searchContainer.setDeltaConfigurable(false);

int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};

String filtroUFSelecionado = (String)request.getAttribute(Constantes.FILTRO_UF_SELECIONADO);
String filtroCidadeSelecionada = (String)request.getAttribute(Constantes.FILTRO_CIDADE_SELECIONADA);
String filtroLocalSelecionado = (String)request.getAttribute(Constantes.FILTRO_LOCAL_SELECIONADO);
String metodo = (String)request.getAttribute(Constantes.METODO);
boolean filtrou = ((Validator.isNotNull(filtroUFSelecionado)) && (Validator.isNotNull(filtroCidadeSelecionada)) && (Validator.isNotNull(filtroLocalSelecionado)));
%>
