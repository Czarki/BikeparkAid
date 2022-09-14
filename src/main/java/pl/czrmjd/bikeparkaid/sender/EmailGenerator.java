package pl.czrmjd.bikeparkaid.sender;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.AppConfiguration;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.*;

@Service
@AllArgsConstructor
public class EmailGenerator {

    private final AppConfiguration appConfiguration;
    private final JavaMailSender javaMailSender;

    public MimeMessage generateRegistrationEmailMessage(String emailAddress, String token) throws Exception {

        String template = FileUtils.readFileAsText("/email/email.html");

        String htmlMsg = template.replace("#{content}", "Zarejestrowałeś sie w BikeparkAid. Potwierdż konto klikając w link: ")
                .replace("#{url}", "http://localhost:8080/api/v1/registration/confirm?token=" + token);

        MimeMultipart mimeMultipart = new MimeMultipart();
        MimeBodyPart htmlBodyPart = createHtmlPart(htmlMsg);
        addBodyPartToMimeMultipart(mimeMultipart, htmlBodyPart);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setContent(mimeMultipart);
        mimeMessage.setContent(mimeMultipart);
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
        mimeMessage.setSubject("Aktywuj konto w BikeparkAid", "UTF-8");
        mimeMessage.setFrom(new InternetAddress(appConfiguration.getEmailUsername(), "BikeparkAid"));

        return mimeMessage;
    }

    public MimeBodyPart createHtmlPart(String htmlBody) {
        try {
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlBody, "text/html; charset=UTF-8");
            return htmlPart;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBodyPartToMimeMultipart(MimeMultipart mimeMultipart, MimeBodyPart mimeBodyPart) {
        try {
            mimeMultipart.addBodyPart(mimeBodyPart);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
