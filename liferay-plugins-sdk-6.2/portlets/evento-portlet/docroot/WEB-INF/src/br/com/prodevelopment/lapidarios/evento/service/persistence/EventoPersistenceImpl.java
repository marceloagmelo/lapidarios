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

package br.com.prodevelopment.lapidarios.evento.service.persistence;

import br.com.prodevelopment.lapidarios.evento.NoSuchEventoException;
import br.com.prodevelopment.lapidarios.evento.model.Evento;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoImpl;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoPersistence
 * @see EventoUtil
 * @generated
 */
public class EventoPersistenceImpl extends BasePersistenceImpl<Evento>
	implements EventoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventoUtil} to access the evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EventoModelImpl.UUID_COLUMN_BITMASK |
			EventoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Evento evento : list) {
				if (!Validator.equals(uuid, evento.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EVENTO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByUuid_First(uuid, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the first evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Evento> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByUuid_Last(uuid, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the last evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Evento> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eventos before and after the current evento in the ordered set where uuid = &#63;.
	 *
	 * @param eventoId the primary key of the current evento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento[] findByUuid_PrevAndNext(long eventoId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			Evento[] array = new EventoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, evento, uuid,
					orderByComparator, true);

			array[1] = evento;

			array[2] = getByUuid_PrevAndNext(session, evento, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evento getByUuid_PrevAndNext(Session session, Evento evento,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Evento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Evento evento : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "evento.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "evento.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(evento.uuid IS NULL OR evento.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoModelImpl.UUID_COLUMN_BITMASK |
			EventoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the evento where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByUUID_G(String uuid, long groupId)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByUUID_G(uuid, groupId);

		if (evento == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEventoException(msg.toString());
		}

		return evento;
	}

	/**
	 * Returns the evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Evento) {
			Evento evento = (Evento)result;

			if (!Validator.equals(uuid, evento.getUuid()) ||
					(groupId != evento.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Evento> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Evento evento = list.get(0);

					result = evento;

					cacheResult(evento);

					if ((evento.getUuid() == null) ||
							!evento.getUuid().equals(uuid) ||
							(evento.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, evento);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Evento)result;
		}
	}

	/**
	 * Removes the evento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the evento that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByUUID_G(uuid, groupId);

		return remove(evento);
	}

	/**
	 * Returns the number of eventos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "evento.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "evento.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(evento.uuid IS NULL OR evento.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "evento.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoModelImpl.UUID_COLUMN_BITMASK |
			EventoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Evento evento : list) {
				if (!Validator.equals(uuid, evento.getUuid()) ||
						(companyId != evento.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EVENTO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the first evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Evento> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the last evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Evento> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eventos before and after the current evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventoId the primary key of the current evento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento[] findByUuid_C_PrevAndNext(long eventoId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			Evento[] array = new EventoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, evento, uuid,
					companyId, orderByComparator, true);

			array[1] = evento;

			array[2] = getByUuid_C_PrevAndNext(session, evento, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evento getByUuid_C_PrevAndNext(Session session, Evento evento,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Evento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Evento evento : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "evento.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "evento.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(evento.uuid IS NULL OR evento.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "evento.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoModelImpl.GROUPID_COLUMN_BITMASK |
			EventoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the eventos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Evento evento : list) {
				if ((companyId != evento.getCompanyId()) ||
						(groupId != evento.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_First(companyId, groupId, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Evento> list = findByCG(companyId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_Last(companyId, groupId, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Evento> list = findByCG(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param eventoId the primary key of the current evento
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento[] findByCG_PrevAndNext(long eventoId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			Evento[] array = new EventoImpl[3];

			array[0] = getByCG_PrevAndNext(session, evento, companyId, groupId,
					orderByComparator, true);

			array[1] = evento;

			array[2] = getByCG_PrevAndNext(session, evento, companyId, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evento getByCG_PrevAndNext(Session session, Evento evento,
		long companyId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTO_WHERE);

		query.append(_FINDER_COLUMN_CG_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Evento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventos where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (Evento evento : findByCG(companyId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "evento.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "evento.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOME = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_Nome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOME = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_Nome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_Nome(long companyId, long groupId, String nome)
		throws SystemException {
		return findByCG_Nome(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_Nome(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByCG_Nome(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_Nome(long companyId, long groupId,
		String nome, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOME;
		finderArgs = new Object[] {
				companyId, groupId, nome,
				
				start, end, orderByComparator
			};

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Evento evento : list) {
				if ((companyId != evento.getCompanyId()) ||
						(groupId != evento.getGroupId()) ||
						!StringUtil.wildcardMatches(evento.getNome(), nome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_NOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_NOME_GROUPID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_CG_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_CG_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_Nome_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_Nome_First(companyId, groupId, nome,
				orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_Nome_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Evento> list = findByCG_Nome(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_Nome_Last(long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_Nome_Last(companyId, groupId, nome,
				orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_Nome_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Nome(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Evento> list = findByCG_Nome(companyId, groupId, nome, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param eventoId the primary key of the current evento
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento[] findByCG_Nome_PrevAndNext(long eventoId, long companyId,
		long groupId, String nome, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			Evento[] array = new EventoImpl[3];

			array[0] = getByCG_Nome_PrevAndNext(session, evento, companyId,
					groupId, nome, orderByComparator, true);

			array[1] = evento;

			array[2] = getByCG_Nome_PrevAndNext(session, evento, companyId,
					groupId, nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evento getByCG_Nome_PrevAndNext(Session session, Evento evento,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTO_WHERE);

		query.append(_FINDER_COLUMN_CG_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_CG_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_CG_NOME_NOME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Evento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Nome(long companyId, long groupId, String nome)
		throws SystemException {
		for (Evento evento : findByCG_Nome(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Nome(long companyId, long groupId, String nome)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOME;

		Object[] finderArgs = new Object[] { companyId, groupId, nome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_NOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_NOME_GROUPID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_CG_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_CG_NOME_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNome) {
					qPos.add(nome);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_NOME_COMPANYID_2 = "evento.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_NOME_GROUPID_2 = "evento.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_NOME_NOME_1 = "evento.nome LIKE NULL";
	private static final String _FINDER_COLUMN_CG_NOME_NOME_2 = "evento.nome LIKE ?";
	private static final String _FINDER_COLUMN_CG_NOME_NOME_3 = "(evento.nome IS NULL OR evento.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID =
		new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID =
		new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EventoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoModelImpl.GROUPID_COLUMN_BITMASK |
			EventoModelImpl.USERRESPONSAVELID_COLUMN_BITMASK |
			EventoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_RESPONSAVELID = new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @return the matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId) throws SystemException {
		return findByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int start, int end) throws SystemException {
		return findByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID;
			finderArgs = new Object[] { companyId, groupId, userResponsavelId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID;
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelId,
					
					start, end, orderByComparator
				};
		}

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Evento evento : list) {
				if ((companyId != evento.getCompanyId()) ||
						(groupId != evento.getGroupId()) ||
						(userResponsavelId != evento.getUserResponsavelId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userResponsavelId);

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_ResponsavelId_First(long companyId, long groupId,
		long userResponsavelId, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_ResponsavelId_First(companyId, groupId,
				userResponsavelId, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelId=");
		msg.append(userResponsavelId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_ResponsavelId_First(long companyId, long groupId,
		long userResponsavelId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Evento> list = findByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_ResponsavelId_Last(long companyId, long groupId,
		long userResponsavelId, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_ResponsavelId_Last(companyId, groupId,
				userResponsavelId, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelId=");
		msg.append(userResponsavelId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_ResponsavelId_Last(long companyId, long groupId,
		long userResponsavelId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_ResponsavelId(companyId, groupId,
				userResponsavelId);

		if (count == 0) {
			return null;
		}

		List<Evento> list = findByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param eventoId the primary key of the current evento
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento[] findByCG_ResponsavelId_PrevAndNext(long eventoId,
		long companyId, long groupId, long userResponsavelId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			Evento[] array = new EventoImpl[3];

			array[0] = getByCG_ResponsavelId_PrevAndNext(session, evento,
					companyId, groupId, userResponsavelId, orderByComparator,
					true);

			array[1] = evento;

			array[2] = getByCG_ResponsavelId_PrevAndNext(session, evento,
					companyId, groupId, userResponsavelId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evento getByCG_ResponsavelId_PrevAndNext(Session session,
		Evento evento, long companyId, long groupId, long userResponsavelId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTO_WHERE);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userResponsavelId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Evento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId) throws SystemException {
		for (Evento evento : findByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_RESPONSAVELID;

		Object[] finderArgs = new Object[] { companyId, groupId, userResponsavelId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userResponsavelId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2 = "evento.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2 = "evento.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2 =
		"evento.userResponsavelId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME =
		new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, EventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_ResponsavelNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME =
		new FinderPath(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCG_ResponsavelNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @return the matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome) throws SystemException {
		return findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome, int start, int end)
		throws SystemException {
		return findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME;
		finderArgs = new Object[] {
				companyId, groupId, userResponsavelNome,
				
				start, end, orderByComparator
			};

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Evento evento : list) {
				if ((companyId != evento.getCompanyId()) ||
						(groupId != evento.getGroupId()) ||
						!StringUtil.wildcardMatches(
							evento.getUserResponsavelNome(),
							userResponsavelNome, CharPool.UNDERLINE,
							CharPool.PERCENT, CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_2);

			boolean bindUserResponsavelNome = false;

			if (userResponsavelNome == null) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_1);
			}
			else if (userResponsavelNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_3);
			}
			else {
				bindUserResponsavelNome = true;

				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindUserResponsavelNome) {
					qPos.add(userResponsavelNome);
				}

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_ResponsavelNome_First(long companyId, long groupId,
		String userResponsavelNome, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_ResponsavelNome_First(companyId, groupId,
				userResponsavelNome, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelNome=");
		msg.append(userResponsavelNome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the first evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_ResponsavelNome_First(long companyId, long groupId,
		String userResponsavelNome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Evento> list = findByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByCG_ResponsavelNome_Last(long companyId, long groupId,
		String userResponsavelNome, OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByCG_ResponsavelNome_Last(companyId, groupId,
				userResponsavelNome, orderByComparator);

		if (evento != null) {
			return evento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelNome=");
		msg.append(userResponsavelNome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoException(msg.toString());
	}

	/**
	 * Returns the last evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento, or <code>null</code> if a matching evento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByCG_ResponsavelNome_Last(long companyId, long groupId,
		String userResponsavelNome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome);

		if (count == 0) {
			return null;
		}

		List<Evento> list = findByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eventos before and after the current evento in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param eventoId the primary key of the current evento
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento[] findByCG_ResponsavelNome_PrevAndNext(long eventoId,
		long companyId, long groupId, String userResponsavelNome,
		OrderByComparator orderByComparator)
		throws NoSuchEventoException, SystemException {
		Evento evento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			Evento[] array = new EventoImpl[3];

			array[0] = getByCG_ResponsavelNome_PrevAndNext(session, evento,
					companyId, groupId, userResponsavelNome, orderByComparator,
					true);

			array[1] = evento;

			array[2] = getByCG_ResponsavelNome_PrevAndNext(session, evento,
					companyId, groupId, userResponsavelNome, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evento getByCG_ResponsavelNome_PrevAndNext(Session session,
		Evento evento, long companyId, long groupId,
		String userResponsavelNome, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTO_WHERE);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_2);

		boolean bindUserResponsavelNome = false;

		if (userResponsavelNome == null) {
			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_1);
		}
		else if (userResponsavelNome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_3);
		}
		else {
			bindUserResponsavelNome = true;

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindUserResponsavelNome) {
			qPos.add(userResponsavelNome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Evento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome) throws SystemException {
		for (Evento evento : findByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @return the number of matching eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME;

		Object[] finderArgs = new Object[] {
				companyId, groupId, userResponsavelNome
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTO_WHERE);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_2);

			boolean bindUserResponsavelNome = false;

			if (userResponsavelNome == null) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_1);
			}
			else if (userResponsavelNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_3);
			}
			else {
				bindUserResponsavelNome = true;

				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindUserResponsavelNome) {
					qPos.add(userResponsavelNome);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_2 = "evento.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_2 = "evento.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_1 =
		"evento.userResponsavelNome LIKE NULL";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_2 =
		"evento.userResponsavelNome LIKE ?";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_3 =
		"(evento.userResponsavelNome IS NULL OR evento.userResponsavelNome LIKE '')";

	public EventoPersistenceImpl() {
		setModelClass(Evento.class);
	}

	/**
	 * Caches the evento in the entity cache if it is enabled.
	 *
	 * @param evento the evento
	 */
	@Override
	public void cacheResult(Evento evento) {
		EntityCacheUtil.putResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoImpl.class, evento.getPrimaryKey(), evento);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { evento.getUuid(), evento.getGroupId() }, evento);

		evento.resetOriginalValues();
	}

	/**
	 * Caches the eventos in the entity cache if it is enabled.
	 *
	 * @param eventos the eventos
	 */
	@Override
	public void cacheResult(List<Evento> eventos) {
		for (Evento evento : eventos) {
			if (EntityCacheUtil.getResult(
						EventoModelImpl.ENTITY_CACHE_ENABLED, EventoImpl.class,
						evento.getPrimaryKey()) == null) {
				cacheResult(evento);
			}
			else {
				evento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eventos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Evento evento) {
		EntityCacheUtil.removeResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoImpl.class, evento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(evento);
	}

	@Override
	public void clearCache(List<Evento> eventos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Evento evento : eventos) {
			EntityCacheUtil.removeResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
				EventoImpl.class, evento.getPrimaryKey());

			clearUniqueFindersCache(evento);
		}
	}

	protected void cacheUniqueFindersCache(Evento evento) {
		if (evento.isNew()) {
			Object[] args = new Object[] { evento.getUuid(), evento.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, evento);
		}
		else {
			EventoModelImpl eventoModelImpl = (EventoModelImpl)evento;

			if ((eventoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						evento.getUuid(), evento.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					evento);
			}
		}
	}

	protected void clearUniqueFindersCache(Evento evento) {
		EventoModelImpl eventoModelImpl = (EventoModelImpl)evento;

		Object[] args = new Object[] { evento.getUuid(), evento.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((eventoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventoModelImpl.getOriginalUuid(),
					eventoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new evento with the primary key. Does not add the evento to the database.
	 *
	 * @param eventoId the primary key for the new evento
	 * @return the new evento
	 */
	@Override
	public Evento create(long eventoId) {
		Evento evento = new EventoImpl();

		evento.setNew(true);
		evento.setPrimaryKey(eventoId);

		String uuid = PortalUUIDUtil.generate();

		evento.setUuid(uuid);

		return evento;
	}

	/**
	 * Removes the evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoId the primary key of the evento
	 * @return the evento that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento remove(long eventoId)
		throws NoSuchEventoException, SystemException {
		return remove((Serializable)eventoId);
	}

	/**
	 * Removes the evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evento
	 * @return the evento that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento remove(Serializable primaryKey)
		throws NoSuchEventoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Evento evento = (Evento)session.get(EventoImpl.class, primaryKey);

			if (evento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(evento);
		}
		catch (NoSuchEventoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Evento removeImpl(Evento evento) throws SystemException {
		evento = toUnwrappedModel(evento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(evento)) {
				evento = (Evento)session.get(EventoImpl.class,
						evento.getPrimaryKeyObj());
			}

			if (evento != null) {
				session.delete(evento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (evento != null) {
			clearCache(evento);
		}

		return evento;
	}

	@Override
	public Evento updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.Evento evento)
		throws SystemException {
		evento = toUnwrappedModel(evento);

		boolean isNew = evento.isNew();

		EventoModelImpl eventoModelImpl = (EventoModelImpl)evento;

		if (Validator.isNull(evento.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			evento.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (evento.isNew()) {
				session.save(evento);

				evento.setNew(false);
			}
			else {
				session.merge(evento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { eventoModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { eventoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((eventoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoModelImpl.getOriginalUuid(),
						eventoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						eventoModelImpl.getUuid(),
						eventoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((eventoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoModelImpl.getOriginalCompanyId(),
						eventoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						eventoModelImpl.getCompanyId(),
						eventoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}

			if ((eventoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoModelImpl.getOriginalCompanyId(),
						eventoModelImpl.getOriginalGroupId(),
						eventoModelImpl.getOriginalUserResponsavelId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_RESPONSAVELID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID,
					args);

				args = new Object[] {
						eventoModelImpl.getCompanyId(),
						eventoModelImpl.getGroupId(),
						eventoModelImpl.getUserResponsavelId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_RESPONSAVELID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID,
					args);
			}
		}

		EntityCacheUtil.putResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
			EventoImpl.class, evento.getPrimaryKey(), evento);

		clearUniqueFindersCache(evento);
		cacheUniqueFindersCache(evento);

		return evento;
	}

	protected Evento toUnwrappedModel(Evento evento) {
		if (evento instanceof EventoImpl) {
			return evento;
		}

		EventoImpl eventoImpl = new EventoImpl();

		eventoImpl.setNew(evento.isNew());
		eventoImpl.setPrimaryKey(evento.getPrimaryKey());

		eventoImpl.setUuid(evento.getUuid());
		eventoImpl.setEventoId(evento.getEventoId());
		eventoImpl.setCompanyId(evento.getCompanyId());
		eventoImpl.setGroupId(evento.getGroupId());
		eventoImpl.setCreateUserId(evento.getCreateUserId());
		eventoImpl.setModifiedUserId(evento.getModifiedUserId());
		eventoImpl.setCreateDate(evento.getCreateDate());
		eventoImpl.setModifiedDate(evento.getModifiedDate());
		eventoImpl.setNome(evento.getNome());
		eventoImpl.setDescricao(evento.getDescricao());
		eventoImpl.setUserResponsavelId(evento.getUserResponsavelId());
		eventoImpl.setUserResponsavelNome(evento.getUserResponsavelNome());
		eventoImpl.setVersao(evento.getVersao());
		eventoImpl.setImagemId(evento.getImagemId());
		eventoImpl.setArticleId(evento.getArticleId());

		return eventoImpl;
	}

	/**
	 * Returns the evento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento
	 * @return the evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventoException, SystemException {
		Evento evento = fetchByPrimaryKey(primaryKey);

		if (evento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return evento;
	}

	/**
	 * Returns the evento with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoException} if it could not be found.
	 *
	 * @param eventoId the primary key of the evento
	 * @return the evento
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoException if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento findByPrimaryKey(long eventoId)
		throws NoSuchEventoException, SystemException {
		return findByPrimaryKey((Serializable)eventoId);
	}

	/**
	 * Returns the evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento
	 * @return the evento, or <code>null</code> if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Evento evento = (Evento)EntityCacheUtil.getResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
				EventoImpl.class, primaryKey);

		if (evento == _nullEvento) {
			return null;
		}

		if (evento == null) {
			Session session = null;

			try {
				session = openSession();

				evento = (Evento)session.get(EventoImpl.class, primaryKey);

				if (evento != null) {
					cacheResult(evento);
				}
				else {
					EntityCacheUtil.putResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
						EventoImpl.class, primaryKey, _nullEvento);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventoModelImpl.ENTITY_CACHE_ENABLED,
					EventoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return evento;
	}

	/**
	 * Returns the evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the evento
	 * @return the evento, or <code>null</code> if a evento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Evento fetchByPrimaryKey(long eventoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)eventoId);
	}

	/**
	 * Returns all the eventos.
	 *
	 * @return the eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @return the range of eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eventos
	 * @param end the upper bound of the range of eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Evento> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Evento> list = (List<Evento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTO;

				if (pagination) {
					sql = sql.concat(EventoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Evento>(list);
				}
				else {
					list = (List<Evento>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the eventos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Evento evento : findAll()) {
			remove(evento);
		}
	}

	/**
	 * Returns the number of eventos.
	 *
	 * @return the number of eventos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the evento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.lapidarios.evento.model.Evento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Evento>> listenersList = new ArrayList<ModelListener<Evento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Evento>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EventoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTO = "SELECT evento FROM Evento evento";
	private static final String _SQL_SELECT_EVENTO_WHERE = "SELECT evento FROM Evento evento WHERE ";
	private static final String _SQL_COUNT_EVENTO = "SELECT COUNT(evento) FROM Evento evento";
	private static final String _SQL_COUNT_EVENTO_WHERE = "SELECT COUNT(evento) FROM Evento evento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "evento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Evento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Evento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Evento _nullEvento = new EventoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Evento> toCacheModel() {
				return _nullEventoCacheModel;
			}
		};

	private static CacheModel<Evento> _nullEventoCacheModel = new CacheModel<Evento>() {
			@Override
			public Evento toEntityModel() {
				return _nullEvento;
			}
		};
}