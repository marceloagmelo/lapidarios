<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/login/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String openId = ParamUtil.getString(request, "openId");
boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);
%>

<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL">
	<portlet:param name="struts_action" value="/login/create_account" />
</portlet:actionURL>

<portlet:renderURL var="loginRedirectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="struts_action" value="/login/login_redirect" />
</portlet:renderURL>

<%
String strutsAction = ParamUtil.getString(request, "struts_action");

boolean showFacebookConnectIcon = false;

if (!strutsAction.startsWith("/login/facebook_connect") && FacebookConnectUtil.isEnabled(company.getCompanyId())) {
	showFacebookConnectIcon = true;
}

boolean showForgotPasswordIcon = false;

if (!strutsAction.equals("/login/forgot_password") && (company.isSendPassword() || company.isSendPasswordResetLink())) {
	showForgotPasswordIcon = true;
}

boolean showSignInIcon = false;

if (Validator.isNotNull(strutsAction) && !strutsAction.equals("/login/login")) {
	showSignInIcon = true;
}

String facebookAuthRedirectURL = FacebookConnectUtil.getRedirectURL(themeDisplay.getCompanyId());

facebookAuthRedirectURL = HttpUtil.addParameter(facebookAuthRedirectURL, "redirect", HttpUtil.encodeURL(loginRedirectURL.toString()));

String facebookAuthURL = FacebookConnectUtil.getAuthURL(themeDisplay.getCompanyId());

facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "client_id", FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "redirect_uri", facebookAuthRedirectURL);
facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "scope", "email");

String taglibOpenFacebookConnectLoginWindow = "javascript:var facebookConnectLoginWindow = window.open('" + facebookAuthURL.toString() + "', 'facebook', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); facebookConnectLoginWindow.focus();";

String signInURL = themeDisplay.getURLSignIn();

if (portletName.equals(PortletKeys.FAST_LOGIN)) {
	PortletURL fastLoginURL = PortletURLFactoryUtil.create(request, PortletKeys.FAST_LOGIN, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

	fastLoginURL.setParameter("saveLastPath", Boolean.FALSE.toString());
	fastLoginURL.setParameter("struts_action", "/login/login");
	fastLoginURL.setPortletMode(PortletMode.VIEW);
	fastLoginURL.setWindowState(LiferayWindowState.POP_UP);

	signInURL = fastLoginURL.toString();
}
%>

<div id="sb-site">

<header id="top-internas">
	<div class="container">
		<div class="center-form">
			<h1 class="title-header">Pré Cadastro na Plataforma LAPIDÁRIOS</h1>
		</div>
	</div>
</header>

<div id="content">
	<div class="container">
		<div class="center-form">
			<div class="model-form">

				<div class="row-fluid">
					<aui:col width="<%= 50 %>">
						<c:if test="<%= showFacebookConnectIcon %>">
							<a href="<%= taglibOpenFacebookConnectLoginWindow %>" class="bt-facebook">
								<span class="icon icon-facebook"></span>
								<span>Cadastre-se com o Facebook</span>
							</a>
						</c:if>
					</aui:col>

					<aui:col width="<%= 50 %>">
						<c:if test="<%= showSignInIcon %>">
							<a href="<%= signInURL %>" class="bt-entrar">
								ENTRAR / Já TENHO CADASTRO
							</a>
						</c:if>
					</aui:col>
						
				</div>

			<aui:form action="<%= createAccountURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="openId" type="hidden" value="<%= openId %>" />
	<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
	<aui:input name="birthdayDay" type="hidden" value="1" />
	<aui:input name="birthdayYear" type="hidden" value="1970" />

	<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactFullNameException.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-open-id-already-exists" />
	<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
		%>

		<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
			<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
	<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
	<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />

	<liferay-ui:error exception="<%= UserPasswordException.class %>">

		<%
		UserPasswordException upe = (UserPasswordException)errorException;
		%>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS %>">
			<liferay-ui:message key="that-password-uses-common-words-please-enter-in-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_INVALID %>">
			<liferay-ui:message key="that-password-is-invalid-please-enter-in-a-different-password" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_LENGTH %>">

			<%
			PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());
			%>

			<%= LanguageUtil.format(pageContext, "that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters", String.valueOf(passwordPolicy.getMinLength()), false) %>
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL %>">
			<liferay-ui:message key="that-password-is-too-trivial" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH %>">
			<liferay-ui:message key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="please-enter-a-valid-screen-name" />
	<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

	<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
		<div class="alert alert-info">
			<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
		</div>
	</c:if>

				<input name="_58_formDate" type="hidden" value="1480176078334"> <input class="field" id="_58_saveLastPath" name="_58_saveLastPath" type="hidden" value="false">

				<input class="field" id="_58_cmd" name="_58_cmd" type="hidden" value="add">

				<input class="field" id="_58_redirect" name="_58_redirect" type="hidden" value="">

				<input class="field" id="_58_openId" name="_58_openId" type="hidden" value="">

				<fieldset class="fieldset ">

					<div class="row-fluid">

						<aui:col width="<%= 50 %>">

							<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" model="<%= User.class %>" name="firstName" />

						</aui:col>

						<aui:col width="<%= 50 %>">

							<aui:input model="<%= User.class %>" name="lastName">
								<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_LAST_NAME_REQUIRED, PropsValues.USERS_LAST_NAME_REQUIRED) %>">
									<aui:validator name="required" />
								</c:if>
							</aui:input>

						</aui:col>
					</div>

					<div class="row-fluid">

						<aui:col width="<%= 50 %>">

							<aui:input model="<%= User.class %>" name="screenName" />

						</aui:col>

						<aui:col width="<%= 50 %>">
						
							<aui:input model="<%= User.class %>" name="emailAddress">
								<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
									<aui:validator name="required" />
								</c:if>
							</aui:input>
							
						</aui:col>
					</div>

					<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT %>">
						<portlet:resourceURL var="captchaURL">
							<portlet:param name="struts_action" value="/login/captcha" />
						</portlet:resourceURL>
		
						<liferay-ui:captcha url="<%= captchaURL %>" />
					</c:if>

				</fieldset>

				<div class="button-holder">
					<button class="btn btn-danger btn-lg" type="submit"> Cadastrar </button>
				</div>
			</aui:form>

			<div class="obrigatorios">Todos os dados com (*) são obrigatórios</div>

			<c:if test="<%= showForgotPasswordIcon %>">
			<portlet:renderURL var="forgotPasswordURL">
				<portlet:param name="struts_action" value="/login/forgot_password" />
			</portlet:renderURL>
			
				<div class="footer-form">
					<a href="<%= forgotPasswordURL %>"><span class="icon icon-question"></span>Esqueci a senha</a>
				</div>
			</c:if>
		</div>
		</div>
	</div>		
</div>
</div>