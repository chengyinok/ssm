package com.ssm.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ssm.user.entity.User;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author chengyin
 * @since 2017-08-19
 */
public interface UserDao extends BaseMapper<User> {

    int insertUser(User user);
}