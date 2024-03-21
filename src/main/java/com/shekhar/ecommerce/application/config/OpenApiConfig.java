package com.shekhar.ecommerce.application.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                    name = "Kumar Shekhar",
                    email = "kumar.shekhar@gmail.com",
                    url = "https:/ex"
                ),
                description = "Open Api documentation of Ecommerce",
                title = "Open Api Documentation - Ecommerce",
                version = "1.0",
                license = @License(
                        name = "License1",
                        url = "https://url1"
                ),
                termsOfService = "Terms of Service"
        ),

        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Prod ENV",
                        url = "https://kumar.com"
                )
        },
        security = @SecurityRequirement(  // It will restrict all the endpoints of this application. JWT token is required to access
                name = "bearerAuth"
        )
)

@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER

)

public class OpenApiConfig {
}
