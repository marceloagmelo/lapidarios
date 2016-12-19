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

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventoAgenda in entity cache.
 *
 * @author Marcelo Melo
 * @see EventoAgenda
 * @generated
 */
public class EventoAgendaCacheModel implements CacheModel<EventoAgenda>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventoAgendaId=");
		sb.append(eventoAgendaId);
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
		sb.append(", dataEvento=");
		sb.append(dataEvento);
		sb.append(", horaEvento=");
		sb.append(horaEvento);
		sb.append(", qtdeVagas=");
		sb.append(qtdeVagas);
		sb.append(", qtdeVagasPreenchida=");
		sb.append(qtdeVagasPreenchida);
		sb.append(", gratuito=");
		sb.append(gratuito);
		sb.append(", valor=");
		sb.append(valor);
		sb.append(", userResponsavelId=");
		sb.append(userResponsavelId);
		sb.append(", userResponsavelNome=");
		sb.append(userResponsavelNome);
		sb.append(", eventoId=");
		sb.append(eventoId);
		sb.append(", eventoNome=");
		sb.append(eventoNome);
		sb.append(", localId=");
		sb.append(localId);
		sb.append(", localNome=");
		sb.append(localNome);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append(", versao=");
		sb.append(versao);
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
	public EventoAgenda toEntityModel() {
		EventoAgendaImpl eventoAgendaImpl = new EventoAgendaImpl();

		if (uuid == null) {
			eventoAgendaImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setUuid(uuid);
		}

		eventoAgendaImpl.setEventoAgendaId(eventoAgendaId);
		eventoAgendaImpl.setCompanyId(companyId);
		eventoAgendaImpl.setGroupId(groupId);
		eventoAgendaImpl.setCreateUserId(createUserId);
		eventoAgendaImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			eventoAgendaImpl.setCreateDate(null);
		}
		else {
			eventoAgendaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventoAgendaImpl.setModifiedDate(null);
		}
		else {
			eventoAgendaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dataEvento == Long.MIN_VALUE) {
			eventoAgendaImpl.setDataEvento(null);
		}
		else {
			eventoAgendaImpl.setDataEvento(new Date(dataEvento));
		}

		if (horaEvento == null) {
			eventoAgendaImpl.setHoraEvento(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setHoraEvento(horaEvento);
		}

		eventoAgendaImpl.setQtdeVagas(qtdeVagas);
		eventoAgendaImpl.setQtdeVagasPreenchida(qtdeVagasPreenchida);
		eventoAgendaImpl.setGratuito(gratuito);
		eventoAgendaImpl.setValor(valor);
		eventoAgendaImpl.setUserResponsavelId(userResponsavelId);

		if (userResponsavelNome == null) {
			eventoAgendaImpl.setUserResponsavelNome(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setUserResponsavelNome(userResponsavelNome);
		}

		eventoAgendaImpl.setEventoId(eventoId);

		if (eventoNome == null) {
			eventoAgendaImpl.setEventoNome(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setEventoNome(eventoNome);
		}

		eventoAgendaImpl.setLocalId(localId);

		if (localNome == null) {
			eventoAgendaImpl.setLocalNome(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setLocalNome(localNome);
		}

		if (observacao == null) {
			eventoAgendaImpl.setObservacao(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setObservacao(observacao);
		}

		eventoAgendaImpl.setVersao(versao);
		eventoAgendaImpl.setStatus(status);
		eventoAgendaImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			eventoAgendaImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			eventoAgendaImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			eventoAgendaImpl.setStatusDate(null);
		}
		else {
			eventoAgendaImpl.setStatusDate(new Date(statusDate));
		}

		eventoAgendaImpl.setClassNameId(classNameId);
		eventoAgendaImpl.setClassPK(classPK);

		eventoAgendaImpl.resetOriginalValues();

		return eventoAgendaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		eventoAgendaId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dataEvento = objectInput.readLong();
		horaEvento = objectInput.readUTF();
		qtdeVagas = objectInput.readInt();
		qtdeVagasPreenchida = objectInput.readInt();
		gratuito = objectInput.readBoolean();
		valor = objectInput.readDouble();
		userResponsavelId = objectInput.readLong();
		userResponsavelNome = objectInput.readUTF();
		eventoId = objectInput.readLong();
		eventoNome = objectInput.readUTF();
		localId = objectInput.readLong();
		localNome = objectInput.readUTF();
		observacao = objectInput.readUTF();
		versao = objectInput.readDouble();
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

		objectOutput.writeLong(eventoAgendaId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dataEvento);

		if (horaEvento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(horaEvento);
		}

		objectOutput.writeInt(qtdeVagas);
		objectOutput.writeInt(qtdeVagasPreenchida);
		objectOutput.writeBoolean(gratuito);
		objectOutput.writeDouble(valor);
		objectOutput.writeLong(userResponsavelId);

		if (userResponsavelNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userResponsavelNome);
		}

		objectOutput.writeLong(eventoId);

		if (eventoNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventoNome);
		}

		objectOutput.writeLong(localId);

		if (localNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localNome);
		}

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}

		objectOutput.writeDouble(versao);
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
	public long eventoAgendaId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public long dataEvento;
	public String horaEvento;
	public int qtdeVagas;
	public int qtdeVagasPreenchida;
	public boolean gratuito;
	public double valor;
	public long userResponsavelId;
	public String userResponsavelNome;
	public long eventoId;
	public String eventoNome;
	public long localId;
	public String localNome;
	public String observacao;
	public double versao;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long classNameId;
	public long classPK;
}