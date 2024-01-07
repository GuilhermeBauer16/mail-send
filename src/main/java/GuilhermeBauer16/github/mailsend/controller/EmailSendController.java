package GuilhermeBauer16.github.mailsend.controller;

import GuilhermeBauer16.github.mailsend.MailSendApplication;
import GuilhermeBauer16.github.mailsend.dto.MailDetailsDTO;
import GuilhermeBauer16.github.mailsend.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;

@RestController
@RequestMapping("/mail")
public class EmailSendController {

    private EmailService emailService;

    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false)MultipartFile[] file, String  to ,
                           String[] cc , String subject , String body){
        return emailService.sendMail(file,to,cc,subject,body);
    }

//    @PostMapping("/send")
//    public String sendMail(@RequestBody MailDetailsDTO mailDetailsDTO){
//        return emailService.sendMail(mailDetailsDTO);
//    }
}
