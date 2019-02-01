package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void testShouldSaveUser() {
        // create data
        User expectedUser = new User("Karel");

        // mock repo
        when(userRepository.save(any())).thenReturn(expectedUser);

        // method to test
        User savedUser = userService.save(expectedUser);

        // verify and assert
        verify(userRepository, times(1)).save(expectedUser);
        assertEquals(expectedUser, savedUser);
    }

    @Test
    public void testShouldFindUserById() {
        User expectedUser = new User("Karel");

        when(userRepository.save(any())).thenReturn(expectedUser);
        when(userRepository.findById(any())).thenReturn(Optional.of(expectedUser));

        Long id = userService.save(expectedUser).getId();
        User foundUser = userService.findById(id);

        verify(userRepository, times(1)).save(expectedUser);
        verify(userRepository, times(1)).findById(id);
        assertEquals(expectedUser, foundUser);
    }

    @Test
    public void testShouldFindUserByUsername() {
        User expectedUser = new User("Karel");

        when(userRepository.save(any())).thenReturn(expectedUser);
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(expectedUser));

        String username = userService.save(expectedUser).getUsername();
        User foundUser = userService.findByUsername(username);

        verify(userRepository, times(1)).save(expectedUser);
        verify(userRepository, times(1)).findByUsername(username);
        assertEquals(expectedUser, foundUser);
    }

    @Test
    public void testShouldFindAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Karel"));
        users.add(new User("Guust"));

        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = userService.findAll();

        verify(userRepository, times(1)).findAll();
        assertEquals(2, foundUsers.size());
    }

    @Test
    public void testShouldDeleteUser() {
        User user = new User("Karel");

        userService.delete(user);

        verify(userRepository, times(1)).delete(user);
    }
}