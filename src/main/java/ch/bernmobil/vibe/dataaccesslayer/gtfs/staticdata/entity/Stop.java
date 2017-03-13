package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.net.URL;
import java.util.TimeZone;

@Entity
public class Stop {
    @Id
    private long stopId;
    private String stopCode;
    private String stopName;
    private String stopDescription;
    private double stopLatitude;
    private double stopLongitude;
    @OneToOne
    private FareRule zone;
    private URL stopUrl;
    private String locationType;
    private String parentStation;
    private TimeZone stopTimezone;
    private WheelchairBoarding wheelchairBoarding;

    public enum WheelchairBoarding {
        NO_INFORMATION, SOME_ACCESSIBLE_VEHICLES, NOT_ACCESSIBLE
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public double getStopLatitude() {
        return stopLatitude;
    }

    public void setStopLatitude(double stopLatitude) {
        this.stopLatitude = stopLatitude;
    }

    public double getStopLongitude() {
        return stopLongitude;
    }

    public void setStopLongitude(double stopLongitude) {
        this.stopLongitude = stopLongitude;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    public void setParentStation(String parentStation) {
        this.parentStation = parentStation;
    }

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopDescription() {
        return stopDescription;
    }

    public void setStopDescription(String stopDescription) {
        this.stopDescription = stopDescription;
    }

    public FareRule getZone() {
        return zone;
    }

    public void setZone(FareRule zone) {
        this.zone = zone;
    }

    public URL getStopUrl() {
        return stopUrl;
    }

    public void setStopUrl(URL stopUrl) {
        this.stopUrl = stopUrl;
    }

    public TimeZone getStopTimezone() {
        return stopTimezone;
    }

    public void setStopTimezone(TimeZone stopTimezone) {
        this.stopTimezone = stopTimezone;
    }

    public WheelchairBoarding getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    public void setWheelchairBoarding(WheelchairBoarding wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
    }

}
