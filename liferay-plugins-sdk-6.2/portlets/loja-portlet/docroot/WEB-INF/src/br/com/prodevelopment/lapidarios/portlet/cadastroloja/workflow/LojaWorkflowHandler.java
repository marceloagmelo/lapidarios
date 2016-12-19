package br.com.prodevelopment.lapidarios.portlet.cadastroloja.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

public class LojaWorkflowHandler extends BaseWorkflowHandler {

	@Override
	public String getClassName() {
		return Loja.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Loja updateStatus(int status,
			Map<String, Serializable> workflowContext) throws PortalException,
			SystemException {

		long userId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		Loja loja = LojaLocalServiceUtil.getLoja(classPK);

		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return LojaLocalServiceUtil.updateStatus(userId,
				loja.getLojaId(), status, serviceContext);
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

}