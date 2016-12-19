<%@ include file="init.jsp"%>

<%@ include file="mensagens.jspf"%>

<portlet:resourceURL var="cidadeResourceURL">
	<portlet:param name="<%=Constantes.METODO%>"
		value="<%=Constantes.GET_CIDADES_UF%>" />
</portlet:resourceURL>
<portlet:resourceURL var="localResourceURL">
	<portlet:param name="<%=Constantes.METODO%>"
		value="<%=Constantes.GET_LOCAIS_CIDADE%>" />
</portlet:resourceURL>

<%
String eventoAgendaId = (String)request.getAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID);
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
		<div class="titulo-area">Evento</div>
		<h1 class="titulo-evento-header"><%=nomeEvento %></h1>
		<ul class="info-evento">
			<li><%=dataEvento %></li>
			<li><%=localEvento %></li>
			<li><%=sbEndereco %></li>
		</ul>

	</div>
</header>
<div class="text-single-eventos">
	<div class="container">
		<div class="row">
			<div class="span7 col-txt-eventos">
				<div class="entry-text">
					<h2>Sobre o evento</h2>
<%
//String eventoConteudo = EventoUtil.getEventoConteudoWeb(agendaEvento.getGroupId(), agendaEvento.getEventoId());
JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(agendaEvento.getGroupId(), String.valueOf(evento.getArticleId()), "","",themeDisplay);
String eventoConteudo = articleDisplay.getContent();
%>					
					<%=eventoConteudo %>
				</div>
			</div>
			<div class="span5 col-horarios">
				<div class="inner-horarios">
					<div class="entry-text">
						<h2>Horários</h2>
					</div>
					<div class="entry-text">
						<h3><%=dataEvento %></h3>
					</div>
<%
List<EventoAgenda> resultsHorarios = AgendaEventoUtil.recuperarHorarios(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
		agendaEvento.getEventoId(), agendaEvento.getDataEvento(), status, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());
for (int j = 0; j < resultsHorarios.size(); j++) {
	EventoAgenda agendaEventoComHorario = (EventoAgenda) resultsHorarios.get(j);

	String gratis = (agendaEventoComHorario.isGratuito() ? "Grátis" : "");
	
	PortletURL inscricaoURL = renderResponse.createActionURL();
	inscricaoURL.setParameter(Constantes.PORTLET_ACTION, Constantes.INSCRICAO);
	inscricaoURL.setParameter(Constantes.CAMPO_EVENTO_AGENDA_ID, String.valueOf(agendaEventoComHorario.getEventoAgendaId()));
	inscricaoURL.setParameter(Constantes.COMPANY_ID, String.valueOf(themeDisplay.getCompanyId()));
	inscricaoURL.setParameter(Constantes.GROUP_ID, String.valueOf(themeDisplay.getScopeGroupId()));
	inscricaoURL.setParameter(Constantes.USER_ID, String.valueOf(themeDisplay.getUserId()));
	inscricaoURL.setParameter(Constantes.REDIRECT, Constantes.JSP_DETALHE_EVENTO);
%>						
					<div class="tabela-inscricao">
						<div class="group-itens">
						  	<div class="item-evento">
					  			<div class="col-item-evento"><%=agendaEventoComHorario.getHoraEvento() %>hs</div>
					  			<div class="col-item-evento">
						  			<c:choose>
						  				<c:when test='<%=!"".equals(gratis) %>'>
						  					<%=gratis %>
						  				</c:when>
						  				<c:otherwise>
						  					<%=agendaEventoComHorario.getValor() %>
						  				</c:otherwise>
						  			</c:choose>
					  			</div>
					  			<c:choose>
					  				<c:when test='<%=AgendaEventoUtil.usuarioInscrito(agendaEventoComHorario.getEventoAgendaId(), themeDisplay.getUserId()) %>'>
					  					<p class="inscrito">Inscrito</p>
					  				</c:when>
					  				<c:otherwise>
							  			<c:choose>
							  				<c:when test='<%=agendaEventoComHorario.getQtdeVagas() > agendaEventoComHorario.getQtdeVagasPreenchida() %>'>
							  					<a href="<%=inscricaoURL.toString() %>" class="btn btn-danger bt-inscricao"><i class="fa fa-sign-out" aria-hidden="true"></i>Inscreva-se</a>
							  				</c:when>
							  				<c:otherwise>
							  					<p class="esgotado">vagas esgotadas</p>
							  				</c:otherwise>
							  			</c:choose>
					  				</c:otherwise>
					  			</c:choose>
						  	</div>
					  	</div> <!-- .group-itens -->
		            </div> <!-- .tabela-inscricao -->
<%
}
%>			
		    	</div> <!-- .inner-horarios -->
			</div>
		</div>
	</div>
</div>
<%
}
%>
<div id="content">
	<div class="container">
		<h2 class="titulo-secao">Próximos Eventos</h2>
		<ul id="resultadoBusca">
<%
List<EventoAgenda> results = null;
if (Validator.isNull(metodo)) {
	results = AgendaEventoUtil.listaProximosEventos(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
			status, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());
} else {
	results = AgendaEventoUtil.buscarEventos(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
			filtroLocalSelecionado, filtroCidadeSelecionada, filtroUFSelecionado, status, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());
}

int total = results.size();

searchContainer.setTotal(total);
searchContainer.setResults(results);

for (int i = 0; i < results.size(); i++) {
	EventoAgenda agendaEvento = (EventoAgenda) results.get(i);
	String eventoDescricao = StringPool.BLANK;
	Evento evento = EventoUtil.getEvento(agendaEvento.getEventoId());
	if (Validator.isNotNull(evento)) {
		eventoDescricao = evento.getDescricao(locale);
	}
	String nomeEvento = agendaEvento.getEventoNome(locale);
	//String dataEvento = DateUtil.getDateExtenso(agendaEvento.getDataEvento(), false);
	String dataEvento = DateUtil.getDateDiaSemana(agendaEvento.getDataEvento()) + " - " + DateUtil.dateToString(agendaEvento.getDataEvento());
	
	
	Local local = LocalUtil.getLocal(agendaEvento.getLocalId());
	StringBuffer sbLocal = new StringBuffer("");
	if (Validator.isNotNull(local)) {
		if (Validator.isNotNull(local.getEndCidade())) {
			sbLocal.append(local.getEndCidade());
		}
		if (Validator.isNotNull(local.getEndUf())) {
			sbLocal.append(", "+local.getEndUf());
		}
    }
%>		
		<li>
			<portlet:renderURL var="detalheEventoURL">
				<portlet:param name="<%=Constantes.REDIRECT%>"
					value="<%=Constantes.JSP_DETALHE_EVENTO%>" />
				<portlet:param name="<%=Constantes.CAMPO_EVENTO_AGENDA_ID%>"
					value="<%=String.valueOf(agendaEvento.getEventoAgendaId())%>" />
			</portlet:renderURL>
			<a href="<%=detalheEventoURL%>">
				<div class="inner-li-eventos">
					<div class="invert">
						<div class="row">
							<div class="span3">
								<div class="group-info-left">
									<div class="data-result"><%=dataEvento %></div>
									<div class="cidade-result"><%=sbLocal.toString() %></div>
								</div>
							</div>
							<div class="span9">
								<div class="inner-right-evento">
									<h2><%=nomeEvento %></h2>
									<p><%=eventoDescricao %></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</a>
		</li>
<%
}
%>
		</ul>
	</div>
</div>
