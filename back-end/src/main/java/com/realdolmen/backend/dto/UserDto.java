package com.realdolmen.backend.dto;

import com.realdolmen.backend.constraint.UniqueUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @UniqueUser
    private String username;
}
