package br.com.prodevelopment.lapidarios.portlet.cadastroevento.comparator;

import br.com.prodevelopment.lapidarios.evento.model.Evento;

import com.liferay.portal.kernel.util.OrderByComparator;

public class EventoNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Evento.nome ASC";

	public static final String ORDER_BY_DESC = "Funcionario.nome DESC";

	public static final String[] ORDER_BY_FIELDS = { "nome" };

	public EventoNomeComparator() {
		this(false);
	}

	public EventoNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Evento evento1 = (Evento) obj1;
		Evento evento2 = (Evento) obj2;

		String nome1 = evento1.getNome();
		String nome2 = evento2.getNome();

		int value = nome1.compareTo(nome2);

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
