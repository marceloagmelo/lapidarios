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

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.evento.EventoAgendaAlteradoOutroUsuarioException;
import br.com.prodevelopment.lapidarios.evento.EventoAgendaObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoDataInvalidaException;
import br.com.prodevelopment.lapidarios.evento.EventoDataMenorHojeException;
import br.com.prodevelopment.lapidarios.evento.EventoDataObrigatoriaException;
import br.com.prodevelopment.lapidarios.evento.EventoLocalObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoNaoEncontradoException;
import br.com.prodevelopment.lapidarios.evento.EventoObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasObrigatoriaException;
import br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasPreenchidaException;
import br.com.prodevelopment.lapidarios.evento.EventoResponsavelObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.model.Evento;
import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.service.EventoInscricaoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.service.base.EventoAgendaLocalServiceBaseImpl;
import br.com.prodevelopment.lapidarios.evento.util.DateUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.SystemEventConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.trash.model.TrashEntry;

/**
 * The implementation of the evento agenda local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.base.EventoAgendaLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil
 */
public class EventoAgendaLocalServiceImpl extends
		EventoAgendaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment
	 * .lapidarios.evento.service.EventoAgendaLocalServiceUtil} to access the
	 * evento agenda local service.
	 */
	private static Logger _log = Logger
			.getLogger(EventoAgendaLocalServiceImpl.class);

	public EventoAgenda addEventoAgenda(long companyId, long groupId,
			long userIdCreate, String sDataEvento, String sHoraEvento,
			int qtdeVagas, boolean gratuito, double valor,
			long userResponsavelId, long eventoId, long localId,
			Map<Locale, String> observacaoMap, long classNameId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		Locale locale = LocaleUtil.getSiteDefault();

		Date now = new Date();

		validate(0, eventoId, localId, sDataEvento, sHoraEvento,
				DateUtil.dateToString(now), userIdCreate, qtdeVagas, 1);

		User userCreate = userPersistence.findByPrimaryKey(userIdCreate);

		// Recuperar responsável
		String userResponsavelNome = StringPool.BLANK;
		if (userResponsavelId > 0) {
			User userResponsavel = userPersistence
					.findByPrimaryKey(userResponsavelId);
			userResponsavelNome = userResponsavel.getFullName();
		}

		// Recuperar evento
		String eventoNome = StringPool.BLANK;
		if (eventoId > 0) {
			Evento evento = eventoPersistence.findByPrimaryKey(eventoId);
			eventoNome = evento.getNome(locale);
		}

		// Recuperar local
		String localNome = StringPool.BLANK;
		if (localId > 0) {
			Local local = localPersistence.findByPrimaryKey(localId);
			localNome = local.getNome();
		}

		// Criar objeto incrementando um novo ID
		long eventoAgendaId = counterLocalService.increment();
		EventoAgenda eventoAgenda = eventoAgendaPersistence
				.create(eventoAgendaId);

		// Atribui novos valores
		eventoAgenda.setCompanyId(companyId);
		eventoAgenda.setGroupId(groupId);
		eventoAgenda.setCreateUserId(userIdCreate);
		eventoAgenda.setCreateDate(now);
		try {
			Date dataEvento = DateUtil.stringToDate("dd/MM/yyyy", sDataEvento);
			eventoAgenda.setDataEvento(dataEvento);
		} catch (ParseException e) {
			_log.error(e, e);
		}
		eventoAgenda.setHoraEvento(sHoraEvento);
		eventoAgenda.setQtdeVagas(qtdeVagas);
		eventoAgenda.setQtdeVagasPreenchida(0);
		eventoAgenda.setValor(valor);
		eventoAgenda.setUserResponsavelId(userResponsavelId);
		eventoAgenda.setUserResponsavelNome(userResponsavelNome);
		eventoAgenda.setEventoId(eventoId);
		eventoAgenda.setEventoNome(eventoNome);
		eventoAgenda.setLocalId(localId);
		eventoAgenda.setLocalNome(localNome);
		eventoAgenda.setClassNameId(classNameId);
		String className = PortalUtil.getClassName(classNameId);
		eventoAgenda.setClassName(className);
		eventoAgenda.setStatusDate(serviceContext.getModifiedDate(now));
		eventoAgenda.setStatusByUserId(userCreate.getUserId());
		eventoAgenda.setStatusByUserName(userCreate.getFullName());
		if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
				companyId, groupId, EventoAgenda.class.getName())) {
			eventoAgenda.setStatus(WorkflowConstants.STATUS_PENDING);
		} else {
			eventoAgenda.setStatus(WorkflowConstants.STATUS_APPROVED);
		}
		eventoAgenda.setObservacaoMap(observacaoMap);
		eventoAgenda.setVersao(Constantes.VERSAO_INICIAL);
		eventoAgenda.setGratuito(gratuito);

		eventoAgendaPersistence.update(eventoAgenda);

		// Workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId,
				userCreate.getUserId(), EventoAgenda.class.getName(),
				eventoAgendaId, eventoAgenda, serviceContext);

		return eventoAgenda;
	}

	public EventoAgenda addEventoAgenda(long companyId, long groupId,
			long userIdCreate, String sDataEvento, String sHoraEvento,
			int qtdeVagas, boolean gratuito, double valor,
			long userResponsavelId, long eventoId, long localId,
			Map<Locale, String> observacaoMap, long classNameId, long classPK,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		EventoAgenda eventoAgenda = addEventoAgenda(companyId, groupId,
				userIdCreate, sDataEvento, sHoraEvento, qtdeVagas, gratuito,
				valor, userResponsavelId, eventoId, localId, observacaoMap,
				classNameId, classPK, serviceContext);
		eventoAgenda.setClassPK(classPK);

		eventoAgendaPersistence.update(eventoAgenda);

		return eventoAgenda;
	}

	public EventoAgenda updateEventoAgenda(long eventoAgendaId, long companyId,
			long groupId, long modifiedUserId, String sDataEvento,
			String sHoraEvento, int qtdeVagas, boolean gratuito, double valor,
			long userResponsavelId, long eventoId, long localId,
			Map<Locale, String> observacaoMap, long classNameId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		Date now = new Date();

		// Recuperar evento agenda
		EventoAgenda eventoAgenda = eventoAgendaPersistence
				.fetchByPrimaryKey(eventoAgendaId);
		double versao = eventoAgenda.getVersao() + 1;

		validate(eventoAgendaId, eventoId, localId, sDataEvento, sHoraEvento,
				DateUtil.dateToString(now), modifiedUserId, qtdeVagas, versao);

		User userModified = userPersistence.findByPrimaryKey(modifiedUserId);

		// Recuperar responsável
		String userResponsavelNome = StringPool.BLANK;
		if (userResponsavelId > 0) {
			User userResponsavel = userPersistence
					.findByPrimaryKey(userResponsavelId);
			userResponsavelNome = userResponsavel.getFullName();
		}

		// Recuperar evento
		String eventoNome = StringPool.BLANK;
		if (eventoId > 0) {
			Evento evento = eventoPersistence.findByPrimaryKey(eventoId);
			eventoNome = evento.getNome(locale);
		}

		// Recuperar local
		String localNome = StringPool.BLANK;
		if (localId > 0) {
			Local local = localPersistence.findByPrimaryKey(localId);
			localNome = local.getNome();
		}

		// Atribui novos valores
		eventoAgenda.setCompanyId(companyId);
		eventoAgenda.setGroupId(groupId);
		eventoAgenda.setModifiedUserId(modifiedUserId);
		eventoAgenda.setModifiedDate(now);
		try {
			Date dataEvento = DateUtil.stringToDate("dd/MM/yyyy", sDataEvento);
			eventoAgenda.setDataEvento(dataEvento);
		} catch (ParseException e) {
			_log.error(e, e);
		}
		eventoAgenda.setHoraEvento(sHoraEvento);
		eventoAgenda.setQtdeVagas(qtdeVagas);
		eventoAgenda.setQtdeVagasPreenchida(0);
		eventoAgenda.setValor(valor);
		eventoAgenda.setUserResponsavelId(userResponsavelId);
		eventoAgenda.setUserResponsavelNome(userResponsavelNome);
		eventoAgenda.setEventoId(eventoId);
		eventoAgenda.setEventoNome(eventoNome);
		eventoAgenda.setLocalId(localId);
		eventoAgenda.setLocalNome(localNome);
		eventoAgenda.setClassNameId(classNameId);
		String className = PortalUtil.getClassName(classNameId);
		eventoAgenda.setClassName(className);
		eventoAgenda.setStatusDate(serviceContext.getModifiedDate(now));
		eventoAgenda.setStatusByUserId(userModified.getUserId());
		eventoAgenda.setStatusByUserName(userModified.getFullName());
		if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
				companyId, groupId, EventoAgenda.class.getName())) {
			eventoAgenda.setStatus(WorkflowConstants.STATUS_PENDING);
		} else {
			eventoAgenda.setStatus(WorkflowConstants.STATUS_APPROVED);
		}
		eventoAgenda.setObservacaoMap(observacaoMap);
		eventoAgenda.setVersao(versao);
		eventoAgenda.setGratuito(gratuito);

		eventoAgendaPersistence.update(eventoAgenda);

		return eventoAgenda;
	}

	public EventoAgenda updateEventoAgendaResponsavel(long eventoAgendaId,
			long modifiedUserId, long userResponsavelId, long eventoId)
			throws PortalException, SystemException {

		Date now = new Date();

		// Recuperar evento agenda
		EventoAgenda eventoAgenda = eventoAgendaPersistence
				.fetchByPrimaryKey(eventoAgendaId);
		double versao = eventoAgenda.getVersao() + 1;

		validateResponsavel(eventoAgendaId, modifiedUserId, versao);

		// Recuperar responsável
		String userResponsavelNome = StringPool.BLANK;
		if (userResponsavelId > 0) {
			User userResponsavel = userPersistence
					.findByPrimaryKey(userResponsavelId);
			userResponsavelNome = userResponsavel.getFullName();
		}

		// Atribui novos valores
		eventoAgenda.setModifiedUserId(modifiedUserId);
		eventoAgenda.setModifiedDate(now);
		eventoAgenda.setUserResponsavelId(userResponsavelId);
		eventoAgenda.setUserResponsavelNome(userResponsavelNome);

		eventoAgendaPersistence.update(eventoAgenda);

		// Atualizar responsavel pelo evento
		this.updateEventoResponsavel(eventoId, modifiedUserId,
				userResponsavelId);

		return eventoAgenda;
	}

	public EventoAgenda adicionarInscriao(long companyId, long groupId,
			long eventoAgendaId, long eventoId, long userIdCreate) throws PortalException,
			SystemException {

		// Recuperar evento agenda
		EventoAgenda eventoAgenda = eventoAgendaPersistence
				.fetchByPrimaryKey(eventoAgendaId);
		int qtdeVagasPreechida = eventoAgenda.getQtdeVagasPreenchida() + 1;

		validateInscricao(eventoAgendaId, eventoAgenda.getQtdeVagas(),
				qtdeVagasPreechida);

		eventoAgenda.setQtdeVagasPreenchida(qtdeVagasPreechida);

		eventoAgendaPersistence.update(eventoAgenda);

		EventoInscricaoLocalServiceUtil.addEventoInscricao(companyId, groupId,
				eventoAgendaId, eventoId, userIdCreate);

		return eventoAgenda;
	}

	@SystemEvent(action = SystemEventConstants.ACTION_SKIP, send = false, type = SystemEventConstants.TYPE_DELETE)
	public EventoAgenda deleteEventoAgenda(EventoAgenda eventoAgenda)
			throws SystemException {

		try {
			if (Validator.isNotNull(eventoAgenda)) {
				eventoAgendaPersistence.remove(eventoAgenda);

				// Trash
				trashEntryLocalService.deleteEntry(
						EventoAgenda.class.getName(),
						eventoAgenda.getEventoAgendaId());
			}
		} catch (PortalException e) {
			_log.error(e, e);
		}

		return eventoAgenda;
	}

	public EventoAgenda deleteEventoAgenda(long typeId) throws PortalException,
			SystemException {

		EventoAgenda type = eventoAgendaPersistence.findByPrimaryKey(typeId);

		return deleteEventoAgenda(type);
	}

	public EventoAgenda moveEventoAgendaToTrash(long userId,
			EventoAgenda eventoAgenda) throws PortalException, SystemException {

		eventoAgendaLocalService.updateStatus(userId, eventoAgenda,
				WorkflowConstants.STATUS_IN_TRASH, new ServiceContext());

		// Workflow
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				eventoAgenda.getCompanyId(), eventoAgenda.getGroupId(),
				EventoAgenda.class.getName(), eventoAgenda.getEventoAgendaId());

		return eventoAgenda;
	}

	public EventoAgenda moveEventoAgendaToTrash(long userId, long typeId)
			throws PortalException, SystemException {

		EventoAgenda type = eventoAgendaPersistence.findByPrimaryKey(typeId);

		return moveEventoAgendaToTrash(userId, type);
	}

	@Override
	public EventoAgenda restoreEventoAgendaFromTrash(long userId,
			long eventoAgendaId) throws PortalException, SystemException {

		EventoAgenda eventoAgenda = getEventoAgenda(eventoAgendaId);

		TrashEntry trashEntry = trashEntryLocalService.getEntry(
				EventoAgenda.class.getName(), eventoAgendaId);

		eventoAgendaLocalService.updateStatus(userId, eventoAgendaId,
				trashEntry.getStatus(), new ServiceContext());

		return eventoAgenda;
	}

	public EventoAgenda updateStatus(long userId, EventoAgenda eventoAgenda,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {

		// Type Task

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		int oldStatus = eventoAgenda.getStatus();

		eventoAgenda.setModifiedUserId(userId);
		eventoAgenda.setModifiedDate(serviceContext.getModifiedDate(now));
		eventoAgenda.setStatus(status);
		eventoAgenda.setStatusByUserId(user.getUserId());
		eventoAgenda.setStatusByUserName(user.getFullName());
		eventoAgenda.setStatusDate(serviceContext.getModifiedDate(now));

		eventoAgendaPersistence.update(eventoAgenda);

		// Trash

		if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
			trashEntryLocalService.deleteEntry(EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId());

			// Workflow
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					eventoAgenda.getCompanyId(), eventoAgenda.getGroupId(),
					userId, EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId(), eventoAgenda,
					serviceContext);
		}

		if (status == WorkflowConstants.STATUS_IN_TRASH) {
			int novoStatus = WorkflowConstants.STATUS_APPROVED;
			if (WorkflowDefinitionLinkLocalServiceUtil
					.hasWorkflowDefinitionLink(eventoAgenda.getCompanyId(),
							eventoAgenda.getGroupId(),
							EventoAgenda.class.getName())) {
				novoStatus = WorkflowConstants.STATUS_PENDING;
			}

			trashEntryLocalService.addTrashEntry(userId,
					eventoAgenda.getGroupId(), EventoAgenda.class.getName(),
					eventoAgenda.getEventoAgendaId(), eventoAgenda.getUuid(),
					null, novoStatus, null, null);
		}

		return eventoAgenda;
	}

	public EventoAgenda updateStatus(long userId, long eventoAgendaId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {

		EventoAgenda eventoAgenda = eventoAgendaPersistence
				.findByPrimaryKey(eventoAgendaId);

		return eventoAgendaLocalService.updateStatus(userId, eventoAgenda,
				status, serviceContext);
	}

	public List<EventoAgenda> search(long companyId, long groupId,
			int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG(companyId, groupId, status,
				start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, int[] status)
			throws SystemException {
		return eventoAgendaPersistence.findByCG(companyId, groupId, status)
				.size();
	}

	public List<EventoAgenda> searchData(long companyId, long groupId,
			Date dataEvento, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG_Data(companyId, groupId,
				dataEvento, status, start, end, orderByComparator);
	}

	public int searchDataCount(long companyId, long groupId, Date dataEvento,
			int[] status) throws SystemException {
		return eventoAgendaPersistence.findByCG_Data(companyId, groupId,
				dataEvento, status).size();
	}

	public List<EventoAgenda> searchEventoData(long companyId, long groupId,
			long eventoId, Date dataEvento, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG_Evento_Data(companyId, groupId,
				eventoId, dataEvento, status, start, end, orderByComparator);
	}

	public int searchEventoDataCount(long companyId, long groupId,
			long eventoId, Date dataEvento, int[] status)
			throws SystemException {
		return eventoAgendaPersistence.findByCG_Evento_Data(companyId, groupId,
				eventoId, dataEvento, status).size();
	}

	public List<EventoAgenda> searchEventoNome(long companyId, long groupId,
			String eventoNome, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG_EventoNome(companyId, groupId,
				eventoNome, status, start, end, orderByComparator);
	}

	public int searchEventoNomeCount(long companyId, long groupId,
			String eventoNome, int[] status) throws SystemException {
		return eventoAgendaPersistence.findByCG_EventoNome(companyId, groupId,
				eventoNome, status).size();
	}

	public List<EventoAgenda> searchEventoID(long companyId, long groupId,
			long eventoId, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG_EventoID(companyId, groupId,
				eventoId, status, start, end, orderByComparator);
	}

	public int searchEventoIDCount(long companyId, long groupId,
			long eventoId, int[] status) throws SystemException {
		return eventoAgendaPersistence.findByCG_EventoID(companyId, groupId,
				eventoId, status).size();
	}
	
	public List<EventoAgenda> searchLocalNome(long companyId, long groupId,
			String localNome, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG_LocalNome(companyId, groupId,
				localNome, status, start, end, orderByComparator);
	}

	public int searchLocalNomeCount(long companyId, long groupId,
			String localNome, int[] status) throws SystemException {
		return eventoAgendaPersistence.findByCG_LocalNome(companyId, groupId,
				localNome, status).size();
	}

	public List<EventoAgenda> searchLocalID(long companyId, long groupId,
			long localId, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return eventoAgendaPersistence.findByCG_LocalID(companyId, groupId,
				localId, status, start, end, orderByComparator);
	}

	public int searchLocalIDCount(long companyId, long groupId,
			long localId, int[] status) throws SystemException {
		return eventoAgendaPersistence.findByCG_LocalID(companyId, groupId,
				localId, status).size();
	}
	
	public List<EventoAgenda> searchResponsavelNome(long companyId,
			long groupId, String responsavelNome, int[] status, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return eventoAgendaPersistence
				.findByCG_ResponsavelNome(companyId, groupId, responsavelNome,
						status, start, end, orderByComparator);
	}

	public int searchResponsavelNomeCount(long companyId, long groupId,
			String responsavelNome, int[] status) throws SystemException {
		return eventoAgendaPersistence.findByCG_ResponsavelNome(companyId,
				groupId, responsavelNome, status).size();
	}

	private void updateEventoResponsavel(long eventoId, long modifiedUserId,
			long userResponsavelId) throws EventoNaoEncontradoException {
		try {
			Evento evento = eventoPersistence.fetchByPrimaryKey(eventoId);
			evento = EventoLocalServiceUtil.updateEventoResponsavel(
					evento.getEventoId(), modifiedUserId, userResponsavelId);
		} catch (PortalException e) {
			throw new EventoNaoEncontradoException();
		} catch (SystemException e) {
			throw new EventoNaoEncontradoException();
		}
	}

	protected void validate(long eventoAgendaId, long eventoId, long localId,
			String sDataEvento, String sHoraEvento, String sDataHoje,
			long userId, int qtdeVagas, double versao) throws PortalException,
			SystemException {

		if (eventoId == 0) {
			throw new EventoObrigatorioException();
		}
		if (localId == 0) {
			throw new EventoLocalObrigatorioException();
		}
		if (Validator.isNull(sDataEvento)) {
			throw new EventoDataObrigatoriaException();
		}
		if (sDataEvento.length() != 10) {
			throw new EventoDataObrigatoriaException();
		}
		if ((Validator.isNotNull(sDataEvento))
				&& (!DateUtil.isValidDate(sDataEvento, "dd/MM/yyyy"))) {
			throw new EventoDataInvalidaException();
		}
		if (Validator.isNotNull(sDataEvento) && Validator.isNotNull(sDataHoje)) {
			if (DateUtil.stringToDate(sDataEvento).before(
					DateUtil.stringToDate(sDataHoje))) {
				throw new EventoDataMenorHojeException();
			}
		}
		if (qtdeVagas == 0) {
			throw new EventoQtdeVagasObrigatoriaException();
		}
		if (eventoAgendaId > 0) {
			EventoAgenda eventoAgenda = eventoAgendaPersistence
					.fetchByPrimaryKey(eventoAgendaId);
			if ((Validator.isNotNull(eventoAgenda))
					&& (eventoAgenda.getVersao() > versao)) {
				throw new EventoAgendaAlteradoOutroUsuarioException();
			}
		}
	}

	protected void validateInscricao(long eventoAgendaId, int qtdeVagas,
			int qtdeVagasPreenchida) throws PortalException, SystemException {

		if (qtdeVagasPreenchida > qtdeVagas) {
			throw new EventoQtdeVagasPreenchidaException();
		}
	}

	protected void validateResponsavel(long eventoAgendaId,
			long userResponsavelId, double versao) throws PortalException,
			SystemException {

		if (eventoAgendaId == 0) {
			throw new EventoAgendaObrigatorioException();
		}
		if (userResponsavelId == 0) {
			throw new EventoResponsavelObrigatorioException();
		}
		if (eventoAgendaId > 0) {
			EventoAgenda eventoAgenda = eventoAgendaPersistence
					.fetchByPrimaryKey(eventoAgendaId);
			if ((Validator.isNotNull(eventoAgenda))
					&& (eventoAgenda.getVersao() > versao)) {
				throw new EventoAgendaAlteradoOutroUsuarioException();
			}
		}
	}
}