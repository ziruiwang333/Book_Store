package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.pojo.User;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUserName(String username) {
        String sql = "SELECT id, username, `password`, email FROM t_user WHERE username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(username, password, email) VALUES(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        String sql = "SELECT id, username, `password`, email FROM t_user WHERE username=? and `password`=?";
        return queryForOne(User.class, sql, username, password);
    }
}
