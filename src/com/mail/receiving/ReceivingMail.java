package com.mail.receiving;

import com.mail.entities.Email;
import com.sun.mail.pop3.POP3Folder;

import javax.mail.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReceivingMail {
	
    public static List<Email>  receiving(final String user,final String pass)  {

        List<Email> emails = new ArrayList<>();
        try {
            Properties properties = new Properties();
            Session session;
            String SMTP_HOST = "192.168.56.128";
            properties.put("mail.smtp.host", SMTP_HOST);
            properties.put("mail.smtp.port","25");
            properties.put("mail.smtp.auth","true");
    		properties.put("mail.smtp.user", user.split("@")[0]);
    		properties.put("mail.smtp.password", pass);

    	    		
    		session = Session.getInstance(properties, new javax.mail.Authenticator() {
    		    protected PasswordAuthentication getPasswordAuthentication() {
    		        return new PasswordAuthentication(user.split("@")[0], pass);
    		    }
    		});

    		session.setDebug(true);
            Store store = session.getStore("pop3");
            store.connect(SMTP_HOST,user.split("@")[0],pass);
            Folder folder = store.getFolder("inbox");

            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();

            for(Message message : messages){
                POP3Folder pf = (POP3Folder)folder;
                Email email = new Email();
                email.setMessage((String) message.getContent());
                email.setFrom(message.getFrom()[0].toString());
                email.setObjet(message.getSubject());
                email.setCreatedAt(message.getSentDate());
                email.setUuid(pf.getUID(message));
                emails.add(email);
            }


            folder.close(true);
            store.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return emails;
    }

}
