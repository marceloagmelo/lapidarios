package br.com.prodevelopment.lapidarios.portlet.cadastroevento.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.lapidarios.evento.EventoAlteradoOutroUsuarioException;
import br.com.prodevelopment.lapidarios.evento.EventoNomeObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.model.Evento;
import br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.util.Helper;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.Constantes;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.util.EventoUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CadastroEventoPortlet
 */
public class CadastroEventoPortlet extends MVCPortlet {
 
	@Override
	public void init() throws PortletException {
		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest
					.setAttribute(Constantes.PORTLET_TITULO, portletTitulo);

			EventoUtil.getEvento(renderRequest);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long eventoId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

		// Recuperar campos do request
		Map<Locale, String> nomeMap = LocalizationUtil.getLocalizationMap(
				actionRequest, Constantes.CAMPO_NOME);
		Map<Locale, String> descricaoMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						Constantes.CAMPO_DESCRICAO);
		long userResposavelId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_USUARIO_RESPONSAVEL_ID);
		long imagemId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_IMAGEM_ID);
		long articleId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_ARTICLE_ID);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);

		try {
			if (Constantes.ADD.equals(acao)) {
				Evento evento = EventoLocalServiceUtil
						.addEvento(themeDisplay.getCompanyId(),
								themeDisplay.getScopeGroupId(),
								themeDisplay.getUserId(), nomeMap, descricaoMap, 
								userResposavelId, imagemId, articleId);

				SessionMessages.add(actionRequest,
						"mensagem.evento.adicionado.sucesso");
			} else {
				Evento evento = EventoLocalServiceUtil.update(eventoId,
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nomeMap, descricaoMap, 
						userResposavelId, imagemId, articleId);
				SessionMessages.add(actionRequest,
						"mensagem.evento.alterado.sucesso");
			}
			if (Constantes.REDIRECT_SELECIONE_EVENTO.equals(redirect)) {
				actionResponse.setRenderParameter("jspPage", "/html/cadastroevento/selecione.jsp");
			} else {
				sendRedirect(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			if (e instanceof EventoNomeObrigatorioException
					|| e instanceof EventoAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/eventocadastro/cadastro.jsp");
			}
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);

		Evento evento = EventoUtil.getEvento(actionRequest);
		if (Validator.isNotNull(evento)) {
			EventoLocalServiceUtil.deleteEvento(evento,
					themeDisplay.getUserId());
		}
		if (Constantes.REDIRECT_SELECIONE_EVENTO.equals(redirect)) {
			actionResponse.setRenderParameter("jspPage", "/html/cadastroevento/selecione.jsp");
		}
	}

	public void deletarSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, Constantes.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			Evento evento = EventoUtil.getEvento(Long
					.valueOf(deleteId));
			if (Validator.isNotNull(evento)) {
				EventoLocalServiceUtil.deleteEvento(evento,
						themeDisplay.getUserId());
			}
		}
		if (Constantes.REDIRECT_SELECIONE_EVENTO.equals(redirect)) {
			actionResponse.setRenderParameter("jspPage", "/html/cadastroevento/selecione.jsp");
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