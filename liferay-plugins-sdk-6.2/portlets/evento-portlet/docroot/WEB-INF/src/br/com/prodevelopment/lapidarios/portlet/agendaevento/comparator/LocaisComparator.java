package br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LocaisComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getLocaisOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new LocalNomeComparator(orderByAsc);
		} else if (orderByCol.equals("nome")) {
			orderByComparator = new LocalNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}
}