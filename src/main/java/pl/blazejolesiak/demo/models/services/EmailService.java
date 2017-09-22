package pl.blazejolesiak.demo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service

public class EmailService {

    @Autowired
    JavaMailSender sender;

    public void sendMessage(String message,String reply, String fromWho){
        MimeMessage mail = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("blazej.olesiak@gmail.com");
            helper.setFrom("Uzytkownik o emailu: "+fromWho);
            helper.setSubject("PortfolioContact");
            helper.setText("Wiadomość od użytkownika: "+message, true);
            helper.setReplyTo(reply);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(mail);

    }
}
