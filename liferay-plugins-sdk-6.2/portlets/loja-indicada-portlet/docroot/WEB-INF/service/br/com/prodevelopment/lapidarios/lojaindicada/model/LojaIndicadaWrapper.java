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

package br.com.prodevelopment.lapidarios.lojaindicada.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LojaIndicada}.
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaIndicada
 * @generated
 */
public class LojaIndicadaWrapper implements LojaIndicada,
	ModelWrapper<LojaIndicada> {
	public LojaIndicadaWrapper(LojaIndicada lojaIndicada) {
		_lojaIndicada = lojaIndicada;
	}

	@Override
	public Class<?> getModelClass() {
		return LojaIndicada.class;
	}

	@Override
	public String getModelClassName() {
		return LojaIndicada.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("lojaIndicadaId", getLojaIndicadaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("idLoja", getIdLoja());
		attributes.put("lojaIndicadaAtual", getLojaIndicadaAtual());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long lojaIndicadaId = (Long)attributes.get("lojaIndicadaId");

		if (lojaIndicadaId != null) {
			setLojaIndicadaId(lojaIndicadaId);
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

		String idLoja = (String)attributes.get("idLoja");

		if (idLoja != null) {
			setIdLoja(idLoja);
		}

		Boolean lojaIndicadaAtual = (Boolean)attributes.get("lojaIndicadaAtual");

		if (lojaIndicadaAtual != null) {
			setLojaIndicadaAtual(lojaIndicadaAtual);
		}
	}

	/**
	* Returns the primary key of this loja indicada.
	*
	* @return the primary key of this loja indicada
	*/
	@Override
	public long getPrimaryKey() {
		return _lojaIndicada.getPrimaryKey();
	}

	/**
	* Sets the primary key of this loja indicada.
	*
	* @param primaryKey the primary key of this loja indicada
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lojaIndicada.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this loja indicada.
	*
	* @return the uuid of this loja indicada
	*/
	@Override
	public java.lang.String getUuid() {
		return _lojaIndicada.getUuid();
	}

	/**
	* Sets the uuid of this loja indicada.
	*
	* @param uuid the uuid of this loja indicada
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_lojaIndicada.setUuid(uuid);
	}

	/**
	* Returns the loja indicada ID of this loja indicada.
	*
	* @return the loja indicada ID of this loja indicada
	*/
	@Override
	public long getLojaIndicadaId() {
		return _lojaIndicada.getLojaIndicadaId();
	}

	/**
	* Sets the loja indicada ID of this loja indicada.
	*
	* @param lojaIndicadaId the loja indicada ID of this loja indicada
	*/
	@Override
	public void setLojaIndicadaId(long lojaIndicadaId) {
		_lojaIndicada.setLojaIndicadaId(lojaIndicadaId);
	}

	/**
	* Returns the company ID of this loja indicada.
	*
	* @return the company ID of this loja indicada
	*/
	@Override
	public long getCompanyId() {
		return _lojaIndicada.getCompanyId();
	}

	/**
	* Sets the company ID of this loja indicada.
	*
	* @param companyId the company ID of this loja indicada
	*/
	@Override
	public void setCompanyId(long companyId) {
		_lojaIndicada.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this loja indicada.
	*
	* @return the group ID of this loja indicada
	*/
	@Override
	public long getGroupId() {
		return _lojaIndicada.getGroupId();
	}

	/**
	* Sets the group ID of this loja indicada.
	*
	* @param groupId the group ID of this loja indicada
	*/
	@Override
	public void setGroupId(long groupId) {
		_lojaIndicada.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this loja indicada.
	*
	* @return the create user ID of this loja indicada
	*/
	@Override
	public long getCreateUserId() {
		return _lojaIndicada.getCreateUserId();
	}

	/**
	* Sets the create user ID of this loja indicada.
	*
	* @param createUserId the create user ID of this loja indicada
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_lojaIndicada.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this loja indicada.
	*
	* @return the create user uuid of this loja indicada
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicada.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this loja indicada.
	*
	* @param createUserUuid the create user uuid of this loja indicada
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_lojaIndicada.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this loja indicada.
	*
	* @return the modified user ID of this loja indicada
	*/
	@Override
	public long getModifiedUserId() {
		return _lojaIndicada.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this loja indicada.
	*
	* @param modifiedUserId the modified user ID of this loja indicada
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_lojaIndicada.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this loja indicada.
	*
	* @return the modified user uuid of this loja indicada
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicada.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this loja indicada.
	*
	* @param modifiedUserUuid the modified user uuid of this loja indicada
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_lojaIndicada.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this loja indicada.
	*
	* @return the create date of this loja indicada
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _lojaIndicada.getCreateDate();
	}

	/**
	* Sets the create date of this loja indicada.
	*
	* @param createDate the create date of this loja indicada
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_lojaIndicada.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this loja indicada.
	*
	* @return the modified date of this loja indicada
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _lojaIndicada.getModifiedDate();
	}

	/**
	* Sets the modified date of this loja indicada.
	*
	* @param modifiedDate the modified date of this loja indicada
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_lojaIndicada.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the id loja of this loja indicada.
	*
	* @return the id loja of this loja indicada
	*/
	@Override
	public java.lang.String getIdLoja() {
		return _lojaIndicada.getIdLoja();
	}

	/**
	* Sets the id loja of this loja indicada.
	*
	* @param idLoja the id loja of this loja indicada
	*/
	@Override
	public void setIdLoja(java.lang.String idLoja) {
		_lojaIndicada.setIdLoja(idLoja);
	}

	/**
	* Returns the loja indicada atual of this loja indicada.
	*
	* @return the loja indicada atual of this loja indicada
	*/
	@Override
	public java.lang.Boolean getLojaIndicadaAtual() {
		return _lojaIndicada.getLojaIndicadaAtual();
	}

	/**
	* Sets the loja indicada atual of this loja indicada.
	*
	* @param lojaIndicadaAtual the loja indicada atual of this loja indicada
	*/
	@Override
	public void setLojaIndicadaAtual(java.lang.Boolean lojaIndicadaAtual) {
		_lojaIndicada.setLojaIndicadaAtual(lojaIndicadaAtual);
	}

	/**
	* Returns the status of this loja indicada.
	*
	* @return the status of this loja indicada
	*/
	@Override
	public int getStatus() {
		return _lojaIndicada.getStatus();
	}

	/**
	* Returns the trash entry created when this loja indicada was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this loja indicada.
	*
	* @return the trash entry created when this loja indicada was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lojaIndicada.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this loja indicada.
	*
	* @return the class primary key of the trash entry for this loja indicada
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _lojaIndicada.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this loja indicada.
	*
	* @return the trash handler for this loja indicada
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _lojaIndicada.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this loja indicada is in the Recycle Bin.
	*
	* @return <code>true</code> if this loja indicada is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _lojaIndicada.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this loja indicada is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this loja indicada is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _lojaIndicada.isInTrashContainer();
	}

	@Override
	public boolean isNew() {
		return _lojaIndicada.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lojaIndicada.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lojaIndicada.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lojaIndicada.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lojaIndicada.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lojaIndicada.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lojaIndicada.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lojaIndicada.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lojaIndicada.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lojaIndicada.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lojaIndicada.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LojaIndicadaWrapper((LojaIndicada)_lojaIndicada.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada) {
		return _lojaIndicada.compareTo(lojaIndicada);
	}

	@Override
	public int hashCode() {
		return _lojaIndicada.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada> toCacheModel() {
		return _lojaIndicada.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada toEscapedModel() {
		return new LojaIndicadaWrapper(_lojaIndicada.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada toUnescapedModel() {
		return new LojaIndicadaWrapper(_lojaIndicada.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lojaIndicada.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lojaIndicada.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lojaIndicada.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LojaIndicadaWrapper)) {
			return false;
		}

		LojaIndicadaWrapper lojaIndicadaWrapper = (LojaIndicadaWrapper)obj;

		if (Validator.equals(_lojaIndicada, lojaIndicadaWrapper._lojaIndicada)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _lojaIndicada.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LojaIndicada getWrappedLojaIndicada() {
		return _lojaIndicada;
	}

	@Override
	public LojaIndicada getWrappedModel() {
		return _lojaIndicada;
	}

	@Override
	public void resetOriginalValues() {
		_lojaIndicada.resetOriginalValues();
	}

	private LojaIndicada _lojaIndicada;
}