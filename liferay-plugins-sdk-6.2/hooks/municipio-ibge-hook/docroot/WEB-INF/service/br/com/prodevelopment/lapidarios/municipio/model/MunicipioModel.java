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

package br.com.prodevelopment.lapidarios.municipio.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Municipio service. Represents a row in the &quot;municipio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Municipio
 * @see br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioImpl
 * @see br.com.prodevelopment.lapidarios.municipio.model.impl.MunicipioModelImpl
 * @generated
 */
public interface MunicipioModel extends BaseModel<Municipio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a municipio model instance should use the {@link Municipio} interface instead.
	 */

	/**
	 * Returns the primary key of this municipio.
	 *
	 * @return the primary key of this municipio
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this municipio.
	 *
	 * @param primaryKey the primary key of this municipio
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the codigo of this municipio.
	 *
	 * @return the codigo of this municipio
	 */
	public long getCodigo();

	/**
	 * Sets the codigo of this municipio.
	 *
	 * @param codigo the codigo of this municipio
	 */
	public void setCodigo(long codigo);

	/**
	 * Returns the uf of this municipio.
	 *
	 * @return the uf of this municipio
	 */
	@AutoEscape
	public String getUf();

	/**
	 * Sets the uf of this municipio.
	 *
	 * @param uf the uf of this municipio
	 */
	public void setUf(String uf);

	/**
	 * Returns the cidade of this municipio.
	 *
	 * @return the cidade of this municipio
	 */
	@AutoEscape
	public String getCidade();

	/**
	 * Sets the cidade of this municipio.
	 *
	 * @param cidade the cidade of this municipio
	 */
	public void setCidade(String cidade);

	/**
	 * Returns the bairro of this municipio.
	 *
	 * @return the bairro of this municipio
	 */
	@AutoEscape
	public String getBairro();

	/**
	 * Sets the bairro of this municipio.
	 *
	 * @param bairro the bairro of this municipio
	 */
	public void setBairro(String bairro);

	/**
	 * Returns the logradouro of this municipio.
	 *
	 * @return the logradouro of this municipio
	 */
	@AutoEscape
	public String getLogradouro();

	/**
	 * Sets the logradouro of this municipio.
	 *
	 * @param logradouro the logradouro of this municipio
	 */
	public void setLogradouro(String logradouro);

	/**
	 * Returns the cep of this municipio.
	 *
	 * @return the cep of this municipio
	 */
	@AutoEscape
	public String getCep();

	/**
	 * Sets the cep of this municipio.
	 *
	 * @param cep the cep of this municipio
	 */
	public void setCep(String cep);

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
		br.com.prodevelopment.lapidarios.municipio.model.Municipio municipio);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.prodevelopment.lapidarios.municipio.model.Municipio> toCacheModel();

	@Override
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio toEscapedModel();

	@Override
	public br.com.prodevelopment.lapidarios.municipio.model.Municipio toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}