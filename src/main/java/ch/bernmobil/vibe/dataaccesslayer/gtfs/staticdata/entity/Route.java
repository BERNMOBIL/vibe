package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.*;
import java.net.URL;

@Entity
public class Route {
    @Id
    private String routeId;
    @ManyToOne
    private Agency agency;
    private String routeShortName;
    private String routeLongName;
    private String routeDescription;
    @Enumerated(EnumType.ORDINAL)
    private RouteType routeType;
    private URL routeUrl;
    private String routeColor;
    private String routeTextColor;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public enum RouteType {
        TRAM, SUBWAY, RAIL, BUS, FERRY, CABLE_CAR, GONDOLA, FUNICULAR
    }
}