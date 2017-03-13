package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trip {
    @Id
    private String id;
    @ManyToOne
    private Route route;
    @OneToMany
    private List<CalendarDate> calendarDate;
    private String tripHeadsign;
    private String tripShortName;
    @Enumerated(EnumType.ORDINAL)
    private Direction directionId;
    private String blockId;
    @OneToOne
    private Shape shape;

    public enum WheelchairAccessible {
        NO_INFORMATION, AT_LEAST_ONE_WHEELCHAIR, NO_WHEELCHAIR
    }

    public enum BikesAllowed {
        NO_INFORMATION, AT_LEAST_ONE_BIKE, NO_BIKE
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<CalendarDate> getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(List<CalendarDate> calendarDate) {
        this.calendarDate = calendarDate;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public Direction getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Direction directionId) {
        this.directionId = directionId;
    }

    public enum Direction {
        OUTBOUND, INBOUND
    }
}
