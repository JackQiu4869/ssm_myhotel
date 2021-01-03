package com.bdqn.controller.admin;

import com.bdqn.entity.MyOrder;
import com.bdqn.entity.Users;
import com.bdqn.service.OrderService;
import com.bdqn.service.UsersService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/myOrder")
public class OrderController {

    @Resource
    private OrderService orderService;

    //查询订单列表
    @RequestMapping("/list")
    public DataGridViewResult list(OrderVo vo){
        //设置分页信息
        PageHelper.startPage(vo.getPage(),vo.getLimit());

        //调用分页查询方法
        List<MyOrder> myOrderList = orderService.findOrderByPage(vo);
        //创建分页对象
        PageInfo<MyOrder> pageInfo =new PageInfo<MyOrder>(myOrderList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());

    }
}
