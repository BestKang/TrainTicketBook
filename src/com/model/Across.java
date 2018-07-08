package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@IdClass(AcrossPK.class)
public class Across implements Serializable{
    private String station;                                 //站点
    private String trainId;                                 //车次号
    private String nextStation;                             //站点的下一站
    private Double distance;                                    //距离
    private Timestamp arTime;                                   //火车到达时间
    private Timestamp deTime;                               //火车离开时间

    @Id                                                         //主键注解
    @Column(name = "station")                                   //行注解
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Id
    @Column(name = "trainId")
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "nextStation")
    public String getNextStation() {
        return nextStation;
    }

    public void setNextStation(String nextStation) {
        this.nextStation = nextStation;
    }

    @Basic
    @Column(name = "distance")
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
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
    @Column(name = "deTime")
    public Timestamp getDeTime() {
        return deTime;
    }

    public void setDeTime(Timestamp deTime) {
        this.deTime = deTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Across across = (Across) o;

        if (station != null ? !station.equals(across.station) : across.station != null) return false;
        if (trainId != null ? !trainId.equals(across.trainId) : across.trainId != null) return false;
        if (nextStation != null ? !nextStation.equals(across.nextStation) : across.nextStation != null) return false;
        if (distance != null ? !distance.equals(across.distance) : across.distance != null) return false;
        if (arTime != null ? !arTime.equals(across.arTime) : across.arTime != null) return false;
        if (deTime != null ? !deTime.equals(across.deTime) : across.deTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = station != null ? station.hashCode() : 0;
        result = 31 * result + (trainId != null ? trainId.hashCode() : 0);
        result = 31 * result + (nextStation != null ? nextStation.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (arTime != null ? arTime.hashCode() : 0);
        result = 31 * result + (deTime != null ? deTime.hashCode() : 0);
        return result;
    }
}
