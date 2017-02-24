package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Route {
    @Id
    private String routeId;
    @ManyToOne
    private Agency agency;
    private String routeShortName;
    private String routeLongName;
    private int routeType;
}