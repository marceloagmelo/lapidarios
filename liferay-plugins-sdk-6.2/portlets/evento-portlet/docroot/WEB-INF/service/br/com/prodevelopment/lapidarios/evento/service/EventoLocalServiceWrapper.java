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
 * Provides a wrapper for {@link EventoLocalService}.
 *
 * @author Marcelo Melo
 * @see EventoLocalService
 * @generated
 */
public class EventoLocalServiceWrapper implements EventoLocalService,
	ServiceWrapper<EventoLocalService> {
	public EventoLocalServiceWrapper(EventoLocalService eventoLocalService) {
		_eventoLocalService = eventoLocalService;
	}

	/**
	* Adds the evento to the database. Also notifies the appropriate model listeners.
	*
	* @param evento the evento
	* @return the evento that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento addEvento(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.addEvento(evento);
	}

	/**
	* Creates a new evento with the primary key. Does not add the evento to the database.
	*
	* @param eventoId the primary key for the new evento
	* @return the new evento
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento createEvento(
		long eventoId) {
		return _eventoLocalService.createEvento(eventoId);
	}

	/**
	* Deletes the evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoId the primary key of the evento
	* @return the evento that was removed
	* @throws PortalException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento deleteEvento(
		long eventoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.deleteEvento(eventoId);
	}

	/**
	* Deletes the evento from the database. Also notifies the appropriate model listeners.
	*
	* @param evento the evento
	* @return the evento that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento deleteEvento(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.deleteEvento(evento);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventoLocalService.dynamicQuery();
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
		return _eventoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eventoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eventoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _eventoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eventoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchEvento(
		long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.fetchEvento(eventoId);
	}

	/**
	* Returns the evento with the matching UUID and company.
	*
	* @param uuid the evento's UUID
	* @param companyId the primary key of the company
	* @return the matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchEventoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.fetchEventoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the evento matching the UUID and group.
	*
	* @param uuid the evento's UUID
	* @param groupId the primary key of the group
	* @return the matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchEventoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.fetchEventoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the evento with the primary key.
	*
	* @param eventoId the primary key of the evento
	* @return the evento
	* @throws PortalException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento getEvento(
		long eventoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.getEvento(eventoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the evento with the matching UUID and company.
	*
	* @param uuid the evento's UUID
	* @param companyId the primary key of the company
	* @return the matching evento
	* @throws PortalException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento getEventoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.getEventoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the evento matching the UUID and group.
	*
	* @param uuid the evento's UUID
	* @param groupId the primary key of the group
	* @return the matching evento
	* @throws PortalException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento getEventoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.getEventoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of eventos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> getEventos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.getEventos(start, end);
	}

	/**
	* Returns the number of eventos.
	*
	* @return the number of eventos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEventosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.getEventosCount();
	}

	/**
	* Updates the evento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param evento the evento
	* @return the evento that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento updateEvento(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.updateEvento(evento);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento addEvento(
		long companyId, long groupId, long createUserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Map<java.util.Locale, java.lang.String> descricao,
		long userResponsavelId, long imagemId, long articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.addEvento(companyId, groupId, createUserId,
			nomeMap, descricao, userResponsavelId, imagemId, articleId);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento update(
		long eventoId, long companyId, long groupId, long modifieduserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Map<java.util.Locale, java.lang.String> descricao,
		long userResponsavelId, long imagemId, long articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.update(eventoId, companyId, groupId,
			modifieduserId, nomeMap, descricao, userResponsavelId, imagemId,
			articleId);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento updateEventoResponsavel(
		long eventoId, long modifiedUserId, long userResponsavelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.updateEventoResponsavel(eventoId,
			modifiedUserId, userResponsavelId);
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento deleteEvento(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.deleteEvento(evento, userId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.search(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoLocalService.searchCount(companyId, groupId, nome);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventoLocalService getWrappedEventoLocalService() {
		return _eventoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventoLocalService(
		EventoLocalService eventoLocalService) {
		_eventoLocalService = eventoLocalService;
	}

	@Override
	public EventoLocalService getWrappedService() {
		return _eventoLocalService;
	}

	@Override
	public void setWrappedService(EventoLocalService eventoLocalService) {
		_eventoLocalService = eventoLocalService;
	}

	private EventoLocalService _eventoLocalService;
}