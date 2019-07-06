package com.wills.bill.springbootbill.controller;

import com.wills.bill.springbootbill.bean.User;
import com.wills.bill.springbootbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"/userList"})
    public String userList(HttpServletRequest request){
        List<User> users = userService.findAll();
        request.setAttribute("users",users);
        return "user/list";
    }

    @GetMapping("/user/view/{typee}/{uid}")
    public String viewUser(@PathVariable("typee")Integer typee,@PathVariable("uid")Integer uid,HttpServletRequest request) {
        User user = userService.findById(uid);
        request.setAttribute("user", user);
        if (user != null) {
            if (typee == 1) {
                //查看
                return "user/view";
            } else {
                //修改
                return "user/update";
            }
        }
        return "redirect:/userList";
    }

    @GetMapping("/user/delete/{uid}")
    public String deleById(@PathVariable("uid")Integer uid){
        userService.deleteUserById(uid);
        return "redirect:/userList";
    }

    @GetMapping("/user/add")
    public String addUser(){
        return "user/add";
    }

    @PostMapping("/user/update/{typee}")
    public String save(@PathVariable("typee")Integer typee,User user){
        if(typee ==1){
            //执行更新操作
            userService.insertUser(user);
        }else{
            //执行插入操作
            userService.insertUser(user);
        }
        return "redirect:/userList";
    }

    @GetMapping("/user/modifyPassword")
    @ResponseBody
    public String modifyPassword(HttpServletRequest request, HttpServletResponse response){
        String password = request.getParameter("passwordd");
        User user = (User)request.getSession().getAttribute("user");
        String prePassword = user.getPassword()+"";
        if(prePassword.equals(password)){
            return "success";
        }else{
            return "faild";
        }
    }

    @PostMapping("/user/changePassword")
    public String changePassword(String password, HttpSession session){
        User user = (User)session.getAttribute("user");
        User byId = userService.findById(user.getId());
        byId.setPassword(password);
        userService.insertUser(byId);
        System.out.println(byId);
        return "redirect:/indexs";
    }
}
