package com.wills.bill.springbootbill.controller;

import com.wills.bill.springbootbill.bean.User;
import com.wills.bill.springbootbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //主页信息使用视图解析器完成，具体请看MySpringMvcViewConfigurer

    @GetMapping({"/password"})
    public String changePassword(HttpSession session){
        /*Object user = session.getAttribute("user");
        System.out.println((User)user);*/
        return "main/password";
    }

    @GetMapping("/indexs")
    public String indexs(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        request.getSession().setMaxInactiveInterval(0);
        return "main/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request, Map<String,Object> map){
        List<User> allUser = userService.findAll();
        for (int i=0;i<allUser.size();i++){
            if((username.equals(allUser.get(i).getUsername()))&&password.equals(allUser.get(i).getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("user",new User(allUser.get(i).getId(),username,password));
                session.setMaxInactiveInterval(60*5);
                return "main/index";
            }else{
                continue;
            }
        }
        //request.setAttribute("msg","用户名/密码错误！");
        map.put("msg","用户名/密码错误！");
        //return "redirect:/index.html";
        return "main/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,HttpServletRequest request){
        session.setAttribute("user",null);
        session.setMaxInactiveInterval(0);
        request.setAttribute("msg","您已成功退出！");
        return "redirect:/indexs";
    }
}