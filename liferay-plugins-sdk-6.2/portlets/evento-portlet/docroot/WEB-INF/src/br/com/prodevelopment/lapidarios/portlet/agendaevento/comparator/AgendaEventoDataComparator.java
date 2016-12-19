package br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator;

import java.util.Date;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AgendaEventoDataComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "EventoAgenda.dataEvento ASC";

	public static final String ORDER_BY_DESC =
		"EventoAgenda.dataEvento DESC";

	public static final String[] ORDER_BY_FIELDS = {Constantes.CAMPO_DATA_EVENTO};

	public AgendaEventoDataComparator() {
		this(false);
	}

	public AgendaEventoDataComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		EventoAgenda eventoAgenda1 = (EventoAgenda)obj1;
		EventoAgenda eventoAgenda2 = (EventoAgenda)obj2;

		Date data1 = eventoAgenda1.getDataEvento();
		Date data2 = eventoAgenda2.getDataEvento();

		int value = data1.compareTo(data2);

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
