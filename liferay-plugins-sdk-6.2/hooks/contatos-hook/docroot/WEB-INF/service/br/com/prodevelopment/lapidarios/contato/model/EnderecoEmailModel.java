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

package br.com.prodevelopment.lapidarios.contato.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EnderecoEmail service. Represents a row in the &quot;endereco_email&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoEmailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoEmailImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see EnderecoEmail
 * @see br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoEmailImpl
 * @see br.com.prodevelopment.lapidarios.contato.model.impl.EnderecoEmailModelImpl
 * @generated
 */
public interface EnderecoEmailModel extends AttachedModel,
	BaseModel<EnderecoEmail>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a endereco email model instance should use the {@link EnderecoEmail} interface instead.
	 */

	/**
	 * Returns the primary key of this endereco email.
	 *
	 * @return the primary key of this endereco email
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this endereco email.
	 *
	 * @param primaryKey the primary key of this endereco email
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this endereco email.
	 *
	 * @return the uuid of this endereco email
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this endereco email.
	 *
	 * @param uuid the uuid of this endereco email
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the endereco email ID of this endereco email.
	 *
	 * @return the endereco email ID of this endereco email
	 */
	public long getEnderecoEmailId();

	/**
	 * Sets the endereco email ID of this endereco email.
	 *
	 * @param enderecoEmailId the endereco email ID of this endereco email
	 */
	public void setEnderecoEmailId(long enderecoEmailId);

	/**
	 * Returns the company ID of this endereco email.
	 *
	 * @return the company ID of this endereco email
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this endereco email.
	 *
	 * @param companyId the company ID of this endereco email
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this endereco email.
	 *
	 * @return the group ID of this endereco email
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this endereco email.
	 *
	 * @param groupId the group ID of this endereco email
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create user ID of this endereco email.
	 *
	 * @return the create user ID of this endereco email
	 */
	public long getCreateUserId();

	/**
	 * Sets the create user ID of this endereco email.
	 *
	 * @param createUserId the create user ID of this endereco email
	 */
	public void setCreateUserId(long createUserId);

	/**
	 * Returns the create user uuid of this endereco email.
	 *
	 * @return the create user uuid of this endereco email
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreateUserUuid() throws SystemException;

	/**
	 * Sets the create user uuid of this endereco email.
	 *
	 * @param createUserUuid the create user uuid of this endereco email
	 */
	public void setCreateUserUuid(String createUserUuid);

	/**
	 * Returns the modified user ID of this endereco email.
	 *
	 * @return the modified user ID of this endereco email
	 */
	public long getModifiedUserId();

	/**
	 * Sets the modified user ID of this endereco email.
	 *
	 * @param modifiedUserId the modified user ID of this endereco email
	 */
	public void setModifiedUserId(long modifiedUserId);

	/**
	 * Returns the modified user uuid of this endereco email.
	 *
	 * @return the modified user uuid of this endereco email
	 * @throws SystemException if a system exception occurred
	 */
	public String getModifiedUserUuid() throws SystemException;

	/**
	 * Sets the modified user uuid of this endereco email.
	 *
	 * @param modifiedUserUuid the modified user uuid of this endereco email
	 */
	public void setModifiedUserUuid(String modifiedUserUuid);

	/**
	 * Returns the create date of this endereco email.
	 *
	 * @return the create date of this endereco email
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this endereco email.
	 *
	 * @param createDate the create date of this endereco email
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this endereco email.
	 *
	 * @return the modified date of this endereco email
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this endereco email.
	 *
	 * @param modifiedDate the modified date of this endereco email
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this endereco email.
	 *
	 * @return the fully qualified class name of this endereco email
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this endereco email.
	 *
	 * @return the class name ID of this endereco email
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this endereco email.
	 *
	 * @param classNameId the class name ID of this endereco email
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this endereco email.
	 *
	 * @return the class p k of this endereco email
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this endereco email.
	 *
	 * @param classPK the class p k of this endereco email
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the endereco of this endereco email.
	 *
	 * @return the endereco of this endereco email
	 */
	@AutoEscape
	public String getEndereco();

	/**
	 * Sets the endereco of this endereco email.
	 *
	 * @param endereco the endereco of this endereco email
	 */
	public void setEndereco(String endereco);

	/**
	 * Returns the tipo of this endereco email.
	 *
	 * @return the tipo of this endereco email
	 */
	public int getTipo();

	/**
	 * Sets the tipo of this endereco email.
	 *
	 * @param tipo the tipo of this endereco email
	 */
	public void setTipo(int tipo);

	/**
	 * Returns the principal of this endereco email.
	 *
	 * @return the principal of this endereco email
	 */
	public boolean getPrincipal();

	/**
	 * Returns <code>true</code> if this endereco email is principal.
	 *
	 * @return <code>true</code> if this endereco email is principal; <code>false</code> otherwise
	 */
	public boolean isPrincipal();

	/**
	 * Sets whether this endereco email is principal.
	 *
	 * @param principal the principal of this endereco email
	 */
	public void setPrincipal(boolean principal);

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
		br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail enderecoEmail);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail> toCacheModel();

	@Override
	public br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail toEscapedModel();

	@Override
	public br.com.prodevelopment.lapidarios.contato.model.EnderecoEmail toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}