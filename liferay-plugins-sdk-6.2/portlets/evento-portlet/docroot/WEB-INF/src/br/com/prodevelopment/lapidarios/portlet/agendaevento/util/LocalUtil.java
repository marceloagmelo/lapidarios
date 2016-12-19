package br.com.prodevelopment.lapidarios.portlet.agendaevento.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.lapidarios.evento.model.Local;
import br.com.prodevelopment.lapidarios.evento.service.LocalLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class LocalUtil {
	public static Local getLocal(long localId) throws SystemException {
		return LocalLocalServiceUtil.fetchLocal(localId);
	}

	public static Local getLocal(HttpServletRequest request)
			throws PortalException, SystemException {

		long localId = ParamUtil.getLong(request, Constantes.CAMPO_LOCAL_ID);

		Local local = null;
		if (localId > 0) {
			local = LocalLocalServiceUtil.getLocal(localId);
		}

		request.setAttribute(Constantes.LOCAL, local);
		request.setAttribute(Constantes.CAMPO_LOCAL_ID, localId);

		return local;
	}

	public static Local getLocal(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getLocal(request);
	}

	public static Local getLocal(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getLocal(request);
	}

	public static List<Local> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<Local> retorno = new ArrayList<Local>();
		List<Local> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = LocalLocalServiceUtil.search(companyId, groupId,
					StringPool.PERCENT + keywords + StringPool.PERCENT,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		} else {
			lista = LocalLocalServiceUtil.search(companyId, groupId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		}

		for (Local local : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = true;/*
											 * permissionChecker.hasPermission(
											 * groupId, Local.class.getName(),
											 * local.getLocalId(),
											 * ActionKeys.VIEW);
											 */
			if (hasViewPermission) {
				retorno.add(local);
			}
		}

		return retorno;
	}

	public static List<String> getUFs(long companyId, long groupId)
			throws SystemException {
		List<String> retorno = new ArrayList<String>();

		List<Local> lista = LocalLocalServiceUtil.search(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		Map<String, String> map = new LinkedHashMap<String, String>();
		for (Local local : lista) {
			if (Validator.isNotNull(local.getEndUf())) {
				map.put(local.getEndUf(), local.getEndUf());
			}
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static List<String> getCidadesFromUF(long companyId, long groupId,
			String uf) throws SystemException {
		List<String> retorno = new ArrayList<String>();

		List<Local> lista = LocalLocalServiceUtil.search(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		Map<String, String> map = new LinkedHashMap<String, String>();
		for (Local local : lista) {
			if ((Validator.isNotNull(local.getEndCidade()))
					&& (uf.equals(local.getEndUf()))) {
				String cidade = local.getEndCidade().replace(" ", "#");
				map.put(cidade, cidade);
			}
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static List<Local> getLocaisFromCidade(long companyId, long groupId,
			String cidade) throws SystemException {
		
		cidade = cidade.replace("#", " ");
		List<Local> retorno = new ArrayList<Local>();

		List<Local> lista = LocalLocalServiceUtil.search(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		Map<String, Local> map = new LinkedHashMap<String, Local>();
		for (Local local : lista) {
			if ((Validator.isNotNull(local.getNome()))
					&& (cidade.equals(local.getEndCidade()))) {
				map.put(String.valueOf(local.getLocalId()), local);
			}
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static List<Local> getLocaisFromUF(long companyId, long groupId,
			String uf) throws SystemException {
		List<Local> retorno = new ArrayList<Local>();

		List<Local> lista = LocalLocalServiceUtil.search(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		Map<String, Local> map = new LinkedHashMap<String, Local>();
		for (Local local : lista) {
			if ((Validator.isNotNull(local.getNome()))
					&& (uf.equals(local.getEndUf()))) {
				map.put(String.valueOf(local.getLocalId()), local);
			}
		}

		retorno = ListUtil.fromMapValues(map);

		return retorno;
	}

	public static JSONArray carregarCidades(List<String> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (String cidade : lista) {
			JSONObject jsonCidade = JSONFactoryUtil.createJSONObject();
			String cidadeDesc = cidade.replace("#" , " ");
			jsonCidade.put(Constantes.CIDADE, cidadeDesc);
			jsonCidade.put(Constantes.CODIGO, cidade);
			jsonArray.put(jsonCidade);
		}
		
		return jsonArray;
	}

	public static JSONArray carregarLocais(List<Local> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonLocal = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(lista)) {
			for (Local local : lista) {
				jsonLocal.put(Constantes.LOCAL, local.getNome());
				jsonLocal.put(Constantes.CODIGO, local.getLocalId());
				jsonArray.put(jsonLocal);
			}
		} else {
			jsonLocal.put(Constantes.LOCAL, "Todos");
			jsonLocal.put(Constantes.CODIGO, "0");
			jsonArray.put(jsonLocal);
		}
		
		return jsonArray;
	}
}