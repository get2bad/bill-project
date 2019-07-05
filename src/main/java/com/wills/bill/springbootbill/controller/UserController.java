package com.wills.bill.springbootbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping({"/userList"})
    public String userList(){
        return "user/list";
    }
}
