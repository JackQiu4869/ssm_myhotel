package com.bdqn.service;

import com.bdqn.entity.Users;
import com.bdqn.vo.UsersVo;

import java.util.List;

public interface UsersService {
    List<Users> findUsersByPage(UsersVo vo);

    int addUsers(Users users);

    Users findUsersByName(String loginName);

    int updateUsers(Users users);

    int deleteById(Integer id);

    Users frontLogin(String username,String password);

}
