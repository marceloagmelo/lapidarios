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

import br.com.prodevelopment.lapidarios.evento.model.Evento;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Evento in entity cache.
 *
 * @author Marcelo Melo
 * @see Evento
 * @generated
 */
public class EventoCacheModel implements CacheModel<Evento>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventoId=");
		sb.append(eventoId);
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
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", userResponsavelId=");
		sb.append(userResponsavelId);
		sb.append(", userResponsavelNome=");
		sb.append(userResponsavelNome);
		sb.append(", versao=");
		sb.append(versao);
		sb.append(", imagemId=");
		sb.append(imagemId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Evento toEntityModel() {
		EventoImpl eventoImpl = new EventoImpl();

		if (uuid == null) {
			eventoImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventoImpl.setUuid(uuid);
		}

		eventoImpl.setEventoId(eventoId);
		eventoImpl.setCompanyId(companyId);
		eventoImpl.setGroupId(groupId);
		eventoImpl.setCreateUserId(createUserId);
		eventoImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			eventoImpl.setCreateDate(null);
		}
		else {
			eventoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventoImpl.setModifiedDate(null);
		}
		else {
			eventoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			eventoImpl.setNome(StringPool.BLANK);
		}
		else {
			eventoImpl.setNome(nome);
		}

		if (descricao == null) {
			eventoImpl.setDescricao(StringPool.BLANK);
		}
		else {
			eventoImpl.setDescricao(descricao);
		}

		eventoImpl.setUserResponsavelId(userResponsavelId);

		if (userResponsavelNome == null) {
			eventoImpl.setUserResponsavelNome(StringPool.BLANK);
		}
		else {
			eventoImpl.setUserResponsavelNome(userResponsavelNome);
		}

		eventoImpl.setVersao(versao);
		eventoImpl.setImagemId(imagemId);
		eventoImpl.setArticleId(articleId);

		eventoImpl.resetOriginalValues();

		return eventoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		eventoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descricao = objectInput.readUTF();
		userResponsavelId = objectInput.readLong();
		userResponsavelNome = objectInput.readUTF();
		versao = objectInput.readDouble();
		imagemId = objectInput.readLong();
		articleId = objectInput.readLong();
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

		objectOutput.writeLong(eventoId);
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

		if (descricao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descricao);
		}

		objectOutput.writeLong(userResponsavelId);

		if (userResponsavelNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userResponsavelNome);
		}

		objectOutput.writeDouble(versao);
		objectOutput.writeLong(imagemId);
		objectOutput.writeLong(articleId);
	}

	public String uuid;
	public long eventoId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descricao;
	public long userResponsavelId;
	public String userResponsavelNome;
	public double versao;
	public long imagemId;
	public long articleId;
}