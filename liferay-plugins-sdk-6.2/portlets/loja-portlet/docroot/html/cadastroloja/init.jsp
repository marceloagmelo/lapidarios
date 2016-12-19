<%@ include file="/html/init.jsp" %>

<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.LojaUtil" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.TelefoneUtil" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.EnderecoEmailUtil" %>

<%@page import="br.com.prodevelopment.lapidarios.loja.model.Loja" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.model.Telefone" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail" %>

<%@page import="br.com.prodevelopment.lapidarios.loja.LojaRazaoSocialObrigatorioException" %>
<%@page import="br.com.prodevelopment.lapidarios.loja.LojaNomeFantasiaObrigatorioException" %>
<%@page import="br.com.prodevelopment.lapidarios.loja.LojaCNPJInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.loja.LojaCNPJDuplicadoException" %>
<%@page import="br.com.prodevelopment.lapidarios.loja.LojalteradaOutroUsuarioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneDDDObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneDDDInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneNumeroObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneNumeroInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoInvalidoException" %>


<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroloja.comparator.CadastroLojaComparator" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroloja.search.CadastroLojaSearch" %>
<%@page import="br.com.prodevelopment.lapidarios.portlet.cadastroloja.search.CadastroLojaDisplayTerms" %>
