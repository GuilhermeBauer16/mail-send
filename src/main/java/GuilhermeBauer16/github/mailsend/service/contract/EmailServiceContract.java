package GuilhermeBauer16.github.mailsend.service.contract;

import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import org.springframework.web.multipart.MultipartFile;

public interface EmailServiceContract {

    void sendMail(NotificationMail data, MultipartFile[] file);
}
