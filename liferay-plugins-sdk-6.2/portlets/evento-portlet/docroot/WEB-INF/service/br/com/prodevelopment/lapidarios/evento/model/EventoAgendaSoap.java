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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.lapidarios.evento.service.http.EventoAgendaServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.http.EventoAgendaServiceSoap
 * @generated
 */
public class EventoAgendaSoap implements Serializable {
	public static EventoAgendaSoap toSoapModel(EventoAgenda model) {
		EventoAgendaSoap soapModel = new EventoAgendaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventoAgendaId(model.getEventoAgendaId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDataEvento(model.getDataEvento());
		soapModel.setHoraEvento(model.getHoraEvento());
		soapModel.setQtdeVagas(model.getQtdeVagas());
		soapModel.setQtdeVagasPreenchida(model.getQtdeVagasPreenchida());
		soapModel.setGratuito(model.getGratuito());
		soapModel.setValor(model.getValor());
		soapModel.setUserResponsavelId(model.getUserResponsavelId());
		soapModel.setUserResponsavelNome(model.getUserResponsavelNome());
		soapModel.setEventoId(model.getEventoId());
		soapModel.setEventoNome(model.getEventoNome());
		soapModel.setLocalId(model.getLocalId());
		soapModel.setLocalNome(model.getLocalNome());
		soapModel.setObservacao(model.getObservacao());
		soapModel.setVersao(model.getVersao());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static EventoAgendaSoap[] toSoapModels(EventoAgenda[] models) {
		EventoAgendaSoap[] soapModels = new EventoAgendaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventoAgendaSoap[][] toSoapModels(EventoAgenda[][] models) {
		EventoAgendaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventoAgendaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventoAgendaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventoAgendaSoap[] toSoapModels(List<EventoAgenda> models) {
		List<EventoAgendaSoap> soapModels = new ArrayList<EventoAgendaSoap>(models.size());

		for (EventoAgenda model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventoAgendaSoap[soapModels.size()]);
	}

	public EventoAgendaSoap() {
	}

	public long getPrimaryKey() {
		return _eventoAgendaId;
	}

	public void setPrimaryKey(long pk) {
		setEventoAgendaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventoAgendaId() {
		return _eventoAgendaId;
	}

	public void setEventoAgendaId(long eventoAgendaId) {
		_eventoAgendaId = eventoAgendaId;
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

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getDataEvento() {
		return _dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		_dataEvento = dataEvento;
	}

	public String getHoraEvento() {
		return _horaEvento;
	}

	public void setHoraEvento(String horaEvento) {
		_horaEvento = horaEvento;
	}

	public int getQtdeVagas() {
		return _qtdeVagas;
	}

	public void setQtdeVagas(int qtdeVagas) {
		_qtdeVagas = qtdeVagas;
	}

	public int getQtdeVagasPreenchida() {
		return _qtdeVagasPreenchida;
	}

	public void setQtdeVagasPreenchida(int qtdeVagasPreenchida) {
		_qtdeVagasPreenchida = qtdeVagasPreenchida;
	}

	public boolean getGratuito() {
		return _gratuito;
	}

	public boolean isGratuito() {
		return _gratuito;
	}

	public void setGratuito(boolean gratuito) {
		_gratuito = gratuito;
	}

	public double getValor() {
		return _valor;
	}

	public void setValor(double valor) {
		_valor = valor;
	}

	public long getUserResponsavelId() {
		return _userResponsavelId;
	}

	public void setUserResponsavelId(long userResponsavelId) {
		_userResponsavelId = userResponsavelId;
	}

	public String getUserResponsavelNome() {
		return _userResponsavelNome;
	}

	public void setUserResponsavelNome(String userResponsavelNome) {
		_userResponsavelNome = userResponsavelNome;
	}

	public long getEventoId() {
		return _eventoId;
	}

	public void setEventoId(long eventoId) {
		_eventoId = eventoId;
	}

	public String getEventoNome() {
		return _eventoNome;
	}

	public void setEventoNome(String eventoNome) {
		_eventoNome = eventoNome;
	}

	public long getLocalId() {
		return _localId;
	}

	public void setLocalId(long localId) {
		_localId = localId;
	}

	public String getLocalNome() {
		return _localNome;
	}

	public void setLocalNome(String localNome) {
		_localNome = localNome;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
	}

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	private String _uuid;
	private long _eventoAgendaId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
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
	private long _localId;
	private String _localNome;
	private String _observacao;
	private double _versao;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _classNameId;
	private long _classPK;
}