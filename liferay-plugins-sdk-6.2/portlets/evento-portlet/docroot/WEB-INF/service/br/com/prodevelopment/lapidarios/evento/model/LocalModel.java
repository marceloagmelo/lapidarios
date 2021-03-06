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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Local service. Represents a row in the &quot;local&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.lapidarios.evento.model.impl.LocalModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.lapidarios.evento.model.impl.LocalImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Local
 * @see br.com.prodevelopment.lapidarios.evento.model.impl.LocalImpl
 * @see br.com.prodevelopment.lapidarios.evento.model.impl.LocalModelImpl
 * @generated
 */
public interface LocalModel extends BaseModel<Local>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a local model instance should use the {@link Local} interface instead.
	 */

	/**
	 * Returns the primary key of this local.
	 *
	 * @return the primary key of this local
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this local.
	 *
	 * @param primaryKey the primary key of this local
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this local.
	 *
	 * @return the uuid of this local
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this local.
	 *
	 * @param uuid the uuid of this local
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the local ID of this local.
	 *
	 * @return the local ID of this local
	 */
	public long getLocalId();

	/**
	 * Sets the local ID of this local.
	 *
	 * @param localId the local ID of this local
	 */
	public void setLocalId(long localId);

	/**
	 * Returns the company ID of this local.
	 *
	 * @return the company ID of this local
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this local.
	 *
	 * @param companyId the company ID of this local
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this local.
	 *
	 * @return the group ID of this local
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this local.
	 *
	 * @param groupId the group ID of this local
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create user ID of this local.
	 *
	 * @return the create user ID of this local
	 */
	public long getCreateUserId();

	/**
	 * Sets the create user ID of this local.
	 *
	 * @param createUserId the create user ID of this local
	 */
	public void setCreateUserId(long createUserId);

	/**
	 * Returns the create user uuid of this local.
	 *
	 * @return the create user uuid of this local
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreateUserUuid() throws SystemException;

	/**
	 * Sets the create user uuid of this local.
	 *
	 * @param createUserUuid the create user uuid of this local
	 */
	public void setCreateUserUuid(String createUserUuid);

	/**
	 * Returns the modified user ID of this local.
	 *
	 * @return the modified user ID of this local
	 */
	public long getModifiedUserId();

	/**
	 * Sets the modified user ID of this local.
	 *
	 * @param modifiedUserId the modified user ID of this local
	 */
	public void setModifiedUserId(long modifiedUserId);

	/**
	 * Returns the modified user uuid of this local.
	 *
	 * @return the modified user uuid of this local
	 * @throws SystemException if a system exception occurred
	 */
	public String getModifiedUserUuid() throws SystemException;

	/**
	 * Sets the modified user uuid of this local.
	 *
	 * @param modifiedUserUuid the modified user uuid of this local
	 */
	public void setModifiedUserUuid(String modifiedUserUuid);

	/**
	 * Returns the create date of this local.
	 *
	 * @return the create date of this local
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this local.
	 *
	 * @param createDate the create date of this local
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this local.
	 *
	 * @return the modified date of this local
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this local.
	 *
	 * @param modifiedDate the modified date of this local
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nome of this local.
	 *
	 * @return the nome of this local
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this local.
	 *
	 * @param nome the nome of this local
	 */
	public void setNome(String nome);

	/**
	 * Returns the end logradouro of this local.
	 *
	 * @return the end logradouro of this local
	 */
	@AutoEscape
	public String getEndLogradouro();

	/**
	 * Sets the end logradouro of this local.
	 *
	 * @param endLogradouro the end logradouro of this local
	 */
	public void setEndLogradouro(String endLogradouro);

	/**
	 * Returns the end numero of this local.
	 *
	 * @return the end numero of this local
	 */
	@AutoEscape
	public String getEndNumero();

	/**
	 * Sets the end numero of this local.
	 *
	 * @param endNumero the end numero of this local
	 */
	public void setEndNumero(String endNumero);

	/**
	 * Returns the end complemento of this local.
	 *
	 * @return the end complemento of this local
	 */
	@AutoEscape
	public String getEndComplemento();

	/**
	 * Sets the end complemento of this local.
	 *
	 * @param endComplemento the end complemento of this local
	 */
	public void setEndComplemento(String endComplemento);

	/**
	 * Returns the end cep of this local.
	 *
	 * @return the end cep of this local
	 */
	@AutoEscape
	public String getEndCep();

	/**
	 * Sets the end cep of this local.
	 *
	 * @param endCep the end cep of this local
	 */
	public void setEndCep(String endCep);

	/**
	 * Returns the end bairro of this local.
	 *
	 * @return the end bairro of this local
	 */
	@AutoEscape
	public String getEndBairro();

	/**
	 * Sets the end bairro of this local.
	 *
	 * @param endBairro the end bairro of this local
	 */
	public void setEndBairro(String endBairro);

	/**
	 * Returns the end cidade of this local.
	 *
	 * @return the end cidade of this local
	 */
	@AutoEscape
	public String getEndCidade();

	/**
	 * Sets the end cidade of this local.
	 *
	 * @param endCidade the end cidade of this local
	 */
	public void setEndCidade(String endCidade);

	/**
	 * Returns the end uf of this local.
	 *
	 * @return the end uf of this local
	 */
	@AutoEscape
	public String getEndUf();

	/**
	 * Sets the end uf of this local.
	 *
	 * @param endUf the end uf of this local
	 */
	public void setEndUf(String endUf);

	/**
	 * Returns the end pais of this local.
	 *
	 * @return the end pais of this local
	 */
	@AutoEscape
	public String getEndPais();

	/**
	 * Sets the end pais of this local.
	 *
	 * @param endPais the end pais of this local
	 */
	public void setEndPais(String endPais);

	/**
	 * Returns the ponto referencia of this local.
	 *
	 * @return the ponto referencia of this local
	 */
	public String getPontoReferencia();

	/**
	 * Returns the localized ponto referencia of this local in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized ponto referencia of this local
	 */
	@AutoEscape
	public String getPontoReferencia(Locale locale);

	/**
	 * Returns the localized ponto referencia of this local in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized ponto referencia of this local. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getPontoReferencia(Locale locale, boolean useDefault);

	/**
	 * Returns the localized ponto referencia of this local in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized ponto referencia of this local
	 */
	@AutoEscape
	public String getPontoReferencia(String languageId);

	/**
	 * Returns the localized ponto referencia of this local in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized ponto referencia of this local
	 */
	@AutoEscape
	public String getPontoReferencia(String languageId, boolean useDefault);

	@AutoEscape
	public String getPontoReferenciaCurrentLanguageId();

	@AutoEscape
	public String getPontoReferenciaCurrentValue();

	/**
	 * Returns a map of the locales and localized ponto referencias of this local.
	 *
	 * @return the locales and localized ponto referencias of this local
	 */
	public Map<Locale, String> getPontoReferenciaMap();

	/**
	 * Sets the ponto referencia of this local.
	 *
	 * @param pontoReferencia the ponto referencia of this local
	 */
	public void setPontoReferencia(String pontoReferencia);

	/**
	 * Sets the localized ponto referencia of this local in the language.
	 *
	 * @param pontoReferencia the localized ponto referencia of this local
	 * @param locale the locale of the language
	 */
	public void setPontoReferencia(String pontoReferencia, Locale locale);

	/**
	 * Sets the localized ponto referencia of this local in the language, and sets the default locale.
	 *
	 * @param pontoReferencia the localized ponto referencia of this local
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setPontoReferencia(String pontoReferencia, Locale locale,
		Locale defaultLocale);

	public void setPontoReferenciaCurrentLanguageId(String languageId);

	/**
	 * Sets the localized ponto referencias of this local from the map of locales and localized ponto referencias.
	 *
	 * @param pontoReferenciaMap the locales and localized ponto referencias of this local
	 */
	public void setPontoReferenciaMap(Map<Locale, String> pontoReferenciaMap);

	/**
	 * Sets the localized ponto referencias of this local from the map of locales and localized ponto referencias, and sets the default locale.
	 *
	 * @param pontoReferenciaMap the locales and localized ponto referencias of this local
	 * @param defaultLocale the default locale
	 */
	public void setPontoReferenciaMap(Map<Locale, String> pontoReferenciaMap,
		Locale defaultLocale);

	/**
	 * Returns the versao of this local.
	 *
	 * @return the versao of this local
	 */
	public double getVersao();

	/**
	 * Sets the versao of this local.
	 *
	 * @param versao the versao of this local
	 */
	public void setVersao(double versao);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.Local local);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.prodevelopment.lapidarios.evento.model.Local> toCacheModel();

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Local toEscapedModel();

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.Local toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}