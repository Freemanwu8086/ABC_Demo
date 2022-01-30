package com.freemanwu.abc_demo.controller;

import com.freemanwu.abc_demo.entity.User;
import com.freemanwu.abc_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public String register(User user){
        userService.register(user);
        return "Welcome";
    }

    @RequestMapping("findByNameAndPassword")
    public String findByNameAndPassword(User user, HttpSession session, Model model){
       User loginUser = userService.findByNameAndPassword(user);
       if (loginUser != null){
           session.setAttribute("loginUser",loginUser);
//           model.addAttribute("loginUser",loginUser);
           return "First";
       }else
           return "Error";
    }

    @RequestMapping("findByName")
    public String findByName(User user){
        userService.findByName(user);
        return "UserHomePage";
    }

    @RequestMapping("First_Redirect")
    public String First_Redirect(User user){
        userService.findByName(user);
        return "First";
    }
}
