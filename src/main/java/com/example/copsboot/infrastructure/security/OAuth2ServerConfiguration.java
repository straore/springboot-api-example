package com.example.copsboot.infrastructure.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ResourceServerConfiguration.class,AuthorizationServerConfiguration.class})
public class OAuth2ServerConfiguration {
}
