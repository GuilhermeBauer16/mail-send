package GuilhermeBauer16.github.mailsend.dto;

import GuilhermeBauer16.github.mailsend.service.EmailService;
import jakarta.validation.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

public record MailDetailsDTO(

        MultipartFile[] file,
        String to,
        String[] cc,
        String subject,
        String body) {

}

