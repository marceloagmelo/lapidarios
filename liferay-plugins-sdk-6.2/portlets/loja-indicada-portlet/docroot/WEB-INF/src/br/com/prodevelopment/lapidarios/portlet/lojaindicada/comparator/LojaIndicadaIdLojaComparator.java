package br.com.prodevelopment.lapidarios.portlet.lojaindicada.comparator;

import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.LojaIndicadaConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LojaIndicadaIdLojaComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "NomeFantasia.idLojaIndicada ASC";

	public static final String ORDER_BY_DESC = "NomeFantasia.idLojaIndicada DESC";

	public static final String[] ORDER_BY_FIELDS = { LojaIndicadaConstants.CAMPO_ID_LOJA };

	public LojaIndicadaIdLojaComparator() {
		this(false);
	}

	public LojaIndicadaIdLojaComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		LojaIndicada lojaIndicada1 = (LojaIndicada) obj1;
		LojaIndicada lojaIndicada2 = (LojaIndicada) obj2;

		String idLojaIndicada1 = lojaIndicada1.getIdLoja();
		String idLojaIndicada2 = lojaIndicada2.getIdLoja();

		int value = idLojaIndicada1.compareTo(idLojaIndicada2);

		if (_ascending) {
			return value;
		} else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}