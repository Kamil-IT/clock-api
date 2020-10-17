package com.clock.clockapi.controller;

import com.clock.clockapi.api.v1.Delete;
import com.clock.clockapi.security.model.UserApp;
import com.clock.clockapi.security.model.UserAppDto;
import com.clock.clockapi.services.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@AllArgsConstructor
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("api/user")
@Api(tags = "User manager", value = "User Controller")
public class UserControllerImpl implements UserController<UserApp, UserAppDto> {

    private UserServiceImpl userService;

    @ApiOperation(value="Get User Details")
    @Override
    public UserApp getUserDetails(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }

    @ApiOperation(value="Post User Details")
    @Override
    public UserApp post(UserAppDto userApp, Principal principal) throws NotFoundException {
        String userId = userService.getUserByUsername(principal.getName()).getId();
        return userService.updateUser(userId, userApp);
    }

    @ApiOperation(value="Delete User")
    @Override
    public Delete delete(Principal principal) {
        try {
            userService.deleteUserById(
                    userService.getUserByUsername(principal.getName()).getId());
        } catch (NotFoundException e){
            return new Delete("404", "User with username " + principal.getName());
        }
        return new Delete("200", "Deleted user with username " + principal.getName());
    }
}
