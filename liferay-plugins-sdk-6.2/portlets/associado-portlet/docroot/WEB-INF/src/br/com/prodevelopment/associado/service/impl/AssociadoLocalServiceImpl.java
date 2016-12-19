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

package br.com.prodevelopment.associado.service.impl;

import java.util.Date;
import java.util.List;

import br.com.prodevelopment.associado.AssociadoAlteradoOutroUsuarioException;
import br.com.prodevelopment.associado.AssociadoCNPJDuplicadoException;
import br.com.prodevelopment.associado.AssociadoCNPJInvalidoException;
import br.com.prodevelopment.associado.AssociadoCPFDuplicadoException;
import br.com.prodevelopment.associado.AssociadoCPFInvalidoException;
import br.com.prodevelopment.associado.AssociadoDataNascimentoInvalidaException;
import br.com.prodevelopment.associado.AssociadoIDPolishopDuplicadoException;
import br.com.prodevelopment.associado.AssociadoNomeObrigatorioException;
import br.com.prodevelopment.associado.AssociadoRGDataEmissaoInvalidaException;
import br.com.prodevelopment.associado.AssociadoRGInscricaoMunDuplicadoException;
import br.com.prodevelopment.associado.AssociadoUsuarioDuplicadoException;
import br.com.prodevelopment.associado.model.Associado;
import br.com.prodevelopment.associado.service.base.AssociadoLocalServiceBaseImpl;
import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail;
import br.com.prodevelopment.lapidarios.contato.model.Telefone;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.portlet.associado.Constantes;
import br.com.prodevelopment.portlet.associado.social.AssociadoActivityKeys;
import br.com.prodevelopment.portlet.associado.util.DateUtil;
import br.com.prodevelopment.portlet.associado.util.Helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the associado local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.associado.service.AssociadoLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.associado.service.base.AssociadoLocalServiceBaseImpl
 * @see br.com.prodevelopment.associado.service.AssociadoLocalServiceUtil
 */
