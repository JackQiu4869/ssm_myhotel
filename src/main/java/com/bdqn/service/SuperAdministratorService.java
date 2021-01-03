package com.bdqn.service;

import com.bdqn.entity.SuperAdministrator;

public interface SuperAdministratorService{

    //管理员登录
    SuperAdministrator login(String loginName,String loginPwd);
}
