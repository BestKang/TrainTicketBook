package com.test;

import com.dao.InfoDao;
import com.model.Info;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class InfoDaoImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
        System.out.println(ac.getBean("infodao"));
        InfoDao infoDao = (InfoDao)ac.getBean("infodao");
        Info info = infoDao.getInfoByName("广州","上海");
        System.out.println(info.getStationA()+info.getStationB()+info.getTicketprice());
    }

}