package br.com.prodevelopment.lapidarios.portlet.cadastroloja.asset;

import javax.portlet.PortletURL;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.permission.CadastroLojaPermission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class CadastroLojaAssetRendererFactory
	extends BaseAssetRendererFactory {

	public static final String TYPE = "loja";

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		Loja loja =
			LojaLocalServiceUtil.getLoja(classPK);

		CadastroLojaAssetRenderer lojaAssetRenderer =
			new CadastroLojaAssetRenderer(loja);

		lojaAssetRenderer.setAssetRendererType(type);

		return lojaAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Loja.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public PortletURL getURLAdd(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws PortalException {

		PortletURL portletURL = liferayPortletResponse.createRenderURL(
				PortletKeys.JOURNAL);

			portletURL.setParameter("struts_action", "/journal/edit_article");

			return portletURL;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		Loja loja =
			LojaLocalServiceUtil.getLoja(classPK);

		if (actionId.equals(ActionKeys.DELETE) ||
			actionId.equals(ActionKeys.UPDATE)) {

			actionId = ActionKeys.VIEW;
		}

		return CadastroLojaPermission.contains(
			permissionChecker, loja.getLojaId(), actionId);
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

	private static final boolean _LINKABLE = true;
}
