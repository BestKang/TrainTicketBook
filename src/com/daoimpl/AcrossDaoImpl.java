package com.daoimpl;

import com.dao.AcrossDao;
import com.model.Across;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcrossDaoImpl implements AcrossDao {
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
    public void addAcross(Across across) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(across);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Across across) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(across);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateAcross(Across across) {
        Session session = sessionFactory.openSession();                                 //获取session
        Transaction transaction = session.beginTransaction();                   //定义 开启事务
        session.update(across);
        transaction.commit();                                                   //提交
        session.close();
    }
    @Transactional
    @Override
    public Across getByStation(String from,String to,String trainId) {
        System.out.println("正调用AcrossDaoImpl");
        Session session = sessionFactory.openSession();
        //
        //根据出发地和车次号
        String hql="from Across where station=? and trainId =?";

        //目的地和车次号
        String hql2="from Across where nextStation=? and trainId =?";


        //
        String hql3="SELECT SUM(distance) from Across WHERE trainId =? AND arTime >= (SELECT arTime FROM Across WHERE trainId =? AND station =?)"+
                "AND  arTime <=(SELECT arTime FROM Across WHERE trainId =? AND nextStation =?)";
        try {
            Across list = (Across)session.createQuery(hql).setString(0,from).setString(1,trainId).list().get(0);    //查询返回对象  同时匹配参数
            System.out.println("AcrossDaoImpl第一个查询完成");
            Across list2 = (Across)session.createQuery(hql2).setString(0,to).setString(1,trainId).list().get(0);
             System.out.println("AcrossDaoImpl第二个查询完成");
            //
            //获取距离
            double distance = (double)session.createQuery(hql3).setString(0,trainId)
                    .setString(1,trainId).setString(2,from).setString(3,trainId).setString(4,to).list().get(0);
            System.out.println("AcrossDaoImpl第三个查询完成");
            Across across = new Across();
            across.setTrainId(trainId);
            across.setStation(from);
            across.setNextStation(to);
            across.setDistance(distance);
            across.setArTime(list.getArTime());
            across.setDeTime(list2.getDeTime());
            session.close();
            System.out.println("AcrossDaoImpl完成");
            session.close();
            return across;
        }catch (Exception e){
            return null;
        }

    }
    public JSONArray selectmiddlestation(String from, String to, Date statTime){
        JSONArray trainArray = new JSONArray();
        Session session = sessionFactory.openSession();
        //找到从出发地到目的地的车次号
        //依据时间和出发地
        String hql="from Across where station=? and DATE_FORMAT(arTime,'%Y-%m-%d') =?";
        String hql2="from Across where nextStation=?";
        List<Across> list = (List<Across>)session.createQuery(hql).setString(0,from).setDate(1,statTime).list();//找出所有经过出发地的车次
        List<Across> list2 = (List<Across>)session.createQuery(hql2).setString(0,to).list();                    //找出所有经过目的地的车次
        //System.out.println("hql语句"+hql.toString());
       // System.out.println("hql2语句"+hql2.toString());
        List mylist= new ArrayList();
        int index=0;

        for (int i=0;i<list.size();i++){
            //System.out.println("测试输出list中的数据"+list.get(i).getTrainId());
            String hql3="from Across where trainId = ?";
            List<Across> list3 = (List<Across>)session.createQuery(hql3).setString(0,list.get(i).getTrainId()).list();        //tu途径站点的所有名称
           // System.out.println("hql3语句"+hql3.toString());
            for (int j=0;j<list3.size();j++){
                //System.out.println("测试输出list3中的数据"+list3.get(j).getTrainId());
                for(int k=0;k<list2.size();k++){
                    String hql4="from Across where trainId = ? ";
                    List<Across> list4 = (List<Across>)session.createQuery(hql4).setString(0,list2.get(k).getTrainId()).list();   //经过目的站的车次的所有记录
                    for (int m=0;m<list4.size();m++){
                        System.out.println("list3："+list3.get(j).getNextStation());
                        System.out.println("list4："+list4.get(m).getTrainId());
                        System.out.println("list4："+list4.get(m).getStation());
                        if (list3.get(j).getNextStation().equals(list4.get(m).getStation())){                           //判断
                            Across across = this.getByStation(from,list3.get(j).getNextStation(),list3.get(j).getTrainId());
                            Across across1 = this.getByStation(list4.get(m).getStation(),to,list4.get(k).getTrainId());
                            System.out.println("去的车"+list3.get(j).getTrainId());
                            System.out.println("转的车"+list4.get(k).getTrainId());
                                JSONObject trainJObj = new JSONObject();
                                trainJObj.put("id", across.getTrainId());////车次id                        //存入json
                                trainJObj.put("from",across.getStation());
                                trainJObj.put("to",across.getNextStation());
                                //trainJObj.put("price",across.get.getTicketprice());
                                SimpleDateFormat sdf =   new SimpleDateFormat( "MM-dd HH:mm" );         //时间格式化
                                System.out.println("测试输出arTime"+across.getArTime());
                                String str = sdf.format(across.getArTime());
                                trainJObj.put("arTime",str);
                                String str2 = sdf.format(across.getDeTime());
                                trainJObj.put("deTime",str2);
                                trainJObj.put("distance",across.getDistance());
                                trainArray.add(index,trainJObj);


                                JSONObject trainJObj2 = new JSONObject();
                                trainJObj2.put("id", across1.getTrainId());////车次id                        //存入json
                                trainJObj2.put("from",across1.getStation());
                                trainJObj2.put("to",across1.getNextStation());
                                System.out.println("测试输出arTime"+across.getArTime());
                                String str3 = sdf.format(across1.getArTime());
                                trainJObj2.put("arTime",str3);
                                String str4 = sdf.format(across1.getDeTime());
                                trainJObj2.put("deTime",str4);
                                trainJObj2.put("distance",across1.getDistance());
                                trainArray.add(index+1,trainJObj2);
                                index++;

                    }

                    }
                }
            }
        }

        return trainArray;

    }

    public double Path(String trainId)
    {
        Session session = sessionFactory.openSession();
        List<Across> across = (List<Across>)session.createQuery(" from Across where trainId = ?").setParameter(0,trainId).list();
        double path = 0;
        for (int i=0;i<across.size();i++)
        {
            path+=across.get(i).getDistance();
        }
        session.close();
        return path;
    }

    public List<Across> findAcross(String trainId)
    {
        Session session = sessionFactory.openSession();
        List<Across> across = (List<Across>)session.createQuery("from Across where trainId = ?").setParameter(0,trainId).list();
        session.close();
        return across;
    }
}
