package com.mrdevv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Value("${email.account}")
    private String emailUser;

    @Value("${email.password}")
    private String emailPassword;

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(emailUser);
        mailSender.setPassword(emailPassword);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp"); // define el protocolo que se usará
        properties.put("mail.smtp.auth", "true"); // define que sea necesario autenticarse para enviar un email
        properties.put("mail.smtp.starttls.enable", "true"); // habilita el cifrado entre la comunicacion de la aplicacion y el provedor de correo electronico
        properties.put("mail.debug", "true"); // imprime en consola información

        return mailSender;
    }
}
