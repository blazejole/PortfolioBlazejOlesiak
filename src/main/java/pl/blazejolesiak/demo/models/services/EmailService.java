package pl.blazejolesiak.demo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.blazejolesiak.demo.models.foms.EmailForm;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service

public class EmailService {

    @Autowired
    JavaMailSender sender;

    public void sendMessage(EmailForm emailForm){
        MimeMessage mail = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("blazej.olesiak@gmail.com");
            helper.setSubject("PortfolioContact");
            helper.setText("Wiadomość od uzytkownika: "+emailForm.getMessage() + " numer telefonu kontaktowego: "+ emailForm.getPhonenumber()+ " adres wysylajacego: "+ emailForm.getEmail());
            helper.setReplyTo("Wiadomosc zwrotna: "+ emailForm.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(mail);

    }
}
