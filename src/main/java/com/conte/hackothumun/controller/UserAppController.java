package com.conte.hackothumun.controller;
import com.conte.hackothumun.entity.UserApp;
import com.conte.hackothumun.repository.UserAppRepo;
import com.conte.hackothumun.service.AccountServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserAppController {
    private final AccountServiceImpl accountService;

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
        model.addAttribute("user", new UserApp());
        return "registerPage";
    }
    @GetMapping("/showuser")
    public String showUser(UserApp user){
        accountService.loadUserByUsername(user.getUsername());
        return "redirect:/index";
    }
    @PostMapping("/createUser")
    public String createUser(UserApp user, Model model){
//        try {
            accountService.addNewUser(user);
            return "redirect:/index";
//        }catch (RuntimeException e){
//            model.addAttribute("error", e.getMessage());
//            return "index";
//        }

    }

    @GetMapping("/notAuthorized")
    public String notAuthorized(){
        return "notAuthorized";
    }
}
