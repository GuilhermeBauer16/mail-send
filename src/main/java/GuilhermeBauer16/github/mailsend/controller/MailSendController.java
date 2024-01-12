package GuilhermeBauer16.github.mailsend.controller;

import GuilhermeBauer16.github.mailsend.dto.NotificationMailDTO;
import GuilhermeBauer16.github.mailsend.service.MailService;
import GuilhermeBauer16.github.mailsend.service.NotificationMailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mail")
public class MailSendController {

    private final MailService mailService;
    private final NotificationMailService notificationMailService;

    @Autowired
    public MailSendController(MailService mailService, NotificationMailService notificationMailService) {
        this.mailService = mailService;
        this.notificationMailService = notificationMailService;
    }


    @PostMapping(value = "/send" , consumes = "multipart/form-data")
    public ResponseEntity<String> sendMail(NotificationMailDTO notificationMailDTO,
                                           @RequestPart(name = "file", required = false)MultipartFile[] file) {

        mailService.sendMail(notificationMailService.createNotificationEmail(notificationMailDTO), file);
        return ResponseEntity.ok().build();
    }
}
