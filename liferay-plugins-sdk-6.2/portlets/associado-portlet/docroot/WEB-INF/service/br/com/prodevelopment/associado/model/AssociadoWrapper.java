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

package br.com.prodevelopment.associado.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Associado}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Associado
 * @generated
 */
public class AssociadoWrapper implements Associado, ModelWrapper<Associado> {
	public AssociadoWrapper(Associado associado) {
		_associado = associado;
	}

	@Override
	public Class<?> getModelClass() {
		return Associado.class;
	}

	@Override
	public String getModelClassName() {
		return Associado.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("associadoId", getAssociadoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("rgInscricaoMun", getRgInscricaoMun());
		attributes.put("rgOrgaoEmissor", getRgOrgaoEmissor());
		attributes.put("rgDataEmissao", getRgDataEmissao());
		attributes.put("tipoPessoa", getTipoPessoa());
		attributes.put("cpfCnpj", getCpfCnpj());
		attributes.put("sexo", getSexo());
		attributes.put("estadoCivil", getEstadoCivil());
		attributes.put("dataNascimento", getDataNascimento());
		attributes.put("endComLogradouro", getEndComLogradouro());
		attributes.put("endComNumero", getEndComNumero());
		attributes.put("endComComplemento", getEndComComplemento());
		attributes.put("endComCep", getEndComCep());
		attributes.put("endComBairro", getEndComBairro());
		attributes.put("endComCidade", getEndComCidade());
		attributes.put("endComUf", getEndComUf());
		attributes.put("endComPais", getEndComPais());
		attributes.put("endResLogradouro", getEndResLogradouro());
		attributes.put("endResNumero", getEndResNumero());
		attributes.put("endResComplemento", getEndResComplemento());
		attributes.put("endResCep", getEndResCep());
		attributes.put("endResBairro", getEndResBairro());
		attributes.put("endResCidade", getEndResCidade());
		attributes.put("endResUf", getEndResUf());
		attributes.put("endResPais", getEndResPais());
		attributes.put("telComDdd", getTelComDdd());
		attributes.put("versao", getVersao());
		attributes.put("userId", getUserId());
		attributes.put("observacao", getObservacao());
		attributes.put("idPolishop", getIdPolishop());
		attributes.put("idLojaIndicada", getIdLojaIndicada());
		attributes.put("idPatrocinador", getIdPatrocinador());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long associadoId = (Long)attributes.get("associadoId");

		if (associadoId != null) {
			setAssociadoId(associadoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String rgInscricaoMun = (String)attributes.get("rgInscricaoMun");

		if (rgInscricaoMun != null) {
			setRgInscricaoMun(rgInscricaoMun);
		}

		String rgOrgaoEmissor = (String)attributes.get("rgOrgaoEmissor");

		if (rgOrgaoEmissor != null) {
			setRgOrgaoEmissor(rgOrgaoEmissor);
		}

		Date rgDataEmissao = (Date)attributes.get("rgDataEmissao");

		if (rgDataEmissao != null) {
			setRgDataEmissao(rgDataEmissao);
		}

		String tipoPessoa = (String)attributes.get("tipoPessoa");

		if (tipoPessoa != null) {
			setTipoPessoa(tipoPessoa);
		}

		String cpfCnpj = (String)attributes.get("cpfCnpj");

		if (cpfCnpj != null) {
			setCpfCnpj(cpfCnpj);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		String estadoCivil = (String)attributes.get("estadoCivil");

		if (estadoCivil != null) {
			setEstadoCivil(estadoCivil);
		}

		Date dataNascimento = (Date)attributes.get("dataNascimento");

		if (dataNascimento != null) {
			setDataNascimento(dataNascimento);
		}

		String endComLogradouro = (String)attributes.get("endComLogradouro");

		if (endComLogradouro != null) {
			setEndComLogradouro(endComLogradouro);
		}

		String endComNumero = (String)attributes.get("endComNumero");

		if (endComNumero != null) {
			setEndComNumero(endComNumero);
		}

		String endComComplemento = (String)attributes.get("endComComplemento");

		if (endComComplemento != null) {
			setEndComComplemento(endComComplemento);
		}

		String endComCep = (String)attributes.get("endComCep");

		if (endComCep != null) {
			setEndComCep(endComCep);
		}

		String endComBairro = (String)attributes.get("endComBairro");

		if (endComBairro != null) {
			setEndComBairro(endComBairro);
		}

		String endComCidade = (String)attributes.get("endComCidade");

		if (endComCidade != null) {
			setEndComCidade(endComCidade);
		}

		String endComUf = (String)attributes.get("endComUf");

		if (endComUf != null) {
			setEndComUf(endComUf);
		}

		String endComPais = (String)attributes.get("endComPais");

		if (endComPais != null) {
			setEndComPais(endComPais);
		}

		String endResLogradouro = (String)attributes.get("endResLogradouro");

		if (endResLogradouro != null) {
			setEndResLogradouro(endResLogradouro);
		}

		String endResNumero = (String)attributes.get("endResNumero");

		if (endResNumero != null) {
			setEndResNumero(endResNumero);
		}

		String endResComplemento = (String)attributes.get("endResComplemento");

		if (endResComplemento != null) {
			setEndResComplemento(endResComplemento);
		}

		String endResCep = (String)attributes.get("endResCep");

		if (endResCep != null) {
			setEndResCep(endResCep);
		}

		String endResBairro = (String)attributes.get("endResBairro");

		if (endResBairro != null) {
			setEndResBairro(endResBairro);
		}

		String endResCidade = (String)attributes.get("endResCidade");

		if (endResCidade != null) {
			setEndResCidade(endResCidade);
		}

		String endResUf = (String)attributes.get("endResUf");

		if (endResUf != null) {
			setEndResUf(endResUf);
		}

		String endResPais = (String)attributes.get("endResPais");

		if (endResPais != null) {
			setEndResPais(endResPais);
		}

		String telComDdd = (String)attributes.get("telComDdd");

		if (telComDdd != null) {
			setTelComDdd(telComDdd);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}

		String idPolishop = (String)attributes.get("idPolishop");

		if (idPolishop != null) {
			setIdPolishop(idPolishop);
		}

		String idLojaIndicada = (String)attributes.get("idLojaIndicada");

		if (idLojaIndicada != null) {
			setIdLojaIndicada(idLojaIndicada);
		}

		String idPatrocinador = (String)attributes.get("idPatrocinador");

		if (idPatrocinador != null) {
			setIdPatrocinador(idPatrocinador);
		}
	}

	/**
	* Returns the primary key of this associado.
	*
	* @return the primary key of this associado
	*/
	@Override
	public long getPrimaryKey() {
		return _associado.getPrimaryKey();
	}

	/**
	* Sets the primary key of this associado.
	*
	* @param primaryKey the primary key of this associado
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_associado.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this associado.
	*
	* @return the uuid of this associado
	*/
	@Override
	public java.lang.String getUuid() {
		return _associado.getUuid();
	}

	/**
	* Sets the uuid of this associado.
	*
	* @param uuid the uuid of this associado
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_associado.setUuid(uuid);
	}

	/**
	* Returns the associado ID of this associado.
	*
	* @return the associado ID of this associado
	*/
	@Override
	public long getAssociadoId() {
		return _associado.getAssociadoId();
	}

	/**
	* Sets the associado ID of this associado.
	*
	* @param associadoId the associado ID of this associado
	*/
	@Override
	public void setAssociadoId(long associadoId) {
		_associado.setAssociadoId(associadoId);
	}

	/**
	* Returns the company ID of this associado.
	*
	* @return the company ID of this associado
	*/
	@Override
	public long getCompanyId() {
		return _associado.getCompanyId();
	}

	/**
	* Sets the company ID of this associado.
	*
	* @param companyId the company ID of this associado
	*/
	@Override
	public void setCompanyId(long companyId) {
		_associado.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this associado.
	*
	* @return the group ID of this associado
	*/
	@Override
	public long getGroupId() {
		return _associado.getGroupId();
	}

	/**
	* Sets the group ID of this associado.
	*
	* @param groupId the group ID of this associado
	*/
	@Override
	public void setGroupId(long groupId) {
		_associado.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this associado.
	*
	* @return the create user ID of this associado
	*/
	@Override
	public long getCreateUserId() {
		return _associado.getCreateUserId();
	}

	/**
	* Sets the create user ID of this associado.
	*
	* @param createUserId the create user ID of this associado
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_associado.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this associado.
	*
	* @return the create user uuid of this associado
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associado.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this associado.
	*
	* @param createUserUuid the create user uuid of this associado
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_associado.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this associado.
	*
	* @return the modified user ID of this associado
	*/
	@Override
	public long getModifiedUserId() {
		return _associado.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this associado.
	*
	* @param modifiedUserId the modified user ID of this associado
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_associado.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this associado.
	*
	* @return the modified user uuid of this associado
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associado.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this associado.
	*
	* @param modifiedUserUuid the modified user uuid of this associado
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_associado.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this associado.
	*
	* @return the create date of this associado
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _associado.getCreateDate();
	}

	/**
	* Sets the create date of this associado.
	*
	* @param createDate the create date of this associado
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_associado.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this associado.
	*
	* @return the modified date of this associado
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _associado.getModifiedDate();
	}

	/**
	* Sets the modified date of this associado.
	*
	* @param modifiedDate the modified date of this associado
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_associado.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this associado.
	*
	* @return the nome of this associado
	*/
	@Override
	public java.lang.String getNome() {
		return _associado.getNome();
	}

	/**
	* Sets the nome of this associado.
	*
	* @param nome the nome of this associado
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_associado.setNome(nome);
	}

	/**
	* Returns the rg inscricao mun of this associado.
	*
	* @return the rg inscricao mun of this associado
	*/
	@Override
	public java.lang.String getRgInscricaoMun() {
		return _associado.getRgInscricaoMun();
	}

	/**
	* Sets the rg inscricao mun of this associado.
	*
	* @param rgInscricaoMun the rg inscricao mun of this associado
	*/
	@Override
	public void setRgInscricaoMun(java.lang.String rgInscricaoMun) {
		_associado.setRgInscricaoMun(rgInscricaoMun);
	}

	/**
	* Returns the rg orgao emissor of this associado.
	*
	* @return the rg orgao emissor of this associado
	*/
	@Override
	public java.lang.String getRgOrgaoEmissor() {
		return _associado.getRgOrgaoEmissor();
	}

	/**
	* Sets the rg orgao emissor of this associado.
	*
	* @param rgOrgaoEmissor the rg orgao emissor of this associado
	*/
	@Override
	public void setRgOrgaoEmissor(java.lang.String rgOrgaoEmissor) {
		_associado.setRgOrgaoEmissor(rgOrgaoEmissor);
	}

	/**
	* Returns the rg data emissao of this associado.
	*
	* @return the rg data emissao of this associado
	*/
	@Override
	public java.util.Date getRgDataEmissao() {
		return _associado.getRgDataEmissao();
	}

	/**
	* Sets the rg data emissao of this associado.
	*
	* @param rgDataEmissao the rg data emissao of this associado
	*/
	@Override
	public void setRgDataEmissao(java.util.Date rgDataEmissao) {
		_associado.setRgDataEmissao(rgDataEmissao);
	}

	/**
	* Returns the tipo pessoa of this associado.
	*
	* @return the tipo pessoa of this associado
	*/
	@Override
	public java.lang.String getTipoPessoa() {
		return _associado.getTipoPessoa();
	}

	/**
	* Sets the tipo pessoa of this associado.
	*
	* @param tipoPessoa the tipo pessoa of this associado
	*/
	@Override
	public void setTipoPessoa(java.lang.String tipoPessoa) {
		_associado.setTipoPessoa(tipoPessoa);
	}

	/**
	* Returns the cpf cnpj of this associado.
	*
	* @return the cpf cnpj of this associado
	*/
	@Override
	public java.lang.String getCpfCnpj() {
		return _associado.getCpfCnpj();
	}

	/**
	* Sets the cpf cnpj of this associado.
	*
	* @param cpfCnpj the cpf cnpj of this associado
	*/
	@Override
	public void setCpfCnpj(java.lang.String cpfCnpj) {
		_associado.setCpfCnpj(cpfCnpj);
	}

	/**
	* Returns the sexo of this associado.
	*
	* @return the sexo of this associado
	*/
	@Override
	public java.lang.String getSexo() {
		return _associado.getSexo();
	}

	/**
	* Sets the sexo of this associado.
	*
	* @param sexo the sexo of this associado
	*/
	@Override
	public void setSexo(java.lang.String sexo) {
		_associado.setSexo(sexo);
	}

	/**
	* Returns the estado civil of this associado.
	*
	* @return the estado civil of this associado
	*/
	@Override
	public java.lang.String getEstadoCivil() {
		return _associado.getEstadoCivil();
	}

	/**
	* Sets the estado civil of this associado.
	*
	* @param estadoCivil the estado civil of this associado
	*/
	@Override
	public void setEstadoCivil(java.lang.String estadoCivil) {
		_associado.setEstadoCivil(estadoCivil);
	}

	/**
	* Returns the data nascimento of this associado.
	*
	* @return the data nascimento of this associado
	*/
	@Override
	public java.util.Date getDataNascimento() {
		return _associado.getDataNascimento();
	}

	/**
	* Sets the data nascimento of this associado.
	*
	* @param dataNascimento the data nascimento of this associado
	*/
	@Override
	public void setDataNascimento(java.util.Date dataNascimento) {
		_associado.setDataNascimento(dataNascimento);
	}

	/**
	* Returns the end com logradouro of this associado.
	*
	* @return the end com logradouro of this associado
	*/
	@Override
	public java.lang.String getEndComLogradouro() {
		return _associado.getEndComLogradouro();
	}

	/**
	* Sets the end com logradouro of this associado.
	*
	* @param endComLogradouro the end com logradouro of this associado
	*/
	@Override
	public void setEndComLogradouro(java.lang.String endComLogradouro) {
		_associado.setEndComLogradouro(endComLogradouro);
	}

	/**
	* Returns the end com numero of this associado.
	*
	* @return the end com numero of this associado
	*/
	@Override
	public java.lang.String getEndComNumero() {
		return _associado.getEndComNumero();
	}

	/**
	* Sets the end com numero of this associado.
	*
	* @param endComNumero the end com numero of this associado
	*/
	@Override
	public void setEndComNumero(java.lang.String endComNumero) {
		_associado.setEndComNumero(endComNumero);
	}

	/**
	* Returns the end com complemento of this associado.
	*
	* @return the end com complemento of this associado
	*/
	@Override
	public java.lang.String getEndComComplemento() {
		return _associado.getEndComComplemento();
	}

	/**
	* Sets the end com complemento of this associado.
	*
	* @param endComComplemento the end com complemento of this associado
	*/
	@Override
	public void setEndComComplemento(java.lang.String endComComplemento) {
		_associado.setEndComComplemento(endComComplemento);
	}

	/**
	* Returns the end com cep of this associado.
	*
	* @return the end com cep of this associado
	*/
	@Override
	public java.lang.String getEndComCep() {
		return _associado.getEndComCep();
	}

	/**
	* Sets the end com cep of this associado.
	*
	* @param endComCep the end com cep of this associado
	*/
	@Override
	public void setEndComCep(java.lang.String endComCep) {
		_associado.setEndComCep(endComCep);
	}

	/**
	* Returns the end com bairro of this associado.
	*
	* @return the end com bairro of this associado
	*/
	@Override
	public java.lang.String getEndComBairro() {
		return _associado.getEndComBairro();
	}

	/**
	* Sets the end com bairro of this associado.
	*
	* @param endComBairro the end com bairro of this associado
	*/
	@Override
	public void setEndComBairro(java.lang.String endComBairro) {
		_associado.setEndComBairro(endComBairro);
	}

	/**
	* Returns the end com cidade of this associado.
	*
	* @return the end com cidade of this associado
	*/
	@Override
	public java.lang.String getEndComCidade() {
		return _associado.getEndComCidade();
	}

	/**
	* Sets the end com cidade of this associado.
	*
	* @param endComCidade the end com cidade of this associado
	*/
	@Override
	public void setEndComCidade(java.lang.String endComCidade) {
		_associado.setEndComCidade(endComCidade);
	}

	/**
	* Returns the end com uf of this associado.
	*
	* @return the end com uf of this associado
	*/
	@Override
	public java.lang.String getEndComUf() {
		return _associado.getEndComUf();
	}

	/**
	* Sets the end com uf of this associado.
	*
	* @param endComUf the end com uf of this associado
	*/
	@Override
	public void setEndComUf(java.lang.String endComUf) {
		_associado.setEndComUf(endComUf);
	}

	/**
	* Returns the end com pais of this associado.
	*
	* @return the end com pais of this associado
	*/
	@Override
	public java.lang.String getEndComPais() {
		return _associado.getEndComPais();
	}

	/**
	* Sets the end com pais of this associado.
	*
	* @param endComPais the end com pais of this associado
	*/
	@Override
	public void setEndComPais(java.lang.String endComPais) {
		_associado.setEndComPais(endComPais);
	}

	/**
	* Returns the end res logradouro of this associado.
	*
	* @return the end res logradouro of this associado
	*/
	@Override
	public java.lang.String getEndResLogradouro() {
		return _associado.getEndResLogradouro();
	}

	/**
	* Sets the end res logradouro of this associado.
	*
	* @param endResLogradouro the end res logradouro of this associado
	*/
	@Override
	public void setEndResLogradouro(java.lang.String endResLogradouro) {
		_associado.setEndResLogradouro(endResLogradouro);
	}

	/**
	* Returns the end res numero of this associado.
	*
	* @return the end res numero of this associado
	*/
	@Override
	public java.lang.String getEndResNumero() {
		return _associado.getEndResNumero();
	}

	/**
	* Sets the end res numero of this associado.
	*
	* @param endResNumero the end res numero of this associado
	*/
	@Override
	public void setEndResNumero(java.lang.String endResNumero) {
		_associado.setEndResNumero(endResNumero);
	}

	/**
	* Returns the end res complemento of this associado.
	*
	* @return the end res complemento of this associado
	*/
	@Override
	public java.lang.String getEndResComplemento() {
		return _associado.getEndResComplemento();
	}

	/**
	* Sets the end res complemento of this associado.
	*
	* @param endResComplemento the end res complemento of this associado
	*/
	@Override
	public void setEndResComplemento(java.lang.String endResComplemento) {
		_associado.setEndResComplemento(endResComplemento);
	}

	/**
	* Returns the end res cep of this associado.
	*
	* @return the end res cep of this associado
	*/
	@Override
	public java.lang.String getEndResCep() {
		return _associado.getEndResCep();
	}

	/**
	* Sets the end res cep of this associado.
	*
	* @param endResCep the end res cep of this associado
	*/
	@Override
	public void setEndResCep(java.lang.String endResCep) {
		_associado.setEndResCep(endResCep);
	}

	/**
	* Returns the end res bairro of this associado.
	*
	* @return the end res bairro of this associado
	*/
	@Override
	public java.lang.String getEndResBairro() {
		return _associado.getEndResBairro();
	}

	/**
	* Sets the end res bairro of this associado.
	*
	* @param endResBairro the end res bairro of this associado
	*/
	@Override
	public void setEndResBairro(java.lang.String endResBairro) {
		_associado.setEndResBairro(endResBairro);
	}

	/**
	* Returns the end res cidade of this associado.
	*
	* @return the end res cidade of this associado
	*/
	@Override
	public java.lang.String getEndResCidade() {
		return _associado.getEndResCidade();
	}

	/**
	* Sets the end res cidade of this associado.
	*
	* @param endResCidade the end res cidade of this associado
	*/
	@Override
	public void setEndResCidade(java.lang.String endResCidade) {
		_associado.setEndResCidade(endResCidade);
	}

	/**
	* Returns the end res uf of this associado.
	*
	* @return the end res uf of this associado
	*/
	@Override
	public java.lang.String getEndResUf() {
		return _associado.getEndResUf();
	}

	/**
	* Sets the end res uf of this associado.
	*
	* @param endResUf the end res uf of this associado
	*/
	@Override
	public void setEndResUf(java.lang.String endResUf) {
		_associado.setEndResUf(endResUf);
	}

	/**
	* Returns the end res pais of this associado.
	*
	* @return the end res pais of this associado
	*/
	@Override
	public java.lang.String getEndResPais() {
		return _associado.getEndResPais();
	}

	/**
	* Sets the end res pais of this associado.
	*
	* @param endResPais the end res pais of this associado
	*/
	@Override
	public void setEndResPais(java.lang.String endResPais) {
		_associado.setEndResPais(endResPais);
	}

	/**
	* Returns the tel com ddd of this associado.
	*
	* @return the tel com ddd of this associado
	*/
	@Override
	public java.lang.String getTelComDdd() {
		return _associado.getTelComDdd();
	}

	/**
	* Sets the tel com ddd of this associado.
	*
	* @param telComDdd the tel com ddd of this associado
	*/
	@Override
	public void setTelComDdd(java.lang.String telComDdd) {
		_associado.setTelComDdd(telComDdd);
	}

	/**
	* Returns the versao of this associado.
	*
	* @return the versao of this associado
	*/
	@Override
	public double getVersao() {
		return _associado.getVersao();
	}

	/**
	* Sets the versao of this associado.
	*
	* @param versao the versao of this associado
	*/
	@Override
	public void setVersao(double versao) {
		_associado.setVersao(versao);
	}

	/**
	* Returns the user ID of this associado.
	*
	* @return the user ID of this associado
	*/
	@Override
	public long getUserId() {
		return _associado.getUserId();
	}

	/**
	* Sets the user ID of this associado.
	*
	* @param userId the user ID of this associado
	*/
	@Override
	public void setUserId(long userId) {
		_associado.setUserId(userId);
	}

	/**
	* Returns the user uuid of this associado.
	*
	* @return the user uuid of this associado
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associado.getUserUuid();
	}

	/**
	* Sets the user uuid of this associado.
	*
	* @param userUuid the user uuid of this associado
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_associado.setUserUuid(userUuid);
	}

	/**
	* Returns the observacao of this associado.
	*
	* @return the observacao of this associado
	*/
	@Override
	public java.lang.String getObservacao() {
		return _associado.getObservacao();
	}

	/**
	* Sets the observacao of this associado.
	*
	* @param observacao the observacao of this associado
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_associado.setObservacao(observacao);
	}

	/**
	* Returns the id polishop of this associado.
	*
	* @return the id polishop of this associado
	*/
	@Override
	public java.lang.String getIdPolishop() {
		return _associado.getIdPolishop();
	}

	/**
	* Sets the id polishop of this associado.
	*
	* @param idPolishop the id polishop of this associado
	*/
	@Override
	public void setIdPolishop(java.lang.String idPolishop) {
		_associado.setIdPolishop(idPolishop);
	}

	/**
	* Returns the id loja indicada of this associado.
	*
	* @return the id loja indicada of this associado
	*/
	@Override
	public java.lang.String getIdLojaIndicada() {
		return _associado.getIdLojaIndicada();
	}

	/**
	* Sets the id loja indicada of this associado.
	*
	* @param idLojaIndicada the id loja indicada of this associado
	*/
	@Override
	public void setIdLojaIndicada(java.lang.String idLojaIndicada) {
		_associado.setIdLojaIndicada(idLojaIndicada);
	}

	/**
	* Returns the id patrocinador of this associado.
	*
	* @return the id patrocinador of this associado
	*/
	@Override
	public java.lang.String getIdPatrocinador() {
		return _associado.getIdPatrocinador();
	}

	/**
	* Sets the id patrocinador of this associado.
	*
	* @param idPatrocinador the id patrocinador of this associado
	*/
	@Override
	public void setIdPatrocinador(java.lang.String idPatrocinador) {
		_associado.setIdPatrocinador(idPatrocinador);
	}

	@Override
	public boolean isNew() {
		return _associado.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_associado.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _associado.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_associado.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _associado.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _associado.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_associado.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _associado.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_associado.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_associado.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_associado.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AssociadoWrapper((Associado)_associado.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.associado.model.Associado associado) {
		return _associado.compareTo(associado);
	}

	@Override
	public int hashCode() {
		return _associado.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.associado.model.Associado> toCacheModel() {
		return _associado.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado toEscapedModel() {
		return new AssociadoWrapper(_associado.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.associado.model.Associado toUnescapedModel() {
		return new AssociadoWrapper(_associado.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _associado.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _associado.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_associado.persist();
	}

	@Override
	public java.lang.String getFotoURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long userId,
		java.lang.String sexo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associado.getFotoURL(themeDisplay, userId, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssociadoWrapper)) {
			return false;
		}

		AssociadoWrapper associadoWrapper = (AssociadoWrapper)obj;

		if (Validator.equals(_associado, associadoWrapper._associado)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _associado.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Associado getWrappedAssociado() {
		return _associado;
	}

	@Override
	public Associado getWrappedModel() {
		return _associado;
	}

	@Override
	public void resetOriginalValues() {
		_associado.resetOriginalValues();
	}

	private Associado _associado;
}