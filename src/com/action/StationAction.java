package com.action;

import com.model.Info;
import com.service.InfoService;

import java.io.UnsupportedEncodingException;

public class StationAction {
    private String from;               //出发站
    private String to;//目的站
    private double distance;//距离
    private InfoService infoService;

    public void setTo(String to) {
        try {
            this.to = new String(to.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        try {
            this.from = new String(from.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public InfoService getInfoService() {
        return infoService;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
    public String update(){              //更新信息
        System.out.println(from+to+distance);
        Info info = new Info();
        info.setStationA(from);
        info.setStationB(to);
        info.setDistance(distance);
        info.setTicketprice(20.5);
        infoService.updateInfo(info);
        return "success";
    }
}
