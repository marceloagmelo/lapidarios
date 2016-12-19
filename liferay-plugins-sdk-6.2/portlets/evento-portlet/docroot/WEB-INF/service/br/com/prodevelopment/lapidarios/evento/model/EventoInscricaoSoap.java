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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.lapidarios.evento.service.http.EventoInscricaoServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.http.EventoInscricaoServiceSoap
 * @generated
 */
public class EventoInscricaoSoap implements Serializable {
	public static EventoInscricaoSoap toSoapModel(EventoInscricao model) {
		EventoInscricaoSoap soapModel = new EventoInscricaoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventoInscricaoId(model.getEventoInscricaoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setEventoAgendaId(model.getEventoAgendaId());
		soapModel.setEventoId(model.getEventoId());
		soapModel.setUserNome(model.getUserNome());

		return soapModel;
	}

	public static EventoInscricaoSoap[] toSoapModels(EventoInscricao[] models) {
		EventoInscricaoSoap[] soapModels = new EventoInscricaoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventoInscricaoSoap[][] toSoapModels(
		EventoInscricao[][] models) {
		EventoInscricaoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventoInscricaoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventoInscricaoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventoInscricaoSoap[] toSoapModels(
		List<EventoInscricao> models) {
		List<EventoInscricaoSoap> soapModels = new ArrayList<EventoInscricaoSoap>(models.size());

		for (EventoInscricao model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventoInscricaoSoap[soapModels.size()]);
	}

	public EventoInscricaoSoap() {
	}

	public long getPrimaryKey() {
		return _eventoInscricaoId;
	}

	public void setPrimaryKey(long pk) {
		setEventoInscricaoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventoInscricaoId() {
		return _eventoInscricaoId;
	}

	public void setEventoInscricaoId(long eventoInscricaoId) {
		_eventoInscricaoId = eventoInscricaoId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getEventoAgendaId() {
		return _eventoAgendaId;
	}

	public void setEventoAgendaId(long eventoAgendaId) {
		_eventoAgendaId = eventoAgendaId;
	}

	public long getEventoId() {
		return _eventoId;
	}

	public void setEventoId(long eventoId) {
		_eventoId = eventoId;
	}

	public String getUserNome() {
		return _userNome;
	}

	public void setUserNome(String userNome) {
		_userNome = userNome;
	}

	private String _uuid;
	private long _eventoInscricaoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private Date _createDate;
	private long _eventoAgendaId;
	private long _eventoId;
	private String _userNome;
}