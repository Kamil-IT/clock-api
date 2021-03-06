package com.clock.clockapi.security.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BadCredentialsResponse {

    public String message;
    private AuthenticationJwtRequest authenticationJwtRequest;

    @JsonGetter("userCredentials")
    public AuthenticationJwtRequest getAuthenticationJwtRequest() {
        return authenticationJwtRequest;
    }
}
