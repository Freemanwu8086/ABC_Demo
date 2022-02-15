package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.UserDAO;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.freemanwu.abc_demo.utils.ConstantUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public void deleteOneUser(Integer id) {
        userDAO.deleteOneUser(id);
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
    public void forgetPassword(User user) {
        userDAO.forgetPassword(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteListMusic(Integer[] id) {
        userDAO.deleteListMusic(id);
    }

    @Override
    public void deleteOneMusicUser(Integer id) {
        userDAO.deleteOneMusicUser(id);
    }
    @Override
    public void updateMusicUser(Sheet_Music music) {
        userDAO.updateMusicUser(music);
    }

    @Override
    public PageInfo<Sheet_Music> findMusicByBeat(int pageNo,String beat) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = userDAO.findMusicByBeat(beat);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sheet_Music> findMusicByTone(int pageNo,String tone) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = userDAO.findMusicByTone(tone);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sheet_Music> CombinedFindMusic(int pageNo,Sheet_Music music) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = userDAO.CombinedFindMusic(music);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
