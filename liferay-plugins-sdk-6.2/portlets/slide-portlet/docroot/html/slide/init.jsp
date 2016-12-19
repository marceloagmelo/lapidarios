<%@include file="/html/init.jsp"%>

<%@ page import="br.com.prodevelopment.portlet.slide.Constantes"%>
<%@ page import="br.com.prodevelopment.portlet.slide.util.Search"%>
<%@ page import="br.com.prodevelopment.portlet.slide.util.JournalUtil"%>

<%
	Map<Long, String> listaEstrutura = (Map<Long, String>) request
			.getAttribute(Constantes.LISTA_ESTRUTURA);
	String articleId = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_ARTICLE_ID);
	if (Validator.isNull(articleId)) {
		articleId = (String)request.getAttribute(Constantes.NOME_PARAM_ARTICLE_ID);
	}
	
	String categoryId = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_CATEGORIA);
	String tag = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_TAG);
	String structureId = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_ESTRUTURA);
	String portletTitulo = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_TITULO_PORTLET);
	
	// Recuperar preferências do portlet caso não tenha encontrado no request
	if (Validator.isNull(categoryId)) {
		categoryId = preferences.getValue(Constantes.PREF_CATEGORIA,
				StringPool.BLANK);
	}
	long[] allCategoryIds = null;
	if (Validator.isNotNull(categoryId)) {
		String[] aCategorias = new String[] { categoryId };
		if (aCategorias.length > 0) {
			allCategoryIds = new long[aCategorias.length];
			int contador = 0;
			for (String valor : aCategorias) {
				allCategoryIds[contador] = Long.valueOf(valor);
				contador++;
			}
		}
	}
	
	if (Validator.isNull(structureId)) {
		structureId = preferences.getValue(Constantes.PREF_ESTRUTURA,
				StringPool.BLANK);
	}
	if (Validator.isNull(tag)) {
		tag = preferences.getValue(Constantes.PREF_TAG, StringPool.BLANK);
	}
	
	String prefEstrutura = preferences.getValue(Constantes.PREF_ESTRUTURA,
			StringPool.BLANK);
	
	String prefExibirTitulo = preferences.getValue(
			Constantes.PREF_EXIBIR_TITULO, Constantes.N);
	boolean showEditArticleIcon = true;
	boolean showAddArticleIcon = true;
	
	long[] classTypeIds = null;
	if (Validator.isNotNull(structureId)) {
		classTypeIds = new long[] { GetterUtil.getLong(21697), GetterUtil.getLong(21612) };
	}
	
	Map<String, PortletURL> addPortletURLs = null;
%>