package br.com.prodevelopment.lapidarios.portlet.cadastroloja.comparator;

import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CadastroLojaComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getCadastroLojaOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new CadastroLojaNomeFantasiaComparator(orderByAsc);
		} else if (orderByCol.equals(CadastroLojaConstants.LOJA_NOME_FANTASIA)) {
			orderByComparator = new CadastroLojaNomeFantasiaComparator(orderByAsc);
		/*} else if (orderByCol.equals(Constantes.CAMPO_NOME_REDUZIDO)) {
			orderByComparator = new FuncionarioNomeReduzidoComparator(orderByAsc);*/
		}
		return orderByComparator;
	}
}
