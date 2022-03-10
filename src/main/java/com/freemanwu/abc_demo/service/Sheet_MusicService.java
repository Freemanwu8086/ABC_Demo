package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface Sheet_MusicService {
    //新增乐谱
    void save(Sheet_Music music);
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    //展示所有曲谱（管理员/用户）
    PageInfo<Sheet_Music> findAllMusic(int pageNo);

    //管理员按曲谱状态查询
    PageInfo<Sheet_Music> findMusicByState(int pageNo,String state);

    //按名称模糊查询曲谱（管理员/用户）
    PageInfo<Sheet_Music> findByMusicName(int pageNo,String music_name);

    //展示所有曲谱（用户）
    PageInfo<Sheet_Music> findAllMusicUser(int pageNo);

    //按名称模糊查询曲谱（用户）
    PageInfo<Sheet_Music> findByMusicNameUser(int pageNo, String music_name);

    //按id查询乐谱（管理员/用户）
    Sheet_Music findMusicById(Integer id);

    //修改曲谱信息（管理员）
    void updateMusicAdmin(Sheet_Music music);

    //修改曲谱信息（用户）
    void updateMusicUser(Sheet_Music music);

    //用户查询个人曲谱
    PageInfo<Sheet_Music> findByMusicUserName(int pageNo,String username);
}
