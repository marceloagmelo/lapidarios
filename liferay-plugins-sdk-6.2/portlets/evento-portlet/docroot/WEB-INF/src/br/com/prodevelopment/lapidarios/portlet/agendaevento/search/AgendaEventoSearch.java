package br.com.prodevelopment.lapidarios.portlet.agendaevento.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator.AgendasEventoComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class AgendaEventoSearch extends SearchContainer<EventoAgenda> {
	private static Logger _log = Logger.getLogger(AgendaEventoSearch.class);
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add(Constantes.CAMPO_DATA_EVENTO);
		headerNames.add(Constantes.CAMPO_HORA_EVENTO);
		headerNames.add(Constantes.CAMPO_EVENTO_NOME);
		
		orderableHeaders.put(Constantes.CAMPO_DATA_EVENTO, Constantes.CAMPO_DATA_EVENTO);
		orderableHeaders.put(Constantes.CAMPO_EVENTO_NOME, Constantes.CAMPO_EVENTO_NOME);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.agenda";		

	public AgendaEventoSearch(PortletRequest portletRequest,
			PortletURL iteratorURL) {
		super(portletRequest, new AgendaEventoDisplayTerms(portletRequest),
				new AgendaEventoDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		AgendaEventoDisplayTerms displayTerms = (AgendaEventoDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(Constantes.CAMPO_DATA_EVENTO, displayTerms.getDataEvento());
		iteratorURL.setParameter(Constantes.CAMPO_HORA_EVENTO, displayTerms.getHoraEvento());
		iteratorURL.setParameter(Constantes.CAMPO_EVENTO_NOME, displayTerms.getEventoNome());
		
		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue(Constantes.PORTLET_NAME,
						"agenda-eveno-order-by-col", orderByCol);
				preferences.setValue(Constantes.PORTLET_NAME,
						"agenda-eveno-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(Constantes.PORTLET_NAME,
						"agenda-eveno-order-by-col", Constantes.CAMPO_NOME);
				orderByType = preferences.getValue(Constantes.PORTLET_NAME,
						"agenda-eveno-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = AgendasEventoComparator
					.getAgendasEventoComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}
	}
}