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

        // validation
        // TODO: move validation checks to custom validation annotations

        // checks for validity


        // checks for existence
        UserDto existingUserDto = userService.findByUsername(userRegistrationDto.getUsername());
        if (existingUserDto != null) {
            result.rejectValue("username", null, "User with this username already exist");
        }

        existingUserDto = userService.findByEmail(userRegistrationDto.getEmail());
        if (existingUserDto != null) {
            result.rejectValue("email", null, "User with this email already exist");
        }

        existingUserDto = userService.findByPhoneNumber(userRegistrationDto.getPhoneNumber());
        if (existingUserDto != null) {
            result.rejectValue("phoneNumber", null, "User with this phoneNumber already exist");
        }

        if (!userRegistrationDto.getPassword().equals(
                userRegistrationDto.getRepeatPassword())){
            result.rejectValue("repeatPassword", null, "Password doesn't match");
        }

        if (result.hasErrors()) {
            return "register";
        }

        userService.save(userRegistrationDto);
        return "redirect:/register?success=true";
    }
}
