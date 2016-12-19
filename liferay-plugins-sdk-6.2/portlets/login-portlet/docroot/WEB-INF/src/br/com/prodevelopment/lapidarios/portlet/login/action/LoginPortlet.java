package br.com.prodevelopment.lapidarios.portlet.login.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prodevelopment.lapidarios.portlet.login.Constantes;
import br.com.prodevelopment.lapidarios.portlet.login.util.LoginUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LoginPortlet
 */
public class LoginPortlet extends MVCPortlet {
 
	public void executarLogin(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException, NoSuchAlgorithmException {
		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);

		String email = ParamUtil.getString(actionRequest, Constantes.EMAIL);
		String senha = ParamUtil.getString(actionRequest, Constantes.SENHA);

		try {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(
					actionRequest);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(
				actionResponse);
			LoginUtil.login(request, response, email, senha, false, null);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			
			String mainPath = themeDisplay.getPathMain();
			//PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.sendRedirect(mainPath);


		} catch (IOException e) {
			SessionErrors
					.add(actionRequest, "mensagem.funcionario.nao.autenticado");
			//_log.error(e, e);
		} catch (Exception e) {
			SessionErrors
			.add(actionRequest, "mensagem.funcionario.nao.autenticado");
			//_log.error(e, e);
		}
	}
}
