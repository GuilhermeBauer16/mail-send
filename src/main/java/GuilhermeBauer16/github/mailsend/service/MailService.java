package GuilhermeBauer16.github.mailsend.service;

import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.contract.EmailServiceContract;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Service
public class MailService implements EmailServiceContract {

    private final String fromEmail;
    private final JavaMailSender javaMailSender;

    public MailService(@Value("${spring.mail.username}")String fromEmail, JavaMailSender javaMailSender) {
        this.fromEmail = fromEmail;
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
                    ByteArrayResource byteArrayResources = new ByteArrayResource(image.getBytes(),
                            "application/octet-stream");
                    mimeMessageHelper.addAttachment(image.getOriginalFilename(),
                            byteArrayResources);
                }
            }

            javaMailSender.send(mimeMessage);

        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
