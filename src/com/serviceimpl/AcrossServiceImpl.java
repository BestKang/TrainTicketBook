package com.serviceimpl;

import com.dao.AcrossDao;

import com.model.Across;
import com.service.AcrossService;
import net.sf.json.JSONArray;

import java.util.Date;
import java.util.List;

public class AcrossServiceImpl implements AcrossService {
    private AcrossDao acrossDao;

    @Override
    public AcrossDao getAcrossDao() {
        return acrossDao;
    }

    @Override
    public void setAcrossDao(AcrossDao acrossDao) {
        this.acrossDao = acrossDao;
    }

    @Override
    public void addAcross(Across across) {
        acrossDao.addAcross(across);
    }

    @Override
    public void delete(Across across) {
        acrossDao.delete(across);
    }

    @Override
    public void updateAcross(Across across) {
        acrossDao.updateAcross(across);
    }

    @Override
    public Across getByStation(String station, String to, String trainId) {
        return acrossDao.getByStation(station,to,trainId);
    }
    public double Path(String trainId){
        return this.acrossDao.Path(trainId);
    }
    public List<Across> findAcross(String trainId){
        return this.acrossDao.findAcross(trainId);
    }
    public JSONArray selectmiddlestation(String from, String to, Date statTime){
       return acrossDao.selectmiddlestation(from,to,statTime);

    }
}
