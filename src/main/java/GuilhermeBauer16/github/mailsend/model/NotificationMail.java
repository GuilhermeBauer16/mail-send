package GuilhermeBauer16.github.mailsend.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationMail {

    private String[] cc;
    private String subject;
    private String body;
    private MultipartFile[] imagePath;
}
