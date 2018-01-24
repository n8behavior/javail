package com.thesandmans.javail;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import junit.framework.TestCase;

public class JavailTest extends TestCase {

	public static final String SMTP_HOST = "localhost";
	public static final String SMTP_FROM = "test@localhost";
	public static final String SMTP_TO = "test@example.com";
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSend() {
		UUID uuid = UUID.randomUUID();

		Javail weShall = new Javail();
		weShall.setHost(SMTP_HOST);
		weShall.setFrom(SMTP_FROM);
		weShall.setTo(SMTP_TO);
		weShall.setSubject(uuid.toString());

		try {
			weShall.send();
		} catch (AddressException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
}
