package com.tension.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tension.myblog.Exceptions.NotFoundException;

@Controller
public class IndexController {

    @RequestMapping("/")
    //方法在url里获取属性值，用PathVariable注解
    public String index(/*@PathVariable Integer id,@PathVariable String name*/){
        System.out.println("index()执行了");
        //int i = 9/0;
        //String blog = null;
        /*if(blog == null){
            throw  new NotFoundException("博客不存在");
        }*/
        return "index";
    }

    @RequestMapping("/blog")
    public String blog(){
        System.out.println("blg()执行了...");
        return "blog";
    }
}
