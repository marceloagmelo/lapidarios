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
 * Provides the local service interface for EventoNaoInscrito. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Marcelo Melo
 * @see EventoNaoInscritoLocalServiceUtil
 * @see br.com.prodevelopment.lapidarios.evento.service.base.EventoNaoInscritoLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.impl.EventoNaoInscritoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EventoNaoInscritoLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventoNaoInscritoLocalServiceUtil} to access the evento nao inscrito local service. Add custom service methods to {@link br.com.prodevelopment.lapidarios.evento.service.impl.EventoNaoInscritoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the evento nao inscrito to the database. Also notifies the appropriate model listeners.
	*
	* @param eventoNaoInscrito the evento nao inscrito
	* @return the evento nao inscrito that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito addEventoNaoInscrito(
		br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito eventoNaoInscrito)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new evento nao inscrito with the primary key. Does not add the evento nao inscrito to the database.
	*
	* @param eventoNaoInscritoId the primary key for the new evento nao inscrito
	* @return the new evento nao inscrito
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito createEventoNaoInscrito(
		long eventoNaoInscritoId);

	/**
	* Deletes the evento nao inscrito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoNaoInscritoId the primary key of the evento nao inscrito
	* @return the evento nao inscrito that was removed
	* @throws PortalException if a evento nao inscrito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito deleteEventoNaoInscrito(
		long eventoNaoInscritoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the evento nao inscrito from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoNaoInscrito the evento nao inscrito
	* @return the evento nao inscrito that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito deleteEventoNaoInscrito(
		br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito eventoNaoInscrito)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito fetchEventoNaoInscrito(
		long eventoNaoInscritoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento nao inscrito with the matching UUID and company.
	*
	* @param uuid the evento nao inscrito's UUID
	* @param companyId the primary key of the company
	* @return the matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito fetchEventoNaoInscritoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento nao inscrito matching the UUID and group.
	*
	* @param uuid the evento nao inscrito's UUID
	* @param groupId the primary key of the group
	* @return the matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito fetchEventoNaoInscritoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento nao inscrito with the primary key.
	*
	* @param eventoNaoInscritoId the primary key of the evento nao inscrito
	* @return the evento nao inscrito
	* @throws PortalException if a evento nao inscrito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito getEventoNaoInscrito(
		long eventoNaoInscritoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento nao inscrito with the matching UUID and company.
	*
	* @param uuid the evento nao inscrito's UUID
	* @param companyId the primary key of the company
	* @return the matching evento nao inscrito
	* @throws PortalException if a matching evento nao inscrito could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito getEventoNaoInscritoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento nao inscrito matching the UUID and group.
	*
	* @param uuid the evento nao inscrito's UUID
	* @param groupId the primary key of the group
	* @return the matching evento nao inscrito
	* @throws PortalException if a matching evento nao inscrito could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito getEventoNaoInscritoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento nao inscritos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evento nao inscritos
	* @param end the upper bound of the range of evento nao inscritos (not inclusive)
	* @return the range of evento nao inscritos
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito> getEventoNaoInscritos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento nao inscritos.
	*
	* @return the number of evento nao inscritos
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventoNaoInscritosCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the evento nao inscrito in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventoNaoInscrito the evento nao inscrito
	* @return the evento nao inscrito that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito updateEventoNaoInscrito(
		br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito eventoNaoInscrito)
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

	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito addEventoNaoInscrito(
		long companyId, long groupId, long eventoAgendaId, long eventoId,
		long userIdCreate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito> search(
		long companyId, long groupId, java.lang.String userNome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(long companyId, long groupId,
		java.lang.String userNome)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito> searchWithEventoAgenda(
		long companyId, long groupId, long eventoAgendaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchWithEventoAgendaCount(long companyId, long groupId,
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito> searchWithEvento(
		long companyId, long groupId, long eventoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchWithEventoCount(long companyId, long groupId, long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito getEventoNaoInscritoWithUser(
		long eventoAgendaId, long createUserId)
		throws com.liferay.portal.kernel.exception.SystemException;
}