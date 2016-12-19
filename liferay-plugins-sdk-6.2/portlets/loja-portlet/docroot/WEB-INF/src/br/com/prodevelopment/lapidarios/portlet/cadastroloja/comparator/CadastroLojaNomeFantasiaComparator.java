package br.com.prodevelopment.lapidarios.portlet.cadastroloja.comparator;

import br.com.prodevelopment.lapidarios.loja.model.Loja;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CadastroLojaNomeFantasiaComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Loja.nomeReduzido ASC";

	public static final String ORDER_BY_DESC =
		"Loja.nomeReduzido DESC";

	public static final String[] ORDER_BY_FIELDS = {CadastroLojaConstants.LOJA_NOME_FANTASIA};

	public CadastroLojaNomeFantasiaComparator() {
		this(false);
	}

	public CadastroLojaNomeFantasiaComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Loja loja1 = (Loja)obj1;
		Loja loja2 = (Loja)obj2;

		String nomeFantasia1 = loja1.getNomeFantasia();
		String nomeFantasia2 = loja2.getNomeFantasia();

		int value = nomeFantasia1.compareTo(nomeFantasia2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}
