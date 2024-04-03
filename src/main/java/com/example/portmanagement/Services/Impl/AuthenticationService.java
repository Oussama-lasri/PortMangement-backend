package com.example.portmanagement.Services.Impl;


import com.example.portmanagement.DTO.Requests.SignInRequest;
import com.example.portmanagement.DTO.Requests.SignUpRequest;
import com.example.portmanagement.DTO.Responses.AuthenticationResponse;
import com.example.portmanagement.Models.User;
import com.example.portmanagement.Repositories.UserRepository;
import com.example.portmanagement.Security.JwtService;
import com.example.portmanagement.Services.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    private final PasswordEncoder passwordEncoder ;
    private final UserRepository userRepository ;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse signIn(SignInRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }



        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->
                new IllegalArgumentException("Invalid email or password.")
        );
        String  jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    @Override
    public AuthenticationResponse signUp(SignUpRequest request) throws Exception {

        var user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);
        // Todo add claims for authorities
        //Map<String , Object> claims = new HashMap<>();

        String token = jwtService.generateToken(user);



        return AuthenticationResponse.builder().token(token).build();
    }

    @Override
    public Boolean checkEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}