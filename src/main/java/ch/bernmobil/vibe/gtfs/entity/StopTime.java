package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.ManyToOne;

public class StopTime {
    @ManyToOne
    private Trip trip;
    private String arrivalTime;
    private String departureTime;
    @ManyToOne
    private Stop stop;
    private int stopSequence;
    private int pickupType;
    private int dropOffType;
}
