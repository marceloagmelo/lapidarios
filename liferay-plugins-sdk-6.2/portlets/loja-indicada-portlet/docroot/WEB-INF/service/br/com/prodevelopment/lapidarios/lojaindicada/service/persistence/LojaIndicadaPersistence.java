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

package br.com.prodevelopment.lapidarios.lojaindicada.service.persistence;

import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the loja indicada service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaIndicadaPersistenceImpl
 * @see LojaIndicadaUtil
 * @generated
 */
public interface LojaIndicadaPersistence extends BasePersistence<LojaIndicada> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LojaIndicadaUtil} to access the loja indicada persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the loja indicadas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loja indicadas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @return the range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loja indicadas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicadas before and after the current loja indicada in the ordered set where uuid = &#63;.
	*
	* @param lojaIndicadaId the primary key of the current loja indicada
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByUuid_PrevAndNext(
		long lojaIndicadaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loja indicadas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loja indicada where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the loja indicada that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loja indicadas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loja indicadas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @return the range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loja indicadas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicadas before and after the current loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param lojaIndicadaId the primary key of the current loja indicada
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByUuid_C_PrevAndNext(
		long lojaIndicadaId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loja indicadas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loja indicadas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loja indicadas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @return the range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loja indicadas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicadas before and after the current loja indicada in the ordered set where companyId = &#63;.
	*
	* @param lojaIndicadaId the primary key of the current loja indicada
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByCompany_PrevAndNext(
		long lojaIndicadaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loja indicadas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loja indicadas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loja indicadas where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @return the range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loja indicadas where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicadas before and after the current loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param lojaIndicadaId the primary key of the current loja indicada
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByCG_PrevAndNext(
		long lojaIndicadaId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loja indicadas where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG_IdLoja(
		long companyId, long groupId, java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @return the range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG_IdLoja(
		long companyId, long groupId, java.lang.String idLoja, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG_IdLoja(
		long companyId, long groupId, java.lang.String idLoja, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_IdLoja_First(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_IdLoja_First(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_IdLoja_Last(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_IdLoja_Last(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicadas before and after the current loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param lojaIndicadaId the primary key of the current loja indicada
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByCG_IdLoja_PrevAndNext(
		long lojaIndicadaId, long companyId, long groupId,
		java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_IdLoja(long companyId, long groupId,
		java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_IdLoja(long companyId, long groupId,
		java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the loja indicada that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada removeByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_lojaIndicadaAtual(long companyId, long groupId,
		java.lang.Boolean lojaIndicadaAtual)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the loja indicada in the entity cache if it is enabled.
	*
	* @param lojaIndicada the loja indicada
	*/
	public void cacheResult(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada);

	/**
	* Caches the loja indicadas in the entity cache if it is enabled.
	*
	* @param lojaIndicadas the loja indicadas
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> lojaIndicadas);

	/**
	* Creates a new loja indicada with the primary key. Does not add the loja indicada to the database.
	*
	* @param lojaIndicadaId the primary key for the new loja indicada
	* @return the new loja indicada
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada create(
		long lojaIndicadaId);

	/**
	* Removes the loja indicada with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada that was removed
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada remove(
		long lojaIndicadaId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada updateImpl(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada with the primary key or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByPrimaryKey(
		long lojaIndicadaId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja indicada with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada, or <code>null</code> if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByPrimaryKey(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loja indicadas.
	*
	* @return the loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loja indicadas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @return the range of loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loja indicadas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loja indicadas
	* @param end the upper bound of the range of loja indicadas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loja indicadas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loja indicadas.
	*
	* @return the number of loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}