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

package br.com.prodevelopment.lapidarios.evento.service.impl;

import java.util.Date;
import java.util.List;

import br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito;
import br.com.prodevelopment.lapidarios.evento.service.base.EventoNaoInscritoLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

/**
 * The implementation of the evento nao inscrito local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.lapidarios.evento.service.EventoNaoInscritoLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.base.EventoNaoInscritoLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.EventoNaoInscritoLocalServiceUtil
 */
public class EventoNaoInscritoLocalServiceImpl extends
		EventoNaoInscritoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment
	 * .lapidarios.evento.service.EventoNaoInscritoLocalServiceUtil} to access
	 * the evento nao inscrito local service.
	 */
	public EventoNaoInscrito addEventoNaoInscrito(long companyId, long groupId,
			long eventoAgendaId, long eventoId, long userIdCreate) throws SystemException,
			PortalException {

		Date now = new Date();

		// Recuperar usuário
		String userNome = StringPool.BLANK;
		if (userIdCreate > 0) {
			User user = userPersistence.findByPrimaryKey(userIdCreate);
			userNome = user.getFullName();
		}

		// Criar objeto incrementando um novo ID
		long eventoNaoInscritoId = counterLocalService.increment();
		EventoNaoInscrito eventoNaoInscrito = eventoNaoInscritoPersistence
				.create(eventoNaoInscritoId);

		// Atribui novos valores
		eventoNaoInscrito.setCompanyId(companyId);
		eventoNaoInscrito.setGroupId(groupId);
		eventoNaoInscrito.setCreateUserId(userIdCreate);
		eventoNaoInscrito.setCreateDate(now);
		eventoNaoInscrito.setEventoAgendaId(eventoAgendaId);
		eventoNaoInscrito.setEventoId(eventoId);
		eventoNaoInscrito.setUserNome(userNome);

		eventoNaoInscritoPersistence.update(eventoNaoInscrito);

		return eventoNaoInscrito;
	}

	public List<EventoNaoInscrito> search(long companyId, long groupId,
			String userNome, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoNaoInscritoPersistence.findByCG_Usuario(companyId,
				groupId, userNome, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, String userNome)
			throws SystemException {
		return eventoNaoInscritoPersistence.findByCG_Usuario(companyId,
				groupId, userNome).size();
	}

	public List<EventoNaoInscrito> searchWithEventoAgenda(long companyId,
			long groupId, long eventoAgendaId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoNaoInscritoPersistence.findByCG_EventoAgenda(companyId,
				groupId, eventoAgendaId, start, end, orderByComparator);
	}

	public int searchWithEventoAgendaCount(long companyId, long groupId,
			long eventoAgendaId) throws SystemException {
		return eventoNaoInscritoPersistence.findByCG_EventoAgenda(companyId,
				groupId, eventoAgendaId).size();
	}

	public List<EventoNaoInscrito> searchWithEvento(long companyId, long groupId,
			long eventoId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoNaoInscritoPersistence.findByCG_Evento(companyId, groupId,
				eventoId, start, end, orderByComparator);
	}

	public int searchWithEventoCount(long companyId, long groupId, long eventoId)
			throws SystemException {
		return eventoNaoInscritoPersistence.findByCG_Evento(companyId, groupId,
				eventoId).size();
	}

	public EventoNaoInscrito getEventoNaoInscritoWithUser(long eventoAgendaId,
			long createUserId) throws SystemException {
		return eventoNaoInscritoPersistence.fetchByEventoAgendaUsuario(
				eventoAgendaId, createUserId);
	}
}