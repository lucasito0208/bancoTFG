package com.bank_management.lucas_backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@OpenAPIDefinition(
        info = @Info(
                description = "OpenApi documentation for Bank Management System",
                title = "OpenApi specification - Bank Management System"
        ),
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
public class OpenApiConfig {
    
}
