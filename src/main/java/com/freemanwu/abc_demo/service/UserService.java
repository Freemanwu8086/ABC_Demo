package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.User;

public interface UserService {
    void register(User user);
    User findByNameAndPassword(User user);

    void update(User user);
}
