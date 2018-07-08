package com.dao;

import com.model.User;

public interface UserDao {
    //插入用户user
    public void insertUser(User user);
    //登录
    public User findUserById(String userName);
    //删除
    public void deleteUser(User user);
    //更新
    public void update(User user);
    //判断用户是否存在
    public boolean isExists(String userName, String userPw);
}
