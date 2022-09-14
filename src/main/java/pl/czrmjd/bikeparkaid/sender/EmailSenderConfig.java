package pl.czrmjd.bikeparkaid.sender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import pl.czrmjd.bikeparkaid.AppConfiguration;

import java.util.Properties;

@Configuration
public class EmailSenderConfig {

    @Bean
    public JavaMailSender getJavaMailSender(AppConfiguration appConfiguration) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(appConfiguration.getEmailHost());
        mailSender.setPort(appConfiguration.getEmailPort());
        mailSender.setDefaultEncoding("UTF-8");

        mailSender.setUsername(appConfiguration.getEmailUsername());
        mailSender.setPassword(appConfiguration.getEmailPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");
        props.put("mail.smtp.ssl.trust", "*");

        return mailSender;
    }

}
