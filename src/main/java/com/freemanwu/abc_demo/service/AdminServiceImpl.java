package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.AdminDAO;
import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin AdminLogin(Admin admin) {
        return adminDAO.AdminLogin(admin);
    }

    @Override
    public void updateMusicAdmin(Sheet_Music music) {
        adminDAO.updateMusicAdmin(music);
    }

    @Override
    public void deleteOneAdmin(Sheet_Music music) {
        adminDAO.deleteOneAdmin(music);
    }

    @Override
    public void deleteListMusic(Integer[] id) {
        adminDAO.deleteListMusic(id);
    }

    @Override
    public List<User> findAllUser() {
        return adminDAO.findAllUser();
    }

    @Override
    public void updateUser(User user) {
        adminDAO.updateUser(user);
    }

    @Override
    public void deleteOneUser(User user) {
        adminDAO.deleteOneUser(user);
    }
}
