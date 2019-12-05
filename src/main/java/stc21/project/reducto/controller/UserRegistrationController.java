package stc21.project.reducto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stc21.project.reducto.dto.UserDto;
import stc21.project.reducto.dto.UserRegistrationDto;
import stc21.project.reducto.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
            BindingResult result) {

        userService
                .fieldsWithErrors(userRegistrationDto)
                .forEach(
                        fieldName->result.rejectValue(
                                fieldName,
                                null,
                                "Username with this "+fieldName+" already exist. Pick another one."));

        if (result.hasErrors()) {
            return "register";
        }

        userService.save(userRegistrationDto);
        return "redirect:/register?success=true";
    }
}
