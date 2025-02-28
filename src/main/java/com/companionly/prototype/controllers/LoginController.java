package com.companionly.prototype.controllers;

import com.companionly.prototype.models.LoginModel;

import com.companionly.prototype.models.User;
import com.companionly.prototype.data.UserRepository;
import com.companionly.prototype.services.CustomUserDetails;
import com.companionly.prototype.services.RewardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RewardService rewardService;

    @GetMapping("")
    public String displayLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("loginError", "Invalid email or password.");
        }
        model.addAttribute("loginModel", new LoginModel());
        return "loginForm";
    }



    
    @GetMapping("/processLogin")
    public String handleInvalidGetRequest() {
        // Handle GET requests to /processLogin by redirecting to /login
        logger.warn("GET request to /processLogin detected. Redirecting to /login.");
        return "redirect:/login";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel,
                               BindingResult bindingResult,
                               Model model) {

        logger.info("Processing login...");
        if (bindingResult.hasErrors()) {
            logger.warn("Validation errors detected.");
            return "loginForm";
        }

        Optional<User> optionalUser = userRepository.findByEmail(loginModel.getEmail());
        if (optionalUser.isEmpty()) {
            logger.warn("Invalid login attempt: user not found.");
            model.addAttribute("loginError", "Invalid email or password.");
            return "loginForm";
        }



        User user = optionalUser.get();

        rewardService.rewardLoginPoints(user);
        userRepository.save(user);

        CustomUserDetails cud = (CustomUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        cud.getUser().setTotalPoints(user.getTotalPoints());

        if (!passwordEncoder.matches(loginModel.getPassword(), user.getPassword())) {
            logger.warn("Invalid login attempt: password mismatch.");
            model.addAttribute("loginError", "Invalid email or password.");
            return "loginForm";
        }



        logger.info("Login successful. Redirecting to /home.");
        return "redirect:/home";
    }
}