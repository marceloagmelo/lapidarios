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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoPersistenceImpl
 * @see EventoUtil
 * @generated
 */
public interface EventoPersistence extends BasePersistence<Evento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventoUtil} to access the evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the eventos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento[] findByUuid_PrevAndNext(
		long eventoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the evento where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the evento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eventos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento[] findByUuid_C_PrevAndNext(
		long eventoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento, or <code>null</code> if a matching evento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_PrevAndNext(
		long eventoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_Nome(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_Nome(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_Nome(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_Nome_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_Nome_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_Nome_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_Nome_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_Nome_PrevAndNext(
		long eventoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_Nome(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_Nome(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_ResponsavelId_PrevAndNext(
		long eventoId, long companyId, long groupId, long userResponsavelId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @return the matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.Evento[] findByCG_ResponsavelNome_PrevAndNext(
		long eventoId, long companyId, long groupId,
		java.lang.String userResponsavelNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @return the number of matching eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the evento in the entity cache if it is enabled.
	*
	* @param evento the evento
	*/
	public void cacheResult(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento);

	/**
	* Caches the eventos in the entity cache if it is enabled.
	*
	* @param eventos the eventos
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> eventos);

	/**
	* Creates a new evento with the primary key. Does not add the evento to the database.
	*
	* @param eventoId the primary key for the new evento
	* @return the new evento
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento create(
		long eventoId);

	/**
	* Removes the evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoId the primary key of the evento
	* @return the evento that was removed
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento remove(
		long eventoId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.Evento updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoException} if it could not be found.
	*
	* @param eventoId the primary key of the evento
	* @return the evento
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento findByPrimaryKey(
		long eventoId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventoId the primary key of the evento
	* @return the evento, or <code>null</code> if a evento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.Evento fetchByPrimaryKey(
		long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eventos.
	*
	* @return the eventos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.Evento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eventos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eventos.
	*
	* @return the number of eventos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}