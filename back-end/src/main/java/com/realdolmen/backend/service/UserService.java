package com.realdolmen.backend.service;

import com.realdolmen.backend.advice.exception.CustomNotFoundException;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements CrudService<User, Long> {
    private final UserRepository userRepository;

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findById(Long primaryKey) {
        return userRepository.findById(primaryKey)
                .orElseThrow(() -> new CustomNotFoundException("User does not exist"));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomNotFoundException("User does not exist"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }
}