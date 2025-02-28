package com.companionly.prototype.controllers;

import com.companionly.prototype.data.UserRepository;
import com.companionly.prototype.models.User;
import com.companionly.prototype.services.CustomUserDetails;
import com.companionly.prototype.models.Questionnaire;
import com.companionly.prototype.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private QuestionnaireService service;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/home")
	public String showHomePage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
		// get the list of questions, etc. ...
		List<Questionnaire> questions = service.getAllQuestions();
		model.addAttribute("questions", questions);

		if (customUserDetails != null) {
			// Pull fresh user from DB so the points field is up to date
			User dbUser = userRepository
					.findByEmail(customUserDetails.getUsername())
					.orElseThrow(() -> new RuntimeException("User not found!"));

			model.addAttribute("username", dbUser.getEmail());
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("lastName", dbUser.getLastName());
			model.addAttribute("points", dbUser.getTotalPoints());
		} else {
			model.addAttribute("points", 0);
		}

		return "home";
	}
	}
