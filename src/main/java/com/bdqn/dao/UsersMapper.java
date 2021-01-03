package com.bdqn.dao;

import com.bdqn.entity.Users;
import com.bdqn.vo.UsersVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    //根据页面查询用户
    List<Users> findUsersByPage(UsersVo vo);

    //用户注册
    int addUsers(Users users);

    //根据用户名查询用户
    Users findUsersByName(String loginName);

    //用户数据更新
    int updateUsers(Users users);

    //用户删除
    int deleteById(Integer id);

    //前台用户登录
    Users frontLogin(@Param("username")String username, @Param("password")String password);
}
