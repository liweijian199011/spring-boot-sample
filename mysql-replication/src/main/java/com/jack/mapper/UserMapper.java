package com.jack.mapper;

import com.jack.domain.User;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
public interface UserMapper {

    List<User> selectUserByCondition(User user);

    Integer updateUserByPrimaryKey(User user);

    Integer deleteUserByPrimaryKey(Integer id);

    Integer insert(User user);

    User selectByPrimaryKey(Long id);
}
