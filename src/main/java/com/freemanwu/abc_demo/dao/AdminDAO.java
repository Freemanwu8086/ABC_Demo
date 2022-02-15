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

    //按id查找某用户
    User findUserById(Integer id);

    //修改某一用户信息（管理员）
    void updateUser(User user);

    //删除某一用户（管理员）
    void deleteOneUser(User user);

    //模糊查询用户
    List<User> findUsersByUserName(String username);

    //全站通知
    void WholeSiteAnnouncement(String FirstPageAnnounce);

    //按节拍查询曲谱
    List<Sheet_Music> findMusicByBeat(String beat);

    //按定调查询曲谱
    List<Sheet_Music> findMusicByTone(String Tone);

    //组合查询
    List<Sheet_Music> CombinedFindMusic(Sheet_Music music);
}
