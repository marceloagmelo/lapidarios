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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the loja service. This utility wraps {@link LojaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaPersistence
 * @see LojaPersistenceImpl
 * @generated
 */
public class LojaUtil {
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
	public static void clearCache(Loja loja) {
		getPersistence().clearCache(loja);
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
	public static List<Loja> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Loja> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Loja> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Loja update(Loja loja) throws SystemException {
		return getPersistence().update(loja);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Loja update(Loja loja, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(loja, serviceContext);
	}

	/**
	* Returns all the lojas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByUuid_PrevAndNext(
		long lojaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(lojaId, uuid, orderByComparator);
	}

	/**
	* Removes all the lojas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of lojas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the loja where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the loja where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the loja where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the loja where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of lojas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the lojas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByUuid_C_PrevAndNext(
		long lojaId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(lojaId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the lojas where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of lojas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the lojas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCompany_PrevAndNext(
		long lojaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(lojaId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the lojas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of lojas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the lojas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_First(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Last(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_PrevAndNext(
		long lojaId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_PrevAndNext(lojaId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of lojas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId);
	}

	/**
	* Returns all the lojas where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByRazaoSocial(
		java.lang.String razaoSocial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRazaoSocial(razaoSocial);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByRazaoSocial(
		java.lang.String razaoSocial, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRazaoSocial(razaoSocial, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByRazaoSocial(
		java.lang.String razaoSocial, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRazaoSocial(razaoSocial, start, end, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByRazaoSocial_First(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRazaoSocial_First(razaoSocial, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByRazaoSocial_First(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRazaoSocial_First(razaoSocial, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByRazaoSocial_Last(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRazaoSocial_Last(razaoSocial, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByRazaoSocial_Last(
		java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRazaoSocial_Last(razaoSocial, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByRazaoSocial_PrevAndNext(
		long lojaId, java.lang.String razaoSocial,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRazaoSocial_PrevAndNext(lojaId, razaoSocial,
			orderByComparator);
	}

	/**
	* Removes all the lojas where razaoSocial LIKE &#63; from the database.
	*
	* @param razaoSocial the razao social
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRazaoSocial(java.lang.String razaoSocial)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRazaoSocial(razaoSocial);
	}

	/**
	* Returns the number of lojas where razaoSocial LIKE &#63;.
	*
	* @param razaoSocial the razao social
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRazaoSocial(java.lang.String razaoSocial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRazaoSocial(razaoSocial);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial(companyId, groupId, razaoSocial, status);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial(companyId, groupId, razaoSocial,
			status, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial(companyId, groupId, razaoSocial,
			status, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_RazaoSocial_First(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial_First(companyId, groupId, razaoSocial,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_RazaoSocial_First(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_RazaoSocial_First(companyId, groupId,
			razaoSocial, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_RazaoSocial_Last(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial_Last(companyId, groupId, razaoSocial,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_RazaoSocial_Last(
		long companyId, long groupId, java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_RazaoSocial_Last(companyId, groupId, razaoSocial,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_RazaoSocial_PrevAndNext(
		long lojaId, long companyId, long groupId,
		java.lang.String razaoSocial, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial_PrevAndNext(lojaId, companyId,
			groupId, razaoSocial, status, orderByComparator);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial(companyId, groupId, razaoSocial,
			statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial(companyId, groupId, razaoSocial,
			statuses, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_RazaoSocial(
		long companyId, long groupId, java.lang.String razaoSocial,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_RazaoSocial(companyId, groupId, razaoSocial,
			statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param razaoSocial the razao social
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_RazaoSocial(long companyId, long groupId,
		java.lang.String razaoSocial, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_RazaoSocial(companyId, groupId, razaoSocial, status);
	}

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
	public static int countByCG_RazaoSocial(long companyId, long groupId,
		java.lang.String razaoSocial, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_RazaoSocial(companyId, groupId, razaoSocial,
			status);
	}

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
	public static int countByCG_RazaoSocial(long companyId, long groupId,
		java.lang.String razaoSocial, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_RazaoSocial(companyId, groupId, razaoSocial,
			statuses);
	}

	/**
	* Returns all the lojas where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @return the matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByNomeFantasia(
		java.lang.String nomeFantasia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNomeFantasia(nomeFantasia);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByNomeFantasia(
		java.lang.String nomeFantasia, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNomeFantasia(nomeFantasia, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByNomeFantasia(
		java.lang.String nomeFantasia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNomeFantasia(nomeFantasia, start, end,
			orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByNomeFantasia_First(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNomeFantasia_First(nomeFantasia, orderByComparator);
	}

	/**
	* Returns the first loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByNomeFantasia_First(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNomeFantasia_First(nomeFantasia, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByNomeFantasia_Last(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNomeFantasia_Last(nomeFantasia, orderByComparator);
	}

	/**
	* Returns the last loja in the ordered set where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByNomeFantasia_Last(
		java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNomeFantasia_Last(nomeFantasia, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByNomeFantasia_PrevAndNext(
		long lojaId, java.lang.String nomeFantasia,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNomeFantasia_PrevAndNext(lojaId, nomeFantasia,
			orderByComparator);
	}

	/**
	* Removes all the lojas where nomeFantasia LIKE &#63; from the database.
	*
	* @param nomeFantasia the nome fantasia
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNomeFantasia(java.lang.String nomeFantasia)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNomeFantasia(nomeFantasia);
	}

	/**
	* Returns the number of lojas where nomeFantasia LIKE &#63;.
	*
	* @param nomeFantasia the nome fantasia
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNomeFantasia(java.lang.String nomeFantasia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNomeFantasia(nomeFantasia);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			status);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			status, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			status, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_NomeFantasia_First(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia_First(companyId, groupId,
			nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_NomeFantasia_First(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_NomeFantasia_First(companyId, groupId,
			nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_NomeFantasia_Last(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia_Last(companyId, groupId,
			nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_NomeFantasia_Last(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_NomeFantasia_Last(companyId, groupId,
			nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_NomeFantasia_PrevAndNext(
		long lojaId, long companyId, long groupId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia_PrevAndNext(lojaId, companyId,
			groupId, nomeFantasia, status, orderByComparator);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			statuses, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_NomeFantasia(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeFantasia the nome fantasia
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_NomeFantasia(long companyId, long groupId,
		java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_NomeFantasia(companyId, groupId, nomeFantasia, status);
	}

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
	public static int countByCG_NomeFantasia(long companyId, long groupId,
		java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			status);
	}

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
	public static int countByCG_NomeFantasia(long companyId, long groupId,
		java.lang.String nomeFantasia, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			statuses);
	}

	/**
	* Returns the loja where cnpj = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param cnpj the cnpj
	* @return the matching loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCNPJ(
		java.lang.String cnpj)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCNPJ(cnpj);
	}

	/**
	* Returns the loja where cnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cnpj the cnpj
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCNPJ(
		java.lang.String cnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCNPJ(cnpj);
	}

	/**
	* Returns the loja where cnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cnpj the cnpj
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCNPJ(
		java.lang.String cnpj, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCNPJ(cnpj, retrieveFromCache);
	}

	/**
	* Removes the loja where cnpj = &#63; from the database.
	*
	* @param cnpj the cnpj
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja removeByCNPJ(
		java.lang.String cnpj)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCNPJ(cnpj);
	}

	/**
	* Returns the number of lojas where cnpj = &#63;.
	*
	* @param cnpj the cnpj
	* @return the number of matching lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCNPJ(java.lang.String cnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCNPJ(cnpj);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_CNPJ(companyId, groupId, cnpj, status);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCG_CNPJ(companyId, groupId, cnpj, status);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_CNPJ(companyId, groupId, cnpj, status,
			retrieveFromCache);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja removeByCG_CNPJ(
		long companyId, long groupId, java.lang.String cnpj, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCG_CNPJ(companyId, groupId, cnpj, status);
	}

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
	public static int countByCG_CNPJ(long companyId, long groupId,
		java.lang.String cnpj, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_CNPJ(companyId, groupId, cnpj, status);
	}

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
	public static int countByCG_CNPJ(long companyId, long groupId,
		java.lang.String cnpj, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_CNPJ(companyId, groupId, cnpj, statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			status);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			status, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			status, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_OrdemIndicada_First(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada_First(companyId, groupId,
			ordemIndicada, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicada_First(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_OrdemIndicada_First(companyId, groupId,
			ordemIndicada, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_OrdemIndicada_Last(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada_Last(companyId, groupId,
			ordemIndicada, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicada_Last(
		long companyId, long groupId, int ordemIndicada, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_OrdemIndicada_Last(companyId, groupId,
			ordemIndicada, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_OrdemIndicada_PrevAndNext(
		long lojaId, long companyId, long groupId, int ordemIndicada,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada_PrevAndNext(lojaId, companyId,
			groupId, ordemIndicada, status, orderByComparator);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int[] statuses,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			statuses, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_OrdemIndicada(
		long companyId, long groupId, int ordemIndicada, int[] statuses,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param ordemIndicada the ordem indicada
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_OrdemIndicada(companyId, groupId, ordemIndicada, status);
	}

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
	public static int countByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			status);
	}

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
	public static int countByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			statuses);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, status);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, status);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, status, retrieveFromCache);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja removeByCG_OrdemIndicadaAtual(
		long companyId, long groupId, boolean ordemIndicadaAtual, int status)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, status);
	}

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
	public static int countByCG_OrdemIndicadaAtual(long companyId,
		long groupId, boolean ordemIndicadaAtual, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, status);
	}

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
	public static int countByCG_OrdemIndicadaAtual(long companyId,
		long groupId, boolean ordemIndicadaAtual, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName(companyId, groupId, classNameId, status);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName(companyId, groupId, classNameId, status,
			start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName(companyId, groupId, classNameId, status,
			start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassName_First(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName_First(companyId, groupId, classNameId,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassName_First(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ClassName_First(companyId, groupId, classNameId,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassName_Last(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName_Last(companyId, groupId, classNameId,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassName_Last(
		long companyId, long groupId, long classNameId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ClassName_Last(companyId, groupId, classNameId,
			status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_ClassName_PrevAndNext(
		long lojaId, long companyId, long groupId, long classNameId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName_PrevAndNext(lojaId, companyId, groupId,
			classNameId, status, orderByComparator);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName(companyId, groupId, classNameId, statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int[] statuses,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName(companyId, groupId, classNameId,
			statuses, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassName(
		long companyId, long groupId, long classNameId, int[] statuses,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassName(companyId, groupId, classNameId,
			statuses, start, end, orderByComparator);
	}

	/**
	* Removes all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_ClassName(long companyId, long groupId,
		long classNameId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_ClassName(companyId, groupId, classNameId, status);
	}

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
	public static int countByCG_ClassName(long companyId, long groupId,
		long classNameId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ClassName(companyId, groupId, classNameId, status);
	}

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
	public static int countByCG_ClassName(long companyId, long groupId,
		long classNameId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ClassName(companyId, groupId, classNameId,
			statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, status);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, status, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, status, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassNameNomeFantasia_First(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia_First(companyId, groupId,
			classNameId, nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassNameNomeFantasia_First(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ClassNameNomeFantasia_First(companyId, groupId,
			classNameId, nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByCG_ClassNameNomeFantasia_Last(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia_Last(companyId, groupId,
			classNameId, nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByCG_ClassNameNomeFantasia_Last(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_ClassNameNomeFantasia_Last(companyId, groupId,
			classNameId, nomeFantasia, status, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.loja.model.Loja[] findByCG_ClassNameNomeFantasia_PrevAndNext(
		long lojaId, long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia_PrevAndNext(lojaId,
			companyId, groupId, classNameId, nomeFantasia, status,
			orderByComparator);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, statuses);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, statuses, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findByCG_ClassNameNomeFantasia(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, statuses, start, end, orderByComparator);
	}

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
	public static void removeByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, java.lang.String nomeFantasia,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_ClassNameNomeFantasia(companyId, groupId, classNameId,
			nomeFantasia, status);
	}

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
	public static int countByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, java.lang.String nomeFantasia,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, status);
	}

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
	public static int countByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, java.lang.String nomeFantasia,
		int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_ClassNameNomeFantasia(companyId, groupId,
			classNameId, nomeFantasia, statuses);
	}

	/**
	* Caches the loja in the entity cache if it is enabled.
	*
	* @param loja the loja
	*/
	public static void cacheResult(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja) {
		getPersistence().cacheResult(loja);
	}

	/**
	* Caches the lojas in the entity cache if it is enabled.
	*
	* @param lojas the lojas
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> lojas) {
		getPersistence().cacheResult(lojas);
	}

	/**
	* Creates a new loja with the primary key. Does not add the loja to the database.
	*
	* @param lojaId the primary key for the new loja
	* @return the new loja
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja create(
		long lojaId) {
		return getPersistence().create(lojaId);
	}

	/**
	* Removes the loja with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaId the primary key of the loja
	* @return the loja that was removed
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja remove(
		long lojaId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(lojaId);
	}

	public static br.com.prodevelopment.lapidarios.loja.model.Loja updateImpl(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(loja);
	}

	/**
	* Returns the loja with the primary key or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	*
	* @param lojaId the primary key of the loja
	* @return the loja
	* @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja findByPrimaryKey(
		long lojaId)
		throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(lojaId);
	}

	/**
	* Returns the loja with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lojaId the primary key of the loja
	* @return the loja, or <code>null</code> if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.loja.model.Loja fetchByPrimaryKey(
		long lojaId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lojaId);
	}

	/**
	* Returns all the lojas.
	*
	* @return the lojas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lojas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lojas.
	*
	* @return the number of lojas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LojaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LojaPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.lapidarios.loja.service.ClpSerializer.getServletContextName(),
					LojaPersistence.class.getName());

			ReferenceRegistry.registerReference(LojaUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LojaPersistence persistence) {
	}

	private static LojaPersistence _persistence;
}