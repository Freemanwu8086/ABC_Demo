package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    //管理员登陆
    Admin AdminLogin(Admin admin);
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    //修改某一曲谱信息（管理员）
    void updateMusicAdmin(Sheet_Music music);

    //删除某单一曲谱（管理员）
    void deleteOneAdmin(Integer id);

    //批量删除曲谱（管理员）
    void deleteListMusic(Integer[] id);
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    //展示所有用户（管理员）
    PageInfo<User> findAllUser(int pageNo);

    //修改某一用户信息（管理员）
    void updateUser(User user);

    //按id查找某用户
    User findUserById(Integer id);

    //删除某一用户（管理员）
    void deleteOneUser(User user);

    //模糊查询用户
    PageInfo<User> findUsersByUserName(int pageNo,String username);

    //全站通知
    void WholeSiteAnnouncement(String FirstPageAnnounce);

    //按节拍查询曲谱
    PageInfo<Sheet_Music> findMusicByBeat(int pageNo ,String beat);

    //按定调查询曲谱
    PageInfo<Sheet_Music> findMusicByTone(int pageNo,String tone);

    //组合查询
    PageInfo<Sheet_Music> CombinedFindMusic(int pageNo,Sheet_Music music);
}
