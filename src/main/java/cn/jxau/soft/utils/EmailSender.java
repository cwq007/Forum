package cn.jxau.soft.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	
	private static Session session;
	private Message msg;
	
	static {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("m13037232862_2@163.com", "123321c");
			}
		};
		session = Session.getDefaultInstance(props, auth);
	}
	
	public Message createMessage(String msgText) throws MessagingException {
		msg = new MimeMessage(session);
		msg.setSubject("欢迎注册");
		msg.setSentDate(new Date());
		msg.setFrom(new InternetAddress("m13037232862_2@163.com"));
		msg.setContent(msgText, "text/html; charset=utf-8"); 
		return msg;
	}
	
	public void sendTo(String emailAddress, String msgText) throws Exception {
		Transport transport;
		transport = session.getTransport();
		transport.connect();
		transport.sendMessage(createMessage(msgText), new InternetAddress[]{new InternetAddress(emailAddress)});
		transport.close();
	}
	
}
