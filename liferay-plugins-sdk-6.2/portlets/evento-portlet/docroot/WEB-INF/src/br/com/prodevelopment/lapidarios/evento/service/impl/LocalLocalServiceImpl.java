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

package br.com.prodevelopment.lapidarios.evento.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail;
import br.com.prodevelopment.lapidarios.contato.model.Telefone;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.lapidarios.evento.LocalAlteradoOutroUsuarioException;
import br.com.prodevelopment.lapidarios.evento.LocalNomeObrigatorioException;
import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.service.base.LocalLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the local local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.lapidarios.evento.service.LocalLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.base.LocalLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil
 */
public class LocalLocalServiceImpl extends LocalLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil} to
	 * access the local local service.
	 */
	public Local addLocal(long companyId, long groupId, long userIdCreate,
			String nome, Map<Locale, String> pontoReferenciaMap,
			String endLogradouro, String endNumero, String endComplemento,
			String endCep, String endBairro, String endCidade, String endUf,
			String endPais, double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones) throws SystemException, PortalException {

		validate(0, nome, userIdCreate, versao);

		// Criar objeto incrementando um novo ID
		long localId = counterLocalService.increment();
		Local local = localPersistence.create(localId);

		Date now = new Date();

		// Atribui novos valores
		local.setCompanyId(companyId);
		local.setGroupId(groupId);
		local.setCreateUserId(userIdCreate);
		local.setCreateDate(now);
		local.setNome(nome);
		local.setPontoReferenciaMap(pontoReferenciaMap);
		local.setEndLogradouro(endLogradouro);
		local.setEndNumero(endNumero);
		local.setEndComplemento(endComplemento);
		local.setEndCep(endCep);
		local.setEndCidade(endCidade);
		local.setEndUf(endUf);
		local.setEndPais(endPais);
		local.setVersao(versao);

		localPersistence.update(local);

		// Contato
		Contato contato = ContatoLocalServiceUtil
				.addContato(companyId, groupId, userIdCreate,
						Local.class.getName(), local.getLocalId(), nome, null,
						null, null, 0, null, null, null);

		// Telefones
		TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
				userIdCreate, Contato.class.getName(), contato.getContatoId(),
				telefones);

		// Enderecços de email
		EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId, groupId,
				userIdCreate, Contato.class.getName(), contato.getContatoId(),
				enderecosEmail);

		return local;
	}

	public Local update(long localId, long companyId, long groupId,
			long modifieduserId, String nome,
			Map<Locale, String> pontoReferenciaMap, String endLogradouro,
			String endNumero, String endComplemento, String endCep,
			String endBairro, String endCidade, String endUf, String endPais,
			double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, long classNameId) throws SystemException,
			PortalException {

		validate(localId, nome, modifieduserId, versao);

		Date now = new Date();

		// Recuperar local
		Local local = localPersistence.fetchByPrimaryKey(localId);

		// Atribui novos valores
		local.setModifiedUserId(modifieduserId);
		local.setModifiedDate(now);
		local.setNome(nome);
		local.setPontoReferenciaMap(pontoReferenciaMap);
		local.setEndLogradouro(endLogradouro);
		local.setEndNumero(endNumero);
		local.setEndComplemento(endComplemento);
		local.setEndCep(endCep);
		local.setEndCidade(endCidade);
		local.setEndUf(endUf);
		local.setEndPais(endPais);
		local.setVersao(versao + 1);

		local = localPersistence.update(local);

		// Contato
		Contato contato = ContatoLocalServiceUtil.findByContato(classNameId,
				localId);
		if (Validator.isNotNull(contato)) {
			ContatoLocalServiceUtil
					.update(contato.getContatoId(), modifieduserId, nome, null,
							null, null, 0, null, null, null);

			// Telefones
			TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
					modifieduserId, Contato.class.getName(),
					contato.getContatoId(), telefones);

			// Enderecços de email
			EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId,
					groupId, modifieduserId, Contato.class.getName(),
					contato.getContatoId(), enderecosEmail);
		}
		return local;

	}

	public Local deleteLocal(long localId) throws PortalException,
			SystemException {

		Local type = localPersistence.findByPrimaryKey(localId);

		return deleteLocal(type);
	}

	public List<Local> search(long companyId, long groupId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return localPersistence.findByCG(companyId, groupId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return localPersistence.findByCG(companyId, groupId).size();
	}

	public List<Local> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return localPersistence.findByCG_Nome(companyId, groupId, nome, start,
				end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return localPersistence.findByCG_Nome(companyId, groupId, nome).size();
	}

	protected void validate(long localId, String nome, long userId,
			double versao) throws PortalException, SystemException {

		if (Validator.isNull(nome)) {
			throw new LocalNomeObrigatorioException();
		}
		if (localId > 0) {
			Local local = localPersistence.fetchByPrimaryKey(localId);
			if ((Validator.isNotNull(local)) && (local.getVersao() > versao)) {
				throw new LocalAlteradoOutroUsuarioException();
			}
		}
	}
}