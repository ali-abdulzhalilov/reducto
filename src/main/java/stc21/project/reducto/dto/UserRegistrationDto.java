package stc21.project.reducto.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class UserRegistrationDto {
    @NotNull
    @Size(min=3, max=20)
    private String username;

    @NotNull
    @Size(min=3, max=20)
    private String password;
    private String repeatPassword;

    //@Email()
    private String email;
    //@Pattern()
    private String phoneNumber;
}
