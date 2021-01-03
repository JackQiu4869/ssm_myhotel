package com.bdqn.service;

import com.bdqn.entity.MyOrder;
import com.bdqn.vo.OrderVo;


import java.util.List;

public interface OrderService {
    List<MyOrder> findOrderByPage(OrderVo vo);
}
