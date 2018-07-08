package com.test;

import com.DateJsonValueProcessor;
import com.dao.AcrossDao;
import com.dao.TrainDao;
import com.model.Across;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TrainDaoImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test() throws ParseException {
        ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
        TrainDao trainDao = (TrainDao)ac.getBean("traindao");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date leavetime = df.parse("2018-01-02");
        java.sql.Date SDA = new java.sql.Date(leavetime.getTime());
        System.out.println(SDA);
       /* JSONArray jsonArray = trainDao.selectTrain("杭州","上海",SDA);
        //System.out.println(jsonArray.toString());
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject);

            System.out.println(jsonObject.get("id"));
            JSONObject sdd = jsonObject.getJSONObject("Time");

            System.out.println(sdd.get("arTime"));
            System.out.println(sdd.get("deTime"));
            System.out.println(sdd.get("distance"));
           /* JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
            JSONObject jsonObj = JSONObject.fromObject(sdd.getJSONObject("arTime"), jsonConfig);
            System.out.println(jsonObj.toString());*/
        JSONArray train = trainDao.selectTrain("杭州","上海",SDA);
        AcrossDao acrossDao = (AcrossDao)ac.getBean("acrossdao");
        double path = 0,minpath=0;
        String trainId1 ="0";//最短路径对应的车次Id
        List<Across> acrosses;
        if (train.isEmpty()!=true)
        {

            for (int i=0;i<train.size();i++)
            {
                JSONObject train1 = train.getJSONObject(i);
                String trainId =(String)train1.get("id");
                acrosses=acrossDao.findAcross(trainId);
                int j=0;
                for (j=0;j<acrosses.size();j++)
                    if(acrosses.get(j).getStation()=="杭州")
                        break;
                while(acrosses.get(j).getNextStation()!="上海")
                {
                    path+=acrosses.get(j).getDistance();
                    j++;//往across表中存数据时按照车次所经站点依次顺序存储。
                }
                if (i==0)
                {
                    minpath=path;
                }
                if(path<minpath)
                {
                    minpath=path;
                    trainId1 =trainId;
                }
            }
            System.out.println(minpath);
            System.out.println(path);
            System.out.println(trainId1);
        }

        }
}