/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.Arquidalgos.usuario.logic.ejb;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JoseMiguel
 */
public class SendEmail extends Thread {
    private String to;
    private String valorBono;
    private String tienda;
    private String codigoBono;
    public SendEmail(String to, String valorBono, String tienda, String codigoBono ) {
        this.to = to;
        this.valorBono = valorBono;
        this. tienda = tienda;
        this.codigoBono = codigoBono;
    }
    @Override
    public void run() {
        final String user="arquidalgos@hotmail.com";//change accordingly  
        final String password="AlanTuring";//change accordingly  

        //String to="jose_suarez94@hotmail.com";//change accordingly  

        //Get the session object  
        Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.live.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");  

        Session session;  
            session = Session.getInstance(props,  
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user,password);
                        }
                    });  

        //Compose the message  
        try {  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(user));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("ln.rojas1902@uniandes.edu.co"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("jf.molano1587@uniandes.edu.co"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("jf.calderon1377@uniandes.edu.co"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("jm.suarez201@uniandes.edu.co"));
            message.setSubject("Tu Mejor Opción");  
            message.setText("Hola,\n José Miguel te ha enviado un bono por $"+ valorBono + " a travéz de TuMejorOpcon.com para que lo utilices comprando ropa en " + tienda+ "   \n El código de tu bono es: " + codigoBono);  

            //send the message  
            Transport.send(message);  

            System.out.println("message sent successfully...");  

        } catch (MessagingException e) {e.printStackTrace();}  
    }
}