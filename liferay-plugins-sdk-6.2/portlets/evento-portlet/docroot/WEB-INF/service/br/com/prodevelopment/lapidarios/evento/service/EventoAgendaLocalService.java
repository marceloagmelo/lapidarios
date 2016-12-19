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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for EventoAgenda. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Marcelo Melo
 * @see EventoAgendaLocalServiceUtil
 * @see br.com.prodevelopment.lapidarios.evento.service.base.EventoAgendaLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.impl.EventoAgendaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EventoAgendaLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventoAgendaLocalServiceUtil} to access the evento agenda local service. Add custom service methods to {@link br.com.prodevelopment.lapidarios.evento.service.impl.EventoAgendaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the evento agenda to the database. Also notifies the appropriate model listeners.
	*
	* @param eventoAgenda the evento agenda
	* @return the evento agenda that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda addEventoAgenda(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new evento agenda with the primary key. Does not add the evento agenda to the database.
	*
	* @param eventoAgendaId the primary key for the new evento agenda
	* @return the new evento agenda
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda createEventoAgenda(
		long eventoAgendaId);

	/**
	* Deletes the evento agenda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda that was removed
	* @throws PortalException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda deleteEventoAgenda(
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the evento agenda from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoAgenda the evento agenda
	* @return the evento agenda that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda deleteEventoAgenda(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchEventoAgenda(
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda with the matching UUID and company.
	*
	* @param uuid the evento agenda's UUID
	* @param companyId the primary key of the company
	* @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchEventoAgendaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda matching the UUID and group.
	*
	* @param uuid the evento agenda's UUID
	* @param groupId the primary key of the group
	* @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchEventoAgendaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda with the primary key.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda
	* @throws PortalException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda getEventoAgenda(
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda with the matching UUID and company.
	*
	* @param uuid the evento agenda's UUID
	* @param companyId the primary key of the company
	* @return the matching evento agenda
	* @throws PortalException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda getEventoAgendaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda matching the UUID and group.
	*
	* @param uuid the evento agenda's UUID
	* @param groupId the primary key of the group
	* @return the matching evento agenda
	* @throws PortalException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda getEventoAgendaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento agendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of evento agendas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> getEventoAgendas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas.
	*
	* @return the number of evento agendas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventoAgendasCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the evento agenda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventoAgenda the evento agenda
	* @return the evento agenda that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateEventoAgenda(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda addEventoAgenda(
		long companyId, long groupId, long userIdCreate,
		java.lang.String sDataEvento, java.lang.String sHoraEvento,
		int qtdeVagas, boolean gratuito, double valor, long userResponsavelId,
		long eventoId, long localId,
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		long classNameId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda addEventoAgenda(
		long companyId, long groupId, long userIdCreate,
		java.lang.String sDataEvento, java.lang.String sHoraEvento,
		int qtdeVagas, boolean gratuito, double valor, long userResponsavelId,
		long eventoId, long localId,
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		long classNameId, long classPK,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateEventoAgenda(
		long eventoAgendaId, long companyId, long groupId, long modifiedUserId,
		java.lang.String sDataEvento, java.lang.String sHoraEvento,
		int qtdeVagas, boolean gratuito, double valor, long userResponsavelId,
		long eventoId, long localId,
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		long classNameId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateEventoAgendaResponsavel(
		long eventoAgendaId, long modifiedUserId, long userResponsavelId,
		long eventoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda adicionarInscriao(
		long companyId, long groupId, long eventoAgendaId, long eventoId,
		long userIdCreate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda moveEventoAgendaToTrash(
		long userId,
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda moveEventoAgendaToTrash(
		long userId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda restoreEventoAgendaFromTrash(
		long userId, long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateStatus(
		long userId,
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda,
		int status, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateStatus(
		long userId, long eventoAgendaId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> search(
		long companyId, long groupId, int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(long companyId, long groupId, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchData(
		long companyId, long groupId, java.util.Date dataEvento, int[] status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchDataCount(long companyId, long groupId,
		java.util.Date dataEvento, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchEventoData(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchEventoDataCount(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchEventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchEventoNomeCount(long companyId, long groupId,
		java.lang.String eventoNome, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchEventoID(
		long companyId, long groupId, long eventoId, int[] status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchEventoIDCount(long companyId, long groupId, long eventoId,
		int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchLocalNome(
		long companyId, long groupId, java.lang.String localNome, int[] status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchLocalNomeCount(long companyId, long groupId,
		java.lang.String localNome, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchLocalID(
		long companyId, long groupId, long localId, int[] status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchLocalIDCount(long companyId, long groupId, long localId,
		int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> searchResponsavelNome(
		long companyId, long groupId, java.lang.String responsavelNome,
		int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchResponsavelNomeCount(long companyId, long groupId,
		java.lang.String responsavelNome, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException;
}