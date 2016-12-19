package br.com.prodevelopment.portlet.associado.comparator;

import br.com.prodevelopment.associado.model.Associado;
import br.com.prodevelopment.portlet.associado.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AssociadoNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Associado.nome ASC";

	public static final String ORDER_BY_DESC =
		"Associado.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {Constantes.CAMPO_NOME};

	public AssociadoNomeComparator() {
		this(false);
	}

	public AssociadoNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Associado associado1 = (Associado)obj1;
		Associado associado2 = (Associado)obj2;

		String nome1 = associado1.getNome();
		String nome2 = associado2.getNome();

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
