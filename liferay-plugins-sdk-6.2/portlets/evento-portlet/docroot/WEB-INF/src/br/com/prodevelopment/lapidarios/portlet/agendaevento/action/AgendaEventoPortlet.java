package br.com.prodevelopment.lapidarios.portlet.agendaevento.action;

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
import br.com.prodevelopment.lapidarios.evento.EventoAgendaAlteradoOutroUsuarioException;
import br.com.prodevelopment.lapidarios.evento.EventoDataInvalidaException;
import br.com.prodevelopment.lapidarios.evento.EventoDataMenorHojeException;
import br.com.prodevelopment.lapidarios.evento.EventoDataObrigatoriaException;
import br.com.prodevelopment.lapidarios.evento.EventoLocalObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasObrigatoriaException;
import br.com.prodevelopment.lapidarios.evento.LocalAlteradoOutroUsuarioException;
import br.com.prodevelopment.lapidarios.evento.LocalNomeObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.util.DateUtil;
import br.com.prodevelopment.lapidarios.evento.util.Helper;
import br.com.prodevelopment.lapidarios.evento.util.UsuarioUtil;
import br.com.prodevelopment.lapidarios.municipio.model.Municipio;
import br.com.prodevelopment.lapidarios.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.AgendaEventoUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.EnderecoEmailUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.LocalUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.MunicipioUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.TelefoneUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.util.EventoUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AgendaEventoPortlet
 */
public class AgendaEventoPortlet extends MVCPortlet {
 
	private static Logger _log = Logger.getLogger(AgendaEventoPortlet.class);
	 
	protected String viewLocalJSP;
	protected String selecioneLocalJSP;

	@Override
	public void init() throws PortletException {
		viewLocalJSP = getInitParameter(Constantes.JSP_VIEW_LOCAL);
		selecioneLocalJSP = getInitParameter(Constantes.JSP_SELECIONE_LOCAL);

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
					Constantes.MOVE_TRASH_ACTION);
			String restoreAction = ParamUtil.getString(renderRequest,
					Constantes.RESTORE_ACTION);
			String deleteAction = ParamUtil.getString(renderRequest,
					Constantes.DELETE_ACTION);
			String eventoNome = ParamUtil.getString(renderRequest,
					Constantes.CAMPO_EVENTO_NOME);
			String restoreEventoAgendaIds = ParamUtil.getString(renderRequest,
					Constantes.RESTORE_EVENTO_AGENDA_IDS);
			String deleteEventoAgendaNomes = ParamUtil.getString(renderRequest,
					Constantes.DELETE_EVENTO_AGENDA_NOME);
			String restoreEventoAgendaNomes = ParamUtil.getString(renderRequest,
					Constantes.RESTORE_EVENTO_AGENDA_NOMES);

			renderRequest.setAttribute(Constantes.MOVE_TRASH_ACTION,
					moveTrashAction);
			renderRequest.setAttribute(Constantes.RESTORE_ACTION,
					restoreAction);
			renderRequest.setAttribute(Constantes.DELETE_ACTION,
					deleteAction);
			renderRequest.setAttribute(
					Constantes.CAMPO_EVENTO_NOME, eventoNome);
			renderRequest.setAttribute(Constantes.RESTORE_EVENTO_AGENDA_IDS,
					restoreEventoAgendaIds);
			renderRequest.setAttribute(
					Constantes.DELETE_EVENTO_AGENDA_NOME,
					deleteEventoAgendaNomes);
			renderRequest.setAttribute(
					Constantes.RESTORE_EVENTO_AGENDA_NOMES,
					restoreEventoAgendaNomes);

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest.setAttribute(Constantes.PORTLET_TITLE,
					portletTitulo);

			AgendaEventoUtil.getEventoAgenda(renderRequest);
			EventoUtil.getEvento(renderRequest);
			LocalUtil.getLocal(renderRequest);
			UsuarioUtil.getUsuario(renderRequest);

