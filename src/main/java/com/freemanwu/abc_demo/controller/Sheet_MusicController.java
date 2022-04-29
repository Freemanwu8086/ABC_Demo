package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.Announce;
import com.freemanwu.abc_demo.entity.Comment;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.freemanwu.abc_demo.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("music")
public class Sheet_MusicController {
    @Autowired
    private Sheet_MusicService musicService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private AnnounceService announceService;

    /**
     * 新建曲谱
     * @param music
     * @return
     */
    @RequestMapping("save")
    public String saveMusic(Sheet_Music music){
        musicService.save(music);
        return "redirect:/music/listMusicUser";
    }

    @RequestMapping("AdminABCEditor")
    public String AdminABCEditor(){
        return "AdminSaveABCSheet";
    }
    @RequestMapping("adminSaveMusic")
    public String adminSaveMusic(Sheet_Music music){
        musicService.adminSaveMusic(music);
        return "redirect:/music/listMusicAdmin";
    }

    /**
     * 管理员查询所有乐谱
     * @param pageNum
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("listMusicAdmin")
    public String getListAdmin(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                          Map<String,Object> map, Model model){
        PageInfo<Sheet_Music> page = musicService.findAllMusic(pageNum);
        List<Sheet_Music> musics = page.getList();

        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindAllMusic";
    }

    /**
     * 按状态查询
     * @param pageNum
     * @param map
     * @param model
     * @param state
     * @param session
     * @return
     */
    @RequestMapping("findByStates")
    public String getListByStateAdmin(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model,String state,HttpSession session){
        PageInfo<Sheet_Music> page = musicService.findMusicByState(pageNum,state);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("state",state);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindMusicByState";
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
        PageInfo<Sheet_Music> page = musicService.findAllMusicUser(pageNum);
        List<Sheet_Music> musics = page.getList();

        model.addAttribute("musics",musics);
        map.put("page",page);
        return "UserFindAllMusic";
    }

    /**
     * 游客模式
     * @param pageNum
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("tourist")
    public String touristFindAllMusic(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model,Announce announce,HttpSession session){
        Announce anna= announceService.showAnnounce(announce);
        session.setAttribute("announce",anna);
        PageInfo<Sheet_Music> page = musicService.findAllMusicUser(pageNum);
        List<Sheet_Music> musics = page.getList();

        model.addAttribute("musics",musics);
        map.put("page",page);
        return "TouristFindAllMusic";
    }
    /**
     * 游客按节拍查询
     * @param pageNum
     * @param map
     * @param model
     * @param beat
     * @param session
     * @return
     */
    @RequestMapping("findMusicByBeat")
    public String findMusicByBeat(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                  Map<String,Object> map, Model model, String beat, HttpSession session){
        PageInfo<Sheet_Music> page = userService.findMusicByBeat(pageNum,beat);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("beat",beat);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "TouristFindMusicByBeat";
    }

    /**
     * 游客按定调查询
     * @param pageNum
     * @param map
     * @param model
     * @param tone
     * @param session
     * @return
     */
    @RequestMapping("findMusicByTone")
    public String findMusicByTone(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                  Map<String,Object> map, Model model, String tone, HttpSession session){
        PageInfo<Sheet_Music> page = userService.findMusicByTone(pageNum,tone);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("tone",tone);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "TouristFindMusicByTone";
    }

    /**
     * 游客组合查询曲谱
     * @param pageNum
     * @param map
     * @param model
     * @param music
     * @param session
     * @return
     */
    @RequestMapping("CombinedFindMusic")
    public String CombinedFindMusic(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                    Map<String,Object> map, Model model, Sheet_Music music, HttpSession session){
        PageInfo<Sheet_Music> page = userService.CombinedFindMusic(pageNum,music);
        String beat1 = music.getBeat();
        String tone1 = music.getTone();
        String music_name1 = music.getMusic_name();
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("beat1",beat1);
        session.setAttribute("tone1",tone1);
        session.setAttribute("music_name1",music_name1);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "TouristFindMusicCombined";
    }

