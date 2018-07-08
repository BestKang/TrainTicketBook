package com.dao;

import com.model.Across;
import net.sf.json.JSONArray;

import java.util.Date;
import java.util.List;

public interface AcrossDao {
    public void delete(Across Across);                 //管理员删
    public void addAcross(Across Across);                   //管理员增
    public void updateAcross(Across Across);                //管理员改
    public Across getByStation(String station,String to,String trainId);             //用户、管理员查
    public double Path(String trainId);                                         //路径
    public List<Across> findAcross(String trainId);
    public JSONArray selectmiddlestation(String from, String to, Date statTime);         //查找中间站点
}
