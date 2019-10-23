package com.tension.myblog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tension.myblog.Service.TypeService;
import com.tension.myblog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public void types(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                      @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize, Model model){

        //为了程序的严谨性，判断非空
        if(pageIndex == null || pageIndex <=0){
            pageIndex = 1;
        }
        if(pageSize == null ){
            pageSize = 4;
        }

        //startPage()函数执行后，要紧跟查询语句，这样才会生效
        //以下执行结果为：将查询到的所有元素放到list中，page中保存起始页数为pageIndex，条数为pageSize的那一页的元素
        PageHelper.startPage(pageIndex,pageSize);
        List<Type> list = typeService.AllTypes();
        PageInfo<Type> page = new PageInfo<>(list);


        if(page==null || list == null){
            System.out.println("传入参数为空");
        }
        else {
            model.addAttribute("pageInfo",page);
            model.addAttribute("list",list);
            System.out.println("传入参数page和list成功");
        }
        System.out.println(page);
        System.out.println(page.getList());
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "/admin/types-input";
    }

    @GetMapping("types/{id}/input")
    public String editInput(@PathVariable Integer id, Model model){
        model.addAttribute("type",typeService.getTypeByID(id));
        return "/admin/types-input";
    }

    //新增函数
    @PostMapping("/types")
    //Type类型和BindingResult要紧挨着，否则会校验失败
    public String post(Type type, BindingResult result, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if(type1 != null){
            result.rejectValue("name","nameError","该名称不能添加重复分类");
        }
        if(result.hasErrors()){
            return "/admin/types-input";
        }
        Type t = typeService.saveType(type);
        if(t == null){
            attributes.addFlashAttribute("message","新增失败");
        }
        else {
            attributes.addFlashAttribute("message","新增成功");

        }
        return "redirect:/admin/types";
    }

    //更新函数
    @PostMapping("/types/{id}")
    //Type类型和BindingResult要紧挨着，否则会校验失败
    public String editpost(Type type, BindingResult result,Integer id, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        System.out.println("type.getId():"+type.getId());
        if(type1 != null){
            result.rejectValue("name","nameError","该名称不能添加重复分类");
        }
        if(result.hasErrors()){
            return "/admin/types-input";
        }
        Type t = typeService.updateType(id,type);
        if(t == null){
            attributes.addFlashAttribute("message","更新失败");
        }
        else {
            attributes.addFlashAttribute("message","更新成功");

        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
