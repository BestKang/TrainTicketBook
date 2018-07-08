package com.action;

import com.model.Train;
import com.opensymphony.xwork2.ActionContext;
import com.serviceimpl.TrainServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;


public class SearchTrainAction {
    private String from;//出发站
    private String to;//目的站
    private Date leavetime;//出发时间
    private TrainServiceImpl trainSerive;

    public void setTrainSerive(TrainServiceImpl trainSerive) {
        this.trainSerive = trainSerive;
    }

    public TrainServiceImpl getTrainSerive() {
        return trainSerive;
    }

    public void setFrom(String from) {
        try {
            this.from = new String(from.getBytes("iso-8859-1"),"utf-8");    //获取jsp传来的中文  防止乱码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        try {
            this.to =  new String(to.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public String getTo() {
        return to;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public String Search(){                                                     //查询车次  from to leavetime
        System.out.println(from+to+leavetime);
        JSONArray jsonArray = trainSerive.selectTrain(from,to,leavetime);
        //String st= trainSerive.selectTrain2(from,to,leavetime);
        //System.out.println(jsonArray);
        if (jsonArray!=null){
          /*  Map session = ActionContext.getContext().getSession();
            Train train =  new Train();
            for (int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //session.put(i,jsonObject.get("id").toString());
                train.setTrainId(jsonObject.get("id").toString());
                JSONObject sdd = jsonObject.getJSONObject("Time");
                train.setArTime((Timestamp) sdd.get("arTime"));
                train.setStatTime((Timestamp) sdd.get("deTime"));
                train.setStartStation(jsonObject.getJSONObject("DistanceAndPrice").get("stationA").toString());
                train.setFinalStation(jsonObject.getJSONObject("DistanceAndPrice").get("stationB").toString());
                session.put(i,train);
            }

*/          Map session = ActionContext.getContext().getSession();
            for (int i= 0 ;i<jsonArray.size();i++){

                session.put(i,jsonArray.get(i));                      //将查询的数据放入session
            }
            for (int i = 0;i<jsonArray.size();i++)
            {
                System.out.println("来自session"+session.get(i));
            }

            //System.out.println(session.get("traininfo"));
            Map request = (Map) ActionContext.getContext().get("request");       //request
            request.put("list", jsonArray);
            System.out.println("request"+request.get("list"));
            return "success";
        }
        else return "fail";

    }
}
