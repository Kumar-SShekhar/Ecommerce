package com.shekhar.ecommerce.application.authentication;

import com.shekhar.ecommerce.application.dto.requestDto.LoginRequest;
import com.shekhar.ecommerce.application.dto.requestDto.RegisterRequest;
import com.shekhar.ecommerce.application.jwt.JwtService;
import com.shekhar.ecommerce.application.model.Role;
import com.shekhar.ecommerce.application.model.Token;
import com.shekhar.ecommerce.application.model.TokenType;
import com.shekhar.ecommerce.application.model.User;
import com.shekhar.ecommerce.application.repository.TokenRepository;
import com.shekhar.ecommerce.application.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    public AuthenticationResponse registerUser(RegisterRequest registerRequest){
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setAge(registerRequest.getAge());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        String jwtRefreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
//                .refreshToken(jwtRefreshToken)
                .build();
    }


    public AuthenticationResponse loginUser(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        String jwtRefreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user,jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
//                .refreshToken(jwtRefreshToken)
                .build();
    }

    public AuthenticationResponse refreshToken(HttpServletRequest request, HttpServletResponse response){
        final String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwtRefreshToken;
        final String userEmail;
        AuthenticationResponse authResponse=null;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return null;
        }
        jwtRefreshToken=authHeader.substring(7);
        userEmail=jwtService.extractUsername(jwtRefreshToken);
        if(userEmail!=null) {
            var user = userRepository.findByEmail(userEmail).orElseThrow();
            if(jwtService.isTokenValid(jwtRefreshToken, user)){
                var jwtAccessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, jwtAccessToken);
                authResponse = AuthenticationResponse.builder()
                        .accessToken(jwtAccessToken)
//                        .refreshToken(jwtRefreshToken)
                        .build();
//                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);  // If we use void as return type
            }
        }
        return authResponse;
    }

    private void saveUserToken(User user , String jwtToken){
        Token token = Token.builder()
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .isRevoked(false)
                .isExpired(false)
                .user(user)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user){
        var validUserTokens = tokenRepository.findAllByUserIdAndIsExpiredFalseAndIsRevokedFalse(user.getId());
        if(validUserTokens.isEmpty())
            return;

        validUserTokens.forEach(token -> {
            token.setIsExpired(true);
            token.setIsRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

}
