package br.com.prodevelopment.portlet.associado.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
import br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail;
import br.com.prodevelopment.lapidarios.contato.model.Telefone;
import br.com.prodevelopment.lapidarios.municipio.model.Municipio;
import br.com.prodevelopment.lapidarios.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.portlet.associado.Constantes;
import br.com.prodevelopment.portlet.associado.util.AssociadoUtil;
import br.com.prodevelopment.portlet.associado.util.EnderecoEmailUtil;
import br.com.prodevelopment.portlet.associado.util.Helper;
import br.com.prodevelopment.portlet.associado.util.MunicipioUtil;
import br.com.prodevelopment.portlet.associado.util.TelefoneUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AssociadoPortlet
 */
public class AssociadoPortlet extends MVCPortlet {

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

			AssociadoUtil.getAssociado(renderRequest);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long associadoId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_ASSOCIADO_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

		// Recuperar campos do request
		String nome = ParamUtil.getString(actionRequest, Constantes.CAMPO_NOME);
		String tipoPessoa = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_TIPO_PESSOA);
		String observacao = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_OBSERVACAO);
		String rg = ParamUtil.getString(actionRequest, Constantes.CAMPO_RG);
		String inscricaoMun = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_INSCRICAO_MUN);
		String rgInscricaoMun = (Constantes.PESSOA_FISICA.equals(tipoPessoa) ? rg
				: inscricaoMun);
		String rgOrgaoEmissor = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_RG_ORGAO_EMISSOR);
		String rgDataEmissao = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_RG_DATA_EMISSAO);
		String cpf = ParamUtil.getString(actionRequest, Constantes.CAMPO_CPF);
		String cnpj = ParamUtil.getString(actionRequest, Constantes.CAMPO_CNPJ);
		String cpfCnpj = (Constantes.PESSOA_FISICA.equals(tipoPessoa) ? cpf
				: cnpj);
		String sexo = ParamUtil.getString(actionRequest, Constantes.CAMPO_SEXO);
		String estadoCivil = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_ESTADO_CIVIL);
		String dataNascimento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_NASCIMENTO);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);
		String endComLogradouro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_LOGRADOURO);
		String endComNumero = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_NUMERO);
		String endComComplemento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_COMPLEMENTO);
		String endComCep = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_CEP);
		String endComBairro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_BAIRRO);
		String endComCidade = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_CIDADE);
		String endComUf = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_UF);
		String endComPais = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_PAIS);
		String endResLogradouro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_LOGRADOURO);
		String endResNumero = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_NUMERO);
		String endResComplemento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_COMPLEMENTO);
		String endResCep = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_CEP);
		String endResBairro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_BAIRRO);
		String endResCidade = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_CIDADE);
		String endResUf = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_UF);
		String endResPais = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_PAIS);
		long userId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_USUARIO_ID);
		String idPolishop = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_ID_POLISHOP);
		String idLojaIndicada = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_ID_LOJA_INDICADA);
		String idPatrocinador = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_ID_PATROCINADOR);

		try {
			List<Telefone> telefones = TelefoneUtil.getTelefones(actionRequest);
			List<EnderecoEmail> enderecosEmail = EnderecoEmailUtil
					.getEnderecosEmail(actionRequest);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Associado.class.getName(), actionRequest);

			if (Constantes.ADD.equals(acao)) {
				AssociadoLocalServiceUtil.addAssociado(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nome, tipoPessoa, observacao,
						rgInscricaoMun, rgOrgaoEmissor, rgDataEmissao, cpfCnpj,
						sexo, estadoCivil, dataNascimento, endComLogradouro,
						endComNumero, endComComplemento, endComCep,
						endComBairro, endComCidade, endComUf, endComPais,
						endResLogradouro, endResNumero, endResComplemento,
						endResCep, endResBairro, endResCidade, endResUf,
						endResPais, Constantes.VERSAO_INICIAL, enderecosEmail,
						telefones, userId, idPolishop, idLojaIndicada,
						idPatrocinador, serviceContext);

				SessionMessages.add(actionRequest,
						"mensagem.associado.adicionado.sucesso");
			} else {
				AssociadoLocalServiceUtil.update(associadoId,
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nome, tipoPessoa, observacao,
						rgInscricaoMun, rgOrgaoEmissor, rgDataEmissao, cpfCnpj,
						sexo, estadoCivil, dataNascimento, endComLogradouro,
						endComNumero, endComComplemento, endComCep,
						endComBairro, endComCidade, endComUf, endComPais,
						endResLogradouro, endResNumero, endResComplemento,
						endResCep, endResBairro, endResCidade, endResUf,
						endResPais, versao, idPolishop, idLojaIndicada,
						idPatrocinador, enderecosEmail, telefones, userId,
						serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.associado.alterado.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
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
						Constantes.CAMPO_RG_DATA_EMISSAO, rgDataEmissao);
				actionResponse.setRenderParameter(
						Constantes.CAMPO_DATA_NASCIMENTO, dataNascimento);

				actionResponse.setRenderParameter("jspPage",
						"/html/associado/cadastro.jsp");
			}
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Associado associado = AssociadoUtil.getAssociado(actionRequest);
		if (Validator.isNotNull(associado)) {
			AssociadoLocalServiceUtil.deleteAssociado(associado,
					themeDisplay.getUserId());
		}
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		String metodo = ParamUtil.getString(request, Constantes.METODO);
		String pais = ParamUtil.getString(request, "pais");
		String uf = ParamUtil.getString(request, "uf");
		String cep = ParamUtil.getString(request, "cep");
		String associadoId = ParamUtil.getString(request,
				Constantes.ASSOCIADO_ID);
		request.setAttribute(Constantes.ASSOCIADO_ID, associadoId);

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(Constantes.LISTAR_UF)) {
				List<Region> lista = MunicipioUtil.listarUf(pais);
				resultJsonArray = MunicipioUtil.carregarUfs(lista);
			} else if (metodo.equals(Constantes.LISTAR_MUNICIPIOS)) {
				List<Municipio> lista = MunicipioUtil.listarMunicipios(uf);
				resultJsonArray = MunicipioUtil.carregarMunicipios(lista);
			} else if (metodo.equals(Constantes.DADOS_CEP)) {
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
		} catch (SystemException e) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deletarSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, Constantes.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			Associado associado = AssociadoUtil.getAssociado(Long
					.valueOf(deleteId));
			if (Validator.isNotNull(associado)) {
				AssociadoLocalServiceUtil.deleteAssociado(associado,
						themeDisplay.getUserId());
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
