package pl.blazejolesiak.demo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.blazejolesiak.demo.models.EmailModel;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service

public class EmailService {

    @Autowired
    JavaMailSender sender;

    public void sendMessage(EmailModel emailModel){
        MimeMessage mail = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("blazej.olesiak@gmail.com");
            helper.setSubject("PortfolioContact");
            helper.setText("Wiadomość od uzytkownika: "+ emailModel.getMessage() + " numer telefonu kontaktowego: "+ emailModel.getPhonenumber()+ " adres wysylajacego: "+ emailModel.getEmail());
            helper.setReplyTo(emailModel.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(mail);

    }
}
