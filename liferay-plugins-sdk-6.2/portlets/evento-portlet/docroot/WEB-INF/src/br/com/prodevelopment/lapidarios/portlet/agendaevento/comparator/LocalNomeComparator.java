package br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator;

import br.com.prodevelopment.lapidarios.evento.model.Local;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LocalNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Local.nome ASC";

	public static final String ORDER_BY_DESC =
		"Local.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {"nome"};

	public LocalNomeComparator() {
		this(false);
	}

	public LocalNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Local local1 = (Local)obj1;
		Local local2 = (Local)obj2;

		String nome1 = local1.getNome();
		String nome2 = local2.getNome();

		int value = nome1.compareTo(nome2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
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
