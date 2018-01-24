package com.thesandmans.javail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Javail {

	private String body;
	private String from;
	private String host;
	private String subject;
	private String to;

	public String getBody() {
		return body;
	}

	public String getFrom() {
		return from;
	}

	public String getHost() {
		return host;
	}

	public String getSubject() {
		return subject;
	}

	public String getTo() {
		return to;
	}

	public void send() throws AddressException, MessagingException {

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", this.host);
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(this.from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(this.subject);
		message.setText("This email is a test.");
		Transport.send(message);
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
