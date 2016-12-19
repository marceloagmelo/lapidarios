<%@ include file="/html/init.jsp" %>


<%@page import="br.com.prodevelopment.portlet.associado.util.AssociadoUtil" %>
<%@page import="br.com.prodevelopment.portlet.associado.util.TelefoneUtil" %>
<%@page import="br.com.prodevelopment.portlet.associado.util.EnderecoEmailUtil" %>
<%@page import="br.com.prodevelopment.portlet.associado.util.EnderecoUtil" %>

<%@page import="br.com.prodevelopment.associado.model.Associado" %>
<%@page import="br.com.prodevelopment.associado.model.impl.AssociadoImpl" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.model.Telefone" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.model.Endereco" %>

<%@page import="br.com.prodevelopment.associado.AssociadoNomeObrigatorioException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoDataNascimentoInvalidaException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoRGDataEmissaoInvalidaException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCPFInvalidoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCPFDuplicadoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCNPJInvalidoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoCNPJDuplicadoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoRGInscricaoMunDuplicadoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoUsuarioDuplicadoException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoAlteradoOutroUsuarioException" %>
<%@page import="br.com.prodevelopment.associado.AssociadoIDPolishopDuplicadoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneDDDObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneDDDInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneNumeroObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.TelefoneNumeroInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoInvalidoException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.lapidarios.contato.EnderecoLogradouroObrigatotioException" %>

<%@page import="br.com.prodevelopment.portlet.associado.comparator.AssociadosComparator" %>
<%@page import="br.com.prodevelopment.portlet.associado.search.AssociadoSearch" %>
<%@page import="br.com.prodevelopment.portlet.associado.search.AssociadoDisplayTerms" %>
