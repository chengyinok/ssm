package com.cheng.mybatisplus.user.service.impl;

import com.cheng.mybatisplus.user.entity.User;
import com.cheng.mybatisplus.user.dao.UserDao;
import com.cheng.mybatisplus.user.service.UserService;
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
