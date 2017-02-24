package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.Id;

public class Stop {
    @Id
    private long stopId;
    private String stopName;
    private double stopLatitude;
    private double stopLongitude;
    private String locationType;
    private String parentStation;

}
