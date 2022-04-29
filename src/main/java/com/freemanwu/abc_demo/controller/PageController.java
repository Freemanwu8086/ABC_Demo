package com.freemanwu.abc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author searchingwu
 * @Description
 * @create 2022-04-21 20:36
 */
@Controller
public class PageController {
    /**
     * 首页
     * @return
     */
    @GetMapping({"/","/index.html"})
    public String indexPage(){
        return "index";
    }

    /**
     * 用户注册页
     * @return
     */
    @GetMapping("/UserRegister.html")
    public String userRegisterPage(){
        return "UserRegister";
    }

    /**
     * 忘记密码页
     * @return
     */
    @GetMapping("/UserForgetPassword.html")
    public String UserForgetPasswordPage(){
        return "UserForgetPassword";
    }
}
