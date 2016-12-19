package br.com.prodevelopment.lapidarios.portlet.cadastroevento.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.lapidarios.evento.model.Evento;
import br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

public class EventoUtil {
	public static Evento getEvento(long eventoId) throws SystemException {
		return EventoLocalServiceUtil.fetchEvento(eventoId);
	}

	public static Evento getEvento(HttpServletRequest request)
			throws PortalException, SystemException {

		long eventoId = ParamUtil.getLong(request, Constantes.CAMPO_EVENTO_ID);

		Evento evento = null;
		if (eventoId > 0) {
			evento = EventoLocalServiceUtil.getEvento(eventoId);
		}

		request.setAttribute(Constantes.EVENTO, evento);
		request.setAttribute(Constantes.CAMPO_EVENTO_ID, eventoId);

		return evento;
	}

	public static Evento getEvento(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getEvento(request);
	}

	public static Evento getEvento(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getEvento(request);
	}

	public static List<Evento> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<Evento> retorno = new ArrayList<Evento>();
		List<Evento> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = EventoLocalServiceUtil.search(companyId, groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		} else {
			lista = EventoLocalServiceUtil.search(companyId, groupId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		}

		for (Evento evento : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = true;/*
											 * permissionChecker.hasPermission(
											 * groupId, Evento.class.getName(),
											 * evento.getEventoId(),
											 * ActionKeys.VIEW);
											 */
			if (hasViewPermission) {
				retorno.add(evento);
			}
		}

		return retorno;
	}

	public static String getEventoConteudoWeb(long groupId, long eventoId)
			throws PortalException, SystemException {
		String retorno = "";

		Evento evento = EventoLocalServiceUtil.fetchEvento(eventoId);
		if (Validator.isNotNull(evento)) {
			if (Validator.isNotNull(evento.getArticleId())) {
				JournalArticle article = JournalArticleLocalServiceUtil
						.getLatestArticle(groupId,
								String.valueOf(evento.getArticleId()),
								WorkflowConstants.STATUS_APPROVED);
				
				if (Validator.isNotNull(article)) {
					retorno = article.getContent();
				}
			}
		}

		return retorno;
	}

}