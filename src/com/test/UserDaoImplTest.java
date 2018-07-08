package com.test;

import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;
import com.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserDaoImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
        System.out.println( ac.getBean("userdao"));
        UserDao userDao = (UserDaoImpl)ac.getBean("userdao");
        User user = new User();
        user.setUserName("张");
        user.setUserPw("无敌好吧");
        //userDao.update(user);
       /* if (userDao.isExists("王","8888")){
            System.out.println("yes");
        }
        else
            System.out.println("no");*/
       //userDao.deleteUser(user);
       user=userDao.findUserById("王");
       System.out.println(user.getUserName()+user.getUserPw());
    }

}