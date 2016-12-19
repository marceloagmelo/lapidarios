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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Associado. This utility wraps
 * {@link br.com.prodevelopment.associado.service.impl.AssociadoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see AssociadoLocalService
 * @see br.com.prodevelopment.associado.service.base.AssociadoLocalServiceBaseImpl
 * @see br.com.prodevelopment.associado.service.impl.AssociadoLocalServiceImpl
 * @generated
 */
public class AssociadoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.associado.service.impl.AssociadoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the associado to the database. Also notifies the appropriate model listeners.
	*
	* @param associado the associado
	* @return the associado that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado addAssociado(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAssociado(associado);
	}

	/**
	* Creates a new associado with the primary key. Does not add the associado to the database.
	*
	* @param associadoId the primary key for the new associado
	* @return the new associado
	*/
	public static br.com.prodevelopment.associado.model.Associado createAssociado(
		long associadoId) {
		return getService().createAssociado(associadoId);
	}

	/**
	* Deletes the associado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associadoId the primary key of the associado
	* @return the associado that was removed
	* @throws PortalException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado deleteAssociado(
		long associadoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAssociado(associadoId);
	}

	/**
	* Deletes the associado from the database. Also notifies the appropriate model listeners.
	*
	* @param associado the associado
	* @return the associado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado deleteAssociado(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAssociado(associado);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.associado.model.Associado fetchAssociado(
		long associadoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAssociado(associadoId);
	}

	/**
	* Returns the associado with the matching UUID and company.
	*
	* @param uuid the associado's UUID
	* @param companyId the primary key of the company
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado fetchAssociadoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAssociadoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the associado matching the UUID and group.
	*
	* @param uuid the associado's UUID
	* @param groupId the primary key of the group
	* @return the matching associado, or <code>null</code> if a matching associado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado fetchAssociadoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAssociadoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the associado with the primary key.
	*
	* @param associadoId the primary key of the associado
	* @return the associado
	* @throws PortalException if a associado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado getAssociado(
		long associadoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssociado(associadoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static br.com.prodevelopment.associado.model.Associado getAssociadoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssociadoByUuidAndCompanyId(uuid, companyId);
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
	public static br.com.prodevelopment.associado.model.Associado getAssociadoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssociadoByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<br.com.prodevelopment.associado.model.Associado> getAssociados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssociados(start, end);
	}

	/**
	* Returns the number of associados.
	*
	* @return the number of associados
	* @throws SystemException if a system exception occurred
	*/
	public static int getAssociadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssociadosCount();
	}

	/**
	* Updates the associado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param associado the associado
	* @return the associado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.associado.model.Associado updateAssociado(
		br.com.prodevelopment.associado.model.Associado associado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAssociado(associado);
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

	public static br.com.prodevelopment.associado.model.Associado addAssociado(
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
		return getService()
				   .addAssociado(companyId, groupId, createUserId, nome,
			tipoPessoa, observacao, rgInscricaoMun, rgOrgaoEmissor,
			rgDataEmissao, cpfCnpj, sexo, estadoCivil, dataNascimento,
			endComLogradouro, endComNumero, endComComplemento, endComCep,
			endComBairro, endComCidade, endComUf, endComPais, endResLogradouro,
			endResNumero, endResComplemento, endResCep, endResBairro,
			endResCidade, endResUf, endResPais, versao, enderecosEmail,
			telefones, userId, idPolishop, idLojaIndicada, idPatrocinador,
			serviceContext);
	}

	public static br.com.prodevelopment.associado.model.Associado update(
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
		return getService()
				   .update(associadoId, companyId, groupId, modifieduserId,
			nome, tipoPessoa, observacao, rgInscricaoMun, rgOrgaoEmissor,
			rgDataEmissao, cpfCnpj, sexo, estadoCivil, dataNascimento,
			endComLogradouro, endComNumero, endComComplemento, endComCep,
			endComBairro, endComCidade, endComUf, endComPais, endResLogradouro,
			endResNumero, endResComplemento, endResCep, endResBairro,
			endResCidade, endResUf, endResPais, versao, idPolishop,
			idLojaIndicada, idPatrocinador, enderecosEmail, telefones, userId,
			serviceContext);
	}

	public static br.com.prodevelopment.associado.model.Associado deleteAssociado(
		br.com.prodevelopment.associado.model.Associado associado, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAssociado(associado, userId);
	}

	public static void updateAsset(long userId,
		br.com.prodevelopment.associado.model.Associado associado,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, associado, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static java.util.List<br.com.prodevelopment.associado.model.Associado> search(
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

	public static java.util.List<br.com.prodevelopment.associado.model.Associado> search(
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

	public static java.util.List<br.com.prodevelopment.associado.model.Associado> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, nome, start, end, orderByComparator);
	}

	public static int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, nome);
	}

	public static java.util.List<br.com.prodevelopment.associado.model.Associado> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, start, end, orderByComparator);
	}

	public static int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId);
	}

	public static br.com.prodevelopment.associado.model.Associado fetchByUSUARIO(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByUSUARIO(userId);
	}

	public static br.com.prodevelopment.associado.model.Associado fetchByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByCPF_CNPJ(cpfCnpj);
	}

	public static br.com.prodevelopment.associado.model.Associado fetchByRG_INSCRICAO(
		java.lang.String rgInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByRG_INSCRICAO(rgInscricao);
	}

	public static br.com.prodevelopment.associado.model.Associado fetchByOD_POLISHOP(
		java.lang.String idPolishop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByOD_POLISHOP(idPolishop);
	}

	public static void clearService() {
		_service = null;
	}

	public static AssociadoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AssociadoLocalService.class.getName());

			if (invokableLocalService instanceof AssociadoLocalService) {
				_service = (AssociadoLocalService)invokableLocalService;
			}
			else {
				_service = new AssociadoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AssociadoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AssociadoLocalService service) {
	}

	private static AssociadoLocalService _service;
}