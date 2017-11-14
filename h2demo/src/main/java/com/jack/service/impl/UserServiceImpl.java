package com.jack.service.impl;

import com.jack.controller.UserPo;
import com.jack.entity.User;
import com.jack.dao.UserMapper;
import com.jack.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser(UserPo userPo) {
        User user = new User();
        BeanUtils.copyProperties(userPo, user);
        return userMapper.selectUserByCondition(user);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserByPrimaryKey(id);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserByPrimaryKey(user);
    }
}
