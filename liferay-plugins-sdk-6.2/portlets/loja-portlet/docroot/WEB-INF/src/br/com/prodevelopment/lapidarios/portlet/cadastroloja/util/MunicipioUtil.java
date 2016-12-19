package br.com.prodevelopment.lapidarios.portlet.cadastroloja.util;

import java.util.List;

import br.com.prodevelopment.lapidarios.municipio.model.Municipio;
import br.com.prodevelopment.lapidarios.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.lapidarios.portlet.cadastroloja.CadastroLojaConstants;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class MunicipioUtil {

	public static List<Municipio> listarMunicipios(String uf) throws SystemException {
		return MunicipioLocalServiceUtil.search(uf);
	}

	public static JSONArray carregarMunicipios(List<Municipio> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Municipio municipio : lista) {
			JSONObject jsonMunicipio = JSONFactoryUtil.createJSONObject();
			jsonMunicipio.put(CadastroLojaConstants.CIDADE, municipio.getCidade());
			jsonMunicipio.put(CadastroLojaConstants.CODIGO, municipio.getCodigo());
			jsonArray.put(jsonMunicipio);
		}
		
		return jsonArray;
	}

	public static JSONArray carregarDadosCep(List<Municipio> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Municipio municipio : lista) {
			JSONObject jsonMunicipio = JSONFactoryUtil.createJSONObject();
			jsonMunicipio.put(CadastroLojaConstants.UF, municipio.getUf());
			jsonMunicipio.put(CadastroLojaConstants.LOGRADOURO, municipio.getLogradouro());
			jsonMunicipio.put(CadastroLojaConstants.BAIRRO, municipio.getBairro());
			jsonArray.put(jsonMunicipio);
		}
		
		return jsonArray;
	}
}