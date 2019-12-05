package stc21.project.reducto.dto.validators;

import stc21.project.reducto.dto.UserRegistrationDto;
import stc21.project.reducto.dto.validators.annotations.EqualPasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, UserRegistrationDto> {

    @Override
    public void initialize(EqualPasswords constraint) {
    }

    @Override
    public boolean isValid(UserRegistrationDto form, ConstraintValidatorContext context) {
        return form.getPassword().equals(form.getRepeatPassword());
    }

}