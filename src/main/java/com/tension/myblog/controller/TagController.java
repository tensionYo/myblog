package com.tension.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tension.myblog.Service.TagService;
import com.tension.myblog.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public void tags(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                     @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize, Model model){
        //为了程序的严谨性，判断非空
        if(pageIndex == null || pageIndex <=0){
            pageIndex = 1;
        }
        if(pageSize == null ){
            pageSize = 4;
        }

        PageHelper.startPage(pageIndex,pageSize);
        List<Tag> list = tagService.AllTags();
        PageInfo<Tag> page = new PageInfo<>(list);

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

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "/admin/tags-input";
    }

    @GetMapping("/tags{id}/inpput")
    public String editInput(@PathVariable Integer id, Model model){
        model.addAttribute("tag",tagService.getTagByID(id));
        return "/admin/tags-input";
    }

    @PostMapping("/tags")
    public String post(Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if(tag1!=null){
            result.rejectValue("name","nameError","该名称不能添加重复标签");
        }
        if(result.hasErrors()){
            return "/admin/tags-imput";
        }
        Tag t = tagService.saveTag(tag);
        if(t == null){
            attributes.addFlashAttribute("message","新增失败");
        }
        else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editpost(Tag tag,BindingResult result,Integer id, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if(tag1!=null){
            result.rejectValue("name","nameError","该名称不能添加重复标签");
        }
        if(result.hasErrors()){
            return "/admin/tags-imput";
        }
        Tag t = tagService.updateTag(id,tag);
        if(t == null){
            attributes.addFlashAttribute("message","新增失败");
        }
        else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}
