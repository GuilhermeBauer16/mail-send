package GuilhermeBauer16.github.mailsend.service;

import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.contract.EmailServiceContract;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class EmailService implements EmailServiceContract {
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(NotificationMail data, MultipartFile[] file) {
        try {
            MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(fromEmail);
            mimeMessageHelper.setSubject(data.getSubject());
            mimeMessageHelper.setCc(data.getCc());
            mimeMessageHelper.setText(data.getBody());
            if (file != null) {
                for (MultipartFile image : file) {
                    ByteArrayResource byteArrayResources = new ByteArrayResource(image.getBytes());
                    mimeMessageHelper.addAttachment(image.toString(),
                            byteArrayResources);
                }
            }


            javaMailSender.send(mimeMessage);

        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
