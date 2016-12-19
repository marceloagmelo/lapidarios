<%@ include file="init.jsp"%>

<%
Local local = (Local)request.getAttribute(Constantes.LOCAL);
long localId = BeanParamUtil.getLong(local, request, Constantes.LOCAL_ID);
String endUf = StringPool.BLANK;
if (Validator.isNotNull(localId)) {
	local = LocalUtil.getLocal(Long.valueOf(localId));
	endUf = local.getEndUf();
}
%>

<portlet:resourceURL var="ufResourceURL">
	<portlet:param name="<%=Constantes.METODO %>" value="<%=Constantes.LISTAR_MUNICIPIOS %>"/>
</portlet:resourceURL>
<portlet:resourceURL var="cepResourceURL">
	<portlet:param name="<%=Constantes.METODO %>" value="<%=Constantes.DADOS_CEP %>"/>
</portlet:resourceURL>

<liferay-ui:error-marker key="errorSection" value="enderecos" />

<aui:model-context bean="<%= local %>" model="<%= Local.class %>" />

<div class="row-fluid">
	<aui:fieldset cssClass="span6" label="label.endereco">	
		<aui:field-wrapper helpMessage="help.cep" label="label.endereco.cep" >
			<aui:input name="<%=Constantes.CAMPO_END_CEP %>" label="">
				<aui:validator name="minLength">8</aui:validator>
				<aui:validator name="maxLength">8</aui:validator>
				<aui:validator name="number"></aui:validator>
			</aui:input>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectCepLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>

				<aui:script use="aui-io-request">
					A.one('#<portlet:namespace />selectCepLink').on(
						'click',
						function() {
				 			A.io.request('<%=cepResourceURL%>',{
				                        dataType: 'json',
				                        method: 'GET',
				                        data: { <portlet:namespace />cep : document.<portlet:namespace />fm.<portlet:namespace />endCep.value},
				                        on: {
				                              success: function() {
				                              		var data=this.get('responseData');
				                              		var options;
				                              		A.Array.each(data, function(obj, idx) {
				                              			document.<portlet:namespace />fm.<portlet:namespace />endLogradouro.value = obj.logradouro;
				                              			document.<portlet:namespace />fm.<portlet:namespace />endBairro.value = obj.bairro;
				                              			document.<portlet:namespace />fm.<portlet:namespace />endUf.value = obj.uf;
				                              		})
				                              }
				                        }
				            });			
						}
					);
				</aui:script>
				
			</c:if>
		</aui:field-wrapper>
		<aui:input name="<%=Constantes.CAMPO_END_LOGRADOURO %>" label="label.endereco.logradouro" />
		<aui:input name="<%=Constantes.CAMPO_END_NUMERO %>" label="label.endereco.numero" />
		<aui:input name="<%=Constantes.CAMPO_END_COMPLEMENTO %>" label="label.endereco.complemento" />
		<aui:input name="<%=Constantes.CAMPO_END_BAIRRO %>" label="label.endereco.bairro" />
		<aui:select label="label.endereco.uf" name="<%=Constantes.CAMPO_END_UF %>">
			<aui:option label=""
				selected='<%=Validator.isNull(endUf)%>' value="" />
			<aui:option label="AC" selected='<%="AC".equals(endUf)%>'
				value="AC" />
			<aui:option label="AL" selected='<%="AL".equals(endUf)%>'
				value="AL" />
			<aui:option label="AM" selected='<%="AM".equals(endUf)%>'
				value="AM" />
			<aui:option label="AP" selected='<%="AP".equals(endUf)%>'
				value="AP" />
			<aui:option label="BA" selected='<%="BA".equals(endUf)%>'
				value="BA" />
			<aui:option label="CE" selected='<%="CE".equals(endUf)%>'
				value="CE" />
			<aui:option label="DF" selected='<%="DF".equals(endUf)%>'
				value="DF" />
			<aui:option label="ES" selected='<%="ES".equals(endUf)%>'
				value="ES" />
			<aui:option label="GO" selected='<%="GO".equals(endUf)%>'
				value="GO" />
			<aui:option label="MA" selected='<%="MA".equals(endUf)%>'
				value="MA" />
			<aui:option label="MG" selected='<%="MG".equals(endUf)%>'
				value="MG" />
			<aui:option label="MT" selected='<%="MT".equals(endUf)%>'
				value="MT" />
			<aui:option label="MS" selected='<%="MS".equals(endUf)%>'
				value="MS" />
			<aui:option label="PA" selected='<%="PA".equals(endUf)%>'
				value="PA" />
			<aui:option label="PB" selected='<%="PB".equals(endUf)%>'
				value="PB" />
			<aui:option label="PE" selected='<%="PE".equals(endUf)%>'
				value="PE" />
			<aui:option label="PR" selected='<%="PR".equals(endUf)%>'
				value="PR" />
			<aui:option label="PJ" selected='<%="PJ".equals(endUf)%>'
				value="PJ" />
			<aui:option label="RJ" selected='<%="RJ".equals(endUf)%>'
				value="RJ" />
			<aui:option label="RN" selected='<%="RN".equals(endUf)%>'
				value="RN" />
			<aui:option label="RO" selected='<%="RO".equals(endUf)%>'
				value="RO" />
			<aui:option label="RS" selected='<%="RS".equals(endUf)%>'
				value="RS" />
			<aui:option label="RR" selected='<%="RR".equals(endUf)%>'
				value="RR" />
			<aui:option label="SC" selected='<%="SC".equals(endUf)%>'
				value="SC" />
			<aui:option label="SE" selected='<%="SE".equals(endUf)%>'
				value="SE" />
			<aui:option label="SP" selected='<%="SP".equals(endUf)%>'
				value="SP" />
			<aui:option label="TO" selected='<%="TO".equals(endUf)%>'
				value="TO" />
		</aui:select>
		<aui:input name="<%=Constantes.CAMPO_END_CIDADE %>" label="label.endereco.cidade" />
		<aui:input name="<%=Constantes.CAMPO_END_PAIS %>" label="label.endereco.pais" />
	</aui:fieldset>
</div>

<aui:script use="aui-base">
	var verSeDesabilitaCamposEnderecos = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_CEP %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_LOGRADOURO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_NUMERO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COMPLEMENTO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_BAIRRO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_UF %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_CIDADE %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_PAIS %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposEnderecos(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>
