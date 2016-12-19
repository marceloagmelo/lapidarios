package br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator;

import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AgendasEventoComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getAgendasEventoComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new AgendaEventoDataComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_DATA_EVENTO)) {
			orderByComparator = new AgendaEventoDataComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_EVENTO_NOME)) {
			orderByComparator = new AgendaEventoNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}
}