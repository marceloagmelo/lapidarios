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

package br.com.prodevelopment.lapidarios.municipio.service.persistence;

import br.com.prodevelopment.lapidarios.municipio.model.Municipio;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the municipio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see MunicipioPersistenceImpl
 * @see MunicipioUtil
 * @generated
 */
public interface MunicipioPersistence extends BasePersistence<Municipio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MunicipioUtil} to access the municipio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the municipios where uf = &#63;.
	*
	* @param uf the uf
	* @return the matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findByUF(
		java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the municipios where uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uf the uf
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @return the range of matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findByUF(
		java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the municipios where uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uf the uf
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findByUF(
		java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first municipio in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio findByUF_First(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first municipio in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching municipio, or <code>null</code> if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio fetchByUF_First(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last municipio in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio findByUF_Last(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last municipio in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching municipio, or <code>null</code> if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio fetchByUF_Last(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the municipios before and after the current municipio in the ordered set where uf = &#63;.
	*
	* @param codigo the primary key of the current municipio
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio[] findByUF_PrevAndNext(
		long codigo, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the municipios where uf = &#63; from the database.
	*
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUF(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of municipios where uf = &#63;.
	*
	* @param uf the uf
	* @return the number of matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public int countByUF(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the municipios where cidade LIKE &#63;.
	*
	* @param cidade the cidade
	* @return the matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findByCIDADE(
		java.lang.String cidade)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the municipios where cidade LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cidade the cidade
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @return the range of matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findByCIDADE(
		java.lang.String cidade, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the municipios where cidade LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cidade the cidade
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findByCIDADE(
		java.lang.String cidade, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first municipio in the ordered set where cidade LIKE &#63;.
	*
	* @param cidade the cidade
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio findByCIDADE_First(
		java.lang.String cidade,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first municipio in the ordered set where cidade LIKE &#63;.
	*
	* @param cidade the cidade
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching municipio, or <code>null</code> if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio fetchByCIDADE_First(
		java.lang.String cidade,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last municipio in the ordered set where cidade LIKE &#63;.
	*
	* @param cidade the cidade
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio findByCIDADE_Last(
		java.lang.String cidade,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last municipio in the ordered set where cidade LIKE &#63;.
	*
	* @param cidade the cidade
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching municipio, or <code>null</code> if a matching municipio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio fetchByCIDADE_Last(
		java.lang.String cidade,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the municipios before and after the current municipio in the ordered set where cidade LIKE &#63;.
	*
	* @param codigo the primary key of the current municipio
	* @param cidade the cidade
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio[] findByCIDADE_PrevAndNext(
		long codigo, java.lang.String cidade,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the municipios where cidade LIKE &#63; from the database.
	*
	* @param cidade the cidade
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCIDADE(java.lang.String cidade)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of municipios where cidade LIKE &#63;.
	*
	* @param cidade the cidade
	* @return the number of matching municipios
	* @throws SystemException if a system exception occurred
	*/
	public int countByCIDADE(java.lang.String cidade)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the municipio in the entity cache if it is enabled.
	*
	* @param municipio the municipio
	*/
	public void cacheResult(
		br.com.prodevelopment.lapidarios.municipio.model.Municipio municipio);

	/**
	* Caches the municipios in the entity cache if it is enabled.
	*
	* @param municipios the municipios
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> municipios);

	/**
	* Creates a new municipio with the primary key. Does not add the municipio to the database.
	*
	* @param codigo the primary key for the new municipio
	* @return the new municipio
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio create(
		long codigo);

	/**
	* Removes the municipio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codigo the primary key of the municipio
	* @return the municipio that was removed
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio remove(
		long codigo)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.lapidarios.municipio.model.Municipio updateImpl(
		br.com.prodevelopment.lapidarios.municipio.model.Municipio municipio)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the municipio with the primary key or throws a {@link br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException} if it could not be found.
	*
	* @param codigo the primary key of the municipio
	* @return the municipio
	* @throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio findByPrimaryKey(
		long codigo)
		throws br.com.prodevelopment.lapidarios.municipio.NoSuchMunicipioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the municipio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codigo the primary key of the municipio
	* @return the municipio, or <code>null</code> if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio fetchByPrimaryKey(
		long codigo) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the municipios.
	*
	* @return the municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the municipios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @return the range of municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the municipios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of municipios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.lapidarios.municipio.model.Municipio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the municipios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of municipios.
	*
	* @return the number of municipios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}