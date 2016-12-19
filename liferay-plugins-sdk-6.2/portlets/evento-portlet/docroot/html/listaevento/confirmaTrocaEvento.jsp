<%@ include file="init.jsp"%>

<%@ include file="mensagens.jspf"%>

<%
String eventoAgendaIdNovo = (String)request.getAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID_NOVO);
String eventoAgendaId = (String)request.getAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID);

PortletURL inscricaoURL = renderResponse.createActionURL();
inscricaoURL.setParameter(Constantes.PORTLET_ACTION, Constantes.TROCA_INSCRICAO);
inscricaoURL.setParameter(Constantes.CAMPO_EVENTO_AGENDA_ID_NOVO, eventoAgendaIdNovo);
inscricaoURL.setParameter(Constantes.CAMPO_EVENTO_AGENDA_ID, eventoAgendaId);
inscricaoURL.setParameter(Constantes.COMPANY_ID, String.valueOf(themeDisplay.getCompanyId()));
inscricaoURL.setParameter(Constantes.GROUP_ID, String.valueOf(themeDisplay.getScopeGroupId()));
inscricaoURL.setParameter(Constantes.USER_ID, String.valueOf(themeDisplay.getUserId()));
inscricaoURL.setParameter(Constantes.REDIRECT, Constantes.JSP_DETALHE_EVENTO);

if (Validator.isNotNull(eventoAgendaId)) {
%>
<header id="top-internas">
	<div class="container">

<%
	EventoAgenda agendaEvento = AgendaEventoUtil.getEventoAgenda(Long.valueOf(eventoAgendaId));

	Evento evento = EventoUtil.getEvento(agendaEvento.getEventoId());
	String nomeEvento = agendaEvento.getEventoNome(locale);
	String localEvento = agendaEvento.getLocalNome();
	//String dataEvento = DateUtil.getDateExtenso(agendaEvento.getDataEvento(), false);
	String dataEvento = DateUtil.getDateDiaSemana(agendaEvento.getDataEvento()) + " - " + DateUtil.dateToString(agendaEvento.getDataEvento());
	String horaEvento = agendaEvento.getHoraEvento();

	
	Local local = LocalUtil.getLocal(agendaEvento.getLocalId());
	StringBuffer sbEndereco = new StringBuffer("");
	if (Validator.isNotNull(local)) {
		sbEndereco.append("End. " + local.getEndLogradouro());
		if (Validator.isNotNull(local.getEndNumero())) {
			sbEndereco.append(", "+local.getEndNumero());
		}
		if (Validator.isNotNull(local.getEndBairro())) {
			sbEndereco.append(" - "+local.getEndBairro());
		}
		if (Validator.isNotNull(local.getEndCidade())) {
			sbEndereco.append(" - "+local.getEndCidade());
		}
		if (Validator.isNotNull(local.getEndUf())) {
			sbEndereco.append(" - "+local.getEndUf());
		}
   }	
%>		
		<div class="titulo-area">Você esta inscrito no evento abaixo:</div>
		<h1 class="titulo-evento-header"><%=nomeEvento %></h1>
		<ul class="info-evento">
			<li><%=dataEvento %> - <%=horaEvento %></li>
			<li><%=localEvento %></li>
			<li><%=sbEndereco %></li>
		</ul>

	</div>
</header>
<div class="text-single-eventos">
	<div class="container">
		<div class="row">
			<div class="span5 col-horarios">
				<div class="inner-horarios">
					<div class="tabela-inscricao">
						<div class="group-itens">
						  	<div class="item-evento">
			  					<a href="<%=inscricaoURL.toString() %>" class="btn btn-danger bt-inscricao"><i class="fa fa-sign-out" aria-hidden="true"></i>Confirma troca?</a>
						  	</div>
					  	</div> <!-- .group-itens -->
		            </div> <!-- .tabela-inscricao -->
		    	</div> <!-- .inner-horarios -->
			</div>
		</div>
	</div>
</div>
<%
}
%>