package com.wills.bill.springbootbill.controller;

import com.wills.bill.springbootbill.bean.Provider;
import com.wills.bill.springbootbill.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 供应商控制层类
 */
@Controller
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    //@ResponseBody
    @GetMapping({"/providers","/providerList"})
    public String listProviders(HttpServletRequest request){
        List<Provider> list = providerService.findAll();
        request.setAttribute("providers",list);
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String getProviderById(@PathVariable("pid")Integer pid,HttpServletRequest request){
        Provider p = providerService.findById(pid);
        if(p!=null){
            request.setAttribute("p",p);
            return "provider/view";
        }
        return "redirect:/providerList";
    }

    @GetMapping("/provider/update/{pid}")
    public String updateProvide(@PathVariable("pid")Integer pid,HttpServletRequest request){
        Provider p = providerService.findById(pid);
        if(p!=null){
            request.setAttribute("p",p);
            return "provider/update";
        }
        return "redirect:/providerList";
    }

    @PostMapping("/provider/updateP/{pid}")
    public String updateProvider(@PathVariable("pid")Integer pid,Provider provider){
        provider.setCreateDate(new Date());
        providerService.save(provider);
        return "redirect:/providerList";
    }

    @GetMapping("/provider/add")
    public String addView(){
        return "provider/add";
    }

    @PostMapping("/provider/insert")
    public String insertProvider(Provider provider,String describes){
        provider.setCreateDate(new Date());
        providerService.save(provider);
        return "redirect:/providerList";
    }

    @GetMapping("/provider/delete/{pid}")
    public String updateProvide(@PathVariable("pid")Integer pid){
        providerService.deleteById(pid);
        return "redirect:/providerList";
    }
}
