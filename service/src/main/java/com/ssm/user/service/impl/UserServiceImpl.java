package com.ssm.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ssm.user.dao.UserDao;
import com.ssm.user.entity.User;
import com.ssm.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chengyin
 * @since 2017-08-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
	
}
