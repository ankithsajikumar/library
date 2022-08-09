package com.library.entespotify.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/register")
    public String register() {
        return "register";
    }


    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }
}
