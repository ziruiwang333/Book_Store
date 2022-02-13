package com.bookstore.test;

import com.bookstore.pojo.User;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser(){
        userService.registerUser(new User("UserServiceTest", "123456", "ust@ust.com"));
    }

    @Test
    public void login(){
        System.out.println(userService.login(new User("张三", "123456", null)));
    }

    @Test
    public void existsUserName(){
        System.out.println(userService.existsUserName("admin"));
    }
}
