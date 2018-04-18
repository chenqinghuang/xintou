package com.hn.sanya.xintou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hn.sanya.xintou.config.WebConfig;
import com.hn.sanya.xintou.controller.main.Annotatedtemplate;
import com.hn.sanya.xintou.dao.UserDao;
import com.hn.sanya.xintou.entity.User;
import com.hn.sanya.xintou.service.UserService;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
　　* @Description: 测试控制器
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/9 11:24
　　*/
@Controller
@RequestMapping(value ="user")
public class UserController {

    @Autowired
    private UserService userService;

  //首页
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
 /*
    //跳转到登录页面
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //跳转到登录页面
    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    @ResponseBody
    public boolean loginCheck(@RequestBody String json){



        return true;
    }*/

   /* @GetMapping("/index1")
    public String index1(@SessionAttribute(WebConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index1";
    }*/


    //跳转到登录页面
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    @ResponseBody
    public String loginCheck(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String a = "a";
        System.out.println(username);
        System.out.println(password);
        if (username == a) {

            return password;
        }else {
            return password;
        }
    }

}
