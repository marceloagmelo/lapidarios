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

import br.com.prodevelopment.lapidarios.evento.model.Evento;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the evento service. This utility wraps {@link EventoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoPersistence
 * @see EventoPersistenceImpl
 * @generated
 */
public class EventoUtil {
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
	public static void clearCache(Evento evento) {
		getPersistence().clearCache(evento);
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
	public static List<Evento> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Evento> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Evento> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Evento update(Evento evento) throws SystemException {
		return getPersistence().update(evento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Evento update(Evento evento, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(evento, serviceContext);
	}

	/**
	* Returns all the eventos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the eventos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the eventos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the eventos before and after the current evento in the ordered set where uuid = &#63;.
	*
	* @param eventoId the primary key of the current evento
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento[] findByUuid_PrevAndNext(
		long eventoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(eventoId, uuid, orderByComparator);
	}

	/**
	* Removes all the eventos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of eventos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the evento where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the evento where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the evento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of eventos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the eventos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the eventos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the eventos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the eventos before and after the current evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param eventoId the primary key of the current evento
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento[] findByUuid_C_PrevAndNext(
		long eventoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(eventoId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the eventos where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of eventos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId);
	}

	/**
	* Returns a range of all the eventos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param eventoId the primary key of the current evento
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_PrevAndNext(
		long eventoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_PrevAndNext(eventoId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG(companyId, groupId);
	}

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId);
	}

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_Nome(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_Nome(companyId, groupId, nome);
	}

	/**
	* Returns a range of all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_Nome(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Nome(companyId, groupId, nome, start, end);
	}

	/**
	* Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_Nome(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Nome(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_Nome_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Nome_First(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_Nome_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Nome_First(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_Nome_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Nome_Last(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_Nome_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Nome_Last(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param eventoId the primary key of the current evento
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_Nome_PrevAndNext(
		long eventoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Nome_PrevAndNext(eventoId, companyId, groupId,
			nome, orderByComparator);
	}

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_Nome(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_Nome(companyId, groupId, nome);
	}

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_Nome(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_Nome(companyId, groupId, nome);
	}

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId, userResponsavelId);
	}

	/**
	* Returns a range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, start, end);
	}

	/**
	* Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId(companyId, groupId,
			userResponsavelId, start, end, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId_First(companyId, groupId,
			userResponsavelId, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelId_First(companyId, groupId,
			userResponsavelId, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId_Last(companyId, groupId,
			userResponsavelId, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelId_Last(companyId, groupId,
			userResponsavelId, orderByComparator);
	}

	/**
	* Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param eventoId the primary key of the current evento
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_ResponsavelId_PrevAndNext(
		long eventoId, long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelId_PrevAndNext(eventoId, companyId,
			groupId, userResponsavelId, orderByComparator);
	}

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_ResponsavelId(companyId, groupId, userResponsavelId);
	}

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ResponsavelId(companyId, groupId,
			userResponsavelId);
	}

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome);
	}

	/**
	* Returns a range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @return the range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, start, end);
	}

	/**
	* Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, start, end, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome_First(companyId, groupId,
			userResponsavelNome, orderByComparator);
	}

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelNome_First(companyId, groupId,
			userResponsavelNome, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome_Last(companyId, groupId,
			userResponsavelNome, orderByComparator);
	}

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ResponsavelNome_Last(companyId, groupId,
			userResponsavelNome, orderByComparator);
	}

	/**
	* Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param eventoId the primary key of the current evento
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_ResponsavelNome_PrevAndNext(
		long eventoId, long companyId, long groupId,
		java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ResponsavelNome_PrevAndNext(eventoId, companyId,
			groupId, userResponsavelNome, orderByComparator);
	}

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_ResponsavelNome(companyId, groupId, userResponsavelNome);
	}

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome);
	}

	/**
	* Caches the evento in the entity cache if it is enabled.
	*
	* @param evento the evento
	*/
	public static void cacheResult(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento) {
		getPersistence().cacheResult(evento);
	}

	/**
	* Caches the eventos in the entity cache if it is enabled.
	*
	* @param eventos the eventos
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> eventos) {
		getPersistence().cacheResult(eventos);
	}

	/**
	* Creates a new evento with the primary key. Does not add the evento to the database.
	*
	* @param eventoId the primary key for the new evento
	* @return the new evento
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento create(
		long eventoId) {
		return getPersistence().create(eventoId);
	}

	/**
	* Removes the evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoId the primary key of the evento
	* @return the evento that was removed
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento remove(
		long eventoId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventoId);
	}

	public static br.com.prodevelopment.lapidarios.evento.model.Evento updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(evento);
	}

	/**
	* Returns the evento with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoException} if it could not be found.
	*
	* @param eventoId the primary key of the evento
	* @return the evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento findByPrimaryKey(
		long eventoId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventoId);
	}

	/**
	* Returns the evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventoId the primary key of the evento
	* @return the evento, or <code>null</code> if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Evento fetchByPrimaryKey(
		long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventoId);
	}

	/**
	* Returns all the eventos.
	*
	* @return the eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eventos
	* @param end the upper bound of the range of eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eventos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the eventos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eventos.
	*
	* @return the number of eventos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EventoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EventoPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.lapidarios.evento.service.ClpSerializer.getServletContextName(),
					EventoPersistence.class.getName());

			ReferenceRegistry.registerReference(EventoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EventoPersistence persistence) {
	}

	private static EventoPersistence _persistence;
}