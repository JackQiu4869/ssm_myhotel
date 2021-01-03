package com.bdqn.dao;

import com.bdqn.entity.MyOrder;
import com.bdqn.vo.OrderVo;



import java.util.List;

public interface OrderMapper {
    //根据页面查询订单
    List<MyOrder> findOrderByPage(OrderVo vo);
}
