package hu.tarnai.minerva.utility;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import hu.tarnai.minerva.enums.ErrorCodeEnum;

public class EmailSend {
	private static String FROM = "taresz0531@gmail.com";
	private static String PW = "Taresz.0531";
	private static String HOST = "smtp.gmail.com";
	
public static ErrorCodeEnum sendMail(String[] to, String subject, String messageText) {
	
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", HOST);
    props.put("mail.smtp.user", FROM);
    props.put("mail.smtp.password", PW);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(FROM));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);
        }

        message.setSubject(subject);
        message.setContent(messageText,"text/html; charset=utf-8");
        
        Transport transport = session.getTransport("smtp");
        transport.connect(HOST, FROM, PW);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        
        return ErrorCodeEnum.SUCCESS;
    }
    catch (AddressException ae) {
        ae.printStackTrace();
        return ErrorCodeEnum.ERROR;
    }
    catch (MessagingException me) {
        me.printStackTrace();
        return ErrorCodeEnum.ERROR;
    }
}
	
}
