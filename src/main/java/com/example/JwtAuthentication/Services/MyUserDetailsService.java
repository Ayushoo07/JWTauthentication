package com.example.JwtAuthentication.Services;

import com.example.JwtAuthentication.Models.User;
import com.example.JwtAuthentication.Exception.NotAvailabilityException;
import com.example.JwtAuthentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws NotAvailabilityException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty()) throw new NotAvailabilityException("User not found with given username");
        User user = optionalUser.get();

        if(user.getEmail().equals(username)){
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
        }
        return null;
    }
}