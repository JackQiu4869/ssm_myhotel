package com.bdqn.controller.admin;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Users;
import com.bdqn.service.UsersService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.utils.HashMapUtil;
import com.bdqn.utils.SystemConstant;
import com.bdqn.vo.UsersVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    private UsersService usersService;


    //查询用户列表
    @RequestMapping("/list")
    public DataGridViewResult list(UsersVo vo){
        //设置分页信息
        PageHelper.startPage(vo.getPage(),vo.getLimit());

        //调用分页查询方法
        List<Users> usersList= usersService.findUsersByPage(vo);
        //创建分页对象
        PageInfo<Users> pageInfo =new PageInfo<Users>(usersList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());

    }

    //修改用户信息
    @RequestMapping("/updateUsers")
    public String updateUsers(Users users){
        Map<String,Object> map=new HashMap<String, Object>();
        if (usersService.updateUsers(users)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

    //删除用户
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        /*Map<String,Object> map=new HashMap<String, Object>();
        if (usersService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);*/

        HashMapUtil hashMapUtil=new HashMapUtil();
        return hashMapUtil.checkDelete(usersService.deleteById(id));

    }




}
