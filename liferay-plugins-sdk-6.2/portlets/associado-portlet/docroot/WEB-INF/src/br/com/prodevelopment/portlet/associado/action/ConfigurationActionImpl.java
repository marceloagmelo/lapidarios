package br.com.prodevelopment.portlet.associado.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.portlet.associado.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
        
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		
		boolean prefClienteSomenteEsseSite = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_ASSOCIADO_SOMENTE_ESSE_SITE, null));
		
		renderRequest.setAttribute(Constantes.PREF_ASSOCIADO_SOMENTE_ESSE_SITE, prefClienteSomenteEsseSite);
	        
	    PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);
		String configTemplate = selPortletConfig.getInitParameter(
			CONFIG_TEMPLATE);
		return configTemplate;
	}
	
	
    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, 
    		ActionResponse actionResponse) throws Exception {
    	
    	PortletPreferences prefs = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");

		String prefClienteSomenteEsseSite = ParamUtil.getString(actionRequest,
				Constantes.PREF_ASSOCIADO_SOMENTE_ESSE_SITE);

    	prefs.setValue(Constantes.PREF_ASSOCIADO_SOMENTE_ESSE_SITE, prefClienteSomenteEsseSite);
    	
		if (SessionErrors.isEmpty(actionRequest)) {
			try {
				prefs.store();
		        SessionMessages.add(actionRequest, Constantes.PORTLET_CONFIGURADO_SUCESSO);
			}
			catch (ValidatorException ve) {
				SessionErrors.add(
					actionRequest, ValidatorException.class.getName(), ve);

				return;
			}

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletResource);

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
    }
    
    public static final String CONFIG_TEMPLATE = "config-template";
}
