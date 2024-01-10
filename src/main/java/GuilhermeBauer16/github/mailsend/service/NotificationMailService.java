package GuilhermeBauer16.github.mailsend.service;

import GuilhermeBauer16.github.mailsend.dto.NotificationMailDTO;
import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.contract.NotificationEmailContract;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class NotificationMailService implements NotificationEmailContract {

    @Override
    public NotificationMail createNotificationEmail(NotificationMailDTO notificationMailDTO) {

        return NotificationMail.builder()
                .cc(notificationMailDTO.cc())
                .subject(notificationMailDTO.subject())
                .body(notificationMailDTO.body())
                .build();
    }

}
