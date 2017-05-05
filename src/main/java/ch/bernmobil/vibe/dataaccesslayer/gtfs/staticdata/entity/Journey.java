package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Journey {

    @Id
    private UUID id;
    private String headsign;

    @OneToOne
    @JoinColumn(name = "route")
    private Route route;

    @OneToOne(targetEntity = JourneyDisruption.class, mappedBy = "journey")
    private JourneyDisruption journeyDisruption;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
