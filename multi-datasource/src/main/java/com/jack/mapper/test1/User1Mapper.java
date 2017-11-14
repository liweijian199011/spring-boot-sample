package com.jack.mapper.test1;

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
public interface User1Mapper {

    @SelectProvider(type = User1Provider.class, method = "selectUserByCondition")
    List<User> selectUserByCondition(User user);

    @UpdateProvider(type = User1Provider.class, method = "updateUserByPrimaryKey")
    Integer updateUserByPrimaryKey(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserByPrimaryKey(Long id);

    @Insert("insert into user (username, password, age, gender) values (#{username}, #{password}, #{age}, #{gender})")
    Integer insert(User user);

    @Select("select * from user where id = #{id}")
    User selectByPrimaryKey(Long id);
}
