package com.realdolmen.backend.service;

import com.realdolmen.backend.advice.exception.NotFoundException;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {
    private final UserRepository userRepository;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User does not exist"));
    }
}