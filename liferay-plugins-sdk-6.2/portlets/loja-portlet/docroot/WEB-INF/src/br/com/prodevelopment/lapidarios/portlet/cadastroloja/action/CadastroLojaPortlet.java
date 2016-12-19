package br.com.prodevelopment.lapidarios.portlet.cadastroloja.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail;
import br.com.prodevelopment.lapidarios.contato.model.Telefone;
import br.com.prodevelopment.lapidarios.loja.LojaCNPJDuplicadoException;
import br.com.prodevelopment.lapidarios.loja.LojaCNPJInvalidoException;
import br.com.prodevelopment.lapidarios.loja.LojaNomeFantasiaObrigatorioException;
import br.com.prodevelopment.lapidarios.loja.LojaRazaoSocialObrigatorioException;
import br.com.prodevelopment.lapidarios.loja.LojalteradaOutroUsuarioException;
import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.loja.util.Helper;
import br.com.prodevelopment.lapidarios.municipio.model.Municipio;
import br.com.prodevelopment.lapidarios.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.EnderecoEmailUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.LojaUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.MunicipioUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.util.TelefoneUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CadastroLojaPortlet
 */
public class CadastroLojaPortlet extends MVCPortlet {

	private static Logger _log = Logger.getLogger(CadastroLojaPortlet.class);

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
			if (_log.isDebugEnabled()) {
				_log.debug("LOG com debug");
			}

