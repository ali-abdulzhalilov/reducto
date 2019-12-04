package stc21.project.reducto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stc21.project.reducto.service.UserService;

@Controller
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, World!");
        model.addAttribute("users", userService.getAllUsers());
        
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/list")
    public String cards() {
        return "list";
    }
}
