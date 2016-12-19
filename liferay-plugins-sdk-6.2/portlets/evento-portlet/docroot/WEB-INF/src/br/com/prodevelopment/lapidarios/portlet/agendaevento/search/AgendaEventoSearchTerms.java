package br.com.prodevelopment.lapidarios.portlet.agendaevento.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class AgendaEventoSearchTerms extends AgendaEventoDisplayTerms {
	public AgendaEventoSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		dataEvento = DAOParamUtil.getString(portletRequest, Constantes.CAMPO_DATA_EVENTO);
		eventoNome = DAOParamUtil.getString(portletRequest, Constantes.CAMPO_EVENTO_NOME);
	}

}
