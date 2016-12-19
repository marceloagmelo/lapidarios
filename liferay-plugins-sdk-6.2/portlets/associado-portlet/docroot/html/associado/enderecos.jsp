<%@ include file="init.jsp"%>

<%
Associado associado = (Associado)request.getAttribute(Constantes.ASSOCIADO);
long associadoId = BeanParamUtil.getLong(associado, request, Constantes.ASSOCIADO_ID);
String endResUf = StringPool.BLANK;
String endComUf = StringPool.BLANK;
if (Validator.isNotNull(associadoId)) {
	associado = AssociadoUtil.getAssociado(Long.valueOf(associadoId));
	endResUf = associado.getEndResUf();
	endComUf = associado.getEndComUf();
}
%>

<portlet:resourceURL var="ufResourceURL">
	<portlet:param name="<%=Constantes.METODO %>" value="<%=Constantes.LISTAR_MUNICIPIOS %>"/>
</portlet:resourceURL>
<portlet:resourceURL var="cepResourceURL">
	<portlet:param name="<%=Constantes.METODO %>" value="<%=Constantes.DADOS_CEP %>"/>
</portlet:resourceURL>

<liferay-ui:error-marker key="errorSection" value="enderecos" />

<aui:model-context bean="<%= associado %>" model="<%= Associado.class %>" />

<aui:input name="cidadeComSelecionada" type="hidden" value="<%= Validator.isNotNull(associado) ? associado.getEndComCidade() : 0 %>" />
<aui:input name="cidadeResSelecionada" type="hidden" value="<%= Validator.isNotNull(associado) ? associado.getEndResCidade() : 0 %>" />

