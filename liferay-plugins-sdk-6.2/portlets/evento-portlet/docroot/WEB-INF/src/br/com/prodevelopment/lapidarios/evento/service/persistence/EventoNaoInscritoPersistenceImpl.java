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

import br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException;
import br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoImpl;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl;

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
 * The persistence implementation for the evento nao inscrito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoNaoInscritoPersistence
 * @see EventoNaoInscritoUtil
 * @generated
 */
public class EventoNaoInscritoPersistenceImpl extends BasePersistenceImpl<EventoNaoInscrito>
	implements EventoNaoInscritoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventoNaoInscritoUtil} to access the evento nao inscrito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventoNaoInscritoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EventoNaoInscritoModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the evento nao inscritos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByUuid(String uuid, int start, int end,
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

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoNaoInscrito eventoNaoInscrito : list) {
				if (!Validator.equals(uuid, eventoNaoInscrito.getUuid())) {
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

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

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
				query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first evento nao inscrito in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByUuid_First(uuid,
				orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the first evento nao inscrito in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoNaoInscrito> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByUuid_Last(uuid,
				orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EventoNaoInscrito> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento nao inscritos before and after the current evento nao inscrito in the ordered set where uuid = &#63;.
	 *
	 * @param eventoNaoInscritoId the primary key of the current evento nao inscrito
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito[] findByUuid_PrevAndNext(
		long eventoNaoInscritoId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByPrimaryKey(eventoNaoInscritoId);

		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito[] array = new EventoNaoInscritoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, eventoNaoInscrito, uuid,
					orderByComparator, true);

			array[1] = eventoNaoInscrito;

			array[2] = getByUuid_PrevAndNext(session, eventoNaoInscrito, uuid,
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

	protected EventoNaoInscrito getByUuid_PrevAndNext(Session session,
		EventoNaoInscrito eventoNaoInscrito, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

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
			query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoNaoInscrito);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoNaoInscrito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento nao inscritos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching evento nao inscritos
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

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "eventoNaoInscrito.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "eventoNaoInscrito.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(eventoNaoInscrito.uuid IS NULL OR eventoNaoInscrito.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoNaoInscritoModelImpl.UUID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the evento nao inscrito where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByUUID_G(String uuid, long groupId)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByUUID_G(uuid, groupId);

		if (eventoNaoInscrito == null) {
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

			throw new NoSuchEventoNaoInscritoException(msg.toString());
		}

		return eventoNaoInscrito;
	}

	/**
	 * Returns the evento nao inscrito where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the evento nao inscrito where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof EventoNaoInscrito) {
			EventoNaoInscrito eventoNaoInscrito = (EventoNaoInscrito)result;

			if (!Validator.equals(uuid, eventoNaoInscrito.getUuid()) ||
					(groupId != eventoNaoInscrito.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

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

				List<EventoNaoInscrito> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					EventoNaoInscrito eventoNaoInscrito = list.get(0);

					result = eventoNaoInscrito;

					cacheResult(eventoNaoInscrito);

					if ((eventoNaoInscrito.getUuid() == null) ||
							!eventoNaoInscrito.getUuid().equals(uuid) ||
							(eventoNaoInscrito.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, eventoNaoInscrito);
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
			return (EventoNaoInscrito)result;
		}
	}

	/**
	 * Removes the evento nao inscrito where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the evento nao inscrito that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByUUID_G(uuid, groupId);

		return remove(eventoNaoInscrito);
	}

	/**
	 * Returns the number of evento nao inscritos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching evento nao inscritos
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

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "eventoNaoInscrito.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "eventoNaoInscrito.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(eventoNaoInscrito.uuid IS NULL OR eventoNaoInscrito.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "eventoNaoInscrito.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoNaoInscritoModelImpl.UUID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the evento nao inscritos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByUuid_C(String uuid, long companyId,
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

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoNaoInscrito eventoNaoInscrito : list) {
				if (!Validator.equals(uuid, eventoNaoInscrito.getUuid()) ||
						(companyId != eventoNaoInscrito.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

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
				query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first evento nao inscrito in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the first evento nao inscrito in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoNaoInscrito> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EventoNaoInscrito> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento nao inscritos before and after the current evento nao inscrito in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventoNaoInscritoId the primary key of the current evento nao inscrito
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito[] findByUuid_C_PrevAndNext(
		long eventoNaoInscritoId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByPrimaryKey(eventoNaoInscritoId);

		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito[] array = new EventoNaoInscritoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, eventoNaoInscrito,
					uuid, companyId, orderByComparator, true);

			array[1] = eventoNaoInscrito;

			array[2] = getByUuid_C_PrevAndNext(session, eventoNaoInscrito,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoNaoInscrito getByUuid_C_PrevAndNext(Session session,
		EventoNaoInscrito eventoNaoInscrito, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

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
			query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoNaoInscrito);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoNaoInscrito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento nao inscritos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching evento nao inscritos
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

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "eventoNaoInscrito.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "eventoNaoInscrito.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(eventoNaoInscrito.uuid IS NULL OR eventoNaoInscrito.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "eventoNaoInscrito.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventoNaoInscritoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the evento nao inscritos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoNaoInscrito eventoNaoInscrito : list) {
				if ((companyId != eventoNaoInscrito.getCompanyId()) ||
						(groupId != eventoNaoInscrito.getGroupId())) {
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

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_First(companyId,
				groupId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoNaoInscrito> list = findByCG(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_Last(companyId,
				groupId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<EventoNaoInscrito> list = findByCG(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento nao inscritos before and after the current evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param eventoNaoInscritoId the primary key of the current evento nao inscrito
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito[] findByCG_PrevAndNext(long eventoNaoInscritoId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByPrimaryKey(eventoNaoInscritoId);

		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito[] array = new EventoNaoInscritoImpl[3];

			array[0] = getByCG_PrevAndNext(session, eventoNaoInscrito,
					companyId, groupId, orderByComparator, true);

			array[1] = eventoNaoInscrito;

			array[2] = getByCG_PrevAndNext(session, eventoNaoInscrito,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoNaoInscrito getByCG_PrevAndNext(Session session,
		EventoNaoInscrito eventoNaoInscrito, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

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
			query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoNaoInscrito);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoNaoInscrito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento nao inscritos where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findByCG(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching evento nao inscritos
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

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

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

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "eventoNaoInscrito.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "eventoNaoInscrito.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOAGENDA =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_EventoAgenda",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_EventoAgenda",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EventoNaoInscritoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.GROUPID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.EVENTOAGENDAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_EventoAgenda",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @return the matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_EventoAgenda(long companyId,
		long groupId, long eventoAgendaId) throws SystemException {
		return findByCG_EventoAgenda(companyId, groupId, eventoAgendaId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_EventoAgenda(long companyId,
		long groupId, long eventoAgendaId, int start, int end)
		throws SystemException {
		return findByCG_EventoAgenda(companyId, groupId, eventoAgendaId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_EventoAgenda(long companyId,
		long groupId, long eventoAgendaId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA;
			finderArgs = new Object[] { companyId, groupId, eventoAgendaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOAGENDA;
			finderArgs = new Object[] {
					companyId, groupId, eventoAgendaId,
					
					start, end, orderByComparator
				};
		}

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoNaoInscrito eventoNaoInscrito : list) {
				if ((companyId != eventoNaoInscrito.getCompanyId()) ||
						(groupId != eventoNaoInscrito.getGroupId()) ||
						(eventoAgendaId != eventoNaoInscrito.getEventoAgendaId())) {
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

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_EVENTOAGENDAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoAgendaId);

				if (!pagination) {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_EventoAgenda_First(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_EventoAgenda_First(companyId,
				groupId, eventoAgendaId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoAgendaId=");
		msg.append(eventoAgendaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_EventoAgenda_First(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoNaoInscrito> list = findByCG_EventoAgenda(companyId,
				groupId, eventoAgendaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_EventoAgenda_Last(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_EventoAgenda_Last(companyId,
				groupId, eventoAgendaId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoAgendaId=");
		msg.append(eventoAgendaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_EventoAgenda_Last(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_EventoAgenda(companyId, groupId, eventoAgendaId);

		if (count == 0) {
			return null;
		}

		List<EventoNaoInscrito> list = findByCG_EventoAgenda(companyId,
				groupId, eventoAgendaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento nao inscritos before and after the current evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param eventoNaoInscritoId the primary key of the current evento nao inscrito
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito[] findByCG_EventoAgenda_PrevAndNext(
		long eventoNaoInscritoId, long companyId, long groupId,
		long eventoAgendaId, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByPrimaryKey(eventoNaoInscritoId);

		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito[] array = new EventoNaoInscritoImpl[3];

			array[0] = getByCG_EventoAgenda_PrevAndNext(session,
					eventoNaoInscrito, companyId, groupId, eventoAgendaId,
					orderByComparator, true);

			array[1] = eventoNaoInscrito;

			array[2] = getByCG_EventoAgenda_PrevAndNext(session,
					eventoNaoInscrito, companyId, groupId, eventoAgendaId,
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

	protected EventoNaoInscrito getByCG_EventoAgenda_PrevAndNext(
		Session session, EventoNaoInscrito eventoNaoInscrito, long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

		query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_EVENTOAGENDAID_2);

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
			query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(eventoAgendaId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoNaoInscrito);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoNaoInscrito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_EventoAgenda(long companyId, long groupId,
		long eventoAgendaId) throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findByCG_EventoAgenda(
				companyId, groupId, eventoAgendaId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @return the number of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_EventoAgenda(long companyId, long groupId,
		long eventoAgendaId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA;

		Object[] finderArgs = new Object[] { companyId, groupId, eventoAgendaId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_EVENTOAGENDAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoAgendaId);

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

	private static final String _FINDER_COLUMN_CG_EVENTOAGENDA_COMPANYID_2 = "eventoNaoInscrito.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOAGENDA_GROUPID_2 = "eventoNaoInscrito.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOAGENDA_EVENTOAGENDAID_2 = "eventoNaoInscrito.eventoAgendaId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_Evento",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_Evento",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EventoNaoInscritoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.GROUPID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.EVENTOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_EVENTO = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_Evento",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @return the matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_Evento(long companyId,
		long groupId, long eventoId) throws SystemException {
		return findByCG_Evento(companyId, groupId, eventoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_Evento(long companyId,
		long groupId, long eventoId, int start, int end)
		throws SystemException {
		return findByCG_Evento(companyId, groupId, eventoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_Evento(long companyId,
		long groupId, long eventoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO;
			finderArgs = new Object[] { companyId, groupId, eventoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO;
			finderArgs = new Object[] {
					companyId, groupId, eventoId,
					
					start, end, orderByComparator
				};
		}

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoNaoInscrito eventoNaoInscrito : list) {
				if ((companyId != eventoNaoInscrito.getCompanyId()) ||
						(groupId != eventoNaoInscrito.getGroupId()) ||
						(eventoId != eventoNaoInscrito.getEventoId())) {
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

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTO_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_EVENTOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_Evento_First(long companyId,
		long groupId, long eventoId, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_Evento_First(companyId,
				groupId, eventoId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoId=");
		msg.append(eventoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_Evento_First(long companyId,
		long groupId, long eventoId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoNaoInscrito> list = findByCG_Evento(companyId, groupId,
				eventoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_Evento_Last(long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_Evento_Last(companyId,
				groupId, eventoId, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", eventoId=");
		msg.append(eventoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_Evento_Last(long companyId,
		long groupId, long eventoId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Evento(companyId, groupId, eventoId);

		if (count == 0) {
			return null;
		}

		List<EventoNaoInscrito> list = findByCG_Evento(companyId, groupId,
				eventoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento nao inscritos before and after the current evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param eventoNaoInscritoId the primary key of the current evento nao inscrito
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito[] findByCG_Evento_PrevAndNext(
		long eventoNaoInscritoId, long companyId, long groupId, long eventoId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByPrimaryKey(eventoNaoInscritoId);

		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito[] array = new EventoNaoInscritoImpl[3];

			array[0] = getByCG_Evento_PrevAndNext(session, eventoNaoInscrito,
					companyId, groupId, eventoId, orderByComparator, true);

			array[1] = eventoNaoInscrito;

			array[2] = getByCG_Evento_PrevAndNext(session, eventoNaoInscrito,
					companyId, groupId, eventoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoNaoInscrito getByCG_Evento_PrevAndNext(Session session,
		EventoNaoInscrito eventoNaoInscrito, long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

		query.append(_FINDER_COLUMN_CG_EVENTO_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_EVENTO_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_EVENTO_EVENTOID_2);

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
			query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(eventoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoNaoInscrito);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoNaoInscrito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Evento(long companyId, long groupId, long eventoId)
		throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findByCG_Evento(companyId,
				groupId, eventoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @return the number of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Evento(long companyId, long groupId, long eventoId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_EVENTO;

		Object[] finderArgs = new Object[] { companyId, groupId, eventoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTO_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_EVENTOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(eventoId);

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

	private static final String _FINDER_COLUMN_CG_EVENTO_COMPANYID_2 = "eventoNaoInscrito.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_GROUPID_2 = "eventoNaoInscrito.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_EVENTOID_2 = "eventoNaoInscrito.eventoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_USUARIO =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_Usuario",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_USUARIO =
		new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_Usuario",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the evento nao inscritos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @return the matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_Usuario(long companyId,
		long groupId, String userNome) throws SystemException {
		return findByCG_Usuario(companyId, groupId, userNome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_Usuario(long companyId,
		long groupId, String userNome, int start, int end)
		throws SystemException {
		return findByCG_Usuario(companyId, groupId, userNome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findByCG_Usuario(long companyId,
		long groupId, String userNome, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_USUARIO;
		finderArgs = new Object[] {
				companyId, groupId, userNome,
				
				start, end, orderByComparator
			};

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoNaoInscrito eventoNaoInscrito : list) {
				if ((companyId != eventoNaoInscrito.getCompanyId()) ||
						(groupId != eventoNaoInscrito.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoNaoInscrito.getUserNome(), userNome,
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

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_USUARIO_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_USUARIO_GROUPID_2);

			boolean bindUserNome = false;

			if (userNome == null) {
				query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_1);
			}
			else if (userNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_3);
			}
			else {
				bindUserNome = true;

				query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindUserNome) {
					qPos.add(userNome);
				}

				if (!pagination) {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_Usuario_First(long companyId,
		long groupId, String userNome, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_Usuario_First(companyId,
				groupId, userNome, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userNome=");
		msg.append(userNome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the first evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_Usuario_First(long companyId,
		long groupId, String userNome, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoNaoInscrito> list = findByCG_Usuario(companyId, groupId,
				userNome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByCG_Usuario_Last(long companyId,
		long groupId, String userNome, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByCG_Usuario_Last(companyId,
				groupId, userNome, orderByComparator);

		if (eventoNaoInscrito != null) {
			return eventoNaoInscrito;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userNome=");
		msg.append(userNome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoNaoInscritoException(msg.toString());
	}

	/**
	 * Returns the last evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByCG_Usuario_Last(long companyId,
		long groupId, String userNome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Usuario(companyId, groupId, userNome);

		if (count == 0) {
			return null;
		}

		List<EventoNaoInscrito> list = findByCG_Usuario(companyId, groupId,
				userNome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento nao inscritos before and after the current evento nao inscrito in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param eventoNaoInscritoId the primary key of the current evento nao inscrito
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito[] findByCG_Usuario_PrevAndNext(
		long eventoNaoInscritoId, long companyId, long groupId,
		String userNome, OrderByComparator orderByComparator)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByPrimaryKey(eventoNaoInscritoId);

		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito[] array = new EventoNaoInscritoImpl[3];

			array[0] = getByCG_Usuario_PrevAndNext(session, eventoNaoInscrito,
					companyId, groupId, userNome, orderByComparator, true);

			array[1] = eventoNaoInscrito;

			array[2] = getByCG_Usuario_PrevAndNext(session, eventoNaoInscrito,
					companyId, groupId, userNome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoNaoInscrito getByCG_Usuario_PrevAndNext(Session session,
		EventoNaoInscrito eventoNaoInscrito, long companyId, long groupId,
		String userNome, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

		query.append(_FINDER_COLUMN_CG_USUARIO_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_USUARIO_GROUPID_2);

		boolean bindUserNome = false;

		if (userNome == null) {
			query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_1);
		}
		else if (userNome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_3);
		}
		else {
			bindUserNome = true;

			query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_2);
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
			query.append(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindUserNome) {
			qPos.add(userNome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoNaoInscrito);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoNaoInscrito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento nao inscritos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Usuario(long companyId, long groupId, String userNome)
		throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findByCG_Usuario(companyId,
				groupId, userNome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @return the number of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Usuario(long companyId, long groupId, String userNome)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_USUARIO;

		Object[] finderArgs = new Object[] { companyId, groupId, userNome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_CG_USUARIO_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_USUARIO_GROUPID_2);

			boolean bindUserNome = false;

			if (userNome == null) {
				query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_1);
			}
			else if (userNome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_3);
			}
			else {
				bindUserNome = true;

				query.append(_FINDER_COLUMN_CG_USUARIO_USERNOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindUserNome) {
					qPos.add(userNome);
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

	private static final String _FINDER_COLUMN_CG_USUARIO_COMPANYID_2 = "eventoNaoInscrito.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_USUARIO_GROUPID_2 = "eventoNaoInscrito.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_USUARIO_USERNOME_1 = "eventoNaoInscrito.userNome LIKE NULL";
	private static final String _FINDER_COLUMN_CG_USUARIO_USERNOME_2 = "eventoNaoInscrito.userNome LIKE ?";
	private static final String _FINDER_COLUMN_CG_USUARIO_USERNOME_3 = "(eventoNaoInscrito.userNome IS NULL OR eventoNaoInscrito.userNome LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED,
			EventoNaoInscritoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEventoAgendaUsuario",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventoNaoInscritoModelImpl.EVENTOAGENDAID_COLUMN_BITMASK |
			EventoNaoInscritoModelImpl.CREATEUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO = new FinderPath(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventoAgendaUsuario",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the evento nao inscrito where eventoAgendaId = &#63; and createUserId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException} if it could not be found.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the matching evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByEventoAgendaUsuario(eventoAgendaId,
				createUserId);

		if (eventoNaoInscrito == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("eventoAgendaId=");
			msg.append(eventoAgendaId);

			msg.append(", createUserId=");
			msg.append(createUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEventoNaoInscritoException(msg.toString());
		}

		return eventoNaoInscrito;
	}

	/**
	 * Returns the evento nao inscrito where eventoAgendaId = &#63; and createUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId) throws SystemException {
		return fetchByEventoAgendaUsuario(eventoAgendaId, createUserId, true);
	}

	/**
	 * Returns the evento nao inscrito where eventoAgendaId = &#63; and createUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evento nao inscrito, or <code>null</code> if a matching evento nao inscrito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { eventoAgendaId, createUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
					finderArgs, this);
		}

		if (result instanceof EventoNaoInscrito) {
			EventoNaoInscrito eventoNaoInscrito = (EventoNaoInscrito)result;

			if ((eventoAgendaId != eventoNaoInscrito.getEventoAgendaId()) ||
					(createUserId != eventoNaoInscrito.getCreateUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_EVENTOAGENDAUSUARIO_EVENTOAGENDAID_2);

			query.append(_FINDER_COLUMN_EVENTOAGENDAUSUARIO_CREATEUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventoAgendaId);

				qPos.add(createUserId);

				List<EventoNaoInscrito> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EventoNaoInscritoPersistenceImpl.fetchByEventoAgendaUsuario(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EventoNaoInscrito eventoNaoInscrito = list.get(0);

					result = eventoNaoInscrito;

					cacheResult(eventoNaoInscrito);

					if ((eventoNaoInscrito.getEventoAgendaId() != eventoAgendaId) ||
							(eventoNaoInscrito.getCreateUserId() != createUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
							finderArgs, eventoNaoInscrito);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
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
			return (EventoNaoInscrito)result;
		}
	}

	/**
	 * Removes the evento nao inscrito where eventoAgendaId = &#63; and createUserId = &#63; from the database.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the evento nao inscrito that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito removeByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = findByEventoAgendaUsuario(eventoAgendaId,
				createUserId);

		return remove(eventoNaoInscrito);
	}

	/**
	 * Returns the number of evento nao inscritos where eventoAgendaId = &#63; and createUserId = &#63;.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the number of matching evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventoAgendaUsuario(long eventoAgendaId, long createUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO;

		Object[] finderArgs = new Object[] { eventoAgendaId, createUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTONAOINSCRITO_WHERE);

			query.append(_FINDER_COLUMN_EVENTOAGENDAUSUARIO_EVENTOAGENDAID_2);

			query.append(_FINDER_COLUMN_EVENTOAGENDAUSUARIO_CREATEUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventoAgendaId);

				qPos.add(createUserId);

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

	private static final String _FINDER_COLUMN_EVENTOAGENDAUSUARIO_EVENTOAGENDAID_2 =
		"eventoNaoInscrito.eventoAgendaId = ? AND ";
	private static final String _FINDER_COLUMN_EVENTOAGENDAUSUARIO_CREATEUSERID_2 =
		"eventoNaoInscrito.createUserId = ?";

	public EventoNaoInscritoPersistenceImpl() {
		setModelClass(EventoNaoInscrito.class);
	}

	/**
	 * Caches the evento nao inscrito in the entity cache if it is enabled.
	 *
	 * @param eventoNaoInscrito the evento nao inscrito
	 */
	@Override
	public void cacheResult(EventoNaoInscrito eventoNaoInscrito) {
		EntityCacheUtil.putResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoImpl.class, eventoNaoInscrito.getPrimaryKey(),
			eventoNaoInscrito);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				eventoNaoInscrito.getUuid(), eventoNaoInscrito.getGroupId()
			}, eventoNaoInscrito);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
			new Object[] {
				eventoNaoInscrito.getEventoAgendaId(),
				eventoNaoInscrito.getCreateUserId()
			}, eventoNaoInscrito);

		eventoNaoInscrito.resetOriginalValues();
	}

	/**
	 * Caches the evento nao inscritos in the entity cache if it is enabled.
	 *
	 * @param eventoNaoInscritos the evento nao inscritos
	 */
	@Override
	public void cacheResult(List<EventoNaoInscrito> eventoNaoInscritos) {
		for (EventoNaoInscrito eventoNaoInscrito : eventoNaoInscritos) {
			if (EntityCacheUtil.getResult(
						EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
						EventoNaoInscritoImpl.class,
						eventoNaoInscrito.getPrimaryKey()) == null) {
				cacheResult(eventoNaoInscrito);
			}
			else {
				eventoNaoInscrito.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all evento nao inscritos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventoNaoInscritoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventoNaoInscritoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evento nao inscrito.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventoNaoInscrito eventoNaoInscrito) {
		EntityCacheUtil.removeResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoImpl.class, eventoNaoInscrito.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(eventoNaoInscrito);
	}

	@Override
	public void clearCache(List<EventoNaoInscrito> eventoNaoInscritos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventoNaoInscrito eventoNaoInscrito : eventoNaoInscritos) {
			EntityCacheUtil.removeResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
				EventoNaoInscritoImpl.class, eventoNaoInscrito.getPrimaryKey());

			clearUniqueFindersCache(eventoNaoInscrito);
		}
	}

	protected void cacheUniqueFindersCache(EventoNaoInscrito eventoNaoInscrito) {
		if (eventoNaoInscrito.isNew()) {
			Object[] args = new Object[] {
					eventoNaoInscrito.getUuid(), eventoNaoInscrito.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				eventoNaoInscrito);

			args = new Object[] {
					eventoNaoInscrito.getEventoAgendaId(),
					eventoNaoInscrito.getCreateUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
				args, eventoNaoInscrito);
		}
		else {
			EventoNaoInscritoModelImpl eventoNaoInscritoModelImpl = (EventoNaoInscritoModelImpl)eventoNaoInscrito;

			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscrito.getUuid(),
						eventoNaoInscrito.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					eventoNaoInscrito);
			}

			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscrito.getEventoAgendaId(),
						eventoNaoInscrito.getCreateUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
					args, eventoNaoInscrito);
			}
		}
	}

	protected void clearUniqueFindersCache(EventoNaoInscrito eventoNaoInscrito) {
		EventoNaoInscritoModelImpl eventoNaoInscritoModelImpl = (EventoNaoInscritoModelImpl)eventoNaoInscrito;

		Object[] args = new Object[] {
				eventoNaoInscrito.getUuid(), eventoNaoInscrito.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventoNaoInscritoModelImpl.getOriginalUuid(),
					eventoNaoInscritoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				eventoNaoInscrito.getEventoAgendaId(),
				eventoNaoInscrito.getCreateUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
			args);

		if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventoNaoInscritoModelImpl.getOriginalEventoAgendaId(),
					eventoNaoInscritoModelImpl.getOriginalCreateUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
				args);
		}
	}

	/**
	 * Creates a new evento nao inscrito with the primary key. Does not add the evento nao inscrito to the database.
	 *
	 * @param eventoNaoInscritoId the primary key for the new evento nao inscrito
	 * @return the new evento nao inscrito
	 */
	@Override
	public EventoNaoInscrito create(long eventoNaoInscritoId) {
		EventoNaoInscrito eventoNaoInscrito = new EventoNaoInscritoImpl();

		eventoNaoInscrito.setNew(true);
		eventoNaoInscrito.setPrimaryKey(eventoNaoInscritoId);

		String uuid = PortalUUIDUtil.generate();

		eventoNaoInscrito.setUuid(uuid);

		return eventoNaoInscrito;
	}

	/**
	 * Removes the evento nao inscrito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoNaoInscritoId the primary key of the evento nao inscrito
	 * @return the evento nao inscrito that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito remove(long eventoNaoInscritoId)
		throws NoSuchEventoNaoInscritoException, SystemException {
		return remove((Serializable)eventoNaoInscritoId);
	}

	/**
	 * Removes the evento nao inscrito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evento nao inscrito
	 * @return the evento nao inscrito that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito remove(Serializable primaryKey)
		throws NoSuchEventoNaoInscritoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventoNaoInscrito eventoNaoInscrito = (EventoNaoInscrito)session.get(EventoNaoInscritoImpl.class,
					primaryKey);

			if (eventoNaoInscrito == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventoNaoInscritoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventoNaoInscrito);
		}
		catch (NoSuchEventoNaoInscritoException nsee) {
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
	protected EventoNaoInscrito removeImpl(EventoNaoInscrito eventoNaoInscrito)
		throws SystemException {
		eventoNaoInscrito = toUnwrappedModel(eventoNaoInscrito);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventoNaoInscrito)) {
				eventoNaoInscrito = (EventoNaoInscrito)session.get(EventoNaoInscritoImpl.class,
						eventoNaoInscrito.getPrimaryKeyObj());
			}

			if (eventoNaoInscrito != null) {
				session.delete(eventoNaoInscrito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventoNaoInscrito != null) {
			clearCache(eventoNaoInscrito);
		}

		return eventoNaoInscrito;
	}

	@Override
	public EventoNaoInscrito updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito eventoNaoInscrito)
		throws SystemException {
		eventoNaoInscrito = toUnwrappedModel(eventoNaoInscrito);

		boolean isNew = eventoNaoInscrito.isNew();

		EventoNaoInscritoModelImpl eventoNaoInscritoModelImpl = (EventoNaoInscritoModelImpl)eventoNaoInscrito;

		if (Validator.isNull(eventoNaoInscrito.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			eventoNaoInscrito.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (eventoNaoInscrito.isNew()) {
				session.save(eventoNaoInscrito);

				eventoNaoInscrito.setNew(false);
			}
			else {
				session.merge(eventoNaoInscrito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventoNaoInscritoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscritoModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { eventoNaoInscritoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscritoModelImpl.getOriginalUuid(),
						eventoNaoInscritoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						eventoNaoInscritoModelImpl.getUuid(),
						eventoNaoInscritoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscritoModelImpl.getOriginalCompanyId(),
						eventoNaoInscritoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						eventoNaoInscritoModelImpl.getCompanyId(),
						eventoNaoInscritoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}

			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscritoModelImpl.getOriginalCompanyId(),
						eventoNaoInscritoModelImpl.getOriginalGroupId(),
						eventoNaoInscritoModelImpl.getOriginalEventoAgendaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA,
					args);

				args = new Object[] {
						eventoNaoInscritoModelImpl.getCompanyId(),
						eventoNaoInscritoModelImpl.getGroupId(),
						eventoNaoInscritoModelImpl.getEventoAgendaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA,
					args);
			}

			if ((eventoNaoInscritoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoNaoInscritoModelImpl.getOriginalCompanyId(),
						eventoNaoInscritoModelImpl.getOriginalGroupId(),
						eventoNaoInscritoModelImpl.getOriginalEventoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO,
					args);

				args = new Object[] {
						eventoNaoInscritoModelImpl.getCompanyId(),
						eventoNaoInscritoModelImpl.getGroupId(),
						eventoNaoInscritoModelImpl.getEventoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
			EventoNaoInscritoImpl.class, eventoNaoInscrito.getPrimaryKey(),
			eventoNaoInscrito);

		clearUniqueFindersCache(eventoNaoInscrito);
		cacheUniqueFindersCache(eventoNaoInscrito);

		return eventoNaoInscrito;
	}

	protected EventoNaoInscrito toUnwrappedModel(
		EventoNaoInscrito eventoNaoInscrito) {
		if (eventoNaoInscrito instanceof EventoNaoInscritoImpl) {
			return eventoNaoInscrito;
		}

		EventoNaoInscritoImpl eventoNaoInscritoImpl = new EventoNaoInscritoImpl();

		eventoNaoInscritoImpl.setNew(eventoNaoInscrito.isNew());
		eventoNaoInscritoImpl.setPrimaryKey(eventoNaoInscrito.getPrimaryKey());

		eventoNaoInscritoImpl.setUuid(eventoNaoInscrito.getUuid());
		eventoNaoInscritoImpl.setEventoNaoInscritoId(eventoNaoInscrito.getEventoNaoInscritoId());
		eventoNaoInscritoImpl.setCompanyId(eventoNaoInscrito.getCompanyId());
		eventoNaoInscritoImpl.setGroupId(eventoNaoInscrito.getGroupId());
		eventoNaoInscritoImpl.setCreateUserId(eventoNaoInscrito.getCreateUserId());
		eventoNaoInscritoImpl.setCreateDate(eventoNaoInscrito.getCreateDate());
		eventoNaoInscritoImpl.setEventoAgendaId(eventoNaoInscrito.getEventoAgendaId());
		eventoNaoInscritoImpl.setEventoId(eventoNaoInscrito.getEventoId());
		eventoNaoInscritoImpl.setUserNome(eventoNaoInscrito.getUserNome());

		return eventoNaoInscritoImpl;
	}

	/**
	 * Returns the evento nao inscrito with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento nao inscrito
	 * @return the evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventoNaoInscritoException, SystemException {
		EventoNaoInscrito eventoNaoInscrito = fetchByPrimaryKey(primaryKey);

		if (eventoNaoInscrito == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventoNaoInscritoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventoNaoInscrito;
	}

	/**
	 * Returns the evento nao inscrito with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException} if it could not be found.
	 *
	 * @param eventoNaoInscritoId the primary key of the evento nao inscrito
	 * @return the evento nao inscrito
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoNaoInscritoException if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito findByPrimaryKey(long eventoNaoInscritoId)
		throws NoSuchEventoNaoInscritoException, SystemException {
		return findByPrimaryKey((Serializable)eventoNaoInscritoId);
	}

	/**
	 * Returns the evento nao inscrito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento nao inscrito
	 * @return the evento nao inscrito, or <code>null</code> if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventoNaoInscrito eventoNaoInscrito = (EventoNaoInscrito)EntityCacheUtil.getResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
				EventoNaoInscritoImpl.class, primaryKey);

		if (eventoNaoInscrito == _nullEventoNaoInscrito) {
			return null;
		}

		if (eventoNaoInscrito == null) {
			Session session = null;

			try {
				session = openSession();

				eventoNaoInscrito = (EventoNaoInscrito)session.get(EventoNaoInscritoImpl.class,
						primaryKey);

				if (eventoNaoInscrito != null) {
					cacheResult(eventoNaoInscrito);
				}
				else {
					EntityCacheUtil.putResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
						EventoNaoInscritoImpl.class, primaryKey,
						_nullEventoNaoInscrito);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventoNaoInscritoModelImpl.ENTITY_CACHE_ENABLED,
					EventoNaoInscritoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventoNaoInscrito;
	}

	/**
	 * Returns the evento nao inscrito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoNaoInscritoId the primary key of the evento nao inscrito
	 * @return the evento nao inscrito, or <code>null</code> if a evento nao inscrito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoNaoInscrito fetchByPrimaryKey(long eventoNaoInscritoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventoNaoInscritoId);
	}

	/**
	 * Returns all the evento nao inscritos.
	 *
	 * @return the evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento nao inscritos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @return the range of evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento nao inscritos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoNaoInscritoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento nao inscritos
	 * @param end the upper bound of the range of evento nao inscritos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evento nao inscritos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoNaoInscrito> findAll(int start, int end,
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

		List<EventoNaoInscrito> list = (List<EventoNaoInscrito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTONAOINSCRITO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTONAOINSCRITO;

				if (pagination) {
					sql = sql.concat(EventoNaoInscritoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoNaoInscrito>(list);
				}
				else {
					list = (List<EventoNaoInscrito>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the evento nao inscritos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventoNaoInscrito eventoNaoInscrito : findAll()) {
			remove(eventoNaoInscrito);
		}
	}

	/**
	 * Returns the number of evento nao inscritos.
	 *
	 * @return the number of evento nao inscritos
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

				Query q = session.createQuery(_SQL_COUNT_EVENTONAOINSCRITO);

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
	 * Initializes the evento nao inscrito persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.lapidarios.evento.model.EventoNaoInscrito")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventoNaoInscrito>> listenersList = new ArrayList<ModelListener<EventoNaoInscrito>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventoNaoInscrito>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventoNaoInscritoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTONAOINSCRITO = "SELECT eventoNaoInscrito FROM EventoNaoInscrito eventoNaoInscrito";
	private static final String _SQL_SELECT_EVENTONAOINSCRITO_WHERE = "SELECT eventoNaoInscrito FROM EventoNaoInscrito eventoNaoInscrito WHERE ";
	private static final String _SQL_COUNT_EVENTONAOINSCRITO = "SELECT COUNT(eventoNaoInscrito) FROM EventoNaoInscrito eventoNaoInscrito";
	private static final String _SQL_COUNT_EVENTONAOINSCRITO_WHERE = "SELECT COUNT(eventoNaoInscrito) FROM EventoNaoInscrito eventoNaoInscrito WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventoNaoInscrito.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventoNaoInscrito exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventoNaoInscrito exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventoNaoInscritoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static EventoNaoInscrito _nullEventoNaoInscrito = new EventoNaoInscritoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventoNaoInscrito> toCacheModel() {
				return _nullEventoNaoInscritoCacheModel;
			}
		};

	private static CacheModel<EventoNaoInscrito> _nullEventoNaoInscritoCacheModel =
		new CacheModel<EventoNaoInscrito>() {
			@Override
			public EventoNaoInscrito toEntityModel() {
				return _nullEventoNaoInscrito;
			}
		};
}