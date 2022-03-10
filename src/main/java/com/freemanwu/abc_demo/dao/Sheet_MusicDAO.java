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
    //展示所有曲谱（管理员）
    List<Sheet_Music> findAllMusic();

    //管理员按曲谱状态查询
    List<Sheet_Music> findMusicByState(String state);

    //按名称模糊查询曲谱（管理员）
    List<Sheet_Music> findByMusicName(String music_name);

    //展示所有曲谱（用户）
    List<Sheet_Music> findAllMusicUser();

    //按名称模糊查询曲谱（用户）
    List<Sheet_Music> findByMusicNameUser(String music_name);

    //按id查询曲谱(管理员/用户)
    Sheet_Music findMusicById(Integer id);

    //修改曲谱信息（管理员）
    void updateMusicAdmin(Sheet_Music music);

    //修改曲谱信息（用户）
    void updateMusicUser(Sheet_Music music);

    //用户查询个人上传的曲谱（用户）
    List<Sheet_Music> findByMusicUserName(String username);
}
