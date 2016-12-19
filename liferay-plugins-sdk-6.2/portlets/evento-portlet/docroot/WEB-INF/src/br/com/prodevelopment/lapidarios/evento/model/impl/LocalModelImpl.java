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

package br.com.prodevelopment.lapidarios.evento.model.impl;

import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.model.LocalModel;
import br.com.prodevelopment.lapidarios.evento.model.LocalSoap;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the Local service. Represents a row in the &quot;local&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.com.prodevelopment.lapidarios.evento.model.LocalModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LocalImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see LocalImpl
 * @see br.com.prodevelopment.lapidarios.evento.model.Local
 * @see br.com.prodevelopment.lapidarios.evento.model.LocalModel
 * @generated
 */
@JSON(strict = true)
public class LocalModelImpl extends BaseModelImpl<Local> implements LocalModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a local model instance should use the {@link br.com.prodevelopment.lapidarios.evento.model.Local} interface instead.
	 */
	public static final String TABLE_NAME = "local";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "localId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createUserId", Types.BIGINT },
			{ "modifiedUserId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "nome", Types.VARCHAR },
			{ "endLogradouro", Types.VARCHAR },
			{ "endNumero", Types.VARCHAR },
			{ "endComplemento", Types.VARCHAR },
			{ "endCep", Types.VARCHAR },
			{ "endBairro", Types.VARCHAR },
			{ "endCidade", Types.VARCHAR },
			{ "endUf", Types.VARCHAR },
			{ "endPais", Types.VARCHAR },
			{ "pontoReferencia", Types.VARCHAR },
			{ "versao", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table local (uuid_ VARCHAR(75) null,localId LONG not null primary key,companyId LONG,groupId LONG,createUserId LONG,modifiedUserId LONG,createDate DATE null,modifiedDate DATE null,nome VARCHAR(75) null,endLogradouro VARCHAR(75) null,endNumero VARCHAR(75) null,endComplemento VARCHAR(75) null,endCep VARCHAR(75) null,endBairro VARCHAR(75) null,endCidade VARCHAR(75) null,endUf VARCHAR(75) null,endPais VARCHAR(75) null,pontoReferencia STRING null,versao DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table local";
	public static final String ORDER_BY_JPQL = " ORDER BY local.nome ASC";
	public static final String ORDER_BY_SQL = " ORDER BY local.nome ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.br.com.prodevelopment.lapidarios.evento.model.Local"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.br.com.prodevelopment.lapidarios.evento.model.Local"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.br.com.prodevelopment.lapidarios.evento.model.Local"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long NOME_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Local toModel(LocalSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Local model = new LocalImpl();

		model.setUuid(soapModel.getUuid());
		model.setLocalId(soapModel.getLocalId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setCreateUserId(soapModel.getCreateUserId());
		model.setModifiedUserId(soapModel.getModifiedUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setNome(soapModel.getNome());
		model.setEndLogradouro(soapModel.getEndLogradouro());
		model.setEndNumero(soapModel.getEndNumero());
		model.setEndComplemento(soapModel.getEndComplemento());
		model.setEndCep(soapModel.getEndCep());
		model.setEndBairro(soapModel.getEndBairro());
		model.setEndCidade(soapModel.getEndCidade());
		model.setEndUf(soapModel.getEndUf());
		model.setEndPais(soapModel.getEndPais());
		model.setPontoReferencia(soapModel.getPontoReferencia());
		model.setVersao(soapModel.getVersao());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Local> toModels(LocalSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Local> models = new ArrayList<Local>(soapModels.length);

		for (LocalSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.br.com.prodevelopment.lapidarios.evento.model.Local"));

	public LocalModelImpl() {
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
	public Class<?> getModelClass() {
		return Local.class;
	}

	@Override
	public String getModelClassName() {
		return Local.class.getName();
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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getLocalId() {
		return _localId;
	}

	@Override
	public void setLocalId(long localId) {
		_localId = localId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
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

	@JSON
	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getNome() {
		if (_nome == null) {
			return StringPool.BLANK;
		}
		else {
			return _nome;
		}
	}

	@Override
	public void setNome(String nome) {
		_columnBitmask = -1L;

		if (_originalNome == null) {
			_originalNome = _nome;
		}

		_nome = nome;
	}

	public String getOriginalNome() {
		return GetterUtil.getString(_originalNome);
	}

	@JSON
	@Override
	public String getEndLogradouro() {
		if (_endLogradouro == null) {
			return StringPool.BLANK;
		}
		else {
			return _endLogradouro;
		}
	}

	@Override
	public void setEndLogradouro(String endLogradouro) {
		_endLogradouro = endLogradouro;
	}

	@JSON
	@Override
	public String getEndNumero() {
		if (_endNumero == null) {
			return StringPool.BLANK;
		}
		else {
			return _endNumero;
		}
	}

	@Override
	public void setEndNumero(String endNumero) {
		_endNumero = endNumero;
	}

	@JSON
	@Override
	public String getEndComplemento() {
		if (_endComplemento == null) {
			return StringPool.BLANK;
		}
		else {
			return _endComplemento;
		}
	}

	@Override
	public void setEndComplemento(String endComplemento) {
		_endComplemento = endComplemento;
	}

	@JSON
	@Override
	public String getEndCep() {
		if (_endCep == null) {
			return StringPool.BLANK;
		}
		else {
			return _endCep;
		}
	}

	@Override
	public void setEndCep(String endCep) {
		_endCep = endCep;
	}

	@JSON
	@Override
	public String getEndBairro() {
		if (_endBairro == null) {
			return StringPool.BLANK;
		}
		else {
			return _endBairro;
		}
	}

	@Override
	public void setEndBairro(String endBairro) {
		_endBairro = endBairro;
	}

	@JSON
	@Override
	public String getEndCidade() {
		if (_endCidade == null) {
			return StringPool.BLANK;
		}
		else {
			return _endCidade;
		}
	}

	@Override
	public void setEndCidade(String endCidade) {
		_endCidade = endCidade;
	}

	@JSON
	@Override
	public String getEndUf() {
		if (_endUf == null) {
			return StringPool.BLANK;
		}
		else {
			return _endUf;
		}
	}

	@Override
	public void setEndUf(String endUf) {
		_endUf = endUf;
	}

	@JSON
	@Override
	public String getEndPais() {
		if (_endPais == null) {
			return StringPool.BLANK;
		}
		else {
			return _endPais;
		}
	}

	@Override
	public void setEndPais(String endPais) {
		_endPais = endPais;
	}

	@JSON
	@Override
	public String getPontoReferencia() {
		if (_pontoReferencia == null) {
			return StringPool.BLANK;
		}
		else {
			return _pontoReferencia;
		}
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

	@JSON
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

		setPontoReferencia(LocalizationUtil.updateLocalization(
				pontoReferenciaMap, getPontoReferencia(), "PontoReferencia",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Local.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Local.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
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
		if (_escapedModel == null) {
			_escapedModel = (Local)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LocalImpl localImpl = new LocalImpl();

		localImpl.setUuid(getUuid());
		localImpl.setLocalId(getLocalId());
		localImpl.setCompanyId(getCompanyId());
		localImpl.setGroupId(getGroupId());
		localImpl.setCreateUserId(getCreateUserId());
		localImpl.setModifiedUserId(getModifiedUserId());
		localImpl.setCreateDate(getCreateDate());
		localImpl.setModifiedDate(getModifiedDate());
		localImpl.setNome(getNome());
		localImpl.setEndLogradouro(getEndLogradouro());
		localImpl.setEndNumero(getEndNumero());
		localImpl.setEndComplemento(getEndComplemento());
		localImpl.setEndCep(getEndCep());
		localImpl.setEndBairro(getEndBairro());
		localImpl.setEndCidade(getEndCidade());
		localImpl.setEndUf(getEndUf());
		localImpl.setEndPais(getEndPais());
		localImpl.setPontoReferencia(getPontoReferencia());
		localImpl.setVersao(getVersao());

		localImpl.resetOriginalValues();

		return localImpl;
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

		if (!(obj instanceof Local)) {
			return false;
		}

		Local local = (Local)obj;

		long primaryKey = local.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LocalModelImpl localModelImpl = this;

		localModelImpl._originalUuid = localModelImpl._uuid;

		localModelImpl._originalCompanyId = localModelImpl._companyId;

		localModelImpl._setOriginalCompanyId = false;

		localModelImpl._originalGroupId = localModelImpl._groupId;

		localModelImpl._setOriginalGroupId = false;

		localModelImpl._originalNome = localModelImpl._nome;

		localModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Local> toCacheModel() {
		LocalCacheModel localCacheModel = new LocalCacheModel();

		localCacheModel.uuid = getUuid();

		String uuid = localCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			localCacheModel.uuid = null;
		}

		localCacheModel.localId = getLocalId();

		localCacheModel.companyId = getCompanyId();

		localCacheModel.groupId = getGroupId();

		localCacheModel.createUserId = getCreateUserId();

		localCacheModel.modifiedUserId = getModifiedUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			localCacheModel.createDate = createDate.getTime();
		}
		else {
			localCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			localCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			localCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		localCacheModel.nome = getNome();

		String nome = localCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			localCacheModel.nome = null;
		}

		localCacheModel.endLogradouro = getEndLogradouro();

		String endLogradouro = localCacheModel.endLogradouro;

		if ((endLogradouro != null) && (endLogradouro.length() == 0)) {
			localCacheModel.endLogradouro = null;
		}

		localCacheModel.endNumero = getEndNumero();

		String endNumero = localCacheModel.endNumero;

		if ((endNumero != null) && (endNumero.length() == 0)) {
			localCacheModel.endNumero = null;
		}

		localCacheModel.endComplemento = getEndComplemento();

		String endComplemento = localCacheModel.endComplemento;

		if ((endComplemento != null) && (endComplemento.length() == 0)) {
			localCacheModel.endComplemento = null;
		}

		localCacheModel.endCep = getEndCep();

		String endCep = localCacheModel.endCep;

		if ((endCep != null) && (endCep.length() == 0)) {
			localCacheModel.endCep = null;
		}

		localCacheModel.endBairro = getEndBairro();

		String endBairro = localCacheModel.endBairro;

		if ((endBairro != null) && (endBairro.length() == 0)) {
			localCacheModel.endBairro = null;
		}

		localCacheModel.endCidade = getEndCidade();

		String endCidade = localCacheModel.endCidade;

		if ((endCidade != null) && (endCidade.length() == 0)) {
			localCacheModel.endCidade = null;
		}

		localCacheModel.endUf = getEndUf();

		String endUf = localCacheModel.endUf;

		if ((endUf != null) && (endUf.length() == 0)) {
			localCacheModel.endUf = null;
		}

		localCacheModel.endPais = getEndPais();

		String endPais = localCacheModel.endPais;

		if ((endPais != null) && (endPais.length() == 0)) {
			localCacheModel.endPais = null;
		}

		localCacheModel.pontoReferencia = getPontoReferencia();

		String pontoReferencia = localCacheModel.pontoReferencia;

		if ((pontoReferencia != null) && (pontoReferencia.length() == 0)) {
			localCacheModel.pontoReferencia = null;
		}

		localCacheModel.versao = getVersao();

		return localCacheModel;
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

	private static ClassLoader _classLoader = Local.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Local.class };
	private String _uuid;
	private String _originalUuid;
	private long _localId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _originalNome;
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
	private long _columnBitmask;
	private Local _escapedModel;
}