package br.com.prodevelopment.lapidarios.portlet.agendaevento.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class AgendaEventoDisplayTerms extends DisplayTerms {
	public AgendaEventoDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		dataEvento = ParamUtil.getString(portletRequest, Constantes.CAMPO_DATA_EVENTO);
		horaEvento = ParamUtil.getString(portletRequest, Constantes.CAMPO_HORA_EVENTO);
		eventoNome = ParamUtil.getString(portletRequest, Constantes.CAMPO_EVENTO_NOME);
	}
	
	public String getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}
	public String getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getEventoNome() {
		return eventoNome;
	}
	public void setEventoNome(String eventoNome) {
		this.eventoNome = eventoNome;
	}

	protected String dataEvento;
	protected String horaEvento;
	protected String eventoNome;

}
