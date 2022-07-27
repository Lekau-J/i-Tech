/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package za.ac;

import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author letso
 */
@Stateless
@LocalBean
public class EmailSender {

    private Session session;

    public void requestAccess(String username, String password, String grantUrl) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        //email address and password... this account is created for test so don't bother hacking
                        return new PasswordAuthentication("jobralets1@gmail.com", "javamissionary");
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jobralets1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jobralets1@gmail.com"));
            message.setSubject("Request Access");
            //Since email can render html, this message is constructed as html format
            String content = "Dear Administrator,<br /><br />"
                    + "This user requests access.<br />"
                    + "Desired username: " + username + "<br />"
                    + "Desired password: " + password + "<br /><br/>"
                    + "<a href='" + grantUrl + "&role=admin'>GRANT ADMIN ACCESS</a><br />"
                    + "<a href='" + grantUrl + "&role=guest'>GRANT GUEST ACCESS</a><br />";
            message.setContent(content, "text/html");
            Transport.send(message);
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
    }
}
