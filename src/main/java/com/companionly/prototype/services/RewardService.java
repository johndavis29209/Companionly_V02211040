package com.companionly.prototype.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.companionly.prototype.models.User;
import com.companionly.prototype.data.UserRepository;

@Service
public class RewardService {

    private final UserRepository userRepository;

    public RewardService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Award user login points if not already rewarded today.
     *
     * @param user the user who just logged in
     */
    @Transactional
    public void rewardLoginPoints(User user) {
        LocalDate today = LocalDate.now();

        // Check if the user has never been rewarded or was last rewarded on a different day
        if (user.getLastLoginRewardDate() == null ||
                !user.getLastLoginRewardDate().toLocalDate().equals(today)) {

            // Award points and update the last reward date
            user.setTotalPoints(user.getTotalPoints() + 10);
            user.setLastLoginRewardDate(LocalDateTime.now());
            userRepository.save(user);
        }
    }
}
