package com.conte.hackothumun.controller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserAppController {
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/login")
    public String loginPage(Model model){
        return "loginPage";
    }
    @GetMapping("/register")
    public String registerPage(Model model){
        return "registerPage";
    }
}
