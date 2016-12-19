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

package br.com.prodevelopment.lapidarios.loja.service.persistence;

import br.com.prodevelopment.lapidarios.loja.NoSuchLojaException;
import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.model.impl.LojaImpl;
import br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl;

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
 * The persistence implementation for the loja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaPersistence
 * @see LojaUtil
 * @generated
 */
public class LojaPersistenceImpl extends BasePersistenceImpl<Loja>
	implements LojaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LojaUtil} to access the loja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LojaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LojaModelImpl.UUID_COLUMN_BITMASK |
			LojaModelImpl.NOMEFANTASIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lojas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByUuid(String uuid, int start, int end,
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

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if (!Validator.equals(uuid, loja.getUuid())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByUuid_First(uuid, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByUuid_Last(uuid, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where uuid = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByUuid_PrevAndNext(long lojaId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, loja, uuid,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByUuid_PrevAndNext(session, loja, uuid,
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

	protected Loja getByUuid_PrevAndNext(Session session, Loja loja,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lojas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Loja loja : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lojas
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

			query.append(_SQL_COUNT_LOJA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "loja.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "loja.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(loja.uuid IS NULL OR loja.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			LojaModelImpl.UUID_COLUMN_BITMASK |
			LojaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the loja where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByUUID_G(String uuid, long groupId)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByUUID_G(uuid, groupId);

		if (loja == null) {
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

			throw new NoSuchLojaException(msg.toString());
		}

		return loja;
	}

	/**
	 * Returns the loja where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the loja where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Loja) {
			Loja loja = (Loja)result;

			if (!Validator.equals(uuid, loja.getUuid()) ||
					(groupId != loja.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LOJA_WHERE);

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

				List<Loja> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Loja loja = list.get(0);

					result = loja;

					cacheResult(loja);

					if ((loja.getUuid() == null) ||
							!loja.getUuid().equals(uuid) ||
							(loja.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, loja);
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
			return (Loja)result;
		}
	}

	/**
	 * Removes the loja where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the loja that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja removeByUUID_G(String uuid, long groupId)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByUUID_G(uuid, groupId);

		return remove(loja);
	}

	/**
	 * Returns the number of lojas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lojas
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

			query.append(_SQL_COUNT_LOJA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "loja.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "loja.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(loja.uuid IS NULL OR loja.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "loja.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			LojaModelImpl.UUID_COLUMN_BITMASK |
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.NOMEFANTASIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lojas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByUuid_C(String uuid, long companyId, int start,
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

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if (!Validator.equals(uuid, loja.getUuid()) ||
						(companyId != loja.getCompanyId())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByUuid_C_PrevAndNext(long lojaId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, loja, uuid, companyId,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByUuid_C_PrevAndNext(session, loja, uuid, companyId,
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

	protected Loja getByUuid_C_PrevAndNext(Session session, Loja loja,
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

		query.append(_SQL_SELECT_LOJA_WHERE);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lojas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Loja loja : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lojas
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

			query.append(_SQL_COUNT_LOJA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "loja.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "loja.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(loja.uuid IS NULL OR loja.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "loja.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.NOMEFANTASIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lojas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCompany(long companyId) throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCompany_First(companyId, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCompany_Last(companyId, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCompany_PrevAndNext(long lojaId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCompany_PrevAndNext(session, loja, companyId,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByCompany_PrevAndNext(session, loja, companyId,
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

	protected Loja getByCompany_PrevAndNext(Session session, Loja loja,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lojas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Loja loja : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompany(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "loja.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.GROUPID_COLUMN_BITMASK |
			LojaModelImpl.NOMEFANTASIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG(long companyId, long groupId, int start, int end)
		throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG(long companyId, long groupId, int start,
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

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_First(companyId, groupId, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByCG(companyId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_Last(companyId, groupId, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCG(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCG_PrevAndNext(long lojaId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCG_PrevAndNext(session, loja, companyId, groupId,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByCG_PrevAndNext(session, loja, companyId, groupId,
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

	protected Loja getByCG_PrevAndNext(Session session, Loja loja,
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

		query.append(_SQL_SELECT_LOJA_WHERE);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lojas where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (Loja loja : findByCG(companyId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching lojas
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

			query.append(_SQL_COUNT_LOJA_WHERE);

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

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "loja.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RAZAOSOCIAL =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRazaoSocial",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_RAZAOSOCIAL =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRazaoSocial",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lojas where razaoSocial LIKE &#63;.
	 *
	 * @param razaoSocial the razao social
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByRazaoSocial(String razaoSocial)
		throws SystemException {
		return findByRazaoSocial(razaoSocial, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where razaoSocial LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param razaoSocial the razao social
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByRazaoSocial(String razaoSocial, int start, int end)
		throws SystemException {
		return findByRazaoSocial(razaoSocial, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where razaoSocial LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param razaoSocial the razao social
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByRazaoSocial(String razaoSocial, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RAZAOSOCIAL;
		finderArgs = new Object[] { razaoSocial, start, end, orderByComparator };

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if (!StringUtil.wildcardMatches(loja.getRazaoSocial(),
							razaoSocial, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean bindRazaoSocial = false;

			if (razaoSocial == null) {
				query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_1);
			}
			else if (razaoSocial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_3);
			}
			else {
				bindRazaoSocial = true;

				query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRazaoSocial) {
					qPos.add(razaoSocial);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where razaoSocial LIKE &#63;.
	 *
	 * @param razaoSocial the razao social
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByRazaoSocial_First(String razaoSocial,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByRazaoSocial_First(razaoSocial, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("razaoSocial=");
		msg.append(razaoSocial);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where razaoSocial LIKE &#63;.
	 *
	 * @param razaoSocial the razao social
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByRazaoSocial_First(String razaoSocial,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByRazaoSocial(razaoSocial, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where razaoSocial LIKE &#63;.
	 *
	 * @param razaoSocial the razao social
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByRazaoSocial_Last(String razaoSocial,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByRazaoSocial_Last(razaoSocial, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("razaoSocial=");
		msg.append(razaoSocial);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where razaoSocial LIKE &#63;.
	 *
	 * @param razaoSocial the razao social
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByRazaoSocial_Last(String razaoSocial,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRazaoSocial(razaoSocial);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByRazaoSocial(razaoSocial, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where razaoSocial LIKE &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param razaoSocial the razao social
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByRazaoSocial_PrevAndNext(long lojaId,
		String razaoSocial, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByRazaoSocial_PrevAndNext(session, loja, razaoSocial,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByRazaoSocial_PrevAndNext(session, loja, razaoSocial,
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

	protected Loja getByRazaoSocial_PrevAndNext(Session session, Loja loja,
		String razaoSocial, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		boolean bindRazaoSocial = false;

		if (razaoSocial == null) {
			query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_1);
		}
		else if (razaoSocial.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_3);
		}
		else {
			bindRazaoSocial = true;

			query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_2);
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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRazaoSocial) {
			qPos.add(razaoSocial);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lojas where razaoSocial LIKE &#63; from the database.
	 *
	 * @param razaoSocial the razao social
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRazaoSocial(String razaoSocial)
		throws SystemException {
		for (Loja loja : findByRazaoSocial(razaoSocial, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where razaoSocial LIKE &#63;.
	 *
	 * @param razaoSocial the razao social
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRazaoSocial(String razaoSocial) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_RAZAOSOCIAL;

		Object[] finderArgs = new Object[] { razaoSocial };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean bindRazaoSocial = false;

			if (razaoSocial == null) {
				query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_1);
			}
			else if (razaoSocial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_3);
			}
			else {
				bindRazaoSocial = true;

				query.append(_FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRazaoSocial) {
					qPos.add(razaoSocial);
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

	private static final String _FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_1 = "loja.razaoSocial LIKE NULL";
	private static final String _FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_2 = "loja.razaoSocial LIKE ?";
	private static final String _FINDER_COLUMN_RAZAOSOCIAL_RAZAOSOCIAL_3 = "(loja.razaoSocial IS NULL OR loja.razaoSocial LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RAZAOSOCIAL =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_RazaoSocial",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RAZAOSOCIAL =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_RazaoSocial",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int status) throws SystemException {
		return findByCG_RazaoSocial(companyId, groupId, razaoSocial, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int status, int start, int end)
		throws SystemException {
		return findByCG_RazaoSocial(companyId, groupId, razaoSocial, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RAZAOSOCIAL;
		finderArgs = new Object[] {
				companyId, groupId, razaoSocial, status,
				
				start, end, orderByComparator
			};

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						!StringUtil.wildcardMatches(loja.getRazaoSocial(),
							razaoSocial, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(status != loja.getStatus())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_2);

			boolean bindRazaoSocial = false;

			if (razaoSocial == null) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_1);
			}
			else if (razaoSocial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_3);
			}
			else {
				bindRazaoSocial = true;

				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_2);
			}

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindRazaoSocial) {
					qPos.add(razaoSocial);
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_RazaoSocial_First(long companyId, long groupId,
		String razaoSocial, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_RazaoSocial_First(companyId, groupId,
				razaoSocial, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", razaoSocial=");
		msg.append(razaoSocial);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_RazaoSocial_First(long companyId, long groupId,
		String razaoSocial, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Loja> list = findByCG_RazaoSocial(companyId, groupId, razaoSocial,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_RazaoSocial_Last(long companyId, long groupId,
		String razaoSocial, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_RazaoSocial_Last(companyId, groupId, razaoSocial,
				status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", razaoSocial=");
		msg.append(razaoSocial);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_RazaoSocial_Last(long companyId, long groupId,
		String razaoSocial, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_RazaoSocial(companyId, groupId, razaoSocial,
				status);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCG_RazaoSocial(companyId, groupId, razaoSocial,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCG_RazaoSocial_PrevAndNext(long lojaId, long companyId,
		long groupId, String razaoSocial, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCG_RazaoSocial_PrevAndNext(session, loja,
					companyId, groupId, razaoSocial, status, orderByComparator,
					true);

			array[1] = loja;

			array[2] = getByCG_RazaoSocial_PrevAndNext(session, loja,
					companyId, groupId, razaoSocial, status, orderByComparator,
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

	protected Loja getByCG_RazaoSocial_PrevAndNext(Session session, Loja loja,
		long companyId, long groupId, String razaoSocial, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_2);

		boolean bindRazaoSocial = false;

		if (razaoSocial == null) {
			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_1);
		}
		else if (razaoSocial.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_3);
		}
		else {
			bindRazaoSocial = true;

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_2);
		}

		query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_2);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindRazaoSocial) {
			qPos.add(razaoSocial);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param statuses the statuses
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int[] statuses) throws SystemException {
		return findByCG_RazaoSocial(companyId, groupId, razaoSocial, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_RazaoSocial(companyId, groupId, razaoSocial, statuses,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_RazaoSocial(companyId, groupId, razaoSocial,
				statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, razaoSocial, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, razaoSocial, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RAZAOSOCIAL,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						!StringUtil.wildcardMatches(loja.getRazaoSocial(),
							razaoSocial, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!ArrayUtil.contains(statuses, loja.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindRazaoSocial = false;

			if (razaoSocial == null) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_4);
			}
			else if (razaoSocial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_6);
			}
			else {
				bindRazaoSocial = true;

				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_5);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindRazaoSocial) {
					qPos.add(razaoSocial);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RAZAOSOCIAL,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_RAZAOSOCIAL,
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
	 * Removes all the lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int status) throws SystemException {
		for (Loja loja : findByCG_RazaoSocial(companyId, groupId, razaoSocial,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RAZAOSOCIAL;

		Object[] finderArgs = new Object[] {
				companyId, groupId, razaoSocial, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_2);

			boolean bindRazaoSocial = false;

			if (razaoSocial == null) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_1);
			}
			else if (razaoSocial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_3);
			}
			else {
				bindRazaoSocial = true;

				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_2);
			}

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindRazaoSocial) {
					qPos.add(razaoSocial);
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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and razaoSocial LIKE &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param razaoSocial the razao social
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_RazaoSocial(long companyId, long groupId,
		String razaoSocial, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, razaoSocial, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RAZAOSOCIAL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindRazaoSocial = false;

			if (razaoSocial == null) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_4);
			}
			else if (razaoSocial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_6);
			}
			else {
				bindRazaoSocial = true;

				query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_5);

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

				if (bindRazaoSocial) {
					qPos.add(razaoSocial);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RAZAOSOCIAL,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_RAZAOSOCIAL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_2 = "loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RAZAOSOCIAL_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_2 = "loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RAZAOSOCIAL_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_1 = "loja.razaoSocial LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_2 = "loja.razaoSocial LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_3 = "(loja.razaoSocial IS NULL OR loja.razaoSocial LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_1) + ")";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_2) + ")";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RAZAOSOCIAL_RAZAOSOCIAL_3) + ")";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_2 = "loja.status = ?";
	private static final String _FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_RAZAOSOCIAL_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOMEFANTASIA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeFantasia",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOMEFANTASIA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNomeFantasia",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lojas where nomeFantasia LIKE &#63;.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByNomeFantasia(String nomeFantasia)
		throws SystemException {
		return findByNomeFantasia(nomeFantasia, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where nomeFantasia LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeFantasia the nome fantasia
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByNomeFantasia(String nomeFantasia, int start, int end)
		throws SystemException {
		return findByNomeFantasia(nomeFantasia, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where nomeFantasia LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeFantasia the nome fantasia
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByNomeFantasia(String nomeFantasia, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOMEFANTASIA;
		finderArgs = new Object[] { nomeFantasia, start, end, orderByComparator };

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if (!StringUtil.wildcardMatches(loja.getNomeFantasia(),
							nomeFantasia, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_1);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_3);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where nomeFantasia LIKE &#63;.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByNomeFantasia_First(String nomeFantasia,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByNomeFantasia_First(nomeFantasia, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeFantasia=");
		msg.append(nomeFantasia);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where nomeFantasia LIKE &#63;.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByNomeFantasia_First(String nomeFantasia,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByNomeFantasia(nomeFantasia, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where nomeFantasia LIKE &#63;.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByNomeFantasia_Last(String nomeFantasia,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByNomeFantasia_Last(nomeFantasia, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeFantasia=");
		msg.append(nomeFantasia);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where nomeFantasia LIKE &#63;.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByNomeFantasia_Last(String nomeFantasia,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNomeFantasia(nomeFantasia);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByNomeFantasia(nomeFantasia, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where nomeFantasia LIKE &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param nomeFantasia the nome fantasia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByNomeFantasia_PrevAndNext(long lojaId,
		String nomeFantasia, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByNomeFantasia_PrevAndNext(session, loja,
					nomeFantasia, orderByComparator, true);

			array[1] = loja;

			array[2] = getByNomeFantasia_PrevAndNext(session, loja,
					nomeFantasia, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loja getByNomeFantasia_PrevAndNext(Session session, Loja loja,
		String nomeFantasia, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		boolean bindNomeFantasia = false;

		if (nomeFantasia == null) {
			query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_1);
		}
		else if (nomeFantasia.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_3);
		}
		else {
			bindNomeFantasia = true;

			query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_2);
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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNomeFantasia) {
			qPos.add(nomeFantasia);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lojas where nomeFantasia LIKE &#63; from the database.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNomeFantasia(String nomeFantasia)
		throws SystemException {
		for (Loja loja : findByNomeFantasia(nomeFantasia, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where nomeFantasia LIKE &#63;.
	 *
	 * @param nomeFantasia the nome fantasia
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNomeFantasia(String nomeFantasia)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOMEFANTASIA;

		Object[] finderArgs = new Object[] { nomeFantasia };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_1);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_3);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
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

	private static final String _FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_1 = "loja.nomeFantasia LIKE NULL";
	private static final String _FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_2 = "loja.nomeFantasia LIKE ?";
	private static final String _FINDER_COLUMN_NOMEFANTASIA_NOMEFANTASIA_3 = "(loja.nomeFantasia IS NULL OR loja.nomeFantasia LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOMEFANTASIA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_NomeFantasia",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOMEFANTASIA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_NomeFantasia",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int status) throws SystemException {
		return findByCG_NomeFantasia(companyId, groupId, nomeFantasia, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int status, int start, int end)
		throws SystemException {
		return findByCG_NomeFantasia(companyId, groupId, nomeFantasia, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOMEFANTASIA;
		finderArgs = new Object[] {
				companyId, groupId, nomeFantasia, status,
				
				start, end, orderByComparator
			};

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						!StringUtil.wildcardMatches(loja.getNomeFantasia(),
							nomeFantasia, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(status != loja.getStatus())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_2);

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_1);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_3);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_2);
			}

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_NomeFantasia_First(long companyId, long groupId,
		String nomeFantasia, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_NomeFantasia_First(companyId, groupId,
				nomeFantasia, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nomeFantasia=");
		msg.append(nomeFantasia);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_NomeFantasia_First(long companyId, long groupId,
		String nomeFantasia, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Loja> list = findByCG_NomeFantasia(companyId, groupId,
				nomeFantasia, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_NomeFantasia_Last(long companyId, long groupId,
		String nomeFantasia, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_NomeFantasia_Last(companyId, groupId,
				nomeFantasia, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nomeFantasia=");
		msg.append(nomeFantasia);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_NomeFantasia_Last(long companyId, long groupId,
		String nomeFantasia, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_NomeFantasia(companyId, groupId, nomeFantasia,
				status);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCG_NomeFantasia(companyId, groupId,
				nomeFantasia, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCG_NomeFantasia_PrevAndNext(long lojaId,
		long companyId, long groupId, String nomeFantasia, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCG_NomeFantasia_PrevAndNext(session, loja,
					companyId, groupId, nomeFantasia, status,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByCG_NomeFantasia_PrevAndNext(session, loja,
					companyId, groupId, nomeFantasia, status,
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

	protected Loja getByCG_NomeFantasia_PrevAndNext(Session session, Loja loja,
		long companyId, long groupId, String nomeFantasia, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_2);

		boolean bindNomeFantasia = false;

		if (nomeFantasia == null) {
			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_1);
		}
		else if (nomeFantasia.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_3);
		}
		else {
			bindNomeFantasia = true;

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_2);
		}

		query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_2);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNomeFantasia) {
			qPos.add(nomeFantasia);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int[] statuses) throws SystemException {
		return findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
			statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_NomeFantasia(companyId, groupId, nomeFantasia,
				statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, nomeFantasia, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, nomeFantasia, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOMEFANTASIA,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						!StringUtil.wildcardMatches(loja.getNomeFantasia(),
							nomeFantasia, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!ArrayUtil.contains(statuses, loja.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_4);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_6);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_5);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOMEFANTASIA,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_NOMEFANTASIA,
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
	 * Removes all the lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int status) throws SystemException {
		for (Loja loja : findByCG_NomeFantasia(companyId, groupId,
				nomeFantasia, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOMEFANTASIA;

		Object[] finderArgs = new Object[] {
				companyId, groupId, nomeFantasia, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_2);

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_1);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_3);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_2);
			}

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_NomeFantasia(long companyId, long groupId,
		String nomeFantasia, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, nomeFantasia, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOMEFANTASIA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_4);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_6);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_5);

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

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOMEFANTASIA,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_NOMEFANTASIA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_2 = "loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_NOMEFANTASIA_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_2 = "loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_NOMEFANTASIA_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_1 = "loja.nomeFantasia LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_2 = "loja.nomeFantasia LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_3 = "(loja.nomeFantasia IS NULL OR loja.nomeFantasia LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_1) + ")";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_2) + ")";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_NOMEFANTASIA_NOMEFANTASIA_3) + ")";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_2 = "loja.status = ?";
	private static final String _FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_NOMEFANTASIA_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_FETCH_BY_CNPJ = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCNPJ",
			new String[] { String.class.getName() },
			LojaModelImpl.CNPJ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CNPJ = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCNPJ",
			new String[] { String.class.getName() });

	/**
	 * Returns the loja where cnpj = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	 *
	 * @param cnpj the cnpj
	 * @return the matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCNPJ(String cnpj)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCNPJ(cnpj);

		if (loja == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cnpj=");
			msg.append(cnpj);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLojaException(msg.toString());
		}

		return loja;
	}

	/**
	 * Returns the loja where cnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCNPJ(String cnpj) throws SystemException {
		return fetchByCNPJ(cnpj, true);
	}

	/**
	 * Returns the loja where cnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCNPJ(String cnpj, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cnpj };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CNPJ,
					finderArgs, this);
		}

		if (result instanceof Loja) {
			Loja loja = (Loja)result;

			if (!Validator.equals(cnpj, loja.getCnpj())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean bindCnpj = false;

			if (cnpj == null) {
				query.append(_FINDER_COLUMN_CNPJ_CNPJ_1);
			}
			else if (cnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNPJ_CNPJ_3);
			}
			else {
				bindCnpj = true;

				query.append(_FINDER_COLUMN_CNPJ_CNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCnpj) {
					qPos.add(cnpj);
				}

				List<Loja> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CNPJ,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LojaPersistenceImpl.fetchByCNPJ(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Loja loja = list.get(0);

					result = loja;

					cacheResult(loja);

					if ((loja.getCnpj() == null) ||
							!loja.getCnpj().equals(cnpj)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CNPJ,
							finderArgs, loja);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CNPJ,
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
			return (Loja)result;
		}
	}

	/**
	 * Removes the loja where cnpj = &#63; from the database.
	 *
	 * @param cnpj the cnpj
	 * @return the loja that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja removeByCNPJ(String cnpj)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByCNPJ(cnpj);

		return remove(loja);
	}

	/**
	 * Returns the number of lojas where cnpj = &#63;.
	 *
	 * @param cnpj the cnpj
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCNPJ(String cnpj) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CNPJ;

		Object[] finderArgs = new Object[] { cnpj };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean bindCnpj = false;

			if (cnpj == null) {
				query.append(_FINDER_COLUMN_CNPJ_CNPJ_1);
			}
			else if (cnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNPJ_CNPJ_3);
			}
			else {
				bindCnpj = true;

				query.append(_FINDER_COLUMN_CNPJ_CNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCnpj) {
					qPos.add(cnpj);
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

	private static final String _FINDER_COLUMN_CNPJ_CNPJ_1 = "loja.cnpj IS NULL";
	private static final String _FINDER_COLUMN_CNPJ_CNPJ_2 = "loja.cnpj = ?";
	private static final String _FINDER_COLUMN_CNPJ_CNPJ_3 = "(loja.cnpj IS NULL OR loja.cnpj = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CG_CNPJ = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCG_CNPJ",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			},
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.GROUPID_COLUMN_BITMASK |
			LojaModelImpl.CNPJ_COLUMN_BITMASK |
			LojaModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_CNPJ = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_CNPJ",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CNPJ = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_CNPJ",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cnpj the cnpj
	 * @param status the status
	 * @return the matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_CNPJ(long companyId, long groupId, String cnpj,
		int status) throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_CNPJ(companyId, groupId, cnpj, status);

		if (loja == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", cnpj=");
			msg.append(cnpj);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLojaException(msg.toString());
		}

		return loja;
	}

	/**
	 * Returns the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cnpj the cnpj
	 * @param status the status
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_CNPJ(long companyId, long groupId, String cnpj,
		int status) throws SystemException {
		return fetchByCG_CNPJ(companyId, groupId, cnpj, status, true);
	}

	/**
	 * Returns the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cnpj the cnpj
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_CNPJ(long companyId, long groupId, String cnpj,
		int status, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, cnpj, status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CG_CNPJ,
					finderArgs, this);
		}

		if (result instanceof Loja) {
			Loja loja = (Loja)result;

			if ((companyId != loja.getCompanyId()) ||
					(groupId != loja.getGroupId()) ||
					!Validator.equals(cnpj, loja.getCnpj()) ||
					(status != loja.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_CNPJ_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CNPJ_GROUPID_2);

			boolean bindCnpj = false;

			if (cnpj == null) {
				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_1);
			}
			else if (cnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_3);
			}
			else {
				bindCnpj = true;

				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_2);
			}

			query.append(_FINDER_COLUMN_CG_CNPJ_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCnpj) {
					qPos.add(cnpj);
				}

				qPos.add(status);

				List<Loja> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_CNPJ,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LojaPersistenceImpl.fetchByCG_CNPJ(long, long, String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Loja loja = list.get(0);

					result = loja;

					cacheResult(loja);

					if ((loja.getCompanyId() != companyId) ||
							(loja.getGroupId() != groupId) ||
							(loja.getCnpj() == null) ||
							!loja.getCnpj().equals(cnpj) ||
							(loja.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_CNPJ,
							finderArgs, loja);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_CNPJ,
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
			return (Loja)result;
		}
	}

	/**
	 * Removes the loja where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cnpj the cnpj
	 * @param status the status
	 * @return the loja that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja removeByCG_CNPJ(long companyId, long groupId, String cnpj,
		int status) throws NoSuchLojaException, SystemException {
		Loja loja = findByCG_CNPJ(companyId, groupId, cnpj, status);

		return remove(loja);
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cnpj the cnpj
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_CNPJ(long companyId, long groupId, String cnpj,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_CNPJ;

		Object[] finderArgs = new Object[] { companyId, groupId, cnpj, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_CNPJ_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CNPJ_GROUPID_2);

			boolean bindCnpj = false;

			if (cnpj == null) {
				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_1);
			}
			else if (cnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_3);
			}
			else {
				bindCnpj = true;

				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_2);
			}

			query.append(_FINDER_COLUMN_CG_CNPJ_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCnpj) {
					qPos.add(cnpj);
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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and cnpj = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cnpj the cnpj
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_CNPJ(long companyId, long groupId, String cnpj,
		int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, cnpj, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CNPJ,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CNPJ_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CNPJ_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindCnpj = false;

			if (cnpj == null) {
				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_4);
			}
			else if (cnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_6);
			}
			else {
				bindCnpj = true;

				query.append(_FINDER_COLUMN_CG_CNPJ_CNPJ_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_CNPJ_STATUS_5);

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

				if (bindCnpj) {
					qPos.add(cnpj);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CNPJ,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CNPJ,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_CNPJ_COMPANYID_2 = "loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CNPJ_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CNPJ_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_CNPJ_GROUPID_2 = "loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CNPJ_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CNPJ_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_CNPJ_CNPJ_1 = "loja.cnpj IS NULL AND ";
	private static final String _FINDER_COLUMN_CG_CNPJ_CNPJ_2 = "loja.cnpj = ? AND ";
	private static final String _FINDER_COLUMN_CG_CNPJ_CNPJ_3 = "(loja.cnpj IS NULL OR loja.cnpj = '') AND ";
	private static final String _FINDER_COLUMN_CG_CNPJ_CNPJ_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CNPJ_CNPJ_1) + ")";
	private static final String _FINDER_COLUMN_CG_CNPJ_CNPJ_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CNPJ_CNPJ_2) + ")";
	private static final String _FINDER_COLUMN_CG_CNPJ_CNPJ_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CNPJ_CNPJ_3) + ")";
	private static final String _FINDER_COLUMN_CG_CNPJ_STATUS_2 = "loja.status = ?";
	private static final String _FINDER_COLUMN_CG_CNPJ_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CNPJ_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_ORDEMINDICADA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_OrdemIndicada",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_ORDEMINDICADA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCG_OrdemIndicada",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.GROUPID_COLUMN_BITMASK |
			LojaModelImpl.ORDEMINDICADA_COLUMN_BITMASK |
			LojaModelImpl.STATUS_COLUMN_BITMASK |
			LojaModelImpl.NOMEFANTASIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_ORDEMINDICADA = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_OrdemIndicada",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_OrdemIndicada",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status) throws SystemException {
		return findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status, int start, int end)
		throws SystemException {
		return findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_ORDEMINDICADA;
			finderArgs = new Object[] { companyId, groupId, ordemIndicada, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_ORDEMINDICADA;
			finderArgs = new Object[] {
					companyId, groupId, ordemIndicada, status,
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						(ordemIndicada != loja.getOrdemIndicada()) ||
						(status != loja.getStatus())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(ordemIndicada);

				qPos.add(status);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_OrdemIndicada_First(long companyId, long groupId,
		int ordemIndicada, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_OrdemIndicada_First(companyId, groupId,
				ordemIndicada, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", ordemIndicada=");
		msg.append(ordemIndicada);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_OrdemIndicada_First(long companyId, long groupId,
		int ordemIndicada, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Loja> list = findByCG_OrdemIndicada(companyId, groupId,
				ordemIndicada, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_OrdemIndicada_Last(long companyId, long groupId,
		int ordemIndicada, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_OrdemIndicada_Last(companyId, groupId,
				ordemIndicada, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", ordemIndicada=");
		msg.append(ordemIndicada);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_OrdemIndicada_Last(long companyId, long groupId,
		int ordemIndicada, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
				status);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCG_OrdemIndicada(companyId, groupId,
				ordemIndicada, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCG_OrdemIndicada_PrevAndNext(long lojaId,
		long companyId, long groupId, int ordemIndicada, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCG_OrdemIndicada_PrevAndNext(session, loja,
					companyId, groupId, ordemIndicada, status,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByCG_OrdemIndicada_PrevAndNext(session, loja,
					companyId, groupId, ordemIndicada, status,
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

	protected Loja getByCG_OrdemIndicada_PrevAndNext(Session session,
		Loja loja, long companyId, long groupId, int ordemIndicada, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_2);

		query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_2);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(ordemIndicada);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param statuses the statuses
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int[] statuses) throws SystemException {
		return findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
			statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_OrdemIndicada(companyId, groupId, ordemIndicada,
				statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, ordemIndicada,
					StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, ordemIndicada,
					StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_ORDEMINDICADA,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						(ordemIndicada != loja.getOrdemIndicada()) ||
						!ArrayUtil.contains(statuses, loja.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_5);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(ordemIndicada);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_ORDEMINDICADA,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_ORDEMINDICADA,
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
	 * Removes all the lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status) throws SystemException {
		for (Loja loja : findByCG_OrdemIndicada(companyId, groupId,
				ordemIndicada, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_ORDEMINDICADA;

		Object[] finderArgs = new Object[] {
				companyId, groupId, ordemIndicada, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(ordemIndicada);

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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicada = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicada the ordem indicada
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_OrdemIndicada(long companyId, long groupId,
		int ordemIndicada, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, ordemIndicada, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_5);

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

				qPos.add(ordemIndicada);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADA,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_2 = "loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADA_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_2 = "loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADA_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_2 = "loja.ordemIndicada = ? AND ";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADA_ORDEMINDICADA_2) +
		")";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_2 = "loja.status = ?";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADA_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCG_OrdemIndicadaAtual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			},
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.GROUPID_COLUMN_BITMASK |
			LojaModelImpl.ORDEMINDICADAATUAL_COLUMN_BITMASK |
			LojaModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_ORDEMINDICADAATUAL = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_OrdemIndicadaAtual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADAATUAL =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCG_OrdemIndicadaAtual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicadaAtual the ordem indicada atual
	 * @param status the status
	 * @return the matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int status)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_OrdemIndicadaAtual(companyId, groupId,
				ordemIndicadaAtual, status);

		if (loja == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", ordemIndicadaAtual=");
			msg.append(ordemIndicadaAtual);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLojaException(msg.toString());
		}

		return loja;
	}

	/**
	 * Returns the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicadaAtual the ordem indicada atual
	 * @param status the status
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int status) throws SystemException {
		return fetchByCG_OrdemIndicadaAtual(companyId, groupId,
			ordemIndicadaAtual, status, true);
	}

	/**
	 * Returns the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicadaAtual the ordem indicada atual
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, ordemIndicadaAtual, status
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
					finderArgs, this);
		}

		if (result instanceof Loja) {
			Loja loja = (Loja)result;

			if ((companyId != loja.getCompanyId()) ||
					(groupId != loja.getGroupId()) ||
					(ordemIndicadaAtual != loja.getOrdemIndicadaAtual()) ||
					(status != loja.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_ORDEMINDICADAATUAL_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(ordemIndicadaAtual);

				qPos.add(status);

				List<Loja> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LojaPersistenceImpl.fetchByCG_OrdemIndicadaAtual(long, long, boolean, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Loja loja = list.get(0);

					result = loja;

					cacheResult(loja);

					if ((loja.getCompanyId() != companyId) ||
							(loja.getGroupId() != groupId) ||
							(loja.getOrdemIndicadaAtual() != ordemIndicadaAtual) ||
							(loja.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
							finderArgs, loja);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
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
			return (Loja)result;
		}
	}

	/**
	 * Removes the loja where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicadaAtual the ordem indicada atual
	 * @param status the status
	 * @return the loja that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja removeByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int status)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByCG_OrdemIndicadaAtual(companyId, groupId,
				ordemIndicadaAtual, status);

		return remove(loja);
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicadaAtual the ordem indicada atual
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_ORDEMINDICADAATUAL;

		Object[] finderArgs = new Object[] {
				companyId, groupId, ordemIndicadaAtual, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_ORDEMINDICADAATUAL_2);

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(ordemIndicadaAtual);

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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and ordemIndicadaAtual = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param ordemIndicadaAtual the ordem indicada atual
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_OrdemIndicadaAtual(long companyId, long groupId,
		boolean ordemIndicadaAtual, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, ordemIndicadaAtual,
				StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADAATUAL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_ORDEMINDICADAATUAL_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_STATUS_5);

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

				qPos.add(ordemIndicadaAtual);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADAATUAL,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_ORDEMINDICADAATUAL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_COMPANYID_2 =
		"loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_COMPANYID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_COMPANYID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_GROUPID_2 = "loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_GROUPID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_ORDEMINDICADAATUAL_2 =
		"loja.ordemIndicadaAtual = ? AND ";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_ORDEMINDICADAATUAL_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_ORDEMINDICADAATUAL_2) +
		")";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_STATUS_2 = "loja.status = ?";
	private static final String _FINDER_COLUMN_CG_ORDEMINDICADAATUAL_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_ORDEMINDICADAATUAL_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAME =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_ClassName",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASSNAME =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_ClassName",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			LojaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaModelImpl.GROUPID_COLUMN_BITMASK |
			LojaModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			LojaModelImpl.STATUS_COLUMN_BITMASK |
			LojaModelImpl.NOMEFANTASIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_CLASSNAME = new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_ClassName",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAME =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_ClassName",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassName(long companyId, long groupId,
		long classNameId, int status) throws SystemException {
		return findByCG_ClassName(companyId, groupId, classNameId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassName(long companyId, long groupId,
		long classNameId, int status, int start, int end)
		throws SystemException {
		return findByCG_ClassName(companyId, groupId, classNameId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassName(long companyId, long groupId,
		long classNameId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASSNAME;
			finderArgs = new Object[] { companyId, groupId, classNameId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAME;
			finderArgs = new Object[] {
					companyId, groupId, classNameId, status,
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						(classNameId != loja.getClassNameId()) ||
						(status != loja.getStatus())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_ClassName_First(long companyId, long groupId,
		long classNameId, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_ClassName_First(companyId, groupId, classNameId,
				status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_ClassName_First(long companyId, long groupId,
		long classNameId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Loja> list = findByCG_ClassName(companyId, groupId, classNameId,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_ClassName_Last(long companyId, long groupId,
		long classNameId, int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_ClassName_Last(companyId, groupId, classNameId,
				status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_ClassName_Last(long companyId, long groupId,
		long classNameId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_ClassName(companyId, groupId, classNameId, status);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCG_ClassName(companyId, groupId, classNameId,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCG_ClassName_PrevAndNext(long lojaId, long companyId,
		long groupId, long classNameId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCG_ClassName_PrevAndNext(session, loja, companyId,
					groupId, classNameId, status, orderByComparator, true);

			array[1] = loja;

			array[2] = getByCG_ClassName_PrevAndNext(session, loja, companyId,
					groupId, classNameId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loja getByCG_ClassName_PrevAndNext(Session session, Loja loja,
		long companyId, long groupId, long classNameId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		query.append(_FINDER_COLUMN_CG_CLASSNAME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_CLASSNAME_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_CG_CLASSNAME_STATUS_2);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(classNameId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param statuses the statuses
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassName(long companyId, long groupId,
		long classNameId, int[] statuses) throws SystemException {
		return findByCG_ClassName(companyId, groupId, classNameId, statuses,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassName(long companyId, long groupId,
		long classNameId, int[] statuses, int start, int end)
		throws SystemException {
		return findByCG_ClassName(companyId, groupId, classNameId, statuses,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassName(long companyId, long groupId,
		long classNameId, int[] statuses, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_ClassName(companyId, groupId, classNameId,
				statuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, classNameId, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, classNameId, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAME,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						(classNameId != loja.getClassNameId()) ||
						!ArrayUtil.contains(statuses, loja.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_CLASSNAME_STATUS_5);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAME,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAME,
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
	 * Removes all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_ClassName(long companyId, long groupId,
		long classNameId, int status) throws SystemException {
		for (Loja loja : findByCG_ClassName(companyId, groupId, classNameId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ClassName(long companyId, long groupId,
		long classNameId, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_CLASSNAME;

		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAME_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ClassName(long companyId, long groupId,
		long classNameId, int[] statuses) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAME_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_CLASSNAME_STATUS_5);

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

				qPos.add(classNameId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAME,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_CLASSNAME_COMPANYID_2 = "loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAME_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_GROUPID_2 = "loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAME_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_2 = "loja.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAME_CLASSNAMEID_2) + ")";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_STATUS_2 = "loja.status = ?";
	private static final String _FINDER_COLUMN_CG_CLASSNAME_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAME_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAMENOMEFANTASIA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, LojaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCG_ClassNameNomeFantasia",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAMENOMEFANTASIA =
		new FinderPath(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCG_ClassNameNomeFantasia",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status)
		throws SystemException {
		return findByCG_ClassNameNomeFantasia(companyId, groupId, classNameId,
			nomeFantasia, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status,
		int start, int end) throws SystemException {
		return findByCG_ClassNameNomeFantasia(companyId, groupId, classNameId,
			nomeFantasia, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAMENOMEFANTASIA;
		finderArgs = new Object[] {
				companyId, groupId, classNameId, nomeFantasia, status,
				
				start, end, orderByComparator
			};

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						(classNameId != loja.getClassNameId()) ||
						!StringUtil.wildcardMatches(loja.getNomeFantasia(),
							nomeFantasia, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(status != loja.getStatus())) {
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

			query.append(_SQL_SELECT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_2);

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_1);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_3);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_2);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_ClassNameNomeFantasia_First(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_ClassNameNomeFantasia_First(companyId, groupId,
				classNameId, nomeFantasia, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", nomeFantasia=");
		msg.append(nomeFantasia);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the first loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_ClassNameNomeFantasia_First(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loja> list = findByCG_ClassNameNomeFantasia(companyId, groupId,
				classNameId, nomeFantasia, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByCG_ClassNameNomeFantasia_Last(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByCG_ClassNameNomeFantasia_Last(companyId, groupId,
				classNameId, nomeFantasia, status, orderByComparator);

		if (loja != null) {
			return loja;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", nomeFantasia=");
		msg.append(nomeFantasia);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaException(msg.toString());
	}

	/**
	 * Returns the last loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja, or <code>null</code> if a matching loja could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByCG_ClassNameNomeFantasia_Last(long companyId,
		long groupId, long classNameId, String nomeFantasia, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG_ClassNameNomeFantasia(companyId, groupId,
				classNameId, nomeFantasia, status);

		if (count == 0) {
			return null;
		}

		List<Loja> list = findByCG_ClassNameNomeFantasia(companyId, groupId,
				classNameId, nomeFantasia, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lojas before and after the current loja in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param lojaId the primary key of the current loja
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja[] findByCG_ClassNameNomeFantasia_PrevAndNext(long lojaId,
		long companyId, long groupId, long classNameId, String nomeFantasia,
		int status, OrderByComparator orderByComparator)
		throws NoSuchLojaException, SystemException {
		Loja loja = findByPrimaryKey(lojaId);

		Session session = null;

		try {
			session = openSession();

			Loja[] array = new LojaImpl[3];

			array[0] = getByCG_ClassNameNomeFantasia_PrevAndNext(session, loja,
					companyId, groupId, classNameId, nomeFantasia, status,
					orderByComparator, true);

			array[1] = loja;

			array[2] = getByCG_ClassNameNomeFantasia_PrevAndNext(session, loja,
					companyId, groupId, classNameId, nomeFantasia, status,
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

	protected Loja getByCG_ClassNameNomeFantasia_PrevAndNext(Session session,
		Loja loja, long companyId, long groupId, long classNameId,
		String nomeFantasia, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJA_WHERE);

		query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_2);

		boolean bindNomeFantasia = false;

		if (nomeFantasia == null) {
			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_1);
		}
		else if (nomeFantasia.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_3);
		}
		else {
			bindNomeFantasia = true;

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_2);
		}

		query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_2);

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
			query.append(LojaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(classNameId);

		if (bindNomeFantasia) {
			qPos.add(nomeFantasia);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loja);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loja> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @return the matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, String nomeFantasia, int[] statuses)
		throws SystemException {
		return findByCG_ClassNameNomeFantasia(companyId, groupId, classNameId,
			nomeFantasia, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, String nomeFantasia, int[] statuses,
		int start, int end) throws SystemException {
		return findByCG_ClassNameNomeFantasia(companyId, groupId, classNameId,
			nomeFantasia, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findByCG_ClassNameNomeFantasia(long companyId,
		long groupId, long classNameId, String nomeFantasia, int[] statuses,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_ClassNameNomeFantasia(companyId, groupId,
				classNameId, nomeFantasia, statuses[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, classNameId, nomeFantasia,
					StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, classNameId, nomeFantasia,
					StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAMENOMEFANTASIA,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loja loja : list) {
				if ((companyId != loja.getCompanyId()) ||
						(groupId != loja.getGroupId()) ||
						(classNameId != loja.getClassNameId()) ||
						!StringUtil.wildcardMatches(loja.getNomeFantasia(),
							nomeFantasia, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!ArrayUtil.contains(statuses, loja.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_4);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_6);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_5);

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
				query.append(LojaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAMENOMEFANTASIA,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASSNAMENOMEFANTASIA,
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
	 * Removes all the lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_ClassNameNomeFantasia(long companyId, long groupId,
		long classNameId, String nomeFantasia, int status)
		throws SystemException {
		for (Loja loja : findByCG_ClassNameNomeFantasia(companyId, groupId,
				classNameId, nomeFantasia, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param status the status
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ClassNameNomeFantasia(long companyId, long groupId,
		long classNameId, String nomeFantasia, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAMENOMEFANTASIA;

		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, nomeFantasia, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_LOJA_WHERE);

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_2);

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_1);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_3);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_2);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
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
	 * Returns the number of lojas where companyId = &#63; and groupId = &#63; and classNameId = &#63; and nomeFantasia LIKE &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param nomeFantasia the nome fantasia
	 * @param statuses the statuses
	 * @return the number of matching lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_ClassNameNomeFantasia(long companyId, long groupId,
		long classNameId, String nomeFantasia, int[] statuses)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, nomeFantasia,
				StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAMENOMEFANTASIA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_LOJA_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindNomeFantasia = false;

			if (nomeFantasia == null) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_4);
			}
			else if (nomeFantasia.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_6);
			}
			else {
				bindNomeFantasia = true;

				query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_5);
			}

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_5);

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

				qPos.add(classNameId);

				if (bindNomeFantasia) {
					qPos.add(nomeFantasia);
				}

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAMENOMEFANTASIA,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_CLASSNAMENOMEFANTASIA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_2 =
		"loja.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_COMPANYID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_2 =
		"loja.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_GROUPID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_2 =
		"loja.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_CLASSNAMEID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_1 =
		"loja.nomeFantasia LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_2 =
		"loja.nomeFantasia LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_3 =
		"(loja.nomeFantasia IS NULL OR loja.nomeFantasia LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_4 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_1) +
		")";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_2) +
		")";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_6 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_NOMEFANTASIA_3) +
		")";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_2 =
		"loja.status = ?";
	private static final String _FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_CLASSNAMENOMEFANTASIA_STATUS_2) +
		")";

	public LojaPersistenceImpl() {
		setModelClass(Loja.class);
	}

	/**
	 * Caches the loja in the entity cache if it is enabled.
	 *
	 * @param loja the loja
	 */
	@Override
	public void cacheResult(Loja loja) {
		EntityCacheUtil.putResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaImpl.class, loja.getPrimaryKey(), loja);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { loja.getUuid(), loja.getGroupId() }, loja);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CNPJ,
			new Object[] { loja.getCnpj() }, loja);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_CNPJ,
			new Object[] {
				loja.getCompanyId(), loja.getGroupId(), loja.getCnpj(),
				loja.getStatus()
			}, loja);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
			new Object[] {
				loja.getCompanyId(), loja.getGroupId(),
				loja.getOrdemIndicadaAtual(), loja.getStatus()
			}, loja);

		loja.resetOriginalValues();
	}

	/**
	 * Caches the lojas in the entity cache if it is enabled.
	 *
	 * @param lojas the lojas
	 */
	@Override
	public void cacheResult(List<Loja> lojas) {
		for (Loja loja : lojas) {
			if (EntityCacheUtil.getResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
						LojaImpl.class, loja.getPrimaryKey()) == null) {
				cacheResult(loja);
			}
			else {
				loja.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lojas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LojaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LojaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loja.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Loja loja) {
		EntityCacheUtil.removeResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaImpl.class, loja.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(loja);
	}

	@Override
	public void clearCache(List<Loja> lojas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Loja loja : lojas) {
			EntityCacheUtil.removeResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
				LojaImpl.class, loja.getPrimaryKey());

			clearUniqueFindersCache(loja);
		}
	}

	protected void cacheUniqueFindersCache(Loja loja) {
		if (loja.isNew()) {
			Object[] args = new Object[] { loja.getUuid(), loja.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, loja);

			args = new Object[] { loja.getCnpj() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CNPJ, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CNPJ, args, loja);

			args = new Object[] {
					loja.getCompanyId(), loja.getGroupId(), loja.getCnpj(),
					loja.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CG_CNPJ, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_CNPJ, args, loja);

			args = new Object[] {
					loja.getCompanyId(), loja.getGroupId(),
					loja.getOrdemIndicadaAtual(), loja.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CG_ORDEMINDICADAATUAL,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
				args, loja);
		}
		else {
			LojaModelImpl lojaModelImpl = (LojaModelImpl)loja;

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { loja.getUuid(), loja.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					loja);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CNPJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { loja.getCnpj() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CNPJ, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CNPJ, args, loja);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CG_CNPJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loja.getCompanyId(), loja.getGroupId(), loja.getCnpj(),
						loja.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CG_CNPJ, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_CNPJ, args,
					loja);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loja.getCompanyId(), loja.getGroupId(),
						loja.getOrdemIndicadaAtual(), loja.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CG_ORDEMINDICADAATUAL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
					args, loja);
			}
		}
	}

	protected void clearUniqueFindersCache(Loja loja) {
		LojaModelImpl lojaModelImpl = (LojaModelImpl)loja;

		Object[] args = new Object[] { loja.getUuid(), loja.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((lojaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					lojaModelImpl.getOriginalUuid(),
					lojaModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { loja.getCnpj() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CNPJ, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CNPJ, args);

		if ((lojaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CNPJ.getColumnBitmask()) != 0) {
			args = new Object[] { lojaModelImpl.getOriginalCnpj() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CNPJ, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CNPJ, args);
		}

		args = new Object[] {
				loja.getCompanyId(), loja.getGroupId(), loja.getCnpj(),
				loja.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_CNPJ, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_CNPJ, args);

		if ((lojaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CG_CNPJ.getColumnBitmask()) != 0) {
			args = new Object[] {
					lojaModelImpl.getOriginalCompanyId(),
					lojaModelImpl.getOriginalGroupId(),
					lojaModelImpl.getOriginalCnpj(),
					lojaModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_CNPJ, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_CNPJ, args);
		}

		args = new Object[] {
				loja.getCompanyId(), loja.getGroupId(),
				loja.getOrdemIndicadaAtual(), loja.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_ORDEMINDICADAATUAL,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
			args);

		if ((lojaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL.getColumnBitmask()) != 0) {
			args = new Object[] {
					lojaModelImpl.getOriginalCompanyId(),
					lojaModelImpl.getOriginalGroupId(),
					lojaModelImpl.getOriginalOrdemIndicadaAtual(),
					lojaModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_ORDEMINDICADAATUAL,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_ORDEMINDICADAATUAL,
				args);
		}
	}

	/**
	 * Creates a new loja with the primary key. Does not add the loja to the database.
	 *
	 * @param lojaId the primary key for the new loja
	 * @return the new loja
	 */
	@Override
	public Loja create(long lojaId) {
		Loja loja = new LojaImpl();

		loja.setNew(true);
		loja.setPrimaryKey(lojaId);

		String uuid = PortalUUIDUtil.generate();

		loja.setUuid(uuid);

		return loja;
	}

	/**
	 * Removes the loja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lojaId the primary key of the loja
	 * @return the loja that was removed
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja remove(long lojaId) throws NoSuchLojaException, SystemException {
		return remove((Serializable)lojaId);
	}

	/**
	 * Removes the loja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loja
	 * @return the loja that was removed
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja remove(Serializable primaryKey)
		throws NoSuchLojaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Loja loja = (Loja)session.get(LojaImpl.class, primaryKey);

			if (loja == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLojaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loja);
		}
		catch (NoSuchLojaException nsee) {
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
	protected Loja removeImpl(Loja loja) throws SystemException {
		loja = toUnwrappedModel(loja);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loja)) {
				loja = (Loja)session.get(LojaImpl.class, loja.getPrimaryKeyObj());
			}

			if (loja != null) {
				session.delete(loja);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loja != null) {
			clearCache(loja);
		}

		return loja;
	}

	@Override
	public Loja updateImpl(
		br.com.prodevelopment.lapidarios.loja.model.Loja loja)
		throws SystemException {
		loja = toUnwrappedModel(loja);

		boolean isNew = loja.isNew();

		LojaModelImpl lojaModelImpl = (LojaModelImpl)loja;

		if (Validator.isNull(loja.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			loja.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (loja.isNew()) {
				session.save(loja);

				loja.setNew(false);
			}
			else {
				session.merge(loja);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LojaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lojaModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { lojaModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaModelImpl.getOriginalUuid(),
						lojaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						lojaModelImpl.getUuid(), lojaModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { lojaModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaModelImpl.getOriginalCompanyId(),
						lojaModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						lojaModelImpl.getCompanyId(), lojaModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_ORDEMINDICADA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaModelImpl.getOriginalCompanyId(),
						lojaModelImpl.getOriginalGroupId(),
						lojaModelImpl.getOriginalOrdemIndicada(),
						lojaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_ORDEMINDICADA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_ORDEMINDICADA,
					args);

				args = new Object[] {
						lojaModelImpl.getCompanyId(), lojaModelImpl.getGroupId(),
						lojaModelImpl.getOrdemIndicada(),
						lojaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_ORDEMINDICADA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_ORDEMINDICADA,
					args);
			}

			if ((lojaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaModelImpl.getOriginalCompanyId(),
						lojaModelImpl.getOriginalGroupId(),
						lojaModelImpl.getOriginalClassNameId(),
						lojaModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASSNAME,
					args);

				args = new Object[] {
						lojaModelImpl.getCompanyId(), lojaModelImpl.getGroupId(),
						lojaModelImpl.getClassNameId(),
						lojaModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASSNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
			LojaImpl.class, loja.getPrimaryKey(), loja);

		clearUniqueFindersCache(loja);
		cacheUniqueFindersCache(loja);

		return loja;
	}

	protected Loja toUnwrappedModel(Loja loja) {
		if (loja instanceof LojaImpl) {
			return loja;
		}

		LojaImpl lojaImpl = new LojaImpl();

		lojaImpl.setNew(loja.isNew());
		lojaImpl.setPrimaryKey(loja.getPrimaryKey());

		lojaImpl.setUuid(loja.getUuid());
		lojaImpl.setLojaId(loja.getLojaId());
		lojaImpl.setCompanyId(loja.getCompanyId());
		lojaImpl.setGroupId(loja.getGroupId());
		lojaImpl.setCreateUserId(loja.getCreateUserId());
		lojaImpl.setModifiedUserId(loja.getModifiedUserId());
		lojaImpl.setCreateDate(loja.getCreateDate());
		lojaImpl.setModifiedDate(loja.getModifiedDate());
		lojaImpl.setRazaoSocial(loja.getRazaoSocial());
		lojaImpl.setNomeFantasia(loja.getNomeFantasia());
		lojaImpl.setObservacao(loja.getObservacao());
		lojaImpl.setCnpj(loja.getCnpj());
		lojaImpl.setEndLogradouro(loja.getEndLogradouro());
		lojaImpl.setEndNumero(loja.getEndNumero());
		lojaImpl.setEndComplemento(loja.getEndComplemento());
		lojaImpl.setEndCep(loja.getEndCep());
		lojaImpl.setEndBairro(loja.getEndBairro());
		lojaImpl.setEndCidade(loja.getEndCidade());
		lojaImpl.setEndUf(loja.getEndUf());
		lojaImpl.setEndPais(loja.getEndPais());
		lojaImpl.setVersao(loja.getVersao());
		lojaImpl.setOrdemIndicada(loja.getOrdemIndicada());
		lojaImpl.setOrdemIndicadaAtual(loja.isOrdemIndicadaAtual());
		lojaImpl.setStatus(loja.getStatus());
		lojaImpl.setStatusByUserId(loja.getStatusByUserId());
		lojaImpl.setStatusByUserName(loja.getStatusByUserName());
		lojaImpl.setStatusDate(loja.getStatusDate());
		lojaImpl.setClassNameId(loja.getClassNameId());
		lojaImpl.setClassPK(loja.getClassPK());

		return lojaImpl;
	}

	/**
	 * Returns the loja with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loja
	 * @return the loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLojaException, SystemException {
		Loja loja = fetchByPrimaryKey(primaryKey);

		if (loja == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLojaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loja;
	}

	/**
	 * Returns the loja with the primary key or throws a {@link br.com.prodevelopment.lapidarios.loja.NoSuchLojaException} if it could not be found.
	 *
	 * @param lojaId the primary key of the loja
	 * @return the loja
	 * @throws br.com.prodevelopment.lapidarios.loja.NoSuchLojaException if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja findByPrimaryKey(long lojaId)
		throws NoSuchLojaException, SystemException {
		return findByPrimaryKey((Serializable)lojaId);
	}

	/**
	 * Returns the loja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loja
	 * @return the loja, or <code>null</code> if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Loja loja = (Loja)EntityCacheUtil.getResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
				LojaImpl.class, primaryKey);

		if (loja == _nullLoja) {
			return null;
		}

		if (loja == null) {
			Session session = null;

			try {
				session = openSession();

				loja = (Loja)session.get(LojaImpl.class, primaryKey);

				if (loja != null) {
					cacheResult(loja);
				}
				else {
					EntityCacheUtil.putResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
						LojaImpl.class, primaryKey, _nullLoja);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LojaModelImpl.ENTITY_CACHE_ENABLED,
					LojaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loja;
	}

	/**
	 * Returns the loja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lojaId the primary key of the loja
	 * @return the loja, or <code>null</code> if a loja with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loja fetchByPrimaryKey(long lojaId) throws SystemException {
		return fetchByPrimaryKey((Serializable)lojaId);
	}

	/**
	 * Returns all the lojas.
	 *
	 * @return the lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lojas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @return the range of lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lojas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.loja.model.impl.LojaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lojas
	 * @param end the upper bound of the range of lojas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lojas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loja> findAll(int start, int end,
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

		List<Loja> list = (List<Loja>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOJA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOJA;

				if (pagination) {
					sql = sql.concat(LojaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loja>(list);
				}
				else {
					list = (List<Loja>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the lojas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Loja loja : findAll()) {
			remove(loja);
		}
	}

	/**
	 * Returns the number of lojas.
	 *
	 * @return the number of lojas
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

				Query q = session.createQuery(_SQL_COUNT_LOJA);

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
	 * Initializes the loja persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.lapidarios.loja.model.Loja")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Loja>> listenersList = new ArrayList<ModelListener<Loja>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Loja>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LojaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOJA = "SELECT loja FROM Loja loja";
	private static final String _SQL_SELECT_LOJA_WHERE = "SELECT loja FROM Loja loja WHERE ";
	private static final String _SQL_COUNT_LOJA = "SELECT COUNT(loja) FROM Loja loja";
	private static final String _SQL_COUNT_LOJA_WHERE = "SELECT COUNT(loja) FROM Loja loja WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loja.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Loja exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Loja exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LojaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Loja _nullLoja = new LojaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Loja> toCacheModel() {
				return _nullLojaCacheModel;
			}
		};

	private static CacheModel<Loja> _nullLojaCacheModel = new CacheModel<Loja>() {
			@Override
			public Loja toEntityModel() {
				return _nullLoja;
			}
		};
}