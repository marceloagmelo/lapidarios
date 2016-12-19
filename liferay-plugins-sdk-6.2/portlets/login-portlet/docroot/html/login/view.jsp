<%@ include file="init.jsp"%>

<%@ include file="mensagem.jspf"%>

<portlet:actionURL var="executarLoginURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION%>"
		value="<%=Constantes.EXECUTAR_LOGIN%>" />
</portlet:actionURL>

<portlet:renderURL var="loginRedirectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
<portlet:param name="struts_action" value="/login/login_redirect" />
</portlet:renderURL>

<%
String facebookAuthRedirectURL = FacebookConnectUtil.getRedirectURL(themeDisplay.getCompanyId());

facebookAuthRedirectURL = HttpUtil.addParameter(facebookAuthRedirectURL, "redirect", HttpUtil.encodeURL(loginRedirectURL.toString()));

String facebookAuthURL = FacebookConnectUtil.getAuthURL(themeDisplay.getCompanyId());

facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "client_id", FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "redirect_uri", facebookAuthRedirectURL);
facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "scope", "email");

String taglibOpenFacebookConnectLoginWindow = "javascript:var facebookConnectLoginWindow = window.open('" + facebookAuthURL.toString() + "', 'facebook', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); facebookConnectLoginWindow.focus();";

%>

<c:choose>
	<c:when test="<%=!themeDisplay.isSignedIn()%>">
		<section class="section-full-width parallax-fixed autoHeight"
			id="cadastro">
			<div class="full-bg-image"
				style="background-image: url('/documents/20182/27711/bg-cadastro.jpg/b9467619-a355-42aa-82e7-076ff07bc094?t=1476493269432');">&nbsp;</div>

			<div class="container">
				<div class="out-table-parallax">
					<div class="inner-parallax">
						<div class="row">
							<div class="offset1 span6 coluna-login">
								<div class="form-cadastro">
									<div class="container-logar">
										<div class="chamada">
											<p>Essa oportunidade não é para todos. Descubra se é para
												você:</p>
										</div>
										<a class="btn-fb" href="<%= taglibOpenFacebookConnectLoginWindow %>"><span><img
												alt="Icone Facebook"
												src="/login-portlet/images/fb-icon.png"
												style="width: 33px; height: 33px;" /> Entre com o seu
												Facebook</span> </a>

										<p class="faca-login">ou faça login</p>

										<aui:form action="<%=executarLoginURL%>" method="post"
											name="fm">
											<div class="control-group">
												<div class="controls">
									            	<aui:input name="<%=Constantes.EMAIL %>" label="" placeholder="Seu e-mail:" type="email">
									            		<aui:validator name="required"></aui:validator>
									            	</aui:input>
												</div>
											</div>

											<div class="control-group">
												<div class="controls">
									            	<aui:input name="<%=Constantes.SENHA %>" label="" placeholder="Senha:" type="password">
									            		<aui:validator name="required"></aui:validator>
									            	</aui:input>
												</div>
											</div>
											<label class="checkbox lembrar"><input
												type="checkbox" value="" />Lembre de mim </label>
										</aui:form>
									</div>

									<ul class="inline inline-logar">
										<li><a class="btn-geral" href="#">Cadastre-se</a></li>
										<li><a class="btn-geral" href="#">Esqueci a senha</a></li>
										<li><button class="btn-geral faca-login" onClick='<%= renderResponse.getNamespace() + "executarLogin();" %>'>Faça
												login</button></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:when>
</c:choose>
<aui:script>
	function <portlet:namespace />executarLogin() {
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>
