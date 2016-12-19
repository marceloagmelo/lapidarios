package br.com.prodevelopment.portlet.slide.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.portlet.slide.Constantes;
import br.com.prodevelopment.portlet.slide.util.Helper;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SlidePortlet
 */
public class SlidePortlet extends MVCPortlet {
 
	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
	
		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);
		super.init();
	}
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(renderRequest));
	
			String articleId = httpReq.getParameter(Constantes.NOME_PARAM_ARTICLE_ID);

			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(Constantes.PREF_CONFIGURADO, Constantes.N);

			if (Constantes.S.equals(prefConfigurado)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);
				
				String portletTitulo = ParamUtil.getString(renderRequest,
						Constantes.NOME_PARAM_TITULO_PORTLET);
				
				if (Validator.isNull(portletTitulo)) {
					portletTitulo = Helper.getTituloPortlet(renderRequest,
							renderResponse, themeDisplay);
				}
				renderRequest.setAttribute(
						Constantes.NOME_PARAM_TITULO_PORTLET, portletTitulo);
				renderRequest.setAttribute(
						Constantes.NOME_PARAM_ARTICLE_ID, articleId);

				super.render(renderRequest, renderResponse);
			} else {
				SessionMessages.add(renderRequest,
						"mensagem.portletNaoConfigurado");
				include(naoConfiguradoJSP, renderRequest, renderResponse);

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
