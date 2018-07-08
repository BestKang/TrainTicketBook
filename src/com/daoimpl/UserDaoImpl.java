package com.daoimpl;

import com.dao.UserDao;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Qualifier("sessionFactory")

    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void insertUser(User user) {
        //System.out.println(user.getUserName()+user.getUserPw());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

    }

    @Override
    public boolean isExists(String userName, String userPw) {
        List list = sessionFactory.openSession().createQuery("from User where userName =? and userPw = ?").setString(0,userName).setString(1,userPw).list();
        if (list.size()<=0)
            return false;
        else
            return  true;
    }


    @Override
    public User findUserById(String userName) {
        User user =(User)sessionFactory.openSession().getSessionFactory().openSession().createQuery
                ("from User where userName =?").setString(0,userName).list().get(0);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();

    }

    @Override
    public void update(User user) {                                     //更新
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();

    }
}
