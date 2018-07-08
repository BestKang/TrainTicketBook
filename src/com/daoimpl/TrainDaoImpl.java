package com.daoimpl;

import com.dao.AcrossDao;
import com.dao.InfoDao;
import com.dao.TrainDao;
import com.model.Across;
import com.model.Info;
import com.model.Train;
import com.model.trainInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainDaoImpl implements TrainDao {
    private SessionFactory sessionFactory;
    private InfoDao infoDao;
    private AcrossDao acrossDao;
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    public InfoDao getInfoDao() {
        return infoDao;
    }

    public void setAcrossDao(AcrossDao acrossDao) {
        this.acrossDao = acrossDao;
    }

    public AcrossDao getAcrossDao() {
        return acrossDao;
    }

    @Override
    public void addTrain(Train train) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(train);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Train train) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(train);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateTrain(Train train) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(train);
        transaction.commit();
        session.close();
    }

    @Override
    public Train getByTrainId(String trainId) {
        Session session = sessionFactory.openSession();
        Train train = session.get(Train.class,trainId);
        session.close();
        return train;
    }

    @Override
    public JSONArray selectTrain(String from, String to, Date statTime) {
        JSONArray trainArray = new JSONArray();
        Session session = sessionFactory.openSession();
        //找到从出发地到目的地的车次号
        String hql = "from Train where  stopStaion like '%"+from+'%'+to +"%' and DATE_FORMAT(statTime,'%Y-%m-%d') =?";
        List<Train> list = (List<Train>)session.createQuery(hql).setDate(0,statTime).list();
        System.out.println("TrainDaoImpl测试语句"+hql.toString());
       // System.out.println("111111调用了"+list.get(0).getTrainId());
        System.out.println("TrainDaoImpl测试语句list大小"+list.size());
        for (int i = 0;i<list.size();i++){
            Train train = list.get(i);
            System.out.println(train.getTrainId());
        }
        for (int i = 0;i<list.size();i++) {
            Train train = list.get(i);                                                  //获取list中对象
            System.out.println("调用了"+list.get(i).getTrainId());
            JSONObject trainJObj = new JSONObject();
            trainJObj.put("id", train.getTrainId());////车次id                        //存入json
            //JSONObject info = infoDao.getInfoByName2(from,to);      //
            Info info1 = infoDao.getInfoByName3(from,to);
            Across across = acrossDao.getByStation(from,to,train.getTrainId());
            trainJObj.put("from",info1.getStationA());
            trainJObj.put("to",info1.getStationB());
            trainJObj.put("price",info1.getTicketprice());
            SimpleDateFormat sdf =   new SimpleDateFormat( "MM-dd HH:mm" );         //时间格式化
            System.out.println("测试输出arTime"+across.getArTime());
            String str = sdf.format(across.getArTime());
            trainJObj.put("arTime",str);
            String str2 = sdf.format(across.getDeTime());
            trainJObj.put("deTime",str2);
            trainJObj.put("distance",across.getDistance());
            trainArray.add(i,trainJObj);                            //放入jsonarray
            /*trainJObj.put("DistanceAndPrice",info);           //车票价钱 含出发站和目的站
            trainJObj.put("Time",across);                     //出发时间和到达时间  含出发站和目的站 车次号  距离
            trainArray.add(i,trainJObj);*/
           /* trainInfo trainInfo = new trainInfo();
            trainInfo.setTrainId(train.getTrainId());
            trainInfo.setStationA(info.get("stationA").toString());
            trainInfo.setStationB(info.get("stationB").toString());
            trainInfo.setDistance(across.getDistance());
            trainInfo.setArTime(across.getArTime());
            trainInfo.setDeTime(across.getDeTime());
            //trainInfo.setTicketprice(info.get("price").toString());
            trainArray.add(i,trainInfo);*/
        }
        session.close();
        System.out.println("来自daoImpl"+trainArray);
        return trainArray;

    }


    @Override
    public String selectTrain2(String from, String to, Date statTime) {
        JSONArray trainArray = new JSONArray();
        Session session = sessionFactory.openSession();
        //找到从出发地到目的地的车次号
        String hql = "from Train where  stopStaion like '%"+from+'%'+to +"%' and DATE_FORMAT(statTime,'%Y-%m-%d') =?";
        List<Train> list = (List<Train>)session.createQuery(hql).setDate(0,statTime).list();
        System.out.println(hql.toString());
        // System.out.println("111111调用了"+list.get(0).getTrainId());
        System.out.println(list.size());
        for (int i = 0;i<list.size();i++){
            Train train = list.get(i);
            System.out.println(train.getTrainId());
        }
        Map map_All=new HashMap();
        for (int i = 0;i<list.size();i++) {
            Train train = list.get(i);
            System.out.println("调用了"+list.get(i).getTrainId());
            JSONObject trainJObj = new JSONObject();
            trainJObj.put("id", train.getTrainId());////车次id
            //JSONObject info = infoDao.getInfoByName2(from,to);      //
            Info info1 = infoDao.getInfoByName3(from,to);
            Across across = acrossDao.getByStation(from,to,train.getTrainId());
            trainInfo trainInfo = new trainInfo();
            trainInfo.setTrainId(train.getTrainId());
            trainInfo.setStationA(info1.getStationA());
            trainInfo.setStationB(info1.getStationB());
            trainInfo.setDistance(across.getDistance());
            trainInfo.setArTime(across.getArTime());
            trainInfo.setDeTime(across.getDeTime());
            trainInfo.setTicketprice(info1.getTicketprice());
            map_All.put(i,trainInfo);
        }
        JSONObject jo_All = JSONObject.fromObject(map_All);
        System.out.println("不会做的啊"+jo_All.toString());
        return jo_All.toString();
    }

}




