package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.Admin;
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

    @RequestMapping("adminLogin")
    public String AdminLogin(Admin admin, HttpSession session){
        Admin loginAdmin = adminService.AdminLogin(admin);
        if (loginAdmin != null){
            session.setAttribute("loginAdmin",loginAdmin);
            return "AdminFirst";
        }else
            return "Error";
    }
}
