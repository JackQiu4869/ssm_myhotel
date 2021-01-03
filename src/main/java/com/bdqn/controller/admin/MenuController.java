package com.bdqn.controller.admin;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Menu;
import com.bdqn.service.MenuService;
import com.bdqn.utils.MenuNode;
import com.bdqn.utils.TreeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    //注入MenuService
    @Resource
    private MenuService menuService;

    //加载首页导航
    @RequestMapping("/loadMenuList")
    public String loadMenuList(){
        //创建Map集合保存菜单信息
        Map<String,Object> map= new LinkedHashMap<String,Object>();
        //创建集合保存info信息
        Map<String,Object> homeInfo= new LinkedHashMap<String,Object>();
        //创建集合保存logo信息
        Map<String,Object> logoInfo= new LinkedHashMap<String,Object>();
        //调用方法，查询菜单列表
        List<Menu> menuList=menuService.findMenuList();
       //保存菜单
        List<MenuNode> menuNodeList=new ArrayList<MenuNode>();



        for (Menu m:menuList){
            MenuNode menuNode=new MenuNode();
            menuNode.setHref(m.getHref());//连接地址
            menuNode.setIcon(m.getIcon());
            menuNode.setId(m.getId());
            menuNode.setPid(m.getPid());
            menuNode.setSpread(m.getSpread());
            menuNode.setTarget(m.getTarget());
            menuNode.setTitle(m.getTitle());//名称
            menuNodeList.add(menuNode);//添加对象到集合

        }



        //保存homeInfo
        homeInfo.put("title","首页");
        homeInfo.put("href","/admin/desktop");
        //保存logo
        logoInfo.put("title","住房管理系统");
        logoInfo.put("image","/statics/layui/images/logo.png");//图标
        logoInfo.put("href","/admin/home.html");//首页地址

        //将菜单信息添加到菜单集合
        map.put("menuInfo", TreeUtil.toTree(menuNodeList,0));
        map.put("homeInfo",homeInfo);
        map.put("logoInfo",logoInfo);

        return JSON.toJSONString(map);
    }

}
