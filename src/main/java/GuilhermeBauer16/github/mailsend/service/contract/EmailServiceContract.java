package GuilhermeBauer16.github.mailsend.service.contract;

import GuilhermeBauer16.github.mailsend.model.NotificationMail;

public interface EmailServiceContract {

    void sendMail(NotificationMail data);
}
