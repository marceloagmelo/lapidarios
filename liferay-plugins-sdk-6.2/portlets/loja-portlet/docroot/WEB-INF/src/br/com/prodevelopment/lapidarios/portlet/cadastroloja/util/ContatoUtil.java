package br.com.prodevelopment.lapidarios.portlet.cadastroloja.util;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ContatoUtil {

	public static Contato getContato(long contatoId) throws SystemException {
		return ContatoLocalServiceUtil.fetchContato(contatoId);
	}

	public static Contato getContato(HttpServletRequest request)
			throws PortalException, SystemException {

		long contatoId = ParamUtil.getLong(request, CadastroLojaConstants.CONTATO_ID);

		Contato contato = null;
		if (contatoId > 0) {
			contato = ContatoLocalServiceUtil.getContato(contatoId);
		}

		request.setAttribute(CadastroLojaConstants.CONTATO, contato);
		request.setAttribute(CadastroLojaConstants.CONTATO_ID, contatoId);

		return contato;
	}

	public static Contato getContato(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getContato(request);
	}

	public static Contato getContato(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getContato(request);
	}

	public static Contato getContato() throws SystemException {
		
		return ContatoLocalServiceUtil.createContato();
	}
}