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

import br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException;
import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaImpl;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the evento agenda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoAgendaPersistence
 * @see EventoAgendaUtil
 * @generated
 */
public class EventoAgendaPersistenceImpl extends BasePersistenceImpl<EventoAgenda>
	implements EventoAgendaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventoAgendaUtil} to access the evento agenda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventoAgendaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EventoAgendaModelImpl.UUID_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the evento agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByUuid(String uuid, int start, int end,
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

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if (!Validator.equals(uuid, eventoAgenda.getUuid())) {
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

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByUuid_First(uuid, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByUuid_Last(uuid, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where uuid = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByUuid_PrevAndNext(long eventoAgendaId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, eventoAgenda, uuid,
					orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByUuid_PrevAndNext(session, eventoAgenda, uuid,
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

	protected EventoAgenda getByUuid_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento agendas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (EventoAgenda eventoAgenda : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching evento agendas
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

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "eventoAgenda.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "eventoAgenda.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(eventoAgenda.uuid IS NULL OR eventoAgenda.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoAgendaModelImpl.UUID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the evento agenda where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByUUID_G(String uuid, long groupId)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByUUID_G(uuid, groupId);

		if (eventoAgenda == null) {
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

			throw new NoSuchEventoAgendaException(msg.toString());
		}

		return eventoAgenda;
	}

	/**
	 * Returns the evento agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the evento agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof EventoAgenda) {
			EventoAgenda eventoAgenda = (EventoAgenda)result;

			if (!Validator.equals(uuid, eventoAgenda.getUuid()) ||
					(groupId != eventoAgenda.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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

				List<EventoAgenda> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					EventoAgenda eventoAgenda = list.get(0);

					result = eventoAgenda;

					cacheResult(eventoAgenda);

					if ((eventoAgenda.getUuid() == null) ||
							!eventoAgenda.getUuid().equals(uuid) ||
							(eventoAgenda.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, eventoAgenda);
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
			return (EventoAgenda)result;
		}
	}

	/**
	 * Removes the evento agenda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the evento agenda that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByUUID_G(uuid, groupId);

		return remove(eventoAgenda);
	}

	/**
	 * Returns the number of evento agendas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching evento agendas
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

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "eventoAgenda.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "eventoAgenda.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(eventoAgenda.uuid IS NULL OR eventoAgenda.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "eventoAgenda.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoAgendaModelImpl.UUID_COLUMN_BITMASK |
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the evento agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if (!Validator.equals(uuid, eventoAgenda.getUuid()) ||
						(companyId != eventoAgenda.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByUuid_C_PrevAndNext(long eventoAgendaId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, eventoAgenda, uuid,
					companyId, orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByUuid_C_PrevAndNext(session, eventoAgenda, uuid,
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

	protected EventoAgenda getByUuid_C_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento agendas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (EventoAgenda eventoAgenda : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching evento agendas
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

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "eventoAgenda.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "eventoAgenda.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(eventoAgenda.uuid IS NULL OR eventoAgenda.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "eventoAgenda.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK |
			EventoAgendaModelImpl.STATUS_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG(long companyId, long groupId, int status)
		throws SystemException {
		return findByCG(companyId, groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG(long companyId, long groupId,
		int status, int start, int end) throws SystemException {
		return findByCG(companyId, groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG(long companyId, long groupId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG;
			finderArgs = new Object[] { companyId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG;
			finderArgs = new Object[] {
					companyId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(status != eventoAgenda.getStatus())) {
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

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_First(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_First(companyId, groupId, status,
				orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_First(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoAgenda> list = findByCG(companyId, groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_Last(long companyId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_Last(companyId, groupId, status,
				orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_Last(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG(companyId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG(companyId, groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_PrevAndNext(long eventoAgendaId,
		long companyId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_PrevAndNext(session, eventoAgenda, companyId,
					groupId, status, orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByCG_PrevAndNext(session, eventoAgenda, companyId,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoAgenda getByCG_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG(long companyId, long groupId,
		int[] statuses) throws SystemException {
		return findByCG(companyId, groupId, statuses, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG(long companyId, long groupId,
		int[] statuses, int start, int end) throws SystemException {
		return findByCG(companyId, groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG(long companyId, long groupId,
		int[] statuses, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG(companyId, groupId, statuses[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId, int status)
		throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG(companyId, groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG(long companyId, long groupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG;

		Object[] finderArgs = new Object[] { companyId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG(long companyId, long groupId, int[] statuses)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_DATA = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_DATA =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			},
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.STATUS_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_DATA = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_DATA = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Data(long companyId, long groupId,
		Date dataEvento, int status) throws SystemException {
		return findByCG_Data(companyId, groupId, dataEvento, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Data(long companyId, long groupId,
		Date dataEvento, int status, int start, int end)
		throws SystemException {
		return findByCG_Data(companyId, groupId, dataEvento, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Data(long companyId, long groupId,
		Date dataEvento, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_DATA;
			finderArgs = new Object[] { companyId, groupId, dataEvento, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_DATA;
			finderArgs = new Object[] {
					companyId, groupId, dataEvento, status,
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!Validator.equals(dataEvento,
							eventoAgenda.getDataEvento()) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_DATA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_DATA_GROUPID_2);

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_1);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_2);
			}

			query.append(_FINDER_COLUMN_CG_DATA_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_Data_First(long companyId, long groupId,
		Date dataEvento, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_Data_First(companyId, groupId,
				dataEvento, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", dataEvento=");
		msg.append(dataEvento);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_Data_First(long companyId, long groupId,
		Date dataEvento, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoAgenda> list = findByCG_Data(companyId, groupId, dataEvento,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_Data_Last(long companyId, long groupId,
		Date dataEvento, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_Data_Last(companyId, groupId,
				dataEvento, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", dataEvento=");
		msg.append(dataEvento);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_Data_Last(long companyId, long groupId,
		Date dataEvento, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Data(companyId, groupId, dataEvento, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_Data(companyId, groupId, dataEvento,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_Data_PrevAndNext(long eventoAgendaId,
		long companyId, long groupId, Date dataEvento, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_Data_PrevAndNext(session, eventoAgenda,
					companyId, groupId, dataEvento, status, orderByComparator,
					true);

			array[1] = eventoAgenda;

			array[2] = getByCG_Data_PrevAndNext(session, eventoAgenda,
					companyId, groupId, dataEvento, status, orderByComparator,
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

	protected EventoAgenda getByCG_Data_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId,
		Date dataEvento, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_DATA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_DATA_GROUPID_2);

		boolean bindDataEvento = false;

		if (dataEvento == null) {
			query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_1);
		}
		else {
			bindDataEvento = true;

			query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_2);
		}

		query.append(_FINDER_COLUMN_CG_DATA_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindDataEvento) {
			qPos.add(CalendarUtil.getTimestamp(dataEvento));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Data(long companyId, long groupId,
		Date dataEvento, int[] statuses) throws SystemException {
		return findByCG_Data(companyId, groupId, dataEvento, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Data(long companyId, long groupId,
		Date dataEvento, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_Data(companyId, groupId, dataEvento, statuses, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Data(long companyId, long groupId,
		Date dataEvento, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_Data(companyId, groupId, dataEvento, statuses[0],
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, dataEvento, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, dataEvento, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_DATA,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!Validator.equals(dataEvento,
							eventoAgenda.getDataEvento()) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_DATA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_DATA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_4);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_DATA_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_DATA,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_DATA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Data(long companyId, long groupId, Date dataEvento,
		int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_Data(companyId, groupId,
				dataEvento, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Data(long companyId, long groupId, Date dataEvento,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_DATA;

		Object[] finderArgs = new Object[] {
				companyId, groupId, dataEvento, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_DATA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_DATA_GROUPID_2);

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_1);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_2);
			}

			query.append(_FINDER_COLUMN_CG_DATA_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Data(long companyId, long groupId, Date dataEvento,
		int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, dataEvento, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_DATA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_DATA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_DATA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_4);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_DATA_DATAEVENTO_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_DATA_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_DATA,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_DATA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_DATA_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_DATA_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_DATA_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_DATA_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_DATA_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_DATA_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_DATA_DATAEVENTO_1 = "eventoAgenda.dataEvento IS NULL AND ";
	private static final String _FINDER_COLUMN_CG_DATA_DATAEVENTO_2 = "eventoAgenda.dataEvento = ? AND ";
	private static final String _FINDER_COLUMN_CG_DATA_DATAEVENTO_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_DATA_DATAEVENTO_1) + ")";
	private static final String _FINDER_COLUMN_CG_DATA_DATAEVENTO_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_DATA_DATAEVENTO_2) + ")";
	private static final String _FINDER_COLUMN_CG_DATA_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_DATA_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_DATA_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO_DATA =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_Evento_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Date.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO_DATA =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_Evento_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Date.class.getName(), Integer.class.getName()
			},
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTOID_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.STATUS_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_EVENTO_DATA = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_Evento_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Date.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTO_DATA =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_Evento_Data",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Date.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Evento_Data(long companyId,
		long groupId, long eventoId, Date dataEvento, int status)
		throws SystemException {
		return findByCG_Evento_Data(companyId, groupId, eventoId, dataEvento,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Evento_Data(long companyId,
		long groupId, long eventoId, Date dataEvento, int status, int start,
		int end) throws SystemException {
		return findByCG_Evento_Data(companyId, groupId, eventoId, dataEvento,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Evento_Data(long companyId,
		long groupId, long eventoId, Date dataEvento, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO_DATA;
			finderArgs = new Object[] {
					companyId, groupId, eventoId, dataEvento, status
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO_DATA;
			finderArgs = new Object[] {
					companyId, groupId, eventoId, dataEvento, status,
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(eventoId != eventoAgenda.getEventoId()) ||
						!Validator.equals(dataEvento,
							eventoAgenda.getDataEvento()) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_2);

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_1);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_2);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_Evento_Data_First(long companyId,
		long groupId, long eventoId, Date dataEvento, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_Evento_Data_First(companyId,
				groupId, eventoId, dataEvento, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoId=");
		msg.append(eventoId);

		msg.append(", dataEvento=");
		msg.append(dataEvento);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_Evento_Data_First(long companyId,
		long groupId, long eventoId, Date dataEvento, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> list = findByCG_Evento_Data(companyId, groupId,
				eventoId, dataEvento, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_Evento_Data_Last(long companyId, long groupId,
		long eventoId, Date dataEvento, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_Evento_Data_Last(companyId,
				groupId, eventoId, dataEvento, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoId=");
		msg.append(eventoId);

		msg.append(", dataEvento=");
		msg.append(dataEvento);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_Evento_Data_Last(long companyId,
		long groupId, long eventoId, Date dataEvento, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG_Evento_Data(companyId, groupId, eventoId,
				dataEvento, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_Evento_Data(companyId, groupId,
				eventoId, dataEvento, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_Evento_Data_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId, long eventoId,
		Date dataEvento, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_Evento_Data_PrevAndNext(session, eventoAgenda,
					companyId, groupId, eventoId, dataEvento, status,
					orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByCG_Evento_Data_PrevAndNext(session, eventoAgenda,
					companyId, groupId, eventoId, dataEvento, status,
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

	protected EventoAgenda getByCG_Evento_Data_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId, long eventoId,
		Date dataEvento, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_2);

		boolean bindDataEvento = false;

		if (dataEvento == null) {
			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_1);
		}
		else {
			bindDataEvento = true;

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_2);
		}

		query.append(_FINDER_COLUMN_CG_EVENTO_DATA_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(eventoId);

		if (bindDataEvento) {
			qPos.add(CalendarUtil.getTimestamp(dataEvento));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Evento_Data(long companyId,
		long groupId, long eventoId, Date dataEvento, int[] statuses)
		throws SystemException {
		return findByCG_Evento_Data(companyId, groupId, eventoId, dataEvento,
			statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Evento_Data(long companyId,
		long groupId, long eventoId, Date dataEvento, int[] statuses,
		int start, int end) throws SystemException {
		return findByCG_Evento_Data(companyId, groupId, eventoId, dataEvento,
			statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_Evento_Data(long companyId,
		long groupId, long eventoId, Date dataEvento, int[] statuses,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_Evento_Data(companyId, groupId, eventoId,
				dataEvento, statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, eventoId, dataEvento,
					StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, eventoId, dataEvento,
					StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO_DATA,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(eventoId != eventoAgenda.getEventoId()) ||
						!Validator.equals(dataEvento,
							eventoAgenda.getDataEvento()) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_4);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_EVENTO_DATA_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO_DATA,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO_DATA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Evento_Data(long companyId, long groupId,
		long eventoId, Date dataEvento, int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_Evento_Data(companyId,
				groupId, eventoId, dataEvento, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Evento_Data(long companyId, long groupId,
		long eventoId, Date dataEvento, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_EVENTO_DATA;

		Object[] finderArgs = new Object[] {
				companyId, groupId, eventoId, dataEvento, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_2);

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_1);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_2);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and dataEvento = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param dataEvento the data evento
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Evento_Data(long companyId, long groupId,
		long eventoId, Date dataEvento, int[] statuses)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, eventoId, dataEvento,
				StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTO_DATA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindDataEvento = false;

			if (dataEvento == null) {
				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_4);
			}
			else {
				bindDataEvento = true;

				query.append(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_EVENTO_DATA_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				if (bindDataEvento) {
					qPos.add(CalendarUtil.getTimestamp(dataEvento));
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTO_DATA,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTO_DATA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTO_DATA_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTO_DATA_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_2 = "eventoAgenda.eventoId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTO_DATA_EVENTOID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_1 = "eventoAgenda.dataEvento IS NULL AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_2 = "eventoAgenda.dataEvento = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_1) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTO_DATA_DATAEVENTO_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_EVENTO_DATA_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTO_DATA_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTONOME =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_EventoNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTONOME =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_EventoNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int status) throws SystemException {
		return findByCG_EventoNome(companyId, groupId, eventoNome, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int status, int start, int end)
		throws SystemException {
		return findByCG_EventoNome(companyId, groupId, eventoNome, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTONOME;
		finderArgs = new Object[] {
				companyId, groupId, eventoNome, status,
				
				start, end, orderByComparator
			};

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoAgenda.getEventoNome(), eventoNome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTONOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTONOME_GROUPID_2);

			boolean bindEventoNome = false;

			if (eventoNome == null) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_1);
			}
			else if (eventoNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_3);
			}
			else {
				bindEventoNome = true;

				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_2);
			}

			query.append(_FINDER_COLUMN_CG_EVENTONOME_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindEventoNome) {
					qPos.add(eventoNome);
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_EventoNome_First(long companyId, long groupId,
		String eventoNome, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_EventoNome_First(companyId,
				groupId, eventoNome, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoNome=");
		msg.append(eventoNome);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_EventoNome_First(long companyId,
		long groupId, String eventoNome, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> list = findByCG_EventoNome(companyId, groupId,
				eventoNome, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_EventoNome_Last(long companyId, long groupId,
		String eventoNome, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_EventoNome_Last(companyId,
				groupId, eventoNome, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoNome=");
		msg.append(eventoNome);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_EventoNome_Last(long companyId, long groupId,
		String eventoNome, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_EventoNome(companyId, groupId, eventoNome, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_EventoNome(companyId, groupId,
				eventoNome, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_EventoNome_PrevAndNext(long eventoAgendaId,
		long companyId, long groupId, String eventoNome, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_EventoNome_PrevAndNext(session, eventoAgenda,
					companyId, groupId, eventoNome, status, orderByComparator,
					true);

			array[1] = eventoAgenda;

			array[2] = getByCG_EventoNome_PrevAndNext(session, eventoAgenda,
					companyId, groupId, eventoNome, status, orderByComparator,
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

	protected EventoAgenda getByCG_EventoNome_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId,
		String eventoNome, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_EVENTONOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_EVENTONOME_GROUPID_2);

		boolean bindEventoNome = false;

		if (eventoNome == null) {
			query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_1);
		}
		else if (eventoNome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_3);
		}
		else {
			bindEventoNome = true;

			query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_2);
		}

		query.append(_FINDER_COLUMN_CG_EVENTONOME_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindEventoNome) {
			qPos.add(eventoNome);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int[] statuses) throws SystemException {
		return findByCG_EventoNome(companyId, groupId, eventoNome, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_EventoNome(companyId, groupId, eventoNome, statuses,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_EventoNome(companyId, groupId, eventoNome,
				statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, eventoNome, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, eventoNome, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTONOME,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoAgenda.getEventoNome(), eventoNome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTONOME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTONOME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindEventoNome = false;

			if (eventoNome == null) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_4);
			}
			else if (eventoNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_6);
			}
			else {
				bindEventoNome = true;

				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_EVENTONOME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindEventoNome) {
					qPos.add(eventoNome);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTONOME,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTONOME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_EventoNome(companyId,
				groupId, eventoNome, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTONOME;

		Object[] finderArgs = new Object[] {
				companyId, groupId, eventoNome, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTONOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTONOME_GROUPID_2);

			boolean bindEventoNome = false;

			if (eventoNome == null) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_1);
			}
			else if (eventoNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_3);
			}
			else {
				bindEventoNome = true;

				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_2);
			}

			query.append(_FINDER_COLUMN_CG_EVENTONOME_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindEventoNome) {
					qPos.add(eventoNome);
				}

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoNome LIKE &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoNome the evento nome
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_EventoNome(long companyId, long groupId,
		String eventoNome, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, eventoNome, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTONOME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTONOME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTONOME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindEventoNome = false;

			if (eventoNome == null) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_4);
			}
			else if (eventoNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_6);
			}
			else {
				bindEventoNome = true;

				query.append(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_EVENTONOME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindEventoNome) {
					qPos.add(eventoNome);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTONOME,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTONOME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_EVENTONOME_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTONOME_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTONOME_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_1 = "eventoAgenda.eventoNome LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_2 = "eventoAgenda.eventoNome LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_3 = "(eventoAgenda.eventoNome IS NULL OR eventoAgenda.eventoNome LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_1) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTONOME_EVENTONOME_3) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_EVENTONOME_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTONOME_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_EventoID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_EventoID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTOID_COLUMN_BITMASK |
			EventoAgendaModelImpl.STATUS_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_EVENTOID = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_EventoID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTOID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_EventoID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoID(long companyId, long groupId,
		long eventoId, int status) throws SystemException {
		return findByCG_EventoID(companyId, groupId, eventoId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoID(long companyId, long groupId,
		long eventoId, int status, int start, int end)
		throws SystemException {
		return findByCG_EventoID(companyId, groupId, eventoId, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoID(long companyId, long groupId,
		long eventoId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOID;
			finderArgs = new Object[] { companyId, groupId, eventoId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOID;
			finderArgs = new Object[] {
					companyId, groupId, eventoId, status,
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(eventoId != eventoAgenda.getEventoId()) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTOID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOID_EVENTOID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_EventoID_First(long companyId, long groupId,
		long eventoId, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_EventoID_First(companyId,
				groupId, eventoId, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoId=");
		msg.append(eventoId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_EventoID_First(long companyId, long groupId,
		long eventoId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoAgenda> list = findByCG_EventoID(companyId, groupId,
				eventoId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_EventoID_Last(long companyId, long groupId,
		long eventoId, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_EventoID_Last(companyId, groupId,
				eventoId, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoId=");
		msg.append(eventoId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_EventoID_Last(long companyId, long groupId,
		long eventoId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_EventoID(companyId, groupId, eventoId, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_EventoID(companyId, groupId,
				eventoId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_EventoID_PrevAndNext(long eventoAgendaId,
		long companyId, long groupId, long eventoId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_EventoID_PrevAndNext(session, eventoAgenda,
					companyId, groupId, eventoId, status, orderByComparator,
					true);

			array[1] = eventoAgenda;

			array[2] = getByCG_EventoID_PrevAndNext(session, eventoAgenda,
					companyId, groupId, eventoId, status, orderByComparator,
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

	protected EventoAgenda getByCG_EventoID_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId, long eventoId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_EVENTOID_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_EVENTOID_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_EVENTOID_EVENTOID_2);

		query.append(_FINDER_COLUMN_CG_EVENTOID_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(eventoId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoID(long companyId, long groupId,
		long eventoId, int[] statuses) throws SystemException {
		return findByCG_EventoID(companyId, groupId, eventoId, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoID(long companyId, long groupId,
		long eventoId, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_EventoID(companyId, groupId, eventoId, statuses, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_EventoID(long companyId, long groupId,
		long eventoId, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_EventoID(companyId, groupId, eventoId, statuses[0],
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, eventoId, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, eventoId, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOID,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(eventoId != eventoAgenda.getEventoId()) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTOID_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTOID_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTOID_EVENTOID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_EVENTOID_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOID,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_EventoID(long companyId, long groupId,
		long eventoId, int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_EventoID(companyId, groupId,
				eventoId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_EventoID(long companyId, long groupId, long eventoId,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_EVENTOID;

		Object[] finderArgs = new Object[] { companyId, groupId, eventoId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTOID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOID_EVENTOID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and eventoId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_EventoID(long companyId, long groupId, long eventoId,
		int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, eventoId, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTOID_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTOID_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_EVENTOID_EVENTOID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_EVENTOID_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTOID,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_EVENTOID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_EVENTOID_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOID_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTOID_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTOID_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOID_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTOID_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTOID_EVENTOID_2 = "eventoAgenda.eventoId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOID_EVENTOID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTOID_EVENTOID_2) + ")";
	private static final String _FINDER_COLUMN_CG_EVENTOID_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_EVENTOID_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_EVENTOID_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALNOME =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_LocalNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALNOME =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_LocalNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalNome(long companyId, long groupId,
		String localNome, int status) throws SystemException {
		return findByCG_LocalNome(companyId, groupId, localNome, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalNome(long companyId, long groupId,
		String localNome, int status, int start, int end)
		throws SystemException {
		return findByCG_LocalNome(companyId, groupId, localNome, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalNome(long companyId, long groupId,
		String localNome, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALNOME;
		finderArgs = new Object[] {
				companyId, groupId, localNome, status,
				
				start, end, orderByComparator
			};

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoAgenda.getLocalNome(), localNome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_LOCALNOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LOCALNOME_GROUPID_2);

			boolean bindLocalNome = false;

			if (localNome == null) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_1);
			}
			else if (localNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_3);
			}
			else {
				bindLocalNome = true;

				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_2);
			}

			query.append(_FINDER_COLUMN_CG_LOCALNOME_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindLocalNome) {
					qPos.add(localNome);
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_LocalNome_First(long companyId, long groupId,
		String localNome, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_LocalNome_First(companyId,
				groupId, localNome, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", localNome=");
		msg.append(localNome);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_LocalNome_First(long companyId, long groupId,
		String localNome, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoAgenda> list = findByCG_LocalNome(companyId, groupId,
				localNome, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_LocalNome_Last(long companyId, long groupId,
		String localNome, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_LocalNome_Last(companyId,
				groupId, localNome, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", localNome=");
		msg.append(localNome);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_LocalNome_Last(long companyId, long groupId,
		String localNome, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_LocalNome(companyId, groupId, localNome, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_LocalNome(companyId, groupId,
				localNome, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_LocalNome_PrevAndNext(long eventoAgendaId,
		long companyId, long groupId, String localNome, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_LocalNome_PrevAndNext(session, eventoAgenda,
					companyId, groupId, localNome, status, orderByComparator,
					true);

			array[1] = eventoAgenda;

			array[2] = getByCG_LocalNome_PrevAndNext(session, eventoAgenda,
					companyId, groupId, localNome, status, orderByComparator,
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

	protected EventoAgenda getByCG_LocalNome_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId,
		String localNome, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_LOCALNOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_LOCALNOME_GROUPID_2);

		boolean bindLocalNome = false;

		if (localNome == null) {
			query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_1);
		}
		else if (localNome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_3);
		}
		else {
			bindLocalNome = true;

			query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_2);
		}

		query.append(_FINDER_COLUMN_CG_LOCALNOME_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindLocalNome) {
			qPos.add(localNome);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalNome(long companyId, long groupId,
		String localNome, int[] statuses) throws SystemException {
		return findByCG_LocalNome(companyId, groupId, localNome, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalNome(long companyId, long groupId,
		String localNome, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_LocalNome(companyId, groupId, localNome, statuses,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalNome(long companyId, long groupId,
		String localNome, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_LocalNome(companyId, groupId, localNome,
				statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, localNome, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, localNome, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALNOME,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoAgenda.getLocalNome(), localNome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALNOME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALNOME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindLocalNome = false;

			if (localNome == null) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_4);
			}
			else if (localNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_6);
			}
			else {
				bindLocalNome = true;

				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_LOCALNOME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindLocalNome) {
					qPos.add(localNome);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALNOME,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALNOME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_LocalNome(long companyId, long groupId,
		String localNome, int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_LocalNome(companyId, groupId,
				localNome, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_LocalNome(long companyId, long groupId,
		String localNome, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALNOME;

		Object[] finderArgs = new Object[] { companyId, groupId, localNome, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_LOCALNOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LOCALNOME_GROUPID_2);

			boolean bindLocalNome = false;

			if (localNome == null) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_1);
			}
			else if (localNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_3);
			}
			else {
				bindLocalNome = true;

				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_2);
			}

			query.append(_FINDER_COLUMN_CG_LOCALNOME_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindLocalNome) {
					qPos.add(localNome);
				}

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localNome LIKE &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localNome the local nome
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_LocalNome(long companyId, long groupId,
		String localNome, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, localNome, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALNOME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALNOME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALNOME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindLocalNome = false;

			if (localNome == null) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_4);
			}
			else if (localNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_6);
			}
			else {
				bindLocalNome = true;

				query.append(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_LOCALNOME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindLocalNome) {
					qPos.add(localNome);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALNOME,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALNOME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_LOCALNOME_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALNOME_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALNOME_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_1 = "eventoAgenda.localNome LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_2 = "eventoAgenda.localNome LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_3 = "(eventoAgenda.localNome IS NULL OR eventoAgenda.localNome LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_1) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_2) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALNOME_LOCALNOME_3) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_LOCALNOME_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALNOME_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_LocalID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_LOCALID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_LocalID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK |
			EventoAgendaModelImpl.LOCALID_COLUMN_BITMASK |
			EventoAgendaModelImpl.STATUS_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_LOCALID = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_LocalID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_LocalID",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalID(long companyId, long groupId,
		long localId, int status) throws SystemException {
		return findByCG_LocalID(companyId, groupId, localId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalID(long companyId, long groupId,
		long localId, int status, int start, int end) throws SystemException {
		return findByCG_LocalID(companyId, groupId, localId, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalID(long companyId, long groupId,
		long localId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_LOCALID;
			finderArgs = new Object[] { companyId, groupId, localId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALID;
			finderArgs = new Object[] {
					companyId, groupId, localId, status,
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(localId != eventoAgenda.getLocalId()) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_LOCALID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LOCALID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_LOCALID_LOCALID_2);

			query.append(_FINDER_COLUMN_CG_LOCALID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(localId);

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_LocalID_First(long companyId, long groupId,
		long localId, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_LocalID_First(companyId, groupId,
				localId, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", localId=");
		msg.append(localId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_LocalID_First(long companyId, long groupId,
		long localId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoAgenda> list = findByCG_LocalID(companyId, groupId, localId,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_LocalID_Last(long companyId, long groupId,
		long localId, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_LocalID_Last(companyId, groupId,
				localId, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", localId=");
		msg.append(localId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_LocalID_Last(long companyId, long groupId,
		long localId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_LocalID(companyId, groupId, localId, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_LocalID(companyId, groupId, localId,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_LocalID_PrevAndNext(long eventoAgendaId,
		long companyId, long groupId, long localId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_LocalID_PrevAndNext(session, eventoAgenda,
					companyId, groupId, localId, status, orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByCG_LocalID_PrevAndNext(session, eventoAgenda,
					companyId, groupId, localId, status, orderByComparator,
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

	protected EventoAgenda getByCG_LocalID_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId, long localId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_LOCALID_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_LOCALID_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_LOCALID_LOCALID_2);

		query.append(_FINDER_COLUMN_CG_LOCALID_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(localId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalID(long companyId, long groupId,
		long localId, int[] statuses) throws SystemException {
		return findByCG_LocalID(companyId, groupId, localId, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalID(long companyId, long groupId,
		long localId, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_LocalID(companyId, groupId, localId, statuses, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_LocalID(long companyId, long groupId,
		long localId, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_LocalID(companyId, groupId, localId, statuses[0],
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, localId, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, localId, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALID,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(localId != eventoAgenda.getLocalId()) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALID_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALID_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALID_LOCALID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_LOCALID_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(localId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALID,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LOCALID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_LocalID(long companyId, long groupId, long localId,
		int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_LocalID(companyId, groupId,
				localId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_LocalID(long companyId, long groupId, long localId,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_LOCALID;

		Object[] finderArgs = new Object[] { companyId, groupId, localId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_LOCALID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LOCALID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_LOCALID_LOCALID_2);

			query.append(_FINDER_COLUMN_CG_LOCALID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(localId);

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and localId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param localId the local ID
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_LocalID(long companyId, long groupId, long localId,
		int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, localId, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALID_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALID_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_LOCALID_LOCALID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_LOCALID_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(localId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALID,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LOCALID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_LOCALID_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOCALID_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALID_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALID_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOCALID_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALID_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALID_LOCALID_2 = "eventoAgenda.localId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOCALID_LOCALID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALID_LOCALID_2) + ")";
	private static final String _FINDER_COLUMN_CG_LOCALID_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_LOCALID_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_LOCALID_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_ResponsavelNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCG_ResponsavelNome",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelNome(long companyId,
		long groupId, String userResponsavelNome, int status)
		throws SystemException {
		return findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelNome(long companyId,
		long groupId, String userResponsavelNome, int status, int start, int end)
		throws SystemException {
		return findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelNome(long companyId,
		long groupId, String userResponsavelNome, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME;
		finderArgs = new Object[] {
				companyId, groupId, userResponsavelNome, status,
				
				start, end, orderByComparator
			};

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoAgenda.getUserResponsavelNome(),
							userResponsavelNome, CharPool.UNDERLINE,
							CharPool.PERCENT, CharPool.BACK_SLASH, true) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_ResponsavelNome_First(long companyId,
		long groupId, String userResponsavelNome, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_ResponsavelNome_First(companyId,
				groupId, userResponsavelNome, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelNome=");
		msg.append(userResponsavelNome);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_ResponsavelNome_First(long companyId,
		long groupId, String userResponsavelNome, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> list = findByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_ResponsavelNome_Last(long companyId,
		long groupId, String userResponsavelNome, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_ResponsavelNome_Last(companyId,
				groupId, userResponsavelNome, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelNome=");
		msg.append(userResponsavelNome);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_ResponsavelNome_Last(long companyId,
		long groupId, String userResponsavelNome, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_ResponsavelNome_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		String userResponsavelNome, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_ResponsavelNome_PrevAndNext(session,
					eventoAgenda, companyId, groupId, userResponsavelNome,
					status, orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByCG_ResponsavelNome_PrevAndNext(session,
					eventoAgenda, companyId, groupId, userResponsavelNome,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoAgenda getByCG_ResponsavelNome_PrevAndNext(
		Session session, EventoAgenda eventoAgenda, long companyId,
		long groupId, String userResponsavelNome, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

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

		query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelNome(long companyId,
		long groupId, String userResponsavelNome, int[] statuses)
		throws SystemException {
		return findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, statuses, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelNome(long companyId,
		long groupId, String userResponsavelNome, int[] statuses, int start,
		int end) throws SystemException {
		return findByCG_ResponsavelNome(companyId, groupId,
			userResponsavelNome, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelNome(long companyId,
		long groupId, String userResponsavelNome, int[] statuses, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_ResponsavelNome(companyId, groupId,
				userResponsavelNome, statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelNome,
					StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelNome,
					StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoAgenda.getUserResponsavelNome(),
							userResponsavelNome, CharPool.UNDERLINE,
							CharPool.PERCENT, CharPool.BACK_SLASH, true) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindUserResponsavelNome = false;

			if (userResponsavelNome == null) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_4);
			}
			else if (userResponsavelNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_6);
			}
			else {
				bindUserResponsavelNome = true;

				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELNOME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome, int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_ResponsavelNome(companyId,
				groupId, userResponsavelNome, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME;

		Object[] finderArgs = new Object[] {
				companyId, groupId, userResponsavelNome, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

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

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_2);

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

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelNome LIKE &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelNome the user responsavel nome
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ResponsavelNome(long companyId, long groupId,
		String userResponsavelNome, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, userResponsavelNome,
				StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindUserResponsavelNome = false;

			if (userResponsavelNome == null) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_4);
			}
			else if (userResponsavelNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_6);
			}
			else {
				bindUserResponsavelNome = true;

				query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
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

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELNOME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELNOME_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELNOME_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_1 =
		"eventoAgenda.userResponsavelNome LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_2 =
		"eventoAgenda.userResponsavelNome LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_3 =
		"(eventoAgenda.userResponsavelNome IS NULL OR eventoAgenda.userResponsavelNome LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_4 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_1) +
		")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_2) +
		")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_6 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELNOME_USERRESPONSAVELNOME_3) +
		")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELNOME_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, EventoAgendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			EventoAgendaModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoAgendaModelImpl.GROUPID_COLUMN_BITMASK |
			EventoAgendaModelImpl.USERRESPONSAVELID_COLUMN_BITMASK |
			EventoAgendaModelImpl.STATUS_COLUMN_BITMASK |
			EventoAgendaModelImpl.DATAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.HORAEVENTO_COLUMN_BITMASK |
			EventoAgendaModelImpl.EVENTONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_RESPONSAVELID = new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELID =
		new FinderPath(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_ResponsavelId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelId(long companyId,
		long groupId, long userResponsavelId, int status)
		throws SystemException {
		return findByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelId(long companyId,
		long groupId, long userResponsavelId, int status, int start, int end)
		throws SystemException {
		return findByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelId(long companyId,
		long groupId, long userResponsavelId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID;
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelId, status
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID;
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelId, status,
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(userResponsavelId != eventoAgenda.getUserResponsavelId()) ||
						(status != eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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

				qPos.add(status);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_ResponsavelId_First(long companyId,
		long groupId, long userResponsavelId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_ResponsavelId_First(companyId,
				groupId, userResponsavelId, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelId=");
		msg.append(userResponsavelId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the first evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_ResponsavelId_First(long companyId,
		long groupId, long userResponsavelId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoAgenda> list = findByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByCG_ResponsavelId_Last(long companyId,
		long groupId, long userResponsavelId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByCG_ResponsavelId_Last(companyId,
				groupId, userResponsavelId, status, orderByComparator);

		if (eventoAgenda != null) {
			return eventoAgenda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userResponsavelId=");
		msg.append(userResponsavelId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoAgendaException(msg.toString());
	}

	/**
	 * Returns the last evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento agenda, or <code>null</code> if a matching evento agenda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByCG_ResponsavelId_Last(long companyId,
		long groupId, long userResponsavelId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, status);

		if (count == 0) {
			return null;
		}

		List<EventoAgenda> list = findByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento agendas before and after the current evento agenda in the ordered set where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param eventoAgendaId the primary key of the current evento agenda
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda[] findByCG_ResponsavelId_PrevAndNext(
		long eventoAgendaId, long companyId, long groupId,
		long userResponsavelId, int status, OrderByComparator orderByComparator)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = findByPrimaryKey(eventoAgendaId);

		Session session = null;

		try {
			session = openSession();

			EventoAgenda[] array = new EventoAgendaImpl[3];

			array[0] = getByCG_ResponsavelId_PrevAndNext(session, eventoAgenda,
					companyId, groupId, userResponsavelId, status,
					orderByComparator, true);

			array[1] = eventoAgenda;

			array[2] = getByCG_ResponsavelId_PrevAndNext(session, eventoAgenda,
					companyId, groupId, userResponsavelId, status,
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

	protected EventoAgenda getByCG_ResponsavelId_PrevAndNext(Session session,
		EventoAgenda eventoAgenda, long companyId, long groupId,
		long userResponsavelId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2);

		query.append(_FINDER_COLUMN_CG_RESPONSAVELID_STATUS_2);

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
			query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userResponsavelId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoAgenda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoAgenda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param statuses the statuses
	 * @return the matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelId(long companyId,
		long groupId, long userResponsavelId, int[] statuses)
		throws SystemException {
		return findByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelId(long companyId,
		long groupId, long userResponsavelId, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_ResponsavelId(companyId, groupId, userResponsavelId,
			statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findByCG_ResponsavelId(long companyId,
		long groupId, long userResponsavelId, int[] statuses, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_ResponsavelId(companyId, groupId,
				userResponsavelId, statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelId,
					StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, userResponsavelId,
					StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoAgenda eventoAgenda : list) {
				if ((companyId != eventoAgenda.getCompanyId()) ||
						(groupId != eventoAgenda.getGroupId()) ||
						(userResponsavelId != eventoAgenda.getUserResponsavelId()) ||
						!ArrayUtil.contains(statuses, eventoAgenda.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_RESPONSAVELID_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoAgendaModelImpl.ORDER_BY_JPQL);
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

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RESPONSAVELID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int status) throws SystemException {
		for (EventoAgenda eventoAgenda : findByCG_ResponsavelId(companyId,
				groupId, userResponsavelId, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param status the status
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_RESPONSAVELID;

		Object[] finderArgs = new Object[] {
				companyId, groupId, userResponsavelId, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2);

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userResponsavelId);

				qPos.add(status);

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

	/**
	 * Returns the number of evento agendas where companyId = &#63; and groupId = &#63; and userResponsavelId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userResponsavelId the user responsavel ID
	 * @param statuses the statuses
	 * @return the number of matching evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ResponsavelId(long companyId, long groupId,
		long userResponsavelId, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, userResponsavelId,
				StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EVENTOAGENDA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_RESPONSAVELID_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
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

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELID,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RESPONSAVELID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2 = "eventoAgenda.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELID_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2 = "eventoAgenda.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELID_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2 =
		"eventoAgenda.userResponsavelId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELID_USERRESPONSAVELID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_STATUS_2 = "eventoAgenda.status = ?";
	private static final String _FINDER_COLUMN_CG_RESPONSAVELID_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RESPONSAVELID_STATUS_2) + ")";

	public EventoAgendaPersistenceImpl() {
		setModelClass(EventoAgenda.class);
	}

	/**
	 * Caches the evento agenda in the entity cache if it is enabled.
	 *
	 * @param eventoAgenda the evento agenda
	 */
	@Override
	public void cacheResult(EventoAgenda eventoAgenda) {
		EntityCacheUtil.putResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaImpl.class, eventoAgenda.getPrimaryKey(), eventoAgenda);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { eventoAgenda.getUuid(), eventoAgenda.getGroupId() },
			eventoAgenda);

		eventoAgenda.resetOriginalValues();
	}

	/**
	 * Caches the evento agendas in the entity cache if it is enabled.
	 *
	 * @param eventoAgendas the evento agendas
	 */
	@Override
	public void cacheResult(List<EventoAgenda> eventoAgendas) {
		for (EventoAgenda eventoAgenda : eventoAgendas) {
			if (EntityCacheUtil.getResult(
						EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
						EventoAgendaImpl.class, eventoAgenda.getPrimaryKey()) == null) {
				cacheResult(eventoAgenda);
			}
			else {
				eventoAgenda.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all evento agendas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventoAgendaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventoAgendaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evento agenda.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventoAgenda eventoAgenda) {
		EntityCacheUtil.removeResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaImpl.class, eventoAgenda.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(eventoAgenda);
	}

	@Override
	public void clearCache(List<EventoAgenda> eventoAgendas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventoAgenda eventoAgenda : eventoAgendas) {
			EntityCacheUtil.removeResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
				EventoAgendaImpl.class, eventoAgenda.getPrimaryKey());

			clearUniqueFindersCache(eventoAgenda);
		}
	}

	protected void cacheUniqueFindersCache(EventoAgenda eventoAgenda) {
		if (eventoAgenda.isNew()) {
			Object[] args = new Object[] {
					eventoAgenda.getUuid(), eventoAgenda.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				eventoAgenda);
		}
		else {
			EventoAgendaModelImpl eventoAgendaModelImpl = (EventoAgendaModelImpl)eventoAgenda;

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgenda.getUuid(), eventoAgenda.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					eventoAgenda);
			}
		}
	}

	protected void clearUniqueFindersCache(EventoAgenda eventoAgenda) {
		EventoAgendaModelImpl eventoAgendaModelImpl = (EventoAgendaModelImpl)eventoAgenda;

		Object[] args = new Object[] {
				eventoAgenda.getUuid(), eventoAgenda.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((eventoAgendaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventoAgendaModelImpl.getOriginalUuid(),
					eventoAgendaModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new evento agenda with the primary key. Does not add the evento agenda to the database.
	 *
	 * @param eventoAgendaId the primary key for the new evento agenda
	 * @return the new evento agenda
	 */
	@Override
	public EventoAgenda create(long eventoAgendaId) {
		EventoAgenda eventoAgenda = new EventoAgendaImpl();

		eventoAgenda.setNew(true);
		eventoAgenda.setPrimaryKey(eventoAgendaId);

		String uuid = PortalUUIDUtil.generate();

		eventoAgenda.setUuid(uuid);

		return eventoAgenda;
	}

	/**
	 * Removes the evento agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoAgendaId the primary key of the evento agenda
	 * @return the evento agenda that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda remove(long eventoAgendaId)
		throws NoSuchEventoAgendaException, SystemException {
		return remove((Serializable)eventoAgendaId);
	}

	/**
	 * Removes the evento agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evento agenda
	 * @return the evento agenda that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda remove(Serializable primaryKey)
		throws NoSuchEventoAgendaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventoAgenda eventoAgenda = (EventoAgenda)session.get(EventoAgendaImpl.class,
					primaryKey);

			if (eventoAgenda == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventoAgendaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventoAgenda);
		}
		catch (NoSuchEventoAgendaException nsee) {
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
	protected EventoAgenda removeImpl(EventoAgenda eventoAgenda)
		throws SystemException {
		eventoAgenda = toUnwrappedModel(eventoAgenda);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventoAgenda)) {
				eventoAgenda = (EventoAgenda)session.get(EventoAgendaImpl.class,
						eventoAgenda.getPrimaryKeyObj());
			}

			if (eventoAgenda != null) {
				session.delete(eventoAgenda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventoAgenda != null) {
			clearCache(eventoAgenda);
		}

		return eventoAgenda;
	}

	@Override
	public EventoAgenda updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.EventoAgenda eventoAgenda)
		throws SystemException {
		eventoAgenda = toUnwrappedModel(eventoAgenda);

		boolean isNew = eventoAgenda.isNew();

		EventoAgendaModelImpl eventoAgendaModelImpl = (EventoAgendaModelImpl)eventoAgenda;

		if (Validator.isNull(eventoAgenda.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			eventoAgenda.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (eventoAgenda.isNew()) {
				session.save(eventoAgenda);

				eventoAgenda.setNew(false);
			}
			else {
				session.merge(eventoAgenda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventoAgendaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { eventoAgendaModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalUuid(),
						eventoAgendaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getUuid(),
						eventoAgendaModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalCompanyId(),
						eventoAgendaModelImpl.getOriginalGroupId(),
						eventoAgendaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getCompanyId(),
						eventoAgendaModelImpl.getGroupId(),
						eventoAgendaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_DATA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalCompanyId(),
						eventoAgendaModelImpl.getOriginalGroupId(),
						eventoAgendaModelImpl.getOriginalDataEvento(),
						eventoAgendaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_DATA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_DATA,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getCompanyId(),
						eventoAgendaModelImpl.getGroupId(),
						eventoAgendaModelImpl.getDataEvento(),
						eventoAgendaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_DATA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_DATA,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO_DATA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalCompanyId(),
						eventoAgendaModelImpl.getOriginalGroupId(),
						eventoAgendaModelImpl.getOriginalEventoId(),
						eventoAgendaModelImpl.getOriginalDataEvento(),
						eventoAgendaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTO_DATA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO_DATA,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getCompanyId(),
						eventoAgendaModelImpl.getGroupId(),
						eventoAgendaModelImpl.getEventoId(),
						eventoAgendaModelImpl.getDataEvento(),
						eventoAgendaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTO_DATA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO_DATA,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalCompanyId(),
						eventoAgendaModelImpl.getOriginalGroupId(),
						eventoAgendaModelImpl.getOriginalEventoId(),
						eventoAgendaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOID,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getCompanyId(),
						eventoAgendaModelImpl.getGroupId(),
						eventoAgendaModelImpl.getEventoId(),
						eventoAgendaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOID,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_LOCALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalCompanyId(),
						eventoAgendaModelImpl.getOriginalGroupId(),
						eventoAgendaModelImpl.getOriginalLocalId(),
						eventoAgendaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_LOCALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_LOCALID,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getCompanyId(),
						eventoAgendaModelImpl.getGroupId(),
						eventoAgendaModelImpl.getLocalId(),
						eventoAgendaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_LOCALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_LOCALID,
					args);
			}

			if ((eventoAgendaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoAgendaModelImpl.getOriginalCompanyId(),
						eventoAgendaModelImpl.getOriginalGroupId(),
						eventoAgendaModelImpl.getOriginalUserResponsavelId(),
						eventoAgendaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_RESPONSAVELID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID,
					args);

				args = new Object[] {
						eventoAgendaModelImpl.getCompanyId(),
						eventoAgendaModelImpl.getGroupId(),
						eventoAgendaModelImpl.getUserResponsavelId(),
						eventoAgendaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_RESPONSAVELID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_RESPONSAVELID,
					args);
			}
		}

		EntityCacheUtil.putResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
			EventoAgendaImpl.class, eventoAgenda.getPrimaryKey(), eventoAgenda);

		clearUniqueFindersCache(eventoAgenda);
		cacheUniqueFindersCache(eventoAgenda);

		return eventoAgenda;
	}

	protected EventoAgenda toUnwrappedModel(EventoAgenda eventoAgenda) {
		if (eventoAgenda instanceof EventoAgendaImpl) {
			return eventoAgenda;
		}

		EventoAgendaImpl eventoAgendaImpl = new EventoAgendaImpl();

		eventoAgendaImpl.setNew(eventoAgenda.isNew());
		eventoAgendaImpl.setPrimaryKey(eventoAgenda.getPrimaryKey());

		eventoAgendaImpl.setUuid(eventoAgenda.getUuid());
		eventoAgendaImpl.setEventoAgendaId(eventoAgenda.getEventoAgendaId());
		eventoAgendaImpl.setCompanyId(eventoAgenda.getCompanyId());
		eventoAgendaImpl.setGroupId(eventoAgenda.getGroupId());
		eventoAgendaImpl.setCreateUserId(eventoAgenda.getCreateUserId());
		eventoAgendaImpl.setModifiedUserId(eventoAgenda.getModifiedUserId());
		eventoAgendaImpl.setCreateDate(eventoAgenda.getCreateDate());
		eventoAgendaImpl.setModifiedDate(eventoAgenda.getModifiedDate());
		eventoAgendaImpl.setDataEvento(eventoAgenda.getDataEvento());
		eventoAgendaImpl.setHoraEvento(eventoAgenda.getHoraEvento());
		eventoAgendaImpl.setQtdeVagas(eventoAgenda.getQtdeVagas());
		eventoAgendaImpl.setQtdeVagasPreenchida(eventoAgenda.getQtdeVagasPreenchida());
		eventoAgendaImpl.setGratuito(eventoAgenda.isGratuito());
		eventoAgendaImpl.setValor(eventoAgenda.getValor());
		eventoAgendaImpl.setUserResponsavelId(eventoAgenda.getUserResponsavelId());
		eventoAgendaImpl.setUserResponsavelNome(eventoAgenda.getUserResponsavelNome());
		eventoAgendaImpl.setEventoId(eventoAgenda.getEventoId());
		eventoAgendaImpl.setEventoNome(eventoAgenda.getEventoNome());
		eventoAgendaImpl.setLocalId(eventoAgenda.getLocalId());
		eventoAgendaImpl.setLocalNome(eventoAgenda.getLocalNome());
		eventoAgendaImpl.setObservacao(eventoAgenda.getObservacao());
		eventoAgendaImpl.setVersao(eventoAgenda.getVersao());
		eventoAgendaImpl.setStatus(eventoAgenda.getStatus());
		eventoAgendaImpl.setStatusByUserId(eventoAgenda.getStatusByUserId());
		eventoAgendaImpl.setStatusByUserName(eventoAgenda.getStatusByUserName());
		eventoAgendaImpl.setStatusDate(eventoAgenda.getStatusDate());
		eventoAgendaImpl.setClassNameId(eventoAgenda.getClassNameId());
		eventoAgendaImpl.setClassPK(eventoAgenda.getClassPK());

		return eventoAgendaImpl;
	}

	/**
	 * Returns the evento agenda with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento agenda
	 * @return the evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventoAgendaException, SystemException {
		EventoAgenda eventoAgenda = fetchByPrimaryKey(primaryKey);

		if (eventoAgenda == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventoAgendaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventoAgenda;
	}

	/**
	 * Returns the evento agenda with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException} if it could not be found.
	 *
	 * @param eventoAgendaId the primary key of the evento agenda
	 * @return the evento agenda
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoAgendaException if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda findByPrimaryKey(long eventoAgendaId)
		throws NoSuchEventoAgendaException, SystemException {
		return findByPrimaryKey((Serializable)eventoAgendaId);
	}

	/**
	 * Returns the evento agenda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento agenda
	 * @return the evento agenda, or <code>null</code> if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventoAgenda eventoAgenda = (EventoAgenda)EntityCacheUtil.getResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
				EventoAgendaImpl.class, primaryKey);

		if (eventoAgenda == _nullEventoAgenda) {
			return null;
		}

		if (eventoAgenda == null) {
			Session session = null;

			try {
				session = openSession();

				eventoAgenda = (EventoAgenda)session.get(EventoAgendaImpl.class,
						primaryKey);

				if (eventoAgenda != null) {
					cacheResult(eventoAgenda);
				}
				else {
					EntityCacheUtil.putResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
						EventoAgendaImpl.class, primaryKey, _nullEventoAgenda);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventoAgendaModelImpl.ENTITY_CACHE_ENABLED,
					EventoAgendaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventoAgenda;
	}

	/**
	 * Returns the evento agenda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoAgendaId the primary key of the evento agenda
	 * @return the evento agenda, or <code>null</code> if a evento agenda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoAgenda fetchByPrimaryKey(long eventoAgendaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventoAgendaId);
	}

	/**
	 * Returns all the evento agendas.
	 *
	 * @return the evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @return the range of evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoAgendaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento agendas
	 * @param end the upper bound of the range of evento agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evento agendas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoAgenda> findAll(int start, int end,
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

		List<EventoAgenda> list = (List<EventoAgenda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTOAGENDA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTOAGENDA;

				if (pagination) {
					sql = sql.concat(EventoAgendaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoAgenda>(list);
				}
				else {
					list = (List<EventoAgenda>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the evento agendas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventoAgenda eventoAgenda : findAll()) {
			remove(eventoAgenda);
		}
	}

	/**
	 * Returns the number of evento agendas.
	 *
	 * @return the number of evento agendas
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

				Query q = session.createQuery(_SQL_COUNT_EVENTOAGENDA);

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
	 * Initializes the evento agenda persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.lapidarios.evento.model.EventoAgenda")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventoAgenda>> listenersList = new ArrayList<ModelListener<EventoAgenda>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventoAgenda>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventoAgendaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTOAGENDA = "SELECT eventoAgenda FROM EventoAgenda eventoAgenda";
	private static final String _SQL_SELECT_EVENTOAGENDA_WHERE = "SELECT eventoAgenda FROM EventoAgenda eventoAgenda WHERE ";
	private static final String _SQL_COUNT_EVENTOAGENDA = "SELECT COUNT(eventoAgenda) FROM EventoAgenda eventoAgenda";
	private static final String _SQL_COUNT_EVENTOAGENDA_WHERE = "SELECT COUNT(eventoAgenda) FROM EventoAgenda eventoAgenda WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventoAgenda.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventoAgenda exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventoAgenda exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventoAgendaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static EventoAgenda _nullEventoAgenda = new EventoAgendaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventoAgenda> toCacheModel() {
				return _nullEventoAgendaCacheModel;
			}
		};

	private static CacheModel<EventoAgenda> _nullEventoAgendaCacheModel = new CacheModel<EventoAgenda>() {
			@Override
			public EventoAgenda toEntityModel() {
				return _nullEventoAgenda;
			}
		};
}