package com.model;

import java.sql.Timestamp;

public class trainInfo {
    private String trainId;
    private String stationA;
    private String stationB;
    private Double distance;
    private Double ticketprice;
    private Timestamp arTime;
    private Timestamp deTime;

    public Double getDistance() {
        return distance;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public String getStationA() {
        return stationA;
    }

    public String getStationB() {
        return stationB;
    }

    public String getTrainId() {
        return trainId;
    }

    public Timestamp getArTime() {
        return arTime;
    }

    public Timestamp getDeTime() {
        return deTime;
    }

    public void setArTime(Timestamp arTime) {
        this.arTime = arTime;
    }

    public void setDeTime(Timestamp deTime) {
        this.deTime = deTime;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setStationA(String stationA) {
        this.stationA = stationA;
    }

    public void setStationB(String stationB) {
        this.stationB = stationB;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

}
