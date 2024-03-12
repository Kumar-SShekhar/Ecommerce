package com.shekhar.ecommerce.application.authentication;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String accessToken;
//    private String refreshToken;
}
