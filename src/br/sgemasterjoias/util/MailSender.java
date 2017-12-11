package br.sgemasterjoias.util;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender implements Serializable{
    
	private static final long serialVersionUID = 3071144309847934479L;

	public  void sendMail(String fromMail,String username,String password,
            String toMail,String subject,String message) throws AddressException, MessagingException{
    
        Properties props=System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        
        
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.fallback", "false");
                
                
                Session mailSession=Session.getDefaultInstance(props, null);
                mailSession.setDebug(true);
                
                Message mailMessage=new MimeMessage(mailSession);
                
                mailMessage.setFrom(new InternetAddress(fromMail));
                mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
                mailMessage.setContent(message,"text/html");
                mailMessage.setSubject(subject);
                
                Transport transport=mailSession.getTransport("smtp");
                transport.connect("smtp.gmail.com", 465, username, password);
                transport.sendMessage(mailMessage, mailMessage.getAllRecipients());   
                
                
    }
    
}