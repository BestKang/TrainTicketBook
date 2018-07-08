package com.daoimpl;

import com.dao.InfoDao;
import com.model.Info;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.annotation.Resource;

public class InfoDaoImpl implements InfoDao {
    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    @Override
    public void addInfo(Info info) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(info);
        transaction.commit();
    }

    @Override
    public void delete(Info info) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(info);
        transaction.commit();
    }

    @Override
    public void updateInfo(Info info) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(info);
        transaction.commit();
    }

    @Override
    public Info getInfoByName(String stationA, String stationB) {
        System.out.println("调用info了");

        //查询
        Info info = (Info) sessionFactory.openSession().createQuery("from Info where stationA =? and stationB = ?").setString(0,stationA).setString(1,stationB).list().get(0);
        return info;
    }
    @Override
    public JSONObject getInfoByName2(String stationA, String stationB) {
        System.out.println("调用info了");
        //查询
        Info info = (Info) sessionFactory.openSession().createQuery("from Info where stationA =? and stationB = ?").setString(0,stationA).setString(1,stationB).list().get(0);
        //存入jsonarray
        JSONObject jsonArray = new JSONObject();
        jsonArray.put("stationA",info.getStationA());
        jsonArray.put("stationB",info.getStationB());
        jsonArray.put("distance",info.getDistance());
        jsonArray.put("price",info.getTicketprice());

        return jsonArray;
    }
    @Override
    public Info getInfoByName3(String stationA, String stationB) {
        System.out.println("调用info了排序");
        Info info = (Info) sessionFactory.openSession().createQuery("from Info where stationA =? and stationB = ? order by distance").setString(0,stationA).setString(1,stationB).list().get(0);
        sessionFactory.openSession().close();
        return info;
    }
}
