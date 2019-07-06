package com.wills.bill.springbootbill.controller;

import com.wills.bill.springbootbill.bean.Bill;
import com.wills.bill.springbootbill.bean.Provider;
import com.wills.bill.springbootbill.service.BillService;
import com.wills.bill.springbootbill.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class BillController {

    @Autowired
    private BillService billService;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/billList")
    public String getBillList(HttpServletRequest request){
        List<Bill> all = billService.findAll();
        request.setAttribute("allBill",all);
        return "bill/list";
    }

    @GetMapping("/bill/view/{typee}/{bid}")
    public String viewById(@PathVariable("typee")Integer optionType,@PathVariable("bid")Integer bid,HttpServletRequest request){
        Bill bill = billService.findById(bid);
        Provider provider = providerService.findById(bill.getPid());
        List<Provider> providers = providerService.findAll();
        request.setAttribute("bill",bill);
        request.setAttribute("providerName1",provider.getProviderName());
        request.setAttribute("providers",providers);
        if(optionType ==1){
            return "bill/update";
        }
        return "bill/view";
    }

    @PostMapping("/bill/update/{typee}")
    public String save(@PathVariable("typee")Integer optionType,Bill bill){
        bill.setCreateDate(new Date());
        if(optionType ==1){
            //执行数据库更新操作
            billService.save(bill);
        }else{
            //执行数据库的插入操作
            billService.save(bill);
        }
        return "redirect:/billList";
    }

    @GetMapping("/bill/delete/{bid}")
    public String deleById(@PathVariable("bid")Integer bid){
            billService.deleteById(bid);
            return "redirect:/billList";
    }

    @GetMapping("/bill/insert")
    public String insert(HttpServletRequest request){
        List<Provider> providers = providerService.findAll();
        request.setAttribute("providers",providers);
        return "bill/add";
    }
}
