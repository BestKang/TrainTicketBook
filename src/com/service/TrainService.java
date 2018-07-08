package com.service;

import com.model.Train;
import net.sf.json.JSONArray;

import java.util.Date;

public interface TrainService {
    public void delete(Train train);                 //管理员删
    public void addTrain(Train train);                   //管理员增
    public void updateTrain(Train train);                //管理员改
    public Train getByTrainId(String trainId);             //用户、管理员查
    public JSONArray selectTrain(String from, String to, Date leavetime);          //用户搜索
    public String  selectTrain2(String from, String to, Date statTime);         //测试方法
}