    /**
     * 游客查询单一曲谱
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("TouristFindMusicById")
    public String touristFindMusicById(Integer id, Model model,@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                       Map<String,Object> map, HttpServletRequest request){
        Sheet_Music music = musicService.findMusicById(id);
        PageInfo<Comment> page = commentService.findAllComments(pageNum,id);
        List<Comment> comments = page.getList();
        model.addAttribute("music",music);
        model.addAttribute("comments",comments);
        map.put("page",page);
        return "TouristShowOneMusic";
    }

    /**
     * 游客模糊查询
     * @param pageNum
     * @param map
     * @param model
     * @param music_name
     * @param session
     * @return
     */
    @RequestMapping("TouristFindByMusicName")
    public String touristFindByMusicName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model, String music_name, HttpSession session){
        PageInfo<Sheet_Music> page = musicService.findByMusicNameUser(pageNum,music_name);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("music_name",music_name);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "TouristFuzzyQueryMusic";
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

    /**
     * 用户按乐曲名模糊查询曲谱
     * @param pageNum
     * @param map
     * @param model
     * @param music_name
     * @param session
     * @return
     */
    @RequestMapping("UserFindByMusicName")
    public String userFindByMusicName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model, String music_name, HttpSession session){
        PageInfo<Sheet_Music> page = musicService.findByMusicNameUser(pageNum,music_name);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("music_name",music_name);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "UserFuzzyQueryMusic";
    }

    /**
     * 管理员展示单个乐谱（按id）
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("AdminFindMusicById")
    public String findMusicById(Model model,Integer id,@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                Map<String,Object> map, HttpServletRequest request, HttpSession session){
        Sheet_Music music = musicService.findMusicById(id);
        PageInfo<Comment> page = commentService.findAllComments(pageNum,id);
        List<Comment> comments = page.getList();
        session.setAttribute("music_id",id);
        model.addAttribute("music",music);
        model.addAttribute("comments",comments);
        map.put("page",page);
        return "AdminShowOneMusic";
    }

    /**
     * 用户展示单个乐谱（按id）
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("UserFindMusicById")
    public String UserFindMusicById(Model model, Integer id,@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                    Map<String,Object> map, HttpServletRequest request,HttpSession session){
        Sheet_Music music = musicService.findMusicById(id);
        PageInfo<Comment> page = commentService.findAllComments(pageNum,id);
        List<Comment> comments = page.getList();
        model.addAttribute("music",music);
        model.addAttribute("comments",comments);
        map.put("page",page);
        return "UserShowOneMusic";
    }

    /**
     * 管理员更新曲谱
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("updateMusicAdmin1")
    public String updateMusicAdmin1(Model model, Integer id){
        Sheet_Music music = musicService.findMusicById(id);
        model.addAttribute("music",music);
        return "AdminUpdateMusic";
    }
    @RequestMapping("updateMusicAdmin2")
    public String updateMusicAdmin2(Sheet_Music music, User user){
        musicService.updateMusicAdmin(music);
        adminService.musicAnnounce(user);
        return "redirect:/music/listMusicAdmin";
    }

    /**
     * 用户查询个人曲谱
     * @param pageNum
     * @param map
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("listPersonalMusic")
    public String findByMusicUserName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model, HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        PageInfo<Sheet_Music> page = musicService.findByMusicUserName(pageNum,username);
        List<Sheet_Music> musics = page.getList();
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "UserPersonalMusic";
    }

    /**
     * 用户更改自己个人乐谱
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("updateMusicUser1")
    public String updateMusicUser1(Model model, Integer id){
        Sheet_Music music = musicService.findMusicById(id);
        model.addAttribute("music",music);
        return "UserUpdateMusic";
    }
    @RequestMapping("updateMusicUser2")
    public String updateMusicUser2(Sheet_Music music){
        musicService.updateMusicUser(music);
        return "redirect:/music/listPersonalMusic";
    }

    /**
     * 用户保存评论
     * @param comment
     * @param model
     * @param pageNum
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("saveComment")
    public String saveComment(Comment comment,Model model,@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                              Map<String,Object> map, HttpServletRequest request){
        commentService.saveComment(comment);
        Integer id = comment.getMusic_id();
        Sheet_Music music = musicService.findMusicById(id);
        PageInfo<Comment> page = commentService.findAllComments(pageNum,id);
        List<Comment> comments = page.getList();
        model.addAttribute("music",music);
        model.addAttribute("comments",comments);
        map.put("page",page);
        return "UserShowOneMusic";
    }

}
