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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LojaIndicada. This utility wraps
 * {@link br.com.prodevelopment.lapidarios.lojaindicada.service.impl.LojaIndicadaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see LojaIndicadaLocalService
 * @see br.com.prodevelopment.lapidarios.lojaindicada.service.base.LojaIndicadaLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.lojaindicada.service.impl.LojaIndicadaLocalServiceImpl
 * @generated
 */
public class LojaIndicadaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.lapidarios.lojaindicada.service.impl.LojaIndicadaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the loja indicada to the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicada the loja indicada
	* @return the loja indicada that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada addLojaIndicada(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLojaIndicada(lojaIndicada);
	}

	/**
	* Creates a new loja indicada with the primary key. Does not add the loja indicada to the database.
	*
	* @param lojaIndicadaId the primary key for the new loja indicada
	* @return the new loja indicada
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada createLojaIndicada(
		long lojaIndicadaId) {
		return getService().createLojaIndicada(lojaIndicadaId);
	}

	/**
	* Deletes the loja indicada with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada that was removed
	* @throws PortalException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada deleteLojaIndicada(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLojaIndicada(lojaIndicadaId);
	}

	/**
	* Deletes the loja indicada from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicada the loja indicada
	* @return the loja indicada that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada deleteLojaIndicada(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLojaIndicada(lojaIndicada);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchLojaIndicada(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLojaIndicada(lojaIndicadaId);
	}

	/**
	* Returns the loja indicada with the matching UUID and company.
	*
	* @param uuid the loja indicada's UUID
	* @param companyId the primary key of the company
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchLojaIndicadaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLojaIndicadaByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the loja indicada matching the UUID and group.
	*
	* @param uuid the loja indicada's UUID
	* @param groupId the primary key of the group
	* @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada fetchLojaIndicadaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLojaIndicadaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the loja indicada with the primary key.
	*
	* @param lojaIndicadaId the primary key of the loja indicada
	* @return the loja indicada
	* @throws PortalException if a loja indicada with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada getLojaIndicada(
		long lojaIndicadaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLojaIndicada(lojaIndicadaId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada getLojaIndicadaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLojaIndicadaByUuidAndCompanyId(uuid, companyId);
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
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada getLojaIndicadaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLojaIndicadaByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> getLojaIndicadas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLojaIndicadas(start, end);
	}

	/**
	* Returns the number of loja indicadas.
	*
	* @return the number of loja indicadas
	* @throws SystemException if a system exception occurred
	*/
	public static int getLojaIndicadasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLojaIndicadasCount();
	}

	/**
	* Updates the loja indicada in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lojaIndicada the loja indicada
	* @return the loja indicada that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada updateLojaIndicada(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLojaIndicada(lojaIndicada);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada addLojaIndicada(
		long companyId, long groupId, long userId, java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addLojaIndicada(companyId, groupId, userId, idLoja);
	}

	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada update(
		long lojaIndicadaId, long companyId, long groupId, long userId,
		java.lang.String idLoja, boolean lojaIndicadaAtual)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(lojaIndicadaId, companyId, groupId, userId, idLoja,
			lojaIndicadaAtual);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, start, end, orderByComparator);
	}

	public static int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, start, end, orderByComparator);
	}

	public static int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> search(
		long companyId, long groupId, java.lang.String idLoja, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, idLoja, start, end,
			orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String idLoja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId, idLoja);
	}

	public static br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada findLojaIndicadaAtual(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findLojaIndicadaAtual(companyId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LojaIndicadaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LojaIndicadaLocalService.class.getName());

			if (invokableLocalService instanceof LojaIndicadaLocalService) {
				_service = (LojaIndicadaLocalService)invokableLocalService;
			}
			else {
				_service = new LojaIndicadaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LojaIndicadaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LojaIndicadaLocalService service) {
	}

	private static LojaIndicadaLocalService _service;
}