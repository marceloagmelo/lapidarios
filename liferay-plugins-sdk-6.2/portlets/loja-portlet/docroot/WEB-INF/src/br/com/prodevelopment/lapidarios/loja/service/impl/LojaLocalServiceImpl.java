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

package br.com.prodevelopment.lapidarios.loja.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail;
import br.com.prodevelopment.lapidarios.contato.model.Telefone;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.lapidarios.loja.LojaCNPJDuplicadoException;
import br.com.prodevelopment.lapidarios.loja.LojaCNPJInvalidoException;
import br.com.prodevelopment.lapidarios.loja.LojaNomeFantasiaObrigatorioException;
import br.com.prodevelopment.lapidarios.loja.LojaRazaoSocialObrigatorioException;
import br.com.prodevelopment.lapidarios.loja.LojalteradaOutroUsuarioException;
import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.base.LojaLocalServiceBaseImpl;
import br.com.prodevelopment.lapidarios.loja.util.Helper;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.social.CadastroLojaActivityKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.SystemEventConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.trash.model.TrashEntry;

/**
 * The implementation of the loja local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.lapidarios.loja.service.LojaLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.lapidarios.loja.service.base.LojaLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil
 */
public class LojaLocalServiceImpl extends LojaLocalServiceBaseImpl {
	private static Logger _log = Logger.getLogger(LojaLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil} to
	 * access the loja local service.
	 */
	public Loja addLoja(long companyId, long groupId, long userIdCreate,
			String razaoSocial, String nomeFantasia,
			Map<Locale, String> observacaoMap, String cnpj,
			String endLogradouro, String endNumero, String endComplemento,
			String endCep, String endBairro, String endCidade, String endUf,
			String endPais, double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, long classNameId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		validate(0, razaoSocial, nomeFantasia, cnpj, userIdCreate, versao);

		User userCreate = userPersistence.findByPrimaryKey(userIdCreate);

		// Criar objeto incrementando um novo ID
		long lojaId = counterLocalService.increment();
		Loja loja = lojaPersistence.create(lojaId);

		Date now = new Date();

		// Atribui novos valores
		loja.setCompanyId(companyId);
		loja.setGroupId(groupId);
		loja.setCreateUserId(userIdCreate);
		loja.setCreateDate(now);
		loja.setRazaoSocial(razaoSocial);
		loja.setNomeFantasia(nomeFantasia);
		loja.setObservacaoMap(observacaoMap);
		loja.setCnpj(cnpj);
		loja.setEndLogradouro(endLogradouro);
		loja.setEndNumero(endNumero);
		loja.setEndComplemento(endComplemento);
		loja.setEndCep(endCep);
		loja.setEndBairro(endBairro);
		loja.setEndCidade(endCidade);
		loja.setEndUf(endUf);
		loja.setEndPais(endPais);
		loja.setClassNameId(classNameId);
		String className = PortalUtil.getClassName(classNameId);
		loja.setClassName(className);
		loja.setStatusDate(serviceContext.getModifiedDate(now));
		loja.setStatusByUserId(userCreate.getUserId());
		loja.setStatusByUserName(userCreate.getFullName());
		if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
				companyId, groupId, Loja.class.getName())) {
			loja.setStatus(WorkflowConstants.STATUS_PENDING);
		} else {
			loja.setStatus(WorkflowConstants.STATUS_APPROVED);
		}
		loja.setVersao(versao);

		lojaPersistence.update(loja);

		// Contato
		Contato contato = ContatoLocalServiceUtil.addContato(companyId,
				groupId, userIdCreate, Loja.class.getName(), loja.getLojaId(),
				nomeFantasia, null, null, null, 0, null, null, null);

		// Telefones
		TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
				userIdCreate, Contato.class.getName(), contato.getContatoId(),
				telefones);

		// Enderecços de email
		EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId, groupId,
				userIdCreate, Contato.class.getName(), contato.getContatoId(),
				enderecosEmail);

		// Asset
		updateAsset(loja.getCreateUserId(), loja,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social
		socialActivityLocalService.addActivity(userIdCreate, loja.getGroupId(),
				Loja.class.getName(), lojaId, CadastroLojaActivityKeys.ADD_LOJA,
				getExtraDataJSON(loja), 0);

		// Workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId,
				userCreate.getUserId(), Loja.class.getName(), lojaId, loja,
				serviceContext);
		Loja lojaAtiva = lojaPersistence.fetchByCG_OrdemIndicadaAtual(companyId, groupId, true, WorkflowConstants.STATUS_APPROVED);
		if (Validator.isNull(lojaAtiva)) {
			loja.setOrdemIndicadaAtual(true);
			lojaPersistence.update(loja);
		}
		
		return loja;
	}

	public Loja addLoja(long companyId, long groupId, long userIdCreate,
			String razaoSocial, String nomeFantasia,
			Map<Locale, String> observacaoMap, String cnpj,
			String endLogradouro, String endNumero, String endComplemento,
			String endCep, String endBairro, String endCidade, String endUf,
			String endPais, double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, long classNameId, long classPK,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		Loja loja = addLoja(companyId, groupId, userIdCreate, razaoSocial,
				nomeFantasia, observacaoMap, cnpj, endLogradouro, endNumero,
				endComplemento, endCep, endBairro, endCidade, endUf, endPais,
				versao, enderecosEmail, telefones, classNameId, serviceContext);
		loja.setClassPK(classPK);

		lojaPersistence.update(loja);

		return loja;
	}

	public Loja update(long lojaId, long companyId, long groupId,
			long modifieduserId, String razaoSocial, String nomeFantasia,
			Map<Locale, String> observacaoMap, String cnpj,
			String endLogradouro, String endNumero, String endComplemento,
			String endCep, String endBairro, String endCidade, String endUf,
			String endPais, long userId, double versao, boolean ordemIndicadaAtual,
			List<EnderecoEmail> enderecosEmail, List<Telefone> telefones,
			long classNameId, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(lojaId, razaoSocial, nomeFantasia, cnpj, userId, versao);

		Date now = new Date();

		// Recuperar loja
		Loja loja = lojaPersistence.fetchByPrimaryKey(lojaId);

		// Atribui novos valores
		loja.setModifiedUserId(modifieduserId);
		loja.setModifiedDate(now);
		loja.setRazaoSocial(razaoSocial);
		loja.setNomeFantasia(nomeFantasia);
		loja.setObservacaoMap(observacaoMap);
		loja.setCnpj(cnpj);
		loja.setEndLogradouro(endLogradouro);
		loja.setEndNumero(endNumero);
		loja.setEndComplemento(endComplemento);
		loja.setEndCep(endCep);
		loja.setEndBairro(endBairro);
		loja.setEndCidade(endCidade);
		loja.setEndUf(endUf);
		loja.setEndPais(endPais);
		loja.setVersao(versao+1);
		loja.setOrdemIndicadaAtual(ordemIndicadaAtual);
		
		loja = lojaPersistence.update(loja);

		// Contato
		Contato contato = ContatoLocalServiceUtil.findByContato(classNameId,
				lojaId);
		if (Validator.isNotNull(contato)) {
			ContatoLocalServiceUtil.update(contato.getContatoId(),
					modifieduserId, nomeFantasia, null, null, null, 0, null,
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
		updateAsset(modifieduserId, loja, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social
		socialActivityLocalService.addActivity(modifieduserId,
				loja.getGroupId(), Loja.class.getName(), lojaId,
				CadastroLojaActivityKeys.UPDATE_LOJA, getExtraDataJSON(loja), 0);
		return loja;

	}

	@SystemEvent(action = SystemEventConstants.ACTION_SKIP, send = false, type = SystemEventConstants.TYPE_DELETE)
	public Loja deleteLoja(Loja loja) throws SystemException {

		try {
			if (Validator.isNotNull(loja)) {
				lojaPersistence.remove(loja);

				// Asset
				assetEntryLocalService.deleteEntry(Loja.class.getName(),
						loja.getLojaId());

				// Trash
				trashEntryLocalService.deleteEntry(Loja.class.getName(),
						loja.getLojaId());
			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
			throw new SystemException();
		}

		return loja;
	}

	public Loja deleteLoja(long lojaId) throws PortalException, SystemException {

		Loja type = lojaPersistence.findByPrimaryKey(lojaId);

		return deleteLoja(type);
	}

	public Loja moveLojaToTrash(long userId, Loja loja) throws PortalException,
			SystemException {

		lojaLocalService.updateStatus(userId, loja,
				WorkflowConstants.STATUS_IN_TRASH, new ServiceContext());

		// Social
		socialActivityCounterLocalService.disableActivityCounters(
				Loja.class.getName(), loja.getLojaId());

		socialActivityLocalService.addActivity(userId, loja.getGroupId(),
				Loja.class.getName(), loja.getLojaId(),
				SocialActivityConstants.TYPE_MOVE_TO_TRASH,
				getExtraDataJSON(loja), 0);

		// Workflow
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				loja.getCompanyId(), loja.getGroupId(), Loja.class.getName(),
				loja.getLojaId());

		return loja;
	}

	public Loja moveLojaToTrash(long userId, long typeId)
			throws PortalException, SystemException {

		Loja type = lojaPersistence.findByPrimaryKey(typeId);

		return moveLojaToTrash(userId, type);
	}

	@Override
	public Loja restoreLojaFromTrash(long userId, long lojaId)
			throws PortalException, SystemException {

		Loja loja = getLoja(lojaId);

		TrashEntry trashEntry = trashEntryLocalService.getEntry(
				Loja.class.getName(), lojaId);

		lojaLocalService.updateStatus(userId, lojaId, trashEntry.getStatus(),
				new ServiceContext());

		// Social
		socialActivityCounterLocalService.enableActivityCounters(
				Loja.class.getName(), lojaId);

		socialActivityLocalService.addActivity(userId, loja.getGroupId(),
				Loja.class.getName(), lojaId,
				SocialActivityConstants.TYPE_RESTORE_FROM_TRASH,
				getExtraDataJSON(loja), 0);

		return loja;
	}

	public Loja updateStatus(long userId, Loja loja, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		// Type Task

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		int oldStatus = loja.getStatus();

		loja.setModifiedUserId(user.getUserId());
		loja.setModifiedDate(serviceContext.getModifiedDate(now));
		loja.setStatus(status);
		loja.setStatusByUserId(user.getUserId());
		loja.setStatusByUserName(user.getFullName());
		loja.setStatusDate(serviceContext.getModifiedDate(now));

		lojaPersistence.update(loja);

		// Trash

		if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
			trashEntryLocalService.deleteEntry(Loja.class.getName(),
					loja.getLojaId());

			// Workflow
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					loja.getCompanyId(), loja.getGroupId(), userId,
					Loja.class.getName(), loja.getLojaId(), loja,
					serviceContext);
		}

		if (status == WorkflowConstants.STATUS_IN_TRASH) {
			int novoStatus = WorkflowConstants.STATUS_APPROVED;
			if (WorkflowDefinitionLinkLocalServiceUtil
					.hasWorkflowDefinitionLink(loja.getCompanyId(),
							loja.getGroupId(), Loja.class.getName())) {
				novoStatus = WorkflowConstants.STATUS_PENDING;
			}

			trashEntryLocalService.addTrashEntry(userId, loja.getGroupId(),
					Loja.class.getName(), loja.getLojaId(), loja.getUuid(),
					null, novoStatus, null, null);
		}

		return loja;
	}

	public Loja updateStatus(long userId, long lojaId, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		Loja loja = lojaPersistence.findByPrimaryKey(lojaId);

		return lojaLocalService.updateStatus(userId, loja, status,
				serviceContext);
	}

	public void updateAsset(long userId, Loja loja, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds)
			throws PortalException, SystemException {

		boolean visible = true;

		String summary = HtmlUtil.extractText(StringUtil.shorten(
				loja.getNomeFantasia(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				loja.getGroupId(), loja.getCreateDate(),
				loja.getModifiedDate(), Loja.class.getName(), loja.getLojaId(),
				loja.getUuid(), 0, assetCategoryIds, assetTagNames, visible,
				null, null, null, ContentTypes.TEXT_HTML,
				loja.getNomeFantasia(), loja.getNomeFantasia(), summary, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	protected String getExtraDataJSON(Loja loja) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("nomeFantasia", loja.getNomeFantasia());

		return jsonObject.toString();
	}
	
	public List<Loja> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return lojaPersistence.findByCompany(companyId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId) throws SystemException {
		return lojaPersistence.findByCompany(companyId).size();
	}
	
	public List<Loja> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return lojaPersistence.findByCG(companyId, groupId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return lojaPersistence.findByCG(companyId, groupId).size();
	}
	
	public List<Loja> search(long companyId, long groupId, String nomeFantasia, int[] status, 
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return lojaPersistence.findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
				status, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, String nomeFantasia, int[] status)
			throws SystemException {
		return lojaPersistence.findByCG_NomeFantasia(companyId, groupId, nomeFantasia, status)
				.size();
	}
	
	public List<Loja> search(long companyId, long groupId, long classNameId, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return lojaPersistence.findByCG_ClassName(companyId,
				groupId, classNameId, status, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId, long classNameId, int[] status) throws SystemException {
		return lojaPersistence.findByCG_ClassName(companyId,
				groupId, classNameId, status).size();
	}
	
	public List<Loja> search(long companyId, long groupId, long classNameId, String nomeFantasia, int[] status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return lojaPersistence.findByCG_ClassNameNomeFantasia(companyId,
				groupId, classNameId, nomeFantasia, status, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId, long classNameId, String nomeFantasia, int[] status) throws SystemException {
		return lojaPersistence.findByCG_ClassNameNomeFantasia(companyId,
				groupId, classNameId, nomeFantasia, status).size();
	}
	
	protected void validate(long lojaId, String razaoSocial,
			String nomeFantasia, String cnpj, long userId, double versao)
			throws PortalException, SystemException {

		if (Validator.isNull(razaoSocial)) {
			throw new LojaRazaoSocialObrigatorioException();
		}
		if (Validator.isNull(nomeFantasia)) {
			throw new LojaNomeFantasiaObrigatorioException();
		}
		if ((Validator.isNotNull(cnpj)) && (!Helper.isCNPJ(cnpj))) {
			throw new LojaCNPJInvalidoException();
		} else if (Validator.isNotNull(cnpj)) {
			Loja loja = lojaPersistence.fetchByCNPJ(cnpj);
			if ((Validator.isNotNull(loja)) && (lojaId > 0)
					&& (lojaId != loja.getLojaId())) {
				throw new LojaCNPJDuplicadoException();
			}
		}
		if (lojaId > 0) {
			Loja loja = lojaPersistence.fetchByPrimaryKey(lojaId);
			if ((Validator.isNotNull(loja)) && (loja.getVersao() > versao)) {
				throw new LojalteradaOutroUsuarioException();
			}
		}
	}
}