package br.com.prodevelopment.lapidarios.portlet.agendaevento.trash;

import br.com.prodevelopment.lapidarios.evento.model.EventoAgenda;
import br.com.prodevelopment.lapidarios.evento.service.EventoAgendaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.agendaevento.permission.AgendaEventoPermission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.security.permission.PermissionChecker;

public class AgendaEventoTrashHandler extends BaseTrashHandler {
	public void deleteTrashEntry(long classPK)
			throws PortalException, SystemException {

			EventoAgendaLocalServiceUtil.deleteEventoAgenda(classPK);
		}


		public String getClassName() {
			return EventoAgenda.class.getName();
		}


		public boolean isInTrash(long classPK)
			throws PortalException, SystemException {

			EventoAgenda typeTask =
				EventoAgendaLocalServiceUtil.getEventoAgenda(classPK);

			return typeTask.isInTrash();
		}


		public boolean isRestorable(long classPK)
			throws PortalException, SystemException {
			return true;
		}


		public void restoreTrashEntry(long userId, long classPK)
			throws PortalException, SystemException {

			EventoAgendaLocalServiceUtil.restoreEventoAgendaFromTrash(
				userId, classPK);
		}


		protected boolean hasPermission(
				PermissionChecker permissionChecker, long classPK, String actionId)
			throws PortalException, SystemException {

			EventoAgenda typeTask =
				EventoAgendaLocalServiceUtil.getEventoAgenda(classPK);
			
			/*return permissionChecker.hasPermission(
					typeTask.getGroupId(), RESOURCE_NAME, typeTask.getGroupId(), actionId);*/

			return AgendaEventoPermission.contains(
					permissionChecker, typeTask.getGroupId(),
				actionId);
		}
}
