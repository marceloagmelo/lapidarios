<%@ include file="init.jsp"%>

<portlet:resourceURL var="localResourceURL">
	<portlet:param name="<%=Constantes.METODO%>"
		value="<%=Constantes.GET_LOCAIS_EVENTO%>" />
</portlet:resourceURL>
<portlet:resourceURL var="dataResourceURL">
	<portlet:param name="<%=Constantes.METODO%>"
		value="<%=Constantes.GET_DATAS_LOCAL%>" />
</portlet:resourceURL>
<portlet:resourceURL var="horaResourceURL">
	<portlet:param name="<%=Constantes.METODO%>"
		value="<%=Constantes.GET_HORAS_DATA%>" />
</portlet:resourceURL>

<portlet:actionURL var="pesquisarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION%>" value="pesquisar" />
</portlet:actionURL>

<c:if test="<%=Constantes.FILTRO.equals(metodo) %>">
<%
	results = AgendaEventoUtil.recuperarInscritos(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
			GetterUtil.getLong(filtroHoraSelecionada), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
%>
</c:if>

<div id="content">
	<div class="container">
		<h2 class="titulo-secao">Lista de Inscritos</h2>
		<div id="filtro">
			<div class="row">
				<div class="span3 col-filtro">
					<aui:select label="label.evento"
						name="<%=Constantes.FILTRO_EVENTO%>">
						<aui:option label="" value="" />
						<%
							for (Evento evento : listaEventos) {
						%>
						<aui:option value="<%=evento.getEventoId()%>"
							label="<%=evento.getNome(locale)%>"
							selected="<%=String.valueOf(evento.getEventoId()).equals(
							filtroEventoSelecionado)%>" />
						<%
							}
						%>
					</aui:select>
				</div>
				<!-- .span3 -->

				<div class="span3 col-filtro">
					<aui:select label="label.local"
						name="<%=Constantes.FILTRO_LOCAL%>">
						<aui:option label="" value="" />
					</aui:select>
				</div>
				<!-- .span3 -->

				<div class="span3 col-filtro">
					<aui:select label="label.data"
						name="<%=Constantes.FILTRO_DATA%>">
						<aui:option label="" value="" />
					</aui:select>
				</div>
				<!-- .span3 -->

				<div class="span3 col-filtro">
					<aui:select label="label.hora"
						name="<%=Constantes.FILTRO_HORA%>">
						<aui:option label="" value="" />
					</aui:select>
				</div>
				<!-- .span3 -->

				<aui:form action="<%=pesquisarURL%>" method="post" name="fm">
					<div class="span3">
						<a
							onClick='<%=renderResponse.getNamespace() + "executarPesquisa();"%>'
							class="btn btn-danger">Pesquisar</a>
					</div>
					<!-- .span3 -->
					<aui:input name="<%=Constantes.COMPANY_ID%>" type="hidden"
						value="<%=themeDisplay.getCompanyId()%>" />
					<aui:input name="<%=Constantes.GROUP_ID%>" type="hidden"
						value="<%=themeDisplay.getScopeGroupId()%>" />
					<aui:input name="<%=Constantes.FILTRO_EVENTO_SELECIONADO%>"
						type="hidden" value="<%=filtroEventoSelecionado%>" />
					<aui:input name="<%=Constantes.FILTRO_LOCAL_SELECIONADO%>"
						type="hidden" value="<%=filtroLocalSelecionado%>" />
					<aui:input name="<%=Constantes.FILTRO_DATA_SELECIONADA%>"
						type="hidden" value="<%=filtroDataSelecionada%>" />
					<aui:input name="<%=Constantes.FILTRO_HORA_SELECIONADA%>"
						type="hidden" value="<%=filtroHoraSelecionada%>" />

				</aui:form>
			</div>
			<!-- .row -->
		</div>
		<!-- #filtro -->
<c:if test="<%=Constantes.FILTRO.equals(metodo) %>">
<%
for (int i = 0; i < results.size(); i++) {
	EventoInscricao eventoInscricao = (EventoInscricao) results.get(i);
%>
	<ul id="resultadoBusca">
		<li>
			<div class="row">
				<%=eventoInscricao.getUserNome() %>
			</div>
		</li>
	</ul>
<%
}
%>		
</c:if>		
	</div>
</div>

