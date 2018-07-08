package com.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AcrossPK implements Serializable {
    private String station;
    private String trainId;

    @Column(name = "station")
    @Id
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Column(name = "trainId")
    @Id
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcrossPK acrossPK = (AcrossPK) o;

        if (station != null ? !station.equals(acrossPK.station) : acrossPK.station != null) return false;
        if (trainId != null ? !trainId.equals(acrossPK.trainId) : acrossPK.trainId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = station != null ? station.hashCode() : 0;
        result = 31 * result + (trainId != null ? trainId.hashCode() : 0);
        return result;
    }
}
