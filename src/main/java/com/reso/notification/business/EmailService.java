package com.reso.notification.business;

import com.reso.notification.business.dto.TaskDTO;
import com.reso.notification.infrastructure.exception.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @Value("${send.email.sender}")
    private String sender;

    @Value("${send.email.senderName}")
    private String senderName;

    public void sendEmail(TaskDTO taskDTO) {

        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            helper.setFrom(new InternetAddress(sender, senderName));
            helper.setTo(InternetAddress.parse(taskDTO.getUserEmail()));
            helper.setSubject("Notificação de Tarefa");

            Context context = new Context();
            context.setVariable("taskName", taskDTO.getNameTask());
            context.setVariable("eventDate", taskDTO.getEventDate().format(formatter));
            context.setVariable("description", taskDTO.getDescription());
            String template = templateEngine.process("notification", context);
            helper.setText(template, true);
            javaMailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException("Error trying to send email", e.getCause());
        }
    }
}
