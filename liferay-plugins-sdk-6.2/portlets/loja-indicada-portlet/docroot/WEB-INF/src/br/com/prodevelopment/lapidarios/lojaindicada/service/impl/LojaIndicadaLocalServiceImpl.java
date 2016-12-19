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

package br.com.prodevelopment.lapidarios.lojaindicada.service.impl;

import java.util.Date;
import java.util.List;

import br.com.prodevelopment.lapidarios.lojaindicada.LojaIndicadaIdLojaObrigatorioException;
import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.lojaindicada.service.base.LojaIndicadaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the loja indicada local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.lapidarios.lojaindicada.service.LojaIndicadaLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.lojaindicada.service.base.LojaIndicadaLocalServiceBaseImpl
 * @see br.com.prodevelopment.lapidarios.lojaindicada.service.LojaIndicadaLocalServiceUtil
 */
public class LojaIndicadaLocalServiceImpl extends
		LojaIndicadaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment
	 * .lapidarios.lojaindicada.service.LojaIndicadaLocalServiceUtil} to access
	 * the loja indicada local service.
	 */
	public LojaIndicada addLojaIndicada(long companyId, long groupId,
			long userId, String idLoja) throws SystemException, PortalException {

		validate(idLoja);

		int count = lojaIndicadaPersistence.findByCG(companyId, groupId).size();

		// Criar objeto incrementando um novo ID
		long lojaIndicadaId = counterLocalService.increment();
		LojaIndicada lojaIndicada = lojaIndicadaPersistence
				.create(lojaIndicadaId);

		Date now = new Date();

		// Atribui novos valores
		lojaIndicada.setCompanyId(companyId);
		lojaIndicada.setGroupId(groupId);
		lojaIndicada.setCreateUserId(userId);
		lojaIndicada.setCreateDate(now);
		lojaIndicada.setIdLoja(idLoja);
		if (count > 0) {
			lojaIndicada.setLojaIndicadaAtual(false);

		} else {
			lojaIndicada.setLojaIndicadaAtual(true);
		}

		lojaIndicadaPersistence.update(lojaIndicada);

		return lojaIndicada;
	}

	public LojaIndicada update(long lojaIndicadaId, long companyId,
			long groupId, long userId, String idLoja, boolean lojaIndicadaAtual)
			throws SystemException, PortalException {

		validate(idLoja);

		// Recuperar loja indicada
		LojaIndicada lojaIndicada = lojaIndicadaPersistence
				.fetchByPrimaryKey(lojaIndicadaId);

		Date now = new Date();

		// Atribui novos valores
		lojaIndicada.setCompanyId(companyId);
		lojaIndicada.setGroupId(groupId);
		lojaIndicada.setModifiedUserId(userId);
		lojaIndicada.setModifiedDate(now);
		lojaIndicada.setIdLoja(idLoja);
		lojaIndicada.setLojaIndicadaAtual(lojaIndicadaAtual);

		lojaIndicadaPersistence.update(lojaIndicada);

		return lojaIndicada;
	}

	public LojaIndicada deleteLojaIndicada(long lojaIndicadaId)
			throws PortalException, SystemException {

		LojaIndicada lojaIndicada = lojaIndicadaPersistence
				.findByPrimaryKey(lojaIndicadaId);
		if (Validator.isNotNull(lojaIndicada)) {
			lojaIndicadaPersistence.remove(lojaIndicada);
		}

		return lojaIndicada;
	}

	public List<LojaIndicada> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return lojaIndicadaPersistence.findByCompany(companyId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId) throws SystemException {
		return lojaIndicadaPersistence.findByCompany(companyId).size();
	}

	public List<LojaIndicada> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return lojaIndicadaPersistence.findByCG(companyId, groupId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return lojaIndicadaPersistence.findByCG(companyId, groupId).size();
	}

	public List<LojaIndicada> search(long companyId, long groupId,
			String idLoja, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return lojaIndicadaPersistence.findByCG_IdLoja(companyId, groupId,
				idLoja, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, String idLoja)
			throws SystemException {
		return lojaIndicadaPersistence.findByCG_IdLoja(companyId, groupId,
				idLoja).size();
	}

	public LojaIndicada findLojaIndicadaAtual(long companyId, long groupId)
			throws SystemException {
		return lojaIndicadaPersistence.fetchByCG_lojaIndicadaAtual(companyId,
				groupId, true);
	}

	protected void validate(String idLoja) throws PortalException,
			SystemException {

		if (Validator.isNull(idLoja)) {
			throw new LojaIndicadaIdLojaObrigatorioException();
		}
	}
}