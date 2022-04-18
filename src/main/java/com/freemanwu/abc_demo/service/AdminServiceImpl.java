package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.AdminDAO;
import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Announce;
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
    public void musicAnnounce(User user) {
        adminDAO.musicAnnounce(user);
    }

    @Override
    public void WholeSiteAnnounce(Announce announce) {
        adminDAO.WholeSiteAnnounce(announce);
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

    @Override
    public PageInfo<Sheet_Music> findMusicByBeat(int pageNo, String beat) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = adminDAO.findMusicByBeat(beat);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sheet_Music> findMusicByTone(int pageNo, String tone) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = adminDAO.findMusicByTone(tone);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sheet_Music> CombinedFindMusic(int pageNo, Sheet_Music music) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = adminDAO.CombinedFindMusic(music);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer totalNumberOfA() {
        return adminDAO.totalNumberOfA();
    }

    @Override
    public Integer totalNumberOfB() {
        return adminDAO.totalNumberOfB();
    }

    @Override
    public Integer totalNumberOfC() {
        return adminDAO.totalNumberOfC();
    }

    @Override
    public Integer totalNumberOfD() {
        return adminDAO.totalNumberOfD();
    }

    @Override
    public Integer totalNumberOfE() {
        return adminDAO.totalNumberOfE();
    }

    @Override
    public Integer totalNumberOfF() {
        return adminDAO.totalNumberOfF();
    }

    @Override
    public Integer totalNumberOfG() {
        return adminDAO.totalNumberOfG();
    }

    @Override
    public Integer totalNumberOfUpA() {
        return adminDAO.totalNumberOfUpA();
    }

    @Override
    public Integer totalNumberOfbA() {
        return adminDAO.totalNumberOfbA();
    }

    @Override
    public Integer totalNumberOfUpB() {
        return adminDAO.totalNumberOfUpB();
    }

    @Override
    public Integer totalNumberOfbB() {
        return adminDAO.totalNumberOfbB();
    }

    @Override
    public Integer totalNumberOfUpC() {
        return adminDAO.totalNumberOfUpC();
    }

    @Override
    public Integer totalNumberOfbC() {
        return adminDAO.totalNumberOfbC();
    }

    @Override
    public Integer totalNumberOfUpD() {
        return adminDAO.totalNumberOfUpD();
    }

    @Override
    public Integer totalNumberOfbD() {
        return adminDAO.totalNumberOfbD();
    }

    @Override
    public Integer totalNumberOfUpE() {
        return adminDAO.totalNumberOfUpE();
    }

    @Override
    public Integer totalNumberOfbE() {
        return adminDAO.totalNumberOfbE();
    }

    @Override
    public Integer totalNumberOfUpF() {
        return adminDAO.totalNumberOfUpF();
    }

    @Override
    public Integer totalNumberOfbF() {
        return adminDAO.totalNumberOfbF();
    }

    @Override
    public Integer totalNumberOfUpG() {
        return adminDAO.totalNumberOfUpG();
    }

    @Override
    public Integer totalNumberOfbG() {
        return adminDAO.totalNumberOfbG();
    }

    @Override
    public String totalBeatOf44() {
        return adminDAO.totalBeatOf44();
    }

    @Override
    public String totalBeatOf34() {
        return adminDAO.totalBeatOf34();
    }

    @Override
    public String totalBeatOf24() {
        return adminDAO.totalBeatOf24();
    }

    @Override
    public String totalBeatOf14() {
        return adminDAO.totalBeatOf14();
    }

    @Override
    public String totalBeatOf38() {
        return adminDAO.totalBeatOf38();
    }

    @Override
    public String totalBeatOf68() {
        return adminDAO.totalBeatOf68();
    }
}
