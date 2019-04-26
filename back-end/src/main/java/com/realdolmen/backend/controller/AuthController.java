package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.impl.UserFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {
    private final UserFacadeImpl userFacade;

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDto logInUser(@RequestBody UserDto userDto) {
        return userFacade.findUserByUsername(userDto.getUsername());
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody @Valid UserDto userDto) {
        return userFacade.saveUser(userDto);
    }
}