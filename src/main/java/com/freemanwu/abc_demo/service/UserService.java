package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;

public interface UserService {
    void register(User user);
    User findByNameAndPassword(User user);
    User findByName(User user);
    void update(User user);


    //删除个人曲谱
    void deleteOneMusicUser(Integer id);
    //个人曲谱修改（用户）
    void updateMusicUser(Sheet_Music music);

    //删除某单一曲谱（用户）
    void deleteOneUser(Integer id);
    //批量删除曲谱（用户）
    void deleteListMusic(Integer[] id);
}
