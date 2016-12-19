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

package br.com.prodevelopment.lapidarios.loja.model.impl;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Loja service. Represents a row in the &quot;loja&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LojaImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaImpl
 * @see br.com.prodevelopment.lapidarios.loja.model.Loja
 * @generated
 */
public abstract class LojaBaseImpl extends LojaModelImpl implements Loja {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a loja model instance should use the {@link Loja} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LojaLocalServiceUtil.addLoja(this);
		}
		else {
			LojaLocalServiceUtil.updateLoja(this);
		}
	}
}