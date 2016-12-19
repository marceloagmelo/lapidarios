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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the evento agenda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoAgendaPersistenceImpl
 * @see EventoAgendaUtil
 * @generated
 */
public interface EventoAgendaPersistence extends BasePersistence<EventoAgenda> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventoAgendaUtil} to access the evento agenda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the evento agendas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByUuid_PrevAndNext(
		long eventoAgendaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the evento agenda where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the evento agenda that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento agendas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByUuid_C_PrevAndNext(
		long eventoAgendaId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG(
		long companyId, long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @return the number of matching evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Data_First(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Data_First(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Data_Last(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Data_Last(
		long companyId, long groupId, java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_Data_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Data(
		long companyId, long groupId, java.util.Date dataEvento,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataEvento the data evento
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_Data(long companyId, long groupId,
		java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_Data(long companyId, long groupId,
		java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_Data(long companyId, long groupId,
		java.util.Date dataEvento, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Evento_Data_First(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Evento_Data_First(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_Evento_Data_Last(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_Evento_Data_Last(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_Evento_Data_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long eventoId,
		java.util.Date dataEvento, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_Evento_Data(
		long companyId, long groupId, long eventoId, java.util.Date dataEvento,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByCG_Evento_Data(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_Evento_Data(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_Evento_Data(long companyId, long groupId,
		long eventoId, java.util.Date dataEvento, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoNome_First(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoNome_First(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoNome_Last(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoNome_Last(
		long companyId, long groupId, java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_EventoNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.lang.String eventoNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoNome(
		long companyId, long groupId, java.lang.String eventoNome,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoNome the evento nome
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_EventoNome(long companyId, long groupId,
		java.lang.String eventoNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_EventoNome(long companyId, long groupId,
		java.lang.String eventoNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_EventoNome(long companyId, long groupId,
		java.lang.String eventoNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoID_First(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoID_First(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_EventoID_Last(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_EventoID_Last(
		long companyId, long groupId, long eventoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_EventoID_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long eventoId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int[] statuses, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_EventoID(
		long companyId, long groupId, long eventoId, int[] statuses, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_EventoID(long companyId, long groupId,
		long eventoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_EventoID(long companyId, long groupId, long eventoId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_EventoID(long companyId, long groupId, long eventoId,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalNome_First(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalNome_First(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalNome_Last(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalNome_Last(
		long companyId, long groupId, java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_LocalNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.lang.String localNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalNome(
		long companyId, long groupId, java.lang.String localNome,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localNome the local nome
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_LocalNome(long companyId, long groupId,
		java.lang.String localNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_LocalNome(long companyId, long groupId,
		java.lang.String localNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_LocalNome(long companyId, long groupId,
		java.lang.String localNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalID_First(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalID_First(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_LocalID_Last(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_LocalID_Last(
		long companyId, long groupId, long localId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_LocalID_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long localId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int[] statuses, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_LocalID(
		long companyId, long groupId, long localId, int[] statuses, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param localId the local ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_LocalID(long companyId, long groupId, long localId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_LocalID(long companyId, long groupId, long localId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_LocalID(long companyId, long groupId, long localId,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelNome_First(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelNome_Last(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_ResponsavelNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		java.lang.String userResponsavelNome, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelNome(
		long companyId, long groupId, java.lang.String userResponsavelNome,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelNome the user responsavel nome
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_ResponsavelNome(long companyId, long groupId,
		java.lang.String userResponsavelNome, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelId_First(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByCG_ResponsavelId_Last(
		long companyId, long groupId, long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda[] findByCG_ResponsavelId_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		long userResponsavelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int[] statuses,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findByCG_ResponsavelId(
		long companyId, long groupId, long userResponsavelId, int[] statuses,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userResponsavelId the user responsavel ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the evento agenda in the entity cache if it is enabled.
	*
	* @param eventoAgenda the evento agenda
	*/
	public void cacheResult(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda);

	/**
	* Caches the evento agendas in the entity cache if it is enabled.
	*
	* @param eventoAgendas the evento agendas
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> eventoAgendas);

	/**
	* Creates a new evento agenda with the primary key. Does not add the evento agenda to the database.
	*
	* @param eventoAgendaId the primary key for the new evento agenda
	* @return the new evento agenda
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda create(
		long eventoAgendaId);

	/**
	* Removes the evento agenda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda that was removed
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda remove(
		long eventoAgendaId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException} if it could not be found.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda findByPrimaryKey(
		long eventoAgendaId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento agenda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventoAgendaId the primary key of the evento agenda
	* @return the evento agenda, or <code>null</code> if a evento agenda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda fetchByPrimaryKey(
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento agendas.
	*
	* @return the evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento agendas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento agendas.
	*
	* @return the number of evento agendas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}