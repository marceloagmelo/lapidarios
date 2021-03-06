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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Associado service. Represents a row in the &quot;associado&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.associado.model.impl.AssociadoImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Associado
 * @see br.com.prodevelopment.associado.model.impl.AssociadoImpl
 * @see br.com.prodevelopment.associado.model.impl.AssociadoModelImpl
 * @generated
 */
public interface AssociadoModel extends BaseModel<Associado>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a associado model instance should use the {@link Associado} interface instead.
	 */

	/**
	 * Returns the primary key of this associado.
	 *
	 * @return the primary key of this associado
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this associado.
	 *
	 * @param primaryKey the primary key of this associado
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this associado.
	 *
	 * @return the uuid of this associado
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this associado.
	 *
	 * @param uuid the uuid of this associado
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the associado ID of this associado.
	 *
	 * @return the associado ID of this associado
	 */
	public long getAssociadoId();

	/**
	 * Sets the associado ID of this associado.
	 *
	 * @param associadoId the associado ID of this associado
	 */
	public void setAssociadoId(long associadoId);

	/**
	 * Returns the company ID of this associado.
	 *
	 * @return the company ID of this associado
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this associado.
	 *
	 * @param companyId the company ID of this associado
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this associado.
	 *
	 * @return the group ID of this associado
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this associado.
	 *
	 * @param groupId the group ID of this associado
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create user ID of this associado.
	 *
	 * @return the create user ID of this associado
	 */
	public long getCreateUserId();

	/**
	 * Sets the create user ID of this associado.
	 *
	 * @param createUserId the create user ID of this associado
	 */
	public void setCreateUserId(long createUserId);

	/**
	 * Returns the create user uuid of this associado.
	 *
	 * @return the create user uuid of this associado
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreateUserUuid() throws SystemException;

	/**
	 * Sets the create user uuid of this associado.
	 *
	 * @param createUserUuid the create user uuid of this associado
	 */
	public void setCreateUserUuid(String createUserUuid);

	/**
	 * Returns the modified user ID of this associado.
	 *
	 * @return the modified user ID of this associado
	 */
	public long getModifiedUserId();

	/**
	 * Sets the modified user ID of this associado.
	 *
	 * @param modifiedUserId the modified user ID of this associado
	 */
	public void setModifiedUserId(long modifiedUserId);

	/**
	 * Returns the modified user uuid of this associado.
	 *
	 * @return the modified user uuid of this associado
	 * @throws SystemException if a system exception occurred
	 */
	public String getModifiedUserUuid() throws SystemException;

	/**
	 * Sets the modified user uuid of this associado.
	 *
	 * @param modifiedUserUuid the modified user uuid of this associado
	 */
	public void setModifiedUserUuid(String modifiedUserUuid);

	/**
	 * Returns the create date of this associado.
	 *
	 * @return the create date of this associado
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this associado.
	 *
	 * @param createDate the create date of this associado
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this associado.
	 *
	 * @return the modified date of this associado
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this associado.
	 *
	 * @param modifiedDate the modified date of this associado
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nome of this associado.
	 *
	 * @return the nome of this associado
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this associado.
	 *
	 * @param nome the nome of this associado
	 */
	public void setNome(String nome);

	/**
	 * Returns the rg inscricao mun of this associado.
	 *
	 * @return the rg inscricao mun of this associado
	 */
	@AutoEscape
	public String getRgInscricaoMun();

	/**
	 * Sets the rg inscricao mun of this associado.
	 *
	 * @param rgInscricaoMun the rg inscricao mun of this associado
	 */
	public void setRgInscricaoMun(String rgInscricaoMun);

	/**
	 * Returns the rg orgao emissor of this associado.
	 *
	 * @return the rg orgao emissor of this associado
	 */
	@AutoEscape
	public String getRgOrgaoEmissor();

	/**
	 * Sets the rg orgao emissor of this associado.
	 *
	 * @param rgOrgaoEmissor the rg orgao emissor of this associado
	 */
	public void setRgOrgaoEmissor(String rgOrgaoEmissor);

	/**
	 * Returns the rg data emissao of this associado.
	 *
	 * @return the rg data emissao of this associado
	 */
	public Date getRgDataEmissao();

	/**
	 * Sets the rg data emissao of this associado.
	 *
	 * @param rgDataEmissao the rg data emissao of this associado
	 */
	public void setRgDataEmissao(Date rgDataEmissao);

	/**
	 * Returns the tipo pessoa of this associado.
	 *
	 * @return the tipo pessoa of this associado
	 */
	@AutoEscape
	public String getTipoPessoa();

	/**
	 * Sets the tipo pessoa of this associado.
	 *
	 * @param tipoPessoa the tipo pessoa of this associado
	 */
	public void setTipoPessoa(String tipoPessoa);

	/**
	 * Returns the cpf cnpj of this associado.
	 *
	 * @return the cpf cnpj of this associado
	 */
	@AutoEscape
	public String getCpfCnpj();

	/**
	 * Sets the cpf cnpj of this associado.
	 *
	 * @param cpfCnpj the cpf cnpj of this associado
	 */
	public void setCpfCnpj(String cpfCnpj);

	/**
	 * Returns the sexo of this associado.
	 *
	 * @return the sexo of this associado
	 */
	@AutoEscape
	public String getSexo();

	/**
	 * Sets the sexo of this associado.
	 *
	 * @param sexo the sexo of this associado
	 */
	public void setSexo(String sexo);

	/**
	 * Returns the estado civil of this associado.
	 *
	 * @return the estado civil of this associado
	 */
	@AutoEscape
	public String getEstadoCivil();

	/**
	 * Sets the estado civil of this associado.
	 *
	 * @param estadoCivil the estado civil of this associado
	 */
	public void setEstadoCivil(String estadoCivil);

	/**
	 * Returns the data nascimento of this associado.
	 *
	 * @return the data nascimento of this associado
	 */
	public Date getDataNascimento();

	/**
	 * Sets the data nascimento of this associado.
	 *
	 * @param dataNascimento the data nascimento of this associado
	 */
	public void setDataNascimento(Date dataNascimento);

	/**
	 * Returns the end com logradouro of this associado.
	 *
	 * @return the end com logradouro of this associado
	 */
	@AutoEscape
	public String getEndComLogradouro();

	/**
	 * Sets the end com logradouro of this associado.
	 *
	 * @param endComLogradouro the end com logradouro of this associado
	 */
	public void setEndComLogradouro(String endComLogradouro);

	/**
	 * Returns the end com numero of this associado.
	 *
	 * @return the end com numero of this associado
	 */
	@AutoEscape
	public String getEndComNumero();

	/**
	 * Sets the end com numero of this associado.
	 *
	 * @param endComNumero the end com numero of this associado
	 */
	public void setEndComNumero(String endComNumero);

	/**
	 * Returns the end com complemento of this associado.
	 *
	 * @return the end com complemento of this associado
	 */
	@AutoEscape
	public String getEndComComplemento();

	/**
	 * Sets the end com complemento of this associado.
	 *
	 * @param endComComplemento the end com complemento of this associado
	 */
	public void setEndComComplemento(String endComComplemento);

	/**
	 * Returns the end com cep of this associado.
	 *
	 * @return the end com cep of this associado
	 */
	@AutoEscape
	public String getEndComCep();

	/**
	 * Sets the end com cep of this associado.
	 *
	 * @param endComCep the end com cep of this associado
	 */
	public void setEndComCep(String endComCep);

	/**
	 * Returns the end com bairro of this associado.
	 *
	 * @return the end com bairro of this associado
	 */
	@AutoEscape
	public String getEndComBairro();

	/**
	 * Sets the end com bairro of this associado.
	 *
	 * @param endComBairro the end com bairro of this associado
	 */
	public void setEndComBairro(String endComBairro);

	/**
	 * Returns the end com cidade of this associado.
	 *
	 * @return the end com cidade of this associado
	 */
	@AutoEscape
	public String getEndComCidade();

	/**
	 * Sets the end com cidade of this associado.
	 *
	 * @param endComCidade the end com cidade of this associado
	 */
	public void setEndComCidade(String endComCidade);

	/**
	 * Returns the end com uf of this associado.
	 *
	 * @return the end com uf of this associado
	 */
	@AutoEscape
	public String getEndComUf();

	/**
	 * Sets the end com uf of this associado.
	 *
	 * @param endComUf the end com uf of this associado
	 */
	public void setEndComUf(String endComUf);

	/**
	 * Returns the end com pais of this associado.
	 *
	 * @return the end com pais of this associado
	 */
	@AutoEscape
	public String getEndComPais();

	/**
	 * Sets the end com pais of this associado.
	 *
	 * @param endComPais the end com pais of this associado
	 */
	public void setEndComPais(String endComPais);

	/**
	 * Returns the end res logradouro of this associado.
	 *
	 * @return the end res logradouro of this associado
	 */
	@AutoEscape
	public String getEndResLogradouro();

	/**
	 * Sets the end res logradouro of this associado.
	 *
	 * @param endResLogradouro the end res logradouro of this associado
	 */
	public void setEndResLogradouro(String endResLogradouro);

	/**
	 * Returns the end res numero of this associado.
	 *
	 * @return the end res numero of this associado
	 */
	@AutoEscape
	public String getEndResNumero();

	/**
	 * Sets the end res numero of this associado.
	 *
	 * @param endResNumero the end res numero of this associado
	 */
	public void setEndResNumero(String endResNumero);

	/**
	 * Returns the end res complemento of this associado.
	 *
	 * @return the end res complemento of this associado
	 */
	@AutoEscape
	public String getEndResComplemento();

	/**
	 * Sets the end res complemento of this associado.
	 *
	 * @param endResComplemento the end res complemento of this associado
	 */
	public void setEndResComplemento(String endResComplemento);

	/**
	 * Returns the end res cep of this associado.
	 *
	 * @return the end res cep of this associado
	 */
	@AutoEscape
	public String getEndResCep();

	/**
	 * Sets the end res cep of this associado.
	 *
	 * @param endResCep the end res cep of this associado
	 */
	public void setEndResCep(String endResCep);

	/**
	 * Returns the end res bairro of this associado.
	 *
	 * @return the end res bairro of this associado
	 */
	@AutoEscape
	public String getEndResBairro();

	/**
	 * Sets the end res bairro of this associado.
	 *
	 * @param endResBairro the end res bairro of this associado
	 */
	public void setEndResBairro(String endResBairro);

	/**
	 * Returns the end res cidade of this associado.
	 *
	 * @return the end res cidade of this associado
	 */
	@AutoEscape
	public String getEndResCidade();

	/**
	 * Sets the end res cidade of this associado.
	 *
	 * @param endResCidade the end res cidade of this associado
	 */
	public void setEndResCidade(String endResCidade);

	/**
	 * Returns the end res uf of this associado.
	 *
	 * @return the end res uf of this associado
	 */
	@AutoEscape
	public String getEndResUf();

	/**
	 * Sets the end res uf of this associado.
	 *
	 * @param endResUf the end res uf of this associado
	 */
	public void setEndResUf(String endResUf);

	/**
	 * Returns the end res pais of this associado.
	 *
	 * @return the end res pais of this associado
	 */
	@AutoEscape
	public String getEndResPais();

	/**
	 * Sets the end res pais of this associado.
	 *
	 * @param endResPais the end res pais of this associado
	 */
	public void setEndResPais(String endResPais);

	/**
	 * Returns the tel com ddd of this associado.
	 *
	 * @return the tel com ddd of this associado
	 */
	@AutoEscape
	public String getTelComDdd();

	/**
	 * Sets the tel com ddd of this associado.
	 *
	 * @param telComDdd the tel com ddd of this associado
	 */
	public void setTelComDdd(String telComDdd);

	/**
	 * Returns the versao of this associado.
	 *
	 * @return the versao of this associado
	 */
	public double getVersao();

	/**
	 * Sets the versao of this associado.
	 *
	 * @param versao the versao of this associado
	 */
	public void setVersao(double versao);

	/**
	 * Returns the user ID of this associado.
	 *
	 * @return the user ID of this associado
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this associado.
	 *
	 * @param userId the user ID of this associado
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this associado.
	 *
	 * @return the user uuid of this associado
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this associado.
	 *
	 * @param userUuid the user uuid of this associado
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the observacao of this associado.
	 *
	 * @return the observacao of this associado
	 */
	@AutoEscape
	public String getObservacao();

	/**
	 * Sets the observacao of this associado.
	 *
	 * @param observacao the observacao of this associado
	 */
	public void setObservacao(String observacao);

	/**
	 * Returns the id polishop of this associado.
	 *
	 * @return the id polishop of this associado
	 */
	@AutoEscape
	public String getIdPolishop();

	/**
	 * Sets the id polishop of this associado.
	 *
	 * @param idPolishop the id polishop of this associado
	 */
	public void setIdPolishop(String idPolishop);

	/**
	 * Returns the id loja indicada of this associado.
	 *
	 * @return the id loja indicada of this associado
	 */
	@AutoEscape
	public String getIdLojaIndicada();

	/**
	 * Sets the id loja indicada of this associado.
	 *
	 * @param idLojaIndicada the id loja indicada of this associado
	 */
	public void setIdLojaIndicada(String idLojaIndicada);

	/**
	 * Returns the id patrocinador of this associado.
	 *
	 * @return the id patrocinador of this associado
	 */
	@AutoEscape
	public String getIdPatrocinador();

	/**
	 * Sets the id patrocinador of this associado.
	 *
	 * @param idPatrocinador the id patrocinador of this associado
	 */
	public void setIdPatrocinador(String idPatrocinador);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		br.com.prodevelopment.associado.model.Associado associado);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.prodevelopment.associado.model.Associado> toCacheModel();

	@Override
	public br.com.prodevelopment.associado.model.Associado toEscapedModel();

	@Override
	public br.com.prodevelopment.associado.model.Associado toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}