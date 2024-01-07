package GuilhermeBauer16.github.mailsend.service.impl;


import GuilhermeBauer16.github.mailsend.dto.MailDetailsDTO;
import GuilhermeBauer16.github.mailsend.service.EmailService;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Objects;



@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            for (int i = 0; i < file.length; i++) {
                mimeMessageHelper.addAttachment(
                        file[i].getOriginalFilename(),
                        new ByteArrayResource(file[i].getBytes()));
            }

            javaMailSender.send(mimeMessage);

            return "mail send";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

//    @Override
//    public String sendMail(MailDetailsDTO mailDetailsDTO) {
//        try {
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(fromEmail);
//            mimeMessageHelper.setTo(mailDetailsDTO.to());
//            mimeMessageHelper.setCc(mailDetailsDTO.cc());
//            mimeMessageHelper.setSubject(mailDetailsDTO.subject());
//            mimeMessageHelper.setText(mailDetailsDTO.body());
//
//            for (MultipartFile multipartFile : mailDetailsDTO.file()) {
//
//                mimeMessageHelper.addAttachment(multipartFile.getOriginalFilename(),
//                        new ByteArrayResource(multipartFile.getBytes()));
//
//            }
//
//            javaMailSender.send(mimeMessage);
//
//            return "mail send";
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//
//    }
}