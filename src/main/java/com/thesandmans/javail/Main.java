package com.thesandmans.javail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
 
public class Main {
     
    public static void main(String[] args)
    {
		Javail weShall = new Javail();
		weShall.setHost(args[0]);
		weShall.setFrom(args[1]);
		weShall.setTo(args[2]);
		weShall.setSubject(args[3]);
		weShall.setBody(args[4]);

		try {
			weShall.send();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
}
