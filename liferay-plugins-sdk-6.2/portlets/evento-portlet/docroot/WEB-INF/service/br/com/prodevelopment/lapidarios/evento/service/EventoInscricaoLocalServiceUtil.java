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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EventoInscricao. This utility wraps
 * {@link br.com.prodevelopment.lapidarios.evento.service.impl.EventoInscricaoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see EventoInscricaoLocalService
 * @see br.com.prodevelopment.lapidarios.evento.service.base.EventoInscricaoLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.impl.EventoInscricaoLocalServiceImpl
 * @generated
 */
public class EventoInscricaoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.lapidarios.evento.service.impl.EventoInscricaoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the evento inscricao to the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricao the evento inscricao
	* @return the evento inscricao that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao addEventoInscricao(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEventoInscricao(eventoInscricao);
	}

	/**
	* Creates a new evento inscricao with the primary key. Does not add the evento inscricao to the database.
	*
	* @param eventoInscricaoId the primary key for the new evento inscricao
	* @return the new evento inscricao
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao createEventoInscricao(
		long eventoInscricaoId) {
		return getService().createEventoInscricao(eventoInscricaoId);
	}

	/**
	* Deletes the evento inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao that was removed
	* @throws PortalException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao deleteEventoInscricao(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventoInscricao(eventoInscricaoId);
	}

	/**
	* Deletes the evento inscricao from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricao the evento inscricao
	* @return the evento inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao deleteEventoInscricao(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventoInscricao(eventoInscricao);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchEventoInscricao(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEventoInscricao(eventoInscricaoId);
	}

	/**
	* Returns the evento inscricao with the matching UUID and company.
	*
	* @param uuid the evento inscricao's UUID
	* @param companyId the primary key of the company
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchEventoInscricaoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchEventoInscricaoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the evento inscricao matching the UUID and group.
	*
	* @param uuid the evento inscricao's UUID
	* @param groupId the primary key of the group
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchEventoInscricaoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEventoInscricaoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the evento inscricao with the primary key.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao
	* @throws PortalException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricao(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventoInscricao(eventoInscricaoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricaoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventoInscricaoByUuidAndCompanyId(uuid, companyId);
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
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricaoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventoInscricaoByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> getEventoInscricaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventoInscricaos(start, end);
	}

	/**
	* Returns the number of evento inscricaos.
	*
	* @return the number of evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public static int getEventoInscricaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventoInscricaosCount();
	}

	/**
	* Updates the evento inscricao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricao the evento inscricao
	* @return the evento inscricao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao updateEventoInscricao(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventoInscricao(eventoInscricao);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao addEventoInscricao(
		long companyId, long groupId, long eventoAgendaId, long eventoId,
		long userIdCreate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEventoInscricao(companyId, groupId, eventoAgendaId,
			eventoId, userIdCreate);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> search(
		long companyId, long groupId, java.lang.String userNome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, userNome, start, end,
			orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String userNome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId, userNome);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> searchWithEventoAgenda(
		long companyId, long groupId, long eventoAgendaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchWithEventoAgenda(companyId, groupId, eventoAgendaId,
			start, end, orderByComparator);
	}

	public static int searchWithEventoAgendaCount(long companyId, long groupId,
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchWithEventoAgendaCount(companyId, groupId,
			eventoAgendaId);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> searchWithEvento(
		long companyId, long groupId, long eventoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchWithEvento(companyId, groupId, eventoId, start, end,
			orderByComparator);
	}

	public static int searchWithEventoCount(long companyId, long groupId,
		long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchWithEventoCount(companyId, groupId, eventoId);
	}

	public static br.com.prodevelopment.lapidarios.evento.model.EventoInscricao getEventoInscricaoWithUser(
		long eventoAgendaId, long createUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEventoInscricaoWithUser(eventoAgendaId, createUserId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventoInscricaoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventoInscricaoLocalService.class.getName());

			if (invokableLocalService instanceof EventoInscricaoLocalService) {
				_service = (EventoInscricaoLocalService)invokableLocalService;
			}
			else {
				_service = new EventoInscricaoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EventoInscricaoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EventoInscricaoLocalService service) {
	}

	private static EventoInscricaoLocalService _service;
}