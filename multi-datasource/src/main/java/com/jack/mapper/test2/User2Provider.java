package com.jack.mapper.test2;

import com.jack.domain.User;
import org.springframework.util.StringUtils;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/11/14.
 *
 * @author liweijian.
 */
public class User2Provider {

    private static final String COLUMNS = "id, username, password, age, gender, create_time, update_time";

    private static final String TABLE = "user";

    public String selectUserByCondition(User user) {
        BEGIN();
        SELECT(COLUMNS);
        FROM(TABLE);
        if (user.getId() != null) {
            WHERE("id = #{id}");
        }
        if (!StringUtils.isEmpty(user.getUsername())) {
            WHERE("username like concat('%', #{username}, '%')");
        }
        if (!StringUtils.isEmpty(user.getPassword())) {
            WHERE("password like concat('%', #{password}, '%')");
        }
        if (user.getGender() != null) {
            WHERE("gender = #{gender}");
        }
        ORDER_BY("update_time desc");
        return SQL();
    }

    public String updateUserByPrimaryKey(User user) {
        BEGIN();
        UPDATE(TABLE);
        if (!StringUtils.isEmpty(user.getUsername())) {
            SET("username = #{username}");
        }
        if (!StringUtils.isEmpty(user.getPassword())) {
            SET("password = #{password}");
        }
        if (user.getGender() != null) {
            SET("gender = #{gender}");
        }
        if (user.getAge() != null) {
            SET("age = #{age}");
        }
        WHERE("id = #{id}");
        return SQL();
    }
}
