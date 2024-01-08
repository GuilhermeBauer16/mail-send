package GuilhermeBauer16.github.mailsend.service;

import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.contract.EmailServiceContract;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServiceContract {
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender javaMailSender;

    public EmailService( JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(NotificationMail data) {
        try {
            MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(fromEmail);
            mimeMessageHelper.setSubject(data.getSubject());
            mimeMessageHelper.setCc(data.getCc());
            mimeMessageHelper.setText(data.getBody());
//            Path path = Paths.get(data.getImagePath());
//            byte[] imageBytes = Files.readAllBytes(path);
//            String fileName = path.getFileName().toString();
//            InputStreamSource imageSource = new ByteArrayResource(imageBytes);
//            mimeMessageHelper.addAttachment(fileName, imageSource);

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
//    String sendMail(MailDetailsDTO mailDetailsDTO);

//    String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body);
//
//    MultipartFile sendImageEmail(MultipartFile multipartFile, MimeMessage mimeMessage);
}
