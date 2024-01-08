package GuilhermeBauer16.github.mailsend.controller;

import GuilhermeBauer16.github.mailsend.dto.NotificationMailDTO;
import GuilhermeBauer16.github.mailsend.model.NotificationMail;
import GuilhermeBauer16.github.mailsend.service.EmailService;
import GuilhermeBauer16.github.mailsend.service.NotificationMailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class EmailSendController {

    private final EmailService emailService;
    private final NotificationMailService notificationMailService;

    @Autowired
    public EmailSendController(EmailService emailService, NotificationMailService notificationMailService) {
        this.emailService = emailService;
        this.notificationMailService = notificationMailService;
    }


//    @PostMapping("/send")
//    public String sendMail(@RequestParam(value = "file", required = false)MultipartFile[] file, String  to ,
//                           String[] cc , String subject , String body){
//        return emailService.sendMail(file,to,cc,subject,body);
//    }

    @PostMapping("/send")
    public ResponseEntity sendMail(@RequestBody @Valid NotificationMailDTO notificationMailDTO) {

        emailService.sendMail(notificationMailService.createNotificationEmail(notificationMailDTO));
        return ResponseEntity.ok().build();
    }
}
