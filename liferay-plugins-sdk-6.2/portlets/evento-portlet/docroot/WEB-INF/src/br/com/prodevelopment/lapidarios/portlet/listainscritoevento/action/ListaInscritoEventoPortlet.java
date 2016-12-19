package br.com.prodevelopment.lapidarios.portlet.listainscritoevento.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.util.AgendaEventoUtil;
import br.com.prodevelopment.lapidarios.portlet.listainscritoevento.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaInscritoEventoPortlet
 */
public class ListaInscritoEventoPortlet extends MVCPortlet {

	private static Logger _log = Logger
			.getLogger(ListaInscritoEventoPortlet.class);

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			addProcessActionSuccessMessage = GetterUtil.getBoolean(
					getInitParameter("add-process-action-success-action"),
					false);

			String filtroEventoSelecionado = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_EVENTO_SELECIONADO);
			String filtroLocalSelecionado = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_LOCAL_SELECIONADO);
			String filtroDataSelecionada = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_DATA_SELECIONADA);
			String filtroHoraSelecionada = ParamUtil.getString(renderRequest,
					Constantes.FILTRO_HORA_SELECIONADA);

			renderRequest.setAttribute(Constantes.FILTRO_EVENTO_SELECIONADO,
					filtroEventoSelecionado);
			renderRequest.setAttribute(Constantes.FILTRO_LOCAL_SELECIONADO,
					filtroLocalSelecionado);
			renderRequest.setAttribute(Constantes.FILTRO_DATA_SELECIONADA,
					filtroDataSelecionada);
			renderRequest.setAttribute(Constantes.FILTRO_HORA_SELECIONADA,
					filtroHoraSelecionada);
			String metodo = ParamUtil.getString(renderRequest,
					Constantes.METODO);
			if (Validator.isNull(filtroHoraSelecionada)) {
				metodo = "";
			}
			renderRequest.setAttribute(Constantes.METODO, metodo);
			String eventoAgendaId = ParamUtil.getString(renderRequest,
					Constantes.CAMPO_EVENTO_AGENDA_ID);
			renderRequest.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID,
					eventoAgendaId);
			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e, e);
		}

	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		String metodo = ParamUtil.getString(request, Constantes.METODO);
		String filtroEvento = ParamUtil.getString(request,
				Constantes.FILTRO_EVENTO);
		String filtroLocal = ParamUtil.getString(request,
				Constantes.FILTRO_LOCAL);
		String filtroData = ParamUtil.getString(request,
				Constantes.FILTRO_DATA);

		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		int[] status = { WorkflowConstants.STATUS_APPROVED };
		long eventoId = GetterUtil.getLong(filtroEvento);
		OrderByComparator orderByComparator = null;

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(Constantes.GET_LOCAIS_EVENTO)) {
				List<EventoAgenda> lista = AgendaEventoUtil
						.getLocaisFromEvento(themeDisplay.getCompanyId(),
								themeDisplay.getScopeGroupId(), eventoId,
								status, start, end, orderByComparator);
				resultJsonArray = AgendaEventoUtil.carregarLocais(lista);
			} else if (metodo.equals(Constantes.GET_DATAS_LOCAL)) {
				List<EventoAgenda> lista = AgendaEventoUtil.getDatasFromLocal(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						GetterUtil.getLong(filtroLocal), status,
						start, end, null);
				resultJsonArray = AgendaEventoUtil.carregarDatas(lista);
			} else if (metodo.equals(Constantes.GET_HORAS_DATA)) {
				List<EventoAgenda> lista = AgendaEventoUtil.getHorasFromData(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), filtroData,
						status, start, end, null);
				resultJsonArray = AgendaEventoUtil.carregarHoras(lista);
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

	public void pesquisar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		String filtroEventoSelecionado = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_EVENTO_SELECIONADO);
		String filtroLocalSelecionado = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_LOCAL_SELECIONADO);
		String filtroDataSelecionada = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_DATA_SELECIONADA);
		String filtroHoraSelecionada = ParamUtil.getString(actionRequest,
				Constantes.FILTRO_HORA_SELECIONADA);

		try {
			actionResponse.setRenderParameter(
					Constantes.FILTRO_EVENTO_SELECIONADO, filtroEventoSelecionado);
			actionResponse.setRenderParameter(
					Constantes.FILTRO_LOCAL_SELECIONADO, filtroLocalSelecionado);
			actionResponse.setRenderParameter(
					Constantes.FILTRO_DATA_SELECIONADA, filtroDataSelecionada);
			actionResponse.setRenderParameter(
					Constantes.FILTRO_HORA_SELECIONADA, filtroHoraSelecionada);
			actionResponse.setRenderParameter(Constantes.METODO,
					Constantes.FILTRO);

		} catch (Exception e) {
			_log.error(e, e);
		}
	}

}
