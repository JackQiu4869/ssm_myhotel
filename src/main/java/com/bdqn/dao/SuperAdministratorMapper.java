package com.bdqn.dao;


import com.bdqn.entity.SuperAdministrator;

public interface SuperAdministratorMapper {

    //根据登录管理员账号查询
    SuperAdministrator findAdminByLoginName(String loginName);

}
