package br.com.prodevelopment.lapidarios.portlet.cadastroloja.trash;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.loja.service.LojaLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.permission.CadastroLojaPermission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.security.permission.PermissionChecker;

public class CadastroLojaTrashHandler extends BaseTrashHandler {
	public void deleteTrashEntry(long classPK)
			throws PortalException, SystemException {

			LojaLocalServiceUtil.deleteLoja(classPK);
		}


		public String getClassName() {
			return Loja.class.getName();
		}


		public boolean isInTrash(long classPK)
			throws PortalException, SystemException {

			Loja loja =
				LojaLocalServiceUtil.getLoja(classPK);

			return loja.isInTrash();
		}


		public boolean isRestorable(long classPK)
			throws PortalException, SystemException {
			return true;
		}


		public void restoreTrashEntry(long userId, long classPK)
			throws PortalException, SystemException {

			LojaLocalServiceUtil.restoreLojaFromTrash(
				userId, classPK);
		}


		protected boolean hasPermission(
				PermissionChecker permissionChecker, long classPK, String actionId)
			throws PortalException, SystemException {

			Loja typeTask =
				LojaLocalServiceUtil.getLoja(classPK);
			
			/*return permissionChecker.hasPermission(
					typeTask.getGroupId(), RESOURCE_NAME, typeTask.getGroupId(), actionId);*/

			return CadastroLojaPermission.contains(
					permissionChecker, typeTask.getGroupId(),
				actionId);
		}
}