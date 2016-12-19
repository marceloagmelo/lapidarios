<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.LocalUtil"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.search.AgendaEventoSearch"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.search.AgendaEventoSearchTerms"%>
<%@page
	import="br.com.prodevelopment.lapidarios.portlet.agendaevento.search.AgendaEventoDisplayTerms"%>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.Local"%>

<%@page import="br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator.LocaisComparator" %>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.LocalAlteradoOutroUsuarioException"%>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.LocalNomeObrigatorioException"%>

<%@page import="br.com.prodevelopment.lapidarios.contato.model.Telefone" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail" %>

<%@page import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.TelefoneUtil" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.agendaevento.util.EnderecoEmailUtil" %>

<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneDDDObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneDDDInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneNumeroObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneNumeroInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoInvalidoException" %>

<%@page
	import="br.com.prodevelopment.lapidarios.evento.model.Local"%>

