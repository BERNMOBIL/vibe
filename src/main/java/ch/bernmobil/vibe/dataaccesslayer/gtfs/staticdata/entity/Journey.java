package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Journey {

    @Id
    private Long id;
    private String headsign;
    private Timestamp update;

    @OneToOne
    @JoinColumn(name = "route")
    private Route route;

    @OneToOne(targetEntity = JourneyDisruption.class, mappedBy = "journey")
    private JourneyDisruption journeyDisruption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public JourneyDisruption getJourneyDisruption() {
        return journeyDisruption;
    }

    public void setJourneyDisruption(
        JourneyDisruption journeyDisruption) {
        this.journeyDisruption = journeyDisruption;
    }
}
