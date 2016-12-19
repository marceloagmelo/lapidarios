package br.com.prodevelopment.lapidarios.portlet.lojaindicada.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.LojaIndicadaConstants;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.comparator.LojaIndicadaComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;


public class LojaIndicadaSearch extends SearchContainer<LojaIndicada> {
	private static Logger _log = Logger.getLogger(LojaIndicadaSearch.class);
	
	static List<String> headerNames = new ArrayList<String>();
	//static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add(LojaIndicadaConstants.CAMPO_ID_LOJA);
		/*orderableHeaders.put(LojaIndicadaConstants.CAMPO_ID_LOJA,
				LojaIndicadaConstants.CAMPO_ID_LOJA);*/
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.lojas";


	public LojaIndicadaSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new LojaIndicadaDisplayTerms(portletRequest),
				new LojaIndicadaDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		LojaIndicadaDisplayTerms displayTerms = (LojaIndicadaDisplayTerms) getDisplayTerms();

		iteratorURL
				.setParameter(LojaIndicadaConstants.CAMPO_ID_LOJA, displayTerms.getIdLoja());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue(LojaIndicadaConstants.PORTLET_NAME,
						"loja-indicada-order-by-col", orderByCol);
				preferences.setValue(LojaIndicadaConstants.PORTLET_NAME,
						"loja-indicada-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(
						LojaIndicadaConstants.PORTLET_NAME,
						"loja-indicada-order-by-col",
						LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID);
				orderByType = preferences.getValue(
						LojaIndicadaConstants.PORTLET_NAME,
						"loja-indicada-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = LojaIndicadaComparator
					.getLojaIndicadaOrderByComparator(orderByCol, orderByType);

			//setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}

	}	
}
