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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.lapidarios.evento.service.http.LocalServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.evento.service.http.LocalServiceSoap
 * @generated
 */
public class LocalSoap implements Serializable {
	public static LocalSoap toSoapModel(Local model) {
		LocalSoap soapModel = new LocalSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLocalId(model.getLocalId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setEndLogradouro(model.getEndLogradouro());
		soapModel.setEndNumero(model.getEndNumero());
		soapModel.setEndComplemento(model.getEndComplemento());
		soapModel.setEndCep(model.getEndCep());
		soapModel.setEndBairro(model.getEndBairro());
		soapModel.setEndCidade(model.getEndCidade());
		soapModel.setEndUf(model.getEndUf());
		soapModel.setEndPais(model.getEndPais());
		soapModel.setPontoReferencia(model.getPontoReferencia());
		soapModel.setVersao(model.getVersao());

		return soapModel;
	}

	public static LocalSoap[] toSoapModels(Local[] models) {
		LocalSoap[] soapModels = new LocalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocalSoap[][] toSoapModels(Local[][] models) {
		LocalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocalSoap[] toSoapModels(List<Local> models) {
		List<LocalSoap> soapModels = new ArrayList<LocalSoap>(models.size());

		for (Local model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocalSoap[soapModels.size()]);
	}

	public LocalSoap() {
	}

	public long getPrimaryKey() {
		return _localId;
	}

	public void setPrimaryKey(long pk) {
		setLocalId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLocalId() {
		return _localId;
	}

	public void setLocalId(long localId) {
		_localId = localId;
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

	public String getEndLogradouro() {
		return _endLogradouro;
	}

	public void setEndLogradouro(String endLogradouro) {
		_endLogradouro = endLogradouro;
	}

	public String getEndNumero() {
		return _endNumero;
	}

	public void setEndNumero(String endNumero) {
		_endNumero = endNumero;
	}

	public String getEndComplemento() {
		return _endComplemento;
	}

	public void setEndComplemento(String endComplemento) {
		_endComplemento = endComplemento;
	}

	public String getEndCep() {
		return _endCep;
	}

	public void setEndCep(String endCep) {
		_endCep = endCep;
	}

	public String getEndBairro() {
		return _endBairro;
	}

	public void setEndBairro(String endBairro) {
		_endBairro = endBairro;
	}

	public String getEndCidade() {
		return _endCidade;
	}

	public void setEndCidade(String endCidade) {
		_endCidade = endCidade;
	}

	public String getEndUf() {
		return _endUf;
	}

	public void setEndUf(String endUf) {
		_endUf = endUf;
	}

	public String getEndPais() {
		return _endPais;
	}

	public void setEndPais(String endPais) {
		_endPais = endPais;
	}

	public String getPontoReferencia() {
		return _pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		_pontoReferencia = pontoReferencia;
	}

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	private String _uuid;
	private long _localId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _endLogradouro;
	private String _endNumero;
	private String _endComplemento;
	private String _endCep;
	private String _endBairro;
	private String _endCidade;
	private String _endUf;
	private String _endPais;
	private String _pontoReferencia;
	private double _versao;
}