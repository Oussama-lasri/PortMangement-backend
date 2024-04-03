package com.example.portmanagement.Controllers;


import com.example.portmanagement.DTO.Requests.SignInRequest;
import com.example.portmanagement.DTO.Requests.SignUpRequest;
import com.example.portmanagement.DTO.Responses.AuthenticationResponse;
import com.example.portmanagement.DTO.Responses.BooleanResponse;
import com.example.portmanagement.Services.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    // todo inject authentication service
    private final IAuthenticationService authenticationService;

    // todo Sign in and sign up
    @PostMapping("/signIn")
    public ResponseEntity<AuthenticationResponse> signIn(
            @RequestBody SignInRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.signIn(request));
    }
    @PostMapping("/signUp")
    public ResponseEntity<AuthenticationResponse> signUp(
            @RequestBody SignUpRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.signUp(request));
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<BooleanResponse> checkEmail(@RequestParam String email){
        log.info(email);
        return  ResponseEntity.status(HttpStatus.OK).body(BooleanResponse.builder().isExist(authenticationService.checkEmail(email)).build());
    }


}