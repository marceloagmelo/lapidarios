package br.com.prodevelopment.portlet.associado.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.associado.model.Associado;
import br.com.prodevelopment.associado.service.AssociadoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.contato.NoSuchContatoException;
import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.portlet.associado.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;

public class AssociadoUtil {

	public static Associado getAssociado(long associadoId)
			throws SystemException {
		return AssociadoLocalServiceUtil.fetchAssociado(associadoId);
	}

	public static Associado getAssociado(HttpServletRequest request)
			throws PortalException, SystemException {

		long associadoId = ParamUtil.getLong(request,
				Constantes.ASSOCIADO_ID);

		Associado associado = null;
		Contato contato = ContatoUtil.getContato();
		if (associadoId > 0) {
			associado = AssociadoLocalServiceUtil
					.getAssociado(associadoId);
			long classNameId = PortalUtil.getClassNameId(Associado.class.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(classNameId, associado.getAssociadoId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
			}
		}

		request.setAttribute(Constantes.ASSOCIADO, associado);
		request.setAttribute(Constantes.ASSOCIADO_ID, associadoId);
		request.setAttribute("enderecos.className", Contato.class.getName());
		request.setAttribute("enderecos.classPK", contato.getContatoId());
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());
		
		return associado;
	}

	public static Associado getAssociado(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getAssociado(request);
	}

	public static Associado getAssociado(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getAssociado(request);
	}

	public static String getFotoURL(String imagePath, String sexo, long fotoId) {

		StringBundler sb = new StringBundler(7);

		sb.append(imagePath);
		sb.append("/user_");

		if (Constantes.MASCULINO.equals(sexo)) {
			sb.append("male");
		} else {
			sb.append("female");
		}

		sb.append("_portrait?img_id=");
		sb.append(fotoId);
		sb.append("&t=");
		sb.append(WebServerServletTokenUtil.getToken(fotoId));

		return sb.toString();
	}

	public static List<Associado> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator, PermissionChecker permissionChecker,
			boolean somenteEsseSite) throws SystemException {
		List<Associado> retorno = new ArrayList<Associado>();
		List<Associado> lista = null;
		if (Validator.isNotNull(keywords)) {
			if (somenteEsseSite) {
				lista = AssociadoLocalServiceUtil
						.search(companyId, groupId, StringPool.PERCENT
								+ keywords + StringPool.PERCENT,
								QueryUtil.ALL_POS, QueryUtil.ALL_POS,
								orderByComparator);

			} else {
				lista = AssociadoLocalServiceUtil
						.search(companyId, StringPool.PERCENT + keywords
								+ StringPool.PERCENT, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		} else {
			if (somenteEsseSite) {
				lista = AssociadoLocalServiceUtil
						.search(companyId, groupId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			} else {
				lista = AssociadoLocalServiceUtil
						.search(companyId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		}

		for (Associado associado : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Associado.class.getName(), associado.getAssociadoId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(associado);
			}
		}
		
		return retorno;
	}
}
