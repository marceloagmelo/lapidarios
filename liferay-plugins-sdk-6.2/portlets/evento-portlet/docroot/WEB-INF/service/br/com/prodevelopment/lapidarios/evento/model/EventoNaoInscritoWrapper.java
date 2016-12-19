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
 * This class is a wrapper for {@link EventoNaoInscrito}.
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoNaoInscrito
 * @generated
 */
public class EventoNaoInscritoWrapper implements EventoNaoInscrito,
	ModelWrapper<EventoNaoInscrito> {
	public EventoNaoInscritoWrapper(EventoNaoInscrito eventoNaoInscrito) {
		_eventoNaoInscrito = eventoNaoInscrito;
	}

	@Override
	public Class<?> getModelClass() {
		return EventoNaoInscrito.class;
	}

	@Override
	public String getModelClassName() {
		return EventoNaoInscrito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventoNaoInscritoId", getEventoNaoInscritoId());
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

		Long eventoNaoInscritoId = (Long)attributes.get("eventoNaoInscritoId");

		if (eventoNaoInscritoId != null) {
			setEventoNaoInscritoId(eventoNaoInscritoId);
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
	* Returns the primary key of this evento nao inscrito.
	*
	* @return the primary key of this evento nao inscrito
	*/
	@Override
	public long getPrimaryKey() {
		return _eventoNaoInscrito.getPrimaryKey();
	}

	/**
	* Sets the primary key of this evento nao inscrito.
	*
	* @param primaryKey the primary key of this evento nao inscrito
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventoNaoInscrito.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this evento nao inscrito.
	*
	* @return the uuid of this evento nao inscrito
	*/
	@Override
	public java.lang.String getUuid() {
		return _eventoNaoInscrito.getUuid();
	}

	/**
	* Sets the uuid of this evento nao inscrito.
	*
	* @param uuid the uuid of this evento nao inscrito
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_eventoNaoInscrito.setUuid(uuid);
	}

	/**
	* Returns the evento nao inscrito ID of this evento nao inscrito.
	*
	* @return the evento nao inscrito ID of this evento nao inscrito
	*/
	@Override
	public long getEventoNaoInscritoId() {
		return _eventoNaoInscrito.getEventoNaoInscritoId();
	}

	/**
	* Sets the evento nao inscrito ID of this evento nao inscrito.
	*
	* @param eventoNaoInscritoId the evento nao inscrito ID of this evento nao inscrito
	*/
	@Override
	public void setEventoNaoInscritoId(long eventoNaoInscritoId) {
		_eventoNaoInscrito.setEventoNaoInscritoId(eventoNaoInscritoId);
	}

	/**
	* Returns the company ID of this evento nao inscrito.
	*
	* @return the company ID of this evento nao inscrito
	*/
	@Override
	public long getCompanyId() {
		return _eventoNaoInscrito.getCompanyId();
	}

	/**
	* Sets the company ID of this evento nao inscrito.
	*
	* @param companyId the company ID of this evento nao inscrito
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventoNaoInscrito.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this evento nao inscrito.
	*
	* @return the group ID of this evento nao inscrito
	*/
	@Override
	public long getGroupId() {
		return _eventoNaoInscrito.getGroupId();
	}

	/**
	* Sets the group ID of this evento nao inscrito.
	*
	* @param groupId the group ID of this evento nao inscrito
	*/
	@Override
	public void setGroupId(long groupId) {
		_eventoNaoInscrito.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this evento nao inscrito.
	*
	* @return the create user ID of this evento nao inscrito
	*/
	@Override
	public long getCreateUserId() {
		return _eventoNaoInscrito.getCreateUserId();
	}

	/**
	* Sets the create user ID of this evento nao inscrito.
	*
	* @param createUserId the create user ID of this evento nao inscrito
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_eventoNaoInscrito.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this evento nao inscrito.
	*
	* @return the create user uuid of this evento nao inscrito
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventoNaoInscrito.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this evento nao inscrito.
	*
	* @param createUserUuid the create user uuid of this evento nao inscrito
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_eventoNaoInscrito.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the create date of this evento nao inscrito.
	*
	* @return the create date of this evento nao inscrito
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eventoNaoInscrito.getCreateDate();
	}

	/**
	* Sets the create date of this evento nao inscrito.
	*
	* @param createDate the create date of this evento nao inscrito
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eventoNaoInscrito.setCreateDate(createDate);
	}

	/**
	* Returns the evento agenda ID of this evento nao inscrito.
	*
	* @return the evento agenda ID of this evento nao inscrito
	*/
	@Override
	public long getEventoAgendaId() {
		return _eventoNaoInscrito.getEventoAgendaId();
	}

	/**
	* Sets the evento agenda ID of this evento nao inscrito.
	*
	* @param eventoAgendaId the evento agenda ID of this evento nao inscrito
	*/
	@Override
	public void setEventoAgendaId(long eventoAgendaId) {
		_eventoNaoInscrito.setEventoAgendaId(eventoAgendaId);
	}

	/**
	* Returns the evento ID of this evento nao inscrito.
	*
	* @return the evento ID of this evento nao inscrito
	*/
	@Override
	public long getEventoId() {
		return _eventoNaoInscrito.getEventoId();
	}

	/**
	* Sets the evento ID of this evento nao inscrito.
	*
	* @param eventoId the evento ID of this evento nao inscrito
	*/
	@Override
	public void setEventoId(long eventoId) {
		_eventoNaoInscrito.setEventoId(eventoId);
	}

	/**
	* Returns the user nome of this evento nao inscrito.
	*
	* @return the user nome of this evento nao inscrito
	*/
	@Override
	public java.lang.String getUserNome() {
		return _eventoNaoInscrito.getUserNome();
	}

	/**
	* Sets the user nome of this evento nao inscrito.
	*
	* @param userNome the user nome of this evento nao inscrito
	*/
	@Override
	public void setUserNome(java.lang.String userNome) {
		_eventoNaoInscrito.setUserNome(userNome);
	}

	@Override
	public boolean isNew() {
		return _eventoNaoInscrito.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventoNaoInscrito.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventoNaoInscrito.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventoNaoInscrito.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventoNaoInscrito.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventoNaoInscrito.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventoNaoInscrito.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventoNaoInscrito.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventoNaoInscrito.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventoNaoInscrito.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventoNaoInscrito.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventoNaoInscritoWrapper((EventoNaoInscrito)_eventoNaoInscrito.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito eventoNaoInscrito) {
		return _eventoNaoInscrito.compareTo(eventoNaoInscrito);
	}

	@Override
	public int hashCode() {
		return _eventoNaoInscrito.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito> toCacheModel() {
		return _eventoNaoInscrito.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito toEscapedModel() {
		return new EventoNaoInscritoWrapper(_eventoNaoInscrito.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito toUnescapedModel() {
		return new EventoNaoInscritoWrapper(_eventoNaoInscrito.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventoNaoInscrito.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventoNaoInscrito.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventoNaoInscrito.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventoNaoInscritoWrapper)) {
			return false;
		}

		EventoNaoInscritoWrapper eventoNaoInscritoWrapper = (EventoNaoInscritoWrapper)obj;

		if (Validator.equals(_eventoNaoInscrito,
					eventoNaoInscritoWrapper._eventoNaoInscrito)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventoNaoInscrito getWrappedEventoNaoInscrito() {
		return _eventoNaoInscrito;
	}

	@Override
	public EventoNaoInscrito getWrappedModel() {
		return _eventoNaoInscrito;
	}

	@Override
	public void resetOriginalValues() {
		_eventoNaoInscrito.resetOriginalValues();
	}

	private EventoNaoInscrito _eventoNaoInscrito;
}