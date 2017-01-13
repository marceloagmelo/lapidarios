package br.com.prodevelopment.portlet.share.util;

import br.com.prodevelopment.associado.model.Associado;
import br.com.prodevelopment.associado.service.AssociadoLocalServiceUtil;

import com.liferay.portal.kernel.util.Validator;

public class AssociadoUtil {
	public static Associado getAssosiadoPorUsuario(long userId) throws Exception {

		Associado retorno = null;
		
		Associado associado = AssociadoLocalServiceUtil.fetchByUSUARIO(userId);
		
		if (Validator.isNotNull(associado)) {
			retorno = associado;
		}

		return retorno;
	}

}