<div class="row-fluid">
	<aui:fieldset cssClass="span6" label="label.endereco.residencial">	
		<aui:field-wrapper helpMessage="help.cep" label="label.endereco.cep" >
			<aui:input name="<%=Constantes.CAMPO_END_RES_CEP %>" label="">
				<aui:validator name="minLength">8</aui:validator>
				<aui:validator name="maxLength">8</aui:validator>
				<aui:validator name="number"></aui:validator>
			</aui:input>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectCepResLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>

				<aui:script use="aui-io-request">
					A.one('#<portlet:namespace />selectCepResLink').on(
						'click',
						function() {
				 			A.io.request('<%=cepResourceURL%>',{
				                        dataType: 'json',
				                        method: 'GET',
				                        data: { <portlet:namespace />cep : document.<portlet:namespace />fm.<portlet:namespace />endResCep.value},
				                        on: {
				                              success: function() {
				                              		var data=this.get('responseData');
				                              		var options;
				                              		A.Array.each(data, function(obj, idx) {
				                              			document.<portlet:namespace />fm.<portlet:namespace />endResLogradouro.value = obj.logradouro;
				                              			document.<portlet:namespace />fm.<portlet:namespace />endResBairro.value = obj.bairro;
				                              			document.<portlet:namespace />fm.<portlet:namespace />endResUf.value = obj.uf;
														var uf = document.<portlet:namespace />fm.<portlet:namespace />endResUf.value;
				                              		})
				                              }
				                        }
				            });			
						}
					);
				</aui:script>
				
			</c:if>
		</aui:field-wrapper>
		<aui:input name="<%=Constantes.CAMPO_END_RES_LOGRADOURO %>" label="label.endereco.logradouro" />
		<aui:input name="<%=Constantes.CAMPO_END_RES_NUMERO %>" label="label.endereco.numero" />
		<aui:input name="<%=Constantes.CAMPO_END_RES_COMPLEMENTO %>" label="label.endereco.complemento" />
		<aui:input name="<%=Constantes.CAMPO_END_RES_BAIRRO %>" label="label.endereco.bairro" />
		<aui:select label="label.endereco.uf" name="<%=Constantes.CAMPO_END_RES_UF %>">
			<aui:option label=""
				selected='<%=Validator.isNull(endResUf)%>' value="" />
			<aui:option label="AC" selected='<%="AC".equals(endResUf)%>'
				value="AC" />
			<aui:option label="AL" selected='<%="AL".equals(endResUf)%>'
				value="AL" />
			<aui:option label="AM" selected='<%="AM".equals(endResUf)%>'
				value="AM" />
			<aui:option label="AP" selected='<%="AP".equals(endResUf)%>'
				value="AP" />
			<aui:option label="BA" selected='<%="BA".equals(endResUf)%>'
				value="BA" />
			<aui:option label="CE" selected='<%="CE".equals(endResUf)%>'
				value="CE" />
			<aui:option label="DF" selected='<%="DF".equals(endResUf)%>'
				value="DF" />
			<aui:option label="ES" selected='<%="ES".equals(endResUf)%>'
				value="ES" />
			<aui:option label="GO" selected='<%="GO".equals(endResUf)%>'
				value="GO" />
			<aui:option label="MA" selected='<%="MA".equals(endResUf)%>'
				value="MA" />
			<aui:option label="MG" selected='<%="MG".equals(endResUf)%>'
				value="MG" />
			<aui:option label="MS" selected='<%="MS".equals(endResUf)%>'
				value="MS" />
			<aui:option label="MT" selected='<%="MT".equals(endResUf)%>'
				value="MT" />
			<aui:option label="PA" selected='<%="PA".equals(endResUf)%>'
				value="PA" />
			<aui:option label="PB" selected='<%="PB".equals(endResUf)%>'
				value="PB" />
			<aui:option label="PE" selected='<%="PE".equals(endResUf)%>'
				value="PE" />
			<aui:option label="PR" selected='<%="PR".equals(endResUf)%>'
				value="PR" />
			<aui:option label="PJ" selected='<%="PJ".equals(endResUf)%>'
				value="PJ" />
			<aui:option label="RJ" selected='<%="RJ".equals(endResUf)%>'
				value="RJ" />
			<aui:option label="RN" selected='<%="RN".equals(endResUf)%>'
				value="RN" />
			<aui:option label="RO" selected='<%="RO".equals(endResUf)%>'
				value="RO" />
			<aui:option label="RS" selected='<%="RS".equals(endResUf)%>'
				value="RS" />
			<aui:option label="RR" selected='<%="RR".equals(endResUf)%>'
				value="RR" />
			<aui:option label="SC" selected='<%="SC".equals(endResUf)%>'
				value="SC" />
			<aui:option label="SE" selected='<%="SE".equals(endResUf)%>'
				value="SE" />
			<aui:option label="SP" selected='<%="SP".equals(endResUf)%>'
				value="SP" />
			<aui:option label="TO" selected='<%="TO".equals(endResUf)%>'
				value="TO" />
		</aui:select>
		<aui:input name="<%=Constantes.CAMPO_END_RES_CIDADE %>" label="label.endereco.cidade" />
		<aui:input name="<%=Constantes.CAMPO_END_RES_PAIS %>" label="label.endereco.pais" />
	</aui:fieldset>
	<aui:fieldset cssClass="span5" label="label.endereco.comercial">
		<aui:field-wrapper helpMessage="help.cep" label="label.endereco.cep" >
			<aui:input name="<%=Constantes.CAMPO_END_COM_CEP %>" label="">
				<aui:validator name="minLength">8</aui:validator>
				<aui:validator name="maxLength">8</aui:validator>
				<aui:validator name="number"></aui:validator>
			</aui:input>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectCepComLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>

				<aui:script use="aui-io-request">
					A.one('#<portlet:namespace />selectCepComLink').on(
						'click',
						function() {
				 			A.io.request('<%=cepResourceURL%>',{
				                        dataType: 'json',
				                        method: 'GET',
				                        data: { <portlet:namespace />cep : document.<portlet:namespace />fm.<portlet:namespace />endComCep.value},
				                        on: {
				                              success: function() {
				                              		var data=this.get('responseData');
				                              		var options;
				                              		A.Array.each(data, function(obj, idx) {
				                              			document.<portlet:namespace />fm.<portlet:namespace />endComLogradouro.value = obj.logradouro;
				                              			document.<portlet:namespace />fm.<portlet:namespace />endComBairro.value = obj.bairro;
				                              			document.<portlet:namespace />fm.<portlet:namespace />endComUf.value = obj.uf;
														var uf = document.<portlet:namespace />fm.<portlet:namespace />endComUf.value;
				                              		})
				                              }
				                        }
				            });			
						}
					);
				</aui:script>
			</c:if>		
		</aui:field-wrapper>
		<aui:input name="<%=Constantes.CAMPO_END_COM_LOGRADOURO %>" label="label.endereco.logradouro" />
		<aui:input name="<%=Constantes.CAMPO_END_COM_NUMERO %>" label="label.endereco.numero" />
		<aui:input name="<%=Constantes.CAMPO_END_COM_COMPLEMENTO %>" label="label.endereco.complemento" />
		<aui:input name="<%=Constantes.CAMPO_END_COM_BAIRRO %>" label="label.endereco.bairro" />
		<aui:select label="label.endereco.uf" name="<%=Constantes.CAMPO_END_COM_UF %>">
			<aui:option label=""
				selected='<%=Validator.isNull(endComUf)%>' value="" />
			<aui:option label="AC" selected='<%="AC".equals(endComUf)%>'
				value="AC" />
			<aui:option label="AL" selected='<%="AL".equals(endComUf)%>'
				value="AL" />
			<aui:option label="AM" selected='<%="AM".equals(endComUf)%>'
				value="AM" />
			<aui:option label="AP" selected='<%="AP".equals(endComUf)%>'
				value="AP" />
			<aui:option label="BA" selected='<%="BA".equals(endComUf)%>'
				value="BA" />
			<aui:option label="CE" selected='<%="CE".equals(endComUf)%>'
				value="CE" />
			<aui:option label="DF" selected='<%="DF".equals(endComUf)%>'
				value="DF" />
			<aui:option label="ES" selected='<%="ES".equals(endComUf)%>'
				value="ES" />
			<aui:option label="GO" selected='<%="GO".equals(endComUf)%>'
				value="GO" />
			<aui:option label="MA" selected='<%="MA".equals(endComUf)%>'
				value="MA" />
			<aui:option label="MG" selected='<%="MG".equals(endComUf)%>'
				value="MG" />
			<aui:option label="MS" selected='<%="MS".equals(endComUf)%>'
				value="MS" />
			<aui:option label="MT" selected='<%="MT".equals(endComUf)%>'
				value="MT" />
			<aui:option label="PA" selected='<%="PA".equals(endComUf)%>'
				value="PA" />
			<aui:option label="PB" selected='<%="PB".equals(endComUf)%>'
				value="PB" />
			<aui:option label="PE" selected='<%="PE".equals(endComUf)%>'
				value="PE" />
			<aui:option label="PR" selected='<%="PR".equals(endComUf)%>'
				value="PR" />
			<aui:option label="PJ" selected='<%="PJ".equals(endComUf)%>'
				value="PJ" />
			<aui:option label="RJ" selected='<%="RJ".equals(endComUf)%>'
				value="RJ" />
			<aui:option label="RN" selected='<%="RN".equals(endComUf)%>'
				value="RN" />
			<aui:option label="RO" selected='<%="RO".equals(endComUf)%>'
				value="RO" />
			<aui:option label="RS" selected='<%="RS".equals(endComUf)%>'
				value="RS" />
			<aui:option label="RR" selected='<%="RR".equals(endComUf)%>'
				value="RR" />
			<aui:option label="SC" selected='<%="SC".equals(endComUf)%>'
				value="SC" />
			<aui:option label="SE" selected='<%="SE".equals(endComUf)%>'
				value="SE" />
			<aui:option label="SP" selected='<%="SP".equals(endComUf)%>'
				value="SP" />
			<aui:option label="TO" selected='<%="TO".equals(endComUf)%>'
				value="TO" />
		</aui:select>
		<aui:input name="<%=Constantes.CAMPO_END_COM_CIDADE %>" label="label.endereco.cidade" />
		<aui:input name="<%=Constantes.CAMPO_END_COM_PAIS %>" label="label.endereco.pais" />
	</aui:fieldset>
</div>

<aui:script use="aui-base">
	var verSeDesabilitaCamposEnderecos = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_CEP %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_LOGRADOURO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_NUMERO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_COMPLEMENTO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_BAIRRO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_UF %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_CIDADE %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_RES_PAIS %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_CEP %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_LOGRADOURO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_NUMERO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_COMPLEMENTO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_BAIRRO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_UF %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_CIDADE %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_END_COM_PAIS %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposEnderecos(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>

<aui:script use="aui-io-request">
	var ufRes = document.<portlet:namespace />fm.<portlet:namespace />endResUf.value;
	var ufCom = document.<portlet:namespace />fm.<portlet:namespace />endComUf.value;
</aui:script>