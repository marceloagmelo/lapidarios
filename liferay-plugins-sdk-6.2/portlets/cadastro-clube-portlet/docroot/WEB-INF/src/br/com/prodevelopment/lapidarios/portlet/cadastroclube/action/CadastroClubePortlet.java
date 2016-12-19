package br.com.prodevelopment.lapidarios.portlet.cadastroclube.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.associado.AssociadoAlteradoOutroUsuarioException;
import br.com.prodevelopment.associado.AssociadoCNPJDuplicadoException;
import br.com.prodevelopment.associado.AssociadoCNPJInvalidoException;
import br.com.prodevelopment.associado.AssociadoCPFDuplicadoException;
import br.com.prodevelopment.associado.AssociadoCPFInvalidoException;
import br.com.prodevelopment.associado.AssociadoDataNascimentoInvalidaException;
import br.com.prodevelopment.associado.AssociadoEmailInvalidoException;
import br.com.prodevelopment.associado.AssociadoIDPolishopDuplicadoException;
import br.com.prodevelopment.associado.AssociadoNomeObrigatorioException;
import br.com.prodevelopment.associado.AssociadoRGDataEmissaoInvalidaException;
import br.com.prodevelopment.associado.AssociadoRGInscricaoMunDuplicadoException;
import br.com.prodevelopment.associado.AssociadoUsuarioDuplicadoException;
import br.com.prodevelopment.associado.model.Associado;
import br.com.prodevelopment.associado.service.AssociadoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoInvalidoException;
import br.com.prodevelopment.lapidarios.contato.EnderecoEmailEnderecoObrigatotioException;
import br.com.prodevelopment.lapidarios.contato.EnderecoEmailTipoObrigatotioException;
import br.com.prodevelopment.lapidarios.contato.EnderecoLogradouroObrigatotioException;
import br.com.prodevelopment.lapidarios.contato.EnderecoTipoObrigatotioException;
import br.com.prodevelopment.lapidarios.contato.TelefoneDDDInvalidoException;
import br.com.prodevelopment.lapidarios.contato.TelefoneDDDObrigatotioException;
import br.com.prodevelopment.lapidarios.contato.TelefoneNumeroInvalidoException;
import br.com.prodevelopment.lapidarios.contato.TelefoneNumeroObrigatotioException;
import br.com.prodevelopment.lapidarios.contato.TelefoneTipoObrigatotioException;
import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.lojaindicada.service.LojaIndicadaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroclube.CadastroClubeConstants;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CadastroClubePortlet
 */
public class CadastroClubePortlet extends MVCPortlet {

	protected String cadastroJSP;

	@Override
	public void init() throws PortletException {
		cadastroJSP = getInitParameter(CadastroClubeConstants.JSP_CADASTRO);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(renderRequest));
			String lojaIndicadaId = httpReq
					.getParameter(CadastroClubeConstants.LOJA_INDICADA_ID);
			if (Validator.isNotNull(lojaIndicadaId)) {
				renderRequest.setAttribute(CadastroClubeConstants.LOJA_INDICADA_ID,
						lojaIndicadaId);

			}
			String jaSouLapidarios = httpReq
					.getParameter(CadastroClubeConstants.JA_SOU_LAPIDARIOS);

