package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {
    private final UserFacade userFacade;

    @GetMapping(path = "/login")
    public UserDto logInUser(@RequestBody String username) {
        return userFacade.findUserByUsername(username);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        User user = userFacade.saveUser(userDto);
        return ResponseEntity.ok(user);
    }
}