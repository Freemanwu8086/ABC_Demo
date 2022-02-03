package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.Sheet_MusicDAO;
import com.freemanwu.abc_demo.entity.Sheet_Music;
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
    public List<Sheet_Music> findAllMusic() {
        return musicDAO.findAllMusic();
    }

    @Override
    public List<Sheet_Music> findByMusicName(Sheet_Music music) {
        return musicDAO.findByMusicName(music);
    }
}
