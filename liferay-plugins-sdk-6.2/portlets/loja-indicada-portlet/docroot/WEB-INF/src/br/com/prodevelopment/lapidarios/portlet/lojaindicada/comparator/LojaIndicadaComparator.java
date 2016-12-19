package br.com.prodevelopment.lapidarios.portlet.lojaindicada.comparator;

import br.com.prodevelopment.lapidarios.portlet.lojaindicada.LojaIndicadaConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LojaIndicadaComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getLojaIndicadaOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new LojaIndicadaIdLojaComparator(orderByAsc);
		} else if (orderByCol.equals(LojaIndicadaConstants.CAMPO_ID_LOJA)) {
			orderByComparator = new LojaIndicadaIdLojaComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
