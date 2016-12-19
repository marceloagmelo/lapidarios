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

import br.com.prodevelopment.lapidarios.evento.model.EventoInscricao;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the evento inscricao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoInscricaoPersistenceImpl
 * @see EventoInscricaoUtil
 * @generated
 */
public interface EventoInscricaoPersistence extends BasePersistence<EventoInscricao> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventoInscricaoUtil} to access the evento inscricao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the evento inscricaos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento inscricaos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricaos before and after the current evento inscricao in the ordered set where uuid = &#63;.
	*
	* @param eventoInscricaoId the primary key of the current evento inscricao
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao[] findByUuid_PrevAndNext(
		long eventoInscricaoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the evento inscricao where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the evento inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento inscricaos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento inscricaos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricaos before and after the current evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param eventoInscricaoId the primary key of the current evento inscricao
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao[] findByUuid_C_PrevAndNext(
		long eventoInscricaoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param eventoInscricaoId the primary key of the current evento inscricao
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao[] findByCG_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @return the matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_EventoAgenda(
		long companyId, long groupId, long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_EventoAgenda(
		long companyId, long groupId, long eventoAgendaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_EventoAgenda(
		long companyId, long groupId, long eventoAgendaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_EventoAgenda_First(
		long companyId, long groupId, long eventoAgendaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_EventoAgenda_First(
		long companyId, long groupId, long eventoAgendaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_EventoAgenda_Last(
		long companyId, long groupId, long eventoAgendaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_EventoAgenda_Last(
		long companyId, long groupId, long eventoAgendaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param eventoInscricaoId the primary key of the current evento inscricao
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao[] findByCG_EventoAgenda_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId,
		long eventoAgendaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_EventoAgenda(long companyId, long groupId,
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoAgendaId the evento agenda ID
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_EventoAgenda(long companyId, long groupId,
		long eventoAgendaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @return the matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_Evento(
		long companyId, long groupId, long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_Evento(
		long companyId, long groupId, long eventoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_Evento(
		long companyId, long groupId, long eventoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_Evento_First(
		long companyId, long groupId, long eventoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_Evento_First(
		long companyId, long groupId, long eventoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_Evento_Last(
		long companyId, long groupId, long eventoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_Evento_Last(
		long companyId, long groupId, long eventoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param eventoInscricaoId the primary key of the current evento inscricao
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao[] findByCG_Evento_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId, long eventoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_Evento(long companyId, long groupId, long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param eventoId the evento ID
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_Evento(long companyId, long groupId, long eventoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @return the matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_Usuario(
		long companyId, long groupId, java.lang.String userNome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @return the range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_Usuario(
		long companyId, long groupId, java.lang.String userNome, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findByCG_Usuario(
		long companyId, long groupId, java.lang.String userNome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_Usuario_First(
		long companyId, long groupId, java.lang.String userNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_Usuario_First(
		long companyId, long groupId, java.lang.String userNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByCG_Usuario_Last(
		long companyId, long groupId, java.lang.String userNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByCG_Usuario_Last(
		long companyId, long groupId, java.lang.String userNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param eventoInscricaoId the primary key of the current evento inscricao
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao[] findByCG_Usuario_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId,
		java.lang.String userNome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_Usuario(long companyId, long groupId,
		java.lang.String userNome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userNome the user nome
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_Usuario(long companyId, long groupId,
		java.lang.String userNome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException} if it could not be found.
	*
	* @param eventoAgendaId the evento agenda ID
	* @param createUserId the create user ID
	* @return the matching evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByEventoAgendaUsuario(
		long eventoAgendaId, long createUserId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eventoAgendaId the evento agenda ID
	* @param createUserId the create user ID
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByEventoAgendaUsuario(
		long eventoAgendaId, long createUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eventoAgendaId the evento agenda ID
	* @param createUserId the create user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByEventoAgendaUsuario(
		long eventoAgendaId, long createUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; from the database.
	*
	* @param eventoAgendaId the evento agenda ID
	* @param createUserId the create user ID
	* @return the evento inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao removeByEventoAgendaUsuario(
		long eventoAgendaId, long createUserId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos where eventoAgendaId = &#63; and createUserId = &#63;.
	*
	* @param eventoAgendaId the evento agenda ID
	* @param createUserId the create user ID
	* @return the number of matching evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventoAgendaUsuario(long eventoAgendaId, long createUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the evento inscricao in the entity cache if it is enabled.
	*
	* @param eventoInscricao the evento inscricao
	*/
	public void cacheResult(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao);

	/**
	* Caches the evento inscricaos in the entity cache if it is enabled.
	*
	* @param eventoInscricaos the evento inscricaos
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> eventoInscricaos);

	/**
	* Creates a new evento inscricao with the primary key. Does not add the evento inscricao to the database.
	*
	* @param eventoInscricaoId the primary key for the new evento inscricao
	* @return the new evento inscricao
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao create(
		long eventoInscricaoId);

	/**
	* Removes the evento inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao that was removed
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao remove(
		long eventoInscricaoId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException} if it could not be found.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao
	* @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao findByPrimaryKey(
		long eventoInscricaoId)
		throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evento inscricao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventoInscricaoId the primary key of the evento inscricao
	* @return the evento inscricao, or <code>null</code> if a evento inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao fetchByPrimaryKey(
		long eventoInscricaoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evento inscricaos.
	*
	* @return the evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the evento inscricaos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evento inscricaos
	* @param end the upper bound of the range of evento inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evento inscricaos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evento inscricaos.
	*
	* @return the number of evento inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}