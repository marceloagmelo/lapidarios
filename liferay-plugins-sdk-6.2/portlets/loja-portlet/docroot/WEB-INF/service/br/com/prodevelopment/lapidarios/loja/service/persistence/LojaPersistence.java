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

package br.com.prodevelopment.lapidarios.loja.service.persistence;

import br.com.prodevelopment.lapidarios.loja.model.Loja;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the loja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaPersistenceImpl
 * @see LojaUtil
 * @generated
 */
public interface LojaPersistence extends BasePersistence<Loja> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LojaUtil} to access the loja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lojas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where uuid = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByUuid_PrevAndNext(
		long lojaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loja where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByUuid_C_PrevAndNext(
		long lojaId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCompany_PrevAndNext(
		long lojaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_PrevAndNext(
		long lojaId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByRazaoSocial(
		java.lang.String razaoSocial)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where razaoSocial LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param razaoSocial the razao social
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByRazaoSocial(
		java.lang.String razaoSocial, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where razaoSocial LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param razaoSocial the razao social
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByRazaoSocial(
		java.lang.String razaoSocial, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByRazaoSocial_First(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByRazaoSocial_First(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByRazaoSocial_Last(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByRazaoSocial_Last(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByRazaoSocial_PrevAndNext(
		long lojaId, java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where razaoSocial LIKE &#63; from the database.
	*
	* @param razaoSocial the razao social
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRazaoSocial(java.lang.String razaoSocial)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByRazaoSocial(java.lang.String razaoSocial)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_RazaoSocial_First(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_RazaoSocial_First(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_RazaoSocial_Last(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_RazaoSocial_Last(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_RazaoSocial_PrevAndNext(
		long lojaId, long companyId, long groupId,
		java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param statuses the statuses
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_RazaoSocial(long companyId, long groupId,
		java.lang.String razaoSocial, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_RazaoSocial(long companyId, long groupId,
		java.lang.String razaoSocial, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_RazaoSocial(long companyId, long groupId,
		java.lang.String razaoSocial, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByNomeFantasia(
		java.lang.String nomeFantasia)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where nomeFantasia LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nomeFantasia the nome fantasia
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByNomeFantasia(
		java.lang.String nomeFantasia, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where nomeFantasia LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nomeFantasia the nome fantasia
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByNomeFantasia(
		java.lang.String nomeFantasia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByNomeFantasia_First(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByNomeFantasia_First(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByNomeFantasia_Last(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByNomeFantasia_Last(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByNomeFantasia_PrevAndNext(
		long lojaId, java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where nomeFantasia LIKE &#63; from the database.
	*
	* @param nomeFantasia the nome fantasia
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNomeFantasia(java.lang.String nomeFantasia)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByNomeFantasia(java.lang.String nomeFantasia)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_NomeFantasia_First(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_NomeFantasia_First(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_NomeFantasia_Last(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_NomeFantasia_Last(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_NomeFantasia_PrevAndNext(
		long lojaId, long companyId, long groupId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_NomeFantasia(long companyId, long groupId,
		java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_NomeFantasia(long companyId, long groupId,
		java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_NomeFantasia(long companyId, long groupId,
		java.lang.String nomeFantasia, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where cnpj = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param cnpj the cnpj
	* @return the matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCNPJ(
		java.lang.String cnpj)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where cnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cnpj the cnpj
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCNPJ(
		java.lang.String cnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where cnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cnpj the cnpj
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCNPJ(
		java.lang.String cnpj, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loja where cnpj = &#63; from the database.
	*
	* @param cnpj the cnpj
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja removeByCNPJ(
		java.lang.String cnpj)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where cnpj = &#63;.
	*
	* @param cnpj the cnpj
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCNPJ(java.lang.String cnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cnpj the cnpj
	* @param status the status
	* @return the matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cnpj the cnpj
	* @param status the status
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cnpj the cnpj
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cnpj the cnpj
	* @param status the status
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja removeByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cnpj the cnpj
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_CNPJ(long companyId, long groupId,
		java.lang.String cnpj, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cnpj the cnpj
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_CNPJ(long companyId, long groupId,
		java.lang.String cnpj, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_OrdemIndicada_First(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicada_First(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_OrdemIndicada_Last(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicada_Last(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_OrdemIndicada_PrevAndNext(
		long lojaId, long companyId, long groupId, int ordemIndicada,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param statuses the statuses
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int[] statuses,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int[] statuses,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicadaAtual the ordem indicada atual
	* @param status the status
	* @return the matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicadaAtual the ordem indicada atual
	* @param status the status
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicadaAtual the ordem indicada atual
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicadaAtual the ordem indicada atual
	* @param status the status
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja removeByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicadaAtual the ordem indicada atual
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicadaAtual the ordem indicada atual
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassName_First(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassName_First(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassName_Last(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassName_Last(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_ClassName_PrevAndNext(
		long lojaId, long companyId, long groupId, long classNameId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param statuses the statuses
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int[] statuses,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int[] statuses,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_ClassName(long companyId, long groupId,
		long classNameId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_ClassName(long companyId, long groupId,
		long classNameId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_ClassName(long companyId, long groupId,
		long classNameId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassNameNomeFantasia_First(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassNameNomeFantasia_First(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassNameNomeFantasia_Last(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassNameNomeFantasia_Last(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param lojaId the primary key of the current loja
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_ClassNameNomeFantasia_PrevAndNext(
		long lojaId, long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_ClassNameNomeFantasia(long companyId, long groupId,
		long classNameId, java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_ClassNameNomeFantasia(long companyId, long groupId,
		long classNameId, java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param nomeFantasia the nome fantasia
	* @param statuses the statuses
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_ClassNameNomeFantasia(long companyId, long groupId,
		long classNameId, java.lang.String nomeFantasia, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the loja in the entity cache if it is enabled.
	*
	* @param loja the loja
	*/
	public void cacheResult(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja);

	/**
	* Caches the lojas in the entity cache if it is enabled.
	*
	* @param lojas the lojas
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> lojas);

	/**
	* Creates a new loja with the primary key. Does not add the loja to the database.
	*
	* @param lojaId the primary key for the new loja
	* @return the new loja
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja create(long lojaId);

	/**
	* Removes the loja with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaId the primary key of the loja
	* @return the loja that was removed
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja remove(long lojaId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.loja.model.Loja updateImpl(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja with the primary key or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param lojaId the primary key of the loja
	* @return the loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja findByPrimaryKey(
		long lojaId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loja with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lojaId the primary key of the loja
	* @return the loja, or <code>null</code> if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchByPrimaryKey(
		long lojaId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lojas.
	*
	* @return the lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lojas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @return the range of lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lojas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lojas
	* @param end the upper bound of the range of lojas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lojas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lojas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lojas.
	*
	* @return the number of lojas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}