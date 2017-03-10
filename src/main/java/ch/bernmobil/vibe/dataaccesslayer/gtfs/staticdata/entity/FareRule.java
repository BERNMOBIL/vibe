package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class FareRule {
    @Id
    private long id;
    @ManyToOne
    private Route route;
    @OneToOne
    private Stop origin;
    @OneToOne
    private Stop destination;
    @OneToOne
    private Stop contains;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Stop getOrigin() {
        return origin;
    }

    public void setOrigin(Stop origin) {
        this.origin = origin;
    }

    public Stop getDestination() {
        return destination;
    }

    public void setDestination(Stop destination) {
        this.destination = destination;
    }

    public Stop getContains() {
        return contains;
    }

    public void setContains(Stop contains) {
        this.contains = contains;
    }
}
