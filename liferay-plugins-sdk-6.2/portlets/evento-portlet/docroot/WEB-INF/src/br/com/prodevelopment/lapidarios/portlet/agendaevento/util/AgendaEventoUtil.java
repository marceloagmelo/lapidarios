package br.com.prodevelopment.lapidarios.portlet.agendaevento.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.contato.NoSuchContatoException;
import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.model.EventoInscricao;
import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoInscricaoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoNaoInscritoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.persistence.EventoAgendaUtil;
import br.com.prodevelopment.lapidarios.evento.util.DateUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class AgendaEventoUtil {
	private static Logger _log = Logger.getLogger(EventoAgendaUtil.class);

	public static EventoAgenda getEventoAgenda(long eventoAgendaId)
			throws SystemException {
		return EventoAgendaLocalServiceUtil.fetchEventoAgenda(eventoAgendaId);
	}

	public static void setEventoAgenda(HttpServletRequest request)
			throws Exception {

		long eventoAgendaId = ParamUtil.getLong(request,
				Constantes.CAMPO_EVENTO_AGENDA_ID);

		EventoAgenda eventoAgenda = null;
		Contato contato = ContatoUtil.getContato();

		if (eventoAgendaId > 0) {
			eventoAgenda = EventoAgendaLocalServiceUtil
					.fetchEventoAgenda(eventoAgendaId);
			long classNameId = PortalUtil.getClassNameId(EventoAgenda.class
					.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(
						classNameId, eventoAgenda.getEventoAgendaId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
				_log.error(e.getMessage(), e);
			}

		}

		request.setAttribute(Constantes.EVENTO_AGENDA, eventoAgenda);
		request.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID, eventoAgendaId);
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());
	}

	public static void getEventoAgenda(RenderRequest renderRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(renderRequest);

		setEventoAgenda(request);
	}

	public static EventoAgenda getEventoAgenda(ActionRequest actionRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getEventoAgenda(request);
	}

	public static EventoAgenda getEventoAgenda(HttpServletRequest request)
			throws Exception {

		long eventoAgendaId = ParamUtil.getLong(request,
				Constantes.CAMPO_EVENTO_AGENDA_ID);

		EventoAgenda eventoAgenda = null;
		Contato contato = ContatoUtil.getContato();

		if (eventoAgendaId > 0) {
			eventoAgenda = EventoAgendaLocalServiceUtil
					.fetchEventoAgenda(eventoAgendaId);
			long classNameId = PortalUtil.getClassNameId(EventoAgenda.class
					.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(
						classNameId, eventoAgenda.getEventoAgendaId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
				_log.error(e.getMessage(), e);
			}
		}

		request.setAttribute(Constantes.EVENTO_AGENDA, eventoAgenda);
		request.setAttribute(Constantes.CAMPO_EVENTO_AGENDA_ID, eventoAgendaId);
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());

		return eventoAgenda;
	}

	public static List<EventoAgenda> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = null;
		int[] status = { WorkflowConstants.STATUS_APPROVED,
				WorkflowConstants.STATUS_PENDING };
		if (Validator.isNotNull(keywords)) {
			lista = EventoAgendaLocalServiceUtil.searchEventoNome(companyId,
					groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT, status,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		} else {
			lista = EventoAgendaLocalServiceUtil.search(companyId, groupId,
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					orderByComparator);
		}

		for (EventoAgenda eventoAgenda : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(eventoAgenda);
			}
		}

		return retorno;
	}

	public static List<EventoAgenda> listaProximosEventos(long companyId,
			long groupId, int[] status, int start, int end,
			OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = null;
		lista = EventoAgendaLocalServiceUtil.search(companyId, groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		Map<String, EventoAgenda> map = new LinkedHashMap<String, EventoAgenda>();
		
		Date dataHoje = new Date();
		for (EventoAgenda eventoAgenda : lista) {
			if (DateUtil.dataDiff(dataHoje, eventoAgenda.getDataEvento()) >= 0) {
				StringBuffer sb = new StringBuffer();
				sb.append(String.valueOf(eventoAgenda.getEventoId()));
				sb.append(String.valueOf(eventoAgenda.getLocalId()));
				sb.append(DateUtil.dateToString(eventoAgenda.getDataEvento()));
				map.put(sb.toString(), eventoAgenda);
			}
		}
		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static int listaProximosEventosCount(long companyId, long groupId,
			int[] status, PermissionChecker permissionChecker)
			throws SystemException {
		int retorno = 0;
		List<EventoAgenda> lista = null;
		lista = EventoAgendaLocalServiceUtil.search(companyId, groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		Date dataHoje = new Date();
		for (EventoAgenda eventoAgenda : lista) {
			if (dataHoje.before(eventoAgenda.getDataEvento())) {
				retorno++;
			}
		}

		return retorno;
	}

	public static List<EventoAgenda> search(long companyId, long groupId,
			String keywords, int[] status, int start, int end,
			OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = EventoAgendaLocalServiceUtil.searchEventoNome(companyId,
					groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT, status,
					start, end, orderByComparator);

		} else {
			lista = EventoAgendaLocalServiceUtil.search(companyId, groupId,
					status, start, end, orderByComparator);
		}

		for (EventoAgenda eventoAgenda : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = true;
			permissionChecker.hasPermission(groupId,
					EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(eventoAgenda);
			}
		}

		return retorno;
	}

	public static int searchCount(long companyId, long groupId,
			String keywords, int[] status, PermissionChecker permissionChecker)
			throws SystemException {
		int retorno = 0;
		List<EventoAgenda> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = EventoAgendaLocalServiceUtil.searchEventoNome(companyId,
					groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT, status,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		} else {
			lista = EventoAgendaLocalServiceUtil.search(companyId, groupId,
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}

		for (EventoAgenda eventoAgenda : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno++;
			}
		}

		return retorno;
	}

	public static void adicionarInscricao(long companyId, long groupId,
			long eventoAgendaId, long eventoId, long userIdCreate) throws SystemException,
			PortalException {
		EventoAgendaLocalServiceUtil.adicionarInscriao(companyId, groupId,
				eventoAgendaId, eventoId, userIdCreate);
	}

	public static void apagarInscricao(long eventoAgendaId, long userId) throws SystemException,
			PortalException {
		EventoAgenda eventoAgenda = AgendaEventoUtil.getEventoAgenda(eventoAgendaId);
		if (Validator.isNotNull(eventoAgenda)) {
			List<EventoInscricao> listaInscritos = AgendaEventoUtil.recuperarInscritosEvento(eventoAgenda.getCompanyId(), eventoAgenda.getGroupId(), eventoAgenda.getEventoId());
			for (EventoInscricao eventoInscricao : listaInscritos) {
				if (eventoInscricao.getCreateUserId() == userId) {
					EventoInscricaoLocalServiceUtil.deleteEventoInscricao(eventoInscricao.getEventoInscricaoId());
				}
			}
		}
		
	}
	
	public static boolean usuarioInscrito(long eventoAgendaId, long userIdCreate)
			throws SystemException, PortalException {
		boolean retorno = false;
		EventoInscricao eventoInscricao = EventoInscricaoLocalServiceUtil
				.getEventoInscricaoWithUser(eventoAgendaId, userIdCreate);
		if (Validator.isNotNull(eventoInscricao)) {
			retorno = true;
		}
		return retorno;
	}

	public static void adicionarNaoInscrito(long companyId, long groupId,
			long eventoAgendaId, long eventoId, long userIdCreate) throws SystemException,
			PortalException {
		EventoNaoInscritoLocalServiceUtil.addEventoNaoInscrito(companyId,
				groupId, eventoAgendaId, eventoId, userIdCreate);
	}

	public static List<EventoAgenda> recuperarHorarios(long companyId,
			long groupId, long eventoId, Date dataEvento, int[] status,
			int start, int end, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = EventoAgendaLocalServiceUtil
				.searchEventoData(companyId, groupId, eventoId, dataEvento,
						status, start, end, null);

		for (EventoAgenda eventoAgenda : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = true;
			permissionChecker.hasPermission(groupId,
					EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(eventoAgenda);
			}
		}

		return retorno;
	}

	public static List<Local> getLocaisFromUF(long companyId, long groupId,
			String uf) throws SystemException {
		List<Local> retorno = new ArrayList<Local>();

		List<Local> lista = LocalLocalServiceUtil.search(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		Map<String, Local> map = new LinkedHashMap<String, Local>();
		for (Local local : lista) {
			if ((Validator.isNotNull(local.getNome()))
					&& (uf.equals(local.getEndUf()))) {
				map.put(String.valueOf(local.getLocalId()), local);
			}
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static List<EventoAgenda> buscarEventos(long companyId,
			long groupId, String localId, String cidade, String uf,
			int[] status, int start, int end,
			OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = new ArrayList<EventoAgenda>();

		if (("".equals(uf)) && ("".equals(cidade))
				&& (GetterUtil.getLong(localId) == 0)) {
			lista = EventoAgendaLocalServiceUtil.search(companyId, groupId,
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		} else if (GetterUtil.getLong(localId) > 0) {
			Local local = LocalUtil.getLocal(GetterUtil.getLong(localId));
			if (Validator.isNotNull(local)) {
				String localNome = local.getNome();
				lista = EventoAgendaLocalServiceUtil.searchLocalNome(companyId,
						groupId, localNome, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						orderByComparator);
			}
		} else if (!"".equals(cidade)) {
			List<EventoAgenda> listaNova = EventoAgendaLocalServiceUtil.search(
					companyId, groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
			if (Validator.isNotNull(listaNova)) {
				List<Local> listaLocal = LocalUtil.getLocaisFromCidade(
						companyId, groupId, cidade);
				for (EventoAgenda eventoAgenda : listaNova) {
					for (Local local : listaLocal) {
						if (eventoAgenda.getLocalNome().equals(local.getNome())) {
							lista.add(eventoAgenda);
						}
					}
				}
			}
		} else if (!"".equals(uf)) {
			List<EventoAgenda> listaNova = EventoAgendaLocalServiceUtil.search(
					companyId, groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
			if (Validator.isNotNull(listaNova)) {
				List<Local> listaLocal = LocalUtil.getLocaisFromUF(companyId,
						groupId, uf);
				for (EventoAgenda eventoAgenda : listaNova) {
					for (Local local : listaLocal) {
						if (eventoAgenda.getLocalNome().equals(local.getNome())) {
							lista.add(eventoAgenda);
						}
					}
				}
			}
		}

		Map<String, EventoAgenda> map = new LinkedHashMap<String, EventoAgenda>();
		
		Date dataHoje = new Date();
		for (EventoAgenda eventoAgenda : lista) {
			if (DateUtil.dataDiff(dataHoje, eventoAgenda.getDataEvento()) >= 0) {
			//if (dataHoje.before(eventoAgenda.getDataEvento())) {
				StringBuffer sb = new StringBuffer();
				sb.append(String.valueOf(eventoAgenda.getEventoId()));
				sb.append(String.valueOf(eventoAgenda.getLocalId()));
				sb.append(DateUtil.dateToString(eventoAgenda.getDataEvento()));
				map.put(sb.toString(), eventoAgenda);
				//retorno.add(eventoAgenda);
			}
		}
		retorno = ListUtil.fromMapValues(map);
		
		return retorno;
	}

	public static List<EventoAgenda> getLocaisFromEvento(long companyId,
			long groupId, long eventoId, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = null;
		lista = EventoAgendaLocalServiceUtil.searchEventoID(companyId, groupId,
				eventoId, status, start, end, orderByComparator);

		Map<String, EventoAgenda> map = new LinkedHashMap<String, EventoAgenda>();
		for (EventoAgenda eventoAgenda : lista) {
			String localNome = eventoAgenda.getLocalNome().replace(" ", "#");
			eventoAgenda.setLocalNome(localNome);
			map.put(String.valueOf(eventoAgenda.getLocalId()), eventoAgenda);
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static List<EventoAgenda> getDatasFromLocal(long companyId,
			long groupId, long localId, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = null;
		lista = EventoAgendaLocalServiceUtil.searchLocalID(companyId, groupId,
				localId, status, start, end, orderByComparator);

		Map<String, EventoAgenda> map = new LinkedHashMap<String, EventoAgenda>();
		for (EventoAgenda eventoAgenda : lista) {
			map.put(String.valueOf(eventoAgenda.getDataEvento()), eventoAgenda);
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static List<EventoAgenda> getHorasFromData(long companyId,
			long groupId, String dataEvento, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> retorno = new ArrayList<EventoAgenda>();
		List<EventoAgenda> lista = null;
		Date dtEvento = DateUtil.stringToDate(dataEvento);
		lista = EventoAgendaLocalServiceUtil.searchData(companyId, groupId,
				dtEvento, status, start, end, orderByComparator);

		Map<String, EventoAgenda> map = new LinkedHashMap<String, EventoAgenda>();
		for (EventoAgenda eventoAgenda : lista) {
			map.put(String.valueOf(eventoAgenda.getHoraEvento()), eventoAgenda);
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static JSONArray carregarLocais(List<EventoAgenda> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (EventoAgenda eventoAgenda : lista) {
			JSONObject jsonLocal = JSONFactoryUtil.createJSONObject();
			String localDesc = eventoAgenda.getLocalNome().replace("#", " ");
			jsonLocal.put(Constantes.CAMPO_LOCAL_NOME, localDesc);
			jsonLocal.put(Constantes.CAMPO_LOCAL_ID,
					String.valueOf(eventoAgenda.getLocalId()));
			jsonArray.put(jsonLocal);
		}

		return jsonArray;
	}

	public static JSONArray carregarDatas(List<EventoAgenda> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (EventoAgenda eventoAgenda : lista) {
			JSONObject jsonData = JSONFactoryUtil.createJSONObject();
			String dataEvento = DateUtil.dateToString(eventoAgenda
					.getDataEvento());
			jsonData.put(Constantes.CAMPO_DATA_EVENTO, dataEvento);
			jsonArray.put(jsonData);
		}

		return jsonArray;
	}

	public static JSONArray carregarHoras(List<EventoAgenda> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (EventoAgenda eventoAgenda : lista) {
			JSONObject jsonHora = JSONFactoryUtil.createJSONObject();
			jsonHora.put(Constantes.CAMPO_HORA_EVENTO,
					eventoAgenda.getHoraEvento());
			jsonHora.put(Constantes.CAMPO_EVENTO_AGENDA_ID,
					String.valueOf(eventoAgenda.getEventoAgendaId()));
			jsonArray.put(jsonHora);
		}

		return jsonArray;
	}

	public static List<EventoInscricao> recuperarInscritos(long companyId,
			long groupId, long eventoAgendaId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return EventoInscricaoLocalServiceUtil.searchWithEventoAgenda(
				companyId, groupId, eventoAgendaId, start, end,
				orderByComparator);
	}


	public static List<EventoInscricao> recuperarInscritosEvento(long companyId,
			long groupId, long eventoId) throws SystemException {
		return EventoInscricaoLocalServiceUtil.searchWithEvento(
				companyId, groupId, eventoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}
}
