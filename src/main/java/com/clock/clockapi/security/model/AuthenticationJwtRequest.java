package com.clock.clockapi.security.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User authentication credentials request")
public class AuthenticationJwtRequest {

    @ApiModelProperty(required = true)
    private String username;
    @ApiModelProperty(required = true)
    private String password;
}
