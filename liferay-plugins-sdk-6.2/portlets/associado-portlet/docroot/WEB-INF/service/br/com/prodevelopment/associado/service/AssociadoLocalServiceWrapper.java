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

package br.com.prodevelopment.associado.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssociadoLocalService}.
 *
 * @author Marcelo Melo
 * @see AssociadoLocalService
 * @generated
 */
public class AssociadoLocalServiceWrapper implements AssociadoLocalService,
	ServiceWrapper<AssociadoLocalService> {
	public AssociadoLocalServiceWrapper(
		AssociadoLocalService associadoLocalService) {
		_associadoLocalService = associadoLocalService;
	}

	/**
	* Adds the associado to the database. Also notifies the appropriate model listeners.
	*
	* @param associado the associado
	* @return the associado that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado addAssociado(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.addAssociado(associado);
	}

	/**
	* Creates a new associado with the primary key. Does not add the associado to the database.
	*
	* @param associadoId the primary key for the new associado
	* @return the new associado
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado createAssociado(
		long associadoId) {
		return _associadoLocalService.createAssociado(associadoId);
	}

	/**
	* Deletes the associado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associadoId the primary key of the associado
	* @return the associado that was removed
	* @throws PortalException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado deleteAssociado(
		long associadoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.deleteAssociado(associadoId);
	}

	/**
	* Deletes the associado from the database. Also notifies the appropriate model listeners.
	*
	* @param associado the associado
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado deleteAssociado(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.deleteAssociado(associado);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _associadoLocalService.dynamicQuery();
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
		return _associadoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _associadoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _associadoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _associadoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _associadoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado fetchAssociado(
		long associadoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchAssociado(associadoId);
	}

	/**
	* Returns the associado with the matching UUID and company.
	*
	* @param uuid the associado's UUID
	* @param companyId the primary key of the company
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado fetchAssociadoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchAssociadoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the associado matching the UUID and group.
	*
	* @param uuid the associado's UUID
	* @param groupId the primary key of the group
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado fetchAssociadoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchAssociadoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the associado with the primary key.
	*
	* @param associadoId the primary key of the associado
	* @return the associado
	* @throws PortalException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado getAssociado(
		long associadoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.getAssociado(associadoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the associado with the matching UUID and company.
	*
	* @param uuid the associado's UUID
	* @param companyId the primary key of the company
	* @return the matching associado
	* @throws PortalException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado getAssociadoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.getAssociadoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the associado matching the UUID and group.
	*
	* @param uuid the associado's UUID
	* @param groupId the primary key of the group
	* @return the matching associado
	* @throws PortalException if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado getAssociadoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.getAssociadoByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<br.com.prodevelopment.associado.model.Associado> getAssociados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.getAssociados(start, end);
	}

	/**
	* Returns the number of associados.
	*
	* @return the number of associados
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAssociadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.getAssociadosCount();
	}

	/**
	* Updates the associado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param associado the associado
	* @return the associado that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.associado.model.Associado updateAssociado(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.updateAssociado(associado);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _associadoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_associadoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _associadoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado addAssociado(
		long companyId, long groupId, long createUserId, java.lang.String nome,
		java.lang.String tipoPessoa, java.lang.String observacao,
		java.lang.String rgInscricaoMun, java.lang.String rgOrgaoEmissor,
		java.lang.String rgDataEmissao, java.lang.String cpfCnpj,
		java.lang.String sexo, java.lang.String estadoCivil,
		java.lang.String dataNascimento, java.lang.String endComLogradouro,
		java.lang.String endComNumero, java.lang.String endComComplemento,
		java.lang.String endComCep, java.lang.String endComBairro,
		java.lang.String endComCidade, java.lang.String endComUf,
		java.lang.String endComPais, java.lang.String endResLogradouro,
		java.lang.String endResNumero, java.lang.String endResComplemento,
		java.lang.String endResCep, java.lang.String endResBairro,
		java.lang.String endResCidade, java.lang.String endResUf,
		java.lang.String endResPais, double versao,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones,
		long userId, java.lang.String idPolishop,
		java.lang.String idLojaIndicada, java.lang.String idPatrocinador,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.addAssociado(companyId, groupId,
			createUserId, nome, tipoPessoa, observacao, rgInscricaoMun,
			rgOrgaoEmissor, rgDataEmissao, cpfCnpj, sexo, estadoCivil,
			dataNascimento, endComLogradouro, endComNumero, endComComplemento,
			endComCep, endComBairro, endComCidade, endComUf, endComPais,
			endResLogradouro, endResNumero, endResComplemento, endResCep,
			endResBairro, endResCidade, endResUf, endResPais, versao,
			enderecosEmail, telefones, userId, idPolishop, idLojaIndicada,
			idPatrocinador, serviceContext);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado update(
		long associadoId, long companyId, long groupId, long modifieduserId,
		java.lang.String nome, java.lang.String tipoPessoa,
		java.lang.String observacao, java.lang.String rgInscricaoMun,
		java.lang.String rgOrgaoEmissor, java.lang.String rgDataEmissao,
		java.lang.String cpfCnpj, java.lang.String sexo,
		java.lang.String estadoCivil, java.lang.String dataNascimento,
		java.lang.String endComLogradouro, java.lang.String endComNumero,
		java.lang.String endComComplemento, java.lang.String endComCep,
		java.lang.String endComBairro, java.lang.String endComCidade,
		java.lang.String endComUf, java.lang.String endComPais,
		java.lang.String endResLogradouro, java.lang.String endResNumero,
		java.lang.String endResComplemento, java.lang.String endResCep,
		java.lang.String endResBairro, java.lang.String endResCidade,
		java.lang.String endResUf, java.lang.String endResPais, double versao,
		java.lang.String idPolishop, java.lang.String idLojaIndicada,
		java.lang.String idPatrocinador,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.lapidarios.contato.model.Telefone> telefones,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.update(associadoId, companyId, groupId,
			modifieduserId, nome, tipoPessoa, observacao, rgInscricaoMun,
			rgOrgaoEmissor, rgDataEmissao, cpfCnpj, sexo, estadoCivil,
			dataNascimento, endComLogradouro, endComNumero, endComComplemento,
			endComCep, endComBairro, endComCidade, endComUf, endComPais,
			endResLogradouro, endResNumero, endResComplemento, endResCep,
			endResBairro, endResCidade, endResUf, endResPais, versao,
			idPolishop, idLojaIndicada, idPatrocinador, enderecosEmail,
			telefones, userId, serviceContext);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado deleteAssociado(
		br.com.prodevelopment.associado.model.Associado associado, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.deleteAssociado(associado, userId);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.associado.model.Associado associado,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_associadoLocalService.updateAsset(userId, associado, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public java.util.List<br.com.prodevelopment.associado.model.Associado> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.search(companyId, groupId, nome, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.searchCount(companyId, groupId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.associado.model.Associado> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.associado.model.Associado> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.search(companyId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.searchCount(companyId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.associado.model.Associado> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.searchCount(companyId);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado fetchByUSUARIO(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchByUSUARIO(userId);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado fetchByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchByCPF_CNPJ(cpfCnpj);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado fetchByRG_INSCRICAO(
		java.lang.String rgInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchByRG_INSCRICAO(rgInscricao);
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado fetchByOD_POLISHOP(
		java.lang.String idPolishop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associadoLocalService.fetchByOD_POLISHOP(idPolishop);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AssociadoLocalService getWrappedAssociadoLocalService() {
		return _associadoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAssociadoLocalService(
		AssociadoLocalService associadoLocalService) {
		_associadoLocalService = associadoLocalService;
	}

	@Override
	public AssociadoLocalService getWrappedService() {
		return _associadoLocalService;
	}

	@Override
	public void setWrappedService(AssociadoLocalService associadoLocalService) {
		_associadoLocalService = associadoLocalService;
	}

	private AssociadoLocalService _associadoLocalService;
}