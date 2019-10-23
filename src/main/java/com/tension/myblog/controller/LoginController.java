package com.tension.myblog.controller;

import com.tension.myblog.Service.UserService;
import com.tension.myblog.entity.User;
import com.tension.myblog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public String loginPage(){
        System.out.println("loginPage()执行......");
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        User user = userService.checkUser(username, MD5Utils.code(password));
        if(user != null){
            session.setAttribute("user",user);
            System.out.println("登陆成功......");
            return "/admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名和密码错误");
            System.out.println("登陆失败......");

            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("logout()方法执行......");
        session.removeAttribute("user");
        return "redirect:/admin";
    }


}
