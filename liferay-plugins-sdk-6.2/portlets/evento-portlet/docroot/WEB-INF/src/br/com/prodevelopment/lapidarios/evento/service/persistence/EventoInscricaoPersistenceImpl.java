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

import br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException;
import br.com.prodevelopment.lapidarios.evento.model.EventoInscricao;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoImpl;
import br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl;

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
 * The persistence implementation for the evento inscricao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EventoInscricaoPersistence
 * @see EventoInscricaoUtil
 * @generated
 */
public class EventoInscricaoPersistenceImpl extends BasePersistenceImpl<EventoInscricao>
	implements EventoInscricaoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventoInscricaoUtil} to access the evento inscricao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventoInscricaoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EventoInscricaoModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the evento inscricaos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByUuid(String uuid, int start, int end,
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

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoInscricao eventoInscricao : list) {
				if (!Validator.equals(uuid, eventoInscricao.getUuid())) {
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

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
				query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Returns the first evento inscricao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByUuid_First(uuid,
				orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first evento inscricao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoInscricao> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento inscricao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByUuid_Last(uuid,
				orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last evento inscricao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EventoInscricao> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento inscricaos before and after the current evento inscricao in the ordered set where uuid = &#63;.
	 *
	 * @param eventoInscricaoId the primary key of the current evento inscricao
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao[] findByUuid_PrevAndNext(long eventoInscricaoId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByPrimaryKey(eventoInscricaoId);

		Session session = null;

		try {
			session = openSession();

			EventoInscricao[] array = new EventoInscricaoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, eventoInscricao, uuid,
					orderByComparator, true);

			array[1] = eventoInscricao;

			array[2] = getByUuid_PrevAndNext(session, eventoInscricao, uuid,
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

	protected EventoInscricao getByUuid_PrevAndNext(Session session,
		EventoInscricao eventoInscricao, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
			query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento inscricaos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (EventoInscricao eventoInscricao : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "eventoInscricao.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "eventoInscricao.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(eventoInscricao.uuid IS NULL OR eventoInscricao.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoInscricaoModelImpl.UUID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the evento inscricao where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByUUID_G(String uuid, long groupId)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByUUID_G(uuid, groupId);

		if (eventoInscricao == null) {
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

			throw new NoSuchEventoInscricaoException(msg.toString());
		}

		return eventoInscricao;
	}

	/**
	 * Returns the evento inscricao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the evento inscricao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof EventoInscricao) {
			EventoInscricao eventoInscricao = (EventoInscricao)result;

			if (!Validator.equals(uuid, eventoInscricao.getUuid()) ||
					(groupId != eventoInscricao.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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

				List<EventoInscricao> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					EventoInscricao eventoInscricao = list.get(0);

					result = eventoInscricao;

					cacheResult(eventoInscricao);

					if ((eventoInscricao.getUuid() == null) ||
							!eventoInscricao.getUuid().equals(uuid) ||
							(eventoInscricao.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, eventoInscricao);
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
			return (EventoInscricao)result;
		}
	}

	/**
	 * Removes the evento inscricao where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the evento inscricao that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByUUID_G(uuid, groupId);

		return remove(eventoInscricao);
	}

	/**
	 * Returns the number of evento inscricaos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "eventoInscricao.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "eventoInscricao.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(eventoInscricao.uuid IS NULL OR eventoInscricao.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "eventoInscricao.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EventoInscricaoModelImpl.UUID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the evento inscricaos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByUuid_C(String uuid, long companyId,
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

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoInscricao eventoInscricao : list) {
				if (!Validator.equals(uuid, eventoInscricao.getUuid()) ||
						(companyId != eventoInscricao.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
				query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Returns the first evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoInscricao> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EventoInscricao> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento inscricaos before and after the current evento inscricao in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventoInscricaoId the primary key of the current evento inscricao
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao[] findByUuid_C_PrevAndNext(long eventoInscricaoId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByPrimaryKey(eventoInscricaoId);

		Session session = null;

		try {
			session = openSession();

			EventoInscricao[] array = new EventoInscricaoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, eventoInscricao, uuid,
					companyId, orderByComparator, true);

			array[1] = eventoInscricao;

			array[2] = getByUuid_C_PrevAndNext(session, eventoInscricao, uuid,
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

	protected EventoInscricao getByUuid_C_PrevAndNext(Session session,
		EventoInscricao eventoInscricao, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
			query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento inscricaos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (EventoInscricao eventoInscricao : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "eventoInscricao.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "eventoInscricao.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(eventoInscricao.uuid IS NULL OR eventoInscricao.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "eventoInscricao.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventoInscricaoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the evento inscricaos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG(long companyId, long groupId,
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

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoInscricao eventoInscricao : list) {
				if ((companyId != eventoInscricao.getCompanyId()) ||
						(groupId != eventoInscricao.getGroupId())) {
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

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_First(companyId, groupId,
				orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventoInscricao> list = findByCG(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_Last(companyId, groupId,
				orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<EventoInscricao> list = findByCG(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param eventoInscricaoId the primary key of the current evento inscricao
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao[] findByCG_PrevAndNext(long eventoInscricaoId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByPrimaryKey(eventoInscricaoId);

		Session session = null;

		try {
			session = openSession();

			EventoInscricao[] array = new EventoInscricaoImpl[3];

			array[0] = getByCG_PrevAndNext(session, eventoInscricao, companyId,
					groupId, orderByComparator, true);

			array[1] = eventoInscricao;

			array[2] = getByCG_PrevAndNext(session, eventoInscricao, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventoInscricao getByCG_PrevAndNext(Session session,
		EventoInscricao eventoInscricao, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
			query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (EventoInscricao eventoInscricao : findByCG(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "eventoInscricao.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "eventoInscricao.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTOAGENDA =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCG_EventoAgenda",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_EventoAgenda",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EventoInscricaoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.GROUPID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.EVENTOAGENDAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_EventoAgenda",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @return the matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_EventoAgenda(long companyId,
		long groupId, long eventoAgendaId) throws SystemException {
		return findByCG_EventoAgenda(companyId, groupId, eventoAgendaId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_EventoAgenda(long companyId,
		long groupId, long eventoAgendaId, int start, int end)
		throws SystemException {
		return findByCG_EventoAgenda(companyId, groupId, eventoAgendaId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_EventoAgenda(long companyId,
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

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoInscricao eventoInscricao : list) {
				if ((companyId != eventoInscricao.getCompanyId()) ||
						(groupId != eventoInscricao.getGroupId()) ||
						(eventoAgendaId != eventoInscricao.getEventoAgendaId())) {
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

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTOAGENDA_EVENTOAGENDAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_EventoAgenda_First(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_EventoAgenda_First(companyId,
				groupId, eventoAgendaId, orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
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

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_EventoAgenda_First(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoInscricao> list = findByCG_EventoAgenda(companyId, groupId,
				eventoAgendaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_EventoAgenda_Last(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_EventoAgenda_Last(companyId,
				groupId, eventoAgendaId, orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
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

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_EventoAgenda_Last(long companyId,
		long groupId, long eventoAgendaId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_EventoAgenda(companyId, groupId, eventoAgendaId);

		if (count == 0) {
			return null;
		}

		List<EventoInscricao> list = findByCG_EventoAgenda(companyId, groupId,
				eventoAgendaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param eventoInscricaoId the primary key of the current evento inscricao
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao[] findByCG_EventoAgenda_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId,
		long eventoAgendaId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByPrimaryKey(eventoInscricaoId);

		Session session = null;

		try {
			session = openSession();

			EventoInscricao[] array = new EventoInscricaoImpl[3];

			array[0] = getByCG_EventoAgenda_PrevAndNext(session,
					eventoInscricao, companyId, groupId, eventoAgendaId,
					orderByComparator, true);

			array[1] = eventoInscricao;

			array[2] = getByCG_EventoAgenda_PrevAndNext(session,
					eventoInscricao, companyId, groupId, eventoAgendaId,
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

	protected EventoInscricao getByCG_EventoAgenda_PrevAndNext(
		Session session, EventoInscricao eventoInscricao, long companyId,
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

		query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
			query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_EventoAgenda(long companyId, long groupId,
		long eventoAgendaId) throws SystemException {
		for (EventoInscricao eventoInscricao : findByCG_EventoAgenda(
				companyId, groupId, eventoAgendaId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63; and eventoAgendaId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoAgendaId the evento agenda ID
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_CG_EVENTOAGENDA_COMPANYID_2 = "eventoInscricao.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOAGENDA_GROUPID_2 = "eventoInscricao.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTOAGENDA_EVENTOAGENDAID_2 = "eventoInscricao.eventoAgendaId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_EVENTO =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCG_Evento",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_Evento",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EventoInscricaoModelImpl.COMPANYID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.GROUPID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.EVENTOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_EVENTO = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_Evento",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @return the matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_Evento(long companyId, long groupId,
		long eventoId) throws SystemException {
		return findByCG_Evento(companyId, groupId, eventoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_Evento(long companyId, long groupId,
		long eventoId, int start, int end) throws SystemException {
		return findByCG_Evento(companyId, groupId, eventoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_Evento(long companyId, long groupId,
		long eventoId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoInscricao eventoInscricao : list) {
				if ((companyId != eventoInscricao.getCompanyId()) ||
						(groupId != eventoInscricao.getGroupId()) ||
						(eventoId != eventoInscricao.getEventoId())) {
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

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_CG_EVENTO_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_EVENTO_EVENTOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_Evento_First(long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_Evento_First(companyId,
				groupId, eventoId, orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
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

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_Evento_First(long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoInscricao> list = findByCG_Evento(companyId, groupId,
				eventoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_Evento_Last(long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_Evento_Last(companyId,
				groupId, eventoId, orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
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

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_Evento_Last(long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Evento(companyId, groupId, eventoId);

		if (count == 0) {
			return null;
		}

		List<EventoInscricao> list = findByCG_Evento(companyId, groupId,
				eventoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param eventoInscricaoId the primary key of the current evento inscricao
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao[] findByCG_Evento_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId, long eventoId,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByPrimaryKey(eventoInscricaoId);

		Session session = null;

		try {
			session = openSession();

			EventoInscricao[] array = new EventoInscricaoImpl[3];

			array[0] = getByCG_Evento_PrevAndNext(session, eventoInscricao,
					companyId, groupId, eventoId, orderByComparator, true);

			array[1] = eventoInscricao;

			array[2] = getByCG_Evento_PrevAndNext(session, eventoInscricao,
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

	protected EventoInscricao getByCG_Evento_PrevAndNext(Session session,
		EventoInscricao eventoInscricao, long companyId, long groupId,
		long eventoId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
			query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Evento(long companyId, long groupId, long eventoId)
		throws SystemException {
		for (EventoInscricao eventoInscricao : findByCG_Evento(companyId,
				groupId, eventoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63; and eventoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param eventoId the evento ID
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_CG_EVENTO_COMPANYID_2 = "eventoInscricao.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_GROUPID_2 = "eventoInscricao.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_EVENTO_EVENTOID_2 = "eventoInscricao.eventoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_USUARIO =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCG_Usuario",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_USUARIO =
		new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_Usuario",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @return the matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_Usuario(long companyId, long groupId,
		String userNome) throws SystemException {
		return findByCG_Usuario(companyId, groupId, userNome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_Usuario(long companyId, long groupId,
		String userNome, int start, int end) throws SystemException {
		return findByCG_Usuario(companyId, groupId, userNome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findByCG_Usuario(long companyId, long groupId,
		String userNome, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_USUARIO;
		finderArgs = new Object[] {
				companyId, groupId, userNome,
				
				start, end, orderByComparator
			};

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventoInscricao eventoInscricao : list) {
				if ((companyId != eventoInscricao.getCompanyId()) ||
						(groupId != eventoInscricao.getGroupId()) ||
						!StringUtil.wildcardMatches(
							eventoInscricao.getUserNome(), userNome,
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

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
				query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_Usuario_First(long companyId, long groupId,
		String userNome, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_Usuario_First(companyId,
				groupId, userNome, orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
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

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_Usuario_First(long companyId,
		long groupId, String userNome, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventoInscricao> list = findByCG_Usuario(companyId, groupId,
				userNome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByCG_Usuario_Last(long companyId, long groupId,
		String userNome, OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByCG_Usuario_Last(companyId,
				groupId, userNome, orderByComparator);

		if (eventoInscricao != null) {
			return eventoInscricao;
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

		throw new NoSuchEventoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByCG_Usuario_Last(long companyId, long groupId,
		String userNome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Usuario(companyId, groupId, userNome);

		if (count == 0) {
			return null;
		}

		List<EventoInscricao> list = findByCG_Usuario(companyId, groupId,
				userNome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evento inscricaos before and after the current evento inscricao in the ordered set where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param eventoInscricaoId the primary key of the current evento inscricao
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao[] findByCG_Usuario_PrevAndNext(
		long eventoInscricaoId, long companyId, long groupId, String userNome,
		OrderByComparator orderByComparator)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByPrimaryKey(eventoInscricaoId);

		Session session = null;

		try {
			session = openSession();

			EventoInscricao[] array = new EventoInscricaoImpl[3];

			array[0] = getByCG_Usuario_PrevAndNext(session, eventoInscricao,
					companyId, groupId, userNome, orderByComparator, true);

			array[1] = eventoInscricao;

			array[2] = getByCG_Usuario_PrevAndNext(session, eventoInscricao,
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

	protected EventoInscricao getByCG_Usuario_PrevAndNext(Session session,
		EventoInscricao eventoInscricao, long companyId, long groupId,
		String userNome, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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
			query.append(EventoInscricaoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(eventoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Usuario(long companyId, long groupId, String userNome)
		throws SystemException {
		for (EventoInscricao eventoInscricao : findByCG_Usuario(companyId,
				groupId, userNome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos where companyId = &#63; and groupId = &#63; and userNome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userNome the user nome
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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

	private static final String _FINDER_COLUMN_CG_USUARIO_COMPANYID_2 = "eventoInscricao.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_USUARIO_GROUPID_2 = "eventoInscricao.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_USUARIO_USERNOME_1 = "eventoInscricao.userNome LIKE NULL";
	private static final String _FINDER_COLUMN_CG_USUARIO_USERNOME_2 = "eventoInscricao.userNome LIKE ?";
	private static final String _FINDER_COLUMN_CG_USUARIO_USERNOME_3 = "(eventoInscricao.userNome IS NULL OR eventoInscricao.userNome LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			EventoInscricaoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEventoAgendaUsuario",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventoInscricaoModelImpl.EVENTOAGENDAID_COLUMN_BITMASK |
			EventoInscricaoModelImpl.CREATEUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO = new FinderPath(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventoAgendaUsuario",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException} if it could not be found.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the matching evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByEventoAgendaUsuario(eventoAgendaId,
				createUserId);

		if (eventoInscricao == null) {
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

			throw new NoSuchEventoInscricaoException(msg.toString());
		}

		return eventoInscricao;
	}

	/**
	 * Returns the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId) throws SystemException {
		return fetchByEventoAgendaUsuario(eventoAgendaId, createUserId, true);
	}

	/**
	 * Returns the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evento inscricao, or <code>null</code> if a matching evento inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { eventoAgendaId, createUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
					finderArgs, this);
		}

		if (result instanceof EventoInscricao) {
			EventoInscricao eventoInscricao = (EventoInscricao)result;

			if ((eventoAgendaId != eventoInscricao.getEventoAgendaId()) ||
					(createUserId != eventoInscricao.getCreateUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTOINSCRICAO_WHERE);

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

				List<EventoInscricao> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EventoInscricaoPersistenceImpl.fetchByEventoAgendaUsuario(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EventoInscricao eventoInscricao = list.get(0);

					result = eventoInscricao;

					cacheResult(eventoInscricao);

					if ((eventoInscricao.getEventoAgendaId() != eventoAgendaId) ||
							(eventoInscricao.getCreateUserId() != createUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
							finderArgs, eventoInscricao);
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
			return (EventoInscricao)result;
		}
	}

	/**
	 * Removes the evento inscricao where eventoAgendaId = &#63; and createUserId = &#63; from the database.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the evento inscricao that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao removeByEventoAgendaUsuario(long eventoAgendaId,
		long createUserId)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = findByEventoAgendaUsuario(eventoAgendaId,
				createUserId);

		return remove(eventoInscricao);
	}

	/**
	 * Returns the number of evento inscricaos where eventoAgendaId = &#63; and createUserId = &#63;.
	 *
	 * @param eventoAgendaId the evento agenda ID
	 * @param createUserId the create user ID
	 * @return the number of matching evento inscricaos
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

			query.append(_SQL_COUNT_EVENTOINSCRICAO_WHERE);

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
		"eventoInscricao.eventoAgendaId = ? AND ";
	private static final String _FINDER_COLUMN_EVENTOAGENDAUSUARIO_CREATEUSERID_2 =
		"eventoInscricao.createUserId = ?";

	public EventoInscricaoPersistenceImpl() {
		setModelClass(EventoInscricao.class);
	}

	/**
	 * Caches the evento inscricao in the entity cache if it is enabled.
	 *
	 * @param eventoInscricao the evento inscricao
	 */
	@Override
	public void cacheResult(EventoInscricao eventoInscricao) {
		EntityCacheUtil.putResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoImpl.class, eventoInscricao.getPrimaryKey(),
			eventoInscricao);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { eventoInscricao.getUuid(), eventoInscricao.getGroupId() },
			eventoInscricao);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
			new Object[] {
				eventoInscricao.getEventoAgendaId(),
				eventoInscricao.getCreateUserId()
			}, eventoInscricao);

		eventoInscricao.resetOriginalValues();
	}

	/**
	 * Caches the evento inscricaos in the entity cache if it is enabled.
	 *
	 * @param eventoInscricaos the evento inscricaos
	 */
	@Override
	public void cacheResult(List<EventoInscricao> eventoInscricaos) {
		for (EventoInscricao eventoInscricao : eventoInscricaos) {
			if (EntityCacheUtil.getResult(
						EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
						EventoInscricaoImpl.class,
						eventoInscricao.getPrimaryKey()) == null) {
				cacheResult(eventoInscricao);
			}
			else {
				eventoInscricao.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all evento inscricaos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventoInscricaoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventoInscricaoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evento inscricao.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventoInscricao eventoInscricao) {
		EntityCacheUtil.removeResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoImpl.class, eventoInscricao.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(eventoInscricao);
	}

	@Override
	public void clearCache(List<EventoInscricao> eventoInscricaos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventoInscricao eventoInscricao : eventoInscricaos) {
			EntityCacheUtil.removeResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
				EventoInscricaoImpl.class, eventoInscricao.getPrimaryKey());

			clearUniqueFindersCache(eventoInscricao);
		}
	}

	protected void cacheUniqueFindersCache(EventoInscricao eventoInscricao) {
		if (eventoInscricao.isNew()) {
			Object[] args = new Object[] {
					eventoInscricao.getUuid(), eventoInscricao.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				eventoInscricao);

			args = new Object[] {
					eventoInscricao.getEventoAgendaId(),
					eventoInscricao.getCreateUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
				args, eventoInscricao);
		}
		else {
			EventoInscricaoModelImpl eventoInscricaoModelImpl = (EventoInscricaoModelImpl)eventoInscricao;

			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricao.getUuid(), eventoInscricao.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					eventoInscricao);
			}

			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricao.getEventoAgendaId(),
						eventoInscricao.getCreateUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
					args, eventoInscricao);
			}
		}
	}

	protected void clearUniqueFindersCache(EventoInscricao eventoInscricao) {
		EventoInscricaoModelImpl eventoInscricaoModelImpl = (EventoInscricaoModelImpl)eventoInscricao;

		Object[] args = new Object[] {
				eventoInscricao.getUuid(), eventoInscricao.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((eventoInscricaoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventoInscricaoModelImpl.getOriginalUuid(),
					eventoInscricaoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				eventoInscricao.getEventoAgendaId(),
				eventoInscricao.getCreateUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
			args);

		if ((eventoInscricaoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventoInscricaoModelImpl.getOriginalEventoAgendaId(),
					eventoInscricaoModelImpl.getOriginalCreateUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTOAGENDAUSUARIO,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTOAGENDAUSUARIO,
				args);
		}
	}

	/**
	 * Creates a new evento inscricao with the primary key. Does not add the evento inscricao to the database.
	 *
	 * @param eventoInscricaoId the primary key for the new evento inscricao
	 * @return the new evento inscricao
	 */
	@Override
	public EventoInscricao create(long eventoInscricaoId) {
		EventoInscricao eventoInscricao = new EventoInscricaoImpl();

		eventoInscricao.setNew(true);
		eventoInscricao.setPrimaryKey(eventoInscricaoId);

		String uuid = PortalUUIDUtil.generate();

		eventoInscricao.setUuid(uuid);

		return eventoInscricao;
	}

	/**
	 * Removes the evento inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoInscricaoId the primary key of the evento inscricao
	 * @return the evento inscricao that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao remove(long eventoInscricaoId)
		throws NoSuchEventoInscricaoException, SystemException {
		return remove((Serializable)eventoInscricaoId);
	}

	/**
	 * Removes the evento inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evento inscricao
	 * @return the evento inscricao that was removed
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao remove(Serializable primaryKey)
		throws NoSuchEventoInscricaoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventoInscricao eventoInscricao = (EventoInscricao)session.get(EventoInscricaoImpl.class,
					primaryKey);

			if (eventoInscricao == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventoInscricaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventoInscricao);
		}
		catch (NoSuchEventoInscricaoException nsee) {
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
	protected EventoInscricao removeImpl(EventoInscricao eventoInscricao)
		throws SystemException {
		eventoInscricao = toUnwrappedModel(eventoInscricao);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventoInscricao)) {
				eventoInscricao = (EventoInscricao)session.get(EventoInscricaoImpl.class,
						eventoInscricao.getPrimaryKeyObj());
			}

			if (eventoInscricao != null) {
				session.delete(eventoInscricao);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventoInscricao != null) {
			clearCache(eventoInscricao);
		}

		return eventoInscricao;
	}

	@Override
	public EventoInscricao updateImpl(
		br.com.prodevelopment.lapidarios.evento.model.EventoInscricao eventoInscricao)
		throws SystemException {
		eventoInscricao = toUnwrappedModel(eventoInscricao);

		boolean isNew = eventoInscricao.isNew();

		EventoInscricaoModelImpl eventoInscricaoModelImpl = (EventoInscricaoModelImpl)eventoInscricao;

		if (Validator.isNull(eventoInscricao.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			eventoInscricao.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (eventoInscricao.isNew()) {
				session.save(eventoInscricao);

				eventoInscricao.setNew(false);
			}
			else {
				session.merge(eventoInscricao);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventoInscricaoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricaoModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { eventoInscricaoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricaoModelImpl.getOriginalUuid(),
						eventoInscricaoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						eventoInscricaoModelImpl.getUuid(),
						eventoInscricaoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricaoModelImpl.getOriginalCompanyId(),
						eventoInscricaoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						eventoInscricaoModelImpl.getCompanyId(),
						eventoInscricaoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}

			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricaoModelImpl.getOriginalCompanyId(),
						eventoInscricaoModelImpl.getOriginalGroupId(),
						eventoInscricaoModelImpl.getOriginalEventoAgendaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA,
					args);

				args = new Object[] {
						eventoInscricaoModelImpl.getCompanyId(),
						eventoInscricaoModelImpl.getGroupId(),
						eventoInscricaoModelImpl.getEventoAgendaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTOAGENDA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTOAGENDA,
					args);
			}

			if ((eventoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventoInscricaoModelImpl.getOriginalCompanyId(),
						eventoInscricaoModelImpl.getOriginalGroupId(),
						eventoInscricaoModelImpl.getOriginalEventoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO,
					args);

				args = new Object[] {
						eventoInscricaoModelImpl.getCompanyId(),
						eventoInscricaoModelImpl.getGroupId(),
						eventoInscricaoModelImpl.getEventoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_EVENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_EVENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			EventoInscricaoImpl.class, eventoInscricao.getPrimaryKey(),
			eventoInscricao);

		clearUniqueFindersCache(eventoInscricao);
		cacheUniqueFindersCache(eventoInscricao);

		return eventoInscricao;
	}

	protected EventoInscricao toUnwrappedModel(EventoInscricao eventoInscricao) {
		if (eventoInscricao instanceof EventoInscricaoImpl) {
			return eventoInscricao;
		}

		EventoInscricaoImpl eventoInscricaoImpl = new EventoInscricaoImpl();

		eventoInscricaoImpl.setNew(eventoInscricao.isNew());
		eventoInscricaoImpl.setPrimaryKey(eventoInscricao.getPrimaryKey());

		eventoInscricaoImpl.setUuid(eventoInscricao.getUuid());
		eventoInscricaoImpl.setEventoInscricaoId(eventoInscricao.getEventoInscricaoId());
		eventoInscricaoImpl.setCompanyId(eventoInscricao.getCompanyId());
		eventoInscricaoImpl.setGroupId(eventoInscricao.getGroupId());
		eventoInscricaoImpl.setCreateUserId(eventoInscricao.getCreateUserId());
		eventoInscricaoImpl.setCreateDate(eventoInscricao.getCreateDate());
		eventoInscricaoImpl.setEventoAgendaId(eventoInscricao.getEventoAgendaId());
		eventoInscricaoImpl.setEventoId(eventoInscricao.getEventoId());
		eventoInscricaoImpl.setUserNome(eventoInscricao.getUserNome());

		return eventoInscricaoImpl;
	}

	/**
	 * Returns the evento inscricao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento inscricao
	 * @return the evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventoInscricaoException, SystemException {
		EventoInscricao eventoInscricao = fetchByPrimaryKey(primaryKey);

		if (eventoInscricao == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventoInscricaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventoInscricao;
	}

	/**
	 * Returns the evento inscricao with the primary key or throws a {@link br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException} if it could not be found.
	 *
	 * @param eventoInscricaoId the primary key of the evento inscricao
	 * @return the evento inscricao
	 * @throws br.com.prodevelopment.lapidarios.evento.NoSuchEventoInscricaoException if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao findByPrimaryKey(long eventoInscricaoId)
		throws NoSuchEventoInscricaoException, SystemException {
		return findByPrimaryKey((Serializable)eventoInscricaoId);
	}

	/**
	 * Returns the evento inscricao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evento inscricao
	 * @return the evento inscricao, or <code>null</code> if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventoInscricao eventoInscricao = (EventoInscricao)EntityCacheUtil.getResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
				EventoInscricaoImpl.class, primaryKey);

		if (eventoInscricao == _nullEventoInscricao) {
			return null;
		}

		if (eventoInscricao == null) {
			Session session = null;

			try {
				session = openSession();

				eventoInscricao = (EventoInscricao)session.get(EventoInscricaoImpl.class,
						primaryKey);

				if (eventoInscricao != null) {
					cacheResult(eventoInscricao);
				}
				else {
					EntityCacheUtil.putResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
						EventoInscricaoImpl.class, primaryKey,
						_nullEventoInscricao);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
					EventoInscricaoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventoInscricao;
	}

	/**
	 * Returns the evento inscricao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoInscricaoId the primary key of the evento inscricao
	 * @return the evento inscricao, or <code>null</code> if a evento inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventoInscricao fetchByPrimaryKey(long eventoInscricaoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventoInscricaoId);
	}

	/**
	 * Returns all the evento inscricaos.
	 *
	 * @return the evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evento inscricaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @return the range of evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evento inscricaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.evento.model.impl.EventoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento inscricaos
	 * @param end the upper bound of the range of evento inscricaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evento inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventoInscricao> findAll(int start, int end,
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

		List<EventoInscricao> list = (List<EventoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTOINSCRICAO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTOINSCRICAO;

				if (pagination) {
					sql = sql.concat(EventoInscricaoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventoInscricao>(list);
				}
				else {
					list = (List<EventoInscricao>)QueryUtil.list(q,
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
	 * Removes all the evento inscricaos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventoInscricao eventoInscricao : findAll()) {
			remove(eventoInscricao);
		}
	}

	/**
	 * Returns the number of evento inscricaos.
	 *
	 * @return the number of evento inscricaos
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

				Query q = session.createQuery(_SQL_COUNT_EVENTOINSCRICAO);

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
	 * Initializes the evento inscricao persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.lapidarios.evento.model.EventoInscricao")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventoInscricao>> listenersList = new ArrayList<ModelListener<EventoInscricao>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventoInscricao>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventoInscricaoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTOINSCRICAO = "SELECT eventoInscricao FROM EventoInscricao eventoInscricao";
	private static final String _SQL_SELECT_EVENTOINSCRICAO_WHERE = "SELECT eventoInscricao FROM EventoInscricao eventoInscricao WHERE ";
	private static final String _SQL_COUNT_EVENTOINSCRICAO = "SELECT COUNT(eventoInscricao) FROM EventoInscricao eventoInscricao";
	private static final String _SQL_COUNT_EVENTOINSCRICAO_WHERE = "SELECT COUNT(eventoInscricao) FROM EventoInscricao eventoInscricao WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventoInscricao.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventoInscricao exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventoInscricao exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventoInscricaoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static EventoInscricao _nullEventoInscricao = new EventoInscricaoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventoInscricao> toCacheModel() {
				return _nullEventoInscricaoCacheModel;
			}
		};

	private static CacheModel<EventoInscricao> _nullEventoInscricaoCacheModel = new CacheModel<EventoInscricao>() {
			@Override
			public EventoInscricao toEntityModel() {
				return _nullEventoInscricao;
			}
		};
}