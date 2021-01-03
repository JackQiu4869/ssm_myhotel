package com.bdqn.controller;


import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Comment;
import com.bdqn.entity.Users;
import com.bdqn.service.CommentService;
import com.bdqn.service.RoomService;
import com.bdqn.service.UsersService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.utils.SystemConstant;
import com.bdqn.vo.CommentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersRegisterController {

    @Resource
    private UsersService usersService;
    @Resource
    private RoomService roomService;
    @Resource
    private CommentService commentService;


    //注册
    @RequestMapping("/register")
    public String register(Users users){
        Map<String,Object> map=new HashMap<String, Object>();
        if (usersService.addUsers(users)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"注册成功");

        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"注册失败");
        }
        return JSON.toJSONString(map);
    }


    //验证用户是否已被使用
    @RequestMapping("/checkLoginName")
    public String checkLoginName(String loginName){
        Map<String,Object> map=new HashMap<String, Object>();
        String a=loginName;
        if (usersService.findUsersByName(loginName)!=null){
            map.put(SystemConstant.EXIST,true);
            map.put(SystemConstant.MESSAGE,"用户名已被使用");
        }else {
            map.put(SystemConstant.EXIST,false);
        }
        return JSON.toJSONString(map);
    }

    //用户登录
    @RequestMapping("/frontLoginEntry")
    public String frontLoginEntry(String name, String password, HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        Users loginUser=usersService.frontLogin(name, password);
        if (loginUser!=null){
            map.put(SystemConstant.SUCCESS,true);
            loginUser.setPassword(null);
            session.setAttribute(SystemConstant.LOGINUSER,loginUser);
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"用户名或密码错误");
        }
        return JSON.toJSONString(map);
    }

    //用户退房
    @RequestMapping("/logOut")
    public String logOut(int room_state){
        Map<String,Object> map=new HashMap<String, Object>();
        int c=room_state;
        if (roomService.findFrontLogout(room_state)!=null){
            int b;
            b=roomService.clearFrontLogout(room_state);
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"退房成功");
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"当前用户未入住");
        }
        return JSON.toJSONString(map);
    }

    //用户查看评价
    @RequestMapping("/checkComment")
    public DataGridViewResult checkComment(CommentVo vo){
        //设置分页信息
        PageHelper.startPage(vo.getPage(),vo.getLimit());

        //调用分页查询方法
        List<Comment> commentList= commentService.findCommentByPage(vo);
        //筛选出对应房型的评论


        //创建分页对象
        PageInfo<Comment> pageInfo =new PageInfo<Comment>(commentList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());

    }



}
