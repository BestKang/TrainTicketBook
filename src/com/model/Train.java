package com.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Train {
    private String trainId;
    private String startStation;
    private String finalStation;
    private Timestamp statTime;
    private Timestamp arTime;
    private String ticketInfo;
    private String stopStaion;                                          //停靠站点

    @Id
    @Column(name = "trainId")
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "startStation")
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    @Basic
    @Column(name = "finalStation")
    public String getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(String finalStation) {
        this.finalStation = finalStation;
    }

    @Basic
    @Column(name = "statTime")
    public Timestamp getStatTime() {
        return statTime;
    }

    public void setStatTime(Timestamp statTime) {
        this.statTime = statTime;
    }

    @Basic
    @Column(name = "arTime")
    public Timestamp getArTime() {
        return arTime;
    }

    public void setArTime(Timestamp arTime) {
        this.arTime = arTime;
    }

    @Basic
    @Column(name = "ticketInfo")
    public String getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(String ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    @Basic
    @Column(name = "stopStaion")
    public String getStopStaion() {
        return stopStaion;
    }

    public void setStopStaion(String stopStaion) {
        this.stopStaion = stopStaion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (trainId != null ? !trainId.equals(train.trainId) : train.trainId != null) return false;
        if (startStation != null ? !startStation.equals(train.startStation) : train.startStation != null) return false;
        if (finalStation != null ? !finalStation.equals(train.finalStation) : train.finalStation != null) return false;
        if (statTime != null ? !statTime.equals(train.statTime) : train.statTime != null) return false;
        if (arTime != null ? !arTime.equals(train.arTime) : train.arTime != null) return false;
        if (ticketInfo != null ? !ticketInfo.equals(train.ticketInfo) : train.ticketInfo != null) return false;
        if (stopStaion != null ? !stopStaion.equals(train.stopStaion) : train.stopStaion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainId != null ? trainId.hashCode() : 0;
        result = 31 * result + (startStation != null ? startStation.hashCode() : 0);
        result = 31 * result + (finalStation != null ? finalStation.hashCode() : 0);
        result = 31 * result + (statTime != null ? statTime.hashCode() : 0);
        result = 31 * result + (arTime != null ? arTime.hashCode() : 0);
        result = 31 * result + (ticketInfo != null ? ticketInfo.hashCode() : 0);
        result = 31 * result + (stopStaion != null ? stopStaion.hashCode() : 0);
        return result;
    }
}
