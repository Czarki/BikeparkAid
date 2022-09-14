package pl.czrmjd.bikeparkaid.sender;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.*;

@Service
@AllArgsConstructor
public class EmailSender {
    private final JavaMailSender javaMailSender;
    private final EmailGenerator emailGenerator;

    public void sendEmail(String emailAddress, String token) {
        MimeMessage mimeMessage;
        try {
            mimeMessage = emailGenerator.generateRegistrationEmailMessage(emailAddress, token);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        javaMailSender.send(mimeMessage);
    }
}
