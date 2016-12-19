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
 * Provides a wrapper for {@link EventoInscricaoLocalService}.
 *
 * @author Marcelo Melo
 * @see EventoInscricaoLocalService
 * @generated
 */
public class EventoInscricaoLocalServiceWrapper
	implements EventoInscricaoLocalService,
		ServiceWrapper<EventoInscricaoLocalService> {
	public EventoInscricaoLocalServiceWrapper(
		EventoInscricaoLocalService eventoInscricaoLocalService) {
		_eventoInscricaoLocalService = eventoInscricaoLocalService;
	}

	/**
	* Adds the evento inscricao to the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricao the evento inscricao
	* @return the evento inscricao that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao addEventoInscricao(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.addEventoInscricao(eventoInscricao);
	}

	/**
	* Creates a new evento inscricao with the primary key. Does not add the evento inscricao to the database.
	*
	* @param eventoInscricaoId the primary key for the new evento inscricao
	* @return the new evento inscricao
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao createEventoInscricao(
		long eventoInscricaoId) {
		return _eventoInscricaoLocalService.createEventoInscricao(eventoInscricaoId);
	}

	/**
	* Deletes the evento inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao that was removed
	* @throws PortalException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao deleteEventoInscricao(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.deleteEventoInscricao(eventoInscricaoId);
	}

	/**
	* Deletes the evento inscricao from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricao the evento inscricao
	* @return the evento inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao deleteEventoInscricao(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.deleteEventoInscricao(eventoInscricao);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventoInscricaoLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchEventoInscricao(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.fetchEventoInscricao(eventoInscricaoId);
	}

	/**
	* Returns the evento inscricao with the matching UUID and company.
	*
	* @param uuid the evento inscricao's UUID
	* @param companyId the primary key of the company
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchEventoInscricaoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.fetchEventoInscricaoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the evento inscricao matching the UUID and group.
	*
	* @param uuid the evento inscricao's UUID
	* @param groupId the primary key of the group
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchEventoInscricaoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.fetchEventoInscricaoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the evento inscricao with the primary key.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao
	* @throws PortalException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricao(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getEventoInscricao(eventoInscricaoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the evento inscricao with the matching UUID and company.
	*
	* @param uuid the evento inscricao's UUID
	* @param companyId the primary key of the company
	* @return the matching evento inscricao
	* @throws PortalException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricaoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getEventoInscricaoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the evento inscricao matching the UUID and group.
	*
	* @param uuid the evento inscricao's UUID
	* @param groupId the primary key of the group
	* @return the matching evento inscricao
	* @throws PortalException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricaoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getEventoInscricaoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the evento inscricaos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> getEventoInscricaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getEventoInscricaos(start, end);
	}

	/**
	* Returns the number of evento inscricaos.
	*
	* @return the number of evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEventoInscricaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getEventoInscricaosCount();
	}

	/**
	* Updates the evento inscricao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricao the evento inscricao
	* @return the evento inscricao that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao updateEventoInscricao(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.updateEventoInscricao(eventoInscricao);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventoInscricaoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventoInscricaoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventoInscricaoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao addEventoInscricao(
		long companyId, long groupId, long eventoAgendaId, long eventoId,
		long userIdCreate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.addEventoInscricao(companyId,
			groupId, eventoAgendaId, eventoId, userIdCreate);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> search(
		long companyId, long groupId, java.lang.String userNome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.search(companyId, groupId,
			userNome, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId,
		java.lang.String userNome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.searchCount(companyId, groupId,
			userNome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> searchWithEventoAgenda(
		long companyId, long groupId, long eventoAgendaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.searchWithEventoAgenda(companyId,
			groupId, eventoAgendaId, start, end, orderByComparator);
	}

	@Override
	public int searchWithEventoAgendaCount(long companyId, long groupId,
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.searchWithEventoAgendaCount(companyId,
			groupId, eventoAgendaId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> searchWithEvento(
		long companyId, long groupId, long eventoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.searchWithEvento(companyId,
			groupId, eventoId, start, end, orderByComparator);
	}

	@Override
	public int searchWithEventoCount(long companyId, long groupId, long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.searchWithEventoCount(companyId,
			groupId, eventoId);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricaoWithUser(
		long eventoAgendaId, long createUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricaoLocalService.getEventoInscricaoWithUser(eventoAgendaId,
			createUserId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventoInscricaoLocalService getWrappedEventoInscricaoLocalService() {
		return _eventoInscricaoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventoInscricaoLocalService(
		EventoInscricaoLocalService eventoInscricaoLocalService) {
		_eventoInscricaoLocalService = eventoInscricaoLocalService;
	}

	@Override
	public EventoInscricaoLocalService getWrappedService() {
		return _eventoInscricaoLocalService;
	}

	@Override
	public void setWrappedService(
		EventoInscricaoLocalService eventoInscricaoLocalService) {
		_eventoInscricaoLocalService = eventoInscricaoLocalService;
	}

	private EventoInscricaoLocalService _eventoInscricaoLocalService;
}