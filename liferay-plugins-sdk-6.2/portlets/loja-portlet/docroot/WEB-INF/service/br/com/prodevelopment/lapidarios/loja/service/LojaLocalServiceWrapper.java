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

package br.com.prodevelopment.lapidarios.loja.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LojaLocalService}.
 *
 * @author Marcelo Melo
 * @see LojaLocalService
 * @generated
 */
public class LojaLocalServiceWrapper implements LojaLocalService,
	ServiceWrapper<LojaLocalService> {
	public LojaLocalServiceWrapper(LojaLocalService lojaLocalService) {
		_lojaLocalService = lojaLocalService;
	}

	/**
	* Adds the loja to the database. Also notifies the appropriate model listeners.
	*
	* @param loja the loja
	* @return the loja that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja addLoja(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.addLoja(loja);
	}

	/**
	* Creates a new loja with the primary key. Does not add the loja to the database.
	*
	* @param lojaId the primary key for the new loja
	* @return the new loja
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja createLoja(
		long lojaId) {
		return _lojaLocalService.createLoja(lojaId);
	}

	/**
	* Deletes the loja with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lojaId the primary key of the loja
	* @return the loja that was removed
	* @throws PortalException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja deleteLoja(
		long lojaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.deleteLoja(lojaId);
	}

	/**
	* Deletes the loja from the database. Also notifies the appropriate model listeners.
	*
	* @param loja the loja
	* @return the loja that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja deleteLoja(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.deleteLoja(loja);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lojaLocalService.dynamicQuery();
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
		return _lojaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lojaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lojaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _lojaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lojaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchLoja(
		long lojaId) throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.fetchLoja(lojaId);
	}

	/**
	* Returns the loja with the matching UUID and company.
	*
	* @param uuid the loja's UUID
	* @param companyId the primary key of the company
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchLojaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.fetchLojaByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the loja matching the UUID and group.
	*
	* @param uuid the loja's UUID
	* @param groupId the primary key of the group
	* @return the matching loja, or <code>null</code> if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja fetchLojaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.fetchLojaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the loja with the primary key.
	*
	* @param lojaId the primary key of the loja
	* @return the loja
	* @throws PortalException if a loja with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja getLoja(long lojaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.getLoja(lojaId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the loja with the matching UUID and company.
	*
	* @param uuid the loja's UUID
	* @param companyId the primary key of the company
	* @return the matching loja
	* @throws PortalException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja getLojaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.getLojaByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the loja matching the UUID and group.
	*
	* @param uuid the loja's UUID
	* @param groupId the primary key of the group
	* @return the matching loja
	* @throws PortalException if a matching loja could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja getLojaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.getLojaByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> getLojas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.getLojas(start, end);
	}

	/**
	* Returns the number of lojas.
	*
	* @return the number of lojas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLojasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.getLojasCount();
	}

	/**
	* Updates the loja in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loja the loja
	* @return the loja that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja updateLoja(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.updateLoja(loja);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lojaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lojaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lojaLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja addLoja(
		long companyId, long groupId, long userIdCreate,
		java.lang.String razaoSocial, java.lang.String nomeFantasia,
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		java.lang.String cnpj, java.lang.String endLogradouro,
		java.lang.String endNumero, java.lang.String endComplemento,
		java.lang.String endCep, java.lang.String endBairro,
		java.lang.String endCidade, java.lang.String endUf,
		java.lang.String endPais, double versao,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones,
		long classNameId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.addLoja(companyId, groupId, userIdCreate,
			razaoSocial, nomeFantasia, observacaoMap, cnpj, endLogradouro,
			endNumero, endComplemento, endCep, endBairro, endCidade, endUf,
			endPais, versao, enderecosEmail, telefones, classNameId,
			serviceContext);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja addLoja(
		long companyId, long groupId, long userIdCreate,
		java.lang.String razaoSocial, java.lang.String nomeFantasia,
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		java.lang.String cnpj, java.lang.String endLogradouro,
		java.lang.String endNumero, java.lang.String endComplemento,
		java.lang.String endCep, java.lang.String endBairro,
		java.lang.String endCidade, java.lang.String endUf,
		java.lang.String endPais, double versao,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones,
		long classNameId, long classPK,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.addLoja(companyId, groupId, userIdCreate,
			razaoSocial, nomeFantasia, observacaoMap, cnpj, endLogradouro,
			endNumero, endComplemento, endCep, endBairro, endCidade, endUf,
			endPais, versao, enderecosEmail, telefones, classNameId, classPK,
			serviceContext);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja update(
		long lojaId, long companyId, long groupId, long modifieduserId,
		java.lang.String razaoSocial, java.lang.String nomeFantasia,
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		java.lang.String cnpj, java.lang.String endLogradouro,
		java.lang.String endNumero, java.lang.String endComplemento,
		java.lang.String endCep, java.lang.String endBairro,
		java.lang.String endCidade, java.lang.String endUf,
		java.lang.String endPais, long userId, double versao,
		boolean ordemIndicadaAtual,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones,
		long classNameId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.update(lojaId, companyId, groupId,
			modifieduserId, razaoSocial, nomeFantasia, observacaoMap, cnpj,
			endLogradouro, endNumero, endComplemento, endCep, endBairro,
			endCidade, endUf, endPais, userId, versao, ordemIndicadaAtual,
			enderecosEmail, telefones, classNameId, serviceContext);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja moveLojaToTrash(
		long userId, br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.moveLojaToTrash(userId, loja);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja moveLojaToTrash(
		long userId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.moveLojaToTrash(userId, typeId);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja restoreLojaFromTrash(
		long userId, long lojaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.restoreLojaFromTrash(userId, lojaId);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja updateStatus(
		long userId, br.com.prodevelopment.lapidarios.loja.model.Loja loja,
		int status, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.updateStatus(userId, loja, status,
			serviceContext);
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja updateStatus(
		long userId, long lojaId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.updateStatus(userId, lojaId, status,
			serviceContext);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.lapidarios.loja.model.Loja loja,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lojaLocalService.updateAsset(userId, loja, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.search(companyId, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.searchCount(companyId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> search(
		long companyId, long groupId, java.lang.String nomeFantasia,
		int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.search(companyId, groupId, nomeFantasia,
			status, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId,
		java.lang.String nomeFantasia, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.searchCount(companyId, groupId, nomeFantasia,
			status);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> search(
		long companyId, long groupId, long classNameId, int[] status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.search(companyId, groupId, classNameId,
			status, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, long classNameId,
		int[] status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.searchCount(companyId, groupId, classNameId,
			status);
	}

	@Override
	public java.util.List<br.com.prodevelopment.lapidarios.loja.model.Loja> search(
		long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.search(companyId, groupId, classNameId,
			nomeFantasia, status, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, long classNameId,
		java.lang.String nomeFantasia, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaLocalService.searchCount(companyId, groupId, classNameId,
			nomeFantasia, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LojaLocalService getWrappedLojaLocalService() {
		return _lojaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLojaLocalService(LojaLocalService lojaLocalService) {
		_lojaLocalService = lojaLocalService;
	}

	@Override
	public LojaLocalService getWrappedService() {
		return _lojaLocalService;
	}

	@Override
	public void setWrappedService(LojaLocalService lojaLocalService) {
		_lojaLocalService = lojaLocalService;
	}

	private LojaLocalService _lojaLocalService;
}