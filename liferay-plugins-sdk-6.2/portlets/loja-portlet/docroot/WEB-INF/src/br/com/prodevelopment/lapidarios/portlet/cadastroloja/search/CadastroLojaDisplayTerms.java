package br.com.prodevelopment.lapidarios.portlet.cadastroloja.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class CadastroLojaDisplayTerms extends DisplayTerms {
	public CadastroLojaDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		nomeFantasia = ParamUtil.getString(portletRequest, CadastroLojaConstants.LOJA_NOME_FANTASIA);
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	protected String nomeFantasia;
}
