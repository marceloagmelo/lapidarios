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

package br.com.prodevelopment.lapidarios.contato.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Endereco. This utility wraps
 * {@link br.com.prodevelopment.lapidarios.contato.service.impl.EnderecoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see EnderecoLocalService
 * @see br.com.prodevelopment.lapidarios.contato.service.base.EnderecoLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.contato.service.impl.EnderecoLocalServiceImpl
 * @generated
 */
public class EnderecoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.lapidarios.contato.service.impl.EnderecoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the endereco to the database. Also notifies the appropriate model listeners.
	*
	* @param endereco the endereco
	* @return the endereco that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco addEndereco(
		br.com.prodevelopment.lapidarios.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEndereco(endereco);
	}

	/**
	* Creates a new endereco with the primary key. Does not add the endereco to the database.
	*
	* @param enderecoId the primary key for the new endereco
	* @return the new endereco
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco createEndereco(
		long enderecoId) {
		return getService().createEndereco(enderecoId);
	}

	/**
	* Deletes the endereco with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco that was removed
	* @throws PortalException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco deleteEndereco(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEndereco(enderecoId);
	}

	/**
	* Deletes the endereco from the database. Also notifies the appropriate model listeners.
	*
	* @param endereco the endereco
	* @return the endereco that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco deleteEndereco(
		br.com.prodevelopment.lapidarios.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEndereco(endereco);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.lapidarios.contato.model.Endereco fetchEndereco(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEndereco(enderecoId);
	}

	/**
	* Returns the endereco with the matching UUID and company.
	*
	* @param uuid the endereco's UUID
	* @param companyId the primary key of the company
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco fetchEnderecoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEnderecoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the endereco matching the UUID and group.
	*
	* @param uuid the endereco's UUID
	* @param groupId the primary key of the group
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco fetchEnderecoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEnderecoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the endereco with the primary key.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco
	* @throws PortalException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco getEndereco(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEndereco(enderecoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the endereco with the matching UUID and company.
	*
	* @param uuid the endereco's UUID
	* @param companyId the primary key of the company
	* @return the matching endereco
	* @throws PortalException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco getEnderecoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the endereco matching the UUID and group.
	*
	* @param uuid the endereco's UUID
	* @param groupId the primary key of the group
	* @return the matching endereco
	* @throws PortalException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco getEnderecoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the enderecos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.lapidarios.contato.model.Endereco> getEnderecos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecos(start, end);
	}

	/**
	* Returns the number of enderecos.
	*
	* @return the number of enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int getEnderecosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecosCount();
	}

	/**
	* Updates the endereco in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param endereco the endereco
	* @return the endereco that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.lapidarios.contato.model.Endereco updateEndereco(
		br.com.prodevelopment.lapidarios.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEndereco(endereco);
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

	public static br.com.prodevelopment.lapidarios.contato.model.Endereco addEndereco(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String logradouro,
		java.lang.String numero, java.lang.String complemento,
		java.lang.String cep, java.lang.String bairro, java.lang.String cidade,
		java.lang.String uf, long paisId, int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEndereco(companyId, groupId, createUserId, className,
			classPK, logradouro, numero, complemento, cep, bairro, cidade, uf,
			paisId, tipo, principal);
	}

	public static br.com.prodevelopment.lapidarios.contato.model.Endereco update(
		long enderecoId, long companyId, java.lang.String className,
		long classPK, long modifieduserId, java.lang.String logradouro,
		java.lang.String numero, java.lang.String complemento,
		java.lang.String cep, java.lang.String bairro, java.lang.String cidade,
		java.lang.String uf, long paisId, int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(enderecoId, companyId, className, classPK,
			modifieduserId, logradouro, numero, complemento, cep, bairro,
			cidade, uf, paisId, tipo, principal);
	}

	public static void updateEnderecos(long companyId, long groupId,
		long userId, java.lang.String className, long classPK,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Endereco> enderecos)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateEnderecos(companyId, groupId, userId, className, classPK,
			enderecos);
	}

	public static void deleteEnderecos(long companyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEnderecos(companyId, className, classPK);
	}

	public static java.util.List<br.com.prodevelopment.lapidarios.contato.model.Endereco> getEnderecos(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecos(companyId, className, classPK);
	}

	public static br.com.prodevelopment.lapidarios.contato.model.Endereco createEndereco()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createEndereco();
	}

	public static void clearService() {
		_service = null;
	}

	public static EnderecoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EnderecoLocalService.class.getName());

			if (invokableLocalService instanceof EnderecoLocalService) {
				_service = (EnderecoLocalService)invokableLocalService;
			}
			else {
				_service = new EnderecoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EnderecoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EnderecoLocalService service) {
	}

	private static EnderecoLocalService _service;
}