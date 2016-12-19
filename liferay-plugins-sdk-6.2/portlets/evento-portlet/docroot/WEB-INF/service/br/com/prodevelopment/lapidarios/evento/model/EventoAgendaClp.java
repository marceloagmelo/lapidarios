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
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.DateUtil;
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
public class EventoAgendaClp extends BaseModelImpl<EventoAgenda>
	implements EventoAgenda {
	public EventoAgendaClp() {
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
	public long getPrimaryKey() {
		return _eventoAgendaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventoAgendaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventoAgendaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_eventoAgendaRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventoAgendaId() {
		return _eventoAgendaId;
	}

	@Override
	public void setEventoAgendaId(long eventoAgendaId) {
		_eventoAgendaId = eventoAgendaId;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoAgendaId", long.class);

				method.invoke(_eventoAgendaRemoteModel, eventoAgendaId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventoAgendaRemoteModel, companyId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eventoAgendaRemoteModel, groupId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_eventoAgendaRemoteModel, createUserId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_eventoAgendaRemoteModel, modifiedUserId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eventoAgendaRemoteModel, createDate);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eventoAgendaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataEvento() {
		return _dataEvento;
	}

	@Override
	public void setDataEvento(Date dataEvento) {
		_dataEvento = dataEvento;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setDataEvento", Date.class);

				method.invoke(_eventoAgendaRemoteModel, dataEvento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHoraEvento() {
		return _horaEvento;
	}

	@Override
	public void setHoraEvento(String horaEvento) {
		_horaEvento = horaEvento;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setHoraEvento", String.class);

				method.invoke(_eventoAgendaRemoteModel, horaEvento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQtdeVagas() {
		return _qtdeVagas;
	}

	@Override
	public void setQtdeVagas(int qtdeVagas) {
		_qtdeVagas = qtdeVagas;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setQtdeVagas", int.class);

				method.invoke(_eventoAgendaRemoteModel, qtdeVagas);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQtdeVagasPreenchida() {
		return _qtdeVagasPreenchida;
	}

	@Override
	public void setQtdeVagasPreenchida(int qtdeVagasPreenchida) {
		_qtdeVagasPreenchida = qtdeVagasPreenchida;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setQtdeVagasPreenchida",
						int.class);

				method.invoke(_eventoAgendaRemoteModel, qtdeVagasPreenchida);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGratuito() {
		return _gratuito;
	}

	@Override
	public boolean isGratuito() {
		return _gratuito;
	}

	@Override
	public void setGratuito(boolean gratuito) {
		_gratuito = gratuito;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setGratuito", boolean.class);

				method.invoke(_eventoAgendaRemoteModel, gratuito);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValor() {
		return _valor;
	}

	@Override
	public void setValor(double valor) {
		_valor = valor;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setValor", double.class);

				method.invoke(_eventoAgendaRemoteModel, valor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserResponsavelId",
						long.class);

				method.invoke(_eventoAgendaRemoteModel, userResponsavelId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserResponsavelNome",
						String.class);

				method.invoke(_eventoAgendaRemoteModel, userResponsavelNome);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoId", long.class);

				method.invoke(_eventoAgendaRemoteModel, eventoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventoNome() {
		return _eventoNome;
	}

	@Override
	public String getEventoNome(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getEventoNome(languageId);
	}

	@Override
	public String getEventoNome(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getEventoNome(languageId, useDefault);
	}

	@Override
	public String getEventoNome(String languageId) {
		return LocalizationUtil.getLocalization(getEventoNome(), languageId);
	}

	@Override
	public String getEventoNome(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getEventoNome(), languageId,
			useDefault);
	}

	@Override
	public String getEventoNomeCurrentLanguageId() {
		return _eventoNomeCurrentLanguageId;
	}

	@Override
	public String getEventoNomeCurrentValue() {
		Locale locale = getLocale(_eventoNomeCurrentLanguageId);

		return getEventoNome(locale);
	}

	@Override
	public Map<Locale, String> getEventoNomeMap() {
		return LocalizationUtil.getLocalizationMap(getEventoNome());
	}

	@Override
	public void setEventoNome(String eventoNome) {
		_eventoNome = eventoNome;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoNome", String.class);

				method.invoke(_eventoAgendaRemoteModel, eventoNome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setEventoNome(String eventoNome, Locale locale) {
		setEventoNome(eventoNome, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setEventoNome(String eventoNome, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(eventoNome)) {
			setEventoNome(LocalizationUtil.updateLocalization(getEventoNome(),
					"EventoNome", eventoNome, languageId, defaultLanguageId));
		}
		else {
			setEventoNome(LocalizationUtil.removeLocalization(getEventoNome(),
					"EventoNome", languageId));
		}
	}

	@Override
	public void setEventoNomeCurrentLanguageId(String languageId) {
		_eventoNomeCurrentLanguageId = languageId;
	}

	@Override
	public void setEventoNomeMap(Map<Locale, String> eventoNomeMap) {
		setEventoNomeMap(eventoNomeMap, LocaleUtil.getDefault());
	}

	@Override
	public void setEventoNomeMap(Map<Locale, String> eventoNomeMap,
		Locale defaultLocale) {
		if (eventoNomeMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setEventoNome(LocalizationUtil.updateLocalization(eventoNomeMap,
					getEventoNome(), "EventoNome",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setLocalId", long.class);

				method.invoke(_eventoAgendaRemoteModel, localId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocalNome() {
		return _localNome;
	}

	@Override
	public void setLocalNome(String localNome) {
		_localNome = localNome;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setLocalNome", String.class);

				method.invoke(_eventoAgendaRemoteModel, localNome);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_eventoAgendaRemoteModel, observacao);
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
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_eventoAgendaRemoteModel, versao);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_eventoAgendaRemoteModel, status);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_eventoAgendaRemoteModel, statusByUserId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_eventoAgendaRemoteModel, statusByUserName);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_eventoAgendaRemoteModel, statusDate);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_eventoAgendaRemoteModel, classNameId);
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

		if (_eventoAgendaRemoteModel != null) {
			try {
				Class<?> clazz = _eventoAgendaRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_eventoAgendaRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				EventoAgenda.class.getName()), getClassNameId());
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

	public BaseModel<?> getEventoAgendaRemoteModel() {
		return _eventoAgendaRemoteModel;
	}

	public void setEventoAgendaRemoteModel(BaseModel<?> eventoAgendaRemoteModel) {
		_eventoAgendaRemoteModel = eventoAgendaRemoteModel;
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

		Class<?> remoteModelClass = _eventoAgendaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventoAgendaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventoAgendaLocalServiceUtil.addEventoAgenda(this);
		}
		else {
			EventoAgendaLocalServiceUtil.updateEventoAgenda(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> eventoNomeMap = getEventoNomeMap();

		for (Map.Entry<Locale, String> entry : eventoNomeMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

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
		String xml = getEventoNome();

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

		String eventoNome = getEventoNome(defaultLocale);

		if (Validator.isNull(eventoNome)) {
			setEventoNome(getEventoNome(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setEventoNome(getEventoNome(defaultLocale), defaultLocale,
				defaultLocale);
		}

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
	public EventoAgenda toEscapedModel() {
		return (EventoAgenda)ProxyUtil.newProxyInstance(EventoAgenda.class.getClassLoader(),
			new Class[] { EventoAgenda.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventoAgendaClp clone = new EventoAgendaClp();

		clone.setUuid(getUuid());
		clone.setEventoAgendaId(getEventoAgendaId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDataEvento(getDataEvento());
		clone.setHoraEvento(getHoraEvento());
		clone.setQtdeVagas(getQtdeVagas());
		clone.setQtdeVagasPreenchida(getQtdeVagasPreenchida());
		clone.setGratuito(getGratuito());
		clone.setValor(getValor());
		clone.setUserResponsavelId(getUserResponsavelId());
		clone.setUserResponsavelNome(getUserResponsavelNome());
		clone.setEventoId(getEventoId());
		clone.setEventoNome(getEventoNome());
		clone.setLocalId(getLocalId());
		clone.setLocalNome(getLocalNome());
		clone.setObservacao(getObservacao());
		clone.setVersao(getVersao());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());

		return clone;
	}

	@Override
	public int compareTo(EventoAgenda eventoAgenda) {
		int value = 0;

		value = getEventoNome().compareTo(eventoAgenda.getEventoNome());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getDataEvento(), eventoAgenda.getDataEvento());

		if (value != 0) {
			return value;
		}

		value = getHoraEvento().compareTo(eventoAgenda.getHoraEvento());

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

		if (!(obj instanceof EventoAgendaClp)) {
			return false;
		}

		EventoAgendaClp eventoAgenda = (EventoAgendaClp)obj;

		long primaryKey = eventoAgenda.getPrimaryKey();

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
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", eventoAgendaId=");
		sb.append(getEventoAgendaId());
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
		sb.append(", dataEvento=");
		sb.append(getDataEvento());
		sb.append(", horaEvento=");
		sb.append(getHoraEvento());
		sb.append(", qtdeVagas=");
		sb.append(getQtdeVagas());
		sb.append(", qtdeVagasPreenchida=");
		sb.append(getQtdeVagasPreenchida());
		sb.append(", gratuito=");
		sb.append(getGratuito());
		sb.append(", valor=");
		sb.append(getValor());
		sb.append(", userResponsavelId=");
		sb.append(getUserResponsavelId());
		sb.append(", userResponsavelNome=");
		sb.append(getUserResponsavelNome());
		sb.append(", eventoId=");
		sb.append(getEventoId());
		sb.append(", eventoNome=");
		sb.append(getEventoNome());
		sb.append(", localId=");
		sb.append(getLocalId());
		sb.append(", localNome=");
		sb.append(getLocalNome());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append(", versao=");
		sb.append(getVersao());
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
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.lapidarios.evento.model.EventoAgenda");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventoAgendaId</column-name><column-value><![CDATA[");
		sb.append(getEventoAgendaId());
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
			"<column><column-name>dataEvento</column-name><column-value><![CDATA[");
		sb.append(getDataEvento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>horaEvento</column-name><column-value><![CDATA[");
		sb.append(getHoraEvento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qtdeVagas</column-name><column-value><![CDATA[");
		sb.append(getQtdeVagas());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qtdeVagasPreenchida</column-name><column-value><![CDATA[");
		sb.append(getQtdeVagasPreenchida());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gratuito</column-name><column-value><![CDATA[");
		sb.append(getGratuito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valor</column-name><column-value><![CDATA[");
		sb.append(getValor());
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
			"<column><column-name>eventoId</column-name><column-value><![CDATA[");
		sb.append(getEventoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventoNome</column-name><column-value><![CDATA[");
		sb.append(getEventoNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localId</column-name><column-value><![CDATA[");
		sb.append(getLocalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localNome</column-name><column-value><![CDATA[");
		sb.append(getLocalNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
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
	private long _eventoAgendaId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dataEvento;
	private String _horaEvento;
	private int _qtdeVagas;
	private int _qtdeVagasPreenchida;
	private boolean _gratuito;
	private double _valor;
	private long _userResponsavelId;
	private String _userResponsavelNome;
	private long _eventoId;
	private String _eventoNome;
	private String _eventoNomeCurrentLanguageId;
	private long _localId;
	private String _localNome;
	private String _observacao;
	private String _observacaoCurrentLanguageId;
	private double _versao;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _classNameId;
	private long _classPK;
	private BaseModel<?> _eventoAgendaRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.lapidarios.evento.service.ClpSerializer.class;
}