package com.bookstore.dao;

import com.bookstore.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回查询到的用户, 若无此用户返回null
     */
    public abstract User queryUserByUserName(String username);

    /**
     * 保存用户
     * @param user
     * @return
     */
    public abstract int saveUser(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 返回该用户, 若无此用户(用户名或密码错误)返回null
     */
    User queryUserByUserNameAndPassword(String username, String password);
}
