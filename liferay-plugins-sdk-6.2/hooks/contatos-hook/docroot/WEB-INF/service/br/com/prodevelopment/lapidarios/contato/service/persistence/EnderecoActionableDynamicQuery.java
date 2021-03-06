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

package br.com.prodevelopment.lapidarios.contato.service.persistence;

import br.com.prodevelopment.lapidarios.contato.model.Endereco;
import br.com.prodevelopment.lapidarios.contato.service.EnderecoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Marcelo Melo
 * @generated
 */
public abstract class EnderecoActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public EnderecoActionableDynamicQuery() throws SystemException {
		setBaseLocalService(EnderecoLocalServiceUtil.getService());
		setClass(Endereco.class);

		setClassLoader(br.com.prodevelopment.lapidarios.contato.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("enderecoId");
	}
}