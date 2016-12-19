package br.com.prodevelopment.lapidarios.portlet.lojaindicada.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.lapidarios.lojaindicada.LojaIndicadaIdLojaObrigatorioException;
import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.lojaindicada.service.LojaIndicadaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.LojaIndicadaConstants;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.util.Helper;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.util.LojaIndicadaUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LojaIndicadaPortlet
 */
public class LojaIndicadaPortlet extends MVCPortlet {
 
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest
					.setAttribute(LojaIndicadaConstants.PORTLET_TITLE, portletTitulo);

			LojaIndicadaUtil.getLojaIndicada(renderRequest);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long lojaIndicadaId = ParamUtil.getLong(actionRequest,
				LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String CAMPO_LOJA_INDICADA_ATUAL = ParamUtil.getString(actionRequest, LojaIndicadaConstants.ACTION);

		// Recuperar campos do request
		String idLoja = ParamUtil.getString(actionRequest,
				LojaIndicadaConstants.CAMPO_ID_LOJA);
		Boolean lojaIndicadaAtual = ParamUtil.getBoolean(actionRequest,
				LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ATUAL);

		try {
			if (LojaIndicadaConstants.ADD.equals(CAMPO_LOJA_INDICADA_ATUAL)) {
				LojaIndicada lojaIndicada = LojaIndicadaLocalServiceUtil
						.addLojaIndicada(themeDisplay.getCompanyId(),
								themeDisplay.getScopeGroupId(),
								themeDisplay.getUserId(), idLoja);

				SessionMessages.add(actionRequest,
						"mensagem.loja.adicionada.sucesso");
			} else {
				LojaIndicada lojaIndicada = LojaIndicadaLocalServiceUtil.update(lojaIndicadaId,
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), idLoja, lojaIndicadaAtual);
				SessionMessages.add(actionRequest,
						"mensagem.loja.alterada.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof LojaIndicadaIdLojaObrigatorioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						LojaIndicadaConstants.PATH_JSP_EDIT);
			}
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		LojaIndicada lojaIndicada = LojaIndicadaUtil.getLojaIndicada(actionRequest);
		if (Validator.isNotNull(lojaIndicada)) {
			LojaIndicadaLocalServiceUtil.deleteLojaIndicada(lojaIndicada.getLojaIndicadaId());
		}
	}

	public void deletarSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, LojaIndicadaConstants.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			LojaIndicada lojaIndicada = LojaIndicadaUtil.getLojaIndicada(Long
					.valueOf(deleteId));
			if (Validator.isNotNull(lojaIndicada)) {
				LojaIndicadaLocalServiceUtil.deleteLojaIndicada(lojaIndicada);
			}
		}
	}

	private void copyRequestParameters(ActionRequest request,
			ActionResponse actionResponse) {

		actionResponse.setRenderParameter("p_p_lifecycle", "1");

		Enumeration<String> enu = request.getParameterNames();

		Map<String, String[]> renderParameters = actionResponse
				.getRenderParameterMap();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();
			String[] values = request.getParameterValues(param);

			if (renderParameters.get(actionResponse.getNamespace() + param) == null
					&& (Validator.isNotNull(param) && Validator
							.isNotNull(values))) {
				actionResponse.setRenderParameter(param, values);
			}
		}
	}
}
