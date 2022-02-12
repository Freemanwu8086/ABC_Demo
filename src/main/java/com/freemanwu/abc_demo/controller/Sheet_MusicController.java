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

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("music")
public class Sheet_MusicController {
    @Autowired
    private Sheet_MusicService musicService;

    /**
     * 管理员查询所有乐谱
     * @param pageNum
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("/listMusicAdmin")
    public String getListAdmin(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                          Map<String,Object> map, Model model){
        PageInfo<Sheet_Music> page = musicService.findAllMusic(pageNum);
        List<Sheet_Music> musics = page.getList();

        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindAllMusic";  //转发到你自己的页面
    }

    /**
     * 用户查询所有乐谱
     * @param pageNum
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("listMusicUser")
    public String getListUser(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                              Map<String,Object> map, Model model){
        PageInfo<Sheet_Music> page = musicService.findAllMusic(pageNum);
        List<Sheet_Music> musics = page.getList();

        model.addAttribute("musics",musics);
        map.put("page",page);
        return "UserFindAllMusic";
    }

    /**
     * 管理员按乐曲名模糊查询乐谱
     * @param pageNum
     * @param map
     * @param model
     * @param music_name
     * @param session
     * @return
     */
    @RequestMapping("findByMusicName")
    public String findByMusicNameAdmin(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                  Map<String,Object> map, Model model, String music_name, HttpSession session){
        PageInfo<Sheet_Music> page = musicService.findByMusicName(pageNum,music_name);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("music_name",music_name);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFuzzyQueryMusic";
    }

    @RequestMapping("userFindByMusicName")
    public String userFindByMusicName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model, String music_name, HttpSession session){
        PageInfo<Sheet_Music> page = musicService.findByMusicName(pageNum,music_name);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("music_name",music_name);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "UserFuzzyQueryMusic";
    }
}
