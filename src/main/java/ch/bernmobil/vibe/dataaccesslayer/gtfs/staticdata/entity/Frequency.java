package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.*;
import java.time.LocalTime;

public class Frequency {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Trip trip;
    private LocalTime startTime;
    private LocalTime endTime;
    private int headwaySecs;
    @Enumerated(EnumType.ORDINAL)
    private ExactTimes exactTimes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getHeadwaySecs() {
        return headwaySecs;
    }

    public void setHeadwaySecs(int headwaySecs) {
        this.headwaySecs = headwaySecs;
    }

    public ExactTimes getExactTimes() {
        return exactTimes;
    }

    public void setExactTimes(ExactTimes exactTimes) {
        this.exactTimes = exactTimes;
    }

    private enum ExactTimes{
        NOT_EXACTLY_SCHEDULED, EXCATLY_SCHEDULED
    }
}
