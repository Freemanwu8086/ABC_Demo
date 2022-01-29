package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.UserDAO;
import com.freemanwu.abc_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public User findByNameAndPassword(User user) {
        return userDAO.findByNameAndPassword(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
