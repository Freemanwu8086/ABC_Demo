package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.Admin;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
}
