package com.companionly.prototype.controllers;

import com.companionly.prototype.models.User;
import com.companionly.prototype.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/app")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @GetMapping("/process_register")
    public String handleInvalidGetRequest() {
        return "redirect:/register";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user, Model model) {
        if (repo.existsByEmail(user.getEmail())) {
            model.addAttribute("errorMessage", "Email is already in use. Please choose another.");
            return "signup_form";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        model.addAttribute("listUsers", repo.findAll());
        return "users";
    }
}
