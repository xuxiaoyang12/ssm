package com.mxiaixy.controller;

import com.mxiaixy.exception.NotFoundException;
import com.mxiaixy.pojo.Role;
import com.mxiaixy.pojo.User;
import com.mxiaixy.service.RoleService;
import com.mxiaixy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Mxia on 2017/1/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;



    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<User> userList = userService.findListUser();
        model.addAttribute("userList",userList);
        return "user/list";
    }


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        //查询所有角色
        List<Role> roleList = roleService.findRoleAll();
        model.addAttribute("roleList",roleList);
        return "user/add";
    }


    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String add(User user,String[] roleIds ,RedirectAttributes redirectAttributes){
        //保存数据
        userService.save(user,roleIds);
        redirectAttributes.addFlashAttribute("message","操作成功");
       return "redirect:/user";
    }


    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,Model model,RedirectAttributes redirectAttributes ){
        User user = userService.findUserById(id);
        if(user==null){
            throw new NotFoundException();
        }else{
            List<Role> roleList = roleService.findRoleAll();
            model.addAttribute("roleList",roleList);
            model.addAttribute("user",user);
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "user/edit";
    }
    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.POST)
    public String edit(User user,String[] roleIds, RedirectAttributes redirectAttributes){
        userService.update(user,roleIds);

        redirectAttributes.addFlashAttribute("message","编辑成功");
       return "redirect:/user";
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String del(@PathVariable Integer id,RedirectAttributes redirectAttributes){

        userService.delUserById(id);
        redirectAttributes.addFlashAttribute("message","操作成功");

        return "redirect:/user";
    }


}
