package com.wills.bill.springbootbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillController {

    @GetMapping("/billList")
    public String getBillList(){
        return "bill/list";
    }
}
