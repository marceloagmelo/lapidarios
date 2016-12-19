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
 * This class is a wrapper for {@link Evento}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Evento
 * @generated
 */
public class EventoWrapper implements Evento, ModelWrapper<Evento> {
	public EventoWrapper(Evento evento) {
		_evento = evento;
	}

	@Override
	public Class<?> getModelClass() {
		return Evento.class;
	}

	@Override
	public String getModelClassName() {
		return Evento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventoId", getEventoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descricao", getDescricao());
		attributes.put("userResponsavelId", getUserResponsavelId());
		attributes.put("userResponsavelNome", getUserResponsavelNome());
		attributes.put("versao", getVersao());
		attributes.put("imagemId", getImagemId());
		attributes.put("articleId", getArticleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
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

		String descricao = (String)attributes.get("descricao");

		if (descricao != null) {
			setDescricao(descricao);
		}

		Long userResponsavelId = (Long)attributes.get("userResponsavelId");

		if (userResponsavelId != null) {
			setUserResponsavelId(userResponsavelId);
		}

		String userResponsavelNome = (String)attributes.get(
				"userResponsavelNome");

		if (userResponsavelNome != null) {
			setUserResponsavelNome(userResponsavelNome);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}

		Long imagemId = (Long)attributes.get("imagemId");

		if (imagemId != null) {
			setImagemId(imagemId);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}
	}

