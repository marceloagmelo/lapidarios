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

package br.com.prodevelopment.lapidarios.loja.model;

import br.com.prodevelopment.lapidarios.loja.service.ClpSerializer;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.ContainerModel;
import com.liferay.portal.model.TrashedModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Marcelo Melo
 */
public class LojaClp extends BaseModelImpl<Loja> implements Loja {
	public LojaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Loja.class;
	}

	@Override
	public String getModelClassName() {
		return Loja.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lojaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLojaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lojaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("lojaId", getLojaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("razaoSocial", getRazaoSocial());
		attributes.put("nomeFantasia", getNomeFantasia());
		attributes.put("observacao", getObservacao());
		attributes.put("cnpj", getCnpj());
		attributes.put("endLogradouro", getEndLogradouro());
		attributes.put("endNumero", getEndNumero());
		attributes.put("endComplemento", getEndComplemento());
		attributes.put("endCep", getEndCep());
		attributes.put("endBairro", getEndBairro());
		attributes.put("endCidade", getEndCidade());
		attributes.put("endUf", getEndUf());
		attributes.put("endPais", getEndPais());
		attributes.put("versao", getVersao());
		attributes.put("ordemIndicada", getOrdemIndicada());
		attributes.put("ordemIndicadaAtual", getOrdemIndicadaAtual());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long lojaId = (Long)attributes.get("lojaId");

		if (lojaId != null) {
			setLojaId(lojaId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String razaoSocial = (String)attributes.get("razaoSocial");

		if (razaoSocial != null) {
			setRazaoSocial(razaoSocial);
		}

		String nomeFantasia = (String)attributes.get("nomeFantasia");

		if (nomeFantasia != null) {
			setNomeFantasia(nomeFantasia);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}

		String cnpj = (String)attributes.get("cnpj");

		if (cnpj != null) {
			setCnpj(cnpj);
		}

		String endLogradouro = (String)attributes.get("endLogradouro");

		if (endLogradouro != null) {
			setEndLogradouro(endLogradouro);
		}

		String endNumero = (String)attributes.get("endNumero");

		if (endNumero != null) {
			setEndNumero(endNumero);
		}

		String endComplemento = (String)attributes.get("endComplemento");

		if (endComplemento != null) {
			setEndComplemento(endComplemento);
		}

		String endCep = (String)attributes.get("endCep");

		if (endCep != null) {
			setEndCep(endCep);
		}

		String endBairro = (String)attributes.get("endBairro");

		if (endBairro != null) {
			setEndBairro(endBairro);
		}

		String endCidade = (String)attributes.get("endCidade");

		if (endCidade != null) {
			setEndCidade(endCidade);
		}

		String endUf = (String)attributes.get("endUf");

		if (endUf != null) {
			setEndUf(endUf);
		}

		String endPais = (String)attributes.get("endPais");

		if (endPais != null) {
			setEndPais(endPais);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}

		Integer ordemIndicada = (Integer)attributes.get("ordemIndicada");

		if (ordemIndicada != null) {
			setOrdemIndicada(ordemIndicada);
		}

		Boolean ordemIndicadaAtual = (Boolean)attributes.get(
				"ordemIndicadaAtual");

		if (ordemIndicadaAtual != null) {
			setOrdemIndicadaAtual(ordemIndicadaAtual);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_lojaRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLojaId() {
		return _lojaId;
	}

	@Override
	public void setLojaId(long lojaId) {
		_lojaId = lojaId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setLojaId", long.class);

				method.invoke(_lojaRemoteModel, lojaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_lojaRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_lojaRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_lojaRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	@Override
	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_lojaRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_lojaRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_lojaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRazaoSocial() {
		return _razaoSocial;
	}

	@Override
	public void setRazaoSocial(String razaoSocial) {
		_razaoSocial = razaoSocial;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setRazaoSocial", String.class);

				method.invoke(_lojaRemoteModel, razaoSocial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeFantasia() {
		return _nomeFantasia;
	}

	@Override
	public void setNomeFantasia(String nomeFantasia) {
		_nomeFantasia = nomeFantasia;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeFantasia", String.class);

				method.invoke(_lojaRemoteModel, nomeFantasia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObservacao() {
		return _observacao;
	}

	@Override
	public String getObservacao(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getObservacao(languageId);
	}

	@Override
	public String getObservacao(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getObservacao(languageId, useDefault);
	}

	@Override
	public String getObservacao(String languageId) {
		return LocalizationUtil.getLocalization(getObservacao(), languageId);
	}

	@Override
	public String getObservacao(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getObservacao(), languageId,
			useDefault);
	}

	@Override
	public String getObservacaoCurrentLanguageId() {
		return _observacaoCurrentLanguageId;
	}

	@Override
	public String getObservacaoCurrentValue() {
		Locale locale = getLocale(_observacaoCurrentLanguageId);

		return getObservacao(locale);
	}

	@Override
	public Map<Locale, String> getObservacaoMap() {
		return LocalizationUtil.getLocalizationMap(getObservacao());
	}

	@Override
	public void setObservacao(String observacao) {
		_observacao = observacao;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_lojaRemoteModel, observacao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setObservacao(String observacao, Locale locale) {
		setObservacao(observacao, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setObservacao(String observacao, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(observacao)) {
			setObservacao(LocalizationUtil.updateLocalization(getObservacao(),
					"Observacao", observacao, languageId, defaultLanguageId));
		}
		else {
			setObservacao(LocalizationUtil.removeLocalization(getObservacao(),
					"Observacao", languageId));
		}
	}

	@Override
	public void setObservacaoCurrentLanguageId(String languageId) {
		_observacaoCurrentLanguageId = languageId;
	}

	@Override
	public void setObservacaoMap(Map<Locale, String> observacaoMap) {
		setObservacaoMap(observacaoMap, LocaleUtil.getDefault());
	}

	@Override
	public void setObservacaoMap(Map<Locale, String> observacaoMap,
		Locale defaultLocale) {
		if (observacaoMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setObservacao(LocalizationUtil.updateLocalization(observacaoMap,
					getObservacao(), "Observacao",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getCnpj() {
		return _cnpj;
	}

	@Override
	public void setCnpj(String cnpj) {
		_cnpj = cnpj;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setCnpj", String.class);

				method.invoke(_lojaRemoteModel, cnpj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndLogradouro() {
		return _endLogradouro;
	}

	@Override
	public void setEndLogradouro(String endLogradouro) {
		_endLogradouro = endLogradouro;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndLogradouro", String.class);

				method.invoke(_lojaRemoteModel, endLogradouro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndNumero() {
		return _endNumero;
	}

	@Override
	public void setEndNumero(String endNumero) {
		_endNumero = endNumero;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndNumero", String.class);

				method.invoke(_lojaRemoteModel, endNumero);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComplemento() {
		return _endComplemento;
	}

	@Override
	public void setEndComplemento(String endComplemento) {
		_endComplemento = endComplemento;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComplemento",
						String.class);

				method.invoke(_lojaRemoteModel, endComplemento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndCep() {
		return _endCep;
	}

	@Override
	public void setEndCep(String endCep) {
		_endCep = endCep;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndCep", String.class);

				method.invoke(_lojaRemoteModel, endCep);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndBairro() {
		return _endBairro;
	}

	@Override
	public void setEndBairro(String endBairro) {
		_endBairro = endBairro;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndBairro", String.class);

				method.invoke(_lojaRemoteModel, endBairro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndCidade() {
		return _endCidade;
	}

	@Override
	public void setEndCidade(String endCidade) {
		_endCidade = endCidade;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndCidade", String.class);

				method.invoke(_lojaRemoteModel, endCidade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndUf() {
		return _endUf;
	}

	@Override
	public void setEndUf(String endUf) {
		_endUf = endUf;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndUf", String.class);

				method.invoke(_lojaRemoteModel, endUf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndPais() {
		return _endPais;
	}

	@Override
	public void setEndPais(String endPais) {
		_endPais = endPais;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setEndPais", String.class);

				method.invoke(_lojaRemoteModel, endPais);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_lojaRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrdemIndicada() {
		return _ordemIndicada;
	}

	@Override
	public void setOrdemIndicada(int ordemIndicada) {
		_ordemIndicada = ordemIndicada;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setOrdemIndicada", int.class);

				method.invoke(_lojaRemoteModel, ordemIndicada);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOrdemIndicadaAtual() {
		return _ordemIndicadaAtual;
	}

	@Override
	public boolean isOrdemIndicadaAtual() {
		return _ordemIndicadaAtual;
	}

	@Override
	public void setOrdemIndicadaAtual(boolean ordemIndicadaAtual) {
		_ordemIndicadaAtual = ordemIndicadaAtual;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setOrdemIndicadaAtual",
						boolean.class);

				method.invoke(_lojaRemoteModel, ordemIndicadaAtual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_lojaRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_lojaRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_lojaRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_lojaRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_lojaRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_lojaRemoteModel != null) {
			try {
				Class<?> clazz = _lojaRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_lojaRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Loja.class.getName()), getClassNameId());
	}

	@Override
	public TrashEntry getTrashEntry() throws PortalException, SystemException {
		if (!isInTrash()) {
			return null;
		}

		TrashEntry trashEntry = TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
				getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		TrashHandler trashHandler = getTrashHandler();

		if (!Validator.isNull(trashHandler.getContainerModelClassName())) {
			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException nsme) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler = TrashHandlerRegistryUtil.getTrashHandler(trashHandler.getContainerModelClassName());

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	@Override
	public TrashHandler getTrashHandler() {
		return TrashHandlerRegistryUtil.getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		TrashHandler trashHandler = getTrashHandler();

		if ((trashHandler == null) ||
				Validator.isNull(trashHandler.getContainerModelClassName())) {
			return false;
		}

		try {
			ContainerModel containerModel = trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getLojaRemoteModel() {
		return _lojaRemoteModel;
	}

	public void setLojaRemoteModel(BaseModel<?> lojaRemoteModel) {
		_lojaRemoteModel = lojaRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _lojaRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_lojaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LojaLocalServiceUtil.addLoja(this);
		}
		else {
			LojaLocalServiceUtil.updateLoja(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> observacaoMap = getObservacaoMap();

		for (Map.Entry<Locale, String> entry : observacaoMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getObservacao();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String observacao = getObservacao(defaultLocale);

		if (Validator.isNull(observacao)) {
			setObservacao(getObservacao(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setObservacao(getObservacao(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Loja toEscapedModel() {
		return (Loja)ProxyUtil.newProxyInstance(Loja.class.getClassLoader(),
			new Class[] { Loja.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LojaClp clone = new LojaClp();

		clone.setUuid(getUuid());
		clone.setLojaId(getLojaId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRazaoSocial(getRazaoSocial());
		clone.setNomeFantasia(getNomeFantasia());
		clone.setObservacao(getObservacao());
		clone.setCnpj(getCnpj());
		clone.setEndLogradouro(getEndLogradouro());
		clone.setEndNumero(getEndNumero());
		clone.setEndComplemento(getEndComplemento());
		clone.setEndCep(getEndCep());
		clone.setEndBairro(getEndBairro());
		clone.setEndCidade(getEndCidade());
		clone.setEndUf(getEndUf());
		clone.setEndPais(getEndPais());
		clone.setVersao(getVersao());
		clone.setOrdemIndicada(getOrdemIndicada());
		clone.setOrdemIndicadaAtual(getOrdemIndicadaAtual());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());

		return clone;
	}

	@Override
	public int compareTo(Loja loja) {
		int value = 0;

		value = getNomeFantasia().compareTo(loja.getNomeFantasia());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LojaClp)) {
			return false;
		}

		LojaClp loja = (LojaClp)obj;

		long primaryKey = loja.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", lojaId=");
		sb.append(getLojaId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", razaoSocial=");
		sb.append(getRazaoSocial());
		sb.append(", nomeFantasia=");
		sb.append(getNomeFantasia());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append(", cnpj=");
		sb.append(getCnpj());
		sb.append(", endLogradouro=");
		sb.append(getEndLogradouro());
		sb.append(", endNumero=");
		sb.append(getEndNumero());
		sb.append(", endComplemento=");
		sb.append(getEndComplemento());
		sb.append(", endCep=");
		sb.append(getEndCep());
		sb.append(", endBairro=");
		sb.append(getEndBairro());
		sb.append(", endCidade=");
		sb.append(getEndCidade());
		sb.append(", endUf=");
		sb.append(getEndUf());
		sb.append(", endPais=");
		sb.append(getEndPais());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append(", ordemIndicada=");
		sb.append(getOrdemIndicada());
		sb.append(", ordemIndicadaAtual=");
		sb.append(getOrdemIndicadaAtual());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(91);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.lapidarios.loja.model.Loja");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lojaId</column-name><column-value><![CDATA[");
		sb.append(getLojaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>razaoSocial</column-name><column-value><![CDATA[");
		sb.append(getRazaoSocial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeFantasia</column-name><column-value><![CDATA[");
		sb.append(getNomeFantasia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cnpj</column-name><column-value><![CDATA[");
		sb.append(getCnpj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endLogradouro</column-name><column-value><![CDATA[");
		sb.append(getEndLogradouro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endNumero</column-name><column-value><![CDATA[");
		sb.append(getEndNumero());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComplemento</column-name><column-value><![CDATA[");
		sb.append(getEndComplemento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endCep</column-name><column-value><![CDATA[");
		sb.append(getEndCep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endBairro</column-name><column-value><![CDATA[");
		sb.append(getEndBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endCidade</column-name><column-value><![CDATA[");
		sb.append(getEndCidade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endUf</column-name><column-value><![CDATA[");
		sb.append(getEndUf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endPais</column-name><column-value><![CDATA[");
		sb.append(getEndPais());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ordemIndicada</column-name><column-value><![CDATA[");
		sb.append(getOrdemIndicada());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ordemIndicadaAtual</column-name><column-value><![CDATA[");
		sb.append(getOrdemIndicadaAtual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _lojaId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _razaoSocial;
	private String _nomeFantasia;
	private String _observacao;
	private String _observacaoCurrentLanguageId;
	private String _cnpj;
	private String _endLogradouro;
	private String _endNumero;
	private String _endComplemento;
	private String _endCep;
	private String _endBairro;
	private String _endCidade;
	private String _endUf;
	private String _endPais;
	private double _versao;
	private int _ordemIndicada;
	private boolean _ordemIndicadaAtual;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _classNameId;
	private long _classPK;
	private BaseModel<?> _lojaRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.lapidarios.loja.service.ClpSerializer.class;
}