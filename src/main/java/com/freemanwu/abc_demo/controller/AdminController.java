package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.*;
import com.freemanwu.abc_demo.service.AdminService;
import com.freemanwu.abc_demo.service.AnnounceService;
import com.freemanwu.abc_demo.service.CommentService;
import com.freemanwu.abc_demo.service.Sheet_MusicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AnnounceService announceService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private Sheet_MusicService musicService;

    /**
     * 管理员登陆
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("adminLogin")
    public String AdminLogin(Admin admin, HttpSession session, Announce announce){
        Admin loginAdmin = adminService.AdminLogin(admin);
        if (loginAdmin != null){
            Announce anna= announceService.showAnnounce(announce);
            session.setAttribute("announce",anna);
            session.setAttribute("loginAdmin",loginAdmin);
            return "AdminFirst";
        }else
            return "error";
    }

    /**
     * 管理员删除单个曲谱
     * @param id
     * @return
     */
    @RequestMapping("adminDeleteOne")
    public String AdminDeleteOne(Integer id){
        adminService.deleteOneAdmin(id);
        return "redirect:/music/listMusicAdmin";
    }

    /**
     * 批量删除曲谱
     * @param id
     * @return
     */
    @RequestMapping("deleteByIds")
    public String deleteByIds(Integer[] id){
        adminService.deleteListMusic(id);
        return "redirect:/music/listMusicAdmin";
    }


//对用户操作

    /**
     * 展示全部用户
     * @param pageNum
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("listUsers")
    public String ListUsers(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                               Map<String,Object> map, Model model){
        PageInfo<User> page = adminService.findAllUser(pageNum);
        List<User> users = page.getList();

        model.addAttribute("users",users);
        map.put("page",page);
        return "AdminFindAllUser";
    }

    /**
     * 删除一个用户
     * @param user
     * @return
     */
    @RequestMapping("adminDeleteOneUser")
    public String adminDeleteOneUser(User user){
        adminService.deleteOneUser(user);
        return "redirect:/admin/listUsers";
    }

    /**
     * 更改用户信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateUser1")
    public String updateUser1(Integer id,Model model){
        User user = adminService.findUserById(id);
        model.addAttribute("user",user);
        return "AdminUpdateUser";
    }
    @RequestMapping("updateUser2")
    public String updateUser2(User user){
        adminService.updateUser(user);
        return "redirect:/admin/listUsers";
    }

    /**
     * 按用户名模糊查询用户
     * @param pageNum
     * @param map
     * @param model
     * @param username
     * @param session
     * @return
     */
    @RequestMapping("findUsersByUserName")
    public String findUsersByUserName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                      Map<String,Object> map, Model model, String username, HttpSession session){
        PageInfo<User> page = adminService.findUsersByUserName(pageNum,username);
        List<User> users = page.getList();
        session.setAttribute("username",username);
        model.addAttribute("users",users);
        map.put("page",page);
        return "AdminFuzzyQueryUser";
    }

    /**
     * 管理员按节拍查询
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
        PageInfo<Sheet_Music> page = adminService.findMusicByBeat(pageNum,beat);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("beat",beat);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindMusicByBeat";
    }

    /**
     * 管理员按定调查询
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
        PageInfo<Sheet_Music> page = adminService.findMusicByTone(pageNum,tone);
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("tone",tone);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindMusicByTone";
    }

    /**
     * 管理员组合查询曲谱
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
        PageInfo<Sheet_Music> page = adminService.CombinedFindMusic(pageNum,music);
        String beat2 = music.getBeat();
        String tone2 = music.getTone();
        String music_name2 = music.getMusic_name();
        List<Sheet_Music> musics = page.getList();
        session.setAttribute("beat2",beat2);
        session.setAttribute("tone2",tone2);
        session.setAttribute("music_name2",music_name2);
        model.addAttribute("musics",musics);
        map.put("page",page);
        return "AdminFindMusicCombined";
    }


    @RequestMapping("newAnnounce")
    public String newAnnounce(){
        return "AdminUpdateAnnounce";
    }

    @RequestMapping("WholeSiteAnnounce")
    public String WholeSiteAnnounce(Announce announce,HttpSession session){
        adminService.WholeSiteAnnounce(announce);
        Announce anna= announceService.showAnnounce(announce);
        session.setAttribute("announce",anna);
        return "AdminFirst";
    }

    /**
     * 管理员曲谱按定调分类饼状图
     * @param model
     * @return
     */
    @RequestMapping("numbers")
    @ResponseBody
    public Integer[] numbers(Model model){
        Integer[] numberList = new Integer[21];
        numberList[0] = adminService.totalNumberOfA();
        numberList[1] = adminService.totalNumberOfUpA();
        numberList[2] = adminService.totalNumberOfbA();

        numberList[3] = adminService.totalNumberOfB();
        numberList[4] = adminService.totalNumberOfUpB();
        numberList[5] = adminService.totalNumberOfbB();

        numberList[6] = adminService.totalNumberOfC();
        numberList[7] = adminService.totalNumberOfUpC();
        numberList[8] = adminService.totalNumberOfbC();

        numberList[9] = adminService.totalNumberOfD();
        numberList[10] = adminService.totalNumberOfUpD();
        numberList[11] = adminService.totalNumberOfbD();

        numberList[12] = adminService.totalNumberOfE();
        numberList[13] = adminService.totalNumberOfUpE();
        numberList[14] = adminService.totalNumberOfbE();

        numberList[15] = adminService.totalNumberOfF();
        numberList[16] = adminService.totalNumberOfUpF();
        numberList[17] = adminService.totalNumberOfbF();

        numberList[18] = adminService.totalNumberOfG();
        numberList[19] = adminService.totalNumberOfUpG();
        numberList[20] = adminService.totalNumberOfbG();


        model.addAttribute("numberList",numberList);
        return numberList;
    }

    /**
     * 管理员曲谱按节拍分类饼状图
     * @return
     */
    @RequestMapping("beatsNumbers")
    @ResponseBody
    public String[] beatNumbers(){
        String[] beatList = new String[6];
        beatList[0] = adminService.totalBeatOf44();
        beatList[1] = adminService.totalBeatOf34();
        beatList[2] = adminService.totalBeatOf24();
        beatList[3] = adminService.totalBeatOf14();
        beatList[4] = adminService.totalBeatOf38();
        beatList[5] = adminService.totalBeatOf68();
        return beatList;
    }

    @RequestMapping("deleteOneComment")
    public String deleteOneComment(HttpSession session, Integer id,@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                                   Map<String,Object> map,Model model){
        commentService.deleteOneComment(id);
        Integer music_id = (Integer) session.getAttribute("music_id");
        Sheet_Music music = musicService.findMusicById(music_id);
        PageInfo<Comment> page = commentService.findAllComments(pageNum,music_id);
        List<Comment> comments = page.getList();
        model.addAttribute("music",music);
        model.addAttribute("comments",comments);
        map.put("page",page);
        return "AdminShowOneMusic";
    }
}
