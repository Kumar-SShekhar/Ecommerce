package com.shekhar.ecommerce.application.authentication;

import com.shekhar.ecommerce.application.dto.requestDto.LoginRequest;
import com.shekhar.ecommerce.application.dto.requestDto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authenticationService.loginUser(loginRequest), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(authenticationService.registerUser(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<>(authenticationService.refreshToken(request, response), HttpStatus.OK);
    }


    @GetMapping("/demo")
    public String getMessage(){
        System.out.println("bhhbswcc");
        return "Message from demo controller";
    }


}
