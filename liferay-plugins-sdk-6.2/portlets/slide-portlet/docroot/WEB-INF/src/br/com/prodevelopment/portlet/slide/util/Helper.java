package br.com.prodevelopment.portlet.slide.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class Helper {

	public static final String _ASSET_IDS = "assetCategoryIds";
	
	public static String getTituloPortlet(RenderRequest renderRequest,
			RenderResponse renderResponse, ThemeDisplay themeDisplay)
			throws SystemException {
		String portletTitulo = "";

		Portlet portlet = (Portlet) renderRequest
				.getAttribute(WebKeys.RENDER_PORTLET);

		String portletId = portlet.getPortletId();

		PortletPreferences portletSetup = PortletPreferencesFactoryUtil
				.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);

		String defaultLanguageId = LocaleUtil.toLanguageId(PortalUtil
				.getLocale(renderRequest));

		portletTitulo = GetterUtil.getString(portletSetup.getValue(
				"portletSetupTitle_" + defaultLanguageId, StringPool.BLANK));

		if (Validator.isNull(portletTitulo)) {
			ResourceBundle resource = ResourceBundle.getBundle(
					portlet.getResourceBundle(), LocaleUtil.getDefault());
			portletTitulo = resource.getString("javax.portlet.title");
		}

		return portletTitulo;
	}

    public static String zerosEsquerda(String valor, int tamanho) {
        
        valor = (valor==null? "0" : valor );
        if (valor.length() < tamanho)
        {
            for (int i=valor.length(); i<tamanho; i++)
            {
            	valor = "0" + valor;
            }
        }
        else {
            valor = valor.substring(0, tamanho);
        }

        return valor;
    }
	public static String trataTextoLongo(String texto, int tamanho) {
		if (texto == null)
			texto = "";
		if (texto.length() > tamanho) {
			texto = texto.substring(0, tamanho);
			texto = texto + "...";
		}
		return texto;
	}
	
	public static Map<String, String> getParametroCategoria(
			LiferayPortletRequest liferayPortletRequest, String[] categorias)
			throws Exception {
		Map<String, String> retorno = null;

		Map<Long, String> assetVocabularyAssetCategoryIds = new HashMap<Long, String>();

		for (String assetCategoryId : categorias) {
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil
					.getAssetCategory(GetterUtil.getLong(assetCategoryId));

			long assetVocabularyId = assetCategory.getVocabularyId();

			if (assetVocabularyAssetCategoryIds.containsKey(assetVocabularyId)) {
				String assetCategoryIds = assetVocabularyAssetCategoryIds
						.get(assetVocabularyId);

				assetVocabularyAssetCategoryIds.put(assetVocabularyId,
						assetCategoryIds + StringPool.COMMA + assetCategoryId);
			} else {
				assetVocabularyAssetCategoryIds.put(assetVocabularyId,
						String.valueOf(assetCategoryId));
			}
		}

		retorno = new HashMap<String, String>(
				assetVocabularyAssetCategoryIds.size());

		for (Map.Entry<Long, String> entry : assetVocabularyAssetCategoryIds
				.entrySet()) {
			long assetVocabularyId = entry.getKey();
			String assetCategoryIds = entry.getValue();

			retorno.put(_ASSET_IDS + StringPool.UNDERLINE + assetVocabularyId,
					assetCategoryIds);
		}

		return retorno;
	}
	

	public static Map<String, String> getEstruturas(
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, String estrutura)
			throws Exception {
		Map<String, String> retorno = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String className = JournalArticle.class.getName();
		AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil
				.getAssetRendererFactoryByClassName(className);

		Map<Long, String> classTypes = assetRendererFactory.getClassTypes(
				new long[] { themeDisplay.getCompanyGroupId(),
						themeDisplay.getScopeGroupId() },
				themeDisplay.getLocale());

		if (Validator.isNotNull(classTypes)) {
			retorno = new LinkedHashMap<String, String>(
					classTypes.size()+1);
			if (Validator.isNull(estrutura)) {
				retorno.put(StringPool.BLANK, "add-web-content");
			}
			if (classTypes != null) {
				for (long classTypeId : classTypes.keySet()) {
					DDMStructure structure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getScopeGroupId(), classTypeId, null);

					if (Validator.isNull(estrutura)) {
						retorno.put(String.valueOf(structure.getStructureId()), classTypes.get(classTypeId));
					} else if (estrutura.equals(structure.getStructureId())) {
						retorno.put(String.valueOf(structure.getStructureId()), classTypes.get(classTypeId));
						break;
					}
				}
			}
		}
		
		return retorno;
	}
	
}
