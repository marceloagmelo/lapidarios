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

package br.com.prodevelopment.lapidarios.contato.model.impl;

import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.model.ContatoModel;
import br.com.prodevelopment.lapidarios.contato.model.ContatoSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Contato service. Represents a row in the &quot;contato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.com.prodevelopment.lapidarios.contato.model.ContatoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContatoImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see ContatoImpl
 * @see br.com.prodevelopment.lapidarios.contato.model.Contato
 * @see br.com.prodevelopment.lapidarios.contato.model.ContatoModel
 * @generated
 */
@JSON(strict = true)
public class ContatoModelImpl extends BaseModelImpl<Contato>
	implements ContatoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a contato model instance should use the {@link br.com.prodevelopment.lapidarios.contato.model.Contato} interface instead.
	 */
	public static final String TABLE_NAME = "contato";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contatoId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createUserId", Types.BIGINT },
			{ "modifiedUserId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "accountId", Types.BIGINT },
			{ "endEmail", Types.VARCHAR },
			{ "nome", Types.VARCHAR },
			{ "sexo", Types.VARCHAR },
			{ "dataNascimento", Types.TIMESTAMP },
			{ "cargoId", Types.BIGINT },
			{ "skype", Types.VARCHAR },
			{ "facebook", Types.VARCHAR },
			{ "twitter", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table contato (contatoId LONG not null primary key,companyId LONG,groupId LONG,createUserId LONG,modifiedUserId LONG,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,accountId LONG,endEmail VARCHAR(75) null,nome VARCHAR(100) null,sexo VARCHAR(1) null,dataNascimento DATE null,cargoId LONG,skype VARCHAR(100) null,facebook VARCHAR(100) null,twitter VARCHAR(100) null)";
	public static final String TABLE_SQL_DROP = "drop table contato";
	public static final String ORDER_BY_JPQL = " ORDER BY contato.nome ASC";
	public static final String ORDER_BY_SQL = " ORDER BY contato.nome ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.br.com.prodevelopment.lapidarios.contato.model.Contato"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.br.com.prodevelopment.lapidarios.contato.model.Contato"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.br.com.prodevelopment.lapidarios.contato.model.Contato"),
			true);
	public static long ACCOUNTID_COLUMN_BITMASK = 1L;
	public static long CARGOID_COLUMN_BITMASK = 2L;
	public static long CLASSNAMEID_COLUMN_BITMASK = 4L;
	public static long CLASSPK_COLUMN_BITMASK = 8L;
	public static long COMPANYID_COLUMN_BITMASK = 16L;
	public static long DATANASCIMENTO_COLUMN_BITMASK = 32L;
	public static long ENDEMAIL_COLUMN_BITMASK = 64L;
	public static long GROUPID_COLUMN_BITMASK = 128L;
	public static long NOME_COLUMN_BITMASK = 256L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Contato toModel(ContatoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Contato model = new ContatoImpl();

		model.setContatoId(soapModel.getContatoId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setCreateUserId(soapModel.getCreateUserId());
		model.setModifiedUserId(soapModel.getModifiedUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setAccountId(soapModel.getAccountId());
		model.setEndEmail(soapModel.getEndEmail());
		model.setNome(soapModel.getNome());
		model.setSexo(soapModel.getSexo());
		model.setDataNascimento(soapModel.getDataNascimento());
		model.setCargoId(soapModel.getCargoId());
		model.setSkype(soapModel.getSkype());
		model.setFacebook(soapModel.getFacebook());
		model.setTwitter(soapModel.getTwitter());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Contato> toModels(ContatoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Contato> models = new ArrayList<Contato>(soapModels.length);

		for (ContatoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.br.com.prodevelopment.lapidarios.contato.model.Contato"));

	public ContatoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _contatoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContatoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contatoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Contato.class;
	}

	@Override
	public String getModelClassName() {
		return Contato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contatoId", getContatoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("accountId", getAccountId());
		attributes.put("endEmail", getEndEmail());
		attributes.put("nome", getNome());
		attributes.put("sexo", getSexo());
		attributes.put("dataNascimento", getDataNascimento());
		attributes.put("cargoId", getCargoId());
		attributes.put("skype", getSkype());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contatoId = (Long)attributes.get("contatoId");

		if (contatoId != null) {
			setContatoId(contatoId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String endEmail = (String)attributes.get("endEmail");

		if (endEmail != null) {
			setEndEmail(endEmail);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		Date dataNascimento = (Date)attributes.get("dataNascimento");

		if (dataNascimento != null) {
			setDataNascimento(dataNascimento);
		}

		Long cargoId = (Long)attributes.get("cargoId");

		if (cargoId != null) {
			setCargoId(cargoId);
		}

		String skype = (String)attributes.get("skype");

		if (skype != null) {
			setSkype(skype);
		}

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}
	}

	@JSON
	@Override
	public long getContatoId() {
		return _contatoId;
	}

	@Override
	public void setContatoId(long contatoId) {
		_contatoId = contatoId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	@Override
	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	@Override
	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
	}

	@JSON
	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_columnBitmask |= ACCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalAccountId) {
			_setOriginalAccountId = true;

			_originalAccountId = _accountId;
		}

		_accountId = accountId;
	}

	public long getOriginalAccountId() {
		return _originalAccountId;
	}

	@JSON
	@Override
	public String getEndEmail() {
		if (_endEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _endEmail;
		}
	}

	@Override
	public void setEndEmail(String endEmail) {
		_columnBitmask |= ENDEMAIL_COLUMN_BITMASK;

		if (_originalEndEmail == null) {
			_originalEndEmail = _endEmail;
		}

		_endEmail = endEmail;
	}

	public String getOriginalEndEmail() {
		return GetterUtil.getString(_originalEndEmail);
	}

	@JSON
	@Override
	public String getNome() {
		if (_nome == null) {
			return StringPool.BLANK;
		}
		else {
			return _nome;
		}
	}

	@Override
	public void setNome(String nome) {
		_columnBitmask = -1L;

		if (_originalNome == null) {
			_originalNome = _nome;
		}

		_nome = nome;
	}

	public String getOriginalNome() {
		return GetterUtil.getString(_originalNome);
	}

	@JSON
	@Override
	public String getSexo() {
		if (_sexo == null) {
			return StringPool.BLANK;
		}
		else {
			return _sexo;
		}
	}

	@Override
	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	@JSON
	@Override
	public Date getDataNascimento() {
		return _dataNascimento;
	}

	@Override
	public void setDataNascimento(Date dataNascimento) {
		_columnBitmask |= DATANASCIMENTO_COLUMN_BITMASK;

		if (_originalDataNascimento == null) {
			_originalDataNascimento = _dataNascimento;
		}

		_dataNascimento = dataNascimento;
	}

	public Date getOriginalDataNascimento() {
		return _originalDataNascimento;
	}

	@JSON
	@Override
	public long getCargoId() {
		return _cargoId;
	}

	@Override
	public void setCargoId(long cargoId) {
		_columnBitmask |= CARGOID_COLUMN_BITMASK;

		if (!_setOriginalCargoId) {
			_setOriginalCargoId = true;

			_originalCargoId = _cargoId;
		}

		_cargoId = cargoId;
	}

	public long getOriginalCargoId() {
		return _originalCargoId;
	}

	@JSON
	@Override
	public String getSkype() {
		if (_skype == null) {
			return StringPool.BLANK;
		}
		else {
			return _skype;
		}
	}

	@Override
	public void setSkype(String skype) {
		_skype = skype;
	}

	@JSON
	@Override
	public String getFacebook() {
		if (_facebook == null) {
			return StringPool.BLANK;
		}
		else {
			return _facebook;
		}
	}

	@Override
	public void setFacebook(String facebook) {
		_facebook = facebook;
	}

	@JSON
	@Override
	public String getTwitter() {
		if (_twitter == null) {
			return StringPool.BLANK;
		}
		else {
			return _twitter;
		}
	}

	@Override
	public void setTwitter(String twitter) {
		_twitter = twitter;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Contato.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Contato toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Contato)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ContatoImpl contatoImpl = new ContatoImpl();

		contatoImpl.setContatoId(getContatoId());
		contatoImpl.setCompanyId(getCompanyId());
		contatoImpl.setGroupId(getGroupId());
		contatoImpl.setCreateUserId(getCreateUserId());
		contatoImpl.setModifiedUserId(getModifiedUserId());
		contatoImpl.setCreateDate(getCreateDate());
		contatoImpl.setModifiedDate(getModifiedDate());
		contatoImpl.setClassNameId(getClassNameId());
		contatoImpl.setClassPK(getClassPK());
		contatoImpl.setAccountId(getAccountId());
		contatoImpl.setEndEmail(getEndEmail());
		contatoImpl.setNome(getNome());
		contatoImpl.setSexo(getSexo());
		contatoImpl.setDataNascimento(getDataNascimento());
		contatoImpl.setCargoId(getCargoId());
		contatoImpl.setSkype(getSkype());
		contatoImpl.setFacebook(getFacebook());
		contatoImpl.setTwitter(getTwitter());

		contatoImpl.resetOriginalValues();

		return contatoImpl;
	}

	@Override
	public int compareTo(Contato contato) {
		int value = 0;

		value = getNome().compareTo(contato.getNome());

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

		if (!(obj instanceof Contato)) {
			return false;
		}

		Contato contato = (Contato)obj;

		long primaryKey = contato.getPrimaryKey();

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
		ContatoModelImpl contatoModelImpl = this;

		contatoModelImpl._originalCompanyId = contatoModelImpl._companyId;

		contatoModelImpl._setOriginalCompanyId = false;

		contatoModelImpl._originalGroupId = contatoModelImpl._groupId;

		contatoModelImpl._setOriginalGroupId = false;

		contatoModelImpl._originalClassNameId = contatoModelImpl._classNameId;

		contatoModelImpl._setOriginalClassNameId = false;

		contatoModelImpl._originalClassPK = contatoModelImpl._classPK;

		contatoModelImpl._setOriginalClassPK = false;

		contatoModelImpl._originalAccountId = contatoModelImpl._accountId;

		contatoModelImpl._setOriginalAccountId = false;

		contatoModelImpl._originalEndEmail = contatoModelImpl._endEmail;

		contatoModelImpl._originalNome = contatoModelImpl._nome;

		contatoModelImpl._originalDataNascimento = contatoModelImpl._dataNascimento;

		contatoModelImpl._originalCargoId = contatoModelImpl._cargoId;

		contatoModelImpl._setOriginalCargoId = false;

		contatoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Contato> toCacheModel() {
		ContatoCacheModel contatoCacheModel = new ContatoCacheModel();

		contatoCacheModel.contatoId = getContatoId();

		contatoCacheModel.companyId = getCompanyId();

		contatoCacheModel.groupId = getGroupId();

		contatoCacheModel.createUserId = getCreateUserId();

		contatoCacheModel.modifiedUserId = getModifiedUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			contatoCacheModel.createDate = createDate.getTime();
		}
		else {
			contatoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			contatoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			contatoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		contatoCacheModel.classNameId = getClassNameId();

		contatoCacheModel.classPK = getClassPK();

		contatoCacheModel.accountId = getAccountId();

		contatoCacheModel.endEmail = getEndEmail();

		String endEmail = contatoCacheModel.endEmail;

		if ((endEmail != null) && (endEmail.length() == 0)) {
			contatoCacheModel.endEmail = null;
		}

		contatoCacheModel.nome = getNome();

		String nome = contatoCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			contatoCacheModel.nome = null;
		}

		contatoCacheModel.sexo = getSexo();

		String sexo = contatoCacheModel.sexo;

		if ((sexo != null) && (sexo.length() == 0)) {
			contatoCacheModel.sexo = null;
		}

		Date dataNascimento = getDataNascimento();

		if (dataNascimento != null) {
			contatoCacheModel.dataNascimento = dataNascimento.getTime();
		}
		else {
			contatoCacheModel.dataNascimento = Long.MIN_VALUE;
		}

		contatoCacheModel.cargoId = getCargoId();

		contatoCacheModel.skype = getSkype();

		String skype = contatoCacheModel.skype;

		if ((skype != null) && (skype.length() == 0)) {
			contatoCacheModel.skype = null;
		}

		contatoCacheModel.facebook = getFacebook();

		String facebook = contatoCacheModel.facebook;

		if ((facebook != null) && (facebook.length() == 0)) {
			contatoCacheModel.facebook = null;
		}

		contatoCacheModel.twitter = getTwitter();

		String twitter = contatoCacheModel.twitter;

		if ((twitter != null) && (twitter.length() == 0)) {
			contatoCacheModel.twitter = null;
		}

		return contatoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{contatoId=");
		sb.append(getContatoId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", endEmail=");
		sb.append(getEndEmail());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", sexo=");
		sb.append(getSexo());
		sb.append(", dataNascimento=");
		sb.append(getDataNascimento());
		sb.append(", cargoId=");
		sb.append(getCargoId());
		sb.append(", skype=");
		sb.append(getSkype());
		sb.append(", facebook=");
		sb.append(getFacebook());
		sb.append(", twitter=");
		sb.append(getTwitter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.lapidarios.contato.model.Contato");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contatoId</column-name><column-value><![CDATA[");
		sb.append(getContatoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endEmail</column-name><column-value><![CDATA[");
		sb.append(getEndEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sexo</column-name><column-value><![CDATA[");
		sb.append(getSexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataNascimento</column-name><column-value><![CDATA[");
		sb.append(getDataNascimento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargoId</column-name><column-value><![CDATA[");
		sb.append(getCargoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skype</column-name><column-value><![CDATA[");
		sb.append(getSkype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebook</column-name><column-value><![CDATA[");
		sb.append(getFacebook());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitter</column-name><column-value><![CDATA[");
		sb.append(getTwitter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Contato.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Contato.class
		};
	private long _contatoId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _accountId;
	private long _originalAccountId;
	private boolean _setOriginalAccountId;
	private String _endEmail;
	private String _originalEndEmail;
	private String _nome;
	private String _originalNome;
	private String _sexo;
	private Date _dataNascimento;
	private Date _originalDataNascimento;
	private long _cargoId;
	private long _originalCargoId;
	private boolean _setOriginalCargoId;
	private String _skype;
	private String _facebook;
	private String _twitter;
	private long _columnBitmask;
	private Contato _escapedModel;
}