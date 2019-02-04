package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.impl.UserFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserFacadeImpl userFacade;

    @GetMapping(path = "/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable String username) {
        return userFacade.findUserByUsername(username);
    }

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userFacade.findAllUsers();
    }
}
