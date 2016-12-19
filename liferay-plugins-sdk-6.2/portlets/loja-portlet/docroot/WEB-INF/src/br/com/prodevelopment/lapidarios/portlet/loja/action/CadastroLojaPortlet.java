package br.com.prodevelopment.lapidarios.portlet.loja.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CadastroLojaPortlet
 */
public class CadastroLojaPortlet extends MVCPortlet {
 
	private static Logger _log = Logger.getLogger(CadastroLojaPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("LOG com debug");
			}
			_log.info("LOG com info");

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e, e);
		}
	}
	
}
