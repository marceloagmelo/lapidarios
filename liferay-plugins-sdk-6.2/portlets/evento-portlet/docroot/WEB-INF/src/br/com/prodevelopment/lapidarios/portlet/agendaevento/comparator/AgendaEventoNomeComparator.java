package br.com.prodevelopment.lapidarios.portlet.agendaevento.comparator;

import java.util.Locale;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class AgendaEventoNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "EventoAgenda.eventoNome ASC";

	public static final String ORDER_BY_DESC =
		"EventoAgenda.eventoNome DESC";

	public static final String[] ORDER_BY_FIELDS = {Constantes.CAMPO_EVENTO_NOME};

	public AgendaEventoNomeComparator() {
		this(false);
	}

	public AgendaEventoNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		EventoAgenda eventoAgenda1 = (EventoAgenda)obj1;
		EventoAgenda eventoAgenda2 = (EventoAgenda)obj2;

		Locale locale = LocaleUtil.getSiteDefault();
		String nome1 = eventoAgenda1.getEventoNome(locale);
		String nome2 = eventoAgenda2.getEventoNome(locale);

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
