package ch.bernmobil.vibe.dataaccesslayer.gtfs.entity;

import javax.persistence.*;

@Entity
public class TimeTableEntry {
    @Id
    private Long id;

    @OneToOne
    private Trip trip;

    @OneToOne
    @JoinColumn(name = "departure_stop_id")
    private Stop departureStop;

    @OneToOne
    @JoinColumn(name = "arrival_stop_id")
    private Stop arrivalStop;

    @OneToOne
    @JoinColumn(name = "departure_stop_time_id")
    private StopTime departureStopTime;

    @OneToOne
    @JoinColumn(name = "arrival_stop_time_id")
    private StopTime arrivalStopTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Stop getDepartureStop() {
        return departureStop;
    }

    public void setDepartureStop(Stop departureStop) {
        this.departureStop = departureStop;
    }

    public StopTime getDepartureStopTime() {
        return departureStopTime;
    }

    public void setDepartureStopTime(StopTime departureStopTime) {
        this.departureStopTime = departureStopTime;
    }

    public Stop getArrivalStop() {
        return arrivalStop;
    }

    public void setArrivalStop(Stop arrivalStop) {
        this.arrivalStop = arrivalStop;
    }

    public StopTime getArrivalStopTime() {
        return arrivalStopTime;
    }

    public void setArrivalStopTime(StopTime arrivalStopTime) {
        this.arrivalStopTime = arrivalStopTime;
    }
}
