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

package br.com.prodevelopment.lapidarios.evento.service.persistence;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the evento agenda service. This utility wraps {@link EventoAgendaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoAgendaPersistence
 * @see EventoAgendaPersistenceImpl
 * @generated
 */
public class EventoAgendaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EventoAgenda eventoAgenda) {
		getPersistence().clearCache(eventoAgenda);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventoAgenda> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventoAgenda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventoAgenda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EventoAgenda update(EventoAgenda eventoAgenda)
		throws SystemException {
		return getPersistence().update(eventoAgenda);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EventoAgenda update(EventoAgenda eventoAgenda,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eventoAgenda, serviceContext);
	}

	/**
	* Returns all the evento agendas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the evento agendas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where uuid = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByUuid_PrevAndNext(
		long eventoAgendaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(eventoAgendaId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the evento agendas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of evento agendas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the evento agenda where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the evento agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the evento agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the evento agenda where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the evento agenda that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of evento agendas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the evento agendas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the evento agendas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByUuid_C_PrevAndNext(
		long eventoAgendaId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(eventoAgendaId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the evento agendas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of evento agendas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_First(companyId, groupId, status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_First(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Last(companyId, groupId, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Last(companyId, groupId, status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_PrevAndNext(eventoAgendaId, companyId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, statuses, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, statuses, start, end,
			orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG(companyId, groupId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data(companyId, groupId, dataEvento, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data(companyId, groupId, dataEvento, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data(companyId, groupId, dataEvento, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Data_First(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data_First(companyId, groupId, dataEvento, status,
			orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Data_First(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Data_First(companyId, groupId, dataEvento,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Data_Last(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data_Last(companyId, groupId, dataEvento, status,
			orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Data_Last(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Data_Last(companyId, groupId, dataEvento, status,
			orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_Data_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data_PrevAndNext(eventoAgendaId, companyId,
			groupId, dataEvento, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data(companyId, groupId, dataEvento, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data(companyId, groupId, dataEvento, statuses,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Data(companyId, groupId, dataEvento, statuses,
			start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_Data(long companyId, long groupId,
		java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_Data(companyId, groupId, dataEvento, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_Data(long companyId, long groupId,
		java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_Data(companyId, groupId, dataEvento, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_Data(long companyId, long groupId,
		java.util.Date dataEvento, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_Data(companyId, groupId, dataEvento, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, status, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, status, start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Evento_Data_First(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data_First(companyId, groupId, eventoId,
			dataEvento, status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Evento_Data_First(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Evento_Data_First(companyId, groupId, eventoId,
			dataEvento, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Evento_Data_Last(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data_Last(companyId, groupId, eventoId,
			dataEvento, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Evento_Data_Last(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Evento_Data_Last(companyId, groupId, eventoId,
			dataEvento, status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_Evento_Data_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long eventoId,
		java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data_PrevAndNext(eventoAgendaId, companyId,
			groupId, eventoId, dataEvento, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, statuses, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_Evento_Data(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_Evento_Data(companyId, groupId, eventoId, dataEvento,
			status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_Evento_Data(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param dataEvento the data evento
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_Evento_Data(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_Evento_Data(companyId, groupId, eventoId,
			dataEvento, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome(companyId, groupId, eventoNome, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome(companyId, groupId, eventoNome, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome(companyId, groupId, eventoNome, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoNome_First(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome_First(companyId, groupId, eventoNome,
			status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoNome_First(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_EventoNome_First(companyId, groupId, eventoNome,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoNome_Last(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome_Last(companyId, groupId, eventoNome,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoNome_Last(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_EventoNome_Last(companyId, groupId, eventoNome,
			status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_EventoNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome_PrevAndNext(eventoAgendaId, companyId,
			groupId, eventoNome, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome(companyId, groupId, eventoNome, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome(companyId, groupId, eventoNome,
			statuses, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoNome(companyId, groupId, eventoNome,
			statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_EventoNome(long companyId, long groupId,
		java.lang.String eventoNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_EventoNome(companyId, groupId, eventoNome, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_EventoNome(long companyId, long groupId,
		java.lang.String eventoNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_EventoNome(companyId, groupId, eventoNome, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_EventoNome(long companyId, long groupId,
		java.lang.String eventoNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_EventoNome(companyId, groupId, eventoNome,
			statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID(companyId, groupId, eventoId, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID(companyId, groupId, eventoId, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID(companyId, groupId, eventoId, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoID_First(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID_First(companyId, groupId, eventoId,
			status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoID_First(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_EventoID_First(companyId, groupId, eventoId,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoID_Last(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID_Last(companyId, groupId, eventoId,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoID_Last(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_EventoID_Last(companyId, groupId, eventoId,
			status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_EventoID_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long eventoId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID_PrevAndNext(eventoAgendaId, companyId,
			groupId, eventoId, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID(companyId, groupId, eventoId, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int[] statuses, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID(companyId, groupId, eventoId, statuses,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int[] statuses, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_EventoID(companyId, groupId, eventoId, statuses,
			start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_EventoID(long companyId, long groupId,
		long eventoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_EventoID(companyId, groupId, eventoId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_EventoID(long companyId, long groupId,
		long eventoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_EventoID(companyId, groupId, eventoId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_EventoID(long companyId, long groupId,
		long eventoId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_EventoID(companyId, groupId, eventoId, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome(companyId, groupId, localNome, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome(companyId, groupId, localNome, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome(companyId, groupId, localNome, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalNome_First(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome_First(companyId, groupId, localNome,
			status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalNome_First(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LocalNome_First(companyId, groupId, localNome,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalNome_Last(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome_Last(companyId, groupId, localNome,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalNome_Last(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LocalNome_Last(companyId, groupId, localNome,
			status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_LocalNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome_PrevAndNext(eventoAgendaId, companyId,
			groupId, localNome, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome(companyId, groupId, localNome, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome(companyId, groupId, localNome, statuses,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalNome(companyId, groupId, localNome, statuses,
			start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_LocalNome(long companyId, long groupId,
		java.lang.String localNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_LocalNome(companyId, groupId, localNome, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_LocalNome(long companyId, long groupId,
		java.lang.String localNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_LocalNome(companyId, groupId, localNome, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_LocalNome(long companyId, long groupId,
		java.lang.String localNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_LocalNome(companyId, groupId, localNome, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID(companyId, groupId, localId, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID(companyId, groupId, localId, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID(companyId, groupId, localId, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalID_First(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID_First(companyId, groupId, localId, status,
			orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalID_First(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LocalID_First(companyId, groupId, localId,
			status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalID_Last(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID_Last(companyId, groupId, localId, status,
			orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalID_Last(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LocalID_Last(companyId, groupId, localId, status,
			orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_LocalID_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long localId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID_PrevAndNext(eventoAgendaId, companyId,
			groupId, localId, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID(companyId, groupId, localId, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int[] statuses, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID(companyId, groupId, localId, statuses,
			start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int[] statuses, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LocalID(companyId, groupId, localId, statuses,
			start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_LocalID(long companyId, long groupId,
		long localId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_LocalID(companyId, groupId, localId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_LocalID(long companyId, long groupId,
		long localId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_LocalID(companyId, groupId, localId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_LocalID(long companyId, long groupId,
		long localId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_LocalID(companyId, groupId, localId, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status, start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome_First(companyId, groupId,
			userResponsavelNome, status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelNome_First(companyId, groupId,
			userResponsavelNome, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome_Last(companyId, groupId,
			userResponsavelNome, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelNome_Last(companyId, groupId,
			userResponsavelNome, status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_ResponsavelNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.lang.String userResponsavelNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome_PrevAndNext(eventoAgendaId,
			companyId, groupId, userResponsavelNome, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, statuses, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, statuses);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, status);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, status, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, status, start, end, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId_First(companyId, groupId,
			userResponsavelId, status, orderByComparator);
	}

	/**
	* Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelId_First(companyId, groupId,
			userResponsavelId, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId_Last(companyId, groupId,
			userResponsavelId, status, orderByComparator);
	}

	/**
	* Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelId_Last(companyId, groupId,
			userResponsavelId, status, orderByComparator);
	}

	/**
	* Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param eventoAgendaId the primary key of the current evento agenda
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_ResponsavelId_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId_PrevAndNext(eventoAgendaId,
			companyId, groupId, userResponsavelId, status, orderByComparator);
	}

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param statuses the statuses
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, statuses);
	}

	/**
	* Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @return the range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int[] statuses,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, statuses, start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param statuses the statuses
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int[] statuses,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, status);
	}

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, statuses);
	}

	/**
	* Caches the evento agenda in the entity cache if it is enabled.
	*
	* @param eventoAgenda the evento agenda
	*/
	public static void cacheResult(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda) {
		getPersistence().cacheResult(eventoAgenda);
	}

