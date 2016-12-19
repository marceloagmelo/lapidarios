/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.prodevelopment.lapidarios.evento.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventoAgendaService}.
 *
 * @author Marcelo Melo
 * @see EventoAgendaService
 * @generated
 */
public class EventoAgendaServiceWrapper implements EventoAgendaService,
	ServiceWrapper<EventoAgendaService> {
	public EventoAgendaServiceWrapper(EventoAgendaService eventoAgendaService) {
		_eventoAgendaService = eventoAgendaService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventoAgendaService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventoAgendaService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventoAgendaService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventoAgendaService getWrappedEventoAgendaService() {
		return _eventoAgendaService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventoAgendaService(
		EventoAgendaService eventoAgendaService) {
		_eventoAgendaService = eventoAgendaService;
	}

	@Override
	public EventoAgendaService getWrappedService() {
		return _eventoAgendaService;
	}

	@Override
	public void setWrappedService(EventoAgendaService eventoAgendaService) {
		_eventoAgendaService = eventoAgendaService;
	}

	private EventoAgendaService _eventoAgendaService;
}