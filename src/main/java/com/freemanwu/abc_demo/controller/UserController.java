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

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    public String register(User user){
        userService.register(user);
        return "Welcome";
    }

    /**
     * 用户登陆
     * @param user
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("findByNameAndPassword")
    public String findByNameAndPassword(User user, HttpSession session, Model model){
       User loginUser = userService.findByNameAndPassword(user);
       if (loginUser != null){
           session.setAttribute("loginUser",loginUser);
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
    public String First_Redirect(User user,Model model){
        User UserInfo = userService.findByName(user);
        model.addAttribute("Model_User_Info",UserInfo);
        return "UserFirst";
    }

    //用户信息更新
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
}
