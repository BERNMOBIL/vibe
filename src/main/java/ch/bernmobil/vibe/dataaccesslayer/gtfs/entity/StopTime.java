package ch.bernmobil.vibe.dataaccesslayer.gtfs.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class StopTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Trip trip;
    private String arrivalTime;
    private String departureTime;
    @ManyToOne
    private Stop stop;
    private int stopSequence;
    @Enumerated(EnumType.ORDINAL)
    private PickupType pickupType;
    @Enumerated(EnumType.ORDINAL)
    private DropOffType dropOffType;

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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public int getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    public PickupType getPickupType() {
        return pickupType;
    }

    public void setPickupType(PickupType pickupType) {
        this.pickupType = pickupType;
    }

    public DropOffType getDropOffType() {
        return dropOffType;
    }

    public void setDropOffType(DropOffType dropOffType) {
        this.dropOffType = dropOffType;
    }

    public enum PickupType {
        REGULARLY_SCHEDULED_PICKUP, NO_PICKUP_AVAILABLE, PHONE_AGENCY_REQUEST_PICKUP, COORDINATE_WITH_DRIVER
    }

    public enum DropOffType {
        REGULARLY_SCHEDULED_DROP_OFF, NO_DROP_OFF_AVAILABLE, PHONE_AGENCY_REQUEST_DROP_OFF, COORDINATE_WITH_DRIVER
    }
}
