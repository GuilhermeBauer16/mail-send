package GuilhermeBauer16.github.mailsend.service;

import GuilhermeBauer16.github.mailsend.dto.MailDetailsDTO;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
//    String sendMail(MailDetailsDTO mailDetailsDTO);

    String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body);
}
