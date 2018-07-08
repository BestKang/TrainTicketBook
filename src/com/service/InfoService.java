package com.service;

import com.model.Info;
import net.sf.json.JSONObject;

public interface InfoService {
    public void delete(Info Info);                 //管理员删
    public void addInfo(Info Info);                   //管理员增
    public void updateInfo(Info Info);                //管理员改
    public Info getInfoByName(String stationA,String stationB);             //用户、管理员查
    public JSONObject getInfoByName2(String stationA, String stationB);     //测试方法
}
