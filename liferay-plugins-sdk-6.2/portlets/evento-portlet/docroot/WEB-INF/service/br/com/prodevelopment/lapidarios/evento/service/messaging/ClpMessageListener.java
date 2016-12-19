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

package br.com.prodevelopment.lapidarios.evento.service.messaging;

import br.com.prodevelopment.lapidarios.evento.service.ClpSerializer;
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoInscricaoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoInscricaoServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoNaoInscritoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoNaoInscritoServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.LocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Marcelo Melo
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			EventoLocalServiceUtil.clearService();

			EventoServiceUtil.clearService();
			EventoAgendaLocalServiceUtil.clearService();

			EventoAgendaServiceUtil.clearService();
			EventoInscricaoLocalServiceUtil.clearService();

			EventoInscricaoServiceUtil.clearService();
			EventoNaoInscritoLocalServiceUtil.clearService();

			EventoNaoInscritoServiceUtil.clearService();
			LocalLocalServiceUtil.clearService();

			LocalServiceUtil.clearService();
		}
	}
}