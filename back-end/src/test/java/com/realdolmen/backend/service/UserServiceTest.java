package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserGuust;
import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserKarel;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void testSavesUser() {
        // create data
        User expectedUser = buildUserKarel().build();

        // mock repo
        when(userRepository.save(any())).thenReturn(expectedUser);

        // method to test
        User savedUser = userService.save(expectedUser);

        // verify and assert
        verify(userRepository, times(1)).save(expectedUser);
        assertEquals(expectedUser, savedUser);
    }

    @Test
    public void testFindsUserById() {
        User expectedUser = buildUserKarel().build();

        when(userRepository.save(any())).thenReturn(expectedUser);
        when(userRepository.findById(any())).thenReturn(Optional.of(expectedUser));

        Long id = userService.save(expectedUser).getId();
        User foundUser = userService.findById(id);

        verify(userRepository, times(1)).save(expectedUser);
        verify(userRepository, times(1)).findById(id);
        assertEquals(expectedUser, foundUser);
    }

    @Test
    public void testFindsUserByUsername() {
        User expectedUser = buildUserKarel().build();

        when(userRepository.save(any())).thenReturn(expectedUser);
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(expectedUser));

        String username = userService.save(expectedUser).getUsername();
        User foundUser = userService.findByUsername(username);

        verify(userRepository, times(1)).save(expectedUser);
        verify(userRepository, times(1)).findByUsername(username);
        assertEquals(expectedUser, foundUser);
    }

    @Test
    public void testFindsAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(buildUserKarel().build());
        users.add(buildUserGuust().build());

        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = userService.findAll();

        verify(userRepository, times(1)).findAll();
        assertEquals(2, foundUsers.size());
    }

    @Test
    public void testDeletesUser() {
        User user = buildUserKarel().build();

        userService.delete(user);

        verify(userRepository, times(1)).delete(user);
    }
}