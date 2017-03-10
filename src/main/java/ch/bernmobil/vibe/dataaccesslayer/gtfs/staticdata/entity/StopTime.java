package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class StopTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Trip trip;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    @ManyToOne
    private Stop stop;
    private int stopSequence;
    private String stopHeadsign;
    @Enumerated(EnumType.ORDINAL)
    private PickupType pickupType;
    @Enumerated(EnumType.ORDINAL)
    private DropOffType dropOffType;
    private int shapeDistTraveled;
    private Timepoint timepoint;

    /**
     * Indicates if the specified arrival and departure times for a stop are strictly adhered to by the transit vehicle.
     * If empty, times are condsidered as exact.
     */
    public enum Timepoint {
        APPROXIMATE, EXACT
    }

    public enum PickupType {
        REGULARLY_SCHEDULED_PICKUP, NO_PICKUP_AVAILABLE, PHONE_AGENCY_REQUEST_PICKUP, COORDINATE_WITH_DRIVER
    }

    public enum DropOffType {
        REGULARLY_SCHEDULED_DROP_OFF, NO_DROP_OFF_AVAILABLE, PHONE_AGENCY_REQUEST_DROP_OFF, COORDINATE_WITH_DRIVER
    }

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

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
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

    public int getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(int shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }

    public void setStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
    }

    public Timepoint getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(Timepoint timepoint) {
        this.timepoint = timepoint;
    }
}
