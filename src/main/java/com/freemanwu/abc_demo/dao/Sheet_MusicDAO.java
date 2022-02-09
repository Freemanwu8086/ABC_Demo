package com.freemanwu.abc_demo.dao;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@CacheNamespace
@Mapper
public interface Sheet_MusicDAO {
    //新增乐谱
    void save(Sheet_Music music);
//——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    //展示所有曲谱（管理员/用户）
    List<Sheet_Music> findAllMusic();

    //按名称模糊查询曲谱（管理员/用户）
    List<Sheet_Music> findByMusicName();
}