	/**
	* Caches the evento agendas in the entity cache if it is enabled.
	*
	* @param eventoAgendas the evento agendas
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> eventoAgendas) {
		getPersistence().cacheResult(eventoAgendas);
	}

	/**
	* Creates a new evento agenda with the primary key. Does not add the evento agenda to the database.
	*
	* @param eventoAgendaId the primary key for the new evento agenda
	* @return the new evento agenda
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda create(
		long eventoAgendaId) {
		return getPersistence().create(eventoAgendaId);
	}

	/**
	* Removes the evento agenda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda that was removed
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda remove(
		long eventoAgendaId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventoAgendaId);
	}

	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eventoAgenda);
	}

	/**
	* Returns the evento agenda with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException} if it could not be found.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByPrimaryKey(
		long eventoAgendaId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventoAgendaId);
	}

	/**
	* Returns the evento agenda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda, or <code>null</code> if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByPrimaryKey(
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventoAgendaId);
	}

	/**
	* Returns all the evento agendas.
	*
	* @return the evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the evento agendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evento agendas
	* @param end the upper bound of the range of evento agendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the evento agendas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of evento agendas.
	*
	* @return the number of evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EventoAgendaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EventoAgendaPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.lapidarios.evento.service.ClpSerializer.getServletContextName(),
					EventoAgendaPersistence.class.getName());

			ReferenceRegistry.registerReference(EventoAgendaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EventoAgendaPersistence persistence) {
	}

	private static EventoAgendaPersistence _persistence;
}