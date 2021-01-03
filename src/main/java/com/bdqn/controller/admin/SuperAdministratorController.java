package com.bdqn.controller.admin;


import com.bdqn.entity.SuperAdministrator;
import com.bdqn.service.SuperAdministratorService;
import com.bdqn.utils.SystemConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/superAdministrator")
public class SuperAdministratorController {


    @Resource
    private SuperAdministratorService superAdministratorService;


    @RequestMapping("/login")
    public Map<String,Object> login(String username, String password, HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        //调用管理员登录方法
        SuperAdministrator superAdministrator=superAdministratorService.login(username,password);

        //判断对象是否为空
        if (superAdministrator!=null){
            //保存当前用户
            session.setAttribute(SystemConstant.LOGINADMIN,superAdministrator);
            map.put(SystemConstant.SUCCESS,true);
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"账号密码错误，登录失败");
        }

        return map;
    }


}
