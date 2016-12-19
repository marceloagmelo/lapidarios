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

package br.com.prodevelopment.lapidarios.lojaindicada.model.impl;

import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LojaIndicada in entity cache.
 *
 * @author Marcelo Melo
 * @see LojaIndicada
 * @generated
 */
public class LojaIndicadaCacheModel implements CacheModel<LojaIndicada>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", lojaIndicadaId=");
		sb.append(lojaIndicadaId);
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
		sb.append(", idLoja=");
		sb.append(idLoja);
		sb.append(", lojaIndicadaAtual=");
		sb.append(lojaIndicadaAtual);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LojaIndicada toEntityModel() {
		LojaIndicadaImpl lojaIndicadaImpl = new LojaIndicadaImpl();

		if (uuid == null) {
			lojaIndicadaImpl.setUuid(StringPool.BLANK);
		}
		else {
			lojaIndicadaImpl.setUuid(uuid);
		}

		lojaIndicadaImpl.setLojaIndicadaId(lojaIndicadaId);
		lojaIndicadaImpl.setCompanyId(companyId);
		lojaIndicadaImpl.setGroupId(groupId);
		lojaIndicadaImpl.setCreateUserId(createUserId);
		lojaIndicadaImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			lojaIndicadaImpl.setCreateDate(null);
		}
		else {
			lojaIndicadaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lojaIndicadaImpl.setModifiedDate(null);
		}
		else {
			lojaIndicadaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (idLoja == null) {
			lojaIndicadaImpl.setIdLoja(StringPool.BLANK);
		}
		else {
			lojaIndicadaImpl.setIdLoja(idLoja);
		}

		lojaIndicadaImpl.setLojaIndicadaAtual(lojaIndicadaAtual);

		lojaIndicadaImpl.resetOriginalValues();

		return lojaIndicadaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		lojaIndicadaId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		idLoja = objectInput.readUTF();
		lojaIndicadaAtual = objectInput.readBoolean();
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

		objectOutput.writeLong(lojaIndicadaId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (idLoja == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idLoja);
		}

		objectOutput.writeBoolean(lojaIndicadaAtual);
	}

	public String uuid;
	public long lojaIndicadaId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String idLoja;
	public Boolean lojaIndicadaAtual;
}