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

<portlet:actionURL var="pesquisarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION%>" value="pesquisar" />
</portlet:actionURL>

<%
	List<EventoAgenda> results = null;
	if (Validator.isNull(metodo)) {
		results = AgendaEventoUtil.listaProximosEventos(
				themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), status,
				searchContainer.getStart(), searchContainer.getEnd(),
				searchContainer.getOrderByComparator(),
				themeDisplay.getPermissionChecker());
	} else {
		results = AgendaEventoUtil.buscarEventos(
				themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), filtroLocalSelecionado,
				filtroCidadeSelecionada, filtroUFSelecionado, status,
				searchContainer.getStart(), searchContainer.getEnd(),
				searchContainer.getOrderByComparator(),
				themeDisplay.getPermissionChecker());
	}

	int total = results.size();

	searchContainer.setTotal(total);
	searchContainer.setResults(results);
%>


<header id="top-internas">
	<div class="container">
		<img src="<%=request.getContextPath() %>/images/topo-eventos.jpg" class="img-responsive">
	</div>
</header>

<div id="content">
	<div class="container">
		<h2 class="titulo-secao">Próximos Eventos</h2>
		<div id="filtro">
			<div class="row">
				<div class="span3 col-filtro">
					<aui:select label="label.uf" name="<%=Constantes.FILTRO_UF %>">
						<aui:option label="Todos" value="" />
						<%  for (String uf : listaUfs) {  %>
								 <aui:option value="<%= uf %>" label="<%= uf %>" selected="<%=uf.equals(filtroUFSelecionado) %>"/>
						 <% } %>
					</aui:select>
				</div>
				<!-- .span3 -->

				<div class="span3 col-filtro">
					<aui:select label="label.cidade" name="<%=Constantes.FILTRO_CIDADE %>">
						<aui:option label="Todas" value="" />
					</aui:select>
				</div>
				<!-- .span3 -->

				<div class="span3 col-filtro">
					<aui:select label="label.local" name="<%=Constantes.FILTRO_LOCAL %>">
						<aui:option label="label.todos" value="0" />
					</aui:select>
				</div>
				<!-- .span3 -->
				<aui:form action="<%= pesquisarURL %>" method="post" name="fm">
				<div class="span3">
					<a onClick='<%=renderResponse.getNamespace() + "executarPesquisa();" %>' class="btn-send-filter">Pesquisar</a>				
				</div>
				<!-- .span3 -->
				<aui:input name="<%=Constantes.COMPANY_ID %>" type="hidden" value="<%= themeDisplay.getCompanyId()%>" />
				<aui:input name="<%=Constantes.GROUP_ID %>" type="hidden" value="<%= themeDisplay.getScopeGroupId()%>" />
				<aui:input name="<%=Constantes.FILTRO_UF_SELECIONADO %>" type="hidden" value="<%= filtroUFSelecionado %>" />
				<aui:input name="<%=Constantes.FILTRO_CIDADE_SELECIONADA %>" type="hidden" value="<%= filtroCidadeSelecionada %>" />
				<aui:input name="<%=Constantes.FILTRO_LOCAL_SELECIONADO %>" type="hidden" value="<%= filtroLocalSelecionado %>" />
				
				</aui:form>
			</div>
			<!-- .row -->
		</div>
		<!-- #filtro -->

<ul id="resultadoBusca">
<%
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

<aui:script use="aui-io-request">
	var uf = <portlet:namespace /><%=Constantes.FILTRO_UF %>.value;
	var cidade = <portlet:namespace /><%=Constantes.FILTRO_CIDADE %>.value;
	var local = <portlet:namespace /><%=Constantes.FILTRO_LOCAL %>.value;
	var cidadeSelecionada = document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_CIDADE_SELECIONADA %>.value;
	var localSelecionado = document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO %>.value;
	var mySelectCidade = A.one('#<portlet:namespace /><%=Constantes.FILTRO_CIDADE %>');
	var mySelectLocal = A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL %>');
	atualizarCidades(uf, cidadeSelecionada, mySelectCidade);
	atualizarLocais(cidadeSelecionada, localSelecionado, mySelectLocal);
	
	A.one('#<portlet:namespace /><%=Constantes.FILTRO_UF %>').on(
		'change',
		function() {
			var uf = <portlet:namespace /><%=Constantes.FILTRO_UF %>.value;
			var mySelect = A.one('#<portlet:namespace /><%=Constantes.FILTRO_CIDADE %>');
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_UF_SELECIONADO %>.value = uf;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_CIDADE_SELECIONADA %>.value = '';
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO %>.value = '0';
			atualizarCidades(uf, 0, mySelect);
			var mySelectLocal = A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL %>');
			atualizarLocais('', 0, mySelectLocal);
		}
	);

	function atualizarCidades(uf, cidade, mySelect) {
 			A.io.request('<%=cidadeResourceURL%>',{
                        dataType: 'json',
                        method: 'GET',
                        data: { <portlet:namespace /><%=Constantes.FILTRO_UF %> : uf},
                        on: {
                              success: function() {
                              		var data=this.get('responseData');
                              		var options;
                              		mySelect.empty();
                              		options  = A.Node.create( '<option value="">Todas</option>');
                              		mySelect.append(options);
                              		A.Array.each(data, function(obj, idx) {
                              			if (cidade == obj.codigo) {
	                              			options  = A.Node.create( '<option value='+obj.codigo+' selected>'+obj.cidade+'</option>');
                              			} else {
	                              			options  = A.Node.create( '<option value='+obj.codigo+'>'+obj.cidade+'</option>');
                              			}
	                              		mySelect.append(options);
                              		})
                              		
                              }
                        }
            });			
	}

	A.one('#<portlet:namespace /><%=Constantes.FILTRO_CIDADE %>').on(
		'change',
		function() {
			var cidade = <portlet:namespace /><%=Constantes.FILTRO_CIDADE %>.value;
			var mySelect = A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL %>');
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_CIDADE_SELECIONADA %>.value = cidade;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO %>.value = '0';
			atualizarLocais(cidade, 0, mySelect);
		}
	);

	function atualizarLocais(cidade, local, mySelect) {
 			A.io.request('<%=localResourceURL%>',{
                        dataType: 'json',
                        method: 'GET',
                        data: { <portlet:namespace /><%=Constantes.FILTRO_CIDADE %> : cidade},
                        on: {
                              success: function() {
                              		var data=this.get('responseData');
                              		var options;
                              		mySelect.empty();
                              		options  = A.Node.create( '<option value="0">Todos</option>');
                              		mySelect.append(options);
                              		A.Array.each(data, function(obj, idx) {
                              			if (local == obj.codigo) {
	                              			options  = A.Node.create( '<option value='+obj.codigo+' selected>'+obj.local+'</option>');
                              			} else {
	                              			options  = A.Node.create( '<option value='+obj.codigo+'>'+obj.local+'</option>');
                              			}
	                              		mySelect.append(options);
                              		})
                              		
                              }
                        }
            });			
	}
	
	A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL %>').on(
		'change',
		function() {
			var local = <portlet:namespace /><%=Constantes.FILTRO_LOCAL %>.value;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO %>.value = local;
		}
	);
	
</aui:script>					
<aui:script>
	function <portlet:namespace />executarPesquisa() {
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>