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

package br.com.prodevelopment.lapidarios.loja.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.lapidarios.loja.service.http.LojaServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.lapidarios.loja.service.http.LojaServiceSoap
 * @generated
 */
public class LojaSoap implements Serializable {
	public static LojaSoap toSoapModel(Loja model) {
		LojaSoap soapModel = new LojaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLojaId(model.getLojaId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRazaoSocial(model.getRazaoSocial());
		soapModel.setNomeFantasia(model.getNomeFantasia());
		soapModel.setObservacao(model.getObservacao());
		soapModel.setCnpj(model.getCnpj());
		soapModel.setEndLogradouro(model.getEndLogradouro());
		soapModel.setEndNumero(model.getEndNumero());
		soapModel.setEndComplemento(model.getEndComplemento());
		soapModel.setEndCep(model.getEndCep());
		soapModel.setEndBairro(model.getEndBairro());
		soapModel.setEndCidade(model.getEndCidade());
		soapModel.setEndUf(model.getEndUf());
		soapModel.setEndPais(model.getEndPais());
		soapModel.setVersao(model.getVersao());
		soapModel.setOrdemIndicada(model.getOrdemIndicada());
		soapModel.setOrdemIndicadaAtual(model.getOrdemIndicadaAtual());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static LojaSoap[] toSoapModels(Loja[] models) {
		LojaSoap[] soapModels = new LojaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LojaSoap[][] toSoapModels(Loja[][] models) {
		LojaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LojaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LojaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LojaSoap[] toSoapModels(List<Loja> models) {
		List<LojaSoap> soapModels = new ArrayList<LojaSoap>(models.size());

		for (Loja model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LojaSoap[soapModels.size()]);
	}

	public LojaSoap() {
	}

	public long getPrimaryKey() {
		return _lojaId;
	}

	public void setPrimaryKey(long pk) {
		setLojaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLojaId() {
		return _lojaId;
	}

	public void setLojaId(long lojaId) {
		_lojaId = lojaId;
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

	public String getRazaoSocial() {
		return _razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		_razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return _nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		_nomeFantasia = nomeFantasia;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
	}

	public String getCnpj() {
		return _cnpj;
	}

	public void setCnpj(String cnpj) {
		_cnpj = cnpj;
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

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	public int getOrdemIndicada() {
		return _ordemIndicada;
	}

	public void setOrdemIndicada(int ordemIndicada) {
		_ordemIndicada = ordemIndicada;
	}

	public boolean getOrdemIndicadaAtual() {
		return _ordemIndicadaAtual;
	}

	public boolean isOrdemIndicadaAtual() {
		return _ordemIndicadaAtual;
	}

	public void setOrdemIndicadaAtual(boolean ordemIndicadaAtual) {
		_ordemIndicadaAtual = ordemIndicadaAtual;
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
	private long _lojaId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _razaoSocial;
	private String _nomeFantasia;
	private String _observacao;
	private String _cnpj;
	private String _endLogradouro;
	private String _endNumero;
	private String _endComplemento;
	private String _endCep;
	private String _endBairro;
	private String _endCidade;
	private String _endUf;
	private String _endPais;
	private double _versao;
	private int _ordemIndicada;
	private boolean _ordemIndicadaAtual;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _classNameId;
	private long _classPK;
}