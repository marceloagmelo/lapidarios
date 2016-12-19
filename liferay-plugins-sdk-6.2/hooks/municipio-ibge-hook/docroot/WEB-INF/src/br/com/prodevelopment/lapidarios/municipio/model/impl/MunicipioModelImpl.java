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

package br.com.prodevelopment.lapidarios.municipio.model.impl;

import br.com.prodevelopment.lapidarios.municipio.model.Municipio;
import br.com.prodevelopment.lapidarios.municipio.model.MunicipioModel;
import br.com.prodevelopment.lapidarios.municipio.model.MunicipioSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Municipio service. Represents a row in the &quot;municipio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.com.prodevelopment.lapidarios.municipio.model.MunicipioModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MunicipioImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see MunicipioImpl
 * @see br.com.prodevelopment.lapidarios.municipio.model.Municipio
 * @see br.com.prodevelopment.lapidarios.municipio.model.MunicipioModel
 * @generated
 */
@JSON(strict = true)
public class MunicipioModelImpl extends BaseModelImpl<Municipio>
	implements MunicipioModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a municipio model instance should use the {@link br.com.prodevelopment.lapidarios.municipio.model.Municipio} interface instead.
	 */
	public static final String TABLE_NAME = "municipio";
	public static final Object[][] TABLE_COLUMNS = {
			{ "codigo", Types.BIGINT },
			{ "uf", Types.VARCHAR },
			{ "cidade", Types.VARCHAR },
			{ "bairro", Types.VARCHAR },
			{ "logradouro", Types.VARCHAR },
			{ "cep", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table municipio (codigo LONG not null primary key,uf VARCHAR(2) null,cidade VARCHAR(75) null,bairro VARCHAR(75) null,logradouro VARCHAR(200) null,cep VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table municipio";
	public static final String ORDER_BY_JPQL = " ORDER BY municipio.cidade ASC";
	public static final String ORDER_BY_SQL = " ORDER BY municipio.cidade ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.br.com.prodevelopment.lapidarios.municipio.model.Municipio"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.br.com.prodevelopment.lapidarios.municipio.model.Municipio"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.br.com.prodevelopment.lapidarios.municipio.model.Municipio"),
			true);
	public static long CIDADE_COLUMN_BITMASK = 1L;
	public static long UF_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Municipio toModel(MunicipioSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Municipio model = new MunicipioImpl();

		model.setCodigo(soapModel.getCodigo());
		model.setUf(soapModel.getUf());
		model.setCidade(soapModel.getCidade());
		model.setBairro(soapModel.getBairro());
		model.setLogradouro(soapModel.getLogradouro());
		model.setCep(soapModel.getCep());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Municipio> toModels(MunicipioSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Municipio> models = new ArrayList<Municipio>(soapModels.length);

		for (MunicipioSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.br.com.prodevelopment.lapidarios.municipio.model.Municipio"));

	public MunicipioModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _codigo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCodigo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codigo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Municipio.class;
	}

	@Override
	public String getModelClassName() {
		return Municipio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codigo", getCodigo());
		attributes.put("uf", getUf());
		attributes.put("cidade", getCidade());
		attributes.put("bairro", getBairro());
		attributes.put("logradouro", getLogradouro());
		attributes.put("cep", getCep());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long codigo = (Long)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String uf = (String)attributes.get("uf");

		if (uf != null) {
			setUf(uf);
		}

		String cidade = (String)attributes.get("cidade");

		if (cidade != null) {
			setCidade(cidade);
		}

		String bairro = (String)attributes.get("bairro");

		if (bairro != null) {
			setBairro(bairro);
		}

		String logradouro = (String)attributes.get("logradouro");

		if (logradouro != null) {
			setLogradouro(logradouro);
		}

		String cep = (String)attributes.get("cep");

		if (cep != null) {
			setCep(cep);
		}
	}

	@JSON
	@Override
	public long getCodigo() {
		return _codigo;
	}

	@Override
	public void setCodigo(long codigo) {
		_codigo = codigo;
	}

	@JSON
	@Override
	public String getUf() {
		if (_uf == null) {
			return StringPool.BLANK;
		}
		else {
			return _uf;
		}
	}

	@Override
	public void setUf(String uf) {
		_columnBitmask |= UF_COLUMN_BITMASK;

		if (_originalUf == null) {
			_originalUf = _uf;
		}

		_uf = uf;
	}

	public String getOriginalUf() {
		return GetterUtil.getString(_originalUf);
	}

	@JSON
	@Override
	public String getCidade() {
		if (_cidade == null) {
			return StringPool.BLANK;
		}
		else {
			return _cidade;
		}
	}

	@Override
	public void setCidade(String cidade) {
		_columnBitmask = -1L;

		if (_originalCidade == null) {
			_originalCidade = _cidade;
		}

		_cidade = cidade;
	}

	public String getOriginalCidade() {
		return GetterUtil.getString(_originalCidade);
	}

	@JSON
	@Override
	public String getBairro() {
		if (_bairro == null) {
			return StringPool.BLANK;
		}
		else {
			return _bairro;
		}
	}

	@Override
	public void setBairro(String bairro) {
		_bairro = bairro;
	}

	@JSON
	@Override
	public String getLogradouro() {
		if (_logradouro == null) {
			return StringPool.BLANK;
		}
		else {
			return _logradouro;
		}
	}

	@Override
	public void setLogradouro(String logradouro) {
		_logradouro = logradouro;
	}

	@JSON
	@Override
	public String getCep() {
		if (_cep == null) {
			return StringPool.BLANK;
		}
		else {
			return _cep;
		}
	}

	@Override
	public void setCep(String cep) {
		_cep = cep;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Municipio.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Municipio toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Municipio)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MunicipioImpl municipioImpl = new MunicipioImpl();

		municipioImpl.setCodigo(getCodigo());
		municipioImpl.setUf(getUf());
		municipioImpl.setCidade(getCidade());
		municipioImpl.setBairro(getBairro());
		municipioImpl.setLogradouro(getLogradouro());
		municipioImpl.setCep(getCep());

		municipioImpl.resetOriginalValues();

		return municipioImpl;
	}

	@Override
	public int compareTo(Municipio municipio) {
		int value = 0;

		value = getCidade().compareTo(municipio.getCidade());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Municipio)) {
			return false;
		}

		Municipio municipio = (Municipio)obj;

		long primaryKey = municipio.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		MunicipioModelImpl municipioModelImpl = this;

		municipioModelImpl._originalUf = municipioModelImpl._uf;

		municipioModelImpl._originalCidade = municipioModelImpl._cidade;

		municipioModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Municipio> toCacheModel() {
		MunicipioCacheModel municipioCacheModel = new MunicipioCacheModel();

		municipioCacheModel.codigo = getCodigo();

		municipioCacheModel.uf = getUf();

		String uf = municipioCacheModel.uf;

		if ((uf != null) && (uf.length() == 0)) {
			municipioCacheModel.uf = null;
		}

		municipioCacheModel.cidade = getCidade();

		String cidade = municipioCacheModel.cidade;

		if ((cidade != null) && (cidade.length() == 0)) {
			municipioCacheModel.cidade = null;
		}

		municipioCacheModel.bairro = getBairro();

		String bairro = municipioCacheModel.bairro;

		if ((bairro != null) && (bairro.length() == 0)) {
			municipioCacheModel.bairro = null;
		}

		municipioCacheModel.logradouro = getLogradouro();

		String logradouro = municipioCacheModel.logradouro;

		if ((logradouro != null) && (logradouro.length() == 0)) {
			municipioCacheModel.logradouro = null;
		}

		municipioCacheModel.cep = getCep();

		String cep = municipioCacheModel.cep;

		if ((cep != null) && (cep.length() == 0)) {
			municipioCacheModel.cep = null;
		}

		return municipioCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{codigo=");
		sb.append(getCodigo());
		sb.append(", uf=");
		sb.append(getUf());
		sb.append(", cidade=");
		sb.append(getCidade());
		sb.append(", bairro=");
		sb.append(getBairro());
		sb.append(", logradouro=");
		sb.append(getLogradouro());
		sb.append(", cep=");
		sb.append(getCep());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.lapidarios.municipio.model.Municipio");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codigo</column-name><column-value><![CDATA[");
		sb.append(getCodigo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uf</column-name><column-value><![CDATA[");
		sb.append(getUf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cidade</column-name><column-value><![CDATA[");
		sb.append(getCidade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bairro</column-name><column-value><![CDATA[");
		sb.append(getBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logradouro</column-name><column-value><![CDATA[");
		sb.append(getLogradouro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cep</column-name><column-value><![CDATA[");
		sb.append(getCep());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Municipio.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Municipio.class
		};
	private long _codigo;
	private String _uf;
	private String _originalUf;
	private String _cidade;
	private String _originalCidade;
	private String _bairro;
	private String _logradouro;
	private String _cep;
	private long _columnBitmask;
	private Municipio _escapedModel;
}