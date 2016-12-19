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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Loja}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Loja
 * @generated
 */
public class LojaWrapper implements Loja, ModelWrapper<Loja> {
	public LojaWrapper(Loja loja) {
		_loja = loja;
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

	/**
	* Returns the primary key of this loja.
	*
	* @return the primary key of this loja
	*/
	@Override
	public long getPrimaryKey() {
		return _loja.getPrimaryKey();
	}

	/**
	* Sets the primary key of this loja.
	*
	* @param primaryKey the primary key of this loja
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loja.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this loja.
	*
	* @return the uuid of this loja
	*/
	@Override
	public java.lang.String getUuid() {
		return _loja.getUuid();
	}

	/**
	* Sets the uuid of this loja.
	*
	* @param uuid the uuid of this loja
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_loja.setUuid(uuid);
	}

	/**
	* Returns the loja ID of this loja.
	*
	* @return the loja ID of this loja
	*/
	@Override
	public long getLojaId() {
		return _loja.getLojaId();
	}

	/**
	* Sets the loja ID of this loja.
	*
	* @param lojaId the loja ID of this loja
	*/
	@Override
	public void setLojaId(long lojaId) {
		_loja.setLojaId(lojaId);
	}

	/**
	* Returns the company ID of this loja.
	*
	* @return the company ID of this loja
	*/
	@Override
	public long getCompanyId() {
		return _loja.getCompanyId();
	}

	/**
	* Sets the company ID of this loja.
	*
	* @param companyId the company ID of this loja
	*/
	@Override
	public void setCompanyId(long companyId) {
		_loja.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this loja.
	*
	* @return the group ID of this loja
	*/
	@Override
	public long getGroupId() {
		return _loja.getGroupId();
	}

	/**
	* Sets the group ID of this loja.
	*
	* @param groupId the group ID of this loja
	*/
	@Override
	public void setGroupId(long groupId) {
		_loja.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this loja.
	*
	* @return the create user ID of this loja
	*/
	@Override
	public long getCreateUserId() {
		return _loja.getCreateUserId();
	}

	/**
	* Sets the create user ID of this loja.
	*
	* @param createUserId the create user ID of this loja
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_loja.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this loja.
	*
	* @return the create user uuid of this loja
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loja.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this loja.
	*
	* @param createUserUuid the create user uuid of this loja
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_loja.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this loja.
	*
	* @return the modified user ID of this loja
	*/
	@Override
	public long getModifiedUserId() {
		return _loja.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this loja.
	*
	* @param modifiedUserId the modified user ID of this loja
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_loja.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this loja.
	*
	* @return the modified user uuid of this loja
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loja.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this loja.
	*
	* @param modifiedUserUuid the modified user uuid of this loja
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_loja.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this loja.
	*
	* @return the create date of this loja
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _loja.getCreateDate();
	}

	/**
	* Sets the create date of this loja.
	*
	* @param createDate the create date of this loja
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_loja.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this loja.
	*
	* @return the modified date of this loja
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _loja.getModifiedDate();
	}

	/**
	* Sets the modified date of this loja.
	*
	* @param modifiedDate the modified date of this loja
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_loja.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the razao social of this loja.
	*
	* @return the razao social of this loja
	*/
	@Override
	public java.lang.String getRazaoSocial() {
		return _loja.getRazaoSocial();
	}

	/**
	* Sets the razao social of this loja.
	*
	* @param razaoSocial the razao social of this loja
	*/
	@Override
	public void setRazaoSocial(java.lang.String razaoSocial) {
		_loja.setRazaoSocial(razaoSocial);
	}

	/**
	* Returns the nome fantasia of this loja.
	*
	* @return the nome fantasia of this loja
	*/
	@Override
	public java.lang.String getNomeFantasia() {
		return _loja.getNomeFantasia();
	}

	/**
	* Sets the nome fantasia of this loja.
	*
	* @param nomeFantasia the nome fantasia of this loja
	*/
	@Override
	public void setNomeFantasia(java.lang.String nomeFantasia) {
		_loja.setNomeFantasia(nomeFantasia);
	}

	/**
	* Returns the observacao of this loja.
	*
	* @return the observacao of this loja
	*/
	@Override
	public java.lang.String getObservacao() {
		return _loja.getObservacao();
	}

	/**
	* Returns the localized observacao of this loja in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized observacao of this loja
	*/
	@Override
	public java.lang.String getObservacao(java.util.Locale locale) {
		return _loja.getObservacao(locale);
	}

	/**
	* Returns the localized observacao of this loja in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized observacao of this loja. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getObservacao(java.util.Locale locale,
		boolean useDefault) {
		return _loja.getObservacao(locale, useDefault);
	}

	/**
	* Returns the localized observacao of this loja in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized observacao of this loja
	*/
	@Override
	public java.lang.String getObservacao(java.lang.String languageId) {
		return _loja.getObservacao(languageId);
	}

	/**
	* Returns the localized observacao of this loja in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized observacao of this loja
	*/
	@Override
	public java.lang.String getObservacao(java.lang.String languageId,
		boolean useDefault) {
		return _loja.getObservacao(languageId, useDefault);
	}

	@Override
	public java.lang.String getObservacaoCurrentLanguageId() {
		return _loja.getObservacaoCurrentLanguageId();
	}

	@Override
	public java.lang.String getObservacaoCurrentValue() {
		return _loja.getObservacaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized observacaos of this loja.
	*
	* @return the locales and localized observacaos of this loja
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getObservacaoMap() {
		return _loja.getObservacaoMap();
	}

	/**
	* Sets the observacao of this loja.
	*
	* @param observacao the observacao of this loja
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_loja.setObservacao(observacao);
	}

	/**
	* Sets the localized observacao of this loja in the language.
	*
	* @param observacao the localized observacao of this loja
	* @param locale the locale of the language
	*/
	@Override
	public void setObservacao(java.lang.String observacao,
		java.util.Locale locale) {
		_loja.setObservacao(observacao, locale);
	}

	/**
	* Sets the localized observacao of this loja in the language, and sets the default locale.
	*
	* @param observacao the localized observacao of this loja
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setObservacao(java.lang.String observacao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_loja.setObservacao(observacao, locale, defaultLocale);
	}

	@Override
	public void setObservacaoCurrentLanguageId(java.lang.String languageId) {
		_loja.setObservacaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized observacaos of this loja from the map of locales and localized observacaos.
	*
	* @param observacaoMap the locales and localized observacaos of this loja
	*/
	@Override
	public void setObservacaoMap(
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap) {
		_loja.setObservacaoMap(observacaoMap);
	}

	/**
	* Sets the localized observacaos of this loja from the map of locales and localized observacaos, and sets the default locale.
	*
	* @param observacaoMap the locales and localized observacaos of this loja
	* @param defaultLocale the default locale
	*/
	@Override
	public void setObservacaoMap(
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		java.util.Locale defaultLocale) {
		_loja.setObservacaoMap(observacaoMap, defaultLocale);
	}

	/**
	* Returns the cnpj of this loja.
	*
	* @return the cnpj of this loja
	*/
	@Override
	public java.lang.String getCnpj() {
		return _loja.getCnpj();
	}

	/**
	* Sets the cnpj of this loja.
	*
	* @param cnpj the cnpj of this loja
	*/
	@Override
	public void setCnpj(java.lang.String cnpj) {
		_loja.setCnpj(cnpj);
	}

	/**
	* Returns the end logradouro of this loja.
	*
	* @return the end logradouro of this loja
	*/
	@Override
	public java.lang.String getEndLogradouro() {
		return _loja.getEndLogradouro();
	}

	/**
	* Sets the end logradouro of this loja.
	*
	* @param endLogradouro the end logradouro of this loja
	*/
	@Override
	public void setEndLogradouro(java.lang.String endLogradouro) {
		_loja.setEndLogradouro(endLogradouro);
	}

	/**
	* Returns the end numero of this loja.
	*
	* @return the end numero of this loja
	*/
	@Override
	public java.lang.String getEndNumero() {
		return _loja.getEndNumero();
	}

	/**
	* Sets the end numero of this loja.
	*
	* @param endNumero the end numero of this loja
	*/
	@Override
	public void setEndNumero(java.lang.String endNumero) {
		_loja.setEndNumero(endNumero);
	}

	/**
	* Returns the end complemento of this loja.
	*
	* @return the end complemento of this loja
	*/
	@Override
	public java.lang.String getEndComplemento() {
		return _loja.getEndComplemento();
	}

	/**
	* Sets the end complemento of this loja.
	*
	* @param endComplemento the end complemento of this loja
	*/
	@Override
	public void setEndComplemento(java.lang.String endComplemento) {
		_loja.setEndComplemento(endComplemento);
	}

	/**
	* Returns the end cep of this loja.
	*
	* @return the end cep of this loja
	*/
	@Override
	public java.lang.String getEndCep() {
		return _loja.getEndCep();
	}

	/**
	* Sets the end cep of this loja.
	*
	* @param endCep the end cep of this loja
	*/
	@Override
	public void setEndCep(java.lang.String endCep) {
		_loja.setEndCep(endCep);
	}

	/**
	* Returns the end bairro of this loja.
	*
	* @return the end bairro of this loja
	*/
	@Override
	public java.lang.String getEndBairro() {
		return _loja.getEndBairro();
	}

	/**
	* Sets the end bairro of this loja.
	*
	* @param endBairro the end bairro of this loja
	*/
	@Override
	public void setEndBairro(java.lang.String endBairro) {
		_loja.setEndBairro(endBairro);
	}

	/**
	* Returns the end cidade of this loja.
	*
	* @return the end cidade of this loja
	*/
	@Override
	public java.lang.String getEndCidade() {
		return _loja.getEndCidade();
	}

	/**
	* Sets the end cidade of this loja.
	*
	* @param endCidade the end cidade of this loja
	*/
	@Override
	public void setEndCidade(java.lang.String endCidade) {
		_loja.setEndCidade(endCidade);
	}

	/**
	* Returns the end uf of this loja.
	*
	* @return the end uf of this loja
	*/
	@Override
	public java.lang.String getEndUf() {
		return _loja.getEndUf();
	}

	/**
	* Sets the end uf of this loja.
	*
	* @param endUf the end uf of this loja
	*/
	@Override
	public void setEndUf(java.lang.String endUf) {
		_loja.setEndUf(endUf);
	}

	/**
	* Returns the end pais of this loja.
	*
	* @return the end pais of this loja
	*/
	@Override
	public java.lang.String getEndPais() {
		return _loja.getEndPais();
	}

	/**
	* Sets the end pais of this loja.
	*
	* @param endPais the end pais of this loja
	*/
	@Override
	public void setEndPais(java.lang.String endPais) {
		_loja.setEndPais(endPais);
	}

	/**
	* Returns the versao of this loja.
	*
	* @return the versao of this loja
	*/
	@Override
	public double getVersao() {
		return _loja.getVersao();
	}

	/**
	* Sets the versao of this loja.
	*
	* @param versao the versao of this loja
	*/
	@Override
	public void setVersao(double versao) {
		_loja.setVersao(versao);
	}

	/**
	* Returns the ordem indicada of this loja.
	*
	* @return the ordem indicada of this loja
	*/
	@Override
	public int getOrdemIndicada() {
		return _loja.getOrdemIndicada();
	}

	/**
	* Sets the ordem indicada of this loja.
	*
	* @param ordemIndicada the ordem indicada of this loja
	*/
	@Override
	public void setOrdemIndicada(int ordemIndicada) {
		_loja.setOrdemIndicada(ordemIndicada);
	}

	/**
	* Returns the ordem indicada atual of this loja.
	*
	* @return the ordem indicada atual of this loja
	*/
	@Override
	public boolean getOrdemIndicadaAtual() {
		return _loja.getOrdemIndicadaAtual();
	}

	/**
	* Returns <code>true</code> if this loja is ordem indicada atual.
	*
	* @return <code>true</code> if this loja is ordem indicada atual; <code>false</code> otherwise
	*/
	@Override
	public boolean isOrdemIndicadaAtual() {
		return _loja.isOrdemIndicadaAtual();
	}

	/**
	* Sets whether this loja is ordem indicada atual.
	*
	* @param ordemIndicadaAtual the ordem indicada atual of this loja
	*/
	@Override
	public void setOrdemIndicadaAtual(boolean ordemIndicadaAtual) {
		_loja.setOrdemIndicadaAtual(ordemIndicadaAtual);
	}

	/**
	* Returns the status of this loja.
	*
	* @return the status of this loja
	*/
	@Override
	public int getStatus() {
		return _loja.getStatus();
	}

	/**
	* Sets the status of this loja.
	*
	* @param status the status of this loja
	*/
	@Override
	public void setStatus(int status) {
		_loja.setStatus(status);
	}

	/**
	* Returns the status by user ID of this loja.
	*
	* @return the status by user ID of this loja
	*/
	@Override
	public long getStatusByUserId() {
		return _loja.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this loja.
	*
	* @param statusByUserId the status by user ID of this loja
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_loja.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this loja.
	*
	* @return the status by user uuid of this loja
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loja.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this loja.
	*
	* @param statusByUserUuid the status by user uuid of this loja
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_loja.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this loja.
	*
	* @return the status by user name of this loja
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _loja.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this loja.
	*
	* @param statusByUserName the status by user name of this loja
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_loja.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this loja.
	*
	* @return the status date of this loja
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _loja.getStatusDate();
	}

	/**
	* Sets the status date of this loja.
	*
	* @param statusDate the status date of this loja
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_loja.setStatusDate(statusDate);
	}

	/**
	* Returns the fully qualified class name of this loja.
	*
	* @return the fully qualified class name of this loja
	*/
	@Override
	public java.lang.String getClassName() {
		return _loja.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_loja.setClassName(className);
	}

	/**
	* Returns the class name ID of this loja.
	*
	* @return the class name ID of this loja
	*/
	@Override
	public long getClassNameId() {
		return _loja.getClassNameId();
	}

	/**
	* Sets the class name ID of this loja.
	*
	* @param classNameId the class name ID of this loja
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_loja.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this loja.
	*
	* @return the class p k of this loja
	*/
	@Override
	public long getClassPK() {
		return _loja.getClassPK();
	}

	/**
	* Sets the class p k of this loja.
	*
	* @param classPK the class p k of this loja
	*/
	@Override
	public void setClassPK(long classPK) {
		_loja.setClassPK(classPK);
	}

	/**
	* Returns the trash entry created when this loja was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this loja.
	*
	* @return the trash entry created when this loja was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loja.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this loja.
	*
	* @return the class primary key of the trash entry for this loja
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _loja.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this loja.
	*
	* @return the trash handler for this loja
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _loja.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this loja is in the Recycle Bin.
	*
	* @return <code>true</code> if this loja is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _loja.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this loja is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this loja is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _loja.isInTrashContainer();
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _loja.getApproved();
	}

	/**
	* Returns <code>true</code> if this loja is approved.
	*
	* @return <code>true</code> if this loja is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _loja.isApproved();
	}

	/**
	* Returns <code>true</code> if this loja is denied.
	*
	* @return <code>true</code> if this loja is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _loja.isDenied();
	}

	/**
	* Returns <code>true</code> if this loja is a draft.
	*
	* @return <code>true</code> if this loja is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _loja.isDraft();
	}

	/**
	* Returns <code>true</code> if this loja is expired.
	*
	* @return <code>true</code> if this loja is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _loja.isExpired();
	}

	/**
	* Returns <code>true</code> if this loja is inactive.
	*
	* @return <code>true</code> if this loja is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _loja.isInactive();
	}

	/**
	* Returns <code>true</code> if this loja is incomplete.
	*
	* @return <code>true</code> if this loja is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _loja.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this loja is pending.
	*
	* @return <code>true</code> if this loja is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _loja.isPending();
	}

	/**
	* Returns <code>true</code> if this loja is scheduled.
	*
	* @return <code>true</code> if this loja is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _loja.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _loja.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_loja.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _loja.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loja.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _loja.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _loja.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_loja.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _loja.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_loja.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_loja.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_loja.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _loja.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _loja.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_loja.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_loja.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new LojaWrapper((Loja)_loja.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.lapidarios.loja.model.Loja loja) {
		return _loja.compareTo(loja);
	}

	@Override
	public int hashCode() {
		return _loja.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.loja.model.Loja> toCacheModel() {
		return _loja.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja toEscapedModel() {
		return new LojaWrapper(_loja.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.loja.model.Loja toUnescapedModel() {
		return new LojaWrapper(_loja.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _loja.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loja.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_loja.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LojaWrapper)) {
			return false;
		}

		LojaWrapper lojaWrapper = (LojaWrapper)obj;

		if (Validator.equals(_loja, lojaWrapper._loja)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _loja.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Loja getWrappedLoja() {
		return _loja;
	}

	@Override
	public Loja getWrappedModel() {
		return _loja;
	}

	@Override
	public void resetOriginalValues() {
		_loja.resetOriginalValues();
	}

	private Loja _loja;
}