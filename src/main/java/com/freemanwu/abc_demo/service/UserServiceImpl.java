package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.UserDAO;
import com.freemanwu.abc_demo.entity.Favorite;
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

    @Override
    public Integer totalNumberOfA() {
        return userDAO.totalNumberOfA();
    }

    @Override
    public Integer totalNumberOfB() {
        return userDAO.totalNumberOfB();
    }

    @Override
    public Integer totalNumberOfC() {
        return userDAO.totalNumberOfC();
    }

    @Override
    public Integer totalNumberOfD() {
        return userDAO.totalNumberOfD();
    }

    @Override
    public Integer totalNumberOfE() {
        return userDAO.totalNumberOfE();
    }

    @Override
    public Integer totalNumberOfF() {
        return userDAO.totalNumberOfF();
    }

    @Override
    public Integer totalNumberOfG() {
        return userDAO.totalNumberOfG();
    }

    @Override
    public Integer totalNumberOfUpA() {
        return userDAO.totalNumberOfUpA();
    }

    @Override
    public Integer totalNumberOfbA() {
        return userDAO.totalNumberOfbA();
    }

    @Override
    public Integer totalNumberOfUpB() {
        return userDAO.totalNumberOfUpB();
    }

    @Override
    public Integer totalNumberOfbB() {
        return userDAO.totalNumberOfbB();
    }

    @Override
    public Integer totalNumberOfUpC() {
        return userDAO.totalNumberOfUpC();
    }

    @Override
    public Integer totalNumberOfbC() {
        return userDAO.totalNumberOfbC();
    }

    @Override
    public Integer totalNumberOfUpD() {
        return userDAO.totalNumberOfUpD();
    }

    @Override
    public Integer totalNumberOfbD() {
        return userDAO.totalNumberOfbD();
    }

    @Override
    public Integer totalNumberOfUpE() {
        return userDAO.totalNumberOfUpE();
    }

    @Override
    public Integer totalNumberOfbE() {
        return userDAO.totalNumberOfbE();
    }

    @Override
    public Integer totalNumberOfUpF() {
        return userDAO.totalNumberOfUpF();
    }

    @Override
    public Integer totalNumberOfbF() {
        return userDAO.totalNumberOfbF();
    }

    @Override
    public Integer totalNumberOfUpG() {
        return userDAO.totalNumberOfUpG();
    }

    @Override
    public Integer totalNumberOfbG() {
        return userDAO.totalNumberOfbG();
    }

    @Override
    public String totalBeatOf44() {
        return userDAO.totalBeatOf44();
    }

    @Override
    public String totalBeatOf34() {
        return userDAO.totalBeatOf34();
    }

    @Override
    public String totalBeatOf24() {
        return userDAO.totalBeatOf24();
    }

    @Override
    public String totalBeatOf14() {
        return userDAO.totalBeatOf14();
    }

    @Override
    public String totalBeatOf38() {
        return userDAO.totalBeatOf38();
    }

    @Override
    public String totalBeatOf68() {
        return userDAO.totalBeatOf68();
    }

    @Override
    public void deleteAccount(String username) {
        userDAO.deleteAccount(username);
    }

    @Override
    public void UnNamedMusic(String username) {
        userDAO.UnNamedMusic(username);
    }

    @Override
    public Integer checkUserName(String username) {
        return userDAO.checkUserName(username);
    }

    @Override
    public void insertFavorite(Favorite favorite) {
        userDAO.insertFavorite(favorite);
    }

    @Override
    public PageInfo<Sheet_Music> showFavorite(String username,int pageNo) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = userDAO.showFavorite(username);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteOneCollection(Integer music_id, String username) {
        userDAO.deleteOneCollection(music_id, username);
    }

    @Override
    public void deleteListCollection(Integer[] music_id, String username) {
        userDAO.deleteListCollection(music_id, username);
    }
}
