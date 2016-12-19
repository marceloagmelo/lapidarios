package br.com.prodevelopment.lapidarios.portlet.cadastroloja.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.comparator.CadastroLojaComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class CadastroLojaSearch extends SearchContainer<Loja> {

	private static Logger _log = Logger.getLogger(CadastroLojaSearch.class);
	
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		orderableHeaders.put(CadastroLojaConstants.LOJA_NOME_FANTASIA,
				CadastroLojaConstants.LOJA_NOME_FANTASIA);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.lojas";


	public CadastroLojaSearch(PortletRequest portletRequest, PortletURL iteratorURL, List<String> headerNames) {
		super(portletRequest, new CadastroLojaDisplayTerms(portletRequest),
				new CadastroLojaDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		CadastroLojaDisplayTerms displayTerms = (CadastroLojaDisplayTerms) getDisplayTerms();

		iteratorURL
				.setParameter(CadastroLojaConstants.CAMPO_NOME_FANTASIA, displayTerms.getNomeFantasia());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue(CadastroLojaConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-col", orderByCol);
				preferences.setValue(CadastroLojaConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(
						CadastroLojaConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-col",
						CadastroLojaConstants.CAMPO_NOME_FANTASIA);
				orderByType = preferences.getValue(
						CadastroLojaConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = CadastroLojaComparator
					.getCadastroLojaOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}

	}	
}
