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

package br.com.prodevelopment.lapidarios.lojaindicada.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LojaIndicadaLocalService}.
 *
 * @author Marcelo Melo
 * @see LojaIndicadaLocalService
 * @generated
 */
public class LojaIndicadaLocalServiceWrapper implements LojaIndicadaLocalService,
	ServiceWrapper<LojaIndicadaLocalService> {
	public LojaIndicadaLocalServiceWrapper(
		LojaIndicadaLocalService lojaIndicadaLocalService) {
		_lojaIndicadaLocalService = lojaIndicadaLocalService;
	}

	/**
	* Adds the loja indicada to the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicada the loja indicada
	* @return the loja indicada that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada addLojaIndicada(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.addLojaIndicada(lojaIndicada);
	}

	/**
	* Creates a new loja indicada with the primary key. Does not add the loja indicada to the database.
	*
	* @param lojaIndicadaId the primary key for the new loja indicada
	* @return the new loja indicada
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada createLojaIndicada(
		long lojaIndicadaId) {
		return _lojaIndicadaLocalService.createLojaIndicada(lojaIndicadaId);
	}

	/**
	* Deletes the loja indicada with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada that was removed
	* @throws PortalException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada deleteLojaIndicada(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.deleteLojaIndicada(lojaIndicadaId);
	}

	/**
	* Deletes the loja indicada from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicada the loja indicada
	* @return the loja indicada that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada deleteLojaIndicada(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.deleteLojaIndicada(lojaIndicada);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lojaIndicadaLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchLojaIndicada(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.fetchLojaIndicada(lojaIndicadaId);
	}

	/**
	* Returns the loja indicada with the matching UUID and company.
	*
	* @param uuid the loja indicada's UUID
	* @param companyId the primary key of the company
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchLojaIndicadaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.fetchLojaIndicadaByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the loja indicada matching the UUID and group.
	*
	* @param uuid the loja indicada's UUID
	* @param groupId the primary key of the group
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchLojaIndicadaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.fetchLojaIndicadaByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the loja indicada with the primary key.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada
	* @throws PortalException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada getLojaIndicada(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.getLojaIndicada(lojaIndicadaId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the loja indicada with the matching UUID and company.
	*
	* @param uuid the loja indicada's UUID
	* @param companyId the primary key of the company
	* @return the matching loja indicada
	* @throws PortalException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada getLojaIndicadaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.getLojaIndicadaByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the loja indicada matching the UUID and group.
	*
	* @param uuid the loja indicada's UUID
	* @param groupId the primary key of the group
	* @return the matching loja indicada
	* @throws PortalException if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada getLojaIndicadaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.getLojaIndicadaByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> getLojaIndicadas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.getLojaIndicadas(start, end);
	}

	/**
	* Returns the number of loja indicadas.
	*
	* @return the number of loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLojaIndicadasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.getLojaIndicadasCount();
	}

	/**
	* Updates the loja indicada in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicada the loja indicada
	* @return the loja indicada that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada updateLojaIndicada(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.updateLojaIndicada(lojaIndicada);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lojaIndicadaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lojaIndicadaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lojaIndicadaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada addLojaIndicada(
		long companyId, long groupId, long userId, java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.addLojaIndicada(companyId, groupId,
			userId, idLoja);
	}

	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada update(
		long lojaIndicadaId, long companyId, long groupId, long userId,
		java.lang.String idLoja, boolean lojaIndicadaAtual)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.update(lojaIndicadaId, companyId,
			groupId, userId, idLoja, lojaIndicadaAtual);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.searchCount(companyId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> search(
		long companyId, long groupId, java.lang.String idLoja, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.search(companyId, groupId, idLoja,
			start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.searchCount(companyId, groupId, idLoja);
	}

	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findLojaIndicadaAtual(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicadaLocalService.findLojaIndicadaAtual(companyId,
			groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LojaIndicadaLocalService getWrappedLojaIndicadaLocalService() {
		return _lojaIndicadaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLojaIndicadaLocalService(
		LojaIndicadaLocalService lojaIndicadaLocalService) {
		_lojaIndicadaLocalService = lojaIndicadaLocalService;
	}

	@Override
	public LojaIndicadaLocalService getWrappedService() {
		return _lojaIndicadaLocalService;
	}

	@Override
	public void setWrappedService(
		LojaIndicadaLocalService lojaIndicadaLocalService) {
		_lojaIndicadaLocalService = lojaIndicadaLocalService;
	}

	private LojaIndicadaLocalService _lojaIndicadaLocalService;
}