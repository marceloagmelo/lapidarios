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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Local}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Local
 * @generated
 */
public class LocalWrapper implements Local, ModelWrapper<Local> {
	public LocalWrapper(Local local) {
		_local = local;
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

	/**
	* Returns the primary key of this local.
	*
	* @return the primary key of this local
	*/
	@Override
	public long getPrimaryKey() {
		return _local.getPrimaryKey();
	}

	/**
	* Sets the primary key of this local.
	*
	* @param primaryKey the primary key of this local
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_local.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this local.
	*
	* @return the uuid of this local
	*/
	@Override
	public java.lang.String getUuid() {
		return _local.getUuid();
	}

	/**
	* Sets the uuid of this local.
	*
	* @param uuid the uuid of this local
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_local.setUuid(uuid);
	}

	/**
	* Returns the local ID of this local.
	*
	* @return the local ID of this local
	*/
	@Override
	public long getLocalId() {
		return _local.getLocalId();
	}

	/**
	* Sets the local ID of this local.
	*
	* @param localId the local ID of this local
	*/
	@Override
	public void setLocalId(long localId) {
		_local.setLocalId(localId);
	}

	/**
	* Returns the company ID of this local.
	*
	* @return the company ID of this local
	*/
	@Override
	public long getCompanyId() {
		return _local.getCompanyId();
	}

	/**
	* Sets the company ID of this local.
	*
	* @param companyId the company ID of this local
	*/
	@Override
	public void setCompanyId(long companyId) {
		_local.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this local.
	*
	* @return the group ID of this local
	*/
	@Override
	public long getGroupId() {
		return _local.getGroupId();
	}

	/**
	* Sets the group ID of this local.
	*
	* @param groupId the group ID of this local
	*/
	@Override
	public void setGroupId(long groupId) {
		_local.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this local.
	*
	* @return the create user ID of this local
	*/
	@Override
	public long getCreateUserId() {
		return _local.getCreateUserId();
	}

	/**
	* Sets the create user ID of this local.
	*
	* @param createUserId the create user ID of this local
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_local.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this local.
	*
	* @return the create user uuid of this local
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _local.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this local.
	*
	* @param createUserUuid the create user uuid of this local
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_local.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this local.
	*
	* @return the modified user ID of this local
	*/
	@Override
	public long getModifiedUserId() {
		return _local.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this local.
	*
	* @param modifiedUserId the modified user ID of this local
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_local.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this local.
	*
	* @return the modified user uuid of this local
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _local.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this local.
	*
	* @param modifiedUserUuid the modified user uuid of this local
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_local.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this local.
	*
	* @return the create date of this local
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _local.getCreateDate();
	}

	/**
	* Sets the create date of this local.
	*
	* @param createDate the create date of this local
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_local.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this local.
	*
	* @return the modified date of this local
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _local.getModifiedDate();
	}

	/**
	* Sets the modified date of this local.
	*
	* @param modifiedDate the modified date of this local
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_local.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this local.
	*
	* @return the nome of this local
	*/
	@Override
	public java.lang.String getNome() {
		return _local.getNome();
	}

	/**
	* Sets the nome of this local.
	*
	* @param nome the nome of this local
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_local.setNome(nome);
	}

	/**
	* Returns the end logradouro of this local.
	*
	* @return the end logradouro of this local
	*/
	@Override
	public java.lang.String getEndLogradouro() {
		return _local.getEndLogradouro();
	}

	/**
	* Sets the end logradouro of this local.
	*
	* @param endLogradouro the end logradouro of this local
	*/
	@Override
	public void setEndLogradouro(java.lang.String endLogradouro) {
		_local.setEndLogradouro(endLogradouro);
	}

	/**
	* Returns the end numero of this local.
	*
	* @return the end numero of this local
	*/
	@Override
	public java.lang.String getEndNumero() {
		return _local.getEndNumero();
	}

	/**
	* Sets the end numero of this local.
	*
	* @param endNumero the end numero of this local
	*/
	@Override
	public void setEndNumero(java.lang.String endNumero) {
		_local.setEndNumero(endNumero);
	}

	/**
	* Returns the end complemento of this local.
	*
	* @return the end complemento of this local
	*/
	@Override
	public java.lang.String getEndComplemento() {
		return _local.getEndComplemento();
	}

	/**
	* Sets the end complemento of this local.
	*
	* @param endComplemento the end complemento of this local
	*/
	@Override
	public void setEndComplemento(java.lang.String endComplemento) {
		_local.setEndComplemento(endComplemento);
	}

	/**
	* Returns the end cep of this local.
	*
	* @return the end cep of this local
	*/
	@Override
	public java.lang.String getEndCep() {
		return _local.getEndCep();
	}

	/**
	* Sets the end cep of this local.
	*
	* @param endCep the end cep of this local
	*/
	@Override
	public void setEndCep(java.lang.String endCep) {
		_local.setEndCep(endCep);
	}

	/**
	* Returns the end bairro of this local.
	*
	* @return the end bairro of this local
	*/
	@Override
	public java.lang.String getEndBairro() {
		return _local.getEndBairro();
	}

	/**
	* Sets the end bairro of this local.
	*
	* @param endBairro the end bairro of this local
	*/
	@Override
	public void setEndBairro(java.lang.String endBairro) {
		_local.setEndBairro(endBairro);
	}

	/**
	* Returns the end cidade of this local.
	*
	* @return the end cidade of this local
	*/
	@Override
	public java.lang.String getEndCidade() {
		return _local.getEndCidade();
	}

	/**
	* Sets the end cidade of this local.
	*
	* @param endCidade the end cidade of this local
	*/
	@Override
	public void setEndCidade(java.lang.String endCidade) {
		_local.setEndCidade(endCidade);
	}

	/**
	* Returns the end uf of this local.
	*
	* @return the end uf of this local
	*/
	@Override
	public java.lang.String getEndUf() {
		return _local.getEndUf();
	}

	/**
	* Sets the end uf of this local.
	*
	* @param endUf the end uf of this local
	*/
	@Override
	public void setEndUf(java.lang.String endUf) {
		_local.setEndUf(endUf);
	}

	/**
	* Returns the end pais of this local.
	*
	* @return the end pais of this local
	*/
	@Override
	public java.lang.String getEndPais() {
		return _local.getEndPais();
	}

	/**
	* Sets the end pais of this local.
	*
	* @param endPais the end pais of this local
	*/
	@Override
	public void setEndPais(java.lang.String endPais) {
		_local.setEndPais(endPais);
	}

	/**
	* Returns the ponto referencia of this local.
	*
	* @return the ponto referencia of this local
	*/
	@Override
	public java.lang.String getPontoReferencia() {
		return _local.getPontoReferencia();
	}

	/**
	* Returns the localized ponto referencia of this local in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized ponto referencia of this local
	*/
	@Override
	public java.lang.String getPontoReferencia(java.util.Locale locale) {
		return _local.getPontoReferencia(locale);
	}

	/**
	* Returns the localized ponto referencia of this local in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized ponto referencia of this local. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getPontoReferencia(java.util.Locale locale,
		boolean useDefault) {
		return _local.getPontoReferencia(locale, useDefault);
	}

	/**
	* Returns the localized ponto referencia of this local in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized ponto referencia of this local
	*/
	@Override
	public java.lang.String getPontoReferencia(java.lang.String languageId) {
		return _local.getPontoReferencia(languageId);
	}

	/**
	* Returns the localized ponto referencia of this local in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized ponto referencia of this local
	*/
	@Override
	public java.lang.String getPontoReferencia(java.lang.String languageId,
		boolean useDefault) {
		return _local.getPontoReferencia(languageId, useDefault);
	}

	@Override
	public java.lang.String getPontoReferenciaCurrentLanguageId() {
		return _local.getPontoReferenciaCurrentLanguageId();
	}

	@Override
	public java.lang.String getPontoReferenciaCurrentValue() {
		return _local.getPontoReferenciaCurrentValue();
	}

	/**
	* Returns a map of the locales and localized ponto referencias of this local.
	*
	* @return the locales and localized ponto referencias of this local
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getPontoReferenciaMap() {
		return _local.getPontoReferenciaMap();
	}

	/**
	* Sets the ponto referencia of this local.
	*
	* @param pontoReferencia the ponto referencia of this local
	*/
	@Override
	public void setPontoReferencia(java.lang.String pontoReferencia) {
		_local.setPontoReferencia(pontoReferencia);
	}

	/**
	* Sets the localized ponto referencia of this local in the language.
	*
	* @param pontoReferencia the localized ponto referencia of this local
	* @param locale the locale of the language
	*/
	@Override
	public void setPontoReferencia(java.lang.String pontoReferencia,
		java.util.Locale locale) {
		_local.setPontoReferencia(pontoReferencia, locale);
	}

	/**
	* Sets the localized ponto referencia of this local in the language, and sets the default locale.
	*
	* @param pontoReferencia the localized ponto referencia of this local
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setPontoReferencia(java.lang.String pontoReferencia,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_local.setPontoReferencia(pontoReferencia, locale, defaultLocale);
	}

	@Override
	public void setPontoReferenciaCurrentLanguageId(java.lang.String languageId) {
		_local.setPontoReferenciaCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized ponto referencias of this local from the map of locales and localized ponto referencias.
	*
	* @param pontoReferenciaMap the locales and localized ponto referencias of this local
	*/
	@Override
	public void setPontoReferenciaMap(
		java.util.Map<java.util.Locale, java.lang.String> pontoReferenciaMap) {
		_local.setPontoReferenciaMap(pontoReferenciaMap);
	}

	/**
	* Sets the localized ponto referencias of this local from the map of locales and localized ponto referencias, and sets the default locale.
	*
	* @param pontoReferenciaMap the locales and localized ponto referencias of this local
	* @param defaultLocale the default locale
	*/
	@Override
	public void setPontoReferenciaMap(
		java.util.Map<java.util.Locale, java.lang.String> pontoReferenciaMap,
		java.util.Locale defaultLocale) {
		_local.setPontoReferenciaMap(pontoReferenciaMap, defaultLocale);
	}

	/**
	* Returns the versao of this local.
	*
	* @return the versao of this local
	*/
	@Override
	public double getVersao() {
		return _local.getVersao();
	}

	/**
	* Sets the versao of this local.
	*
	* @param versao the versao of this local
	*/
	@Override
	public void setVersao(double versao) {
		_local.setVersao(versao);
	}

	@Override
	public boolean isNew() {
		return _local.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_local.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _local.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_local.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _local.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _local.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_local.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _local.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_local.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_local.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_local.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _local.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _local.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_local.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_local.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new LocalWrapper((Local)_local.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.Local local) {
		return _local.compareTo(local);
	}

	@Override
	public int hashCode() {
		return _local.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.evento.model.Local> toCacheModel() {
		return _local.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Local toEscapedModel() {
		return new LocalWrapper(_local.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Local toUnescapedModel() {
		return new LocalWrapper(_local.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _local.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _local.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_local.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalWrapper)) {
			return false;
		}

		LocalWrapper localWrapper = (LocalWrapper)obj;

		if (Validator.equals(_local, localWrapper._local)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _local.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Local getWrappedLocal() {
		return _local;
	}

	@Override
	public Local getWrappedModel() {
		return _local;
	}

	@Override
	public void resetOriginalValues() {
		_local.resetOriginalValues();
	}

	private Local _local;
}