			super.render(renderRequest, renderResponse);

		} catch (Exception e) {
			_log.error(e, e);
		}
	}
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String redirect = ParamUtil.getString(renderRequest,
				Constantes.REDIRECT);

		if (Constantes.REDIRECT_VIEW_LOCAL.equals(redirect)) {
			include(viewLocalJSP, renderRequest, renderResponse);
		} else if (Constantes.REDIRECT_SELECIONE_LOCAL.equals(redirect)) {
			include(selecioneLocalJSP, renderRequest, renderResponse);
		} else {
			super.doView(renderRequest, renderResponse);
		}
	}
	
	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long eventoAgendaId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_AGENDA_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

		// Recuperar campos do request
		String dataEvento = ParamUtil.getString(actionRequest, Constantes.CAMPO_DATA_EVENTO);
		String horaEvento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_HORA_EVENTO);
		long eventoId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_ID);
		long localId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_LOCAL_ID);
		long usuarioResponsavelId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_USUARIO_RESPONSAVEL_ID);
		int qtdeVagas = ParamUtil.getInteger(actionRequest, Constantes.CAMPO_QTDE_VAGAS);
		double valor = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VALOR);
		boolean gratuito = ParamUtil.getBoolean(actionRequest,
				Constantes.CAMPO_GRATUITO);
		boolean repetir = ParamUtil.getBoolean(actionRequest,
				Constantes.CAMPO_REPETIR);
		String qtdeRepeticao = ParamUtil.getString(actionRequest, Constantes.CAMPO_QTDE_REPETICAO);
		
		Map<Locale, String> observacaoMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						Constantes.CAMPO_OBSERVACAO);
		long classNameId = PortalUtil.getClassNameId(EventoAgenda.class);
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					EventoAgenda.class.getName(), actionRequest);

			if (Constantes.ADD.equals(acao)) {
				EventoAgenda eventoAgenda = EventoAgendaLocalServiceUtil.addEventoAgenda(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
						dataEvento, horaEvento, qtdeVagas, gratuito, valor, usuarioResponsavelId, eventoId, localId, observacaoMap, classNameId, serviceContext);
				if ((repetir) && (Validator.isNumber(qtdeRepeticao)) && GetterUtil.getInteger(qtdeRepeticao) > 0) {
					for (int i=1; i<=GetterUtil.getInteger(qtdeRepeticao); i++) {
						String novaDataEvento = DateUtil.dateToString(DateUtil.addDias(DateUtil.stringToDate(dataEvento), i));
						eventoAgenda = EventoAgendaLocalServiceUtil.addEventoAgenda(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
								novaDataEvento, horaEvento, qtdeVagas, gratuito, valor, usuarioResponsavelId, eventoId, localId, observacaoMap, classNameId, serviceContext);
					}
				}

				SessionMessages.add(actionRequest,
						"mensagem.eventoAgenda.adicionada.sucesso");
			} else {
				EventoAgenda eventoAgenda = EventoAgendaLocalServiceUtil.updateEventoAgenda(eventoAgendaId, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), dataEvento, horaEvento, 
						qtdeVagas, gratuito, valor, usuarioResponsavelId, eventoId, localId, observacaoMap, classNameId, serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.eventoAgenda.alterada.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof EventoObrigatorioException
					|| e instanceof EventoLocalObrigatorioException
					|| e instanceof EventoDataObrigatoriaException
					|| e instanceof EventoDataInvalidaException
					|| e instanceof EventoDataMenorHojeException
					|| e instanceof EventoQtdeVagasObrigatoriaException
					|| e instanceof EventoAgendaAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter(
						Constantes.CAMPO_EVENTO_ID, String.valueOf(eventoId));
				actionResponse.setRenderParameter(
						Constantes.CAMPO_LOCAL_ID, String.valueOf(localId));
				actionResponse.setRenderParameter(
						Constantes.CAMPO_USUARIO_RESPONSAVEL_ID, String.valueOf(usuarioResponsavelId));

				actionResponse.setRenderParameter("jspPage",
						"/html/agendaevento/cadastro.jsp");
			}
		}
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		String metodo = ParamUtil.getString(request,
				Constantes.METODO);
		String uf = ParamUtil.getString(request, "uf");
		String cep = ParamUtil.getString(request, "cep");
		String eventoAgendaId = ParamUtil.getString(request,
				Constantes.CAMPO_EVENTO_AGENDA_ID);
		request.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID, eventoAgendaId);

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(Constantes.LISTAR_MUNICIPIOS)) {
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
			_log.error(e, e);
		} catch (SystemException e) {
			_log.error(e, e);
		} catch (Exception e) {
			_log.error(e, e);
		}
	}
	
	public void salvarLocal(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		// Recuperar campos do request
		long localId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_LOCAL_ID);
		String nome = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_NOME);
		Map<Locale, String> pontoReferenciaMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						Constantes.CAMPO_PONTO_REFERENCIA);
		String endLogradouro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_LOGRADOURO);
		String endNumero = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_NUMERO);
		String endComplemento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COMPLEMENTO);
		String endCep = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_CEP);
		String endBairro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_BAIRRO);
		String endCidade = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_CIDADE);
		String endUf = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_UF);
		String endPais = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_PAIS);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);
		long classNameId = PortalUtil.getClassNameId(Local.class);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);

		List<Telefone> telefones = TelefoneUtil.getTelefones(actionRequest);
		List<EnderecoEmail> enderecosEmail = EnderecoEmailUtil
				.getEnderecosEmail(actionRequest);
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

			if (Constantes.ADD.equals(acao)) {
				LocalLocalServiceUtil.addLocal(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
						themeDisplay.getUserId(), nome, pontoReferenciaMap, endLogradouro, endNumero, endComplemento, endCep, 
						endBairro, endCidade, endUf, endPais, Constantes.VERSAO_INICIAL, enderecosEmail, telefones);
				SessionMessages.add(actionRequest,
						"mensagem.local.adicionado.sucesso");
			} else {
				LocalLocalServiceUtil.update(localId, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
						themeDisplay.getUserId(), nome, pontoReferenciaMap, endLogradouro, endNumero, endComplemento, endCep, 
						endBairro, endCidade, endUf, endPais, versao, enderecosEmail, telefones, classNameId);
				SessionMessages.add(actionRequest,
						"mensagem.local.alterado.sucesso");
			}
			// sendRedirect(actionRequest, actionResponse);

			if (Constantes.REDIRECT_SELECIONE_LOCAL.equals(redirect)) {
				actionResponse.setRenderParameter("jspPage", "/html/local/selecione.jsp");
			} else {
				actionResponse.setRenderParameter("jspPage", "/html/local/view.jsp");
			}
			
			actionResponse.setRenderParameter(Constantes.REDIRECT, Constantes.REDIRECT_VIEW_LOCAL);
		} catch (Exception e) {
			if (e instanceof LocalNomeObrigatorioException
					|| e instanceof LocalAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/local/cadastro.jsp");
			}
		}
	}
	
	public void deletarLocal(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		String redirect = ParamUtil.getString(actionRequest, "direciona");
		actionResponse.setRenderParameter(Constantes.REDIRECT, redirect);

		Local local = LocalUtil.getLocal(actionRequest);
		if (Validator.isNotNull(local)) {
			LocalLocalServiceUtil.deleteLocal(local.getLocalId());
		}

		//sendRedirect(actionRequest, actionResponse);
		actionResponse.setRenderParameter(Constantes.REDIRECT, Constantes.REDIRECT_VIEW_LOCAL);
		actionResponse.setRenderParameter("jspPage", "/html/local/view.jsp");
	}

	public void deletarLocaisSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException, PortalException {

		actionResponse.setRenderParameter(Constantes.REDIRECT,
				Constantes.REDIRECT_VIEW_LOCAL);

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, Constantes.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			Local local = LocalUtil.getLocal(Long.valueOf(deleteId));
			if (Validator.isNotNull(local)) {
				LocalLocalServiceUtil.deleteLocal(local.getLocalId());				
			}
		}
		actionResponse.setRenderParameter("jspPage", "/html/local/view.jsp");
	}
	
	protected EventoAgenda updateEventoAgenda(ActionRequest actionRequest) throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		long eventoAgendaId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_AGENDA_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar campos do request
		String dataEvento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_EVENTO);
		String horaEvento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_HORA_EVENTO);
		String minutoEvento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_MINUTO_EVENTO);
		horaEvento= horaEvento+":"+minutoEvento;
		int qtdeVagas = ParamUtil.getInteger(actionRequest,
				Constantes.CAMPO_QTDE_VAGAS);
		boolean gratuito = ParamUtil.getBoolean(actionRequest,
				Constantes.CAMPO_GRATUITO);
		double valor = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VALOR);
		long usuarioResponsavelId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_USUARIO_RESPONSAVEL_ID);
		long localId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_LOCAL_ID);
		long eventoId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_ID);
		Map<Locale, String> observacaoMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						Constantes.CAMPO_OBSERVACAO);
		long userId = themeDisplay.getUserId();
		long classNameId = PortalUtil.getClassNameId(EventoAgenda.class);

		EventoAgenda eventoAgenda = null;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				EventoAgenda.class.getName(), actionRequest);

		if (cmd.equals(Constants.ADD)) {
			eventoAgenda = EventoAgendaLocalServiceUtil.addEventoAgenda(themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(), userId, dataEvento,
					horaEvento, qtdeVagas, gratuito, valor,
					usuarioResponsavelId, eventoId, localId,
					observacaoMap, classNameId, serviceContext);
			
		} else if (cmd.equals(Constants.UPDATE)) {
			eventoAgenda = EventoAgendaLocalServiceUtil.updateEventoAgenda(eventoAgendaId, themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(), userId, dataEvento,
					horaEvento, qtdeVagas, gratuito, valor,
					usuarioResponsavelId, eventoId, localId, observacaoMap, classNameId, serviceContext);
		}

		return eventoAgenda;
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
