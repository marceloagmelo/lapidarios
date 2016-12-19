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

package br.com.prodevelopment.lapidarios.evento.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Local. This utility wraps
 * {@link br.com.prodevelopment.lapidarios.evento.service.impl.LocalLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see LocalLocalService
 * @see br.com.prodevelopment.lapidarios.evento.service.base.LocalLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.impl.LocalLocalServiceImpl
 * @generated
 */
public class LocalLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.lapidarios.evento.service.impl.LocalLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the local to the database. Also notifies the appropriate model listeners.
	*
	* @param local the local
	* @return the local that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local addLocal(
		br.com.prodevelopment.lapidarios.evento.model.Local local)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLocal(local);
	}

	/**
	* Creates a new local with the primary key. Does not add the local to the database.
	*
	* @param localId the primary key for the new local
	* @return the new local
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local createLocal(
		long localId) {
		return getService().createLocal(localId);
	}

	/**
	* Deletes the local with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param localId the primary key of the local
	* @return the local that was removed
	* @throws PortalException if a local with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local deleteLocal(
		long localId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLocal(localId);
	}

	/**
	* Deletes the local from the database. Also notifies the appropriate model listeners.
	*
	* @param local the local
	* @return the local that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local deleteLocal(
		br.com.prodevelopment.lapidarios.evento.model.Local local)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLocal(local);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.LocalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.LocalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.lapidarios.evento.model.Local fetchLocal(
		long localId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLocal(localId);
	}

	/**
	* Returns the local with the matching UUID and company.
	*
	* @param uuid the local's UUID
	* @param companyId the primary key of the company
	* @return the matching local, or <code>null</code> if a matching local could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local fetchLocalByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLocalByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the local matching the UUID and group.
	*
	* @param uuid the local's UUID
	* @param groupId the primary key of the group
	* @return the matching local, or <code>null</code> if a matching local could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local fetchLocalByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLocalByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the local with the primary key.
	*
	* @param localId the primary key of the local
	* @return the local
	* @throws PortalException if a local with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local getLocal(
		long localId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocal(localId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the local with the matching UUID and company.
	*
	* @param uuid the local's UUID
	* @param companyId the primary key of the company
	* @return the matching local
	* @throws PortalException if a matching local could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local getLocalByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the local matching the UUID and group.
	*
	* @param uuid the local's UUID
	* @param groupId the primary key of the group
	* @return the matching local
	* @throws PortalException if a matching local could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local getLocalByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the locals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.LocalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locals
	* @param end the upper bound of the range of locals (not inclusive)
	* @return the range of locals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Local> getLocals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocals(start, end);
	}

	/**
	* Returns the number of locals.
	*
	* @return the number of locals
	* @throws SystemException if a system exception occurred
	*/
	public static int getLocalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalsCount();
	}

	/**
	* Updates the local in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param local the local
	* @return the local that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.evento.model.Local updateLocal(
		br.com.prodevelopment.lapidarios.evento.model.Local local)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLocal(local);
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

	public static br.com.prodevelopment.lapidarios.evento.model.Local addLocal(
		long companyId, long groupId, long userIdCreate, java.lang.String nome,
		java.util.Map<java.util.Locale, java.lang.String> pontoReferenciaMap,
		java.lang.String endLogradouro, java.lang.String endNumero,
		java.lang.String endComplemento, java.lang.String endCep,
		java.lang.String endBairro, java.lang.String endCidade,
		java.lang.String endUf, java.lang.String endPais, double versao,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLocal(companyId, groupId, userIdCreate, nome,
			pontoReferenciaMap, endLogradouro, endNumero, endComplemento,
			endCep, endBairro, endCidade, endUf, endPais, versao,
			enderecosEmail, telefones);
	}

	public static br.com.prodevelopment.lapidarios.evento.model.Local update(
		long localId, long companyId, long groupId, long modifieduserId,
		java.lang.String nome,
		java.util.Map<java.util.Locale, java.lang.String> pontoReferenciaMap,
		java.lang.String endLogradouro, java.lang.String endNumero,
		java.lang.String endComplemento, java.lang.String endCep,
		java.lang.String endBairro, java.lang.String endCidade,
		java.lang.String endUf, java.lang.String endPais, double versao,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones,
		long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(localId, companyId, groupId, modifieduserId, nome,
			pontoReferenciaMap, endLogradouro, endNumero, endComplemento,
			endCep, endBairro, endCidade, endUf, endPais, versao,
			enderecosEmail, telefones, classNameId);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Local> search(
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

	public static java.util.List<br.com.prodevelopment.lapidarios.evento.model.Local> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId, nome);
	}

	public static void clearService() {
		_service = null;
	}

	public static LocalLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LocalLocalService.class.getName());

			if (invokableLocalService instanceof LocalLocalService) {
				_service = (LocalLocalService)invokableLocalService;
			}
			else {
				_service = new LocalLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LocalLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LocalLocalService service) {
	}

	private static LocalLocalService _service;
}