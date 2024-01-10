package GuilhermeBauer16.github.mailsend.dto;


import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record NotificationMailDTO(


        String[] cc,


        String subject,


        String body,
        MultipartFile[] imagePath) {


}

