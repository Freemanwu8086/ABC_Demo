package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.Announce;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.freemanwu.abc_demo.service.AdminService;
import com.freemanwu.abc_demo.service.AnnounceService;
import com.freemanwu.abc_demo.service.UserService;
import com.freemanwu.abc_demo.utils.ValidateImageCodeUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnnounceService announceService;
    @Autowired
    private AdminService adminService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    public String register(User user, HttpSession session){
        String sessionCode = (String) session.getAttribute("code");
        if (sessionCode.equalsIgnoreCase(sessionCode)){
            userService.register(user);
            return "Welcome";
        }else
        return "Error";
    }

    /**
     * 生成验证码
     * @param session
     * @param response
     * @throws IOException
     */
    @GetMapping("code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);
        //响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);
    }

    /**
     * 用户登陆
     * @param user
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("findByNameAndPassword")
    public String findByNameAndPassword(User user, Announce announce, HttpSession session, Model model){
       User loginUser = userService.findByNameAndPassword(user);
       String username = loginUser.getUsername();
       if (loginUser != null){
           session.setAttribute("loginUser",loginUser);
           session.setAttribute("username",username);
           Announce anna = announceService.showAnnounce(announce);
//           model.addAttribute("announce",anna);
           session.setAttribute("announce",anna);
//           model.addAttribute("User",loginUser);
           return "UserFirst";
       }else
           return "Error";
    }

    /**
     * 用户主页
     * @param user
     * @return
     */
    @RequestMapping("findByName")
    public String findByName(User user,Model model){
        User UserInfo = userService.findByName(user);
        model.addAttribute("Model_User_Info",UserInfo);
        return "UserHomePage";
    }

    /**
     * 用户返回主页重定向
     * @param user
     * @return
     */
    @RequestMapping("First_Redirect")
    public String First_Redirect(User user,Model model, Announce announce){
        User UserInfo = userService.findByName(user);
        Announce anna = announceService.showAnnounce(announce);
        model.addAttribute("announce",anna);
        model.addAttribute("Model_User_Info",UserInfo);
        return "UserFirst";
    }

    //用户信息更新

    /**
     * 用户更改个人信息
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("update1")
    public String update1(User user, Model model){
        User UserInfo = userService.findByName(user);
        model.addAttribute("Model_User_Info", UserInfo);
        return "UserChange";
    }

    @RequestMapping("update2")
    public String update2(User user, Model model){
        userService.update(user);
        User UserInfo = userService.findByName(user);
        model.addAttribute("Model_User_Info",UserInfo);
        return "UserHomePage";
    }

    /**
     * 用户新建乐谱
     * @return
     */
    @RequestMapping("ABCEditor")
    public String ABCEditor(){
        return "SaveABCSheet";
    }

    /**
     * 用户删除个人乐谱
     * @param id
     * @return
     */
    @RequestMapping("deleteOneUser")
    public String deleteOneUser(Integer id){
        userService.deleteOneUser(id);
        return "redirect:/music/listPersonalMusic";
    }

    /**
     * 用户批量删除个人乐谱
     * @param id
     * @return
     */
    @RequestMapping("deleteByIds")
    public String deleteByIds(Integer[] id){
        userService.deleteListMusic(id);
        return "redirect:/music/listPersonalMusic";
    }

    /**
     * 用户按节拍查询
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
        return "UserFindMusicByBeat";
    }

    /**
     * 用户按定调查询
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
        return "UserFindMusicByTone";
    }

    /**
     * 用户组合查询曲谱
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
        return "UserFindMusicCombined";
    }

    /**
     * 忘记密码
     * @param user
     * @return
     */
    @RequestMapping("forgetPassword")
    public String forgetPassword1(User user){
        userService.forgetPassword(user);
        return "Welcome";
    }

    /**
     * 用户按定调分类饼状图
     * @param model
     * @return
     */
    @RequestMapping("numbers")
    @ResponseBody
    public Integer[] numbers(Model model){
        Integer[] numberList = new Integer[7];
        numberList[0] = userService.totalNumberOfA();
        numberList[1] = userService.totalNumberOfB();
        numberList[2] = userService.totalNumberOfC();
        numberList[3] = userService.totalNumberOfD();
        numberList[4] = userService.totalNumberOfE();
        numberList[5] = userService.totalNumberOfF();
        numberList[6] = userService.totalNumberOfG();

        model.addAttribute("numberList",numberList);
        return numberList;
    }

    /**
     * 用户按节拍分类饼状图
     * @return
     */
    @RequestMapping("beatsNumbers")
    @ResponseBody
    public String[] beatNumbers(){
        String[] beatList = new String[4];
        beatList[0] = userService.totalBeatOf44();
        beatList[1] = userService.totalBeatOf34();
        beatList[2] = userService.totalBeatOf24();
        beatList[3] = userService.totalBeatOf14();
        return beatList;
    }

    /**
     * 用户注销
     * @return
     */
    @RequestMapping("deleteAccount1")
    public String deleteJump(){
        return "UserDeleteAccount";
    }

    @RequestMapping("deleteAccount2")
    public String deleteAccount(String username){
        userService.deleteAccount(username);
        userService.UnNamedMusic(username);
        return "Welcome";
    }


}
