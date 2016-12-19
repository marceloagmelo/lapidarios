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

package br.com.prodevelopment.associado.service.persistence;

import br.com.prodevelopment.associado.NoSuchAssociadoException;
import br.com.prodevelopment.associado.model.Associado;
import br.com.prodevelopment.associado.model.impl.AssociadoImpl;
import br.com.prodevelopment.associado.model.impl.AssociadoModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the associado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see AssociadoPersistence
 * @see AssociadoUtil
 * @generated
 */
public class AssociadoPersistenceImpl extends BasePersistenceImpl<Associado>
	implements AssociadoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssociadoUtil} to access the associado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssociadoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AssociadoModelImpl.UUID_COLUMN_BITMASK |
			AssociadoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the associados where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByUuid(String uuid, int start, int end,
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

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if (!Validator.equals(uuid, associado.getUuid())) {
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

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

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
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByUuid_First(uuid, orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associado> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByUuid_Last(uuid, orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where uuid = &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByUuid_PrevAndNext(long associadoId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, associado, uuid,
					orderByComparator, true);

			array[1] = associado;

			array[2] = getByUuid_PrevAndNext(session, associado, uuid,
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

	protected Associado getByUuid_PrevAndNext(Session session,
		Associado associado, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Associado associado : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching associados
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

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "associado.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "associado.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(associado.uuid IS NULL OR associado.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AssociadoModelImpl.UUID_COLUMN_BITMASK |
			AssociadoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the associado where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByUUID_G(String uuid, long groupId)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByUUID_G(uuid, groupId);

		if (associado == null) {
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

			throw new NoSuchAssociadoException(msg.toString());
		}

		return associado;
	}

	/**
	 * Returns the associado where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the associado where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Associado) {
			Associado associado = (Associado)result;

			if (!Validator.equals(uuid, associado.getUuid()) ||
					(groupId != associado.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

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

				List<Associado> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Associado associado = list.get(0);

					result = associado;

					cacheResult(associado);

					if ((associado.getUuid() == null) ||
							!associado.getUuid().equals(uuid) ||
							(associado.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, associado);
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
			return (Associado)result;
		}
	}

	/**
	 * Removes the associado where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the associado that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado removeByUUID_G(String uuid, long groupId)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByUUID_G(uuid, groupId);

		return remove(associado);
	}

	/**
	 * Returns the number of associados where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching associados
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

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "associado.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "associado.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(associado.uuid IS NULL OR associado.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "associado.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AssociadoModelImpl.UUID_COLUMN_BITMASK |
			AssociadoModelImpl.COMPANYID_COLUMN_BITMASK |
			AssociadoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the associados where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByUuid_C(String uuid, long companyId, int start,
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

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if (!Validator.equals(uuid, associado.getUuid()) ||
						(companyId != associado.getCompanyId())) {
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

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

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
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associado> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByUuid_C_PrevAndNext(long associadoId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, associado, uuid,
					companyId, orderByComparator, true);

			array[1] = associado;

			array[2] = getByUuid_C_PrevAndNext(session, associado, uuid,
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

	protected Associado getByUuid_C_PrevAndNext(Session session,
		Associado associado, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Associado associado : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching associados
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

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "associado.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "associado.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(associado.uuid IS NULL OR associado.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "associado.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			AssociadoModelImpl.COMPANYID_COLUMN_BITMASK |
			AssociadoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the associados where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the associados where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByCompany(long companyId, int start, int end,
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

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if ((companyId != associado.getCompanyId())) {
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

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByCompany_First(companyId, orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associado> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByCompany_Last(companyId, orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where companyId = &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByCompany_PrevAndNext(long associadoId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByCompany_PrevAndNext(session, associado, companyId,
					orderByComparator, true);

			array[1] = associado;

			array[2] = getByCompany_PrevAndNext(session, associado, companyId,
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

	protected Associado getByCompany_PrevAndNext(Session session,
		Associado associado, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Associado associado : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching associados
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

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "associado.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			AssociadoModelImpl.COMPANYID_COLUMN_BITMASK |
			AssociadoModelImpl.GROUPID_COLUMN_BITMASK |
			AssociadoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the associados where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if ((companyId != associado.getCompanyId()) ||
						(groupId != associado.getGroupId())) {
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

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associado> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByC_G_PrevAndNext(long associadoId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByC_G_PrevAndNext(session, associado, companyId,
					groupId, orderByComparator, true);

			array[1] = associado;

			array[2] = getByC_G_PrevAndNext(session, associado, companyId,
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

	protected Associado getByC_G_PrevAndNext(Session session,
		Associado associado, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> filterFindByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G(companyId, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AssociadoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Associado.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AssociadoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AssociadoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Associado>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set of associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] filterFindByC_G_PrevAndNext(long associadoId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(associadoId, companyId, groupId,
				orderByComparator);
		}

		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, associado,
					companyId, groupId, orderByComparator, true);

			array[1] = associado;

			array[2] = filterGetByC_G_PrevAndNext(session, associado,
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

	protected Associado filterGetByC_G_PrevAndNext(Session session,
		Associado associado, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AssociadoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Associado.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AssociadoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AssociadoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Associado associado : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

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

	/**
	 * Returns the number of associados that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ASSOCIADO_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Associado.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "associado.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "associado.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NOME",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NOME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the associados where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_NOME(long companyId, String nome)
		throws SystemException {
		return findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_NOME(long companyId, String nome, int start,
		int end) throws SystemException {
		return findByC_NOME(companyId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_NOME(long companyId, String nome, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME;
		finderArgs = new Object[] { companyId, nome, start, end, orderByComparator };

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if ((companyId != associado.getCompanyId()) ||
						!StringUtil.wildcardMatches(associado.getNome(), nome,
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
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_C_NOME_COMPANYID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByC_NOME_First(companyId, nome,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associado> list = findByC_NOME(companyId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByC_NOME_Last(companyId, nome,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_NOME(companyId, nome);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByC_NOME(companyId, nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByC_NOME_PrevAndNext(long associadoId,
		long companyId, String nome, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByC_NOME_PrevAndNext(session, associado, companyId,
					nome, orderByComparator, true);

			array[1] = associado;

			array[2] = getByC_NOME_PrevAndNext(session, associado, companyId,
					nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Associado getByC_NOME_PrevAndNext(Session session,
		Associado associado, long companyId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

		query.append(_FINDER_COLUMN_C_NOME_COMPANYID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_NOME_NOME_2);
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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where companyId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_NOME(long companyId, String nome)
		throws SystemException {
		for (Associado associado : findByC_NOME(companyId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_NOME(long companyId, String nome)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME;

		Object[] finderArgs = new Object[] { companyId, nome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_C_NOME_COMPANYID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_NOME_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_NOME_COMPANYID_2 = "associado.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOME_NOME_1 = "associado.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_NOME_NOME_2 = "associado.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_NOME_NOME_3 = "(associado.nome IS NULL OR associado.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME =
		new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME;
		finderArgs = new Object[] {
				companyId, groupId, nome,
				
				start, end, orderByComparator
			};

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if ((companyId != associado.getCompanyId()) ||
						(groupId != associado.getGroupId()) ||
						!StringUtil.wildcardMatches(associado.getNome(), nome,
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

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByC_G_NOME_First(companyId, groupId, nome,
				orderByComparator);

		if (associado != null) {
			return associado;
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

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Associado> list = findByC_G_NOME(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByC_G_NOME_Last(companyId, groupId, nome,
				orderByComparator);

		if (associado != null) {
			return associado;
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

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_NOME(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByC_G_NOME(companyId, groupId, nome,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByC_G_NOME_PrevAndNext(long associadoId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByC_G_NOME_PrevAndNext(session, associado, companyId,
					groupId, nome, orderByComparator, true);

			array[1] = associado;

			array[2] = getByC_G_NOME_PrevAndNext(session, associado, companyId,
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

	protected Associado getByC_G_NOME_PrevAndNext(Session session,
		Associado associado, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> filterFindByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME(companyId, groupId, nome, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AssociadoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Associado.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AssociadoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AssociadoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			return (List<Associado>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set of associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] filterFindByC_G_NOME_PrevAndNext(long associadoId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME_PrevAndNext(associadoId, companyId, groupId,
				nome, orderByComparator);
		}

		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = filterGetByC_G_NOME_PrevAndNext(session, associado,
					companyId, groupId, nome, orderByComparator, true);

			array[1] = associado;

			array[2] = filterGetByC_G_NOME_PrevAndNext(session, associado,
					companyId, groupId, nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Associado filterGetByC_G_NOME_PrevAndNext(Session session,
		Associado associado, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AssociadoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Associado.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AssociadoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AssociadoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		for (Associado associado : findByC_G_NOME(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME;

		Object[] finderArgs = new Object[] { companyId, groupId, nome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
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

	/**
	 * Returns the number of associados that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching associados that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_NOME(companyId, groupId, nome);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_ASSOCIADO_WHERE);

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Associado.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_C_G_NOME_COMPANYID_2 = "associado.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_GROUPID_2 = "associado.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_1 = "associado.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_2 = "associado.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_3 = "(associado.nome IS NULL OR associado.nome LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CPF_CNPJ = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCPF_CNPJ",
			new String[] { String.class.getName() },
			AssociadoModelImpl.CPFCNPJ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CPF_CNPJ = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPF_CNPJ",
			new String[] { String.class.getName() });

	/**
	 * Returns the associado where cpfCnpj = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByCPF_CNPJ(String cpfCnpj)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByCPF_CNPJ(cpfCnpj);

		if (associado == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cpfCnpj=");
			msg.append(cpfCnpj);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAssociadoException(msg.toString());
		}

		return associado;
	}

	/**
	 * Returns the associado where cpfCnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByCPF_CNPJ(String cpfCnpj) throws SystemException {
		return fetchByCPF_CNPJ(cpfCnpj, true);
	}

	/**
	 * Returns the associado where cpfCnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByCPF_CNPJ(String cpfCnpj, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cpfCnpj };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
					finderArgs, this);
		}

		if (result instanceof Associado) {
			Associado associado = (Associado)result;

			if (!Validator.equals(cpfCnpj, associado.getCpfCnpj())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			boolean bindCpfCnpj = false;

			if (cpfCnpj == null) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_1);
			}
			else if (cpfCnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_3);
			}
			else {
				bindCpfCnpj = true;

				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpfCnpj) {
					qPos.add(cpfCnpj);
				}

				List<Associado> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AssociadoPersistenceImpl.fetchByCPF_CNPJ(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Associado associado = list.get(0);

					result = associado;

					cacheResult(associado);

					if ((associado.getCpfCnpj() == null) ||
							!associado.getCpfCnpj().equals(cpfCnpj)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
							finderArgs, associado);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
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
			return (Associado)result;
		}
	}

	/**
	 * Removes the associado where cpfCnpj = &#63; from the database.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the associado that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado removeByCPF_CNPJ(String cpfCnpj)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByCPF_CNPJ(cpfCnpj);

		return remove(associado);
	}

	/**
	 * Returns the number of associados where cpfCnpj = &#63;.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCPF_CNPJ(String cpfCnpj) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CPF_CNPJ;

		Object[] finderArgs = new Object[] { cpfCnpj };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			boolean bindCpfCnpj = false;

			if (cpfCnpj == null) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_1);
			}
			else if (cpfCnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_3);
			}
			else {
				bindCpfCnpj = true;

				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpfCnpj) {
					qPos.add(cpfCnpj);
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

	private static final String _FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_1 = "associado.cpfCnpj IS NULL";
	private static final String _FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_2 = "associado.cpfCnpj = ?";
	private static final String _FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_3 = "(associado.cpfCnpj IS NULL OR associado.cpfCnpj = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_RG_INSCRICAO = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRG_INSCRICAO",
			new String[] { String.class.getName() },
			AssociadoModelImpl.RGINSCRICAOMUN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RG_INSCRICAO = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRG_INSCRICAO",
			new String[] { String.class.getName() });

	/**
	 * Returns the associado where rgInscricaoMun = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByRG_INSCRICAO(String rgInscricaoMun)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByRG_INSCRICAO(rgInscricaoMun);

		if (associado == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rgInscricaoMun=");
			msg.append(rgInscricaoMun);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAssociadoException(msg.toString());
		}

		return associado;
	}

	/**
	 * Returns the associado where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByRG_INSCRICAO(String rgInscricaoMun)
		throws SystemException {
		return fetchByRG_INSCRICAO(rgInscricaoMun, true);
	}

	/**
	 * Returns the associado where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByRG_INSCRICAO(String rgInscricaoMun,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { rgInscricaoMun };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
					finderArgs, this);
		}

		if (result instanceof Associado) {
			Associado associado = (Associado)result;

			if (!Validator.equals(rgInscricaoMun, associado.getRgInscricaoMun())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			boolean bindRgInscricaoMun = false;

			if (rgInscricaoMun == null) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_1);
			}
			else if (rgInscricaoMun.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_3);
			}
			else {
				bindRgInscricaoMun = true;

				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRgInscricaoMun) {
					qPos.add(rgInscricaoMun);
				}

				List<Associado> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AssociadoPersistenceImpl.fetchByRG_INSCRICAO(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Associado associado = list.get(0);

					result = associado;

					cacheResult(associado);

					if ((associado.getRgInscricaoMun() == null) ||
							!associado.getRgInscricaoMun().equals(rgInscricaoMun)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
							finderArgs, associado);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
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
			return (Associado)result;
		}
	}

	/**
	 * Removes the associado where rgInscricaoMun = &#63; from the database.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the associado that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado removeByRG_INSCRICAO(String rgInscricaoMun)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByRG_INSCRICAO(rgInscricaoMun);

		return remove(associado);
	}

	/**
	 * Returns the number of associados where rgInscricaoMun = &#63;.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRG_INSCRICAO(String rgInscricaoMun)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RG_INSCRICAO;

		Object[] finderArgs = new Object[] { rgInscricaoMun };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			boolean bindRgInscricaoMun = false;

			if (rgInscricaoMun == null) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_1);
			}
			else if (rgInscricaoMun.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_3);
			}
			else {
				bindRgInscricaoMun = true;

				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRgInscricaoMun) {
					qPos.add(rgInscricaoMun);
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

	private static final String _FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_1 = "associado.rgInscricaoMun IS NULL";
	private static final String _FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_2 = "associado.rgInscricaoMun = ?";
	private static final String _FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_3 = "(associado.rgInscricaoMun IS NULL OR associado.rgInscricaoMun = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DT_NASCIMENTO =
		new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDT_NASCIMENTO",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO =
		new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDT_NASCIMENTO",
			new String[] { Date.class.getName() },
			AssociadoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			AssociadoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DT_NASCIMENTO = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDT_NASCIMENTO",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the associados where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		return findByDT_NASCIMENTO(dataNascimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByDT_NASCIMENTO(Date dataNascimento, int start,
		int end) throws SystemException {
		return findByDT_NASCIMENTO(dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findByDT_NASCIMENTO(Date dataNascimento, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO;
			finderArgs = new Object[] { dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DT_NASCIMENTO;
			finderArgs = new Object[] {
					dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associado associado : list) {
				if (!Validator.equals(dataNascimento,
							associado.getDataNascimento())) {
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

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociadoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

				if (!pagination) {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associado in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByDT_NASCIMENTO_First(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByDT_NASCIMENTO_First(dataNascimento,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the first associado in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByDT_NASCIMENTO_First(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associado> list = findByDT_NASCIMENTO(dataNascimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associado in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByDT_NASCIMENTO_Last(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByDT_NASCIMENTO_Last(dataNascimento,
				orderByComparator);

		if (associado != null) {
			return associado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociadoException(msg.toString());
	}

	/**
	 * Returns the last associado in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByDT_NASCIMENTO_Last(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDT_NASCIMENTO(dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Associado> list = findByDT_NASCIMENTO(dataNascimento, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associados before and after the current associado in the ordered set where dataNascimento = &#63;.
	 *
	 * @param associadoId the primary key of the current associado
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado[] findByDT_NASCIMENTO_PrevAndNext(long associadoId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByPrimaryKey(associadoId);

		Session session = null;

		try {
			session = openSession();

			Associado[] array = new AssociadoImpl[3];

			array[0] = getByDT_NASCIMENTO_PrevAndNext(session, associado,
					dataNascimento, orderByComparator, true);

			array[1] = associado;

			array[2] = getByDT_NASCIMENTO_PrevAndNext(session, associado,
					dataNascimento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Associado getByDT_NASCIMENTO_PrevAndNext(Session session,
		Associado associado, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIADO_WHERE);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2);
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
			query.append(AssociadoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDataNascimento) {
			qPos.add(CalendarUtil.getTimestamp(dataNascimento));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associados where dataNascimento = &#63; from the database.
	 *
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		for (Associado associado : findByDT_NASCIMENTO(dataNascimento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DT_NASCIMENTO;

		Object[] finderArgs = new Object[] { dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
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

	private static final String _FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1 = "associado.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2 = "associado.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USUARIO = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUSUARIO",
			new String[] { Long.class.getName() },
			AssociadoModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USUARIO = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSUARIO",
			new String[] { Long.class.getName() });

	/**
	 * Returns the associado where userId = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByUSUARIO(long userId)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByUSUARIO(userId);

		if (associado == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAssociadoException(msg.toString());
		}

		return associado;
	}

	/**
	 * Returns the associado where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUSUARIO(long userId) throws SystemException {
		return fetchByUSUARIO(userId, true);
	}

	/**
	 * Returns the associado where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByUSUARIO(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USUARIO,
					finderArgs, this);
		}

		if (result instanceof Associado) {
			Associado associado = (Associado)result;

			if ((userId != associado.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_USUARIO_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Associado> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AssociadoPersistenceImpl.fetchByUSUARIO(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Associado associado = list.get(0);

					result = associado;

					cacheResult(associado);

					if ((associado.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
							finderArgs, associado);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO,
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
			return (Associado)result;
		}
	}

	/**
	 * Removes the associado where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the associado that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado removeByUSUARIO(long userId)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByUSUARIO(userId);

		return remove(associado);
	}

	/**
	 * Returns the number of associados where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUSUARIO(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USUARIO;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			query.append(_FINDER_COLUMN_USUARIO_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USUARIO_USERID_2 = "associado.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ID_POLISHOP = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, AssociadoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByID_POLISHOP",
			new String[] { String.class.getName() },
			AssociadoModelImpl.IDPOLISHOP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID_POLISHOP = new FinderPath(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByID_POLISHOP",
			new String[] { String.class.getName() });

	/**
	 * Returns the associado where idPolishop = &#63; or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	 *
	 * @param idPolishop the id polishop
	 * @return the matching associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByID_POLISHOP(String idPolishop)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByID_POLISHOP(idPolishop);

		if (associado == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idPolishop=");
			msg.append(idPolishop);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAssociadoException(msg.toString());
		}

		return associado;
	}

	/**
	 * Returns the associado where idPolishop = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idPolishop the id polishop
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByID_POLISHOP(String idPolishop)
		throws SystemException {
		return fetchByID_POLISHOP(idPolishop, true);
	}

	/**
	 * Returns the associado where idPolishop = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idPolishop the id polishop
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching associado, or <code>null</code> if a matching associado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByID_POLISHOP(String idPolishop,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { idPolishop };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID_POLISHOP,
					finderArgs, this);
		}

		if (result instanceof Associado) {
			Associado associado = (Associado)result;

			if (!Validator.equals(idPolishop, associado.getIdPolishop())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ASSOCIADO_WHERE);

			boolean bindIdPolishop = false;

			if (idPolishop == null) {
				query.append(_FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_1);
			}
			else if (idPolishop.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_3);
			}
			else {
				bindIdPolishop = true;

				query.append(_FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdPolishop) {
					qPos.add(idPolishop);
				}

				List<Associado> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID_POLISHOP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AssociadoPersistenceImpl.fetchByID_POLISHOP(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Associado associado = list.get(0);

					result = associado;

					cacheResult(associado);

					if ((associado.getIdPolishop() == null) ||
							!associado.getIdPolishop().equals(idPolishop)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID_POLISHOP,
							finderArgs, associado);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID_POLISHOP,
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
			return (Associado)result;
		}
	}

	/**
	 * Removes the associado where idPolishop = &#63; from the database.
	 *
	 * @param idPolishop the id polishop
	 * @return the associado that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado removeByID_POLISHOP(String idPolishop)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = findByID_POLISHOP(idPolishop);

		return remove(associado);
	}

	/**
	 * Returns the number of associados where idPolishop = &#63;.
	 *
	 * @param idPolishop the id polishop
	 * @return the number of matching associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByID_POLISHOP(String idPolishop) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID_POLISHOP;

		Object[] finderArgs = new Object[] { idPolishop };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIADO_WHERE);

			boolean bindIdPolishop = false;

			if (idPolishop == null) {
				query.append(_FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_1);
			}
			else if (idPolishop.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_3);
			}
			else {
				bindIdPolishop = true;

				query.append(_FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdPolishop) {
					qPos.add(idPolishop);
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

	private static final String _FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_1 = "associado.idPolishop IS NULL";
	private static final String _FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_2 = "associado.idPolishop = ?";
	private static final String _FINDER_COLUMN_ID_POLISHOP_IDPOLISHOP_3 = "(associado.idPolishop IS NULL OR associado.idPolishop = '')";

	public AssociadoPersistenceImpl() {
		setModelClass(Associado.class);
	}

	/**
	 * Caches the associado in the entity cache if it is enabled.
	 *
	 * @param associado the associado
	 */
	@Override
	public void cacheResult(Associado associado) {
		EntityCacheUtil.putResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoImpl.class, associado.getPrimaryKey(), associado);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { associado.getUuid(), associado.getGroupId() },
			associado);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
			new Object[] { associado.getCpfCnpj() }, associado);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
			new Object[] { associado.getRgInscricaoMun() }, associado);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
			new Object[] { associado.getUserId() }, associado);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID_POLISHOP,
			new Object[] { associado.getIdPolishop() }, associado);

		associado.resetOriginalValues();
	}

	/**
	 * Caches the associados in the entity cache if it is enabled.
	 *
	 * @param associados the associados
	 */
	@Override
	public void cacheResult(List<Associado> associados) {
		for (Associado associado : associados) {
			if (EntityCacheUtil.getResult(
						AssociadoModelImpl.ENTITY_CACHE_ENABLED,
						AssociadoImpl.class, associado.getPrimaryKey()) == null) {
				cacheResult(associado);
			}
			else {
				associado.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all associados.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AssociadoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AssociadoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the associado.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Associado associado) {
		EntityCacheUtil.removeResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoImpl.class, associado.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(associado);
	}

	@Override
	public void clearCache(List<Associado> associados) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Associado associado : associados) {
			EntityCacheUtil.removeResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
				AssociadoImpl.class, associado.getPrimaryKey());

			clearUniqueFindersCache(associado);
		}
	}

	protected void cacheUniqueFindersCache(Associado associado) {
		if (associado.isNew()) {
			Object[] args = new Object[] {
					associado.getUuid(), associado.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				associado);

			args = new Object[] { associado.getCpfCnpj() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args,
				associado);

			args = new Object[] { associado.getRgInscricaoMun() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO, args,
				associado);

			args = new Object[] { associado.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USUARIO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO, args,
				associado);

			args = new Object[] { associado.getIdPolishop() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID_POLISHOP, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID_POLISHOP, args,
				associado);
		}
		else {
			AssociadoModelImpl associadoModelImpl = (AssociadoModelImpl)associado;

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						associado.getUuid(), associado.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					associado);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CPF_CNPJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { associado.getCpfCnpj() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args,
					associado);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RG_INSCRICAO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { associado.getRgInscricaoMun() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
					args, associado);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { associado.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USUARIO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO, args,
					associado);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID_POLISHOP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { associado.getIdPolishop() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID_POLISHOP,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID_POLISHOP,
					args, associado);
			}
		}
	}

	protected void clearUniqueFindersCache(Associado associado) {
		AssociadoModelImpl associadoModelImpl = (AssociadoModelImpl)associado;

		Object[] args = new Object[] { associado.getUuid(), associado.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((associadoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					associadoModelImpl.getOriginalUuid(),
					associadoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { associado.getCpfCnpj() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args);

		if ((associadoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CPF_CNPJ.getColumnBitmask()) != 0) {
			args = new Object[] { associadoModelImpl.getOriginalCpfCnpj() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args);
		}

		args = new Object[] { associado.getRgInscricaoMun() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO, args);

		if ((associadoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RG_INSCRICAO.getColumnBitmask()) != 0) {
			args = new Object[] { associadoModelImpl.getOriginalRgInscricaoMun() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO, args);
		}

		args = new Object[] { associado.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO, args);

		if ((associadoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USUARIO.getColumnBitmask()) != 0) {
			args = new Object[] { associadoModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO, args);
		}

		args = new Object[] { associado.getIdPolishop() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID_POLISHOP, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID_POLISHOP, args);

		if ((associadoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ID_POLISHOP.getColumnBitmask()) != 0) {
			args = new Object[] { associadoModelImpl.getOriginalIdPolishop() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID_POLISHOP, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID_POLISHOP, args);
		}
	}

	/**
	 * Creates a new associado with the primary key. Does not add the associado to the database.
	 *
	 * @param associadoId the primary key for the new associado
	 * @return the new associado
	 */
	@Override
	public Associado create(long associadoId) {
		Associado associado = new AssociadoImpl();

		associado.setNew(true);
		associado.setPrimaryKey(associadoId);

		String uuid = PortalUUIDUtil.generate();

		associado.setUuid(uuid);

		return associado;
	}

	/**
	 * Removes the associado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param associadoId the primary key of the associado
	 * @return the associado that was removed
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado remove(long associadoId)
		throws NoSuchAssociadoException, SystemException {
		return remove((Serializable)associadoId);
	}

	/**
	 * Removes the associado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the associado
	 * @return the associado that was removed
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado remove(Serializable primaryKey)
		throws NoSuchAssociadoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Associado associado = (Associado)session.get(AssociadoImpl.class,
					primaryKey);

			if (associado == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssociadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(associado);
		}
		catch (NoSuchAssociadoException nsee) {
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
	protected Associado removeImpl(Associado associado)
		throws SystemException {
		associado = toUnwrappedModel(associado);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(associado)) {
				associado = (Associado)session.get(AssociadoImpl.class,
						associado.getPrimaryKeyObj());
			}

			if (associado != null) {
				session.delete(associado);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (associado != null) {
			clearCache(associado);
		}

		return associado;
	}

	@Override
	public Associado updateImpl(
		br.com.prodevelopment.associado.model.Associado associado)
		throws SystemException {
		associado = toUnwrappedModel(associado);

		boolean isNew = associado.isNew();

		AssociadoModelImpl associadoModelImpl = (AssociadoModelImpl)associado;

		if (Validator.isNull(associado.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			associado.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (associado.isNew()) {
				session.save(associado);

				associado.setNew(false);
			}
			else {
				session.merge(associado);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AssociadoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						associadoModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { associadoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						associadoModelImpl.getOriginalUuid(),
						associadoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						associadoModelImpl.getUuid(),
						associadoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						associadoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { associadoModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						associadoModelImpl.getOriginalCompanyId(),
						associadoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						associadoModelImpl.getCompanyId(),
						associadoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((associadoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						associadoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DT_NASCIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO,
					args);

				args = new Object[] { associadoModelImpl.getDataNascimento() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DT_NASCIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
			AssociadoImpl.class, associado.getPrimaryKey(), associado);

		clearUniqueFindersCache(associado);
		cacheUniqueFindersCache(associado);

		return associado;
	}

	protected Associado toUnwrappedModel(Associado associado) {
		if (associado instanceof AssociadoImpl) {
			return associado;
		}

		AssociadoImpl associadoImpl = new AssociadoImpl();

		associadoImpl.setNew(associado.isNew());
		associadoImpl.setPrimaryKey(associado.getPrimaryKey());

		associadoImpl.setUuid(associado.getUuid());
		associadoImpl.setAssociadoId(associado.getAssociadoId());
		associadoImpl.setCompanyId(associado.getCompanyId());
		associadoImpl.setGroupId(associado.getGroupId());
		associadoImpl.setCreateUserId(associado.getCreateUserId());
		associadoImpl.setModifiedUserId(associado.getModifiedUserId());
		associadoImpl.setCreateDate(associado.getCreateDate());
		associadoImpl.setModifiedDate(associado.getModifiedDate());
		associadoImpl.setNome(associado.getNome());
		associadoImpl.setRgInscricaoMun(associado.getRgInscricaoMun());
		associadoImpl.setRgOrgaoEmissor(associado.getRgOrgaoEmissor());
		associadoImpl.setRgDataEmissao(associado.getRgDataEmissao());
		associadoImpl.setTipoPessoa(associado.getTipoPessoa());
		associadoImpl.setCpfCnpj(associado.getCpfCnpj());
		associadoImpl.setSexo(associado.getSexo());
		associadoImpl.setEstadoCivil(associado.getEstadoCivil());
		associadoImpl.setDataNascimento(associado.getDataNascimento());
		associadoImpl.setEndComLogradouro(associado.getEndComLogradouro());
		associadoImpl.setEndComNumero(associado.getEndComNumero());
		associadoImpl.setEndComComplemento(associado.getEndComComplemento());
		associadoImpl.setEndComCep(associado.getEndComCep());
		associadoImpl.setEndComBairro(associado.getEndComBairro());
		associadoImpl.setEndComCidade(associado.getEndComCidade());
		associadoImpl.setEndComUf(associado.getEndComUf());
		associadoImpl.setEndComPais(associado.getEndComPais());
		associadoImpl.setEndResLogradouro(associado.getEndResLogradouro());
		associadoImpl.setEndResNumero(associado.getEndResNumero());
		associadoImpl.setEndResComplemento(associado.getEndResComplemento());
		associadoImpl.setEndResCep(associado.getEndResCep());
		associadoImpl.setEndResBairro(associado.getEndResBairro());
		associadoImpl.setEndResCidade(associado.getEndResCidade());
		associadoImpl.setEndResUf(associado.getEndResUf());
		associadoImpl.setEndResPais(associado.getEndResPais());
		associadoImpl.setTelComDdd(associado.getTelComDdd());
		associadoImpl.setVersao(associado.getVersao());
		associadoImpl.setUserId(associado.getUserId());
		associadoImpl.setObservacao(associado.getObservacao());
		associadoImpl.setIdPolishop(associado.getIdPolishop());
		associadoImpl.setIdLojaIndicada(associado.getIdLojaIndicada());
		associadoImpl.setIdPatrocinador(associado.getIdPatrocinador());

		return associadoImpl;
	}

	/**
	 * Returns the associado with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the associado
	 * @return the associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssociadoException, SystemException {
		Associado associado = fetchByPrimaryKey(primaryKey);

		if (associado == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssociadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return associado;
	}

	/**
	 * Returns the associado with the primary key or throws a {@link br.com.prodevelopment.associado.NoSuchAssociadoException} if it could not be found.
	 *
	 * @param associadoId the primary key of the associado
	 * @return the associado
	 * @throws br.com.prodevelopment.associado.NoSuchAssociadoException if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado findByPrimaryKey(long associadoId)
		throws NoSuchAssociadoException, SystemException {
		return findByPrimaryKey((Serializable)associadoId);
	}

	/**
	 * Returns the associado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the associado
	 * @return the associado, or <code>null</code> if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Associado associado = (Associado)EntityCacheUtil.getResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
				AssociadoImpl.class, primaryKey);

		if (associado == _nullAssociado) {
			return null;
		}

		if (associado == null) {
			Session session = null;

			try {
				session = openSession();

				associado = (Associado)session.get(AssociadoImpl.class,
						primaryKey);

				if (associado != null) {
					cacheResult(associado);
				}
				else {
					EntityCacheUtil.putResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
						AssociadoImpl.class, primaryKey, _nullAssociado);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AssociadoModelImpl.ENTITY_CACHE_ENABLED,
					AssociadoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return associado;
	}

	/**
	 * Returns the associado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param associadoId the primary key of the associado
	 * @return the associado, or <code>null</code> if a associado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associado fetchByPrimaryKey(long associadoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)associadoId);
	}

	/**
	 * Returns all the associados.
	 *
	 * @return the associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @return the range of associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the associados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.associado.model.impl.AssociadoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of associados
	 * @param end the upper bound of the range of associados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of associados
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associado> findAll(int start, int end,
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

		List<Associado> list = (List<Associado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSOCIADO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSOCIADO;

				if (pagination) {
					sql = sql.concat(AssociadoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associado>(list);
				}
				else {
					list = (List<Associado>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the associados from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Associado associado : findAll()) {
			remove(associado);
		}
	}

	/**
	 * Returns the number of associados.
	 *
	 * @return the number of associados
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

				Query q = session.createQuery(_SQL_COUNT_ASSOCIADO);

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
	 * Initializes the associado persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.associado.model.Associado")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Associado>> listenersList = new ArrayList<ModelListener<Associado>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Associado>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AssociadoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASSOCIADO = "SELECT associado FROM Associado associado";
	private static final String _SQL_SELECT_ASSOCIADO_WHERE = "SELECT associado FROM Associado associado WHERE ";
	private static final String _SQL_COUNT_ASSOCIADO = "SELECT COUNT(associado) FROM Associado associado";
	private static final String _SQL_COUNT_ASSOCIADO_WHERE = "SELECT COUNT(associado) FROM Associado associado WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "associado.associadoId";
	private static final String _FILTER_SQL_SELECT_ASSOCIADO_WHERE = "SELECT DISTINCT {associado.*} FROM associado associado WHERE ";
	private static final String _FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {associado.*} FROM (SELECT DISTINCT associado.associadoId FROM associado associado WHERE ";
	private static final String _FILTER_SQL_SELECT_ASSOCIADO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN associado ON TEMP_TABLE.associadoId = associado.associadoId";
	private static final String _FILTER_SQL_COUNT_ASSOCIADO_WHERE = "SELECT COUNT(DISTINCT associado.associadoId) AS COUNT_VALUE FROM associado associado WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "associado";
	private static final String _FILTER_ENTITY_TABLE = "associado";
	private static final String _ORDER_BY_ENTITY_ALIAS = "associado.";
	private static final String _ORDER_BY_ENTITY_TABLE = "associado.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Associado exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Associado exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AssociadoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Associado _nullAssociado = new AssociadoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Associado> toCacheModel() {
				return _nullAssociadoCacheModel;
			}
		};

	private static CacheModel<Associado> _nullAssociadoCacheModel = new CacheModel<Associado>() {
			@Override
			public Associado toEntityModel() {
				return _nullAssociado;
			}
		};
}