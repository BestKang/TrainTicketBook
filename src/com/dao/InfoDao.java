package com.dao;

import com.model.Info;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface InfoDao {
    public void delete(Info Info);                 //管理员删
    public void addInfo(Info Info);                   //管理员增
    public void updateInfo(Info Info);                //管理员改
    public Info getInfoByName(String stationA,String stationB);             //用户、管理员查
    public JSONObject getInfoByName2(String stationA, String stationB);     //测试方法
    public Info getInfoByName3(String stationA, String stationB);                   //查询  根据出发地和目的地
}
