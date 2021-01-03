package com.bdqn.service.impl;

import com.bdqn.dao.MenuMapper;
import com.bdqn.entity.Menu;
import com.bdqn.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;


    public List<Menu> findMenuList(){
        return menuMapper.findMenuList();
    }

}
