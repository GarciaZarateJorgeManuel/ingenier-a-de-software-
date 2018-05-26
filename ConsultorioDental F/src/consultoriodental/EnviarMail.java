
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultoriodental;

/**
 *
 * @author Armando
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnviarMail {
    
    public static String Username = "infoDrFrancisco@gmail.com";
    public static String PassWord = "Y*Y*Y*Y*";
    String Mensage;
    String To = "";
    String Subject ;
 public EnviarMail(String enviarA,String Mensaje,String Asunto){
   this.To = enviarA;
   Subject=Asunto;
   this.Mensage=Mensaje;
 }
 
    public void SendMail() {
        
    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
    props.put("mail.smtp.user", Username);
    props.put("mail.smtp.clave",PassWord);    //La clave de la cuenta
    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });
    MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(Username));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(To));   //Se podrían añadir varios de la misma manera
        message.setSubject(Subject);
        message.setText(Mensage);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", Username, PassWord);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
