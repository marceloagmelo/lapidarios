<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes"%>
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
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.search.AgendaEventoSearch"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.search.AgendaEventoSearchTerms"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.search.AgendaEventoDisplayTerms"%>

<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator.AgendasEventoComparator"%>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.Evento"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.Local"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.EventoAgenda"%>


<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoAgendaAlteradoOutroUsuarioException"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoDataObrigatoriaException"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoDataInvalidaException"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoDataMenorHojeException"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoDataObrigatoriaException"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoLocalObrigatorioException"%>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoObrigatorioException"%>
<%@page
	import="br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasObrigatoriaException"%>

<%
String sDataEvento = ParamUtil.getString(request, Constantes.CAMPO_DATA_EVENTO);

EventoAgenda eventoAgenda = (EventoAgenda)request.getAttribute(Constantes.EVENTO_AGENDA);
long eventoAgendaId = BeanParamUtil.getLong(eventoAgenda, request, Constantes.CAMPO_EVENTO_AGENDA_ID);

String eventoNome = ParamUtil.getString(request, Constantes.CAMPO_EVENTO_NOME);
Evento evento = null;
long eventoId = BeanParamUtil.getLong(evento, request, Constantes.CAMPO_EVENTO_ID);

String localNome = ParamUtil.getString(request, Constantes.CAMPO_LOCAL_NOME);
Local local = null;
long localId = BeanParamUtil.getLong(local, request, Constantes.CAMPO_LOCAL_ID);

String usuarioResponsavelNome = ParamUtil.getString(request, Constantes.CAMPO_USUARIO_RESPONSAVEL_NOME);
User usuario = null;
long usuarioResponsavelId = BeanParamUtil.getLong(usuario, request, Constantes.CAMPO_USUARIO_RESPONSAVEL_ID);

boolean gratuito = false;
boolean repetir = false;

if (eventoAgendaId > 0) {
	eventoAgenda = AgendaEventoUtil.getEventoAgenda(eventoAgendaId);
	
	// Data evento
	if ( (Validator.isNull(sDataEvento)) && (eventoAgenda != null) ) {
		if (Validator.isNotNull(eventoAgenda.getDataEvento())) {
			sDataEvento = DateUtil.dateToString(eventoAgenda.getDataEvento());
		}
	}


	if ( (Validator.isNotNull(eventoAgenda)) && (eventoAgenda.getEventoId() > 0) ) {
		evento = EventoUtil.getEvento(eventoAgenda.getEventoId());
		if (Validator.isNotNull(evento)) {
			eventoId = evento.getEventoId();
			eventoNome = evento.getNome(locale);
		}
	}

	if ( (Validator.isNotNull(eventoAgenda)) && (eventoAgenda.getEventoId() > 0) ) {
		local = LocalUtil.getLocal(eventoAgenda.getLocalId());
		if (Validator.isNotNull(local)) {
			localId = local.getLocalId();
			localNome = local.getNome();
		}
	}

	if ( (Validator.isNotNull(eventoAgenda)) && (eventoAgenda.getUserResponsavelId() > 0) ) {
		usuario =  UsuarioUtil.getUsuario(eventoAgenda.getUserResponsavelId());
		if (Validator.isNotNull(usuario)) {
			usuarioResponsavelId = usuario.getUserId();
			usuarioResponsavelNome = usuario.getFullName();
		}
	}

	if (Validator.isNotNull(eventoAgenda)) {
		gratuito = eventoAgenda.getGratuito();
	}
}
String qtdeRepeticao = ParamUtil.getString(request, Constantes.CAMPO_QTDE_REPETICAO);
%>