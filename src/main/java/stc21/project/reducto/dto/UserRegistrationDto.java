package stc21.project.reducto.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import stc21.project.reducto.dto.validators.annotations.EqualPasswords;
import stc21.project.reducto.dto.validators.annotations.ValidEmail;
import stc21.project.reducto.dto.validators.annotations.ValidPhoneNumber;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@EqualPasswords
public class UserRegistrationDto {
    @NotNull
    @Size(min=3, max=20)
    private String username;

    @NotNull
    @Size(min=3, max=20)
    private String password;
    private String repeatPassword;

    @ValidEmail
    private String email;
    @ValidPhoneNumber
    private String phoneNumber;
}
