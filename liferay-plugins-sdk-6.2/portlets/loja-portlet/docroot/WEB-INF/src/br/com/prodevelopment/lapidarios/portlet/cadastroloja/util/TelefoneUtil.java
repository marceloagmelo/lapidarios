package br.com.prodevelopment.lapidarios.portlet.cadastroloja.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.lapidarios.contato.model.Contato;
import br.com.prodevelopment.lapidarios.contato.model.Telefone;
import br.com.prodevelopment.lapidarios.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PortalUtil;

public class TelefoneUtil {

	public static Telefone getTelefone(long telefoneId) throws SystemException {
		return TelefoneLocalServiceUtil.fetchTelefone(telefoneId);
	}

	public static Telefone getTelefone(HttpServletRequest request)
			throws PortalException, SystemException {

		long telefoneId = ParamUtil.getLong(request, CadastroLojaConstants.TELEFONE_ID);

		Telefone telefone = null;
		if (telefoneId > 0) {
			telefone = TelefoneLocalServiceUtil.getTelefone(telefoneId);
		}

		request.setAttribute(CadastroLojaConstants.TELEFONE, telefone);
		request.setAttribute(CadastroLojaConstants.TELEFONE_ID, telefoneId);

		return telefone;
	}

	public static Telefone getTelefone(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getTelefone(request);
	}

	public static Telefone getTelefone(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getTelefone(request);
	}

	public static Telefone getTelefone() throws SystemException {
		return TelefoneLocalServiceUtil.createTelefone();
	}

	public static List<Telefone> getTelefones(long companyId, long classPK)
			throws SystemException {
		return TelefoneLocalServiceUtil.getTelefones(companyId,
				Contato.class.getName(), classPK);
	}

	public static List<Telefone> getTelefones(ActionRequest actionRequest) {
		return getTelefones(actionRequest, Collections.<Telefone> emptyList());
	}

	public static List<Telefone> getTelefones(ActionRequest actionRequest,
			List<Telefone> defaultTelefones) {

		String telefonesIndexesString = actionRequest
				.getParameter("telefonesIndexes");

		if (telefonesIndexesString == null) {
			return defaultTelefones;
		}

		List<Telefone> telefones = new ArrayList<Telefone>();

		int[] telefonesIndexes = StringUtil.split(telefonesIndexesString, 0);

		int principal = ParamUtil.getInteger(actionRequest,
				CadastroLojaConstants.CAMPO_TELEFONE_PRINCIPAL);

		for (int telefonesIndex : telefonesIndexes) {
			long telefoneId = ParamUtil.getLong(actionRequest,
					CadastroLojaConstants.TELEFONE_ID + telefonesIndex);

			int tipo = ParamUtil.getInteger(actionRequest,
					CadastroLojaConstants.CAMPO_TIPO_TELEFONE + telefonesIndex);
			String ddi = ParamUtil.getString(actionRequest,
					CadastroLojaConstants.CAMPO_DDI + telefonesIndex);
			String ddd = ParamUtil.getString(actionRequest,
					CadastroLojaConstants.CAMPO_DDD + telefonesIndex);
			String numero = ParamUtil.getString(actionRequest,
					CadastroLojaConstants.CAMPO_NUMERO_TELEFONE + telefonesIndex);
			String ramal = ParamUtil.getString(actionRequest,
					CadastroLojaConstants.CAMPO_RAMAL + telefonesIndex);

			if (tipo == 0) {
				continue;
			}

			boolean bPrincipal = false;

			if (telefonesIndex == principal) {
				bPrincipal = true;
			}

			Telefone telefone = TelefoneLocalServiceUtil
					.createTelefone(telefoneId);

			telefone.setDdi(ddi);
			telefone.setDdd(ddd);
			telefone.setNumero(numero);
			telefone.setRamal(ramal);
			telefone.setTipo(tipo);
			telefone.setPrincipal(bPrincipal);

			telefones.add(telefone);
		}

		return telefones;
	}
}