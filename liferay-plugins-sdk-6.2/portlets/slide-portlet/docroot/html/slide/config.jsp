<%@include file="init.jsp"%>

<%@ include file="/html/common/mensagem.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<aui:fieldset>
		<aui:select name="<%=Constantes.PREF_EXIBIR_TITULO%>" label="label.pref.exibirTitulo">
			<aui:option label="label.sim" selected="<%=Constantes.S.equals(prefExibirTitulo) %>" value="<%=Constantes.S%>"/>
			<aui:option label="label.nao" selected="<%=Constantes.N.equals(prefExibirTitulo) %>" value="<%=Constantes.N%>"/>
		</aui:select>
		<%
			if (listaEstrutura != null) {
		%>
		<aui:select label="label.pref.estrutura" name="<%=Constantes.PREF_ESTRUTURA%>">
			<aui:option label="label.selecione"	selected="selected" value="" />
<%
				for (Iterator it = listaEstrutura.keySet().iterator(); it.hasNext();) {
					Long idEstrutura = (Long) it.next();
					String nome = listaEstrutura.get(idEstrutura);
%>
					<aui:option label="<%=nome%>" selected="<%=prefEstrutura.equals(String.valueOf(idEstrutura)) %>" value="<%=String.valueOf(idEstrutura)%>" />
<%
				}
%>							
		</aui:select>
		<%
			}
		%>
		<liferay-ui:message key="label.pref.categoria" /> 
		<liferay-ui:asset-categories-selector
					curCategoryIds="${prefCategoria}" />
		<liferay-ui:message key="label.pref.tag" /> 
		<liferay-ui:asset-tags-selector curTags="${prefTag}" />

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</aui:fieldset>
</aui:form>