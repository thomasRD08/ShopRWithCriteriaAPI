package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;

public class UserTestDataBuilder {
    public static User.UserBuilder buildUserKarel() {
        return User.builder()
                .username("Karel");
    }

    public static User.UserBuilder buildUserGuust() {
        return User.builder()
                .username("Guust");
    }

    public static UserDto.UserDtoBuilder buildUserDtoKarel() {
        return UserDto.builder()
                .username("Karel");
    }
}
