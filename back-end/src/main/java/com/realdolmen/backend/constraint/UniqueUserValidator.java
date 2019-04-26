package com.realdolmen.backend.constraint;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@AllArgsConstructor
public class UniqueUserValidator implements ConstraintValidator<UniqueUser, String> {
    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueUser constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findByUsername(username);

        return !user.isPresent();
    }
}
