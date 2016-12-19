package br.com.prodevelopment.lapidarios.portlet.lojaindicada.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.lojaindicada.service.LojaIndicadaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.lojaindicada.LojaIndicadaConstants;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class LojaIndicadaUtil {
	public static LojaIndicada getLojaIndicada(long lojaIndicadaId)
			throws SystemException {
		return LojaIndicadaLocalServiceUtil.fetchLojaIndicada(lojaIndicadaId);
	}

	public static void setLojaIndicada(HttpServletRequest request) throws Exception {

		long lojaIndicadaId = ParamUtil.getLong(request,
				LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID);

		LojaIndicada lojaIndicada = null;

		if (lojaIndicadaId > 0) {
			lojaIndicada = LojaIndicadaLocalServiceUtil
					.fetchLojaIndicada(lojaIndicadaId);
		}

		request.setAttribute(LojaIndicadaConstants.LOJA_INDICADA, lojaIndicada);
		request.setAttribute(LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID,
				lojaIndicadaId);
	}

	public static void getLojaIndicada(RenderRequest renderRequest) throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(renderRequest);

		setLojaIndicada(request);
	}

	public static LojaIndicada getLojaIndicada(ActionRequest actionRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getLojaIndicada(request);
	}

	public static LojaIndicada getLojaIndicada(HttpServletRequest request)
			throws Exception {

		long lojaIndicadaId = ParamUtil.getLong(request,
				LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID);

		LojaIndicada lojaIndicada = null;

		if (lojaIndicadaId > 0) {
			lojaIndicada = LojaIndicadaLocalServiceUtil
					.fetchLojaIndicada(lojaIndicadaId);
		}

		request.setAttribute(LojaIndicadaConstants.LOJA_INDICADA, lojaIndicada);
		request.setAttribute(LojaIndicadaConstants.CAMPO_LOJA_INDICADA_ID,
				lojaIndicadaId);

		return lojaIndicada;
	}

	public static List<LojaIndicada> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<LojaIndicada> retorno = new ArrayList<LojaIndicada>();
		List<LojaIndicada> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = LojaIndicadaLocalServiceUtil.search(companyId, groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		} else {
			lista = LojaIndicadaLocalServiceUtil.search(companyId, groupId, 
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		}

		for (LojaIndicada lojaIndicada : lista) {
			/*
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, LojaIndicada.class.getName(),
					lojaIndicada.getLojaIndicadaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(lojaIndicada);
			}
			*/
			retorno.add(lojaIndicada);
		}

		return retorno;
	}

	public static List<LojaIndicada> search(long companyId, long groupId,
			String keywords, int start, int end, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<LojaIndicada> retorno = new ArrayList<LojaIndicada>();
		List<LojaIndicada> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = LojaIndicadaLocalServiceUtil.search(companyId, groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT, start, end, orderByComparator);

		} else {
			lista = LojaIndicadaLocalServiceUtil.search(companyId, groupId, 
					start, end, orderByComparator);
		}

		if (Validator.isNotNull(lista)) {
			for (LojaIndicada lojaIndicada : lista) {
				/*
				// Permissao de visualizar
				boolean hasViewPermission = permissionChecker.hasPermission(
						groupId, LojaIndicada.class.getName(),
						lojaIndicada.getLojaIndicadaId(), ActionKeys.VIEW);
				if (hasViewPermission) {
					retorno.add(lojaIndicada);
				}
				*/
				retorno.add(lojaIndicada);
			}
		}

		return retorno;
	}

	public static int searchCount(long companyId, long groupId,
			String keywords, PermissionChecker permissionChecker)
			throws SystemException {
		int retorno = 0;
		List<LojaIndicada> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = LojaIndicadaLocalServiceUtil.search(companyId, groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		} else {
			lista = LojaIndicadaLocalServiceUtil.search(companyId, groupId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}

		if (Validator.isNotNull(lista)) {
			for (LojaIndicada lojaIndicada : lista) {
				/*
				 * // Permissao de visualizar boolean hasViewPermission =
				 * permissionChecker.hasPermission( groupId,
				 * LojaIndicada.class.getName(), lojaIndicada.getLojaIndicadaId(),
				 * ActionKeys.VIEW); if (hasViewPermission) { retorno++; }
				 */
				retorno++;
			}
	}

		return retorno;
	}
}
