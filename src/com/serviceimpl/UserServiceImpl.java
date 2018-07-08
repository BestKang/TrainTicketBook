package com.serviceimpl;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public UserDao getUserDao() {
        return this.userDao;
    }

    @Override
    public void setUserDao(UserDao dao) {
        this.userDao = dao;

    }
    @Override
    public void insertUser(User stu) {
        this.userDao.insertUser(stu);
    }

    @Override
    public boolean isExists(String userName, String userPw) {
        return this.userDao.isExists(userName,userPw);
    }

    @Override
    public User findUserById(String userName) {
        return this.userDao.findUserById(userName);
    }

    @Override
    public void update(User stu) {
        this.userDao.update(stu);
    }

    @Override
    public void deleteUser(User stu) {
        this.userDao.deleteUser(stu);
    }


}
