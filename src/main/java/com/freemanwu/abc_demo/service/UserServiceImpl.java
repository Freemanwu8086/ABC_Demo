package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.UserDAO;
import com.freemanwu.abc_demo.entity.Sheet_Music;
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
    public User findByName(User user) {
        return userDAO.findByName(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public Sheet_Music findMusicByUserName(Sheet_Music music) {
        return userDAO.findMusicByUserName(music);
    }

    @Override
    public void updateMusicUser(Sheet_Music music) {
        userDAO.updateMusicUser(music);
    }
}
