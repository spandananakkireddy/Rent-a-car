/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author SPANDANA
 */
public class MailUtilGmail {
	public static void sendMail(String host, String port,final String userName,final String password,
			String to, String from, String subject, String body, boolean bodyIsHTML)
					throws MessagingException {

		// 1 - get a mail session
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", host);
		props.put("mail.smtps.port", port);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.quitwait", "false");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);


		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		// 2 - create a message
		Message message = new MimeMessage(session);
		message.setSubject(subject);
		if (bodyIsHTML) {
			message.setContent(body, "text/html");
		} else {
			message.setText(body);
		}

		// 3 - address the message
		Address fromAddress = new InternetAddress(from);
		Address toAddress = new InternetAddress(to);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);

		// 4 - send the message
		Transport transport = session.getTransport();
		transport.connect("spandana.s0607@gmail.com", "spandana674");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

	}

}
