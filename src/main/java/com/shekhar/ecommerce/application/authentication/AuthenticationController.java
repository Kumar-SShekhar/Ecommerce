package com.shekhar.ecommerce.application.authentication;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
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
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.loginUser(loginRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Login Successful", authenticationResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest registerRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.registerUser(registerRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Registration Successful", authenticationResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse> refresh(HttpServletRequest request, HttpServletResponse response){
        AuthenticationResponse authenticationResponse = authenticationService.refreshToken(request, response);
        ApiResponse apiResponse = new ApiResponse("Success", "Refresh Token generated successfully", authenticationResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }


    @GetMapping("/demo")
    public String getMessage(){
        System.out.println("bhhbswcc");
        return "Message from demo controller";
    }


}
