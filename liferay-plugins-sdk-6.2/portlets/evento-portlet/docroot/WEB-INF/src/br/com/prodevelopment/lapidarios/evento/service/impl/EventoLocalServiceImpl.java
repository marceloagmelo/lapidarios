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
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.lapidarios.evento.EventoAlteradoOutroUsuarioException;
import br.com.prodevelopment.lapidarios.evento.EventoNomeObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoResponsavelObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.model.Evento;
import br.com.prodevelopment.lapidarios.evento.service.base.EventoLocalServiceBaseImpl;
import br.com.prodevelopment.lapidarios.portlet.cadastroevento.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

/**
 * The implementation of the evento local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.lapidarios.evento.service.EventoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.base.EventoLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil
 */
public class EventoLocalServiceImpl extends EventoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil} to access the evento local service.
	 */
	public Evento addEvento(long companyId, long groupId, long createUserId,
			Map<Locale, String> nomeMap, Map<Locale, String> descricao,
			long userResponsavelId, long imagemId, long articleId)
			throws SystemException, PortalException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(0, nomeMap, locale, 1);

		Date now = new Date();

		// Recuperar responsável
		String userResponsavelNome = StringPool.BLANK;
		if (userResponsavelId > 0) {
			User userResponsavel = userPersistence
					.findByPrimaryKey(userResponsavelId);
			userResponsavelNome = userResponsavel.getFullName();
		}

		// Criar objeto incrementando um novo ID
		Evento evento = eventoPersistence.create(counterLocalService
				.increment(Evento.class.getName()));

		// Atribui novos valores
		evento.setCompanyId(companyId);
		evento.setGroupId(groupId);
		evento.setCreateUserId(createUserId);
		evento.setCreateDate(now);
		evento.setNomeMap(nomeMap);
		evento.setDescricaoMap(descricao);
		evento.setUserResponsavelNome(userResponsavelNome);
		evento.setUserResponsavelId(userResponsavelId);
		evento.setImagemId(imagemId);
		evento.setArticleId(articleId);
		evento.setVersao(Constantes.VERSAO_INICIAL);

		evento.setNew(true);

		evento = eventoPersistence.update(evento);

		return evento;
	}

	public Evento update(long eventoId, long companyId, long groupId,
			long modifieduserId, Map<Locale, String> nomeMap,
			Map<Locale, String> descricao, long userResponsavelId,
			long imagemId, long articleId)
			throws SystemException, PortalException {

		Locale locale = LocaleUtil.getSiteDefault();
		
		// Recuperar evento
		Evento evento = eventoPersistence.fetchByPrimaryKey(eventoId);
		double versao = evento.getVersao()+1;

		validate(eventoId, nomeMap, locale, versao);

		Date now = new Date();

		// Recuperar responsável
		String userResponsavelNome = StringPool.BLANK;
		if (userResponsavelId > 0) {
			User userResponsavel = userPersistence
					.findByPrimaryKey(userResponsavelId);
			userResponsavelNome = userResponsavel.getFullName();
		}

		// Atribui novos valores
		evento.setModifiedUserId(modifieduserId);
		evento.setModifiedDate(now);
		evento.setNomeMap(nomeMap);
		evento.setDescricaoMap(descricao);
		evento.setUserResponsavelNome(userResponsavelNome);
		evento.setUserResponsavelId(userResponsavelId);
		evento.setImagemId(imagemId);
		evento.setArticleId(articleId);

		evento = eventoPersistence.update(evento);

		return evento;

	}
	
	public Evento updateEventoResponsavel(long eventoId,
			long modifiedUserId, long userResponsavelId)
			throws PortalException, SystemException {

			Date now = new Date();

		// Recuperar evento
		Evento evento = eventoPersistence.fetchByPrimaryKey(eventoId);
		double versao = evento.getVersao()+1;
		
		validateResponsavel(eventoId, modifiedUserId, versao);

		// Recuperar responsável
		String userResponsavelNome = StringPool.BLANK;
		if (userResponsavelId > 0) {
			User userResponsavel = userPersistence
					.findByPrimaryKey(userResponsavelId);
			userResponsavelNome = userResponsavel.getFullName();
		}

		// Atribui novos valores
		evento.setModifiedUserId(modifiedUserId);
		evento.setModifiedDate(now);
		evento.setUserResponsavelId(userResponsavelId);
		evento.setUserResponsavelNome(userResponsavelNome);

		eventoPersistence.update(evento);

		return evento;
	}

	public Evento deleteEvento(Evento evento, long userId)
			throws SystemException {

		evento = super.deleteEvento(evento);
		return evento;
	}

	public List<Evento> search(long companyId, long groupId, 
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return eventoPersistence.findByCG(companyId, groupId, 
				start, end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId)
			throws SystemException {
		return eventoPersistence.findByCG(companyId, groupId)
				.size();
	}

	public List<Evento> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return eventoPersistence.findByCG_Nome(companyId, groupId, nome,
				start, end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return eventoPersistence.findByCG_Nome(companyId, groupId, nome)
				.size();
	}

	protected void validate(long eventoId, Map<Locale, String> nomeMap,
			Locale locale, double versao) throws PortalException,
			SystemException {

		String name = nomeMap.get(locale);

		if (Validator.isNull(name)) {
			throw new EventoNomeObrigatorioException();
		}
		if (eventoId > 0) {
			Evento evento = eventoPersistence.fetchByPrimaryKey(eventoId);
			if ((Validator.isNotNull(evento)) && (evento.getVersao() > versao)) {
				throw new EventoAlteradoOutroUsuarioException();
			}
		}
	}
	
	protected void validateResponsavel(long eventoId,
			long userResponsavelId, double versao) throws PortalException,
			SystemException {

		if (eventoId == 0) {
			throw new EventoObrigatorioException();
		}
		if (userResponsavelId == 0) {
			throw new EventoResponsavelObrigatorioException();
		}
		if (eventoId > 0) {
			Evento evento = eventoPersistence
					.fetchByPrimaryKey(eventoId);
			if ((Validator.isNotNull(evento))
					&& (evento.getVersao() > versao)) {
				throw new EventoAlteradoOutroUsuarioException();
			}
		}
	}
}