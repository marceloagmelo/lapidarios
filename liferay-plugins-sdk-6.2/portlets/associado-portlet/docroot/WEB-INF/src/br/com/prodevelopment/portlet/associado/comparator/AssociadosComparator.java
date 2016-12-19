package br.com.prodevelopment.portlet.associado.comparator;

import br.com.prodevelopment.portlet.associado.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AssociadosComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getAssociadosOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new AssociadoNomeComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_NOME)) {
			orderByComparator = new AssociadoNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}
}


