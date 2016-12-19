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

import br.com.prodevelopment.lapidarios.evento.model.EventoInscricao;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventoInscricao in entity cache.
 *
 * @author Marcelo Melo
 * @see EventoInscricao
 * @generated
 */
public class EventoInscricaoCacheModel implements CacheModel<EventoInscricao>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventoInscricaoId=");
		sb.append(eventoInscricaoId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", eventoAgendaId=");
		sb.append(eventoAgendaId);
		sb.append(", eventoId=");
		sb.append(eventoId);
		sb.append(", userNome=");
		sb.append(userNome);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventoInscricao toEntityModel() {
		EventoInscricaoImpl eventoInscricaoImpl = new EventoInscricaoImpl();

		if (uuid == null) {
			eventoInscricaoImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventoInscricaoImpl.setUuid(uuid);
		}

		eventoInscricaoImpl.setEventoInscricaoId(eventoInscricaoId);
		eventoInscricaoImpl.setCompanyId(companyId);
		eventoInscricaoImpl.setGroupId(groupId);
		eventoInscricaoImpl.setCreateUserId(createUserId);

		if (createDate == Long.MIN_VALUE) {
			eventoInscricaoImpl.setCreateDate(null);
		}
		else {
			eventoInscricaoImpl.setCreateDate(new Date(createDate));
		}

		eventoInscricaoImpl.setEventoAgendaId(eventoAgendaId);
		eventoInscricaoImpl.setEventoId(eventoId);

		if (userNome == null) {
			eventoInscricaoImpl.setUserNome(StringPool.BLANK);
		}
		else {
			eventoInscricaoImpl.setUserNome(userNome);
		}

		eventoInscricaoImpl.resetOriginalValues();

		return eventoInscricaoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		eventoInscricaoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		eventoAgendaId = objectInput.readLong();
		eventoId = objectInput.readLong();
		userNome = objectInput.readUTF();
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

		objectOutput.writeLong(eventoInscricaoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(eventoAgendaId);
		objectOutput.writeLong(eventoId);

		if (userNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userNome);
		}
	}

	public String uuid;
	public long eventoInscricaoId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long createDate;
	public long eventoAgendaId;
	public long eventoId;
	public String userNome;
}