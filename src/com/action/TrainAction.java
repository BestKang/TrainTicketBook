package com.action;

import com.model.Train;
import com.serviceimpl.TrainServiceImpl;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

public class TrainAction {
    private String from;                                                //出发站
    private String to;                                                      //目的站
    private String trainId;                                                 //车次号
    private Timestamp deTime;                                               //出发时间
    private Timestamp arTime;                                               //到达时间
    private String price;                                                   //价格
    private String stopstation;                                         //停靠站点
    private TrainServiceImpl trainService;
    public void setFrom(String from) {
        try {
            this.from = new String(from.getBytes("iso-8859-1"),"utf-8");//防止乱码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        try {
            this.to = new String(to.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setTrainService(TrainServiceImpl trainService) {
        this.trainService = trainService;
    }

    public TrainServiceImpl getTrainService() {
        return trainService;
    }

    public void setTrainId(String trainId) {
        try {
            this.trainId = new String(trainId.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setDeTime(Timestamp deTime) {
        this.deTime = deTime;
    }

    public void setArTime(Timestamp arTime) {
        this.arTime = arTime;
    }

    public Timestamp getDeTime() {
        return deTime;
    }

    public Timestamp getArTime() {
        return arTime;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getStopstation() {
        return stopstation;
    }

    public void setStopstation(String stopstation) {
        try {
            this.stopstation = new String(stopstation.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setPrice(String price) {
        try {
            this.price = new String(price.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getPrice() {
        return price;
    }
    public String  update(){                                           //更新信息
        Train train = new Train();
        train.setTrainId(trainId);
        train.setStartStation(from);
        train.setFinalStation(to);
        train.setStatTime(deTime);
        train.setArTime(arTime);
        train.setTicketInfo(price);
        train.setStopStaion(stopstation);
        trainService.updateTrain(train);
        return "success";
    }
}
