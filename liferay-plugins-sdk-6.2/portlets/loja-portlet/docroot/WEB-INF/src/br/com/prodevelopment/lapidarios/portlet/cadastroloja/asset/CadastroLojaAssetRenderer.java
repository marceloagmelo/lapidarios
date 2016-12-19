package br.com.prodevelopment.lapidarios.portlet.cadastroloja.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.permission.CadastroLojaPermission;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class CadastroLojaAssetRenderer
	extends BaseAssetRenderer implements TrashRenderer {

	public CadastroLojaAssetRenderer(Loja loja) {
		_loja = loja;
	}

	@Override
	public String getClassName() {
		return Loja.class.getName();
	}

	@Override
	public long getClassPK() {
		return _loja.getLojaId();
	}

	@Override
	public long getGroupId() {
		return _loja.getGroupId();
	}

	@Override
	public String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

	@Override
	public String getPortletId() {
		AssetRendererFactory assetRendererFactory = getAssetRendererFactory();

		return assetRendererFactory.getPortletId();
	}

	@Override
	public String getSummary(Locale locale) {

		String summary = _loja.getNomeFantasia();

		return StringUtil.shorten(HtmlUtil.stripHtml(summary), 200);
	}

	@Override
	public String getTitle(Locale locale) {
		return _loja.getNomeFantasia();
	}

	@Override
	public String getType() {
		return CadastroLojaAssetRendererFactory.TYPE;
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			getControlPanelPlid(liferayPortletRequest), PortletKeys.CALENDAR,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/edit_calendar_booking.jsp");
		portletURL.setParameter(
			"lojaId",
			String.valueOf(_loja.getLojaId()));

		return portletURL;
	}

	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) {

		try {
			PortletURL portletURL = liferayPortletResponse.createRenderURL(
				PortletKeys.CALENDAR);

			portletURL.setParameter("mvcPath", "/view_calendar_booking.jsp");
			portletURL.setParameter(
				"lojaId",
				String.valueOf(_loja.getLojaId()));
			portletURL.setWindowState(WindowState.MAXIMIZED);

			return portletURL.toString();
		}
		catch (Exception e) {
		}

		return null;
	}

	@Override
	public long getUserId() {
		return _loja.getModifiedUserId();
	}

	@Override
	public String getUserName() {
		return "marcelo";
	}

	@Override
	public String getUuid() {
		return _loja.getUuid();
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		Loja loja = null;

		try {
			loja = _loja;
		}
		catch (Exception e) {
			_log.error(e);
		}

		return CadastroLojaPermission.contains(
			permissionChecker, loja.getLojaId(), ActionKeys.VIEW);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		Loja loja = null;

		try {
			loja = _loja;
		}
		catch (Exception e) {
			_log.error(e);
		}

		return CadastroLojaPermission.contains(
			permissionChecker, loja.getLojaId(), ActionKeys.VIEW);
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String template)
		throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute(
				CadastroLojaConstants.LOJA, _loja);

			return "/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CadastroLojaAssetRenderer.class);

	private Loja _loja;

}
