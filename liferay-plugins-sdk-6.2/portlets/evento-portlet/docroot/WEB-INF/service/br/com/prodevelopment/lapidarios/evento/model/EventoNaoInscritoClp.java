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
import br.com.prodevelopment.lapidarios.evento.service.EventoNaoInscritoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class EventoNaoInscritoClp extends BaseModelImpl<EventoNaoInscrito>
	implements EventoNaoInscrito {
	public EventoNaoInscritoClp() {
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
	public long getPrimaryKey() {
		return _eventoNaoInscritoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventoNaoInscritoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventoNaoInscritoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_eventoNaoInscritoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventoNaoInscritoId() {
		return _eventoNaoInscritoId;
	}

	@Override
	public void setEventoNaoInscritoId(long eventoNaoInscritoId) {
		_eventoNaoInscritoId = eventoNaoInscritoId;

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoNaoInscritoId",
						long.class);

				method.invoke(_eventoNaoInscritoRemoteModel, eventoNaoInscritoId);
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

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventoNaoInscritoRemoteModel, companyId);
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

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eventoNaoInscritoRemoteModel, groupId);
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

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_eventoNaoInscritoRemoteModel, createUserId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eventoNaoInscritoRemoteModel, createDate);
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

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoAgendaId", long.class);

				method.invoke(_eventoNaoInscritoRemoteModel, eventoAgendaId);
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

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setEventoId", long.class);

				method.invoke(_eventoNaoInscritoRemoteModel, eventoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserNome() {
		return _userNome;
	}

	@Override
	public void setUserNome(String userNome) {
		_userNome = userNome;

		if (_eventoNaoInscritoRemoteModel != null) {
			try {
				Class<?> clazz = _eventoNaoInscritoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserNome", String.class);

				method.invoke(_eventoNaoInscritoRemoteModel, userNome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventoNaoInscritoRemoteModel() {
		return _eventoNaoInscritoRemoteModel;
	}

	public void setEventoNaoInscritoRemoteModel(
		BaseModel<?> eventoNaoInscritoRemoteModel) {
		_eventoNaoInscritoRemoteModel = eventoNaoInscritoRemoteModel;
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

		Class<?> remoteModelClass = _eventoNaoInscritoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventoNaoInscritoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventoNaoInscritoLocalServiceUtil.addEventoNaoInscrito(this);
		}
		else {
			EventoNaoInscritoLocalServiceUtil.updateEventoNaoInscrito(this);
		}
	}

	@Override
	public EventoNaoInscrito toEscapedModel() {
		return (EventoNaoInscrito)ProxyUtil.newProxyInstance(EventoNaoInscrito.class.getClassLoader(),
			new Class[] { EventoNaoInscrito.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventoNaoInscritoClp clone = new EventoNaoInscritoClp();

		clone.setUuid(getUuid());
		clone.setEventoNaoInscritoId(getEventoNaoInscritoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreateDate(getCreateDate());
		clone.setEventoAgendaId(getEventoAgendaId());
		clone.setEventoId(getEventoId());
		clone.setUserNome(getUserNome());

		return clone;
	}

	@Override
	public int compareTo(EventoNaoInscrito eventoNaoInscrito) {
		int value = 0;

		if (getEventoNaoInscritoId() < eventoNaoInscrito.getEventoNaoInscritoId()) {
			value = -1;
		}
		else if (getEventoNaoInscritoId() > eventoNaoInscrito.getEventoNaoInscritoId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof EventoNaoInscritoClp)) {
			return false;
		}

		EventoNaoInscritoClp eventoNaoInscrito = (EventoNaoInscritoClp)obj;

		long primaryKey = eventoNaoInscrito.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", eventoNaoInscritoId=");
		sb.append(getEventoNaoInscritoId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", eventoAgendaId=");
		sb.append(getEventoAgendaId());
		sb.append(", eventoId=");
		sb.append(getEventoId());
		sb.append(", userNome=");
		sb.append(getUserNome());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventoNaoInscritoId</column-name><column-value><![CDATA[");
		sb.append(getEventoNaoInscritoId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventoAgendaId</column-name><column-value><![CDATA[");
		sb.append(getEventoAgendaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventoId</column-name><column-value><![CDATA[");
		sb.append(getEventoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userNome</column-name><column-value><![CDATA[");
		sb.append(getUserNome());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _eventoNaoInscritoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private Date _createDate;
	private long _eventoAgendaId;
	private long _eventoId;
	private String _userNome;
	private BaseModel<?> _eventoNaoInscritoRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.lapidarios.evento.service.ClpSerializer.class;
}