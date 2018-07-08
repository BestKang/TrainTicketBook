package com.service;

import com.dao.UserDao;
import com.model.User;

public interface UserService {
    public UserDao getUserDao();
    public void setUserDao(UserDao dao);
    public boolean isExists(String userName, String userPw);            //判断是否存在
    public void insertUser(User stu);                               //插入
    public void deleteUser(User stu);                               //删除
    public void update(User stu);                               //更新
    public User findUserById(String userName);                          //查找
}
