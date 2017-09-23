package com.jack.service;

import com.jack.config.GlobalConfig;
import com.jack.domain.User;
import com.jack.mapper.UserMapper;
import com.jack.util.HostnameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/23.
 *
 * @author liweijian.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        if (!GlobalConfig.isOnline()) {
            logger.info("当前查询的主机名：{}", HostnameUtils.getHostname());
        }
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }
}
