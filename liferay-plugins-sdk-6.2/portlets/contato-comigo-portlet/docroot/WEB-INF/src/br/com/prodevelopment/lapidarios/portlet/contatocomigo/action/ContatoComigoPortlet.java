package br.com.prodevelopment.lapidarios.portlet.contatocomigo.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import br.com.prodevelopment.lapidarios.portlet.contatocomigo.Constantes;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * Portlet implementation class ContatoComigoPortlet
 */
public class ContatoComigoPortlet extends MVCPortlet {

	public void enviar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar dados dos usuários
		User user = themeDisplay.getUser();
		String nome = user.getFullName();
		String email = user.getEmailAddress();

		// Recuperar campos do request
		String uf = ParamUtil.getString(actionRequest, Constantes.CAMPO_UF);
		String cidade = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_CIDADE);
		String celular = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_CELULAR);

		// Enviar email
		enviarEmail(nome, email, uf, cidade, celular);

	}

	private void enviarEmail(String nome, String email, String uf,
			String cidade, String celular) throws Exception {
		StringBuilder corpoEmail = new StringBuilder();

		// Cabecalho
		String velocityTemplateIdCorpo = "/email_contato.vm";
		String corpoEmailTexto = leituraArquivo(velocityTemplateIdCorpo);

		corpoEmailTexto = corpoEmailTexto.replace("$nome", nome);
		corpoEmailTexto = corpoEmailTexto.replace("$email", email);
		corpoEmailTexto = corpoEmailTexto.replace("$uf", uf);
		corpoEmailTexto = corpoEmailTexto.replace("$cidade", cidade);
		corpoEmailTexto = corpoEmailTexto.replace("$celular", celular);

		corpoEmail.append(corpoEmailTexto);

		InternetAddress remetente = new InternetAddress(
				email, "Portal");
		String personalRemetente = remetente.getPersonal();
		remetente.setPersonal(personalRemetente, "UTF-8");
		List<MailMessage> mensagens = new ArrayList<MailMessage>();
		
		String emailsDestinarario = PortletProps.get("emails.destinarario");
		
		String[] emails = null;
		
		if (emailsDestinarario.contains("#")) {
			emails = emailsDestinarario.split("#");
		} else {
			emails = new String[] { emailsDestinarario };
		}
		
		for (String emailDest : emails) {
			InternetAddress destinatario = new InternetAddress(emailDest, "");
			String personalDestinatario = destinatario.getPersonal();
			destinatario.setPersonal(personalDestinatario, "UTF-8");
			MailMessage mensagem = new MailMessage(remetente, destinatario,
					"Contato Comigo", corpoEmail.toString(), true);
			mensagens.add(mensagem);
		}

		// Envio dos emails
		for (MailMessage mailMessage : mensagens) {
			MailServiceUtil.sendEmail(mailMessage);
		}
	}

	private String leituraArquivo(String file) throws IOException {
		URL url = getClass().getClassLoader().getResource(file);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		StringBuffer buffer = new StringBuffer();

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine + "\n");
		in.close();
		return buffer.toString();
	}

}