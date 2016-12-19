package br.com.prodevelopment.lapidarios.portlet.cadastroevento.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.lapidarios.portlet.cadastroevento.Constantes;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class EventoDisplayTerms extends DisplayTerms {

	public EventoDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		nome = ParamUtil.getString(portletRequest, Constantes.CAMPO_NOME);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	protected String nome;

}