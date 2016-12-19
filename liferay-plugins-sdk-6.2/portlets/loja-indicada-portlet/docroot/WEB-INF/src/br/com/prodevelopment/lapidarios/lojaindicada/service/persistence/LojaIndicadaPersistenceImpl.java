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

package br.com.prodevelopment.lapidarios.lojaindicada.service.persistence;

import br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException;
import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaImpl;
import br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl;

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
 * The persistence implementation for the loja indicada service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see LojaIndicadaPersistence
 * @see LojaIndicadaUtil
 * @generated
 */
public class LojaIndicadaPersistenceImpl extends BasePersistenceImpl<LojaIndicada>
	implements LojaIndicadaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LojaIndicadaUtil} to access the loja indicada persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LojaIndicadaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LojaIndicadaModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the loja indicadas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loja indicadas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @return the range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loja indicadas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByUuid(String uuid, int start, int end,
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

		List<LojaIndicada> list = (List<LojaIndicada>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LojaIndicada lojaIndicada : list) {
				if (!Validator.equals(uuid, lojaIndicada.getUuid())) {
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

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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
				query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
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
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LojaIndicada>(list);
				}
				else {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loja indicada in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByUuid_First(uuid, orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the first loja indicada in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<LojaIndicada> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja indicada in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByUuid_Last(uuid, orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the last loja indicada in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LojaIndicada> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loja indicadas before and after the current loja indicada in the ordered set where uuid = &#63;.
	 *
	 * @param lojaIndicadaId the primary key of the current loja indicada
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada[] findByUuid_PrevAndNext(long lojaIndicadaId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByPrimaryKey(lojaIndicadaId);

		Session session = null;

		try {
			session = openSession();

			LojaIndicada[] array = new LojaIndicadaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, lojaIndicada, uuid,
					orderByComparator, true);

			array[1] = lojaIndicada;

			array[2] = getByUuid_PrevAndNext(session, lojaIndicada, uuid,
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

	protected LojaIndicada getByUuid_PrevAndNext(Session session,
		LojaIndicada lojaIndicada, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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
			query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(lojaIndicada);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LojaIndicada> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loja indicadas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (LojaIndicada lojaIndicada : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lojaIndicada);
		}
	}

	/**
	 * Returns the number of loja indicadas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loja indicadas
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

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "lojaIndicada.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "lojaIndicada.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(lojaIndicada.uuid IS NULL OR lojaIndicada.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			LojaIndicadaModelImpl.UUID_COLUMN_BITMASK |
			LojaIndicadaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the loja indicada where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByUUID_G(String uuid, long groupId)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByUUID_G(uuid, groupId);

		if (lojaIndicada == null) {
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

			throw new NoSuchLojaIndicadaException(msg.toString());
		}

		return lojaIndicada;
	}

	/**
	 * Returns the loja indicada where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the loja indicada where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof LojaIndicada) {
			LojaIndicada lojaIndicada = (LojaIndicada)result;

			if (!Validator.equals(uuid, lojaIndicada.getUuid()) ||
					(groupId != lojaIndicada.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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

				List<LojaIndicada> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					LojaIndicada lojaIndicada = list.get(0);

					result = lojaIndicada;

					cacheResult(lojaIndicada);

					if ((lojaIndicada.getUuid() == null) ||
							!lojaIndicada.getUuid().equals(uuid) ||
							(lojaIndicada.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, lojaIndicada);
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
			return (LojaIndicada)result;
		}
	}

	/**
	 * Removes the loja indicada where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the loja indicada that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada removeByUUID_G(String uuid, long groupId)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByUUID_G(uuid, groupId);

		return remove(lojaIndicada);
	}

	/**
	 * Returns the number of loja indicadas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching loja indicadas
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

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "lojaIndicada.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "lojaIndicada.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(lojaIndicada.uuid IS NULL OR lojaIndicada.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "lojaIndicada.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			LojaIndicadaModelImpl.UUID_COLUMN_BITMASK |
			LojaIndicadaModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loja indicadas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loja indicadas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @return the range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loja indicadas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByUuid_C(String uuid, long companyId,
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

		List<LojaIndicada> list = (List<LojaIndicada>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LojaIndicada lojaIndicada : list) {
				if (!Validator.equals(uuid, lojaIndicada.getUuid()) ||
						(companyId != lojaIndicada.getCompanyId())) {
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

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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
				query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
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
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LojaIndicada>(list);
				}
				else {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the first loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LojaIndicada> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the last loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LojaIndicada> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loja indicadas before and after the current loja indicada in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param lojaIndicadaId the primary key of the current loja indicada
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada[] findByUuid_C_PrevAndNext(long lojaIndicadaId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByPrimaryKey(lojaIndicadaId);

		Session session = null;

		try {
			session = openSession();

			LojaIndicada[] array = new LojaIndicadaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, lojaIndicada, uuid,
					companyId, orderByComparator, true);

			array[1] = lojaIndicada;

			array[2] = getByUuid_C_PrevAndNext(session, lojaIndicada, uuid,
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

	protected LojaIndicada getByUuid_C_PrevAndNext(Session session,
		LojaIndicada lojaIndicada, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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
			query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(lojaIndicada);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LojaIndicada> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loja indicadas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (LojaIndicada lojaIndicada : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lojaIndicada);
		}
	}

	/**
	 * Returns the number of loja indicadas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loja indicadas
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

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "lojaIndicada.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "lojaIndicada.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(lojaIndicada.uuid IS NULL OR lojaIndicada.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "lojaIndicada.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			LojaIndicadaModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loja indicadas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the loja indicadas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @return the range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loja indicadas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCompany(long companyId, int start, int end,
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

		List<LojaIndicada> list = (List<LojaIndicada>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LojaIndicada lojaIndicada : list) {
				if ((companyId != lojaIndicada.getCompanyId())) {
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

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LojaIndicada>(list);
				}
				else {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loja indicada in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCompany_First(companyId,
				orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the first loja indicada in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LojaIndicada> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja indicada in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCompany_Last(companyId,
				orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the last loja indicada in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<LojaIndicada> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loja indicadas before and after the current loja indicada in the ordered set where companyId = &#63;.
	 *
	 * @param lojaIndicadaId the primary key of the current loja indicada
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada[] findByCompany_PrevAndNext(long lojaIndicadaId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByPrimaryKey(lojaIndicadaId);

		Session session = null;

		try {
			session = openSession();

			LojaIndicada[] array = new LojaIndicadaImpl[3];

			array[0] = getByCompany_PrevAndNext(session, lojaIndicada,
					companyId, orderByComparator, true);

			array[1] = lojaIndicada;

			array[2] = getByCompany_PrevAndNext(session, lojaIndicada,
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

	protected LojaIndicada getByCompany_PrevAndNext(Session session,
		LojaIndicada lojaIndicada, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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
			query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lojaIndicada);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LojaIndicada> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loja indicadas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (LojaIndicada lojaIndicada : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lojaIndicada);
		}
	}

	/**
	 * Returns the number of loja indicadas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching loja indicadas
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

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "lojaIndicada.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			LojaIndicadaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaIndicadaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loja indicadas where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loja indicadas where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @return the range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCG(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loja indicadas where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCG(long companyId, long groupId, int start,
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

		List<LojaIndicada> list = (List<LojaIndicada>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LojaIndicada lojaIndicada : list) {
				if ((companyId != lojaIndicada.getCompanyId()) ||
						(groupId != lojaIndicada.getGroupId())) {
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

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
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
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LojaIndicada>(list);
				}
				else {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCG_First(companyId, groupId,
				orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LojaIndicada> list = findByCG(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCG_Last(companyId, groupId,
				orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<LojaIndicada> list = findByCG(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loja indicadas before and after the current loja indicada in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param lojaIndicadaId the primary key of the current loja indicada
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada[] findByCG_PrevAndNext(long lojaIndicadaId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByPrimaryKey(lojaIndicadaId);

		Session session = null;

		try {
			session = openSession();

			LojaIndicada[] array = new LojaIndicadaImpl[3];

			array[0] = getByCG_PrevAndNext(session, lojaIndicada, companyId,
					groupId, orderByComparator, true);

			array[1] = lojaIndicada;

			array[2] = getByCG_PrevAndNext(session, lojaIndicada, companyId,
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

	protected LojaIndicada getByCG_PrevAndNext(Session session,
		LojaIndicada lojaIndicada, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

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
			query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lojaIndicada);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LojaIndicada> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loja indicadas where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (LojaIndicada lojaIndicada : findByCG(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lojaIndicada);
		}
	}

	/**
	 * Returns the number of loja indicadas where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching loja indicadas
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

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

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

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "lojaIndicada.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "lojaIndicada.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_IDLOJA =
		new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_IdLoja",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_IDLOJA =
		new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_IdLoja",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @return the matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCG_IdLoja(long companyId, long groupId,
		String idLoja) throws SystemException {
		return findByCG_IdLoja(companyId, groupId, idLoja, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @return the range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCG_IdLoja(long companyId, long groupId,
		String idLoja, int start, int end) throws SystemException {
		return findByCG_IdLoja(companyId, groupId, idLoja, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findByCG_IdLoja(long companyId, long groupId,
		String idLoja, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_IDLOJA;
		finderArgs = new Object[] {
				companyId, groupId, idLoja,
				
				start, end, orderByComparator
			};

		List<LojaIndicada> list = (List<LojaIndicada>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LojaIndicada lojaIndicada : list) {
				if ((companyId != lojaIndicada.getCompanyId()) ||
						(groupId != lojaIndicada.getGroupId()) ||
						!StringUtil.wildcardMatches(lojaIndicada.getIdLoja(),
							idLoja, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

			query.append(_FINDER_COLUMN_CG_IDLOJA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_IDLOJA_GROUPID_2);

			boolean bindIdLoja = false;

			if (idLoja == null) {
				query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_1);
			}
			else if (idLoja.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_3);
			}
			else {
				bindIdLoja = true;

				query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindIdLoja) {
					qPos.add(idLoja);
				}

				if (!pagination) {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LojaIndicada>(list);
				}
				else {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCG_IdLoja_First(long companyId, long groupId,
		String idLoja, OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCG_IdLoja_First(companyId, groupId,
				idLoja, orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", idLoja=");
		msg.append(idLoja);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the first loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCG_IdLoja_First(long companyId, long groupId,
		String idLoja, OrderByComparator orderByComparator)
		throws SystemException {
		List<LojaIndicada> list = findByCG_IdLoja(companyId, groupId, idLoja,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCG_IdLoja_Last(long companyId, long groupId,
		String idLoja, OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCG_IdLoja_Last(companyId, groupId,
				idLoja, orderByComparator);

		if (lojaIndicada != null) {
			return lojaIndicada;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", idLoja=");
		msg.append(idLoja);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLojaIndicadaException(msg.toString());
	}

	/**
	 * Returns the last loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCG_IdLoja_Last(long companyId, long groupId,
		String idLoja, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_IdLoja(companyId, groupId, idLoja);

		if (count == 0) {
			return null;
		}

		List<LojaIndicada> list = findByCG_IdLoja(companyId, groupId, idLoja,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loja indicadas before and after the current loja indicada in the ordered set where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param lojaIndicadaId the primary key of the current loja indicada
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada[] findByCG_IdLoja_PrevAndNext(long lojaIndicadaId,
		long companyId, long groupId, String idLoja,
		OrderByComparator orderByComparator)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByPrimaryKey(lojaIndicadaId);

		Session session = null;

		try {
			session = openSession();

			LojaIndicada[] array = new LojaIndicadaImpl[3];

			array[0] = getByCG_IdLoja_PrevAndNext(session, lojaIndicada,
					companyId, groupId, idLoja, orderByComparator, true);

			array[1] = lojaIndicada;

			array[2] = getByCG_IdLoja_PrevAndNext(session, lojaIndicada,
					companyId, groupId, idLoja, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LojaIndicada getByCG_IdLoja_PrevAndNext(Session session,
		LojaIndicada lojaIndicada, long companyId, long groupId, String idLoja,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

		query.append(_FINDER_COLUMN_CG_IDLOJA_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_IDLOJA_GROUPID_2);

		boolean bindIdLoja = false;

		if (idLoja == null) {
			query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_1);
		}
		else if (idLoja.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_3);
		}
		else {
			bindIdLoja = true;

			query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_2);
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
			query.append(LojaIndicadaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindIdLoja) {
			qPos.add(idLoja);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lojaIndicada);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LojaIndicada> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_IdLoja(long companyId, long groupId, String idLoja)
		throws SystemException {
		for (LojaIndicada lojaIndicada : findByCG_IdLoja(companyId, groupId,
				idLoja, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lojaIndicada);
		}
	}

	/**
	 * Returns the number of loja indicadas where companyId = &#63; and groupId = &#63; and idLoja LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param idLoja the id loja
	 * @return the number of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_IdLoja(long companyId, long groupId, String idLoja)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_IDLOJA;

		Object[] finderArgs = new Object[] { companyId, groupId, idLoja };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

			query.append(_FINDER_COLUMN_CG_IDLOJA_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_IDLOJA_GROUPID_2);

			boolean bindIdLoja = false;

			if (idLoja == null) {
				query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_1);
			}
			else if (idLoja.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_3);
			}
			else {
				bindIdLoja = true;

				query.append(_FINDER_COLUMN_CG_IDLOJA_IDLOJA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindIdLoja) {
					qPos.add(idLoja);
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

	private static final String _FINDER_COLUMN_CG_IDLOJA_COMPANYID_2 = "lojaIndicada.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_IDLOJA_GROUPID_2 = "lojaIndicada.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_IDLOJA_IDLOJA_1 = "lojaIndicada.idLoja LIKE NULL";
	private static final String _FINDER_COLUMN_CG_IDLOJA_IDLOJA_2 = "lojaIndicada.idLoja LIKE ?";
	private static final String _FINDER_COLUMN_CG_IDLOJA_IDLOJA_3 = "(lojaIndicada.idLoja IS NULL OR lojaIndicada.idLoja LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, LojaIndicadaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCG_lojaIndicadaAtual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LojaIndicadaModelImpl.COMPANYID_COLUMN_BITMASK |
			LojaIndicadaModelImpl.GROUPID_COLUMN_BITMASK |
			LojaIndicadaModelImpl.LOJAINDICADAATUAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_LOJAINDICADAATUAL = new FinderPath(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCG_lojaIndicadaAtual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param lojaIndicadaAtual the loja indicada atual
	 * @return the matching loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByCG_lojaIndicadaAtual(long companyId,
		long groupId, Boolean lojaIndicadaAtual)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByCG_lojaIndicadaAtual(companyId,
				groupId, lojaIndicadaAtual);

		if (lojaIndicada == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", lojaIndicadaAtual=");
			msg.append(lojaIndicadaAtual);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLojaIndicadaException(msg.toString());
		}

		return lojaIndicada;
	}

	/**
	 * Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param lojaIndicadaAtual the loja indicada atual
	 * @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCG_lojaIndicadaAtual(long companyId,
		long groupId, Boolean lojaIndicadaAtual) throws SystemException {
		return fetchByCG_lojaIndicadaAtual(companyId, groupId,
			lojaIndicadaAtual, true);
	}

	/**
	 * Returns the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param lojaIndicadaAtual the loja indicada atual
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loja indicada, or <code>null</code> if a matching loja indicada could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByCG_lojaIndicadaAtual(long companyId,
		long groupId, Boolean lojaIndicadaAtual, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, lojaIndicadaAtual };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
					finderArgs, this);
		}

		if (result instanceof LojaIndicada) {
			LojaIndicada lojaIndicada = (LojaIndicada)result;

			if ((companyId != lojaIndicada.getCompanyId()) ||
					(groupId != lojaIndicada.getGroupId()) ||
					!Validator.equals(lojaIndicadaAtual,
						lojaIndicada.getLojaIndicadaAtual())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LOJAINDICADA_WHERE);

			query.append(_FINDER_COLUMN_CG_LOJAINDICADAATUAL_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LOJAINDICADAATUAL_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_LOJAINDICADAATUAL_LOJAINDICADAATUAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(lojaIndicadaAtual.booleanValue());

				List<LojaIndicada> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LojaIndicadaPersistenceImpl.fetchByCG_lojaIndicadaAtual(long, long, Boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LojaIndicada lojaIndicada = list.get(0);

					result = lojaIndicada;

					cacheResult(lojaIndicada);

					if ((lojaIndicada.getCompanyId() != companyId) ||
							(lojaIndicada.getGroupId() != groupId) ||
							(lojaIndicada.getLojaIndicadaAtual() != lojaIndicadaAtual)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
							finderArgs, lojaIndicada);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
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
			return (LojaIndicada)result;
		}
	}

	/**
	 * Removes the loja indicada where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param lojaIndicadaAtual the loja indicada atual
	 * @return the loja indicada that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada removeByCG_lojaIndicadaAtual(long companyId,
		long groupId, Boolean lojaIndicadaAtual)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = findByCG_lojaIndicadaAtual(companyId,
				groupId, lojaIndicadaAtual);

		return remove(lojaIndicada);
	}

	/**
	 * Returns the number of loja indicadas where companyId = &#63; and groupId = &#63; and lojaIndicadaAtual = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param lojaIndicadaAtual the loja indicada atual
	 * @return the number of matching loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_lojaIndicadaAtual(long companyId, long groupId,
		Boolean lojaIndicadaAtual) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_LOJAINDICADAATUAL;

		Object[] finderArgs = new Object[] { companyId, groupId, lojaIndicadaAtual };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LOJAINDICADA_WHERE);

			query.append(_FINDER_COLUMN_CG_LOJAINDICADAATUAL_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LOJAINDICADAATUAL_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_LOJAINDICADAATUAL_LOJAINDICADAATUAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(lojaIndicadaAtual.booleanValue());

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

	private static final String _FINDER_COLUMN_CG_LOJAINDICADAATUAL_COMPANYID_2 = "lojaIndicada.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOJAINDICADAATUAL_GROUPID_2 = "lojaIndicada.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LOJAINDICADAATUAL_LOJAINDICADAATUAL_2 =
		"lojaIndicada.lojaIndicadaAtual = ?";

	public LojaIndicadaPersistenceImpl() {
		setModelClass(LojaIndicada.class);
	}

	/**
	 * Caches the loja indicada in the entity cache if it is enabled.
	 *
	 * @param lojaIndicada the loja indicada
	 */
	@Override
	public void cacheResult(LojaIndicada lojaIndicada) {
		EntityCacheUtil.putResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaImpl.class, lojaIndicada.getPrimaryKey(), lojaIndicada);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { lojaIndicada.getUuid(), lojaIndicada.getGroupId() },
			lojaIndicada);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
			new Object[] {
				lojaIndicada.getCompanyId(), lojaIndicada.getGroupId(),
				lojaIndicada.getLojaIndicadaAtual()
			}, lojaIndicada);

		lojaIndicada.resetOriginalValues();
	}

	/**
	 * Caches the loja indicadas in the entity cache if it is enabled.
	 *
	 * @param lojaIndicadas the loja indicadas
	 */
	@Override
	public void cacheResult(List<LojaIndicada> lojaIndicadas) {
		for (LojaIndicada lojaIndicada : lojaIndicadas) {
			if (EntityCacheUtil.getResult(
						LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
						LojaIndicadaImpl.class, lojaIndicada.getPrimaryKey()) == null) {
				cacheResult(lojaIndicada);
			}
			else {
				lojaIndicada.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loja indicadas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LojaIndicadaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LojaIndicadaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loja indicada.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LojaIndicada lojaIndicada) {
		EntityCacheUtil.removeResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaImpl.class, lojaIndicada.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lojaIndicada);
	}

	@Override
	public void clearCache(List<LojaIndicada> lojaIndicadas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LojaIndicada lojaIndicada : lojaIndicadas) {
			EntityCacheUtil.removeResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
				LojaIndicadaImpl.class, lojaIndicada.getPrimaryKey());

			clearUniqueFindersCache(lojaIndicada);
		}
	}

	protected void cacheUniqueFindersCache(LojaIndicada lojaIndicada) {
		if (lojaIndicada.isNew()) {
			Object[] args = new Object[] {
					lojaIndicada.getUuid(), lojaIndicada.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				lojaIndicada);

			args = new Object[] {
					lojaIndicada.getCompanyId(), lojaIndicada.getGroupId(),
					lojaIndicada.getLojaIndicadaAtual()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CG_LOJAINDICADAATUAL,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
				args, lojaIndicada);
		}
		else {
			LojaIndicadaModelImpl lojaIndicadaModelImpl = (LojaIndicadaModelImpl)lojaIndicada;

			if ((lojaIndicadaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaIndicada.getUuid(), lojaIndicada.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					lojaIndicada);
			}

			if ((lojaIndicadaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaIndicada.getCompanyId(), lojaIndicada.getGroupId(),
						lojaIndicada.getLojaIndicadaAtual()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CG_LOJAINDICADAATUAL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
					args, lojaIndicada);
			}
		}
	}

	protected void clearUniqueFindersCache(LojaIndicada lojaIndicada) {
		LojaIndicadaModelImpl lojaIndicadaModelImpl = (LojaIndicadaModelImpl)lojaIndicada;

		Object[] args = new Object[] {
				lojaIndicada.getUuid(), lojaIndicada.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((lojaIndicadaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					lojaIndicadaModelImpl.getOriginalUuid(),
					lojaIndicadaModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				lojaIndicada.getCompanyId(), lojaIndicada.getGroupId(),
				lojaIndicada.getLojaIndicadaAtual()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_LOJAINDICADAATUAL,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
			args);

		if ((lojaIndicadaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL.getColumnBitmask()) != 0) {
			args = new Object[] {
					lojaIndicadaModelImpl.getOriginalCompanyId(),
					lojaIndicadaModelImpl.getOriginalGroupId(),
					lojaIndicadaModelImpl.getOriginalLojaIndicadaAtual()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_LOJAINDICADAATUAL,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CG_LOJAINDICADAATUAL,
				args);
		}
	}

	/**
	 * Creates a new loja indicada with the primary key. Does not add the loja indicada to the database.
	 *
	 * @param lojaIndicadaId the primary key for the new loja indicada
	 * @return the new loja indicada
	 */
	@Override
	public LojaIndicada create(long lojaIndicadaId) {
		LojaIndicada lojaIndicada = new LojaIndicadaImpl();

		lojaIndicada.setNew(true);
		lojaIndicada.setPrimaryKey(lojaIndicadaId);

		String uuid = PortalUUIDUtil.generate();

		lojaIndicada.setUuid(uuid);

		return lojaIndicada;
	}

	/**
	 * Removes the loja indicada with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lojaIndicadaId the primary key of the loja indicada
	 * @return the loja indicada that was removed
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada remove(long lojaIndicadaId)
		throws NoSuchLojaIndicadaException, SystemException {
		return remove((Serializable)lojaIndicadaId);
	}

	/**
	 * Removes the loja indicada with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loja indicada
	 * @return the loja indicada that was removed
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada remove(Serializable primaryKey)
		throws NoSuchLojaIndicadaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LojaIndicada lojaIndicada = (LojaIndicada)session.get(LojaIndicadaImpl.class,
					primaryKey);

			if (lojaIndicada == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLojaIndicadaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lojaIndicada);
		}
		catch (NoSuchLojaIndicadaException nsee) {
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
	protected LojaIndicada removeImpl(LojaIndicada lojaIndicada)
		throws SystemException {
		lojaIndicada = toUnwrappedModel(lojaIndicada);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lojaIndicada)) {
				lojaIndicada = (LojaIndicada)session.get(LojaIndicadaImpl.class,
						lojaIndicada.getPrimaryKeyObj());
			}

			if (lojaIndicada != null) {
				session.delete(lojaIndicada);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lojaIndicada != null) {
			clearCache(lojaIndicada);
		}

		return lojaIndicada;
	}

	@Override
	public LojaIndicada updateImpl(
		br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada lojaIndicada)
		throws SystemException {
		lojaIndicada = toUnwrappedModel(lojaIndicada);

		boolean isNew = lojaIndicada.isNew();

		LojaIndicadaModelImpl lojaIndicadaModelImpl = (LojaIndicadaModelImpl)lojaIndicada;

		if (Validator.isNull(lojaIndicada.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			lojaIndicada.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (lojaIndicada.isNew()) {
				session.save(lojaIndicada);

				lojaIndicada.setNew(false);
			}
			else {
				session.merge(lojaIndicada);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LojaIndicadaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lojaIndicadaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaIndicadaModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { lojaIndicadaModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((lojaIndicadaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaIndicadaModelImpl.getOriginalUuid(),
						lojaIndicadaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						lojaIndicadaModelImpl.getUuid(),
						lojaIndicadaModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((lojaIndicadaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaIndicadaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { lojaIndicadaModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((lojaIndicadaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lojaIndicadaModelImpl.getOriginalCompanyId(),
						lojaIndicadaModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						lojaIndicadaModelImpl.getCompanyId(),
						lojaIndicadaModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}
		}

		EntityCacheUtil.putResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
			LojaIndicadaImpl.class, lojaIndicada.getPrimaryKey(), lojaIndicada);

		clearUniqueFindersCache(lojaIndicada);
		cacheUniqueFindersCache(lojaIndicada);

		return lojaIndicada;
	}

	protected LojaIndicada toUnwrappedModel(LojaIndicada lojaIndicada) {
		if (lojaIndicada instanceof LojaIndicadaImpl) {
			return lojaIndicada;
		}

		LojaIndicadaImpl lojaIndicadaImpl = new LojaIndicadaImpl();

		lojaIndicadaImpl.setNew(lojaIndicada.isNew());
		lojaIndicadaImpl.setPrimaryKey(lojaIndicada.getPrimaryKey());

		lojaIndicadaImpl.setUuid(lojaIndicada.getUuid());
		lojaIndicadaImpl.setLojaIndicadaId(lojaIndicada.getLojaIndicadaId());
		lojaIndicadaImpl.setCompanyId(lojaIndicada.getCompanyId());
		lojaIndicadaImpl.setGroupId(lojaIndicada.getGroupId());
		lojaIndicadaImpl.setCreateUserId(lojaIndicada.getCreateUserId());
		lojaIndicadaImpl.setModifiedUserId(lojaIndicada.getModifiedUserId());
		lojaIndicadaImpl.setCreateDate(lojaIndicada.getCreateDate());
		lojaIndicadaImpl.setModifiedDate(lojaIndicada.getModifiedDate());
		lojaIndicadaImpl.setIdLoja(lojaIndicada.getIdLoja());
		lojaIndicadaImpl.setLojaIndicadaAtual(lojaIndicada.getLojaIndicadaAtual());

		return lojaIndicadaImpl;
	}

	/**
	 * Returns the loja indicada with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loja indicada
	 * @return the loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLojaIndicadaException, SystemException {
		LojaIndicada lojaIndicada = fetchByPrimaryKey(primaryKey);

		if (lojaIndicada == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLojaIndicadaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lojaIndicada;
	}

	/**
	 * Returns the loja indicada with the primary key or throws a {@link br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException} if it could not be found.
	 *
	 * @param lojaIndicadaId the primary key of the loja indicada
	 * @return the loja indicada
	 * @throws br.com.prodevelopment.lapidarios.lojaindicada.NoSuchLojaIndicadaException if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada findByPrimaryKey(long lojaIndicadaId)
		throws NoSuchLojaIndicadaException, SystemException {
		return findByPrimaryKey((Serializable)lojaIndicadaId);
	}

	/**
	 * Returns the loja indicada with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loja indicada
	 * @return the loja indicada, or <code>null</code> if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LojaIndicada lojaIndicada = (LojaIndicada)EntityCacheUtil.getResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
				LojaIndicadaImpl.class, primaryKey);

		if (lojaIndicada == _nullLojaIndicada) {
			return null;
		}

		if (lojaIndicada == null) {
			Session session = null;

			try {
				session = openSession();

				lojaIndicada = (LojaIndicada)session.get(LojaIndicadaImpl.class,
						primaryKey);

				if (lojaIndicada != null) {
					cacheResult(lojaIndicada);
				}
				else {
					EntityCacheUtil.putResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
						LojaIndicadaImpl.class, primaryKey, _nullLojaIndicada);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LojaIndicadaModelImpl.ENTITY_CACHE_ENABLED,
					LojaIndicadaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lojaIndicada;
	}

	/**
	 * Returns the loja indicada with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lojaIndicadaId the primary key of the loja indicada
	 * @return the loja indicada, or <code>null</code> if a loja indicada with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LojaIndicada fetchByPrimaryKey(long lojaIndicadaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)lojaIndicadaId);
	}

	/**
	 * Returns all the loja indicadas.
	 *
	 * @return the loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loja indicadas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @return the range of loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loja indicadas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.lapidarios.lojaindicada.model.impl.LojaIndicadaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loja indicadas
	 * @param end the upper bound of the range of loja indicadas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loja indicadas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LojaIndicada> findAll(int start, int end,
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

		List<LojaIndicada> list = (List<LojaIndicada>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOJAINDICADA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOJAINDICADA;

				if (pagination) {
					sql = sql.concat(LojaIndicadaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LojaIndicada>(list);
				}
				else {
					list = (List<LojaIndicada>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the loja indicadas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LojaIndicada lojaIndicada : findAll()) {
			remove(lojaIndicada);
		}
	}

	/**
	 * Returns the number of loja indicadas.
	 *
	 * @return the number of loja indicadas
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

				Query q = session.createQuery(_SQL_COUNT_LOJAINDICADA);

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
	 * Initializes the loja indicada persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LojaIndicada>> listenersList = new ArrayList<ModelListener<LojaIndicada>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LojaIndicada>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LojaIndicadaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOJAINDICADA = "SELECT lojaIndicada FROM LojaIndicada lojaIndicada";
	private static final String _SQL_SELECT_LOJAINDICADA_WHERE = "SELECT lojaIndicada FROM LojaIndicada lojaIndicada WHERE ";
	private static final String _SQL_COUNT_LOJAINDICADA = "SELECT COUNT(lojaIndicada) FROM LojaIndicada lojaIndicada";
	private static final String _SQL_COUNT_LOJAINDICADA_WHERE = "SELECT COUNT(lojaIndicada) FROM LojaIndicada lojaIndicada WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lojaIndicada.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LojaIndicada exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LojaIndicada exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LojaIndicadaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static LojaIndicada _nullLojaIndicada = new LojaIndicadaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LojaIndicada> toCacheModel() {
				return _nullLojaIndicadaCacheModel;
			}
		};

	private static CacheModel<LojaIndicada> _nullLojaIndicadaCacheModel = new CacheModel<LojaIndicada>() {
			@Override
			public LojaIndicada toEntityModel() {
				return _nullLojaIndicada;
			}
		};
}