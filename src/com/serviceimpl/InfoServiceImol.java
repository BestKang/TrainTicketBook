package com.serviceimpl;

import com.dao.InfoDao;
import com.model.Info;
import com.service.InfoService;
import net.sf.json.JSONObject;

public class InfoServiceImol implements InfoService {
    private InfoDao infoDao;

    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }
    public InfoDao getInfoDao() {
        return infoDao;
    }
    @Override
    public Info getInfoByName(String stationA, String stationB) {
        return null;
    }

    @Override
    public void addInfo(Info Info) {
        infoDao.addInfo(Info);
    }

    @Override
    public void delete(Info Info) {
        infoDao.delete(Info);
    }

    @Override
    public void updateInfo(Info Info) {
        infoDao.updateInfo(Info);
    }



    @Override
    public JSONObject getInfoByName2(String stationA, String stationB) {
        return infoDao.getInfoByName2(stationA,stationB);
    }
}
