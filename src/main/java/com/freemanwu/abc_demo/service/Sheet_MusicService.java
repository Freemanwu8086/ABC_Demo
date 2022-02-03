package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface Sheet_MusicService {
    //新增乐谱
    void save(Sheet_Music music);
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    //展示所有曲谱（管理员/用户）
    List<Sheet_Music> findAllMusic();

    //按名称模糊查询曲谱（管理员/用户）
    List<Sheet_Music> findByMusicName(Sheet_Music music);
}