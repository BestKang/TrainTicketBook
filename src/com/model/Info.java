package com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(InfoPK.class)
public class Info implements Serializable{
    private String stationA;                            //站点
    private String stationB;                              //进过的站点
    private Double distance;                    //距离
    private Double ticketprice;                             //价格

    @Id
    @Column(name = "stationA")
    public String getStationA() {
        return stationA;
    }

    public void setStationA(String stationA) {
        this.stationA = stationA;
    }

    @Id
    @Column(name = "stationB")
    public String getStationB() {
        return stationB;
    }

    public void setStationB(String stationB) {
        this.stationB = stationB;
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
    @Column(name = "ticketprice")
    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info = (Info) o;

        if (stationA != null ? !stationA.equals(info.stationA) : info.stationA != null) return false;
        if (stationB != null ? !stationB.equals(info.stationB) : info.stationB != null) return false;
        if (distance != null ? !distance.equals(info.distance) : info.distance != null) return false;
        if (ticketprice != null ? !ticketprice.equals(info.ticketprice) : info.ticketprice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stationA != null ? stationA.hashCode() : 0;
        result = 31 * result + (stationB != null ? stationB.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (ticketprice != null ? ticketprice.hashCode() : 0);
        return result;
    }
}
