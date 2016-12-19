package br.com.prodevelopment.lapidarios.portlet.cadastroevento.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.evento.model.Evento;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.Constantes;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.comparator.EventosComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class EventoSearch extends SearchContainer<Evento> {

	private static Logger _log = Logger.getLogger(EventoSearch.class);

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add(Constantes.CAMPO_NOME);

		orderableHeaders.put(Constantes.CAMPO_NOME, Constantes.CAMPO_NOME);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.eventos";

	public EventoSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new EventoDisplayTerms(portletRequest),
				new EventoDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		EventoDisplayTerms displayTerms = (EventoDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(Constantes.CAMPO_NOME, displayTerms.getNome());

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
						"cadastro-evento-order-by-col", orderByCol);
				preferences.setValue(Constantes.PORTLET_NAME,
						"cadastro-evento-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(Constantes.PORTLET_NAME,
						"cadastro-evento-order-by-col", Constantes.CAMPO_NOME);
				orderByType = preferences.getValue(Constantes.PORTLET_NAME,
						"cadastro-evento-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = EventosComparator
					.getEventosOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}

	}
}