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
 * This class is a wrapper for {@link EventoAgenda}.
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoAgenda
 * @generated
 */
public class EventoAgendaWrapper implements EventoAgenda,
	ModelWrapper<EventoAgenda> {
	public EventoAgendaWrapper(EventoAgenda eventoAgenda) {
		_eventoAgenda = eventoAgenda;
	}

	@Override
	public Class<?> getModelClass() {
		return EventoAgenda.class;
	}

	@Override
	public String getModelClassName() {
		return EventoAgenda.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventoAgendaId", getEventoAgendaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dataEvento", getDataEvento());
		attributes.put("horaEvento", getHoraEvento());
		attributes.put("qtdeVagas", getQtdeVagas());
		attributes.put("qtdeVagasPreenchida", getQtdeVagasPreenchida());
		attributes.put("gratuito", getGratuito());
		attributes.put("valor", getValor());
		attributes.put("userResponsavelId", getUserResponsavelId());
		attributes.put("userResponsavelNome", getUserResponsavelNome());
		attributes.put("eventoId", getEventoId());
		attributes.put("eventoNome", getEventoNome());
		attributes.put("localId", getLocalId());
		attributes.put("localNome", getLocalNome());
		attributes.put("observacao", getObservacao());
		attributes.put("versao", getVersao());
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

		Long eventoAgendaId = (Long)attributes.get("eventoAgendaId");

		if (eventoAgendaId != null) {
			setEventoAgendaId(eventoAgendaId);
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

		Date dataEvento = (Date)attributes.get("dataEvento");

		if (dataEvento != null) {
			setDataEvento(dataEvento);
		}

		String horaEvento = (String)attributes.get("horaEvento");

		if (horaEvento != null) {
			setHoraEvento(horaEvento);
		}

		Integer qtdeVagas = (Integer)attributes.get("qtdeVagas");

		if (qtdeVagas != null) {
			setQtdeVagas(qtdeVagas);
		}

		Integer qtdeVagasPreenchida = (Integer)attributes.get(
				"qtdeVagasPreenchida");

		if (qtdeVagasPreenchida != null) {
			setQtdeVagasPreenchida(qtdeVagasPreenchida);
		}

		Boolean gratuito = (Boolean)attributes.get("gratuito");

		if (gratuito != null) {
			setGratuito(gratuito);
		}

		Double valor = (Double)attributes.get("valor");

		if (valor != null) {
			setValor(valor);
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

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
		}

		String eventoNome = (String)attributes.get("eventoNome");

		if (eventoNome != null) {
			setEventoNome(eventoNome);
		}

		Long localId = (Long)attributes.get("localId");

		if (localId != null) {
			setLocalId(localId);
		}

		String localNome = (String)attributes.get("localNome");

		if (localNome != null) {
			setLocalNome(localNome);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
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
	* Returns the primary key of this evento agenda.
	*
	* @return the primary key of this evento agenda
	*/
	@Override
	public long getPrimaryKey() {
		return _eventoAgenda.getPrimaryKey();
	}

	/**
	* Sets the primary key of this evento agenda.
	*
	* @param primaryKey the primary key of this evento agenda
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventoAgenda.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this evento agenda.
	*
	* @return the uuid of this evento agenda
	*/
	@Override
	public java.lang.String getUuid() {
		return _eventoAgenda.getUuid();
	}

	/**
	* Sets the uuid of this evento agenda.
	*
	* @param uuid the uuid of this evento agenda
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_eventoAgenda.setUuid(uuid);
	}

	/**
	* Returns the evento agenda ID of this evento agenda.
	*
	* @return the evento agenda ID of this evento agenda
	*/
	@Override
	public long getEventoAgendaId() {
		return _eventoAgenda.getEventoAgendaId();
	}

	/**
	* Sets the evento agenda ID of this evento agenda.
	*
	* @param eventoAgendaId the evento agenda ID of this evento agenda
	*/
	@Override
	public void setEventoAgendaId(long eventoAgendaId) {
		_eventoAgenda.setEventoAgendaId(eventoAgendaId);
	}

	/**
	* Returns the company ID of this evento agenda.
	*
	* @return the company ID of this evento agenda
	*/
	@Override
	public long getCompanyId() {
		return _eventoAgenda.getCompanyId();
	}

	/**
	* Sets the company ID of this evento agenda.
	*
	* @param companyId the company ID of this evento agenda
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventoAgenda.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this evento agenda.
	*
	* @return the group ID of this evento agenda
	*/
	@Override
	public long getGroupId() {
		return _eventoAgenda.getGroupId();
	}

	/**
	* Sets the group ID of this evento agenda.
	*
	* @param groupId the group ID of this evento agenda
	*/
	@Override
	public void setGroupId(long groupId) {
		_eventoAgenda.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this evento agenda.
	*
	* @return the create user ID of this evento agenda
	*/
	@Override
	public long getCreateUserId() {
		return _eventoAgenda.getCreateUserId();
	}

	/**
	* Sets the create user ID of this evento agenda.
	*
	* @param createUserId the create user ID of this evento agenda
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_eventoAgenda.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this evento agenda.
	*
	* @return the create user uuid of this evento agenda
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoAgenda.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this evento agenda.
	*
	* @param createUserUuid the create user uuid of this evento agenda
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_eventoAgenda.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this evento agenda.
	*
	* @return the modified user ID of this evento agenda
	*/
	@Override
	public long getModifiedUserId() {
		return _eventoAgenda.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this evento agenda.
	*
	* @param modifiedUserId the modified user ID of this evento agenda
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_eventoAgenda.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this evento agenda.
	*
	* @return the modified user uuid of this evento agenda
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoAgenda.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this evento agenda.
	*
	* @param modifiedUserUuid the modified user uuid of this evento agenda
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_eventoAgenda.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this evento agenda.
	*
	* @return the create date of this evento agenda
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eventoAgenda.getCreateDate();
	}

	/**
	* Sets the create date of this evento agenda.
	*
	* @param createDate the create date of this evento agenda
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eventoAgenda.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this evento agenda.
	*
	* @return the modified date of this evento agenda
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eventoAgenda.getModifiedDate();
	}

	/**
	* Sets the modified date of this evento agenda.
	*
	* @param modifiedDate the modified date of this evento agenda
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eventoAgenda.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the data evento of this evento agenda.
	*
	* @return the data evento of this evento agenda
	*/
	@Override
	public java.util.Date getDataEvento() {
		return _eventoAgenda.getDataEvento();
	}

	/**
	* Sets the data evento of this evento agenda.
	*
	* @param dataEvento the data evento of this evento agenda
	*/
	@Override
	public void setDataEvento(java.util.Date dataEvento) {
		_eventoAgenda.setDataEvento(dataEvento);
	}

	/**
	* Returns the hora evento of this evento agenda.
	*
	* @return the hora evento of this evento agenda
	*/
	@Override
	public java.lang.String getHoraEvento() {
		return _eventoAgenda.getHoraEvento();
	}

	/**
	* Sets the hora evento of this evento agenda.
	*
	* @param horaEvento the hora evento of this evento agenda
	*/
	@Override
	public void setHoraEvento(java.lang.String horaEvento) {
		_eventoAgenda.setHoraEvento(horaEvento);
	}

	/**
	* Returns the qtde vagas of this evento agenda.
	*
	* @return the qtde vagas of this evento agenda
	*/
	@Override
	public int getQtdeVagas() {
		return _eventoAgenda.getQtdeVagas();
	}

	/**
	* Sets the qtde vagas of this evento agenda.
	*
	* @param qtdeVagas the qtde vagas of this evento agenda
	*/
	@Override
	public void setQtdeVagas(int qtdeVagas) {
		_eventoAgenda.setQtdeVagas(qtdeVagas);
	}

	/**
	* Returns the qtde vagas preenchida of this evento agenda.
	*
	* @return the qtde vagas preenchida of this evento agenda
	*/
	@Override
	public int getQtdeVagasPreenchida() {
		return _eventoAgenda.getQtdeVagasPreenchida();
	}

	/**
	* Sets the qtde vagas preenchida of this evento agenda.
	*
	* @param qtdeVagasPreenchida the qtde vagas preenchida of this evento agenda
	*/
	@Override
	public void setQtdeVagasPreenchida(int qtdeVagasPreenchida) {
		_eventoAgenda.setQtdeVagasPreenchida(qtdeVagasPreenchida);
	}

	/**
	* Returns the gratuito of this evento agenda.
	*
	* @return the gratuito of this evento agenda
	*/
	@Override
	public boolean getGratuito() {
		return _eventoAgenda.getGratuito();
	}

	/**
	* Returns <code>true</code> if this evento agenda is gratuito.
	*
	* @return <code>true</code> if this evento agenda is gratuito; <code>false</code> otherwise
	*/
	@Override
	public boolean isGratuito() {
		return _eventoAgenda.isGratuito();
	}

	/**
	* Sets whether this evento agenda is gratuito.
	*
	* @param gratuito the gratuito of this evento agenda
	*/
	@Override
	public void setGratuito(boolean gratuito) {
		_eventoAgenda.setGratuito(gratuito);
	}

	/**
	* Returns the valor of this evento agenda.
	*
	* @return the valor of this evento agenda
	*/
	@Override
	public double getValor() {
		return _eventoAgenda.getValor();
	}

	/**
	* Sets the valor of this evento agenda.
	*
	* @param valor the valor of this evento agenda
	*/
	@Override
	public void setValor(double valor) {
		_eventoAgenda.setValor(valor);
	}

	/**
	* Returns the user responsavel ID of this evento agenda.
	*
	* @return the user responsavel ID of this evento agenda
	*/
	@Override
	public long getUserResponsavelId() {
		return _eventoAgenda.getUserResponsavelId();
	}

	/**
	* Sets the user responsavel ID of this evento agenda.
	*
	* @param userResponsavelId the user responsavel ID of this evento agenda
	*/
	@Override
	public void setUserResponsavelId(long userResponsavelId) {
		_eventoAgenda.setUserResponsavelId(userResponsavelId);
	}

	/**
	* Returns the user responsavel nome of this evento agenda.
	*
	* @return the user responsavel nome of this evento agenda
	*/
	@Override
	public java.lang.String getUserResponsavelNome() {
		return _eventoAgenda.getUserResponsavelNome();
	}

	/**
	* Sets the user responsavel nome of this evento agenda.
	*
	* @param userResponsavelNome the user responsavel nome of this evento agenda
	*/
	@Override
	public void setUserResponsavelNome(java.lang.String userResponsavelNome) {
		_eventoAgenda.setUserResponsavelNome(userResponsavelNome);
	}

	/**
	* Returns the evento ID of this evento agenda.
	*
	* @return the evento ID of this evento agenda
	*/
	@Override
	public long getEventoId() {
		return _eventoAgenda.getEventoId();
	}

	/**
	* Sets the evento ID of this evento agenda.
	*
	* @param eventoId the evento ID of this evento agenda
	*/
	@Override
	public void setEventoId(long eventoId) {
		_eventoAgenda.setEventoId(eventoId);
	}

	/**
	* Returns the evento nome of this evento agenda.
	*
	* @return the evento nome of this evento agenda
	*/
	@Override
	public java.lang.String getEventoNome() {
		return _eventoAgenda.getEventoNome();
	}

	/**
	* Returns the localized evento nome of this evento agenda in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized evento nome of this evento agenda
	*/
	@Override
	public java.lang.String getEventoNome(java.util.Locale locale) {
		return _eventoAgenda.getEventoNome(locale);
	}

	/**
	* Returns the localized evento nome of this evento agenda in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized evento nome of this evento agenda. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getEventoNome(java.util.Locale locale,
		boolean useDefault) {
		return _eventoAgenda.getEventoNome(locale, useDefault);
	}

	/**
	* Returns the localized evento nome of this evento agenda in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized evento nome of this evento agenda
	*/
	@Override
	public java.lang.String getEventoNome(java.lang.String languageId) {
		return _eventoAgenda.getEventoNome(languageId);
	}

	/**
	* Returns the localized evento nome of this evento agenda in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized evento nome of this evento agenda
	*/
	@Override
	public java.lang.String getEventoNome(java.lang.String languageId,
		boolean useDefault) {
		return _eventoAgenda.getEventoNome(languageId, useDefault);
	}

	@Override
	public java.lang.String getEventoNomeCurrentLanguageId() {
		return _eventoAgenda.getEventoNomeCurrentLanguageId();
	}

	@Override
	public java.lang.String getEventoNomeCurrentValue() {
		return _eventoAgenda.getEventoNomeCurrentValue();
	}

	/**
	* Returns a map of the locales and localized evento nomes of this evento agenda.
	*
	* @return the locales and localized evento nomes of this evento agenda
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getEventoNomeMap() {
		return _eventoAgenda.getEventoNomeMap();
	}

	/**
	* Sets the evento nome of this evento agenda.
	*
	* @param eventoNome the evento nome of this evento agenda
	*/
	@Override
	public void setEventoNome(java.lang.String eventoNome) {
		_eventoAgenda.setEventoNome(eventoNome);
	}

	/**
	* Sets the localized evento nome of this evento agenda in the language.
	*
	* @param eventoNome the localized evento nome of this evento agenda
	* @param locale the locale of the language
	*/
	@Override
	public void setEventoNome(java.lang.String eventoNome,
		java.util.Locale locale) {
		_eventoAgenda.setEventoNome(eventoNome, locale);
	}

	/**
	* Sets the localized evento nome of this evento agenda in the language, and sets the default locale.
	*
	* @param eventoNome the localized evento nome of this evento agenda
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setEventoNome(java.lang.String eventoNome,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_eventoAgenda.setEventoNome(eventoNome, locale, defaultLocale);
	}

	@Override
	public void setEventoNomeCurrentLanguageId(java.lang.String languageId) {
		_eventoAgenda.setEventoNomeCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized evento nomes of this evento agenda from the map of locales and localized evento nomes.
	*
	* @param eventoNomeMap the locales and localized evento nomes of this evento agenda
	*/
	@Override
	public void setEventoNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> eventoNomeMap) {
		_eventoAgenda.setEventoNomeMap(eventoNomeMap);
	}

	/**
	* Sets the localized evento nomes of this evento agenda from the map of locales and localized evento nomes, and sets the default locale.
	*
	* @param eventoNomeMap the locales and localized evento nomes of this evento agenda
	* @param defaultLocale the default locale
	*/
	@Override
	public void setEventoNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> eventoNomeMap,
		java.util.Locale defaultLocale) {
		_eventoAgenda.setEventoNomeMap(eventoNomeMap, defaultLocale);
	}

	/**
	* Returns the local ID of this evento agenda.
	*
	* @return the local ID of this evento agenda
	*/
	@Override
	public long getLocalId() {
		return _eventoAgenda.getLocalId();
	}

	/**
	* Sets the local ID of this evento agenda.
	*
	* @param localId the local ID of this evento agenda
	*/
	@Override
	public void setLocalId(long localId) {
		_eventoAgenda.setLocalId(localId);
	}

	/**
	* Returns the local nome of this evento agenda.
	*
	* @return the local nome of this evento agenda
	*/
	@Override
	public java.lang.String getLocalNome() {
		return _eventoAgenda.getLocalNome();
	}

	/**
	* Sets the local nome of this evento agenda.
	*
	* @param localNome the local nome of this evento agenda
	*/
	@Override
	public void setLocalNome(java.lang.String localNome) {
		_eventoAgenda.setLocalNome(localNome);
	}

	/**
	* Returns the observacao of this evento agenda.
	*
	* @return the observacao of this evento agenda
	*/
	@Override
	public java.lang.String getObservacao() {
		return _eventoAgenda.getObservacao();
	}

	/**
	* Returns the localized observacao of this evento agenda in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized observacao of this evento agenda
	*/
	@Override
	public java.lang.String getObservacao(java.util.Locale locale) {
		return _eventoAgenda.getObservacao(locale);
	}

	/**
	* Returns the localized observacao of this evento agenda in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized observacao of this evento agenda. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getObservacao(java.util.Locale locale,
		boolean useDefault) {
		return _eventoAgenda.getObservacao(locale, useDefault);
	}

	/**
	* Returns the localized observacao of this evento agenda in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized observacao of this evento agenda
	*/
	@Override
	public java.lang.String getObservacao(java.lang.String languageId) {
		return _eventoAgenda.getObservacao(languageId);
	}

	/**
	* Returns the localized observacao of this evento agenda in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized observacao of this evento agenda
	*/
	@Override
	public java.lang.String getObservacao(java.lang.String languageId,
		boolean useDefault) {
		return _eventoAgenda.getObservacao(languageId, useDefault);
	}

	@Override
	public java.lang.String getObservacaoCurrentLanguageId() {
		return _eventoAgenda.getObservacaoCurrentLanguageId();
	}

	@Override
	public java.lang.String getObservacaoCurrentValue() {
		return _eventoAgenda.getObservacaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized observacaos of this evento agenda.
	*
	* @return the locales and localized observacaos of this evento agenda
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getObservacaoMap() {
		return _eventoAgenda.getObservacaoMap();
	}

	/**
	* Sets the observacao of this evento agenda.
	*
	* @param observacao the observacao of this evento agenda
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_eventoAgenda.setObservacao(observacao);
	}

	/**
	* Sets the localized observacao of this evento agenda in the language.
	*
	* @param observacao the localized observacao of this evento agenda
	* @param locale the locale of the language
	*/
	@Override
	public void setObservacao(java.lang.String observacao,
		java.util.Locale locale) {
		_eventoAgenda.setObservacao(observacao, locale);
	}

	/**
	* Sets the localized observacao of this evento agenda in the language, and sets the default locale.
	*
	* @param observacao the localized observacao of this evento agenda
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setObservacao(java.lang.String observacao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_eventoAgenda.setObservacao(observacao, locale, defaultLocale);
	}

	@Override
	public void setObservacaoCurrentLanguageId(java.lang.String languageId) {
		_eventoAgenda.setObservacaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized observacaos of this evento agenda from the map of locales and localized observacaos.
	*
	* @param observacaoMap the locales and localized observacaos of this evento agenda
	*/
	@Override
	public void setObservacaoMap(
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap) {
		_eventoAgenda.setObservacaoMap(observacaoMap);
	}

	/**
	* Sets the localized observacaos of this evento agenda from the map of locales and localized observacaos, and sets the default locale.
	*
	* @param observacaoMap the locales and localized observacaos of this evento agenda
	* @param defaultLocale the default locale
	*/
	@Override
	public void setObservacaoMap(
		java.util.Map<java.util.Locale, java.lang.String> observacaoMap,
		java.util.Locale defaultLocale) {
		_eventoAgenda.setObservacaoMap(observacaoMap, defaultLocale);
	}

	/**
	* Returns the versao of this evento agenda.
	*
	* @return the versao of this evento agenda
	*/
	@Override
	public double getVersao() {
		return _eventoAgenda.getVersao();
	}

	/**
	* Sets the versao of this evento agenda.
	*
	* @param versao the versao of this evento agenda
	*/
	@Override
	public void setVersao(double versao) {
		_eventoAgenda.setVersao(versao);
	}

	/**
	* Returns the status of this evento agenda.
	*
	* @return the status of this evento agenda
	*/
	@Override
	public int getStatus() {
		return _eventoAgenda.getStatus();
	}

	/**
	* Sets the status of this evento agenda.
	*
	* @param status the status of this evento agenda
	*/
	@Override
	public void setStatus(int status) {
		_eventoAgenda.setStatus(status);
	}

	/**
	* Returns the status by user ID of this evento agenda.
	*
	* @return the status by user ID of this evento agenda
	*/
	@Override
	public long getStatusByUserId() {
		return _eventoAgenda.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this evento agenda.
	*
	* @param statusByUserId the status by user ID of this evento agenda
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_eventoAgenda.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this evento agenda.
	*
	* @return the status by user uuid of this evento agenda
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoAgenda.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this evento agenda.
	*
	* @param statusByUserUuid the status by user uuid of this evento agenda
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_eventoAgenda.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this evento agenda.
	*
	* @return the status by user name of this evento agenda
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _eventoAgenda.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this evento agenda.
	*
	* @param statusByUserName the status by user name of this evento agenda
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_eventoAgenda.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this evento agenda.
	*
	* @return the status date of this evento agenda
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _eventoAgenda.getStatusDate();
	}

	/**
	* Sets the status date of this evento agenda.
	*
	* @param statusDate the status date of this evento agenda
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_eventoAgenda.setStatusDate(statusDate);
	}

	/**
	* Returns the fully qualified class name of this evento agenda.
	*
	* @return the fully qualified class name of this evento agenda
	*/
	@Override
	public java.lang.String getClassName() {
		return _eventoAgenda.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_eventoAgenda.setClassName(className);
	}

	/**
	* Returns the class name ID of this evento agenda.
	*
	* @return the class name ID of this evento agenda
	*/
	@Override
	public long getClassNameId() {
		return _eventoAgenda.getClassNameId();
	}

	/**
	* Sets the class name ID of this evento agenda.
	*
	* @param classNameId the class name ID of this evento agenda
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_eventoAgenda.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this evento agenda.
	*
	* @return the class p k of this evento agenda
	*/
	@Override
	public long getClassPK() {
		return _eventoAgenda.getClassPK();
	}

	/**
	* Sets the class p k of this evento agenda.
	*
	* @param classPK the class p k of this evento agenda
	*/
	@Override
	public void setClassPK(long classPK) {
		_eventoAgenda.setClassPK(classPK);
	}

	/**
	* Returns the trash entry created when this evento agenda was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this evento agenda.
	*
	* @return the trash entry created when this evento agenda was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventoAgenda.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this evento agenda.
	*
	* @return the class primary key of the trash entry for this evento agenda
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _eventoAgenda.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this evento agenda.
	*
	* @return the trash handler for this evento agenda
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _eventoAgenda.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this evento agenda is in the Recycle Bin.
	*
	* @return <code>true</code> if this evento agenda is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _eventoAgenda.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this evento agenda is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this evento agenda is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _eventoAgenda.isInTrashContainer();
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _eventoAgenda.getApproved();
	}

	/**
	* Returns <code>true</code> if this evento agenda is approved.
	*
	* @return <code>true</code> if this evento agenda is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _eventoAgenda.isApproved();
	}

	/**
	* Returns <code>true</code> if this evento agenda is denied.
	*
	* @return <code>true</code> if this evento agenda is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _eventoAgenda.isDenied();
	}

	/**
	* Returns <code>true</code> if this evento agenda is a draft.
	*
	* @return <code>true</code> if this evento agenda is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _eventoAgenda.isDraft();
	}

	/**
	* Returns <code>true</code> if this evento agenda is expired.
	*
	* @return <code>true</code> if this evento agenda is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _eventoAgenda.isExpired();
	}

	/**
	* Returns <code>true</code> if this evento agenda is inactive.
	*
	* @return <code>true</code> if this evento agenda is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _eventoAgenda.isInactive();
	}

	/**
	* Returns <code>true</code> if this evento agenda is incomplete.
	*
	* @return <code>true</code> if this evento agenda is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _eventoAgenda.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this evento agenda is pending.
	*
	* @return <code>true</code> if this evento agenda is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _eventoAgenda.isPending();
	}

	/**
	* Returns <code>true</code> if this evento agenda is scheduled.
	*
	* @return <code>true</code> if this evento agenda is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _eventoAgenda.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _eventoAgenda.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventoAgenda.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventoAgenda.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventoAgenda.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventoAgenda.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventoAgenda.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventoAgenda.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventoAgenda.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventoAgenda.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventoAgenda.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventoAgenda.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _eventoAgenda.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _eventoAgenda.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_eventoAgenda.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_eventoAgenda.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new EventoAgendaWrapper((EventoAgenda)_eventoAgenda.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda) {
		return _eventoAgenda.compareTo(eventoAgenda);
	}

	@Override
	public int hashCode() {
		return _eventoAgenda.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.evento.model.EventoAgenda> toCacheModel() {
		return _eventoAgenda.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda toEscapedModel() {
		return new EventoAgendaWrapper(_eventoAgenda.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoAgenda toUnescapedModel() {
		return new EventoAgendaWrapper(_eventoAgenda.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventoAgenda.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventoAgenda.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventoAgenda.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventoAgendaWrapper)) {
			return false;
		}

		EventoAgendaWrapper eventoAgendaWrapper = (EventoAgendaWrapper)obj;

		if (Validator.equals(_eventoAgenda, eventoAgendaWrapper._eventoAgenda)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _eventoAgenda.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventoAgenda getWrappedEventoAgenda() {
		return _eventoAgenda;
	}

	@Override
	public EventoAgenda getWrappedModel() {
		return _eventoAgenda;
	}

	@Override
	public void resetOriginalValues() {
		_eventoAgenda.resetOriginalValues();
	}

	private EventoAgenda _eventoAgenda;
}