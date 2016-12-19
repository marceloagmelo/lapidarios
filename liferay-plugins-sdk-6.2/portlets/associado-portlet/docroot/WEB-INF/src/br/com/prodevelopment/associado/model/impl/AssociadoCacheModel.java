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

package br.com.prodevelopment.associado.model.impl;

import br.com.prodevelopment.associado.model.Associado;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Associado in entity cache.
 *
 * @author Marcelo Melo
 * @see Associado
 * @generated
 */
public class AssociadoCacheModel implements CacheModel<Associado>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", associadoId=");
		sb.append(associadoId);
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
		sb.append(", rgInscricaoMun=");
		sb.append(rgInscricaoMun);
		sb.append(", rgOrgaoEmissor=");
		sb.append(rgOrgaoEmissor);
		sb.append(", rgDataEmissao=");
		sb.append(rgDataEmissao);
		sb.append(", tipoPessoa=");
		sb.append(tipoPessoa);
		sb.append(", cpfCnpj=");
		sb.append(cpfCnpj);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", estadoCivil=");
		sb.append(estadoCivil);
		sb.append(", dataNascimento=");
		sb.append(dataNascimento);
		sb.append(", endComLogradouro=");
		sb.append(endComLogradouro);
		sb.append(", endComNumero=");
		sb.append(endComNumero);
		sb.append(", endComComplemento=");
		sb.append(endComComplemento);
		sb.append(", endComCep=");
		sb.append(endComCep);
		sb.append(", endComBairro=");
		sb.append(endComBairro);
		sb.append(", endComCidade=");
		sb.append(endComCidade);
		sb.append(", endComUf=");
		sb.append(endComUf);
		sb.append(", endComPais=");
		sb.append(endComPais);
		sb.append(", endResLogradouro=");
		sb.append(endResLogradouro);
		sb.append(", endResNumero=");
		sb.append(endResNumero);
		sb.append(", endResComplemento=");
		sb.append(endResComplemento);
		sb.append(", endResCep=");
		sb.append(endResCep);
		sb.append(", endResBairro=");
		sb.append(endResBairro);
		sb.append(", endResCidade=");
		sb.append(endResCidade);
		sb.append(", endResUf=");
		sb.append(endResUf);
		sb.append(", endResPais=");
		sb.append(endResPais);
		sb.append(", telComDdd=");
		sb.append(telComDdd);
		sb.append(", versao=");
		sb.append(versao);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append(", idPolishop=");
		sb.append(idPolishop);
		sb.append(", idLojaIndicada=");
		sb.append(idLojaIndicada);
		sb.append(", idPatrocinador=");
		sb.append(idPatrocinador);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Associado toEntityModel() {
		AssociadoImpl associadoImpl = new AssociadoImpl();

		if (uuid == null) {
			associadoImpl.setUuid(StringPool.BLANK);
		}
		else {
			associadoImpl.setUuid(uuid);
		}

		associadoImpl.setAssociadoId(associadoId);
		associadoImpl.setCompanyId(companyId);
		associadoImpl.setGroupId(groupId);
		associadoImpl.setCreateUserId(createUserId);
		associadoImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			associadoImpl.setCreateDate(null);
		}
		else {
			associadoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			associadoImpl.setModifiedDate(null);
		}
		else {
			associadoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			associadoImpl.setNome(StringPool.BLANK);
		}
		else {
			associadoImpl.setNome(nome);
		}

		if (rgInscricaoMun == null) {
			associadoImpl.setRgInscricaoMun(StringPool.BLANK);
		}
		else {
			associadoImpl.setRgInscricaoMun(rgInscricaoMun);
		}

		if (rgOrgaoEmissor == null) {
			associadoImpl.setRgOrgaoEmissor(StringPool.BLANK);
		}
		else {
			associadoImpl.setRgOrgaoEmissor(rgOrgaoEmissor);
		}

		if (rgDataEmissao == Long.MIN_VALUE) {
			associadoImpl.setRgDataEmissao(null);
		}
		else {
			associadoImpl.setRgDataEmissao(new Date(rgDataEmissao));
		}

		if (tipoPessoa == null) {
			associadoImpl.setTipoPessoa(StringPool.BLANK);
		}
		else {
			associadoImpl.setTipoPessoa(tipoPessoa);
		}

		if (cpfCnpj == null) {
			associadoImpl.setCpfCnpj(StringPool.BLANK);
		}
		else {
			associadoImpl.setCpfCnpj(cpfCnpj);
		}

		if (sexo == null) {
			associadoImpl.setSexo(StringPool.BLANK);
		}
		else {
			associadoImpl.setSexo(sexo);
		}

		if (estadoCivil == null) {
			associadoImpl.setEstadoCivil(StringPool.BLANK);
		}
		else {
			associadoImpl.setEstadoCivil(estadoCivil);
		}

		if (dataNascimento == Long.MIN_VALUE) {
			associadoImpl.setDataNascimento(null);
		}
		else {
			associadoImpl.setDataNascimento(new Date(dataNascimento));
		}

		if (endComLogradouro == null) {
			associadoImpl.setEndComLogradouro(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComLogradouro(endComLogradouro);
		}

		if (endComNumero == null) {
			associadoImpl.setEndComNumero(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComNumero(endComNumero);
		}

		if (endComComplemento == null) {
			associadoImpl.setEndComComplemento(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComComplemento(endComComplemento);
		}

		if (endComCep == null) {
			associadoImpl.setEndComCep(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComCep(endComCep);
		}

		if (endComBairro == null) {
			associadoImpl.setEndComBairro(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComBairro(endComBairro);
		}

		if (endComCidade == null) {
			associadoImpl.setEndComCidade(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComCidade(endComCidade);
		}

		if (endComUf == null) {
			associadoImpl.setEndComUf(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComUf(endComUf);
		}

		if (endComPais == null) {
			associadoImpl.setEndComPais(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndComPais(endComPais);
		}

		if (endResLogradouro == null) {
			associadoImpl.setEndResLogradouro(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResLogradouro(endResLogradouro);
		}

		if (endResNumero == null) {
			associadoImpl.setEndResNumero(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResNumero(endResNumero);
		}

		if (endResComplemento == null) {
			associadoImpl.setEndResComplemento(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResComplemento(endResComplemento);
		}

		if (endResCep == null) {
			associadoImpl.setEndResCep(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResCep(endResCep);
		}

		if (endResBairro == null) {
			associadoImpl.setEndResBairro(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResBairro(endResBairro);
		}

		if (endResCidade == null) {
			associadoImpl.setEndResCidade(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResCidade(endResCidade);
		}

		if (endResUf == null) {
			associadoImpl.setEndResUf(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResUf(endResUf);
		}

		if (endResPais == null) {
			associadoImpl.setEndResPais(StringPool.BLANK);
		}
		else {
			associadoImpl.setEndResPais(endResPais);
		}

		if (telComDdd == null) {
			associadoImpl.setTelComDdd(StringPool.BLANK);
		}
		else {
			associadoImpl.setTelComDdd(telComDdd);
		}

		associadoImpl.setVersao(versao);
		associadoImpl.setUserId(userId);

		if (observacao == null) {
			associadoImpl.setObservacao(StringPool.BLANK);
		}
		else {
			associadoImpl.setObservacao(observacao);
		}

		if (idPolishop == null) {
			associadoImpl.setIdPolishop(StringPool.BLANK);
		}
		else {
			associadoImpl.setIdPolishop(idPolishop);
		}

		if (idLojaIndicada == null) {
			associadoImpl.setIdLojaIndicada(StringPool.BLANK);
		}
		else {
			associadoImpl.setIdLojaIndicada(idLojaIndicada);
		}

		if (idPatrocinador == null) {
			associadoImpl.setIdPatrocinador(StringPool.BLANK);
		}
		else {
			associadoImpl.setIdPatrocinador(idPatrocinador);
		}

		associadoImpl.resetOriginalValues();

		return associadoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		associadoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		rgInscricaoMun = objectInput.readUTF();
		rgOrgaoEmissor = objectInput.readUTF();
		rgDataEmissao = objectInput.readLong();
		tipoPessoa = objectInput.readUTF();
		cpfCnpj = objectInput.readUTF();
		sexo = objectInput.readUTF();
		estadoCivil = objectInput.readUTF();
		dataNascimento = objectInput.readLong();
		endComLogradouro = objectInput.readUTF();
		endComNumero = objectInput.readUTF();
		endComComplemento = objectInput.readUTF();
		endComCep = objectInput.readUTF();
		endComBairro = objectInput.readUTF();
		endComCidade = objectInput.readUTF();
		endComUf = objectInput.readUTF();
		endComPais = objectInput.readUTF();
		endResLogradouro = objectInput.readUTF();
		endResNumero = objectInput.readUTF();
		endResComplemento = objectInput.readUTF();
		endResCep = objectInput.readUTF();
		endResBairro = objectInput.readUTF();
		endResCidade = objectInput.readUTF();
		endResUf = objectInput.readUTF();
		endResPais = objectInput.readUTF();
		telComDdd = objectInput.readUTF();
		versao = objectInput.readDouble();
		userId = objectInput.readLong();
		observacao = objectInput.readUTF();
		idPolishop = objectInput.readUTF();
		idLojaIndicada = objectInput.readUTF();
		idPatrocinador = objectInput.readUTF();
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

		objectOutput.writeLong(associadoId);
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

		if (rgInscricaoMun == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rgInscricaoMun);
		}

		if (rgOrgaoEmissor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rgOrgaoEmissor);
		}

		objectOutput.writeLong(rgDataEmissao);

		if (tipoPessoa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoPessoa);
		}

		if (cpfCnpj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cpfCnpj);
		}

		if (sexo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sexo);
		}

		if (estadoCivil == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(estadoCivil);
		}

		objectOutput.writeLong(dataNascimento);

		if (endComLogradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComLogradouro);
		}

		if (endComNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComNumero);
		}

		if (endComComplemento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComComplemento);
		}

		if (endComCep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComCep);
		}

		if (endComBairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComBairro);
		}

		if (endComCidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComCidade);
		}

		if (endComUf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComUf);
		}

		if (endComPais == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComPais);
		}

		if (endResLogradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResLogradouro);
		}

		if (endResNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResNumero);
		}

		if (endResComplemento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResComplemento);
		}

		if (endResCep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResCep);
		}

		if (endResBairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResBairro);
		}

		if (endResCidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResCidade);
		}

		if (endResUf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResUf);
		}

		if (endResPais == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResPais);
		}

		if (telComDdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telComDdd);
		}

		objectOutput.writeDouble(versao);
		objectOutput.writeLong(userId);

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}

		if (idPolishop == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idPolishop);
		}

		if (idLojaIndicada == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idLojaIndicada);
		}

		if (idPatrocinador == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idPatrocinador);
		}
	}

	public String uuid;
	public long associadoId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String rgInscricaoMun;
	public String rgOrgaoEmissor;
	public long rgDataEmissao;
	public String tipoPessoa;
	public String cpfCnpj;
	public String sexo;
	public String estadoCivil;
	public long dataNascimento;
	public String endComLogradouro;
	public String endComNumero;
	public String endComComplemento;
	public String endComCep;
	public String endComBairro;
	public String endComCidade;
	public String endComUf;
	public String endComPais;
	public String endResLogradouro;
	public String endResNumero;
	public String endResComplemento;
	public String endResCep;
	public String endResBairro;
	public String endResCidade;
	public String endResUf;
	public String endResPais;
	public String telComDdd;
	public double versao;
	public long userId;
	public String observacao;
	public String idPolishop;
	public String idLojaIndicada;
	public String idPatrocinador;
}