public class AssociadoLocalServiceImpl extends AssociadoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.associado.service.AssociadoLocalServiceUtil} to
	 * access the associado local service.
	 */
	public Associado addAssociado(long companyId, long groupId,
			long createUserId, String nome, String tipoPessoa,
			String observacao, String rgInscricaoMun, String rgOrgaoEmissor,
			String rgDataEmissao, String cpfCnpj, String sexo,
			String estadoCivil, String dataNascimento, String endComLogradouro,
			String endComNumero, String endComComplemento, String endComCep,
			String endComBairro, String endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResNumero,
			String endResComplemento, String endResCep, String endResBairro,
			String endResCidade, String endResUf, String endResPais,
			double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, long userId, String idPolishop,
			String idLojaIndicada, String idPatrocinador,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		validate(0, nome, tipoPessoa, cpfCnpj, rgInscricaoMun, rgDataEmissao,
				dataNascimento, userId, versao, idPolishop);

		Date now = DateUtil.getDataAtual();

		Date dRgDataEmissao = null;
		Date dDataNascimento = null;
		if (Validator.isNotNull(rgDataEmissao)) {
			dRgDataEmissao = DateUtil.stringToDate(rgDataEmissao);
		}
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}

		// Criar objeto incrementando um novo ID
		Associado associado = associadoPersistence.create(counterLocalService
				.increment(Associado.class.getName()));

		// Atribui novos valores
		associado.setCompanyId(companyId);
		associado.setGroupId(groupId);
		associado.setCreateUserId(createUserId);
		associado.setCreateDate(now);
		associado.setTipoPessoa(tipoPessoa);
		associado.setNome(nome);
		associado.setObservacao(observacao);
		associado.setCpfCnpj(cpfCnpj);
		associado.setDataNascimento(dDataNascimento);
		associado.setEstadoCivil(estadoCivil);
		associado.setRgInscricaoMun(rgInscricaoMun);
		associado.setRgDataEmissao(dRgDataEmissao);
		associado.setRgOrgaoEmissor(rgOrgaoEmissor);
		associado.setSexo(sexo);
		associado.setVersao(versao);
		associado.setEndComLogradouro(endComLogradouro);
		associado.setEndComNumero(endComNumero);
		associado.setEndComComplemento(endComComplemento);
		associado.setEndComCep(endComCep);
		associado.setEndComBairro(endComBairro);
		associado.setEndComCidade(endComCidade);
		associado.setEndComUf(endComUf);
		associado.setEndComPais(endComPais);
		associado.setEndResLogradouro(endResLogradouro);
		associado.setEndResNumero(endResNumero);
		associado.setEndResComplemento(endResComplemento);
		associado.setEndResCep(endResCep);
		associado.setEndResBairro(endResBairro);
		associado.setEndResCidade(endResCidade);
		associado.setEndResUf(endResUf);
		associado.setEndResPais(endResPais);
		associado.setUserId(userId);
		associado.setIdPolishop(idPolishop);
		associado.setIdLojaIndicada(idLojaIndicada);
		associado.setIdPatrocinador(idPatrocinador);

		associado.setNew(true);

		associado = associadoPersistence.update(associado);

		// Contato
		Contato contato = ContatoLocalServiceUtil.addContato(companyId,
				groupId, createUserId, Associado.class.getName(),
				associado.getAssociadoId(), nome, null, sexo, dataNascimento,
				0, null, null, null);

		// Telefones
		if (Validator.isNotNull(telefones)) {
			TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
					createUserId, Contato.class.getName(), contato.getContatoId(),
					telefones);
		}

		// Enderecços de email
		if (Validator.isNotNull(enderecosEmail)) {
			EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId, groupId,
					createUserId, Contato.class.getName(), contato.getContatoId(),
					enderecosEmail);
		}

		// Asset
		updateAsset(associado.getCreateUserId(), associado,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", associado.getNome());

		socialActivityLocalService.addActivity(associado.getCreateUserId(),
				associado.getGroupId(), Associado.class.getName(),
				associado.getAssociadoId(), AssociadoActivityKeys.ADD_CLIENTE,
				extraDataJSONObject.toString(), 0);

		return associado;
	}

	public Associado update(long associadoId, long companyId, long groupId,
			long modifieduserId, String nome, String tipoPessoa,
			String observacao, String rgInscricaoMun, String rgOrgaoEmissor,
			String rgDataEmissao, String cpfCnpj, String sexo,
			String estadoCivil, String dataNascimento, String endComLogradouro,
			String endComNumero, String endComComplemento, String endComCep,
			String endComBairro, String endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResNumero,
			String endResComplemento, String endResCep, String endResBairro,
			String endResCidade, String endResUf, String endResPais,
			double versao, String idPolishop, String idLojaIndicada,
			String idPatrocinador, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, long userId, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(associadoId, nome, tipoPessoa, cpfCnpj, rgInscricaoMun,
				rgDataEmissao, dataNascimento, userId, versao, idPolishop);

		Date now = DateUtil.getDataAtual();

		Date dRgDataEmissao = null;
		Date dDataNascimento = null;
		if (Validator.isNotNull(rgDataEmissao)) {
			dRgDataEmissao = DateUtil.stringToDate(rgDataEmissao);
		}
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}

		// Recuperar associado
		Associado associado = associadoPersistence
				.fetchByPrimaryKey(associadoId);

		// Atribui novos valores
		associado.setModifiedUserId(modifieduserId);
		associado.setModifiedDate(now);
		associado.setTipoPessoa(tipoPessoa);
		associado.setNome(nome);
		associado.setObservacao(observacao);
		associado.setCpfCnpj(cpfCnpj);
		associado.setDataNascimento(dDataNascimento);
		associado.setEstadoCivil(estadoCivil);
		associado.setRgInscricaoMun(rgInscricaoMun);
		associado.setRgDataEmissao(dRgDataEmissao);
		associado.setRgOrgaoEmissor(rgOrgaoEmissor);
		associado.setSexo(sexo);
		associado.setVersao(versao + 1);
		associado.setEndComLogradouro(endComLogradouro);
		associado.setEndComNumero(endComNumero);
		associado.setEndComComplemento(endComComplemento);
		associado.setEndComCep(endComCep);
		associado.setEndComBairro(endComBairro);
		associado.setEndComCidade(endComCidade);
		associado.setEndComUf(endComUf);
		associado.setEndComPais(endComPais);
		associado.setEndResLogradouro(endResLogradouro);
		associado.setEndResNumero(endResNumero);
		associado.setEndResComplemento(endResComplemento);
		associado.setEndResCep(endResCep);
		associado.setEndResBairro(endResBairro);
		associado.setEndResCidade(endResCidade);
		associado.setEndResUf(endResUf);
		associado.setEndResPais(endResPais);
		associado.setUserId(userId);
		associado.setIdPolishop(idPolishop);
		associado.setIdLojaIndicada(idLojaIndicada);
		associado.setIdPatrocinador(idPatrocinador);

		associado = associadoPersistence.update(associado);

		// Contato
		long classNameId = PortalUtil.getClassNameId(Associado.class.getName());
		Contato contato = ContatoLocalServiceUtil.findByContato(classNameId,
				associadoId);
		if (Validator.isNotNull(contato)) {
			ContatoLocalServiceUtil.update(contato.getContatoId(),
					modifieduserId, nome, null, sexo, dataNascimento, 0, null,
					null, null);

			// Telefones
			TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
					modifieduserId, Contato.class.getName(),
					contato.getContatoId(), telefones);

			// Enderecços de email
			EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId,
					groupId, modifieduserId, Contato.class.getName(),
					contato.getContatoId(), enderecosEmail);
		}

		// Asset
		updateAsset(associado.getModifiedUserId(), associado,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", associado.getNome());

		socialActivityLocalService.addActivity(associado.getModifiedUserId(),
				associado.getGroupId(), Associado.class.getName(),
				associado.getAssociadoId(),
				AssociadoActivityKeys.UPDATE_CLIENTE,
				extraDataJSONObject.toString(), 0);

		return associado;

	}

	public Associado deleteAssociado(Associado associado, long userId)
			throws SystemException {

		try {

			associado = super.deleteAssociado(associado);

			// Contato
			long classNameId = PortalUtil.getClassNameId(Associado.class
					.getName());
			Contato contato = ContatoLocalServiceUtil.findByContato(
					classNameId, associado.getAssociadoId());
			if (Validator.isNotNull(contato)) {
				ContatoLocalServiceUtil.deleteContato(contato);

				// Telefones
				TelefoneLocalServiceUtil.deleteTelefones(
						associado.getCompanyId(), Contato.class.getName(),
						contato.getContatoId());

				// Enderecços de email
				EnderecoEmailLocalServiceUtil.deleteEnderecosEmail(
						associado.getCompanyId(), Contato.class.getName(),
						contato.getContatoId());
			}

			// Asset

			assetEntryLocalService.deleteEntry(Associado.class.getName(),
					associado.getAssociadoId());

			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("nome", associado.getNome());

			socialActivityLocalService.addActivity(userId,
					associado.getGroupId(), Associado.class.getName(),
					associado.getAssociadoId(),
					AssociadoActivityKeys.DELETE_CLIENTE,
					extraDataJSONObject.toString(), 0);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return associado;
	}

	public void updateAsset(long userId, Associado associado,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				associado.getGroupId(), associado.getCreateDate(),
				associado.getModifiedDate(), Associado.class.getName(),
				associado.getAssociadoId(), StringPool.BLANK, 0,
				assetCategoryIds, assetTagNames, true, null, null, null,
				ContentTypes.TEXT_HTML, associado.getNome(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	public List<Associado> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return associadoPersistence.findByC_G_NOME(companyId, groupId, nome,
				start, end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return associadoPersistence.findByC_G_NOME(companyId, groupId, nome)
				.size();
	}

	public List<Associado> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return associadoPersistence.findByC_G(companyId, groupId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return associadoPersistence.findByC_G(companyId, groupId).size();
	}

	public List<Associado> search(long companyId, String nome, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {

		return associadoPersistence.findByC_NOME(companyId, nome, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, String nome) throws SystemException {
		return associadoPersistence.findByC_NOME(companyId, nome).size();
	}

	public List<Associado> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return associadoPersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return associadoPersistence.findByCompany(companyId).size();
	}

	public Associado fetchByUSUARIO(long userId) throws SystemException {
		return associadoPersistence.fetchByUSUARIO(userId);
	}

	public Associado fetchByCPF_CNPJ(String cpfCnpj) throws SystemException {
		return associadoPersistence.fetchByCPF_CNPJ(cpfCnpj);
	}

	public Associado fetchByRG_INSCRICAO(String rgInscricao)
			throws SystemException {
		return associadoPersistence.fetchByRG_INSCRICAO(rgInscricao);
	}

	public Associado fetchByOD_POLISHOP(String idPolishop)
			throws SystemException {
		return associadoPersistence.fetchByID_POLISHOP(idPolishop);
	}

	protected void validate(long associadoId, String nome, String tipoPessoa,
			String cpfCnpj, String rgInscricaoMun, String rgDataEmissao,
			String dataNascimento, long userId, double versao, String idPolishop)
			throws PortalException, SystemException {

		if (Validator.isNull(nome)) {
			throw new AssociadoNomeObrigatorioException();
		}
		if ((Validator.isNotNull(cpfCnpj))
				&& (Constantes.PESSOA_FISICA.equals(tipoPessoa))
				&& (!Helper.isCPF(cpfCnpj))) {
			throw new AssociadoCPFInvalidoException();
		} else if (Validator.isNotNull(cpfCnpj)) {
			Associado associado = associadoPersistence.fetchByCPF_CNPJ(cpfCnpj);
			if ((Validator.isNotNull(associado)) && (associadoId > 0)
					&& (associadoId != associado.getAssociadoId())) {
				throw new AssociadoCPFDuplicadoException();
			}
		}
		if ((Validator.isNotNull(cpfCnpj))
				&& (Constantes.PESSOA_JURIDICA.equals(tipoPessoa))
				&& (!Helper.isCNPJ(cpfCnpj))) {
			throw new AssociadoCNPJInvalidoException();
		} else if (Validator.isNotNull(cpfCnpj)) {
			Associado associado = associadoPersistence.fetchByCPF_CNPJ(cpfCnpj);
			if ((Validator.isNotNull(associado)) && (associadoId > 0)
					&& (associadoId != associado.getAssociadoId())) {
				throw new AssociadoCNPJDuplicadoException();
			}
		}
		if (Validator.isNotNull(rgInscricaoMun)) {
			Associado associado = associadoPersistence
					.fetchByRG_INSCRICAO(rgInscricaoMun);
			if ((Validator.isNotNull(associado)) && (associadoId > 0)
					&& (associadoId != associado.getAssociadoId())) {
				throw new AssociadoRGInscricaoMunDuplicadoException();
			}
		}
		if ((Validator.isNotNull(rgDataEmissao))
				&& (!DateUtil.isValidDate(rgDataEmissao, "dd/MM/yyyy"))) {
			throw new AssociadoRGDataEmissaoInvalidaException();
		}
		if ((Validator.isNotNull(dataNascimento))
				&& (!DateUtil.isValidDate(dataNascimento, "dd/MM/yyyy"))) {
			throw new AssociadoDataNascimentoInvalidaException();
		}
		if (userId > 0) {
			Associado associado = associadoPersistence.fetchByUSUARIO(userId);
			if ((Validator.isNotNull(associado))
					&& (associadoId != associado.getAssociadoId())
					&& (userId == associado.getUserId())) {
				throw new AssociadoUsuarioDuplicadoException();
			}
		}
		if (associadoId > 0) {
			Associado associado = associadoPersistence
					.fetchByPrimaryKey(associadoId);
			if ((Validator.isNotNull(associado))
					&& (associado.getVersao() > versao)) {
				throw new AssociadoAlteradoOutroUsuarioException();
			}
		}
		/*if ( (associadoId == 0) && (Validator.isNotNull(idPolishop)) ) {
			Associado associado = associadoPersistence
					.fetchByID_POLISHOP(idPolishop);
			if (Validator.isNotNull(associado)) {
				throw new AssociadoIDPolishopDuplicadoException();
			}
		}*/
	}
}