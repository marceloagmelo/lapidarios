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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the loja indicada service. This utility wraps {@link LojaIndicadaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaIndicadaPersistence
 * @see LojaIndicadaPersistenceImpl
 * @generated
 */
public class LojaIndicadaUtil {
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
	public static void clearCache(LojaIndicada lojaIndicada) {
		getPersistence().clearCache(lojaIndicada);
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
	public static List<LojaIndicada> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LojaIndicada> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LojaIndicada> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LojaIndicada update(LojaIndicada lojaIndicada)
		throws SystemException {
		return getPersistence().update(lojaIndicada);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LojaIndicada update(LojaIndicada lojaIndicada,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lojaIndicada, serviceContext);
	}

	/**
	* Returns all the loja indicadas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByUuid_PrevAndNext(
		long lojaIndicadaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(lojaIndicadaId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the loja indicadas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of loja indicadas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the loja indicada where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the loja indicada where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the loja indicada where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the loja indicada where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the loja indicada that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of loja indicadas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the loja indicadas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByUuid_C_PrevAndNext(
		long lojaIndicadaId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(lojaIndicadaId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the loja indicadas where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of loja indicadas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the loja indicadas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByCompany_PrevAndNext(
		long lojaIndicadaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(lojaIndicadaId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the loja indicadas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of loja indicadas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the loja indicadas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_First(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Last(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByCG_PrevAndNext(
		long lojaIndicadaId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_PrevAndNext(lojaIndicadaId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the loja indicadas where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of loja indicadas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId);
	}

	/**
	* Returns all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @return the matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG_IdLoja(
		long companyId, long groupId, java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_IdLoja(companyId, groupId, idLoja);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG_IdLoja(
		long companyId, long groupId, java.lang.String idLoja, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_IdLoja(companyId, groupId, idLoja, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findByCG_IdLoja(
		long companyId, long groupId, java.lang.String idLoja, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_IdLoja(companyId, groupId, idLoja, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_IdLoja_First(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_IdLoja_First(companyId, groupId, idLoja,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_IdLoja_First(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_IdLoja_First(companyId, groupId, idLoja,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_IdLoja_Last(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_IdLoja_Last(companyId, groupId, idLoja,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_IdLoja_Last(
		long companyId, long groupId, java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_IdLoja_Last(companyId, groupId, idLoja,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada[] findByCG_IdLoja_PrevAndNext(
		long lojaIndicadaId, long companyId, long groupId,
		java.lang.String idLoja,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_IdLoja_PrevAndNext(lojaIndicadaId, companyId,
			groupId, idLoja, orderByComparator);
	}

	/**
	* Removes all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_IdLoja(long companyId, long groupId,
		java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_IdLoja(companyId, groupId, idLoja);
	}

	/**
	* Returns the number of loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param idLoja the id loja
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_IdLoja(long companyId, long groupId,
		java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_IdLoja(companyId, groupId, idLoja);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_lojaIndicadaAtual(companyId, groupId,
			lojaIndicadaAtual);
	}

	/**
	* Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_lojaIndicadaAtual(companyId, groupId,
			lojaIndicadaAtual);
	}

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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_lojaIndicadaAtual(companyId, groupId,
			lojaIndicadaAtual, retrieveFromCache);
	}

	/**
	* Removes the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the loja indicada that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada removeByCG_lojaIndicadaAtual(
		long companyId, long groupId, java.lang.Boolean lojaIndicadaAtual)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByCG_lojaIndicadaAtual(companyId, groupId,
			lojaIndicadaAtual);
	}

	/**
	* Returns the number of loja indicadas where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param lojaIndicadaAtual the loja indicada atual
	* @return the number of matching loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_lojaIndicadaAtual(long companyId, long groupId,
		java.lang.Boolean lojaIndicadaAtual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_lojaIndicadaAtual(companyId, groupId,
			lojaIndicadaAtual);
	}

	/**
	* Caches the loja indicada in the entity cache if it is enabled.
	*
	* @param lojaIndicada the loja indicada
	*/
	public static void cacheResult(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada) {
		getPersistence().cacheResult(lojaIndicada);
	}

	/**
	* Caches the loja indicadas in the entity cache if it is enabled.
	*
	* @param lojaIndicadas the loja indicadas
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> lojaIndicadas) {
		getPersistence().cacheResult(lojaIndicadas);
	}

	/**
	* Creates a new loja indicada with the primary key. Does not add the loja indicada to the database.
	*
	* @param lojaIndicadaId the primary key for the new loja indicada
	* @return the new loja indicada
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada create(
		long lojaIndicadaId) {
		return getPersistence().create(lojaIndicadaId);
	}

	/**
	* Removes the loja indicada with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada that was removed
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada remove(
		long lojaIndicadaId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(lojaIndicadaId);
	}

	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada updateImpl(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lojaIndicada);
	}

	/**
	* Returns the loja indicada with the primary key or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada
	* @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findByPrimaryKey(
		long lojaIndicadaId)
		throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(lojaIndicadaId);
	}

	/**
	* Returns the loja indicada with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada, or <code>null</code> if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchByPrimaryKey(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lojaIndicadaId);
	}

	/**
	* Returns all the loja indicadas.
	*
	* @return the loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the loja indicadas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loja indicadas.
	*
	* @return the number of loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LojaIndicadaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LojaIndicadaPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.lapidarios.lojaindicada.service.ClpSerializer.getServletContextName(),
					LojaIndicadaPersistence.class.getName());

			ReferenceRegistry.registerReference(LojaIndicadaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LojaIndicadaPersistence persistence) {
	}

	private static LojaIndicadaPersistence _persistence;
}