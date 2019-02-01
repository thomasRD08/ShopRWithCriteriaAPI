package com.realdolmen.backend.service;

import com.realdolmen.backend.advice.exception.NotFoundException;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {
    @Getter
    private final UserRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User does not exist"));
    }
}