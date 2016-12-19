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

package br.com.prodevelopment.lapidarios.evento.model;

import br.com.prodevelopment.lapidarios.evento.service.ClpSerializer;
import br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

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
public class LocalClp extends BaseModelImpl<Local> implements Local {
	public LocalClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Local.class;
	}

	@Override
	public String getModelClassName() {
		return Local.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _localId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLocalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("localId", getLocalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("endLogradouro", getEndLogradouro());
		attributes.put("endNumero", getEndNumero());
		attributes.put("endComplemento", getEndComplemento());
		attributes.put("endCep", getEndCep());
		attributes.put("endBairro", getEndBairro());
		attributes.put("endCidade", getEndCidade());
		attributes.put("endUf", getEndUf());
		attributes.put("endPais", getEndPais());
		attributes.put("pontoReferencia", getPontoReferencia());
		attributes.put("versao", getVersao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long localId = (Long)attributes.get("localId");

		if (localId != null) {
			setLocalId(localId);
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

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
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

		String pontoReferencia = (String)attributes.get("pontoReferencia");

		if (pontoReferencia != null) {
			setPontoReferencia(pontoReferencia);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_localRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocalId() {
		return _localId;
	}

	@Override
	public void setLocalId(long localId) {
		_localId = localId;

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setLocalId", long.class);

				method.invoke(_localRemoteModel, localId);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_localRemoteModel, companyId);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_localRemoteModel, groupId);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_localRemoteModel, createUserId);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_localRemoteModel, modifiedUserId);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_localRemoteModel, createDate);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_localRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _nome;
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_localRemoteModel, nome);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndLogradouro", String.class);

				method.invoke(_localRemoteModel, endLogradouro);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndNumero", String.class);

				method.invoke(_localRemoteModel, endNumero);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComplemento",
						String.class);

				method.invoke(_localRemoteModel, endComplemento);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndCep", String.class);

				method.invoke(_localRemoteModel, endCep);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndBairro", String.class);

				method.invoke(_localRemoteModel, endBairro);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndCidade", String.class);

				method.invoke(_localRemoteModel, endCidade);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndUf", String.class);

				method.invoke(_localRemoteModel, endUf);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setEndPais", String.class);

				method.invoke(_localRemoteModel, endPais);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPontoReferencia() {
		return _pontoReferencia;
	}

	@Override
	public String getPontoReferencia(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPontoReferencia(languageId);
	}

	@Override
	public String getPontoReferencia(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPontoReferencia(languageId, useDefault);
	}

	@Override
	public String getPontoReferencia(String languageId) {
		return LocalizationUtil.getLocalization(getPontoReferencia(), languageId);
	}

	@Override
	public String getPontoReferencia(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getPontoReferencia(),
			languageId, useDefault);
	}

	@Override
	public String getPontoReferenciaCurrentLanguageId() {
		return _pontoReferenciaCurrentLanguageId;
	}

	@Override
	public String getPontoReferenciaCurrentValue() {
		Locale locale = getLocale(_pontoReferenciaCurrentLanguageId);

		return getPontoReferencia(locale);
	}

	@Override
	public Map<Locale, String> getPontoReferenciaMap() {
		return LocalizationUtil.getLocalizationMap(getPontoReferencia());
	}

	@Override
	public void setPontoReferencia(String pontoReferencia) {
		_pontoReferencia = pontoReferencia;

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setPontoReferencia",
						String.class);

				method.invoke(_localRemoteModel, pontoReferencia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setPontoReferencia(String pontoReferencia, Locale locale) {
		setPontoReferencia(pontoReferencia, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setPontoReferencia(String pontoReferencia, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(pontoReferencia)) {
			setPontoReferencia(LocalizationUtil.updateLocalization(
					getPontoReferencia(), "PontoReferencia", pontoReferencia,
					languageId, defaultLanguageId));
		}
		else {
			setPontoReferencia(LocalizationUtil.removeLocalization(
					getPontoReferencia(), "PontoReferencia", languageId));
		}
	}

	@Override
	public void setPontoReferenciaCurrentLanguageId(String languageId) {
		_pontoReferenciaCurrentLanguageId = languageId;
	}

	@Override
	public void setPontoReferenciaMap(Map<Locale, String> pontoReferenciaMap) {
		setPontoReferenciaMap(pontoReferenciaMap, LocaleUtil.getDefault());
	}

	@Override
	public void setPontoReferenciaMap(Map<Locale, String> pontoReferenciaMap,
		Locale defaultLocale) {
		if (pontoReferenciaMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setPontoReferencia(LocalizationUtil.updateLocalization(
					pontoReferenciaMap, getPontoReferencia(),
					"PontoReferencia", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
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

		if (_localRemoteModel != null) {
			try {
				Class<?> clazz = _localRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_localRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Local.class.getName()));
	}

	public BaseModel<?> getLocalRemoteModel() {
		return _localRemoteModel;
	}

	public void setLocalRemoteModel(BaseModel<?> localRemoteModel) {
		_localRemoteModel = localRemoteModel;
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

		Class<?> remoteModelClass = _localRemoteModel.getClass();

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

		Object returnValue = method.invoke(_localRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LocalLocalServiceUtil.addLocal(this);
		}
		else {
			LocalLocalServiceUtil.updateLocal(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> pontoReferenciaMap = getPontoReferenciaMap();

		for (Map.Entry<Locale, String> entry : pontoReferenciaMap.entrySet()) {
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
		String xml = getPontoReferencia();

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

		String pontoReferencia = getPontoReferencia(defaultLocale);

		if (Validator.isNull(pontoReferencia)) {
			setPontoReferencia(getPontoReferencia(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setPontoReferencia(getPontoReferencia(defaultLocale),
				defaultLocale, defaultLocale);
		}
	}

	@Override
	public Local toEscapedModel() {
		return (Local)ProxyUtil.newProxyInstance(Local.class.getClassLoader(),
			new Class[] { Local.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LocalClp clone = new LocalClp();

		clone.setUuid(getUuid());
		clone.setLocalId(getLocalId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNome(getNome());
		clone.setEndLogradouro(getEndLogradouro());
		clone.setEndNumero(getEndNumero());
		clone.setEndComplemento(getEndComplemento());
		clone.setEndCep(getEndCep());
		clone.setEndBairro(getEndBairro());
		clone.setEndCidade(getEndCidade());
		clone.setEndUf(getEndUf());
		clone.setEndPais(getEndPais());
		clone.setPontoReferencia(getPontoReferencia());
		clone.setVersao(getVersao());

		return clone;
	}

	@Override
	public int compareTo(Local local) {
		int value = 0;

		value = getNome().compareTo(local.getNome());

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

		if (!(obj instanceof LocalClp)) {
			return false;
		}

		LocalClp local = (LocalClp)obj;

		long primaryKey = local.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", localId=");
		sb.append(getLocalId());
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
		sb.append(", nome=");
		sb.append(getNome());
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
		sb.append(", pontoReferencia=");
		sb.append(getPontoReferencia());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.lapidarios.evento.model.Local");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localId</column-name><column-value><![CDATA[");
		sb.append(getLocalId());
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
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
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
			"<column><column-name>pontoReferencia</column-name><column-value><![CDATA[");
		sb.append(getPontoReferencia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _localId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _endLogradouro;
	private String _endNumero;
	private String _endComplemento;
	private String _endCep;
	private String _endBairro;
	private String _endCidade;
	private String _endUf;
	private String _endPais;
	private String _pontoReferencia;
	private String _pontoReferenciaCurrentLanguageId;
	private double _versao;
	private BaseModel<?> _localRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.lapidarios.evento.service.ClpSerializer.class;
}