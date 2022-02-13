package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.freemanwu.abc_demo.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登陆
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("adminLogin")
    public String AdminLogin(Admin admin, HttpSession session){
        Admin loginAdmin = adminService.AdminLogin(admin);
        if (loginAdmin != null){
            session.setAttribute("loginAdmin",loginAdmin);
            return "AdminFirst";
        }else
            return "Error";
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
    @RequestMapping("listUsers")
    public String ListUsers(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum,
                               Map<String,Object> map, Model model){
        PageInfo<User> page = adminService.findAllUser(pageNum);
        List<User> users = page.getList();

        model.addAttribute("users",users);
        map.put("page",page);
        return "AdminFindAllUser";
    }
    @RequestMapping("adminDeleteOneUser")
    public String adminDeleteOneUser(User user){
        adminService.deleteOneUser(user);
        return "redirect:/admin/listUsers";
    }
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
}
