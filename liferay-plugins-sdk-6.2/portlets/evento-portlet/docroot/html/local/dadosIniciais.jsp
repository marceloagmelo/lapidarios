<%@ include file="init.jsp"%>

<%
Local local = null;//(Local)request.getAttribute(Constantes.LOCAL);
long localId = BeanParamUtil.getLong(local, request, Constantes.LOCAL_ID);

String pontoReferencia = "";
if (localId > 0) {
	local = LocalUtil.getLocal(localId);
	pontoReferencia = local.getPontoReferencia(locale);
}
%>
<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR_LOCAL %>" />
</portlet:actionURL>

<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (localId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="localId" type="hidden" value="<%= localId %>" />
	<aui:input name="<%=Constantes.REDIRECT %>" type="hidden" value="<%= redirect %>" />
	
<%
request.setAttribute(Constantes.LOCAL_ID, localId);
%>

<aui:model-context bean="<%= local %>" model="<%= Local.class %>" />

<aui:input name="versao" type="hidden"/>

<liferay-ui:error exception="<%= LocalAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= LocalNomeObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=Constantes.CAMPO_NOME %>" label="label.nome">
			<aui:validator name="required" />
		</aui:input>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pontoReferencia">
			<liferay-ui:input-localized
				name="<%=Constantes.CAMPO_PONTO_REFERENCIA%>" type="textarea" xml="<%=pontoReferencia %>"/>
		</aui:field-wrapper>
	</aui:fieldset>
</div>
</aui:form>

<aui:script use="aui-base">
	var verSeDesabilitaCamposLocal = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_NOME %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_PONTO_REFERENCIA %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposLocal(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>
