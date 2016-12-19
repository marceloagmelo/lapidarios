package br.com.prodevelopment.lapidarios.portlet.cadastroloja.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.prodevelopment.lapidarios.contato.NoSuchContatoException;
import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class LojaUtil {
	private static Logger _log = Logger.getLogger(LojaUtil.class);
	
	public static Loja getLoja(long lojaId)
			throws SystemException {
		return LojaLocalServiceUtil.fetchLoja(lojaId);
	}
	
	public static void setLoja(HttpServletRequest request) throws Exception {

		long lojaId = ParamUtil.getLong(request,
				CadastroLojaConstants.LOJA_ID);

		Loja loja = null;
		Contato contato = ContatoUtil.getContato();
		
		if (lojaId > 0) {
			loja = LojaLocalServiceUtil.fetchLoja(lojaId);
			long classNameId = PortalUtil.getClassNameId(Loja.class.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(classNameId, loja.getLojaId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
				_log.error(e.getMessage(), e);
			}
			
		}

		request.setAttribute(CadastroLojaConstants.LOJA, loja);
		request.setAttribute(CadastroLojaConstants.LOJA_ID, lojaId);
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());
	}

	public static void getLoja(RenderRequest renderRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(renderRequest);

		setLoja(request);
	}


	public static Loja getLoja(ActionRequest actionRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getLoja(request);
	}

	public static Loja getLoja(HttpServletRequest request) throws Exception {

		long lojaId = ParamUtil.getLong(request,
				CadastroLojaConstants.LOJA_ID);

		Loja loja = null;
		Contato contato = ContatoUtil.getContato();

		if (lojaId > 0) {
			loja = LojaLocalServiceUtil.fetchLoja(lojaId);
			long classNameId = PortalUtil.getClassNameId(Loja.class.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(classNameId, loja.getLojaId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
				_log.error(e.getMessage(), e);
			}
		}

		request.setAttribute(CadastroLojaConstants.LOJA, loja);
		request.setAttribute(CadastroLojaConstants.LOJA_ID, lojaId);
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());
		
		return loja;
	}
	
	public static List<Loja> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<Loja> retorno = new ArrayList<Loja>();
		List<Loja> lista = null;
		long classNameId = PortalUtil.getClassNameId(Loja.class);
		int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};
		if (Validator.isNotNull(keywords)) {
			lista = LojaLocalServiceUtil.search(companyId, groupId,
					classNameId, StringPool.PERCENT + keywords + StringPool.PERCENT, status,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		} else {
			lista = LojaLocalServiceUtil.search(companyId, groupId, classNameId, status, 
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		}

		for (Loja loja : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Loja.class.getName(),
					loja.getLojaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(loja);
			}
		}

		return retorno;
	}

	public static List<Loja> search(long companyId, long groupId,
			String keywords, int[ ] status, int start, int end, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<Loja> retorno = new ArrayList<Loja>();
		List<Loja> lista = null;
		long classNameId = PortalUtil.getClassNameId(Loja.class);
		if (Validator.isNotNull(keywords)) {
			lista = LojaLocalServiceUtil.search(companyId, groupId,
					classNameId, StringPool.PERCENT + keywords + StringPool.PERCENT, status,
					start, end, orderByComparator);

		} else {
			lista = LojaLocalServiceUtil.search(companyId, groupId, classNameId, status, 
					start, end, orderByComparator);
		}

		for (Loja loja : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = true;permissionChecker.hasPermission(
					groupId, Loja.class.getName(),
					loja.getLojaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(loja);
			}
		}

		return retorno;
	}

	public static int searchCount(long companyId, long groupId,
			String keywords, int[ ] status, PermissionChecker permissionChecker) throws SystemException {
		int retorno = 0;
		List<Loja> lista = null;
		//int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};
		long classNameId = PortalUtil.getClassNameId(Loja.class);
		if (Validator.isNotNull(keywords)) {
			lista = LojaLocalServiceUtil.search(companyId, groupId,
					classNameId, StringPool.PERCENT + keywords + StringPool.PERCENT, status,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		} else {
			lista = LojaLocalServiceUtil.search(companyId, groupId, classNameId, status,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}

		for (Loja loja : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Loja.class.getName(),
					loja.getLojaId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno++;
			}
		}

		return retorno;
	}	
}
