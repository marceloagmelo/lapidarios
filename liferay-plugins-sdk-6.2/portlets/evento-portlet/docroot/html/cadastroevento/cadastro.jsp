<%@ include file="init.jsp"%>

<%
Evento evento = (Evento)request.getAttribute(Constantes.EVENTO);
long eventoId = BeanParamUtil.getLong(evento, request, Constantes.CAMPO_EVENTO_ID);
String descricao = "";
if (eventoId > 0) {
	descricao = evento.getDescricao(locale);
}

String labelTitulo = "label.adicionar.evento";
if (Validator.isNotNull(evento)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(evento.getNome(locale));
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.evento.x", HtmlUtil.escape(evento.getNome(locale)));
	}
}

String usuarioResponsavelNome = ParamUtil.getString(request, Constantes.CAMPO_USUARIO_RESPONSAVEL_NOME);

User usuario = null;
long usuarioResponsavelId = BeanParamUtil.getLong(usuario, request, Constantes.CAMPO_USUARIO_RESPONSAVEL_ID);

if ( (Validator.isNotNull(evento)) && (evento.getUserResponsavelId() > 0) ) {
	usuario = UserLocalServiceUtil.fetchUser(evento.getUserResponsavelId());
	if (Validator.isNotNull(usuario)) {
		usuarioResponsavelId = usuario.getUserId();
		usuarioResponsavelNome = usuario.getFullName();
	}
}

%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (evento == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (eventoId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="eventoId" type="hidden" value="<%= eventoId %>" />
<%
request.setAttribute(Constantes.CAMPO_EVENTO_ID, eventoId);
%>
<aui:model-context bean="<%= evento %>" model="<%= Evento.class %>" />

<aui:input name="versao" type="hidden"/>

<liferay-ui:error exception="<%= EventoAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= EventoNomeObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=Constantes.CAMPO_NOME %>" label="label.nome" disabled="<%=Constantes.VIEW.equals(acao) %>">
			<aui:validator name="required" />
		</aui:input>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.descricao">
			<liferay-ui:input-localized
				name="<%=Constantes.CAMPO_DESCRICAO%>" type="textarea" xml="<%=descricao %>" disabled="<%=Constantes.VIEW.equals(acao) %>"/>
		</aui:field-wrapper>
		<aui:input name="<%=Constantes.CAMPO_ARTICLE_ID %>" label="label.conteudoweb" disabled="<%=Constantes.VIEW.equals(acao) %>">
			<<aui:validator name="digits"/>
		</aui:input>
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