			if ((Validator.isNotNull(lojaIndicadaId))
					|| (Validator.isNotNull(jaSouLapidarios))) {
				include(cadastroJSP, renderRequest, renderResponse);
			} else {
				super.render(renderRequest, renderResponse);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String idPolishop = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_ID_POLISHOP);
		String idPatrocinador = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_ID_PATROCINADOR);
		String idLoja = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_ID_LOJA);
		long lojaIndicadaId = ParamUtil.getLong(actionRequest,
				CadastroClubeConstants.CAMPO_LOJA_INDICADA_ID);
		String nome = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_NOME);
		String tipoPessoa = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_TIPO_PESSOA);
		String cpf = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_CPF);
		String cnpj = ParamUtil.getString(actionRequest,
				CadastroClubeConstants.CAMPO_CNPJ);
		String cpfCnpj = (CadastroClubeConstants.PESSOA_FISICA
				.equals(tipoPessoa) ? cpf : cnpj);

		try {
			List<LojaIndicada> lojasIndicadas = LojaIndicadaLocalServiceUtil
					.getLojaIndicadas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			boolean gravou = false;
			int contador = 0;
			long lojaIndicadaIdGravar = lojaIndicadaId;
			for (LojaIndicada lojaIndicada : lojasIndicadas) {
				if (contador == 0) {
					lojaIndicadaIdGravar = lojaIndicada.getLojaIndicadaId();
				}
				contador++;
				if (lojaIndicada.getLojaIndicadaId() > lojaIndicadaId) {
					LojaIndicada novaLojaIndicada = LojaIndicadaLocalServiceUtil
							.getLojaIndicada(lojaIndicada.getLojaIndicadaId());
					novaLojaIndicada.setLojaIndicadaAtual(true);
					LojaIndicadaLocalServiceUtil
							.updateLojaIndicada(novaLojaIndicada);
					LojaIndicada antigaLojaIndicada = LojaIndicadaLocalServiceUtil
							.getLojaIndicada(lojaIndicadaId);
					antigaLojaIndicada.setLojaIndicadaAtual(false);
					LojaIndicadaLocalServiceUtil
							.updateLojaIndicada(antigaLojaIndicada);

					ServiceContext serviceContext = ServiceContextFactory
							.getInstance(Associado.class.getName(),
									actionRequest);

					User user = UserLocalServiceUtil.getUser(themeDisplay
							.getUserId());

					Associado associado = AssociadoLocalServiceUtil
							.addAssociado(themeDisplay.getCompanyId(),
									themeDisplay.getScopeGroupId(),
									themeDisplay.getUserId(),
									user.getFullName(), tipoPessoa,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									cpfCnpj, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK,
									StringPool.BLANK, StringPool.BLANK, 1,
									null, null, user.getUserId(), idPolishop,
									idLoja, idPatrocinador, serviceContext);
					gravou = true;
					break;
				}
			}
			if (!gravou) {
				LojaIndicada novaLojaIndicada = LojaIndicadaLocalServiceUtil
						.getLojaIndicada(lojaIndicadaIdGravar);
				novaLojaIndicada.setLojaIndicadaAtual(true);
				LojaIndicadaLocalServiceUtil
						.updateLojaIndicada(novaLojaIndicada);
				LojaIndicada antigaLojaIndicada = LojaIndicadaLocalServiceUtil
						.getLojaIndicada(lojaIndicadaId);
				antigaLojaIndicada.setLojaIndicadaAtual(false);
				LojaIndicadaLocalServiceUtil
						.updateLojaIndicada(antigaLojaIndicada);
			}
			SessionMessages
					.add(actionRequest, "mensagem.cadastroclube.sucesso");
		} catch (Exception e) {
			if (e instanceof AssociadoRGDataEmissaoInvalidaException
					|| e instanceof AssociadoDataNascimentoInvalidaException
					|| e instanceof AssociadoNomeObrigatorioException
					|| e instanceof AssociadoCPFInvalidoException
					|| e instanceof AssociadoCPFDuplicadoException
					|| e instanceof AssociadoCNPJInvalidoException
					|| e instanceof AssociadoCNPJDuplicadoException
					|| e instanceof AssociadoRGInscricaoMunDuplicadoException
					|| e instanceof AssociadoEmailInvalidoException
					|| e instanceof AssociadoUsuarioDuplicadoException
					|| e instanceof AssociadoAlteradoOutroUsuarioException
					|| e instanceof TelefoneTipoObrigatotioException
					|| e instanceof TelefoneDDDObrigatotioException
					|| e instanceof TelefoneDDDInvalidoException
					|| e instanceof TelefoneNumeroObrigatotioException
					|| e instanceof TelefoneNumeroInvalidoException
					|| e instanceof EnderecoEmailTipoObrigatotioException
					|| e instanceof EnderecoEmailEnderecoObrigatotioException
					|| e instanceof EnderecoEmailEnderecoInvalidoException
					|| e instanceof EnderecoTipoObrigatotioException
					|| e instanceof EnderecoLogradouroObrigatotioException
					|| e instanceof AssociadoIDPolishopDuplicadoException) {
				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter(
						CadastroClubeConstants.CAMPO_NOME, nome);
				actionResponse.setRenderParameter(
						CadastroClubeConstants.CAMPO_ID_POLISHOP, idPolishop);
				actionResponse.setRenderParameter(
						CadastroClubeConstants.CAMPO_ID_PATROCINADOR,
						idPatrocinador);
			}
			copyRequestParameters(actionRequest, actionResponse);
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
