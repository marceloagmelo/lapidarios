<%@ include file="/html/portlet/login/init.jsp" %>

<portlet:renderURL var="loginRedirectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
<portlet:param name="struts_action" value="/login/login_redirect" />
</portlet:renderURL>

<%
String strutsAction = ParamUtil.getString(request, "struts_action");

boolean showFacebookConnectIcon = false;

if (!strutsAction.startsWith("/login/facebook_connect") && FacebookConnectUtil.isEnabled(company.getCompanyId())) {
	showFacebookConnectIcon = true;
}

boolean showCreateAccountIcon = false;

if (!strutsAction.equals("/login/create_account") && company.isStrangers() && !portletName.equals(PortletKeys.FAST_LOGIN)) {
	showCreateAccountIcon = true;
}

boolean showForgotPasswordIcon = false;

if (!strutsAction.equals("/login/forgot_password") && (company.isSendPassword() || company.isSendPasswordResetLink())) {
	showForgotPasswordIcon = true;
}
%>

<c:choose>
	<c:when test="<%=!themeDisplay.isSignedIn()%>">
		<%
		String redirect = ParamUtil.getString(request, "redirect");

		String login = LoginUtil.getLogin(request, "login", company);
		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>

		<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
			<portlet:param name="struts_action" value="/login/login" />
		</portlet:actionURL>
	
		<section class="section-full-width parallax-fixed autoHeight"
			id="cadastro">
			<div class="full-bg-image"
				style="background-image: url('/documents/20182/27711/bg-cadastro.jpg/b9467619-a355-42aa-82e7-076ff07bc094?t=1476493269432');">&nbsp;</div>

			<div class="container">

				<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-login-because-the-maximum-number-of-users-has-been-reached" />
				<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
				<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
				<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserLockoutException.class %>" message="this-account-has-been-locked" />
				<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="authentication-failed" />
			
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
										<c:if test="<%= showFacebookConnectIcon %>">										
<%
String facebookAuthRedirectURL = FacebookConnectUtil.getRedirectURL(themeDisplay.getCompanyId());

facebookAuthRedirectURL = HttpUtil.addParameter(facebookAuthRedirectURL, "redirect", HttpUtil.encodeURL(loginRedirectURL.toString()));

String facebookAuthURL = FacebookConnectUtil.getAuthURL(themeDisplay.getCompanyId());

facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "client_id", FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "redirect_uri", facebookAuthRedirectURL);
facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "scope", "email");

String taglibOpenFacebookConnectLoginWindow = "javascript:var facebookConnectLoginWindow = window.open('" + facebookAuthURL.toString() + "', 'facebook', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); facebookConnectLoginWindow.focus();";
%>
										<a class="btn-fb" href="<%= taglibOpenFacebookConnectLoginWindow %>"><span><img
												alt="Icone Facebook"
												src="/documents/20182/27711/fb-icon.png/34bf684c-5b34-4b19-b641-51d572146074?t=1476493196208"
												style="width: 33px; height: 33px;" /> Entre com o seu
												Facebook</span> </a>
										</c:if>
										<p class="faca-login">ou faça login</p>
										<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' method="post" name="fm" onSubmit="event.preventDefault();">
										<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
										<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
										<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />
				<%
				String loginLabel = null;

				if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
					loginLabel = "Seu e-mail:";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					loginLabel = "Login:";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
					loginLabel = "ID:";
				}
				%>
											<div class="control-group">
												<div class="controls">
													<aui:input label="" placeholder="<%=loginLabel %>" name="login" value="<%= login %>" type="email">
														<aui:validator name="required" />
													</aui:input>
												</div>
											</div>

											<div class="control-group">
												<div class="controls">
													<aui:input name="password" type="password" label="" placeholder="Senha:" value="<%= password %>">
														<aui:validator name="required" />
													</aui:input>
												</div>
											</div>
											<c:if test="<%= company.isAutoLogin() && !PropsValues.SESSION_DISABLED %>">
												<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" />
											</c:if>
										</aui:form>
									</div>

									<ul class="inline inline-logar">
										<c:if test="<%= showCreateAccountIcon %>">
											<li><a class="btn-geral" href="<%= PortalUtil.getCreateAccountURL(request, themeDisplay) %>">Cadastre-se</a></li>
										</c:if>
										<c:if test="<%= showForgotPasswordIcon %>">
											<portlet:renderURL var="forgotPasswordURL">
												<portlet:param name="struts_action" value="/login/forgot_password" />
											</portlet:renderURL>
										
										   <li><a class="btn-geral" href="<%= forgotPasswordURL %>">Esqueci a senha</a></li>
										</c:if>
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