package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.Sheet_MusicDAO;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.utils.ConstantUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Sheet_MusicServiceImpl implements Sheet_MusicService {
    @Autowired
    private Sheet_MusicDAO musicDAO;
    @Override
    public void save(Sheet_Music music) {
        musicDAO.save(music);
    }

    @Override
    public PageInfo<Sheet_Music> findAllMusic(int pageNo) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = musicDAO.findAllMusic();
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sheet_Music> findMusicByState(int pageNo, String state) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = musicDAO.findMusicByState(state);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Sheet_Music findMusicById(Integer id) {
        return musicDAO.findMusicById(id);
    }

    @Override
    public PageInfo<Sheet_Music> findAllMusicUser(int pageNo) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = musicDAO.findAllMusicUser();
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updateMusicAdmin(Sheet_Music music) {
        musicDAO.updateMusicAdmin(music);
    }

    @Override
    public PageInfo<Sheet_Music> findByMusicUserName(int pageNo,String username) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = musicDAO.findByMusicUserName(username);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updateMusicUser(Sheet_Music music) {
        musicDAO.updateMusicUser(music);
    }

    @Override
    public PageInfo<Sheet_Music> findByMusicNameUser(int pageNo, String music_name) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = musicDAO.findByMusicNameUser(music_name);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sheet_Music> findByMusicName(int pageNo,String music_name) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Sheet_Music> list = musicDAO.findByMusicName(music_name);
        PageInfo<Sheet_Music> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
