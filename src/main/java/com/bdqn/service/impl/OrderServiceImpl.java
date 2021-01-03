package com.bdqn.service.impl;

import com.bdqn.dao.OrderMapper;
import com.bdqn.dao.UsersMapper;
import com.bdqn.entity.MyOrder;
import com.bdqn.service.OrderService;
import com.bdqn.vo.OrderVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    public List<MyOrder> findOrderByPage(OrderVo vo) {
        return orderMapper.findOrderByPage(vo);
    }
}
