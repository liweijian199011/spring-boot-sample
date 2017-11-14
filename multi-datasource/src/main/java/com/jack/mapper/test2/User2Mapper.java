package com.jack.mapper.test2;

import com.jack.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/11/14.
 *
 * @author liweijian.
 */
public interface User2Mapper {
    @SelectProvider(type = User2Provider.class, method = "selectUserByCondition")
    List<User> selectUserByCondition(User user);

    @UpdateProvider(type = User2Provider.class, method = "updateUserByPrimaryKey")
    Integer updateUserByPrimaryKey(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserByPrimaryKey(Integer id);

    @Insert("insert into user (username, password, age, gender) values (#{username}, #{password}, #{age}, #{gender})")
    Integer insert(User user);

    @Select("select * from user where id = #{id}")
    User selectByPrimaryKey(Long id);
}
