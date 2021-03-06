package br.com.prodevelopment.lapidarios.portlet.cadastroloja.social;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityConstants;

public class CadastroLojaActivityInterpreter extends BaseSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected String getEntryTitle(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		return activity.getExtraDataValue("description", serviceContext.getLocale());
	}

	@Override
	protected String getPath(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		long plid = PortalUtil.getPlidFromPortletId(activity.getGroupId(),
				CadastroLojaConstants.PORTLET_NAME);

		PortletURL portletURL = PortletURLFactoryUtil.create(
				serviceContext.getRequest(), CadastroLojaConstants.PORTLET_NAME, plid,
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("jspPage", "/html/cadastroloja/cadastro.jsp");
		portletURL.setParameter("keywords",
				getEntryTitle(activity, serviceContext));
		portletURL.setParameter(CadastroLojaConstants.LOJA_ID, String.valueOf(activity.getClassPK()));
		portletURL.setParameter(CadastroLojaConstants.ACTION, ActionKeys.VIEW);
		portletURL.setParameter("backURL", serviceContext.getCurrentURL());

		return portletURL.toString();
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity) {

		int activityType = activity.getType();

		if (activityType == CadastroLojaActivityKeys.ADD_LOJA) {
			if (Validator.isNull(groupName)) {
				return "activity.loja.add";
			} else {
				return "activity.loja.add.em";
			}
		} else if (activityType == CadastroLojaActivityKeys.UPDATE_LOJA) {
			if (Validator.isNull(groupName)) {
				return "activity.loja.update";
			} else {
				return "activity.loja.update.em";
			}
		} else if (activityType == SocialActivityConstants.TYPE_MOVE_TO_TRASH) {
			if (Validator.isNull(groupName)) {
				return "activity.loja.move.to.trash";
			} else {
				return "activity.loja.move.to.trash.in";
			}
		} else if (activityType == SocialActivityConstants.TYPE_RESTORE_FROM_TRASH) {
			if (Validator.isNull(groupName)) {
				return "activity.loja.restore.to.trash";
			} else {
				return "activity.loja.restore.to.trash.in";
			}
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(PermissionChecker permissionChecker,
			SocialActivity activity, String actionId,
			ServiceContext serviceContext) throws Exception {

		boolean permissaoView = permissionChecker.hasPermission(
				activity.getGroupId(), Loja.class.getName(),
				activity.getClassPK(), actionId);

		if (!permissaoView) {

			return false;
		}

		return true;
	}

	@Override
	protected String getUserName(long userId, ServiceContext serviceContext) {
		try {
			if (userId <= 0) {
				return StringPool.BLANK;
			}

			User user = UserLocalServiceUtil.getUserById(userId);

			if (user.getUserId() == serviceContext.getUserId()) {
				return HtmlUtil.escape(user.getFirstName());
			}

			String userName = user.getFullName();

			Group group = user.getGroup();

			if (group.getGroupId() == serviceContext.getScopeGroupId()) {
				return HtmlUtil.escape(userName);
			}

			String userDisplayURL = user.getDisplayURL(serviceContext
					.getThemeDisplay());

			if (Validator.isNotNull(userDisplayURL)) {
				userName = "<a class=\"user\" href=\"" + userDisplayURL + "\">"
						+ HtmlUtil.escape(userName) + "</a>";
			} else {
				userName = HtmlUtil.escape(userName);
			}

			return userName;
		} catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	private static final String[] _CLASS_NAMES = { Loja.class.getName() };
}
