package com.companionly.prototype.services;

import com.companionly.prototype.models.User;
import com.companionly.prototype.data.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RewardService rewardService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Retrieve the authenticated user details
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        // Award login points (the RewardService method already saves the user)
        rewardService.rewardLoginPoints(user);

        // Optionally update the user in session (if you need the updated points immediately)
        userDetails.getUser().setTotalPoints(user.getTotalPoints());

        // Redirect to the home page after successful login
        response.sendRedirect("/home");
    }
}
