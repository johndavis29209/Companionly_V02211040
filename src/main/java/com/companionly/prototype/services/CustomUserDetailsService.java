package com.companionly.prototype.services;

import com.companionly.prototype.models.User;
import com.companionly.prototype.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    ;
    private  UserRepository userRepository;

    private RewardService rewardService;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Searching for user with email: " + username);

        // Fetch the user by email
        Optional<User> userOptional = userRepository.findByEmail(username);

        // If user is not found, throw exception
        if (userOptional.isEmpty()) {
            System.out.println("User not found with email: " + username);
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Retrieve the User object
        User user = userOptional.get();
        System.out.println("User found: " + user.getEmail() + " with first name: " + user.getFirstName());
        System.out.println("Encoded password from database: " + user.getPassword());

        // Return CustomUserDetails for Spring Security
        return new CustomUserDetails(user, rewardService);
    }
}
