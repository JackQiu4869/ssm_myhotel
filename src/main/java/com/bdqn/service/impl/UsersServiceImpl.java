package com.bdqn.service.impl;

import com.bdqn.dao.UsersMapper;
import com.bdqn.entity.Users;
import com.bdqn.service.UsersService;
import com.bdqn.vo.UsersVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    public List<Users> findUsersByPage(UsersVo vo) {
        return usersMapper.findUsersByPage(vo);
    }

    public int addUsers(Users users){
        return usersMapper.addUsers(users);
    }

    public Users findUsersByName(String loginName) {
        return usersMapper.findUsersByName(loginName);
    }

    public int updateUsers(Users users) {
        return usersMapper.updateUsers(users);
    }

    public int deleteById(Integer id) {
        return usersMapper.deleteById(id);
    }

    public Users frontLogin(String username, String password) {
        return usersMapper.frontLogin(username, password);
    }

}
