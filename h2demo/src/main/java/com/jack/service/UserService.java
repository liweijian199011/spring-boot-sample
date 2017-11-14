package com.jack.service;

import com.jack.controller.UserPo;
import com.jack.entity.User;

import java.util.List;

/**
 * Description
 * <p>
 *     用户操作业务
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
public interface UserService {

    /**
     * 查询用户列表
     * @param userPo 查询条件
     * @return 用户列表
     */
    List<User> listUser(UserPo userPo);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 新增个数
     */
    Integer addUser(User user);

    /**
     * 根据id删除用户
     * @param id id
     * @return 删除个数
     */
    Integer deleteUserById(Integer id);

    /**
     * 根据id修改用户
     * @param user 修改信息
     * @return  修改个数
     */
    Integer updateUserById(User user);
}
