<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
	
	pageContext.setAttribute("selEventoAgendaId", String.valueOf(eventoAgendaId));
	
%>
<liferay-ui:search-toggle buttonLabel="label.pesquisar"
	displayTerms="<%=displayTerms%>" id="toggle_id_search">
	<aui:field-wrapper label="label.dataEvento">
		<input type="text" name="<portlet:namespace /><%=Constantes.CAMPO_DATA_EVENTO %>" id="<portlet:namespace /><%=Constantes.CAMPO_DATA_EVENTO %>"/>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="label.nome">
		<input type="text" name="<portlet:namespace /><%=Constantes.CAMPO_EVENTO_NOME %>" id="<portlet:namespace /><%=Constantes.CAMPO_EVENTO_NOME %>"/>
	</aui:field-wrapper>
</liferay-ui:search-toggle>
<script>
jQuery(document).ready(
		function() {
			jQuery("#<portlet:namespace />dataEvento")
				.datepicker({
					showOn: 'button', 
					buttonImage: '/evento/images/calendario.png', 
					buttonImageOnly: true,
					dateFormat: 'dd/mm/yyyy',  
					dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sabado','Domingo'],  
					dayNamesMin: ['D','S','T','Q','Q','S','S','D'],  
					dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab','Dom'],  
					monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
					monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],  
					nextText: 'Próximo',
					prevText: 'Anterior',
					startDate: '01/01/1901'
				})
				.mask("99/99/9999");

});
</script>