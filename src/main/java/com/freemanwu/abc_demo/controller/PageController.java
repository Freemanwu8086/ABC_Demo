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
    @GetMapping({"/","/index.html"})
    public String indexPage(){
        return "index";
    }

    @GetMapping("/UserRegister.html")
    public String userRegisterPage(){
        return "UserRegister";
    }

    @GetMapping("/UserForgetPassword.html")
    public String UserForgetPasswordPage(){
        return "UserForgetPassword";
    }
}
