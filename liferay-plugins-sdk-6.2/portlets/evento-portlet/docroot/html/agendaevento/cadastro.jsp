<%@ include file="init.jsp"%>

<%
String labelTitulo = "label.adicionar.agenda";
if (Validator.isNotNull(eventoAgenda)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(eventoAgenda.getEventoNome(locale));
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.agenda.x", HtmlUtil.escape(eventoAgenda.getEventoNome(locale)));
	}
}

Calendar calDataEvento = CalendarFactoryUtil.getCalendar();

if (eventoAgenda != null) {
	calDataEvento.setTime(eventoAgenda.getDataEvento());
}

%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (eventoAgenda == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (eventoAgendaId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="eventoAgendaId" type="hidden" value="<%= eventoAgendaId %>" />
<%
request.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID, eventoAgendaId);
%>
<aui:model-context bean="<%= eventoAgenda %>" model="<%= EventoAgenda.class %>" />

<aui:input name="versao" type="hidden"/>

<liferay-ui:error exception="<%= EventoAgendaAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= EventoDataObrigatoriaException.class %>" focusField="<%=Constantes.CAMPO_DATA_EVENTO %>" message="mensagem.dataEvento.obrigatoria" />
		<liferay-ui:error exception="<%= EventoDataInvalidaException.class %>" focusField="<%=Constantes.CAMPO_DATA_EVENTO %>" message="mensagem.dataEvento.invalida" />
		<aui:input cssClass="modify-link" name="<%=Constantes.CAMPO_DATA_EVENTO %>" value="<%= calDataEvento %>" label="label.dataEvento"/>
		<aui:field-wrapper label="label.horaEvento" >
			<aui:select name="<%=Constantes.CAMPO_HORA_EVENTO%>" label="">
				<%
				for (String hora : Helper.getHoras()) {
				%>
				<aui:option value="<%=hora %>"><%=hora %></aui:option>
				<%
					}
				%>
			</aui:select>
		</aui:field-wrapper>
		<liferay-ui:error exception="<%= EventoObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_DATA_EVENTO %>" message="mensagem.evento.obrigatorio" />
		<aui:field-wrapper helpMessage="help.evento" label="label.evento" >
			<aui:input name="<%=Constantes.CAMPO_EVENTO_ID %>" type="hidden" value="<%= eventoId %>" />
			<aui:input name="<%=Constantes.CAMPO_EVENTO_NOME %>" disabled="true" type="text" value="<%= eventoNome %>" label=""/>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectEventoLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>
				<aui:button disabled="<%= Validator.isNull(eventoNome) %>" name="removeEventoButton" onClick='<%= renderResponse.getNamespace() + "removeEvento();" %>' value="remove" />			

				<aui:script use="aui-base">
					A.one('#<portlet:namespace />selectEventoLink').on(
						'click',
						function(event) {
							Liferay.Util.selectEntity(
								{
									id: '<portlet:namespace />openEventoSelector',
									title: '<%= UnicodeLanguageUtil.get(pageContext, "label.eventos") %>',
									uri: '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/html/cadastroevento/selecione.jsp" /></liferay-portlet:renderURL>'
								},
								function(event) {
										document.<portlet:namespace />fm.<portlet:namespace />eventoId.value = event.eventoid;
										document.<portlet:namespace />fm.<portlet:namespace />eventoNome.value = event.nome;
										var A = new AUI();
										var button = A.one('#<portlet:namespace />removeEventoButton');
										Liferay.Util.toggleDisabled(button, false);
								}
							);
						}
					);
				
					Liferay.provide(
						window,
						'<portlet:namespace />removeEvento',
						function() {
							document.<portlet:namespace />fm.<portlet:namespace />eventoId.value = '0';
							document.<portlet:namespace />fm.<portlet:namespace />eventoNome.value = '';
							var A = new AUI();
							var button = A.one('#<portlet:namespace />removeEventoButton');
							Liferay.Util.toggleDisabled(button, true);
						}
					);
				</aui:script>
			</c:if>
		</aui:field-wrapper>
		<aui:field-wrapper helpMessage="help.responsvel" label="label.responsavel" >
			<aui:input name="<%=Constantes.CAMPO_USUARIO_RESPONSAVEL_ID %>" type="hidden" value="<%= usuarioResponsavelId %>" />
			<aui:input name="<%=Constantes.CAMPO_USUARIO_RESPONSAVEL_NOME %>" disabled="true" type="text" value="<%= usuarioResponsavelNome %>" label=""/>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectUsuarioLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>
				<aui:button disabled="<%= Validator.isNull(usuarioResponsavelNome) %>" name="removeUsuarioButton" onClick='<%= renderResponse.getNamespace() + "removeUsuario();" %>' value="remove" />

				<aui:script use="aui-base">
					A.one('#<portlet:namespace />selectUsuarioLink').on(
						'click',
						function(event) {
							Liferay.Util.selectEntity(
								{
									id: '<portlet:namespace />openUsuarioSelector',
									title: '<%= UnicodeLanguageUtil.get(pageContext, "label.usuarios") %>',
									uri: '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/html/usuario/selecione.jsp" /></liferay-portlet:renderURL>'
								},
								function(event) {
										document.<portlet:namespace />fm.<portlet:namespace />usuarioResponsavelId.value = event.userid;
										document.<portlet:namespace />fm.<portlet:namespace />usuarioResponsavelNome.value = event.nome;
										var A = new AUI();
										var button = A.one('#<portlet:namespace />removeUsuarioButton');
										Liferay.Util.toggleDisabled(button, false);
								}
							);
						}
					);

					Liferay.provide(
						window,
						'<portlet:namespace />removeUsuario',
						function() {
							document.<portlet:namespace />fm.<portlet:namespace />usuarioResponsavelId.value = '0';
							document.<portlet:namespace />fm.<portlet:namespace />usuarioResponsavelNome.value = '';
							var A = new AUI();
							var button = A.one('#<portlet:namespace />removeUsuarioButton');
							Liferay.Util.toggleDisabled(button, true);
						}
					);
				</aui:script>
			</c:if>
		</aui:field-wrapper>
		<liferay-ui:error exception="<%= EventoLocalObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_DATA_EVENTO %>" message="mensagem.eventoLocal.obrigatorio" />
		<aui:field-wrapper helpMessage="help.local" label="label.local" >
			<aui:input name="<%=Constantes.CAMPO_LOCAL_ID %>" type="hidden" value="<%= localId %>" />
			<aui:input name="<%=Constantes.CAMPO_LOCAL_NOME %>" disabled="true" type="text" value="<%= localNome %>" label=""/>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectLocalLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>
				<aui:button disabled="<%= Validator.isNull(localNome) %>" name="removeLocalButton" onClick='<%= renderResponse.getNamespace() + "removeLocal();" %>' value="remove" />			

				<aui:script use="aui-base">
					A.one('#<portlet:namespace />selectLocalLink').on(
						'click',
						function(event) {
							Liferay.Util.selectEntity(
								{
									id: '<portlet:namespace />openLocalSelector',
									title: '<%= UnicodeLanguageUtil.get(pageContext, "label.locais") %>',
									uri: '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/html/local/selecione.jsp" /></liferay-portlet:renderURL>'
								},
								function(event) {
										document.<portlet:namespace />fm.<portlet:namespace />localId.value = event.localid;
										document.<portlet:namespace />fm.<portlet:namespace />localNome.value = event.nome;
										var A = new AUI();
										var button = A.one('#<portlet:namespace />removeLocalButton');
										Liferay.Util.toggleDisabled(button, false);
								}
							);
						}
					);
				
					Liferay.provide(
						window,
						'<portlet:namespace />removeLocal',
						function() {
							document.<portlet:namespace />fm.<portlet:namespace />localId.value = '0';
							document.<portlet:namespace />fm.<portlet:namespace />localNome.value = '';
							var A = new AUI();
							var button = A.one('#<portlet:namespace />removeLocalButton');
							Liferay.Util.toggleDisabled(button, true);
						}
					);
				</aui:script>
			</c:if>
		</aui:field-wrapper>
	</aui:fieldset>
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= EventoQtdeVagasObrigatoriaException.class %>" focusField="<%=Constantes.CAMPO_QTDE_VAGAS %>" message="mensagem.qtdeVagas.obrigatorio" />
		<aui:input name="<%=Constantes.CAMPO_QTDE_VAGAS %>" label="label.qtde.vagas" max="6">
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">6</aui:validator>
			<aui:validator name="number"></aui:validator>
		</aui:input>
		<aui:input name="<%=Constantes.CAMPO_VALOR %>" label="label.valor">
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
			<aui:validator name="number"></aui:validator>
		</aui:input>
		<aui:input label="label.gratuito" name="<%=Constantes.CAMPO_GRATUITO %>" type="checkbox" value="<%=gratuito %>"/>
		<c:if test="<%=(eventoAgendaId == 0) %>">
			<aui:input label="label.repetir" name="<%=Constantes.CAMPO_REPETIR %>" type="checkbox" value="<%=repetir %>"/>
			<input name="<portlet:namespace /><%=Constantes.CAMPO_QTDE_REPETICAO %>" id="<portlet:namespace /><%=Constantes.CAMPO_QTDE_REPETICAO %>" value="<%=qtdeRepeticao%>"/> Dias
		</c:if>		
	</aui:fieldset>
	<c:if test="<%=(!Constantes.VIEW.equals(acao)) %>">
		<aui:button-row>
			<aui:button type="submit" />
			<portlet:renderURL var="cancelarURL"/>
	
			<aui:button href="<%= cancelarURL %>" value="botao.cancelar"/>
		</aui:button-row>
	</c:if>
</div>
</aui:form>