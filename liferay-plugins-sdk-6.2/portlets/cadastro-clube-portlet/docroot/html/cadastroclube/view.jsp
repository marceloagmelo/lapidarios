<%@ include file="init.jsp"%>

<%@ include file="mensagens.jspf"%>
	
<%
	String link = "/cadastro-no-clube?lojaIndicadaId="+lojaId;
%>
<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=CadastroClubeConstants.PORTLET_ACTION %>" value="<%=CadastroClubeConstants.SALVAR %>" />
</portlet:actionURL>

   <aui:input name="<%=CadastroClubeConstants.CAMPO_ID_LOJA %>" type="hidden" value="<%= lojaId %>" />
   <aui:input name="<%=CadastroClubeConstants.CAMPO_LOJA_INDICADA_ID %>" type="hidden" value="<%= lojaIndicadaId %>" />
   <aui:input name="<%=CadastroClubeConstants.CAMPO_TIPO_PESSOA %>" type="hidden" value="PF" />

<div class="span12">
	<%=cadastroClubeConteudo %>

	<a href="<%=link %>" class="btn btn-danger bt-cadastrado">Já estou Cadastrado</a>

</div>