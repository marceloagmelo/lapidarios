package br.com.prodevelopment.lapidarios.portlet.agendaevento.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

public class AgendaEventoWorkflowHandler extends BaseWorkflowHandler {
	@Override
	public String getClassName() {
		return EventoAgenda.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public EventoAgenda updateStatus(int status,
			Map<String, Serializable> workflowContext) throws PortalException,
			SystemException {

		long userId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		EventoAgenda loja = EventoAgendaLocalServiceUtil.getEventoAgenda(classPK);

		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return EventoAgendaLocalServiceUtil.updateStatus(userId,
				loja.getEventoAgendaId(), status, serviceContext);
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

}
