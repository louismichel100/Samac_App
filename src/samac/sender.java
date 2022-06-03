/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

/**
 *
 * @author NGONO
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class sender {
    
    public int envoyer_mail(String url, String mess){
         //// Sender's email id and pass
        
        Properties props = new Properties();
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.socketFactory.port", "465");
                        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.prot", "465");

                        Session session = Session.getDefaultInstance(props,
                                new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {

                                return new PasswordAuthentication("sangalamballamichel@gmail.com", "audemp0_P");
                            }
                        }
                        );
                        try {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress("sangalamballamichel@gmail.com"));
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(url));
                            message.setSubject("Inscription validée, recevez votre login et mot de passe !");
                            message.setHeader("BBS UD", "BBS UD");
                        
                            message.setText(mess);
                            Transport.send(message);
                            
                            return 1;

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "pas de connexion internet");
                            e.printStackTrace();
                            
                        }
                        
          return 0;              
    }
    
}

//https://myaccount.google.com/lesssecureapps