	/**
	* Returns the primary key of this evento.
	*
	* @return the primary key of this evento
	*/
	@Override
	public long getPrimaryKey() {
		return _evento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this evento.
	*
	* @param primaryKey the primary key of this evento
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_evento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this evento.
	*
	* @return the uuid of this evento
	*/
	@Override
	public java.lang.String getUuid() {
		return _evento.getUuid();
	}

	/**
	* Sets the uuid of this evento.
	*
	* @param uuid the uuid of this evento
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_evento.setUuid(uuid);
	}

	/**
	* Returns the evento ID of this evento.
	*
	* @return the evento ID of this evento
	*/
	@Override
	public long getEventoId() {
		return _evento.getEventoId();
	}

	/**
	* Sets the evento ID of this evento.
	*
	* @param eventoId the evento ID of this evento
	*/
	@Override
	public void setEventoId(long eventoId) {
		_evento.setEventoId(eventoId);
	}

	/**
	* Returns the company ID of this evento.
	*
	* @return the company ID of this evento
	*/
	@Override
	public long getCompanyId() {
		return _evento.getCompanyId();
	}

	/**
	* Sets the company ID of this evento.
	*
	* @param companyId the company ID of this evento
	*/
	@Override
	public void setCompanyId(long companyId) {
		_evento.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this evento.
	*
	* @return the group ID of this evento
	*/
	@Override
	public long getGroupId() {
		return _evento.getGroupId();
	}

	/**
	* Sets the group ID of this evento.
	*
	* @param groupId the group ID of this evento
	*/
	@Override
	public void setGroupId(long groupId) {
		_evento.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this evento.
	*
	* @return the create user ID of this evento
	*/
	@Override
	public long getCreateUserId() {
		return _evento.getCreateUserId();
	}

	/**
	* Sets the create user ID of this evento.
	*
	* @param createUserId the create user ID of this evento
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_evento.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this evento.
	*
	* @return the create user uuid of this evento
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evento.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this evento.
	*
	* @param createUserUuid the create user uuid of this evento
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_evento.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this evento.
	*
	* @return the modified user ID of this evento
	*/
	@Override
	public long getModifiedUserId() {
		return _evento.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this evento.
	*
	* @param modifiedUserId the modified user ID of this evento
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_evento.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this evento.
	*
	* @return the modified user uuid of this evento
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evento.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this evento.
	*
	* @param modifiedUserUuid the modified user uuid of this evento
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_evento.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this evento.
	*
	* @return the create date of this evento
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _evento.getCreateDate();
	}

	/**
	* Sets the create date of this evento.
	*
	* @param createDate the create date of this evento
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_evento.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this evento.
	*
	* @return the modified date of this evento
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _evento.getModifiedDate();
	}

	/**
	* Sets the modified date of this evento.
	*
	* @param modifiedDate the modified date of this evento
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_evento.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this evento.
	*
	* @return the nome of this evento
	*/
	@Override
	public java.lang.String getNome() {
		return _evento.getNome();
	}

	/**
	* Returns the localized nome of this evento in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized nome of this evento
	*/
	@Override
	public java.lang.String getNome(java.util.Locale locale) {
		return _evento.getNome(locale);
	}

	/**
	* Returns the localized nome of this evento in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized nome of this evento. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getNome(java.util.Locale locale, boolean useDefault) {
		return _evento.getNome(locale, useDefault);
	}

	/**
	* Returns the localized nome of this evento in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized nome of this evento
	*/
	@Override
	public java.lang.String getNome(java.lang.String languageId) {
		return _evento.getNome(languageId);
	}

	/**
	* Returns the localized nome of this evento in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized nome of this evento
	*/
	@Override
	public java.lang.String getNome(java.lang.String languageId,
		boolean useDefault) {
		return _evento.getNome(languageId, useDefault);
	}

	@Override
	public java.lang.String getNomeCurrentLanguageId() {
		return _evento.getNomeCurrentLanguageId();
	}

	@Override
	public java.lang.String getNomeCurrentValue() {
		return _evento.getNomeCurrentValue();
	}

	/**
	* Returns a map of the locales and localized nomes of this evento.
	*
	* @return the locales and localized nomes of this evento
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNomeMap() {
		return _evento.getNomeMap();
	}

	/**
	* Sets the nome of this evento.
	*
	* @param nome the nome of this evento
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_evento.setNome(nome);
	}

	/**
	* Sets the localized nome of this evento in the language.
	*
	* @param nome the localized nome of this evento
	* @param locale the locale of the language
	*/
	@Override
	public void setNome(java.lang.String nome, java.util.Locale locale) {
		_evento.setNome(nome, locale);
	}

	/**
	* Sets the localized nome of this evento in the language, and sets the default locale.
	*
	* @param nome the localized nome of this evento
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNome(java.lang.String nome, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_evento.setNome(nome, locale, defaultLocale);
	}

	@Override
	public void setNomeCurrentLanguageId(java.lang.String languageId) {
		_evento.setNomeCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized nomes of this evento from the map of locales and localized nomes.
	*
	* @param nomeMap the locales and localized nomes of this evento
	*/
	@Override
	public void setNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> nomeMap) {
		_evento.setNomeMap(nomeMap);
	}

	/**
	* Sets the localized nomes of this evento from the map of locales and localized nomes, and sets the default locale.
	*
	* @param nomeMap the locales and localized nomes of this evento
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Locale defaultLocale) {
		_evento.setNomeMap(nomeMap, defaultLocale);
	}

	/**
	* Returns the descricao of this evento.
	*
	* @return the descricao of this evento
	*/
	@Override
	public java.lang.String getDescricao() {
		return _evento.getDescricao();
	}

	/**
	* Returns the localized descricao of this evento in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized descricao of this evento
	*/
	@Override
	public java.lang.String getDescricao(java.util.Locale locale) {
		return _evento.getDescricao(locale);
	}

	/**
	* Returns the localized descricao of this evento in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this evento. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescricao(java.util.Locale locale,
		boolean useDefault) {
		return _evento.getDescricao(locale, useDefault);
	}

	/**
	* Returns the localized descricao of this evento in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized descricao of this evento
	*/
	@Override
	public java.lang.String getDescricao(java.lang.String languageId) {
		return _evento.getDescricao(languageId);
	}

	/**
	* Returns the localized descricao of this evento in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this evento
	*/
	@Override
	public java.lang.String getDescricao(java.lang.String languageId,
		boolean useDefault) {
		return _evento.getDescricao(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescricaoCurrentLanguageId() {
		return _evento.getDescricaoCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescricaoCurrentValue() {
		return _evento.getDescricaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descricaos of this evento.
	*
	* @return the locales and localized descricaos of this evento
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescricaoMap() {
		return _evento.getDescricaoMap();
	}

	/**
	* Sets the descricao of this evento.
	*
	* @param descricao the descricao of this evento
	*/
	@Override
	public void setDescricao(java.lang.String descricao) {
		_evento.setDescricao(descricao);
	}

	/**
	* Sets the localized descricao of this evento in the language.
	*
	* @param descricao the localized descricao of this evento
	* @param locale the locale of the language
	*/
	@Override
	public void setDescricao(java.lang.String descricao, java.util.Locale locale) {
		_evento.setDescricao(descricao, locale);
	}

	/**
	* Sets the localized descricao of this evento in the language, and sets the default locale.
	*
	* @param descricao the localized descricao of this evento
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescricao(java.lang.String descricao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_evento.setDescricao(descricao, locale, defaultLocale);
	}

	@Override
	public void setDescricaoCurrentLanguageId(java.lang.String languageId) {
		_evento.setDescricaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descricaos of this evento from the map of locales and localized descricaos.
	*
	* @param descricaoMap the locales and localized descricaos of this evento
	*/
	@Override
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap) {
		_evento.setDescricaoMap(descricaoMap);
	}

	/**
	* Sets the localized descricaos of this evento from the map of locales and localized descricaos, and sets the default locale.
	*
	* @param descricaoMap the locales and localized descricaos of this evento
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		java.util.Locale defaultLocale) {
		_evento.setDescricaoMap(descricaoMap, defaultLocale);
	}

	/**
	* Returns the user responsavel ID of this evento.
	*
	* @return the user responsavel ID of this evento
	*/
	@Override
	public long getUserResponsavelId() {
		return _evento.getUserResponsavelId();
	}

	/**
	* Sets the user responsavel ID of this evento.
	*
	* @param userResponsavelId the user responsavel ID of this evento
	*/
	@Override
	public void setUserResponsavelId(long userResponsavelId) {
		_evento.setUserResponsavelId(userResponsavelId);
	}

	/**
	* Returns the user responsavel nome of this evento.
	*
	* @return the user responsavel nome of this evento
	*/
	@Override
	public java.lang.String getUserResponsavelNome() {
		return _evento.getUserResponsavelNome();
	}

	/**
	* Sets the user responsavel nome of this evento.
	*
	* @param userResponsavelNome the user responsavel nome of this evento
	*/
	@Override
	public void setUserResponsavelNome(java.lang.String userResponsavelNome) {
		_evento.setUserResponsavelNome(userResponsavelNome);
	}

	/**
	* Returns the versao of this evento.
	*
	* @return the versao of this evento
	*/
	@Override
	public double getVersao() {
		return _evento.getVersao();
	}

	/**
	* Sets the versao of this evento.
	*
	* @param versao the versao of this evento
	*/
	@Override
	public void setVersao(double versao) {
		_evento.setVersao(versao);
	}

	/**
	* Returns the imagem ID of this evento.
	*
	* @return the imagem ID of this evento
	*/
	@Override
	public long getImagemId() {
		return _evento.getImagemId();
	}

	/**
	* Sets the imagem ID of this evento.
	*
	* @param imagemId the imagem ID of this evento
	*/
	@Override
	public void setImagemId(long imagemId) {
		_evento.setImagemId(imagemId);
	}

	/**
	* Returns the article ID of this evento.
	*
	* @return the article ID of this evento
	*/
	@Override
	public long getArticleId() {
		return _evento.getArticleId();
	}

	/**
	* Sets the article ID of this evento.
	*
	* @param articleId the article ID of this evento
	*/
	@Override
	public void setArticleId(long articleId) {
		_evento.setArticleId(articleId);
	}

	@Override
	public boolean isNew() {
		return _evento.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_evento.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _evento.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_evento.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _evento.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _evento.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_evento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _evento.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_evento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_evento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_evento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _evento.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _evento.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_evento.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_evento.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new EventoWrapper((Evento)_evento.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento) {
		return _evento.compareTo(evento);
	}

	@Override
	public int hashCode() {
		return _evento.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.evento.model.Evento> toCacheModel() {
		return _evento.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento toEscapedModel() {
		return new EventoWrapper(_evento.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Evento toUnescapedModel() {
		return new EventoWrapper(_evento.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _evento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _evento.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_evento.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventoWrapper)) {
			return false;
		}

		EventoWrapper eventoWrapper = (EventoWrapper)obj;

		if (Validator.equals(_evento, eventoWrapper._evento)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _evento.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Evento getWrappedEvento() {
		return _evento;
	}

	@Override
	public Evento getWrappedModel() {
		return _evento;
	}

	@Override
	public void resetOriginalValues() {
		_evento.resetOriginalValues();
	}

	private Evento _evento;
}