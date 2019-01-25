package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userFacade.findAllUsers();
    }
}
