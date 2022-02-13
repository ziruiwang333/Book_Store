package com.bookstore.test;

import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;
import com.bookstore.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUserName(){
        System.out.println(userDao.queryUserByUserName("admin"));
    }

    @Test
    public void queryUserByUserNameAndPassword(){
        System.out.println(userDao.queryUserByUserNameAndPassword("admin", "admin"));
    }

    @Test
    public void saveUser(){
        System.out.println(userDao.saveUser(new User("张三", "123456", "zhangsan@gmail.com")));
    }
}
