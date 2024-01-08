package GuilhermeBauer16.github.mailsend.service;

import GuilhermeBauer16.github.mailsend.dto.NotificationMailDTO;
import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.contract.NotificationEmailContract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationMailService implements NotificationEmailContract {

    @Override
    public NotificationMail createNotificationEmail(NotificationMailDTO notificationMailDTO) {

        NotificationMail notificationMail = new NotificationMail();
        notificationMail.setCc(notificationMailDTO.cc());
        notificationMail.setSubject(notificationMailDTO.subject()); // Set subject from DTO
        notificationMail.setBody(notificationMailDTO.body());
        return notificationMail;
    }

}
