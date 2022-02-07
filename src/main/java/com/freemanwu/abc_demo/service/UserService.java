package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;

public interface UserService {
    void register(User user);
    User findByNameAndPassword(User user);
    User findByName(User user);
    void update(User user);
    //个人曲谱查询（用户）
    Sheet_Music findMusicByUserName(Sheet_Music music);

    //个人曲谱修改（用户）
    void updateMusicUser(Sheet_Music music);
}
