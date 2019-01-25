package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.User;

public class UserTestDataBuilder {
    public static User.Builder buildUserKarel() {
        return User.builder()
                .username("Karel");
    }

    public static User.Builder buildUserGuust() {
        return User.builder()
                .username("Guust");
    }
}