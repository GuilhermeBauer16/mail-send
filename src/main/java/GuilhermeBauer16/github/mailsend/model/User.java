package GuilhermeBauer16.github.mailsend.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.BindParam;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    private String name;
    private String lastName;
}
