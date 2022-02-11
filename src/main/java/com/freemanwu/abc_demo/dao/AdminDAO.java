package com.freemanwu.abc_demo.dao;

import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@CacheNamespace
@Mapper
public interface AdminDAO {
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
    List<User> findAllUser();

    //修改某一用户信息（管理员）
    void updateUser(User user);

    //删除某一用户（管理员）
    void deleteOneUser(User user);
}
