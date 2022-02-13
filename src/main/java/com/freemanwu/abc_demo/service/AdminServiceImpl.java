package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.AdminDAO;
import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.freemanwu.abc_demo.utils.ConstantUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public void deleteOneAdmin(Integer id) {
        adminDAO.deleteOneAdmin(id);
    }

    @Override
    public void deleteListMusic(Integer[] id) {
        adminDAO.deleteListMusic(id);
    }

    @Override
    public void WholeSiteAnnouncement(String FirstPageAnnounce) {
        adminDAO.WholeSiteAnnouncement(FirstPageAnnounce);
    }

    @Override
    public PageInfo<User> findUsersByUserName(int pageNo,String username) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<User> list = adminDAO.findUsersByUserName(username);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public User findUserById(Integer id) {
        return adminDAO.findUserById(id);
    }

    @Override
    public PageInfo<User> findAllUser(int pageNo) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<User> list = adminDAO.findAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
