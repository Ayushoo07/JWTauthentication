package com.example.JwtAuthentication.Controller;

import com.example.JwtAuthentication.Exception.AvailabilityException;
import com.example.JwtAuthentication.Transformer.UserRequestDtoToUser;
import com.example.JwtAuthentication.DTO.UserRequestDto;
import com.example.JwtAuthentication.DTO.JwtRequest;
import com.example.JwtAuthentication.DTO.JwtResponse;
import com.example.JwtAuthentication.Models.User;
import com.example.JwtAuthentication.Security.JWTHelper;
import com.example.JwtAuthentication.Services.MyUserDetailsService;
import com.example.JwtAuthentication.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
public class AuthController {



    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/Signup")
    public ResponseEntity<String> Signup(@RequestBody UserRequestDto userRequestDto) throws AvailabilityException {
        Optional<User> optionalUser = userRepository.findByEmail(userRequestDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new AvailabilityException("User available here try another one");
        }

        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());
        userRequestDto.setPassword(encodedPassword);

        User responseUser = userRepository.save(UserRequestDtoToUser.userRequestdtoTouser(userRequestDto));


        return new ResponseEntity<String>("User added successfullly",HttpStatus.OK);
    }

    @PostMapping("/Login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/current-user")
    public String getcurentuser(Principal principal)
            
    {
        return principal.getName();
    }

    @GetMapping("/mydetails")
    public Optional<User> mydetails(Principal principal)

    {
        return userRepository.findByEmail(principal.getName());
    }
    
    
    
    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