			String moveTrashAction = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.MOVE_TRASH_ACTION);
			String restoreAction = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.RESTORE_ACTION);
			String deleteAction = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.DELETE_ACTION);
			String name = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.LOJA_NOME_FANTASIA);
			String restoreLojaIds = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.RESTORE_LOJA_IDS);
			String deleteLojaNames = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.DELETE_LOJA_NOMES_FANTASIA);
			String restoreLojaNames = ParamUtil.getString(renderRequest,
					CadastroLojaConstants.RESTORE_LOJA_NOMES_FANTASIA);

			renderRequest.setAttribute(CadastroLojaConstants.MOVE_TRASH_ACTION,
					moveTrashAction);
			renderRequest.setAttribute(CadastroLojaConstants.RESTORE_ACTION,
					restoreAction);
			renderRequest.setAttribute(CadastroLojaConstants.DELETE_ACTION,
					deleteAction);
			renderRequest.setAttribute(
					CadastroLojaConstants.LOJA_NOME_FANTASIA, name);
			renderRequest.setAttribute(CadastroLojaConstants.RESTORE_LOJA_IDS,
					restoreLojaIds);
			renderRequest.setAttribute(
					CadastroLojaConstants.DELETE_LOJA_NOMES_FANTASIA,
					deleteLojaNames);
			renderRequest.setAttribute(
					CadastroLojaConstants.RESTORE_LOJA_NOMES_FANTASIA,
					restoreLojaNames);

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest.setAttribute(CadastroLojaConstants.PORTLET_TITLE,
					portletTitulo);

			LojaUtil.getLoja(renderRequest);

			super.render(renderRequest, renderResponse);

		} catch (Exception e) {
			_log.error(e, e);
		}
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		String metodo = ParamUtil.getString(request,
				CadastroLojaConstants.METODO);
		String uf = ParamUtil.getString(request, "uf");
		String cep = ParamUtil.getString(request, "cep");
		String lojaId = ParamUtil.getString(request,
				CadastroLojaConstants.LOJA_ID);
		request.setAttribute(CadastroLojaConstants.LOJA_ID, lojaId);

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(CadastroLojaConstants.LISTAR_MUNICIPIOS)) {
				List<Municipio> lista = MunicipioUtil.listarMunicipios(uf);
				resultJsonArray = MunicipioUtil.carregarMunicipios(lista);
			} else if (metodo.equals(CadastroLojaConstants.DADOS_CEP)) {
				List<Municipio> lista = null;
				Municipio municipio = MunicipioLocalServiceUtil
						.getDadosCep(cep);
				if (Validator.isNotNull(municipio)) {
					lista = new ArrayList<Municipio>(1);
					lista.add(municipio);
					resultJsonArray = MunicipioUtil.carregarDadosCep(lista);
				}
			}

			writeJSON(request, response, resultJsonArray);

		} catch (IOException e) {
			_log.error(e, e);
		} catch (SystemException e) {
			_log.error(e, e);
		} catch (Exception e) {
			_log.error(e, e);
		}

	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		String lojaId = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.LOJA_ID);
		String keywords = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.KEYWORDS);
		String availableFields = ParamUtil.getString(actionRequest,
				"availableFields");
		String action = CadastroLojaConstants.VIEW;

		try {
			if (Constants.ADD.equals(cmd) || Constants.UPDATE.equals(cmd)) {
				Loja loja = updateLoja(actionRequest);
				lojaId = String.valueOf(loja.getLojaId());

				actionResponse.setRenderParameter(
						CadastroLojaConstants.JSP_PAGE,
						CadastroLojaConstants.PATH_JSP_EDIT);
				if (Constants.ADD.equals(cmd)) {
					SessionMessages.add(actionRequest,
							"mensagem.loja.adicionada.sucesso");
				} else {
					SessionMessages.add(actionRequest,
							"mensagem.loja.alterada.sucesso");
				}
				actionResponse.setRenderParameter(
						CadastroLojaConstants.JSP_PAGE,
						CadastroLojaConstants.PATH_JSP_VIEW);
			} else if (Constants.DELETE.equals(cmd)
					|| Constants.MOVE_TO_TRASH.equals(cmd)) {
				deleteLojas(actionRequest, actionResponse, cmd);
			} else if (cmd.equals(Constants.RESTORE)) {
				restoreLojas(actionRequest, actionResponse, cmd);
			}
		} catch (Exception e) {
			if (e instanceof LojaRazaoSocialObrigatorioException
					|| e instanceof LojaNomeFantasiaObrigatorioException
					|| e instanceof LojaCNPJInvalidoException
					|| e instanceof LojaCNPJDuplicadoException
					|| e instanceof LojalteradaOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass(), e);

				if (Constants.ADD.equals(cmd) || Constants.UPDATE.equals(cmd)) {
					actionResponse.setRenderParameter(
							CadastroLojaConstants.JSP_PAGE,
							CadastroLojaConstants.PATH_JSP_EDIT);
				}
				action = CadastroLojaConstants.EDIT;
				//sendRedirect(actionRequest, actionResponse);
				copyRequestParameters(actionRequest, actionResponse);
			} else {
				_log.error(e, e);
			}
		}
		actionResponse.setRenderParameter(CadastroLojaConstants.REDIRECT,
				getRedirect(actionRequest, actionResponse));
		actionResponse.setRenderParameter(Constants.CMD, cmd);
		actionResponse.setRenderParameter(CadastroLojaConstants.COMPANY_ID,
				String.valueOf(themeDisplay.getCompanyId()));
		actionResponse.setRenderParameter(CadastroLojaConstants.GROUP_ID,
				String.valueOf(themeDisplay.getScopeGroupId()));
		actionResponse.setRenderParameter("availableFields", availableFields);
		actionResponse
				.setRenderParameter(CadastroLojaConstants.LOJA_ID, lojaId);
		actionResponse.setRenderParameter(CadastroLojaConstants.KEYWORDS,
				keywords);
		actionResponse.setRenderParameter(Constants.ACTION, action);
	}

	protected void deleteLojas(ActionRequest actionRequest,
			ActionResponse actionResponse, String comand) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String moveTrashAction = StringPool.BLANK;
		String deleteAction = StringPool.BLANK;
		String sDeleteLojaIds = StringPool.BLANK;
		String sDeleteLojaNames = StringPool.BLANK;

		long[] restoreLojaIds = null;

		long lojaId = ParamUtil.getLong(actionRequest,
				CadastroLojaConstants.LOJA_ID);

		if (lojaId > 0) {
			restoreLojaIds = new long[] { lojaId };
		} else {
			restoreLojaIds = StringUtil.split(ParamUtil.getString(
					actionRequest, CadastroLojaConstants.DELETE_TAG_IDS), 0L);
		}

		for (long deleteLojaId : restoreLojaIds) {
			Loja loja = LojaLocalServiceUtil.getLoja(deleteLojaId);
			if (Constants.DELETE.equals(comand)) {
				LojaLocalServiceUtil.deleteLoja(deleteLojaId);
				deleteAction = CadastroLojaConstants.UM;
			} else if (Constants.MOVE_TO_TRASH.equals(comand)) {
				LojaLocalServiceUtil.moveLojaToTrash(
						themeDisplay.getRealUserId(), deleteLojaId);
				moveTrashAction = CadastroLojaConstants.UM;
			}
			if (sDeleteLojaIds.length() > 0) {
				sDeleteLojaIds = sDeleteLojaIds + StringPool.SEMICOLON;
			}
			sDeleteLojaIds = sDeleteLojaIds + String.valueOf(deleteLojaId);
			if (sDeleteLojaNames.length() > 0) {
				sDeleteLojaNames = sDeleteLojaNames + StringPool.SEMICOLON;
			}
			sDeleteLojaNames = sDeleteLojaNames + loja.getNomeFantasia();
		}

		if (Validator.isNotNull(sDeleteLojaNames)) {
			actionResponse.setRenderParameter(
					CadastroLojaConstants.MOVE_TRASH_ACTION, moveTrashAction);
			actionResponse.setRenderParameter(
					CadastroLojaConstants.DELETE_ACTION, deleteAction);
		}
		actionResponse.setRenderParameter(
				CadastroLojaConstants.RESTORE_LOJA_IDS, sDeleteLojaIds);
		actionResponse.setRenderParameter(
				CadastroLojaConstants.DELETE_LOJA_NOMES_FANTASIA,
				sDeleteLojaNames);
	}

	protected void restoreLojas(ActionRequest actionRequest,
			ActionResponse actionResponse, String comand) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String restoreAction = StringPool.BLANK;
		String sRestoreLojaNomesFantasia = StringPool.BLANK;

		String restoreLojasIds = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.RESTORE_LOJA_IDS);

		if (Validator.isNotNull(restoreLojasIds)) {
			for (String retval : restoreLojasIds.split(";")) {
				Loja loja = LojaLocalServiceUtil.getLoja(Long.valueOf(retval));
				if (Validator.isNotNull(loja)) {
					LojaLocalServiceUtil.restoreLojaFromTrash(
							themeDisplay.getUserId(), loja.getLojaId());
					restoreAction = CadastroLojaConstants.UM;

					if (sRestoreLojaNomesFantasia.length() > 0) {
						sRestoreLojaNomesFantasia = sRestoreLojaNomesFantasia
								+ StringPool.SEMICOLON;
					}
					sRestoreLojaNomesFantasia = sRestoreLojaNomesFantasia
							+ loja.getNomeFantasia();
				}
			}
		}
		actionResponse.setRenderParameter(CadastroLojaConstants.RESTORE_ACTION,
				restoreAction);
		actionResponse.setRenderParameter(
				CadastroLojaConstants.RESTORE_LOJA_NOMES_FANTASIA,
				sRestoreLojaNomesFantasia);

	}

	protected Loja updateLoja(ActionRequest actionRequest) throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		long lojaId = ParamUtil.getLong(actionRequest,
				CadastroLojaConstants.CAMPO_LOJA_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar campos do request
		String razaoSocial = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_RAZAO_SOCIAL);
		String nomeFantasia = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_NOME_FANTASIA);
		Map<Locale, String> observacaoMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						CadastroLojaConstants.CAMPO_OBSERVACAO);
		String cnpj = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_CNPJ);
		String endLogradouro = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_LOGRADOURO);
		String endNumero = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_NUMERO);
		String endComplemento = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_COMPLEMENTO);
		String endCep = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_CEP);
		String endBairro = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_BAIRRO);
		String endCidade = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_CIDADE);
		String endUf = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_UF);
		String endPais = ParamUtil.getString(actionRequest,
				CadastroLojaConstants.CAMPO_END_PAIS);
		boolean ordemIndicadaAtual = ParamUtil.getBoolean(actionRequest,
				CadastroLojaConstants.CAMPO_ORDEM_INDICADA_ATUAL);
		double versao = ParamUtil.getDouble(actionRequest,
				CadastroLojaConstants.CAMPO_VERSAO);
		long userId = themeDisplay.getUserId();
		long classNameId = PortalUtil.getClassNameId(Loja.class);

		Loja loja = null;

		List<Telefone> telefones = TelefoneUtil.getTelefones(actionRequest);
		List<EnderecoEmail> enderecosEmail = EnderecoEmailUtil
				.getEnderecosEmail(actionRequest);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Loja.class.getName(), actionRequest);

		if (cmd.equals(Constants.ADD)) {
			loja = LojaLocalServiceUtil.addLoja(themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(), userId, razaoSocial,
					nomeFantasia, observacaoMap, cnpj, endLogradouro,
					endNumero, endComplemento, endCep, endBairro, endCidade,
					endUf, endPais, CadastroLojaConstants.VERSAO_INICIAL,
					enderecosEmail, telefones, classNameId, serviceContext);
			
		} else if (cmd.equals(Constants.UPDATE)) {
			loja = LojaLocalServiceUtil.update(lojaId,
					themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(), userId, razaoSocial,
					nomeFantasia, observacaoMap, cnpj, endLogradouro,
					endNumero, endComplemento, endCep, endBairro, endCidade,
					endUf, endPais, userId, versao, ordemIndicadaAtual, enderecosEmail, telefones,
					classNameId, serviceContext);
		}

		return loja;
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
