package com.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class InfoPK implements Serializable {
    private String stationA;
    private String stationB;

    @Column(name = "stationA")
    @Id
    public String getStationA() {
        return stationA;
    }

    public void setStationA(String stationA) {
        this.stationA = stationA;
    }

    @Column(name = "stationB")
    @Id
    public String getStationB() {
        return stationB;
    }

    public void setStationB(String stationB) {
        this.stationB = stationB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoPK infoPK = (InfoPK) o;

        if (stationA != null ? !stationA.equals(infoPK.stationA) : infoPK.stationA != null) return false;
        if (stationB != null ? !stationB.equals(infoPK.stationB) : infoPK.stationB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stationA != null ? stationA.hashCode() : 0;
        result = 31 * result + (stationB != null ? stationB.hashCode() : 0);
        return result;
    }
}
