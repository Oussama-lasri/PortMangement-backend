package com.example.portmanagement.Services;


import com.example.portmanagement.DTO.Requests.SignInRequest;
import com.example.portmanagement.DTO.Requests.SignUpRequest;
import com.example.portmanagement.DTO.Responses.AuthenticationResponse;

public interface IAuthenticationService {

    // todo Sign in and sign up

    public AuthenticationResponse signIn(SignInRequest request);
    public AuthenticationResponse signUp(SignUpRequest request) throws Exception;
    public Boolean checkEmail(String email);

}