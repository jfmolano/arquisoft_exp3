package munod;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author JoseMiguel
 */
public class SendEmail extends Thread {
    private final String to;
    private final String valorBono;
    private final String tienda;
    private final String codigoBono;
    private final static File file = new File("img/123.JPG");
    
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

        ManagerQR.generarCodigoQR(codigoBono, file);
        String sDirectorioTrabajo = System.getProperty("user.dir");
        System.out.println("--------------------------------------------------");
        System.out.println("El directorio de trabajo es " + sDirectorioTrabajo);
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
            
            MimeMultipart content = new MimeMultipart(); 
                MimeBodyPart bodyPart = new MimeBodyPart();
                bodyPart.setText("Hola,\n Jos� Miguel te ha enviado un bono por $"+ valorBono + " a trav�z de TuMejorOpcon.com para que lo utilices comprando ropa en " + tienda+ "   \n El c�digo de tu bono es: " + codigoBono);
            content.addBodyPart(bodyPart);
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.attachFile(file);
            content.addBodyPart(imagePart);
                
                message.setContent(content);
            message.setSubject("Tu Mejor Opci�n");  

            //send the message  
            Transport.send(message);  

            System.out.println("message sent successfully...");  

        } catch (MessagingException e) {e.printStackTrace();} 
        catch (IOException ex) {  
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}

