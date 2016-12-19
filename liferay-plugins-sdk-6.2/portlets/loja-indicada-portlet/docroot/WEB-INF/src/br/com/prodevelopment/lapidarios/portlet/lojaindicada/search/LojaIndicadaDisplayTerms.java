package br.com.prodevelopment.lapidarios.portlet.lojaindicada.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.lapidarios.portlet.lojaindicada.LojaIndicadaConstants;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LojaIndicadaDisplayTerms extends DisplayTerms {
	public LojaIndicadaDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		idLoja = ParamUtil.getString(portletRequest, LojaIndicadaConstants.CAMPO_ID_LOJA);
	}


	public String getIdLoja() {
		return idLoja;
	}


	public void setIdLoja(String idLoja) {
		this.idLoja = idLoja;
	}


	protected String idLoja;	
}
