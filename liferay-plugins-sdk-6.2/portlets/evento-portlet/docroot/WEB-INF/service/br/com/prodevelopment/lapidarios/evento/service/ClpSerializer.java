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

package br.com.prodevelopment.lapidarios.evento.service;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgendaClp;
import br.com.prodevelopment.lapidarios.evento.model.EventoClp;
import br.com.prodevelopment.lapidarios.evento.model.EventoInscricaoClp;
import br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscritoClp;
import br.com.prodevelopment.lapidarios.evento.model.LocalClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelo Melo
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"evento-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"evento-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "evento-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EventoClp.class.getName())) {
			return translateInputEvento(oldModel);
		}

		if (oldModelClassName.equals(EventoAgendaClp.class.getName())) {
			return translateInputEventoAgenda(oldModel);
		}

		if (oldModelClassName.equals(EventoInscricaoClp.class.getName())) {
			return translateInputEventoInscricao(oldModel);
		}

		if (oldModelClassName.equals(EventoNaoInscritoClp.class.getName())) {
			return translateInputEventoNaoInscrito(oldModel);
		}

		if (oldModelClassName.equals(LocalClp.class.getName())) {
			return translateInputLocal(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputEvento(BaseModel<?> oldModel) {
		EventoClp oldClpModel = (EventoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEventoAgenda(BaseModel<?> oldModel) {
		EventoAgendaClp oldClpModel = (EventoAgendaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventoAgendaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEventoInscricao(BaseModel<?> oldModel) {
		EventoInscricaoClp oldClpModel = (EventoInscricaoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventoInscricaoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEventoNaoInscrito(BaseModel<?> oldModel) {
		EventoNaoInscritoClp oldClpModel = (EventoNaoInscritoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventoNaoInscritoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocal(BaseModel<?> oldModel) {
		LocalClp oldClpModel = (LocalClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocalRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"br.com.prodevelopment.lapidarios.evento.model.impl.EventoImpl")) {
			return translateOutputEvento(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaImpl")) {
			return translateOutputEventoAgenda(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoImpl")) {
			return translateOutputEventoInscricao(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoImpl")) {
			return translateOutputEventoNaoInscrito(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.lapidarios.evento.model.impl.LocalImpl")) {
			return translateOutputLocal(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoAgendaAlteradoOutroUsuarioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoAgendaAlteradoOutroUsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoAgendaObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoAgendaObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoAgendaResponsavelObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoAgendaResponsavelObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoAlteradoOutroUsuarioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoAlteradoOutroUsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoDataInvalidaException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoDataInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoDataMenorHojeException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoDataMenorHojeException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoDataObrigatoriaException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoDataObrigatoriaException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoLocalObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoLocalObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoNaoEncontradoException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoNaoEncontradoException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoNomeObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoNomeObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasObrigatoriaException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasObrigatoriaException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasPreenchidaException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoQtdeVagasPreenchidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.EventoResponsavelObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.EventoResponsavelObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.LocalAlteradoOutroUsuarioException")) {
			return new br.com.prodevelopment.lapidarios.evento.LocalAlteradoOutroUsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.LocalNomeObrigatorioException")) {
			return new br.com.prodevelopment.lapidarios.evento.LocalNomeObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.NoSuchEventoException")) {
			return new br.com.prodevelopment.lapidarios.evento.NoSuchEventoException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException")) {
			return new br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException")) {
			return new br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException")) {
			return new br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException();
		}

		if (className.equals(
					"br.com.prodevelopment.lapidarios.evento.NoSuchLocalException")) {
			return new br.com.prodevelopment.lapidarios.evento.NoSuchLocalException();
		}

		return throwable;
	}

	public static Object translateOutputEvento(BaseModel<?> oldModel) {
		EventoClp newModel = new EventoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEventoAgenda(BaseModel<?> oldModel) {
		EventoAgendaClp newModel = new EventoAgendaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventoAgendaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEventoInscricao(BaseModel<?> oldModel) {
		EventoInscricaoClp newModel = new EventoInscricaoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventoInscricaoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEventoNaoInscrito(BaseModel<?> oldModel) {
		EventoNaoInscritoClp newModel = new EventoNaoInscritoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventoNaoInscritoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocal(BaseModel<?> oldModel) {
		LocalClp newModel = new LocalClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocalRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}