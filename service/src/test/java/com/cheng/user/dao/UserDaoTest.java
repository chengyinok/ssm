package com.cheng.user.dao;

import com.cheng.base.BaseDaoTest;
import com.cheng.user.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by chengyin on 2017/8/19.
 */

public class UserDaoTest  extends BaseDaoTest{

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
//        User user = userDao.selectById(1);
//        System.out.println(user);
    }
}