<%@ include file="/html/init.jsp" %>

<%@page
	import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>

<%@page
	import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page
	import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroclube.CadastroClubeConstants" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroclube.util.LojaIndicadaUtil" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroclube.util.AssociadoUtil" %>

<%@page import="br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada" %>

<%@page import="br.com.prodevelopment.associado.AssociadoNomeObrigatorioException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCPFInvalidoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCPFDuplicadoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCNPJInvalidoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCNPJDuplicadoException" %>

<%@page import="br.com.prodevelopment.associado.model.Associado" %>

<%
	long lojaIndicadaId = 0;
	String lojaId = "";
	LojaIndicada lojaIndicada = LojaIndicadaUtil.getLojaIndicada(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	if (Validator.isNotNull(lojaIndicada)) {
		lojaId = lojaIndicada.getIdLoja();
		lojaIndicadaId = lojaIndicada.getLojaIndicadaId();
	}
	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(themeDisplay.getScopeGroupId(), String.valueOf(21572), "","",themeDisplay);
	String cadastroClubeConteudo = articleDisplay.getContent();
	cadastroClubeConteudo = cadastroClubeConteudo.replaceAll("##ID_LOJA_INDICADA##", lojaId);

	String sCpfCnpj = ParamUtil.getString(request, CadastroClubeConstants.CAMPO_CPF_CNPJ);
	String tipoPessoa = ParamUtil.getString(request, CadastroClubeConstants.CAMPO_TIPO_PESSOA);
%>