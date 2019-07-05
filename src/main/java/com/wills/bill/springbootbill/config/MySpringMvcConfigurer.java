package com.wills.bill.springbootbill.config;

import com.wills.bill.springbootbill.intercepter.LoginHandlerIntercepter;
import com.wills.bill.springbootbill.locale.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfigurer {
    /**
     * 两种方式实现视图控制
     * 1、实现WebMvcConfigurer接口，实现接口内的方法即可
     * 2、直接写上返回值，返回值内部实现接口的方法
     * @return
     */
    @Bean //向容器中添加实例
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //SpringBoot2+中要排除静态资源路径, 因访问时不会加/static，所以配置如下
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/", "/index.html", "/login","/logout","/css/**", "/img/**","/js/**");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
            }
        };
        return webMvcConfigurer;
    }
    //替换mvc中自动配置类中的区域解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
