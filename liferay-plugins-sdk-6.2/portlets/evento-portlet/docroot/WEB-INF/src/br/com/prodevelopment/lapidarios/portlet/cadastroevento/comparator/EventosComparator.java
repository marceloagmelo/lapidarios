package br.com.prodevelopment.lapidarios.portlet.cadastroevento.comparator;

import br.com.prodevelopment.lapidarios.portlet.cadastroevento.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class EventosComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getEventosOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new EventoNomeComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_NOME)) {
			orderByComparator = new EventoNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
