package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.ManyToOne;

public class Trip {
    @ManyToOne
    private Route route;
    @ManyToOne
    private Service service;
    @ManyToOne
    private Trip trip;
    private String tripHeadsign;
    private String directionId;
}
