package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;

public interface UserService extends CrudService<User, Long>{
    User findByUsername(String username);
}
