package com.cheng.user.service.impl;

import com.cheng.user.entity.User;
import com.cheng.user.dao.UserDao;
import com.cheng.user.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
