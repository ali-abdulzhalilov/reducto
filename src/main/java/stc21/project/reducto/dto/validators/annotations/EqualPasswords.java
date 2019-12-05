package stc21.project.reducto.dto.validators.annotations;

import stc21.project.reducto.dto.validators.EqualPasswordsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualPasswordsValidator.class})
public @interface EqualPasswords {
    String message() default "Passwords don\'t match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
