package com.test;

import com.dao.AcrossDao;
import com.dao.TrainDao;
import com.daoimpl.AcrossDaoImpl;
import com.model.Across;
import com.model.Train;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import static org.junit.Assert.*;

public class AcrossDaoImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
        System.out.println(ac.getBean("acrossdao"));

        AcrossDao acrossDao= (AcrossDao) ac.getBean("acrossdao");
        //Across across = new Across();
       /* across.setStation("北京");
        across.setNextStation("上海");
        across.setDistance(100.0);
        across.setTrainId("k999");*/
        //across=acrossDao.getByStation("杭州","上海","k111");
        //System.out.println(across.getTrainId()+across.getStation()+across.getNextStation()+"发车时间"+across.getArTime()+"到达时间"+across.getDeTime());
        //acrossDao.delete(across);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date leavetime = null;
        try {
            leavetime = df.parse("2018-01-10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date SDA = new java.sql.Date(leavetime.getTime());
        JSONArray trainArray = new JSONArray();
        trainArray=acrossDao.selectmiddlestation("杭州","西藏",SDA);
        for (int i=0;i<trainArray.size();i++){
            System.out.println(trainArray.get(i));
        }

    }

}