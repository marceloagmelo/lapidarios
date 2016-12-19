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

package br.com.prodevelopment.lapidarios.evento.model.impl;

import br.com.prodevelopment.lapidarios.evento.model.Local;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Local in entity cache.
 *
 * @author Marcelo Melo
 * @see Local
 * @generated
 */
public class LocalCacheModel implements CacheModel<Local>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", localId=");
		sb.append(localId);
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
		sb.append(", nome=");
		sb.append(nome);
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
		sb.append(", pontoReferencia=");
		sb.append(pontoReferencia);
		sb.append(", versao=");
		sb.append(versao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Local toEntityModel() {
		LocalImpl localImpl = new LocalImpl();

		if (uuid == null) {
			localImpl.setUuid(StringPool.BLANK);
		}
		else {
			localImpl.setUuid(uuid);
		}

		localImpl.setLocalId(localId);
		localImpl.setCompanyId(companyId);
		localImpl.setGroupId(groupId);
		localImpl.setCreateUserId(createUserId);
		localImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			localImpl.setCreateDate(null);
		}
		else {
			localImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			localImpl.setModifiedDate(null);
		}
		else {
			localImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			localImpl.setNome(StringPool.BLANK);
		}
		else {
			localImpl.setNome(nome);
		}

		if (endLogradouro == null) {
			localImpl.setEndLogradouro(StringPool.BLANK);
		}
		else {
			localImpl.setEndLogradouro(endLogradouro);
		}

		if (endNumero == null) {
			localImpl.setEndNumero(StringPool.BLANK);
		}
		else {
			localImpl.setEndNumero(endNumero);
		}

		if (endComplemento == null) {
			localImpl.setEndComplemento(StringPool.BLANK);
		}
		else {
			localImpl.setEndComplemento(endComplemento);
		}

		if (endCep == null) {
			localImpl.setEndCep(StringPool.BLANK);
		}
		else {
			localImpl.setEndCep(endCep);
		}

		if (endBairro == null) {
			localImpl.setEndBairro(StringPool.BLANK);
		}
		else {
			localImpl.setEndBairro(endBairro);
		}

		if (endCidade == null) {
			localImpl.setEndCidade(StringPool.BLANK);
		}
		else {
			localImpl.setEndCidade(endCidade);
		}

		if (endUf == null) {
			localImpl.setEndUf(StringPool.BLANK);
		}
		else {
			localImpl.setEndUf(endUf);
		}

		if (endPais == null) {
			localImpl.setEndPais(StringPool.BLANK);
		}
		else {
			localImpl.setEndPais(endPais);
		}

		if (pontoReferencia == null) {
			localImpl.setPontoReferencia(StringPool.BLANK);
		}
		else {
			localImpl.setPontoReferencia(pontoReferencia);
		}

		localImpl.setVersao(versao);

		localImpl.resetOriginalValues();

		return localImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		localId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		endLogradouro = objectInput.readUTF();
		endNumero = objectInput.readUTF();
		endComplemento = objectInput.readUTF();
		endCep = objectInput.readUTF();
		endBairro = objectInput.readUTF();
		endCidade = objectInput.readUTF();
		endUf = objectInput.readUTF();
		endPais = objectInput.readUTF();
		pontoReferencia = objectInput.readUTF();
		versao = objectInput.readDouble();
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

		objectOutput.writeLong(localId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
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

		if (pontoReferencia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pontoReferencia);
		}

		objectOutput.writeDouble(versao);
	}

	public String uuid;
	public long localId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String endLogradouro;
	public String endNumero;
	public String endComplemento;
	public String endCep;
	public String endBairro;
	public String endCidade;
	public String endUf;
	public String endPais;
	public String pontoReferencia;
	public double versao;
}