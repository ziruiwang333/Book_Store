package com.bookstore.service;

import com.bookstore.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public abstract void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public abstract User login(User user);

    /**
     * 检查用户名是否可用
     * @param name
     * @return 返回True表示用户名已存在, 返回False表示用户名可用
     */
    public abstract boolean existsUserName(String name);
}
