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

package br.com.prodevelopment.lapidarios.loja.model.impl;

import br.com.prodevelopment.lapidarios.loja.model.Loja;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Loja in entity cache.
 *
 * @author Marcelo Melo
 * @see Loja
 * @generated
 */
public class LojaCacheModel implements CacheModel<Loja>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", lojaId=");
		sb.append(lojaId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", razaoSocial=");
		sb.append(razaoSocial);
		sb.append(", nomeFantasia=");
		sb.append(nomeFantasia);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append(", cnpj=");
		sb.append(cnpj);
		sb.append(", endLogradouro=");
		sb.append(endLogradouro);
		sb.append(", endNumero=");
		sb.append(endNumero);
		sb.append(", endComplemento=");
		sb.append(endComplemento);
		sb.append(", endCep=");
		sb.append(endCep);
		sb.append(", endBairro=");
		sb.append(endBairro);
		sb.append(", endCidade=");
		sb.append(endCidade);
		sb.append(", endUf=");
		sb.append(endUf);
		sb.append(", endPais=");
		sb.append(endPais);
		sb.append(", versao=");
		sb.append(versao);
		sb.append(", ordemIndicada=");
		sb.append(ordemIndicada);
		sb.append(", ordemIndicadaAtual=");
		sb.append(ordemIndicadaAtual);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Loja toEntityModel() {
		LojaImpl lojaImpl = new LojaImpl();

		if (uuid == null) {
			lojaImpl.setUuid(StringPool.BLANK);
		}
		else {
			lojaImpl.setUuid(uuid);
		}

		lojaImpl.setLojaId(lojaId);
		lojaImpl.setCompanyId(companyId);
		lojaImpl.setGroupId(groupId);
		lojaImpl.setCreateUserId(createUserId);
		lojaImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			lojaImpl.setCreateDate(null);
		}
		else {
			lojaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lojaImpl.setModifiedDate(null);
		}
		else {
			lojaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (razaoSocial == null) {
			lojaImpl.setRazaoSocial(StringPool.BLANK);
		}
		else {
			lojaImpl.setRazaoSocial(razaoSocial);
		}

		if (nomeFantasia == null) {
			lojaImpl.setNomeFantasia(StringPool.BLANK);
		}
		else {
			lojaImpl.setNomeFantasia(nomeFantasia);
		}

		if (observacao == null) {
			lojaImpl.setObservacao(StringPool.BLANK);
		}
		else {
			lojaImpl.setObservacao(observacao);
		}

		if (cnpj == null) {
			lojaImpl.setCnpj(StringPool.BLANK);
		}
		else {
			lojaImpl.setCnpj(cnpj);
		}

		if (endLogradouro == null) {
			lojaImpl.setEndLogradouro(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndLogradouro(endLogradouro);
		}

		if (endNumero == null) {
			lojaImpl.setEndNumero(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndNumero(endNumero);
		}

		if (endComplemento == null) {
			lojaImpl.setEndComplemento(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndComplemento(endComplemento);
		}

		if (endCep == null) {
			lojaImpl.setEndCep(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndCep(endCep);
		}

		if (endBairro == null) {
			lojaImpl.setEndBairro(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndBairro(endBairro);
		}

		if (endCidade == null) {
			lojaImpl.setEndCidade(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndCidade(endCidade);
		}

		if (endUf == null) {
			lojaImpl.setEndUf(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndUf(endUf);
		}

		if (endPais == null) {
			lojaImpl.setEndPais(StringPool.BLANK);
		}
		else {
			lojaImpl.setEndPais(endPais);
		}

		lojaImpl.setVersao(versao);
		lojaImpl.setOrdemIndicada(ordemIndicada);
		lojaImpl.setOrdemIndicadaAtual(ordemIndicadaAtual);
		lojaImpl.setStatus(status);
		lojaImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			lojaImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			lojaImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			lojaImpl.setStatusDate(null);
		}
		else {
			lojaImpl.setStatusDate(new Date(statusDate));
		}

		lojaImpl.setClassNameId(classNameId);
		lojaImpl.setClassPK(classPK);

		lojaImpl.resetOriginalValues();

		return lojaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		lojaId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		razaoSocial = objectInput.readUTF();
		nomeFantasia = objectInput.readUTF();
		observacao = objectInput.readUTF();
		cnpj = objectInput.readUTF();
		endLogradouro = objectInput.readUTF();
		endNumero = objectInput.readUTF();
		endComplemento = objectInput.readUTF();
		endCep = objectInput.readUTF();
		endBairro = objectInput.readUTF();
		endCidade = objectInput.readUTF();
		endUf = objectInput.readUTF();
		endPais = objectInput.readUTF();
		versao = objectInput.readDouble();
		ordemIndicada = objectInput.readInt();
		ordemIndicadaAtual = objectInput.readBoolean();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(lojaId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (razaoSocial == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(razaoSocial);
		}

		if (nomeFantasia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeFantasia);
		}

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}

		if (cnpj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cnpj);
		}

		if (endLogradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endLogradouro);
		}

		if (endNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endNumero);
		}

		if (endComplemento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComplemento);
		}

		if (endCep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endCep);
		}

		if (endBairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endBairro);
		}

		if (endCidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endCidade);
		}

		if (endUf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endUf);
		}

		if (endPais == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endPais);
		}

		objectOutput.writeDouble(versao);
		objectOutput.writeInt(ordemIndicada);
		objectOutput.writeBoolean(ordemIndicadaAtual);
		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
	}

	public String uuid;
	public long lojaId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String razaoSocial;
	public String nomeFantasia;
	public String observacao;
	public String cnpj;
	public String endLogradouro;
	public String endNumero;
	public String endComplemento;
	public String endCep;
	public String endBairro;
	public String endCidade;
	public String endUf;
	public String endPais;
	public double versao;
	public int ordemIndicada;
	public boolean ordemIndicadaAtual;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long classNameId;
	public long classPK;
}