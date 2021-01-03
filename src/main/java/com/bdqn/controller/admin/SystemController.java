package com.bdqn.controller.admin;

import com.bdqn.utils.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class SystemController {

    //跳转到登录页面
    @RequestMapping("/login.html")
    public String login(){
        return "admin/login";
    }

    //跳转到后台首页
    @RequestMapping("home.html")
    public String home(){
        return "admin/home";
    }


    //首页显示欢迎界面
    @RequestMapping("/desktop")
    public String desktop(){
        return "admin/welcomeManager/welcome";
    }


    //管理员退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(SystemConstant.LOGINADMIN);
        return "redirect:/admin/login.html";//重定向到登录页面
    }

    //用户管理页面
    @RequestMapping("toUserManager")
    public String toUserManager(){
        return "admin/userManager/table";
    }

    //房型管理页面
    @RequestMapping("toRoomTypeManager")
    public String toRoomTypeManager(){
        return "admin/roomTypeManager/myRoomType";
    }

    //评价管理页面
    @RequestMapping("toCommentManager")
    public String toCommentManager(){
        return "admin/commentManager/myComment";
    }

    //订单管理界面
    @RequestMapping("toOrderManager")
    public String toOrderManager(){
        return "admin/orderManager/MyOrder";
    }

}
