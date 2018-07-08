package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.serviceimpl.AcrossServiceImpl;
import com.serviceimpl.TrainServiceImpl;
import net.sf.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;

public class SelectMiddleTrainAction {
    private String from;//出发站
    private String to;//目的站
    private Date leavetime;//出发时间
    private TrainServiceImpl trainSerive;
    private AcrossServiceImpl acrossService;

    public void setAcrossService(AcrossServiceImpl acrossService) {
        this.acrossService = acrossService;
    }

    public AcrossServiceImpl getAcrossService() {
        return acrossService;
    }

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

    public String Searchmiddle(){                                                     //查询中转  from to leavetime
        System.out.println(from+to+leavetime);
        JSONArray jsonArray = acrossService.selectmiddlestation(from,to,leavetime);

        if (jsonArray!=null){

          Map session = ActionContext.getContext().getSession();
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
