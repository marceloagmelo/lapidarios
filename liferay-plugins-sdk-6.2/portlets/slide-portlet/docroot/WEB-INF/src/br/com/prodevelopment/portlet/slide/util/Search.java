package br.com.prodevelopment.portlet.slide.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class Search {

	public static List<JournalArticle> buscarConteudos(String keywords,
			long companyId, long groupId, long structureId, int inicio,
			int fim, String categorias, String tags)
			throws SystemException, PortalException {
		List<JournalArticle> listaConteudos = new ArrayList<JournalArticle>();

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(companyId);
		searchContext.setEnd(fim);
		searchContext.setEntryClassNames(new String[] { JournalArticle.class
				.getName() });
		searchContext.setGroupIds(new long[] { groupId });
		searchContext.setLike(true);

		if (structureId > 0) {
			searchContext.setClassTypeIds(new long[] { 21697,21612 });
		}

		Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class
				.getName());

		searchContext.setSearchEngineId(indexer.getSearchEngineId());

		searchContext.setStart(inicio);

		// Cria o criterio de ordenação
		Sort sort = new Sort(Field.CREATE_DATE, false);
		searchContext.setSorts(sort);

		if (Validator.isNotNull(categorias)) {
			String[] aCategorias = new String[] { categorias };
			if (aCategorias.length > 0) {
				long[] allCategoryIds = new long[aCategorias.length];
				int contador = 0;
				for (String valor : aCategorias) {
					allCategoryIds[contador] = Long.valueOf(valor);
					contador++;
				}
				searchContext.setAssetCategoryIds(allCategoryIds);
			}
		}

		if (Validator.isNotNull(tags)) {
			searchContext.setAssetTagNames(new String[] { tags });
		}

		searchContext.setAndSearch(false);

		Map<String, Serializable> attributes = new HashMap<String, Serializable>();

		if (Validator.isNotNull(keywords)) {
			searchContext.setKeywords(keywords);
			attributes.put(Field.CONTENT, keywords);
			attributes.put(Field.DESCRIPTION, keywords);
			attributes.put(Field.TITLE, keywords);
		}

		searchContext.setAttributes(attributes);

		// Executa a busca return
		Hits hits = indexer.search(searchContext);

		if (hits.getLength() > 0) {
			for (int i = 0; hits != null && hits.getDocs() != null
					&& i < hits.getDocs().length; i++) {
				Document doc = hits.getDocs()[i];
				String articleId = doc.get("articleId");

				JournalArticle article = JournalArticleLocalServiceUtil
						.getLatestArticle(groupId, articleId,
								WorkflowConstants.STATUS_APPROVED);

				listaConteudos.add(article);
			}
		}
		return listaConteudos;
	}

	public static int getTotalConteudo(String keywords, long companyId,
			long groupId, long structureId, String categorias, String tags)
			throws SystemException, PortalException {
		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(companyId);
		searchContext.setEntryClassNames(new String[] { JournalArticle.class
				.getName() });
		searchContext.setGroupIds(new long[] { groupId });
		searchContext.setLike(true);

		if (structureId > 0) {
			searchContext.setClassTypeIds(new long[] { 21697,21612 });
		}

		Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class
				.getName());

		searchContext.setSearchEngineId(indexer.getSearchEngineId());

		if (Validator.isNotNull(categorias)) {
			String[] aCategorias = new String[] { categorias };
			if (aCategorias.length > 0) {
				long[] allCategoryIds = new long[aCategorias.length];
				int contador = 0;
				for (String valor : aCategorias) {
					allCategoryIds[contador] = Long.valueOf(valor);
					contador++;
				}
				searchContext.setAssetCategoryIds(allCategoryIds);
			}
		}
		if (Validator.isNotNull(tags)) {
			searchContext.setAssetTagNames(new String[] { tags });
		}

		searchContext.setAndSearch(false);

		Map<String, Serializable> attributes = new HashMap<String, Serializable>();

		if (Validator.isNotNull(keywords)) {
			searchContext.setKeywords(keywords);
			attributes.put(Field.CONTENT, keywords);
			attributes.put(Field.DESCRIPTION, keywords);
			attributes.put(Field.TITLE, keywords);
		}

		searchContext.setAttributes(attributes);

		// Executa a busca return
		Hits hits = indexer.search(searchContext);

		return hits.getLength();
	}
}
