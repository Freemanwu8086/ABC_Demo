package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.service.Sheet_MusicService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("music")
public class Sheet_MusicController {
    @Autowired
    private Sheet_MusicService musicService;

    @RequestMapping("/listMusicAdmin")
    public String getList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                          Map<String,Object> map, Model model){
        PageInfo<Sheet_Music> page = musicService.findAllMusic(pageNum);
        List<Sheet_Music> musics = page.getList();

        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindAllMusic";  //转发到你自己的页面
    }
}