<aui:script use="aui-io-request">
	var evento = <portlet:namespace /><%=Constantes.FILTRO_EVENTO%>.value;
	var local = <portlet:namespace /><%=Constantes.FILTRO_LOCAL%>.value;
	var data = <portlet:namespace /><%=Constantes.FILTRO_DATA%>.value;
	var hora = <portlet:namespace /><%=Constantes.FILTRO_HORA%>.value;
	var localSelecionado = document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO%>.value;
	var dataSelecionada = document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_DATA_SELECIONADA%>.value;
	var horaSelecionada = document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_HORA_SELECIONADA%>.value;
	var mySelectEvento = A.one('#<portlet:namespace /><%=Constantes.FILTRO_EVENTO%>');
	var mySelectLocal = A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL%>');
	var mySelectData = A.one('#<portlet:namespace /><%=Constantes.FILTRO_DATA%>');
	var mySelectHora = A.one('#<portlet:namespace /><%=Constantes.FILTRO_HORA%>');
	atualizarLocais(evento, localSelecionado, mySelectLocal);
	atualizarDatas(localSelecionado, dataSelecionada, mySelectData);
	atualizarHoras(dataSelecionada, horaSelecionada, mySelectHora);
	
	A.one('#<portlet:namespace /><%=Constantes.FILTRO_EVENTO%>').on(
		'change',
		function() {
			var evento = <portlet:namespace /><%=Constantes.FILTRO_EVENTO%>.value;
			var mySelect = A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL%>');
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_EVENTO_SELECIONADO%>.value = evento;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO%>.value = '';
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_DATA_SELECIONADA%>.value = '';
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_HORA_SELECIONADA%>.value = '';
			atualizarLocais(evento, 0, mySelect);
			var mySelectData = A.one('#<portlet:namespace /><%=Constantes.FILTRO_DATA%>');
			atualizarDatas('', 0, mySelectData);
			var mySelectHora = A.one('#<portlet:namespace /><%=Constantes.FILTRO_HORA%>');
			atualizarHoras('', 0, mySelectHora);
		}
	);

	function atualizarLocais(evento, local, mySelect) {
 			A.io.request('<%=localResourceURL%>',{
                        dataType: 'json',
                        method: 'GET',
                        data: { <portlet:namespace /><%=Constantes.FILTRO_EVENTO%> : evento},
                        on: {
                              success: function() {
                              		var data=this.get('responseData');
                              		var options;
                              		mySelect.empty();
                              		options  = A.Node.create( '<option value=""></option>');
                              		mySelect.append(options);
                              		A.Array.each(data, function(obj, idx) {
                              			if (local == obj.localId) {
	                              			options  = A.Node.create( '<option value='+obj.localId+' selected>'+obj.localNome+'</option>');
                              			} else {
	                              			options  = A.Node.create( '<option value='+obj.localId+'>'+obj.localNome+'</option>');
                              			}
	                              		mySelect.append(options);
                              		})
                              		
                              }
                        }
            });			
	}

	A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL%>').on(
		'change',
		function() {
			var local = <portlet:namespace /><%=Constantes.FILTRO_LOCAL%>.value;
			var mySelect = A.one('#<portlet:namespace /><%=Constantes.FILTRO_DATA%>');
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO%>.value = local;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_DATA_SELECIONADA%>.value = '';
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_HORA_SELECIONADA%>.value = '';
			atualizarDatas(local, '', mySelect);
			var mySelectHora = A.one('#<portlet:namespace /><%=Constantes.FILTRO_HORA%>');
			atualizarHoras('', 0, mySelectHora);
		}
	);

	function atualizarDatas(local, dataEvento, mySelect) {
 			A.io.request('<%=dataResourceURL%>',{
                        dataType: 'json',
                        method: 'GET',
                        data: { <portlet:namespace /><%=Constantes.FILTRO_LOCAL%> : local},
                        on: {
                              success: function() {
                              		var data=this.get('responseData');
                              		var options;
                              		mySelect.empty();
                              		options  = A.Node.create( '<option value=""></option>');
                              		mySelect.append(options);
                              		A.Array.each(data, function(obj, idx) {
                              			if (dataEvento == obj.dataEvento) {
	                              			options  = A.Node.create( '<option value='+obj.dataEvento+' selected>'+obj.dataEvento+'</option>');
                              			} else {
	                              			options  = A.Node.create( '<option value='+obj.dataEvento+'>'+obj.dataEvento+'</option>');
                              			}
	                              		mySelect.append(options);
                              		})
                              		
                              }
                        }
            });			
	}
	
	A.one('#<portlet:namespace /><%=Constantes.FILTRO_DATA%>').on(
		'change',
		function() {
			var data = <portlet:namespace /><%=Constantes.FILTRO_DATA%>.value;
			var mySelect = A.one('#<portlet:namespace /><%=Constantes.FILTRO_HORA%>');
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_DATA_SELECIONADA%>.value = data;
			atualizarHoras(data, '', mySelect);
		}
	);

	function atualizarHoras(data, hora, mySelect) {
 			A.io.request('<%=horaResourceURL%>',{
                        dataType: 'json',
                        method: 'GET',
                        data: { <portlet:namespace /><%=Constantes.FILTRO_DATA%> : data},
                        on: {
                              success: function() {
                              		var data=this.get('responseData');
                              		var options;
                              		mySelect.empty();
                              		options  = A.Node.create( '<option value=""></option>');
                              		mySelect.append(options);
                              		A.Array.each(data, function(obj, idx) {
                              			if (hora == obj.eventoAgendaId) {
	                              			options  = A.Node.create( '<option value='+obj.eventoAgendaId+' selected>'+obj.horaEvento+'</option>');
                              			} else {
	                              			options  = A.Node.create( '<option value='+obj.eventoAgendaId+'>'+obj.horaEvento+'</option>');
                              			}
	                              		mySelect.append(options);
                              		})
                              		
                              }
                        }
            });			
	}

	A.one('#<portlet:namespace /><%=Constantes.FILTRO_LOCAL%>').on(
		'change',
		function() {
			var local = <portlet:namespace /><%=Constantes.FILTRO_LOCAL%>.value;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_LOCAL_SELECIONADO%>.value = local;
		}
	);
	
	A.one('#<portlet:namespace /><%=Constantes.FILTRO_DATA%>').on(
		'change',
		function() {
			var data = <portlet:namespace /><%=Constantes.FILTRO_DATA%>.value;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_DATA_SELECIONADA%>.value = data;
		}
	);

	A.one('#<portlet:namespace /><%=Constantes.FILTRO_HORA%>').on(
		'change',
		function() {
			var hora = <portlet:namespace /><%=Constantes.FILTRO_HORA%>.value;
			document.<portlet:namespace />fm.<portlet:namespace /><%=Constantes.FILTRO_HORA_SELECIONADA%>.value = hora;
		}
	);

</aui:script>
<aui:script>
	function <portlet:namespace />executarPesquisa() {
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>