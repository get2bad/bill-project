package com.wills.bill.springbootbill.intercepter;

import com.wills.bill.springbootbill.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerIntercepter implements HandlerInterceptor {
    //之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查User是否登录
        User user = (User)request.getSession().getAttribute("user");
        if(user !=null){
            return true;
        }
        //没有登录就返回登录界面
        request.setAttribute("msg","您的登录信息已过期！请重新登陆");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
    //正在
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
