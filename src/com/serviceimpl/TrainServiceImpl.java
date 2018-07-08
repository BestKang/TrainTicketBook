package com.serviceimpl;

import com.dao.TrainDao;
import com.model.Train;
import com.service.TrainService;
import net.sf.json.JSONArray;

import java.util.Date;

public class TrainServiceImpl implements TrainService {
    private TrainDao trainDao;

    public void setTrainDao(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    public TrainDao getTrainDao() {
        return trainDao;
    }

    @Override
    public void addTrain(Train train) {
        trainDao.addTrain(train);
    }

    @Override
    public void delete(Train train) {
        trainDao.delete(train);
    }

    @Override
    public void updateTrain(Train train) {
        trainDao.updateTrain(train);
    }

    @Override
    public Train getByTrainId(String trainId) {
        return trainDao.getByTrainId(trainId);
    }

    @Override
    public JSONArray selectTrain(String from, String to, Date leavetime) {
        return trainDao.selectTrain(from,to,leavetime);
    }

    @Override
    public String selectTrain2(String from, String to, Date statTime) {
        return trainDao.selectTrain2(from,to,statTime);
    }
}
