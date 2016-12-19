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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EventoNaoInscrito service. Represents a row in the &quot;evento_nao_inscrito&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoNaoInscrito
 * @see br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoImpl
 * @see br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl
 * @generated
 */
public interface EventoNaoInscritoModel extends BaseModel<EventoNaoInscrito> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a evento nao inscrito model instance should use the {@link EventoNaoInscrito} interface instead.
	 */

	/**
	 * Returns the primary key of this evento nao inscrito.
	 *
	 * @return the primary key of this evento nao inscrito
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this evento nao inscrito.
	 *
	 * @param primaryKey the primary key of this evento nao inscrito
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this evento nao inscrito.
	 *
	 * @return the uuid of this evento nao inscrito
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this evento nao inscrito.
	 *
	 * @param uuid the uuid of this evento nao inscrito
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the evento nao inscrito ID of this evento nao inscrito.
	 *
	 * @return the evento nao inscrito ID of this evento nao inscrito
	 */
	public long getEventoNaoInscritoId();

	/**
	 * Sets the evento nao inscrito ID of this evento nao inscrito.
	 *
	 * @param eventoNaoInscritoId the evento nao inscrito ID of this evento nao inscrito
	 */
	public void setEventoNaoInscritoId(long eventoNaoInscritoId);

	/**
	 * Returns the company ID of this evento nao inscrito.
	 *
	 * @return the company ID of this evento nao inscrito
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this evento nao inscrito.
	 *
	 * @param companyId the company ID of this evento nao inscrito
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this evento nao inscrito.
	 *
	 * @return the group ID of this evento nao inscrito
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this evento nao inscrito.
	 *
	 * @param groupId the group ID of this evento nao inscrito
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create user ID of this evento nao inscrito.
	 *
	 * @return the create user ID of this evento nao inscrito
	 */
	public long getCreateUserId();

	/**
	 * Sets the create user ID of this evento nao inscrito.
	 *
	 * @param createUserId the create user ID of this evento nao inscrito
	 */
	public void setCreateUserId(long createUserId);

	/**
	 * Returns the create user uuid of this evento nao inscrito.
	 *
	 * @return the create user uuid of this evento nao inscrito
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreateUserUuid() throws SystemException;

	/**
	 * Sets the create user uuid of this evento nao inscrito.
	 *
	 * @param createUserUuid the create user uuid of this evento nao inscrito
	 */
	public void setCreateUserUuid(String createUserUuid);

	/**
	 * Returns the create date of this evento nao inscrito.
	 *
	 * @return the create date of this evento nao inscrito
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this evento nao inscrito.
	 *
	 * @param createDate the create date of this evento nao inscrito
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the evento agenda ID of this evento nao inscrito.
	 *
	 * @return the evento agenda ID of this evento nao inscrito
	 */
	public long getEventoAgendaId();

	/**
	 * Sets the evento agenda ID of this evento nao inscrito.
	 *
	 * @param eventoAgendaId the evento agenda ID of this evento nao inscrito
	 */
	public void setEventoAgendaId(long eventoAgendaId);

	/**
	 * Returns the evento ID of this evento nao inscrito.
	 *
	 * @return the evento ID of this evento nao inscrito
	 */
	public long getEventoId();

	/**
	 * Sets the evento ID of this evento nao inscrito.
	 *
	 * @param eventoId the evento ID of this evento nao inscrito
	 */
	public void setEventoId(long eventoId);

	/**
	 * Returns the user nome of this evento nao inscrito.
	 *
	 * @return the user nome of this evento nao inscrito
	 */
	@AutoEscape
	public String getUserNome();

	/**
	 * Sets the user nome of this evento nao inscrito.
	 *
	 * @param userNome the user nome of this evento nao inscrito
	 */
	public void setUserNome(String userNome);

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

	@Override
	public Object clone();

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito eventoNaoInscrito);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito> toCacheModel();

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito toEscapedModel();

	@Override
	public br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}