package br.com.prodevelopment.lapidarios.portlet.cadastroclube.util;

import br.com.prodevelopment.lapidarios.lojaindicada.model.LojaIndicada;
import br.com.prodevelopment.lapidarios.lojaindicada.service.LojaIndicadaLocalServiceUtil;

import com.liferay.portal.kernel.util.Validator;

public class LojaIndicadaUtil {
	public static LojaIndicada getLojaIndicada(long companyId, long groupId) throws Exception {

		LojaIndicada retorno = null;
		
		LojaIndicada lojaIndicada = LojaIndicadaLocalServiceUtil.findLojaIndicadaAtual(companyId, groupId);
		
		if (Validator.isNotNull(lojaIndicada)) {
			retorno = lojaIndicada;
		}

		return retorno;
	}
}
