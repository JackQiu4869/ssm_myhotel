package com.bdqn.service.impl;

import com.bdqn.dao.SuperAdministratorMapper;
import com.bdqn.entity.SuperAdministrator;
import com.bdqn.service.SuperAdministratorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class SuperAdministratorServiceImpl implements SuperAdministratorService {

    //注入数据
    @Resource
    private SuperAdministratorMapper superAdministratorMapper;

    public SuperAdministrator login(String loginName, String loginPwd) {
        //根据用户名接收对象
        SuperAdministrator superAdministrator=superAdministratorMapper.findAdminByLoginName(loginName);

        //判断对象是否为空

        if (superAdministrator!=null){
        //密码是否一致
            if (superAdministrator.getPassword().equals(loginPwd)){
                return superAdministrator;//登录成功
            }
        }

        //失败：账号不正确/密码不正确
        return null;
    }
}
