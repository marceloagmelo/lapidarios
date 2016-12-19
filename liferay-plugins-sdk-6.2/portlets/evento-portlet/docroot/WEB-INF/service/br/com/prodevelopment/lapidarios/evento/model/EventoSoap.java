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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.lapidarios.evento.service.http.EventoServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.http.EventoServiceSoap
 * @generated
 */
public class EventoSoap implements Serializable {
	public static EventoSoap toSoapModel(Evento model) {
		EventoSoap soapModel = new EventoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventoId(model.getEventoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setDescricao(model.getDescricao());
		soapModel.setUserResponsavelId(model.getUserResponsavelId());
		soapModel.setUserResponsavelNome(model.getUserResponsavelNome());
		soapModel.setVersao(model.getVersao());
		soapModel.setImagemId(model.getImagemId());
		soapModel.setArticleId(model.getArticleId());

		return soapModel;
	}

	public static EventoSoap[] toSoapModels(Evento[] models) {
		EventoSoap[] soapModels = new EventoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventoSoap[][] toSoapModels(Evento[][] models) {
		EventoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventoSoap[] toSoapModels(List<Evento> models) {
		List<EventoSoap> soapModels = new ArrayList<EventoSoap>(models.size());

		for (Evento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventoSoap[soapModels.size()]);
	}

	public EventoSoap() {
	}

	public long getPrimaryKey() {
		return _eventoId;
	}

	public void setPrimaryKey(long pk) {
		setEventoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventoId() {
		return _eventoId;
	}

	public void setEventoId(long eventoId) {
		_eventoId = eventoId;
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

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getDescricao() {
		return _descricao;
	}

	public void setDescricao(String descricao) {
		_descricao = descricao;
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

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	public long getImagemId() {
		return _imagemId;
	}

	public void setImagemId(long imagemId) {
		_imagemId = imagemId;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	private String _uuid;
	private long _eventoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _descricao;
	private long _userResponsavelId;
	private String _userResponsavelNome;
	private double _versao;
	private long _imagemId;
	private long _articleId;
}