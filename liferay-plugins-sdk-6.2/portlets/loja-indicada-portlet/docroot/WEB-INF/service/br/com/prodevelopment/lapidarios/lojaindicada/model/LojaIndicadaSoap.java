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

package br.com.prodevelopment.lapidarios.lojaindicada.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.lapidarios.lojaindicada.service.http.LojaIndicadaServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.lojaindicada.service.http.LojaIndicadaServiceSoap
 * @generated
 */
public class LojaIndicadaSoap implements Serializable {
	public static LojaIndicadaSoap toSoapModel(LojaIndicada model) {
		LojaIndicadaSoap soapModel = new LojaIndicadaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLojaIndicadaId(model.getLojaIndicadaId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIdLoja(model.getIdLoja());
		soapModel.setLojaIndicadaAtual(model.getLojaIndicadaAtual());

		return soapModel;
	}

	public static LojaIndicadaSoap[] toSoapModels(LojaIndicada[] models) {
		LojaIndicadaSoap[] soapModels = new LojaIndicadaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LojaIndicadaSoap[][] toSoapModels(LojaIndicada[][] models) {
		LojaIndicadaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LojaIndicadaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LojaIndicadaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LojaIndicadaSoap[] toSoapModels(List<LojaIndicada> models) {
		List<LojaIndicadaSoap> soapModels = new ArrayList<LojaIndicadaSoap>(models.size());

		for (LojaIndicada model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LojaIndicadaSoap[soapModels.size()]);
	}

	public LojaIndicadaSoap() {
	}

	public long getPrimaryKey() {
		return _lojaIndicadaId;
	}

	public void setPrimaryKey(long pk) {
		setLojaIndicadaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLojaIndicadaId() {
		return _lojaIndicadaId;
	}

	public void setLojaIndicadaId(long lojaIndicadaId) {
		_lojaIndicadaId = lojaIndicadaId;
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

	public String getIdLoja() {
		return _idLoja;
	}

	public void setIdLoja(String idLoja) {
		_idLoja = idLoja;
	}

	public Boolean getLojaIndicadaAtual() {
		return _lojaIndicadaAtual;
	}

	public void setLojaIndicadaAtual(Boolean lojaIndicadaAtual) {
		_lojaIndicadaAtual = lojaIndicadaAtual;
	}

	private String _uuid;
	private long _lojaIndicadaId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _idLoja;
	private Boolean _lojaIndicadaAtual;
}