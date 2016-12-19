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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventoInscricao}.
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoInscricao
 * @generated
 */
public class EventoInscricaoWrapper implements EventoInscricao,
	ModelWrapper<EventoInscricao> {
	public EventoInscricaoWrapper(EventoInscricao eventoInscricao) {
		_eventoInscricao = eventoInscricao;
	}

	@Override
	public Class<?> getModelClass() {
		return EventoInscricao.class;
	}

	@Override
	public String getModelClassName() {
		return EventoInscricao.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventoInscricaoId", getEventoInscricaoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("eventoAgendaId", getEventoAgendaId());
		attributes.put("eventoId", getEventoId());
		attributes.put("userNome", getUserNome());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventoInscricaoId = (Long)attributes.get("eventoInscricaoId");

		if (eventoInscricaoId != null) {
			setEventoInscricaoId(eventoInscricaoId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long eventoAgendaId = (Long)attributes.get("eventoAgendaId");

		if (eventoAgendaId != null) {
			setEventoAgendaId(eventoAgendaId);
		}

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
		}

		String userNome = (String)attributes.get("userNome");

		if (userNome != null) {
			setUserNome(userNome);
		}
	}

	/**
	* Returns the primary key of this evento inscricao.
	*
	* @return the primary key of this evento inscricao
	*/
	@Override
	public long getPrimaryKey() {
		return _eventoInscricao.getPrimaryKey();
	}

	/**
	* Sets the primary key of this evento inscricao.
	*
	* @param primaryKey the primary key of this evento inscricao
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventoInscricao.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this evento inscricao.
	*
	* @return the uuid of this evento inscricao
	*/
	@Override
	public java.lang.String getUuid() {
		return _eventoInscricao.getUuid();
	}

	/**
	* Sets the uuid of this evento inscricao.
	*
	* @param uuid the uuid of this evento inscricao
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_eventoInscricao.setUuid(uuid);
	}

	/**
	* Returns the evento inscricao ID of this evento inscricao.
	*
	* @return the evento inscricao ID of this evento inscricao
	*/
	@Override
	public long getEventoInscricaoId() {
		return _eventoInscricao.getEventoInscricaoId();
	}

	/**
	* Sets the evento inscricao ID of this evento inscricao.
	*
	* @param eventoInscricaoId the evento inscricao ID of this evento inscricao
	*/
	@Override
	public void setEventoInscricaoId(long eventoInscricaoId) {
		_eventoInscricao.setEventoInscricaoId(eventoInscricaoId);
	}

	/**
	* Returns the company ID of this evento inscricao.
	*
	* @return the company ID of this evento inscricao
	*/
	@Override
	public long getCompanyId() {
		return _eventoInscricao.getCompanyId();
	}

	/**
	* Sets the company ID of this evento inscricao.
	*
	* @param companyId the company ID of this evento inscricao
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventoInscricao.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this evento inscricao.
	*
	* @return the group ID of this evento inscricao
	*/
	@Override
	public long getGroupId() {
		return _eventoInscricao.getGroupId();
	}

	/**
	* Sets the group ID of this evento inscricao.
	*
	* @param groupId the group ID of this evento inscricao
	*/
	@Override
	public void setGroupId(long groupId) {
		_eventoInscricao.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this evento inscricao.
	*
	* @return the create user ID of this evento inscricao
	*/
	@Override
	public long getCreateUserId() {
		return _eventoInscricao.getCreateUserId();
	}

	/**
	* Sets the create user ID of this evento inscricao.
	*
	* @param createUserId the create user ID of this evento inscricao
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_eventoInscricao.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this evento inscricao.
	*
	* @return the create user uuid of this evento inscricao
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoInscricao.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this evento inscricao.
	*
	* @param createUserUuid the create user uuid of this evento inscricao
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_eventoInscricao.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the create date of this evento inscricao.
	*
	* @return the create date of this evento inscricao
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eventoInscricao.getCreateDate();
	}

	/**
	* Sets the create date of this evento inscricao.
	*
	* @param createDate the create date of this evento inscricao
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eventoInscricao.setCreateDate(createDate);
	}

	/**
	* Returns the evento agenda ID of this evento inscricao.
	*
	* @return the evento agenda ID of this evento inscricao
	*/
	@Override
	public long getEventoAgendaId() {
		return _eventoInscricao.getEventoAgendaId();
	}

	/**
	* Sets the evento agenda ID of this evento inscricao.
	*
	* @param eventoAgendaId the evento agenda ID of this evento inscricao
	*/
	@Override
	public void setEventoAgendaId(long eventoAgendaId) {
		_eventoInscricao.setEventoAgendaId(eventoAgendaId);
	}

	/**
	* Returns the evento ID of this evento inscricao.
	*
	* @return the evento ID of this evento inscricao
	*/
	@Override
	public long getEventoId() {
		return _eventoInscricao.getEventoId();
	}

	/**
	* Sets the evento ID of this evento inscricao.
	*
	* @param eventoId the evento ID of this evento inscricao
	*/
	@Override
	public void setEventoId(long eventoId) {
		_eventoInscricao.setEventoId(eventoId);
	}

	/**
	* Returns the user nome of this evento inscricao.
	*
	* @return the user nome of this evento inscricao
	*/
	@Override
	public java.lang.String getUserNome() {
		return _eventoInscricao.getUserNome();
	}

	/**
	* Sets the user nome of this evento inscricao.
	*
	* @param userNome the user nome of this evento inscricao
	*/
	@Override
	public void setUserNome(java.lang.String userNome) {
		_eventoInscricao.setUserNome(userNome);
	}

	@Override
	public boolean isNew() {
		return _eventoInscricao.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventoInscricao.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventoInscricao.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventoInscricao.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventoInscricao.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventoInscricao.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventoInscricao.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventoInscricao.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventoInscricao.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventoInscricao.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventoInscricao.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventoInscricaoWrapper((EventoInscricao)_eventoInscricao.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao) {
		return _eventoInscricao.compareTo(eventoInscricao);
	}

	@Override
	public int hashCode() {
		return _eventoInscricao.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.evento.model.EventoInscricao> toCacheModel() {
		return _eventoInscricao.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao toEscapedModel() {
		return new EventoInscricaoWrapper(_eventoInscricao.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoInscricao toUnescapedModel() {
		return new EventoInscricaoWrapper(_eventoInscricao.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventoInscricao.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventoInscricao.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventoInscricao.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventoInscricaoWrapper)) {
			return false;
		}

		EventoInscricaoWrapper eventoInscricaoWrapper = (EventoInscricaoWrapper)obj;

		if (Validator.equals(_eventoInscricao,
					eventoInscricaoWrapper._eventoInscricao)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventoInscricao getWrappedEventoInscricao() {
		return _eventoInscricao;
	}

	@Override
	public EventoInscricao getWrappedModel() {
		return _eventoInscricao;
	}

	@Override
	public void resetOriginalValues() {
		_eventoInscricao.resetOriginalValues();
	}

	private EventoInscricao _eventoInscricao;
}