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
import br.com.prodevelopment.lapidarios.evento.service.EventoLocalServiceUtil;

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
public class EventoClp extends BaseModelImpl<Evento> implements Evento {
	public EventoClp() {
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
	public long getPrimaryKey() {
		return _eventoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_eventoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventoId() {
		return _eventoId;
	}

	@Override
	public void setEventoId(long eventoId) {
		_eventoId = eventoId;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoId", long.class);

				method.invoke(_eventoRemoteModel, eventoId);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventoRemoteModel, companyId);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eventoRemoteModel, groupId);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_eventoRemoteModel, createUserId);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_eventoRemoteModel, modifiedUserId);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eventoRemoteModel, createDate);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eventoRemoteModel, modifiedDate);
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
	public String getNome(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getNome(languageId);
	}

	@Override
	public String getNome(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getNome(languageId, useDefault);
	}

	@Override
	public String getNome(String languageId) {
		return LocalizationUtil.getLocalization(getNome(), languageId);
	}

	@Override
	public String getNome(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getNome(), languageId,
			useDefault);
	}

	@Override
	public String getNomeCurrentLanguageId() {
		return _nomeCurrentLanguageId;
	}

	@Override
	public String getNomeCurrentValue() {
		Locale locale = getLocale(_nomeCurrentLanguageId);

		return getNome(locale);
	}

	@Override
	public Map<Locale, String> getNomeMap() {
		return LocalizationUtil.getLocalizationMap(getNome());
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_eventoRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setNome(String nome, Locale locale) {
		setNome(nome, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setNome(String nome, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(nome)) {
			setNome(LocalizationUtil.updateLocalization(getNome(), "Nome",
					nome, languageId, defaultLanguageId));
		}
		else {
			setNome(LocalizationUtil.removeLocalization(getNome(), "Nome",
					languageId));
		}
	}

	@Override
	public void setNomeCurrentLanguageId(String languageId) {
		_nomeCurrentLanguageId = languageId;
	}

	@Override
	public void setNomeMap(Map<Locale, String> nomeMap) {
		setNomeMap(nomeMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNomeMap(Map<Locale, String> nomeMap, Locale defaultLocale) {
		if (nomeMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setNome(LocalizationUtil.updateLocalization(nomeMap, getNome(),
					"Nome", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDescricao() {
		return _descricao;
	}

	@Override
	public String getDescricao(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescricao(languageId);
	}

	@Override
	public String getDescricao(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescricao(languageId, useDefault);
	}

	@Override
	public String getDescricao(String languageId) {
		return LocalizationUtil.getLocalization(getDescricao(), languageId);
	}

	@Override
	public String getDescricao(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescricao(), languageId,
			useDefault);
	}

	@Override
	public String getDescricaoCurrentLanguageId() {
		return _descricaoCurrentLanguageId;
	}

	@Override
	public String getDescricaoCurrentValue() {
		Locale locale = getLocale(_descricaoCurrentLanguageId);

		return getDescricao(locale);
	}

	@Override
	public Map<Locale, String> getDescricaoMap() {
		return LocalizationUtil.getLocalizationMap(getDescricao());
	}

	@Override
	public void setDescricao(String descricao) {
		_descricao = descricao;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescricao", String.class);

				method.invoke(_eventoRemoteModel, descricao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDescricao(String descricao, Locale locale) {
		setDescricao(descricao, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescricao(String descricao, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(descricao)) {
			setDescricao(LocalizationUtil.updateLocalization(getDescricao(),
					"Descricao", descricao, languageId, defaultLanguageId));
		}
		else {
			setDescricao(LocalizationUtil.removeLocalization(getDescricao(),
					"Descricao", languageId));
		}
	}

	@Override
	public void setDescricaoCurrentLanguageId(String languageId) {
		_descricaoCurrentLanguageId = languageId;
	}

	@Override
	public void setDescricaoMap(Map<Locale, String> descricaoMap) {
		setDescricaoMap(descricaoMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescricaoMap(Map<Locale, String> descricaoMap,
		Locale defaultLocale) {
		if (descricaoMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setDescricao(LocalizationUtil.updateLocalization(descricaoMap,
					getDescricao(), "Descricao",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getUserResponsavelId() {
		return _userResponsavelId;
	}

	@Override
	public void setUserResponsavelId(long userResponsavelId) {
		_userResponsavelId = userResponsavelId;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserResponsavelId",
						long.class);

				method.invoke(_eventoRemoteModel, userResponsavelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserResponsavelNome() {
		return _userResponsavelNome;
	}

	@Override
	public void setUserResponsavelNome(String userResponsavelNome) {
		_userResponsavelNome = userResponsavelNome;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserResponsavelNome",
						String.class);

				method.invoke(_eventoRemoteModel, userResponsavelNome);
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

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_eventoRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImagemId() {
		return _imagemId;
	}

	@Override
	public void setImagemId(long imagemId) {
		_imagemId = imagemId;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setImagemId", long.class);

				method.invoke(_eventoRemoteModel, imagemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_articleId = articleId;

		if (_eventoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleId", long.class);

				method.invoke(_eventoRemoteModel, articleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Evento.class.getName()));
	}

	public BaseModel<?> getEventoRemoteModel() {
		return _eventoRemoteModel;
	}

	public void setEventoRemoteModel(BaseModel<?> eventoRemoteModel) {
		_eventoRemoteModel = eventoRemoteModel;
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

		Class<?> remoteModelClass = _eventoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventoLocalServiceUtil.addEvento(this);
		}
		else {
			EventoLocalServiceUtil.updateEvento(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nomeMap = getNomeMap();

		for (Map.Entry<Locale, String> entry : nomeMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descricaoMap = getDescricaoMap();

		for (Map.Entry<Locale, String> entry : descricaoMap.entrySet()) {
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
		String xml = getNome();

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

		String nome = getNome(defaultLocale);

		if (Validator.isNull(nome)) {
			setNome(getNome(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setNome(getNome(defaultLocale), defaultLocale, defaultLocale);
		}

		String descricao = getDescricao(defaultLocale);

		if (Validator.isNull(descricao)) {
			setDescricao(getDescricao(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescricao(getDescricao(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Evento toEscapedModel() {
		return (Evento)ProxyUtil.newProxyInstance(Evento.class.getClassLoader(),
			new Class[] { Evento.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventoClp clone = new EventoClp();

		clone.setUuid(getUuid());
		clone.setEventoId(getEventoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNome(getNome());
		clone.setDescricao(getDescricao());
		clone.setUserResponsavelId(getUserResponsavelId());
		clone.setUserResponsavelNome(getUserResponsavelNome());
		clone.setVersao(getVersao());
		clone.setImagemId(getImagemId());
		clone.setArticleId(getArticleId());

		return clone;
	}

	@Override
	public int compareTo(Evento evento) {
		int value = 0;

		value = getNome().compareTo(evento.getNome());

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

		if (!(obj instanceof EventoClp)) {
			return false;
		}

		EventoClp evento = (EventoClp)obj;

		long primaryKey = evento.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", eventoId=");
		sb.append(getEventoId());
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
		sb.append(", descricao=");
		sb.append(getDescricao());
		sb.append(", userResponsavelId=");
		sb.append(getUserResponsavelId());
		sb.append(", userResponsavelNome=");
		sb.append(getUserResponsavelNome());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append(", imagemId=");
		sb.append(getImagemId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.lapidarios.evento.model.Evento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventoId</column-name><column-value><![CDATA[");
		sb.append(getEventoId());
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
			"<column><column-name>descricao</column-name><column-value><![CDATA[");
		sb.append(getDescricao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userResponsavelId</column-name><column-value><![CDATA[");
		sb.append(getUserResponsavelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userResponsavelNome</column-name><column-value><![CDATA[");
		sb.append(getUserResponsavelNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imagemId</column-name><column-value><![CDATA[");
		sb.append(getImagemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _eventoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _nomeCurrentLanguageId;
	private String _descricao;
	private String _descricaoCurrentLanguageId;
	private long _userResponsavelId;
	private String _userResponsavelNome;
	private double _versao;
	private long _imagemId;
	private long _articleId;
	private BaseModel<?> _eventoRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.lapidarios.evento.service.ClpSerializer.class;
}