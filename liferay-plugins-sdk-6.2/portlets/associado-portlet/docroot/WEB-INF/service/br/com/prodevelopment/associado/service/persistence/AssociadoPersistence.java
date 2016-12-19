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

package br.com.prodevelopment.associado.service.persistence;

import br.com.prodevelopment.associado.model.Associado;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the associado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see AssociadoPersistenceImpl
 * @see AssociadoUtil
 * @generated
 */
public interface AssociadoPersistence extends BasePersistence<Associado> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssociadoUtil} to access the associado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the associados where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where uuid = &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByUuid_PrevAndNext(
		long associadoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associado where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByUuid_C_PrevAndNext(
		long associadoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where companyId = &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByCompany_PrevAndNext(
		long associadoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByC_G_PrevAndNext(
		long associadoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set of associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] filterFindByC_G_PrevAndNext(
		long associadoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByC_NOME_PrevAndNext(
		long associadoId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByC_G_NOME_PrevAndNext(
		long associadoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set of associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] filterFindByC_G_NOME_PrevAndNext(
		long associadoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching associados that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where cpfCnpj = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where cpfCnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where cpfCnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cpfCnpj the cpf cnpj
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByCPF_CNPJ(
		java.lang.String cpfCnpj, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associado where cpfCnpj = &#63; from the database.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado removeByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where cpfCnpj = &#63;.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByCPF_CNPJ(java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where rgInscricaoMun = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByRG_INSCRICAO(
		java.lang.String rgInscricaoMun)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByRG_INSCRICAO(
		java.lang.String rgInscricaoMun)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByRG_INSCRICAO(
		java.lang.String rgInscricaoMun, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associado where rgInscricaoMun = &#63; from the database.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado removeByRG_INSCRICAO(
		java.lang.String rgInscricaoMun)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where rgInscricaoMun = &#63;.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByRG_INSCRICAO(java.lang.String rgInscricaoMun)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByDT_NASCIMENTO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associado in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associado in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associados before and after the current associado in the ordered set where dataNascimento = &#63;.
	*
	* @param associadoId the primary key of the current associado
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado[] findByDT_NASCIMENTO_PrevAndNext(
		long associadoId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where userId = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByUSUARIO(
		long userId)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUSUARIO(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByUSUARIO(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associado where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado removeByUSUARIO(
		long userId)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByUSUARIO(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where idPolishop = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	*
	* @param idPolishop the id polishop
	* @return the matching associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByID_POLISHOP(
		java.lang.String idPolishop)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where idPolishop = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idPolishop the id polishop
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByID_POLISHOP(
		java.lang.String idPolishop)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado where idPolishop = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idPolishop the id polishop
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByID_POLISHOP(
		java.lang.String idPolishop, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associado where idPolishop = &#63; from the database.
	*
	* @param idPolishop the id polishop
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado removeByID_POLISHOP(
		java.lang.String idPolishop)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados where idPolishop = &#63;.
	*
	* @param idPolishop the id polishop
	* @return the number of matching associados
	* @throws SystemException if a system exception occurred
	*/
	public int countByID_POLISHOP(java.lang.String idPolishop)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the associado in the entity cache if it is enabled.
	*
	* @param associado the associado
	*/
	public void cacheResult(
		br.com.prodevelopment.associado.model.Associado associado);

	/**
	* Caches the associados in the entity cache if it is enabled.
	*
	* @param associados the associados
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.associado.model.Associado> associados);

	/**
	* Creates a new associado with the primary key. Does not add the associado to the database.
	*
	* @param associadoId the primary key for the new associado
	* @return the new associado
	*/
	public br.com.prodevelopment.associado.model.Associado create(
		long associadoId);

	/**
	* Removes the associado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associadoId the primary key of the associado
	* @return the associado that was removed
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado remove(
		long associadoId)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.associado.model.Associado updateImpl(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado with the primary key or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	*
	* @param associadoId the primary key of the associado
	* @return the associado
	* @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado findByPrimaryKey(
		long associadoId)
		throws br.com.prodevelopment.associado.NoSuchAssociadoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param associadoId the primary key of the associado
	* @return the associado, or <code>null</code> if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.associado.model.Associado fetchByPrimaryKey(
		long associadoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associados.
	*
	* @return the associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @return the range of associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of associados
	* @param end the upper bound of the range of associados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of associados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.associado.model.Associado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associados.
	*
	* @return the number of associados
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}