package GuilhermeBauer16.github.mailsend.service.contract;

import GuilhermeBauer16.github.mailsend.dto.NotificationMailDTO;
import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.NotificationMailService;
import org.springframework.web.multipart.MultipartFile;

public interface NotificationEmailContract {

    NotificationMail createNotificationEmail(NotificationMailDTO notificationMailDTO);

}
