package com.companionly.prototype.services;

import com.companionly.prototype.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final User user;



    private final RewardService rewardService;


    public CustomUserDetails(User user, RewardService rewardService) {
        this.user = user;
        this.rewardService = rewardService;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }
    
    public User getUser() {
        return user;
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public int getTotalPoints() {
        return user.getTotalPoints();
    }


   

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void awardLoginPoints() {
        rewardService.rewardLoginPoints(user);
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "email=" + getUsername() +
                ", roles=" + getAuthorities() +
                '}';
    }

}
