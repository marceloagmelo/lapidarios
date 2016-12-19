package br.com.prodevelopment.portlet.slide.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.portlet.slide.Constantes;
import br.com.prodevelopment.portlet.slide.util.JournalUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		PortletPreferences prefs = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		String prefExibirTitulo = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO);
		String prefCategoria = ParamUtil.getString(actionRequest,
				Constantes.CATEGORIAS_IDS);
		String prefTag = ParamUtil.getString(actionRequest,
				Constantes.TAG_NAMES);
		String prefEstrutura = ParamUtil.getString(actionRequest,
				Constantes.PREF_ESTRUTURA);

		prefs.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		prefs.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
		prefs.setValue(Constantes.PREF_TAG, prefTag);
		prefs.setValue(Constantes.PREF_ESTRUTURA, prefEstrutura);
		prefs.setValue(Constantes.PREF_CATEGORIA, prefCategoria);

		if (SessionErrors.isEmpty(actionRequest)) {
			try {
				prefs.store();
				SessionMessages.add(actionRequest,
						Constantes.PORTLET_CONFIGURADO_SUCESSO);
			} catch (ValidatorException ve) {
				SessionErrors.add(actionRequest,
						ValidatorException.class.getName(), ve);

				return;
			}

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		String prefExibirTitulo = portletPreferences.getValue(
				Constantes.PREF_EXIBIR_TITULO, Constantes.N);
		String prefTag = portletPreferences.getValue(Constantes.PREF_TAG,
				Constantes.VAZIO);
		String prefCategoria = portletPreferences.getValue(
				Constantes.PREF_CATEGORIA, Constantes.VAZIO);
		String prefEstrutura = portletPreferences.getValue(
				Constantes.PREF_ESTRUTURA, Constantes.VAZIO);

		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);
		renderRequest.setAttribute(Constantes.PREF_TAG, prefTag);
		renderRequest.setAttribute(Constantes.PREF_ESTRUTURA, prefEstrutura);
		renderRequest.setAttribute(Constantes.PREF_CATEGORIA, prefCategoria);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Map<Long, String> listaEstrutura = JournalUtil
				.getEstruturas(themeDisplay);
		if ((Validator.isNotNull(listaEstrutura))
				&& (listaEstrutura.size() > 0)) {
			renderRequest.setAttribute(Constantes.LISTA_ESTRUTURA,
					listaEstrutura);
		}

		return Constantes.JSP_CONFIG;
	}
}
