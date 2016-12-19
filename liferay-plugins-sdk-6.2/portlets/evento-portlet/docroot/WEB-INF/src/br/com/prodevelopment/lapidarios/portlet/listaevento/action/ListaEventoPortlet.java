package br.com.prodevelopment.lapidarios.portlet.listaevento.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasPreenchidaException;
import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.model.EventoInscricao;
import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.util.DateUtil;
import br.com.prodevelopment.lapidarios.evento.util.UsuarioUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.AgendaEventoUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.LocalUtil;
import br.com.prodevelopment.lapidarios.portlet.listaevento.Constantes;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaEventoPortlet
 */
public class ListaEventoPortlet extends MVCPortlet {

	private static Logger _log = Logger.getLogger(ListaEventoPortlet.class);

	protected String detalheEventoJSP;
	protected String confirmaTrocaEventoJSP;

	@Override
	public void init() throws PortletException {
		detalheEventoJSP = getInitParameter(Constantes.JSP_DETALHE_EVENTO);
		confirmaTrocaEventoJSP = getInitParameter(Constantes.JSP_CONFIRMA_TROCA_EVENTO);

		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			addProcessActionSuccessMessage = GetterUtil.getBoolean(
					getInitParameter("add-process-action-success-action"),
					false);

			String filtroUF = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_UF_SELECIONADO);
			renderRequest.setAttribute(Constantes.FILTRO_UF_SELECIONADO,
					filtroUF);
			String filtroCidade = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_CIDADE_SELECIONADA);
			renderRequest.setAttribute(Constantes.FILTRO_CIDADE_SELECIONADA,
					filtroCidade);
			String filtroLocal = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_LOCAL_SELECIONADO);
			renderRequest.setAttribute(Constantes.FILTRO_LOCAL_SELECIONADO,
					filtroLocal);
			String metodo = ParamUtil.getString(renderRequest,
					Constantes.METODO);
			renderRequest.setAttribute(Constantes.METODO, metodo);
			String eventoAgendaId = ParamUtil.getString(renderRequest,
					Constantes.CAMPO_EVENTO_AGENDA_ID);
			renderRequest.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID,
					eventoAgendaId);
			String eventoAgendaIdNovo = ParamUtil.getString(renderRequest,
					Constantes.CAMPO_EVENTO_AGENDA_ID_NOVO);
			renderRequest.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID_NOVO,
					eventoAgendaIdNovo);

			String redirect = ParamUtil.getString(renderRequest,
					Constantes.REDIRECT);

			if (Constantes.JSP_DETALHE_EVENTO.equals(redirect)) {
				include(detalheEventoJSP, renderRequest, renderResponse);
			} else if (Constantes.JSP_CONFIRMA_TROCA_EVENTO.equals(redirect)) {
				include(confirmaTrocaEventoJSP, renderRequest, renderResponse);
			} else {
				super.render(renderRequest, renderResponse);
			}
		} catch (Exception e) {
			_log.error(e, e);
		}

	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		String metodo = ParamUtil.getString(request, Constantes.METODO);
		String uf = ParamUtil.getString(request, Constantes.FILTRO_UF);
		String cidade = ParamUtil.getString(request, Constantes.FILTRO_CIDADE);

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(Constantes.GET_CIDADES_UF)) {
				List<String> lista = LocalUtil.getCidadesFromUF(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), uf);
				resultJsonArray = LocalUtil.carregarCidades(lista);
			} else if (metodo.equals(Constantes.GET_LOCAIS_CIDADE)) {
				if (Validator.isNotNull(cidade)) {
					List<Local> lista = LocalUtil.getLocaisFromCidade(
							themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), cidade);
					if (Validator.isNotNull(lista)) {
						resultJsonArray = LocalUtil.carregarLocais(lista);
					}
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

	public void inscricao(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		long companyId = ParamUtil
				.getLong(actionRequest, Constantes.COMPANY_ID);
		long groupId = ParamUtil.getLong(actionRequest, Constantes.GROUP_ID);
		long userId = ParamUtil.getLong(actionRequest, Constantes.USER_ID);
		long eventoAgendaId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_AGENDA_ID);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);
		actionResponse.setRenderParameter(Constantes.REDIRECT, redirect);
		actionResponse.setRenderParameter(Constantes.CAMPO_EVENTO_AGENDA_ID,
				String.valueOf(eventoAgendaId));
		try {
			boolean existeInscricao = false;
			EventoAgenda eventoAgenda = AgendaEventoUtil.getEventoAgenda(eventoAgendaId);
			if (Validator.isNotNull(eventoAgenda)) {
				List<EventoInscricao> listaInscritos = AgendaEventoUtil.recuperarInscritosEvento(companyId, groupId, eventoAgenda.getEventoId());
				for (EventoInscricao eventoInscricao : listaInscritos) {
					if (eventoInscricao.getCreateUserId() == userId) {
						actionResponse.setRenderParameter(Constantes.CAMPO_EVENTO_AGENDA_ID_NOVO,
								String.valueOf(eventoAgendaId));
						actionResponse.setRenderParameter(Constantes.CAMPO_EVENTO_AGENDA_ID,
								String.valueOf(eventoInscricao.getEventoAgendaId()));
						actionResponse.setRenderParameter(Constantes.REDIRECT,
								Constantes.JSP_CONFIRMA_TROCA_EVENTO);
						existeInscricao = true;

						SessionMessages.add(actionRequest,
								StringPool.BLANK);
					}
				}
				if (!existeInscricao) {
					AgendaEventoUtil.adicionarInscricao(companyId, groupId,
							eventoAgendaId, eventoAgenda.getEventoId(), userId);

					enviarEmailParaResponsavel(eventoAgendaId, userId);

					SessionMessages.add(actionRequest,
							"mensagem.inscricao.realizada.sucesso");
				}
			}
		} catch (Exception e) {
			if (e instanceof EventoQtdeVagasPreenchidaException) {
				EventoAgenda eventoAgenda = AgendaEventoUtil.getEventoAgenda(eventoAgendaId);
				if (Validator.isNotNull(eventoAgenda)) {
					AgendaEventoUtil.adicionarNaoInscrito(companyId, groupId,
							eventoAgendaId, eventoAgenda.getEventoId(), userId);
					SessionErrors.add(actionRequest, e.getClass());
				}
			}
		}
	}

	public void trocaInscricao(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		long companyId = ParamUtil
				.getLong(actionRequest, Constantes.COMPANY_ID);
		long groupId = ParamUtil.getLong(actionRequest, Constantes.GROUP_ID);
		long userId = ParamUtil.getLong(actionRequest, Constantes.USER_ID);
		long eventoAgendaId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_AGENDA_ID);
		long eventoAgendaIdNovo = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_AGENDA_ID_NOVO);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);
		actionResponse.setRenderParameter(Constantes.REDIRECT, redirect);

		try {
			EventoAgenda eventoAgenda = AgendaEventoUtil.getEventoAgenda(eventoAgendaIdNovo);
			if (Validator.isNotNull(eventoAgenda)) {
				AgendaEventoUtil.apagarInscricao(eventoAgendaId, userId);

				AgendaEventoUtil.adicionarInscricao(companyId, groupId,
						eventoAgendaIdNovo, eventoAgenda.getEventoId(), userId);

				enviarEmailParaResponsavel(eventoAgendaIdNovo, userId);
				
				actionResponse.setRenderParameter(Constantes.CAMPO_EVENTO_AGENDA_ID,
						String.valueOf(eventoAgendaIdNovo));


				SessionMessages.add(actionRequest,
						"mensagem.inscricao.realizada.sucesso");
			}
		} catch (Exception e) {
			EventoAgenda eventoAgenda = AgendaEventoUtil.getEventoAgenda(eventoAgendaId);
			if (Validator.isNotNull(eventoAgenda)) {
				AgendaEventoUtil.adicionarNaoInscrito(companyId, groupId,
						eventoAgendaId, eventoAgenda.getEventoId(), userId);
				SessionErrors.add(actionRequest, e.getClass());
			}
		}
	}

	/*
	public void inscricaoOLD(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		long companyId = ParamUtil
				.getLong(actionRequest, Constantes.COMPANY_ID);
		long groupId = ParamUtil.getLong(actionRequest, Constantes.GROUP_ID);
		long userId = ParamUtil.getLong(actionRequest, Constantes.USER_ID);
		long eventoAgendaId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_EVENTO_AGENDA_ID);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);
		actionResponse.setRenderParameter(Constantes.REDIRECT, redirect);
		actionResponse.setRenderParameter(Constantes.CAMPO_EVENTO_AGENDA_ID,
				String.valueOf(eventoAgendaId));

		try {
			AgendaEventoUtil.adicionarInscricao(companyId, groupId,
					eventoAgendaId, userId);

			enviarEmailParaResponsavel(eventoAgendaId, userId);

			SessionMessages.add(actionRequest,
					"mensagem.inscricao.realizada.sucesso");
		} catch (Exception e) {
			if (e instanceof EventoQtdeVagasPreenchidaException) {
				AgendaEventoUtil.adicionarNaoInscrito(companyId, groupId,
						eventoAgendaId, userId);
				SessionErrors.add(actionRequest, e.getClass());
			}
		}
	}
	*/
	public void pesquisar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		String filtroUF = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_UF_SELECIONADO);
		String filtroCidade = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_CIDADE_SELECIONADA);
		String filtroLocal = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_LOCAL_SELECIONADO);

		try {
			actionResponse.setRenderParameter(Constantes.FILTRO_UF_SELECIONADO,
					filtroUF);
			actionResponse.setRenderParameter(
					Constantes.FILTRO_CIDADE_SELECIONADA, filtroCidade);
			actionResponse.setRenderParameter(
					Constantes.FILTRO_LOCAL_SELECIONADO, filtroLocal);
			actionResponse.setRenderParameter(Constantes.METODO,
					Constantes.FILTRO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enviarEmailParaResponsavel(long eventoAgendaId, long userId)
			throws Exception {
		Locale locale = LocaleUtil.getSiteDefault();
		
		
		EventoAgenda agendaEvento = AgendaEventoUtil
				.getEventoAgenda(eventoAgendaId);
		
		String nomeEvento = agendaEvento.getEventoNome(locale);
		String localEvento = agendaEvento.getLocalNome();
		String dataEvento = DateUtil.getDateExtenso(agendaEvento.getDataEvento(), false);
		String horaEvento = agendaEvento.getHoraEvento();
		
		Local local = LocalUtil.getLocal(agendaEvento.getLocalId());
		StringBuffer sbEndereco = new StringBuffer(StringPool.BLANK);
		if (Validator.isNotNull(local)) {
			sbEndereco.append(local.getEndLogradouro());
			if (Validator.isNotNull(local.getEndNumero())) {
				sbEndereco.append(", "+local.getEndNumero());
			}
			if (Validator.isNotNull(local.getEndBairro())) {
				sbEndereco.append(" - "+local.getEndBairro());
			}
			if (Validator.isNotNull(local.getEndCidade())) {
				sbEndereco.append(" - "+local.getEndCidade());
			}
			if (Validator.isNotNull(local.getEndUf())) {
				sbEndereco.append(" - "+local.getEndUf());
			}
	    }	

		User user = UsuarioUtil.getUsuario(userId);

		StringBuilder corpoEmail = new StringBuilder();

		// Cabecalho
		String velocityTemplateIdCorpo = "/email_inscricao.vm";
		String corpoEmailTexto = leituraArquivo(velocityTemplateIdCorpo);

		corpoEmailTexto = corpoEmailTexto.replace(
				"$user.getFullName()", user.getFullName());
		corpoEmailTexto = corpoEmailTexto.replace(
				"$dataEvento", dataEvento);
		corpoEmailTexto = corpoEmailTexto.replace(
				"$horaEvento", horaEvento);
		corpoEmailTexto = corpoEmailTexto.replace(
				"$localEvento", localEvento);
		corpoEmailTexto = corpoEmailTexto.replace(
				"$endEvento", sbEndereco.toString());


		corpoEmail.append(corpoEmailTexto);

		InternetAddress remetente = new InternetAddress(
				"adm@lapidarios.com.vc", "Portal");
		String personalRemetente = remetente.getPersonal();
		remetente.setPersonal(personalRemetente, "UTF-8");
		List<MailMessage> mensagens = new ArrayList<MailMessage>();

		InternetAddress destinatario = new InternetAddress(
				user.getEmailAddress(), "");
		String personalDestinatario = destinatario.getPersonal();
		destinatario.setPersonal(personalDestinatario, "UTF-8");
		MailMessage mensagem = new MailMessage(remetente, destinatario,
				"Evento " + nomeEvento,
				corpoEmail.toString(), true);
		mensagens.add(mensagem);

		// Envio dos emails
		for (MailMessage mailMessage : mensagens) {
			MailServiceUtil.sendEmail(mailMessage);
		}
	}

	private String leituraArquivo(String file) throws IOException {
		URL url = getClass().getClassLoader().getResource(file);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		StringBuffer buffer = new StringBuffer();

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine + "\n");
		in.close();
		return buffer.toString();
	}
}
