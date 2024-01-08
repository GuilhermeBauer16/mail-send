package GuilhermeBauer16.github.mailsend.dto;

import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

public record NotificationMailDTO(

        @NotBlank
        String[] cc,

        @NotBlank
        String subject,

        @NotBlank
        String body) {


}

